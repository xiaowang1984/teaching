package com.neuedu.service.employment;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.dao.EmploymentMapper;
import com.neuedu.message.Message;
import com.neuedu.pojo.Company;
import com.neuedu.pojo.Employment;
import com.neuedu.pojo.EmploymentExample;
import com.neuedu.pojo.EmploymentParams;
import com.neuedu.service.company.IcompanyService;
import com.neuedu.utils.pojoTovo.PoToVoUtil;
import com.neuedu.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class EmploymentServiceImpl implements IemploymentService {
    @Resource
    EmploymentMapper employmentMapper;
    @Resource
    IcompanyService companyService;

    @Override
    public int add(Employment employment) {
        /*if (companyService.count(employment.getcName()) == 0) {
            Company company = new Company();
            company.setName(employment.getcName());
            companyService.add(company);
        }*/
        return employmentMapper.insertSelective(employment);
    }

    @Override
    public List<Employment> list(Integer sId) {
        EmploymentExample employmentExample = new EmploymentExample();
        employmentExample.createCriteria().andSIdEqualTo(sId).andIsDelEqualTo(1);
        return employmentMapper.selectByExample(employmentExample);
    }

    @Override
    public Employment getEmploymentById(Integer id) {
        return employmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Employment employment) {
        return employmentMapper.updateByPrimaryKeySelective(employment);
    }

    @Override
    public int check(Employment employment) {
        int result = 0;
        employment.setChoice(1);
        result += employmentMapper.updateByPrimaryKeySelective(employment);
        Employment query = getEmploymentById(employment.getId());
        Employment other = new Employment();
        other.setChoice(0);
        EmploymentExample employmentExample = new EmploymentExample();
        employmentExample.createCriteria().andSIdEqualTo(query.getsId()).andIdNotEqualTo(employment.getId());
        result += employmentMapper.updateByExampleSelective(other, employmentExample);
        return result;
    }

    @Override
    public List<Map<String, Object>> reportByGrade(EmploymentParams params) {
        return employmentMapper.reportByGrade(params);
    }

    @Override
    public List<Map<String, Object>> reportByStudent(int sId) {
        return employmentMapper.reportByStudent(sId);
    }

    /*==================zhangxin================*/
    //获取就业信息数据
    @Override
    public ServerResponse getJoblist(Integer pageNum, Integer pageSize) {
        //创建高可用对象
        ServerResponse sr = null;

        //获取每家公司就业数据，不包含offer数据
        PageHelper.startPage(pageNum, pageSize);
        List<JobListVOCompany> li = employmentMapper.selectAllJobByCompany();

        //判断就业数据是否为空
        if (li == null || li.size() == 0) {
            //如果集合为空，说明不存在数据
            sr = ServerResponse.createServerResponseByError(Const.JobListEnum.MSG_NULL.getCode(), Const.JobListEnum.MSG_NULL.getDesc());
            return sr;
        } else {
            for (JobListVOCompany jlvc : li) {
                //获取每家公司offer人数
                Integer om = employmentMapper.selectOfferNum(jlvc.getC_name());
                //空值处理
                double offernum = 0;
                if (om != null) {
                    offernum = om;
                }
                //设置offer人数
                jlvc.setC_offer(offernum);

                //设置平均薪资
                if (offernum == 0) {
                    jlvc.setC_money(0.00);
                } else {
                    Double avgMoney = employmentMapper.selectAvgMoney(jlvc.getC_name());
                    jlvc.setC_money(avgMoney);
                }
                //设置成功率
                String s = "";
                if (offernum == 0 || jlvc.getC_num() == 0) {
                    s = "0";
                } else {
                    double f = (offernum / jlvc.getC_num()) * 100;
                    DecimalFormat df = new DecimalFormat("##.00");
                    s = df.format(f) + "%";
                }
                jlvc.setC_success(s);
            }
        }

        //创建分页对象
        PageInfo pi = new PageInfo(li, 4);
        //放入数据和状态码
        sr = ServerResponse.createServerResponseBySuccess(pi);
        return sr;
    }

    //根据不同参数获取详细就业信息数据
    @Override
    public ServerResponse getJoblistDetil(Integer pageNum,Integer pageSize,ParmaVODetil p) {
        //创建高可用对象
        ServerResponse sr = null;

        //创建VO类接受容器
        List ali = new ArrayList();


        //参加该公司面试的人员详情
        PageHelper.startPage(pageNum,pageSize);

        //zhangxin2019.4.10 对is_job参数做判断，获取不同的数据
        List<JobListCompanyDetil> li = null;
        if(p.getIs_job() == 0){
            //面试人员详情
            li = employmentMapper.selectJobDetilByCname0(p);
        }
        if(p.getIs_job() == 1){
            //offer人员详情
            li = employmentMapper.selectJobDetilByCname1(p);
        }
        if(p.getIs_job() == 2){
            //入职人员详情
            li = employmentMapper.selectJobDetilByCname2(p);
        }


        //集合数据为空
        if (li == null || li.size() == 0) {
            sr = ServerResponse.createServerResponseByError(Const.JobListEnum.MSG_NULL.getCode(), Const.JobListEnum.MSG_NULL.getDesc());
            return sr;
        }

        //获取每家公司面试人数
        Integer jm = employmentMapper.selectJobNum(p.getCname());
        //空值处理
        double jobnum = 0;
        if (jm != null) {
            jobnum = jm;
        }
        //获取每家公司offer人数
        Integer om = employmentMapper.selectOfferNum(p.getCname());
        //空值处理
        double offernum = 0;
        if (om != null) {
            offernum = om;
        }
        //获取每家公司平均薪资
        Double avgMoney = employmentMapper.selectAvgMoney(p.getCname());
        if (avgMoney == null) {
            avgMoney = 0.00;
        }
        //获取每家公司入职人数
        Integer cin = employmentMapper.selectByChoce(p.getCname());
        //空值处理
        if (cin == null) {
            cin = 0;
        }

        PageInfo pi = new PageInfo(li, 4);
        //集合数据不为空，封装对应VO类
        JobListVOCompanyDetil jlvc = PoToVoUtil.getNewCompanyDetil(pi, p.getCname(), jobnum, offernum, avgMoney, cin);

        //返回数据
        sr = ServerResponse.createServerResponseBySuccess(jlvc);
        return sr;
    }

    //根据公司名称获取就业信息数据
    @Override
    public ServerResponse getJoblistCname(String c_name) {
        //创建高可用对象
        ServerResponse sr = null;

        //判断参数非空
        if (c_name == null || c_name.equals("")) {
            sr = ServerResponse.createServerResponseByError(300, "公司名称不能为空");
            return sr;
        }

        //判断公司是否存在
        int a = employmentMapper.selectByCompany(c_name);
        if (a < 1) {
            sr = ServerResponse.createServerResponseByError(302, "没有该公司信息");
            return sr;
        }
        //封裝VO类
        //获取每家公司面试人数
        Integer jm = employmentMapper.selectJobNum(c_name);
        //空值处理
        double jobnum = 0;
        if (jm != null) {
            jobnum = jm;
        }
        //获取每家公司offer人数
        Integer om = employmentMapper.selectOfferNum(c_name);
        //空值处理
        double offernum = 0;
        if (om != null) {
            offernum = om;
        }

        //获取每家公司平均薪资
        Double avgMoney = employmentMapper.selectAvgMoney(c_name);
        if (avgMoney == null) {
            avgMoney = 0.00;
        }
        //vo类转化
        JobListVOCompany aNew = PoToVoUtil.getNewCompany(c_name, jobnum, offernum, avgMoney);

        sr = ServerResponse.createServerResponseBySuccess(aNew);
        return sr;
    }

}
