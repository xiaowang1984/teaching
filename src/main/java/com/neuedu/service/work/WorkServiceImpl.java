package com.neuedu.service.work;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.neuedu.dao.WorkMapper;
import com.neuedu.pojo.*;
import com.neuedu.service.student.IstudentService;
import com.neuedu.service.workCommit.IworkCommitService;
import com.neuedu.service.workdetails.IworkDetailsService;
import com.neuedu.service.workstudent.IworkstudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Service
public class WorkServiceImpl implements IworkService{
    @Resource
    WorkMapper workMapper;
    @Resource
    IworkCommitService workCommitService;
    @Resource
    IstudentService studentService;
    @Resource
    IworkDetailsService workDetailsService;
    @Resource
    IworkstudentService workstudentService;
    @Override
    public List<Work> list(Work work,Date dat) {
        WorkExample workExample = new WorkExample();
        workExample.setOrderByClause("id desc");
        WorkExample.Criteria criteria = workExample.createCriteria();
        if(StringUtils.isNotBlank(work.getName()))
            criteria.andNameLike("%"+work.getName()+"%");
        if(StringUtils.isNotBlank(work.getExtend()))
            criteria.andNameLike("%"+work.getExtend()+"%");
        if(dat!=null)
            criteria.andStartDatLessThanOrEqualTo(dat).andEndDatGreaterThanOrEqualTo(dat);
        if(work.getIsDel()!=null)
            criteria.andIsDelEqualTo(work.getIsDel());
        if(work.getGid()!=null)
        criteria.andGidEqualTo(work.getGid());
        if(work.getWithPage()==1)
            PageHelper.startPage(work.getPageNo(), work.getPageSize());
        return workMapper.selectByExampleWithBLOBs(workExample);
    }

    @Override
    public int add(Work work) {
        return workMapper.insertSelective(work);
    }

    @Override
    public int update(Work work) {
        return workMapper.updateByPrimaryKeySelective(work);
    }

    @Override
    public Work getWorkById(int id) {
        return workMapper.selectByPrimaryKey(id);
    }

    @Override
    public Work getWorkByName(String name,int gId) {
        WorkExample workExample = new WorkExample();
        workExample.createCriteria().andNameEqualTo(name).andGidEqualTo(gId);
        List<Work> work=workMapper.selectByExampleWithBLOBs(workExample);
        if(work.size()==1)
            return work.get(0);
        return null;
    }

    @Override
    @Transactional
    public void gitLoad(Map<String, String> parameterMap) throws ParseException {
        Map<String,String> repository = JSONObject.parseObject(parameterMap.get("repository"), Map.class);
            List<Map<String,String>> list = JSONObject.parseObject(parameterMap.get("commits"), List.class);
            Map<String,String> pusher = JSONObject.parseObject(parameterMap.get("pusher"), Map.class);
            String name=repository.get("name");
            String commitid=list.get(0).get("id");
            String user=pusher.get("name");
            Student student = studentService.getStudentByGit(user);
            if(student != null){
                Work work = getWorkByName(name, student.getgId());
                if(work != null){
                    RestTemplate template = new RestTemplate();
                    String url="https://api.github.com/repos/"+user+"/"+name+"/commits/"+commitid;
                    String str = template.getForObject(url, String.class);
                    Map<String,Object> map = JSONObject.parseObject(str, Map.class);
                    Map<String,Integer> stats=JSONObject.parseObject(map.get("stats").toString(), Map.class);
                    Map<String,Object> commit=JSONObject.parseObject(map.get("commit").toString(), Map.class);
                    Map<String,String> author= JSONObject.parseObject(commit.get("author").toString(), Map.class);
                    List<Map<String,Object>> files = (List<Map<String, Object>>) map.get("files");
                    Workcommit workcommit = new Workcommit();
                    workcommit.setAdditions(stats.get("additions"));
                    workcommit.setDeletions(stats.get("deletions"));
                    workcommit.setMessage(commit.get("message").toString());
                    String dat=author.get("date");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                    Date dateTime =sdf.parse(dat);
                    workcommit.setDat(dateTime);
                    workcommit.setTim(dateTime);
                    workcommit.setsId(student.getId());
                    workcommit.setwId(work.getId());
                    workCommitService.add(workcommit);
                    for(Map<String,Object> file : files){
                        Workdetails workdetails = new Workdetails();
                        workdetails.setcId(workcommit.getId());
                        workdetails.setFile(file.get("filename").toString());
                        workdetails.setStatus(file.get("status").toString());
                        workdetails.setAdditions(Integer.parseInt(file.get("additions").toString()));
                        workdetails.setDeletions(Integer.parseInt(file.get("deletions").toString()));
                        workDetailsService.add(workdetails);
                    }
                }
        }
    }

    @Override
    public List<Work> getListByGid(int gId) {
        WorkExample workExample = new WorkExample();
        workExample.createCriteria().andGidEqualTo(gId).andIsDelEqualTo(1);
        return workMapper.selectByExampleWithBLOBs(workExample);
    }

    @Override
    public List<Work> getListOne(int gId, int sId) {
        List<Work> list = getListByGid(gId);
        for (Work work : list){
            List<Workstudent> workstudents = workstudentService.list(work.getId(), sId);
            work.setWorkstudents(workstudents);
        }
        return list;
    }
}
