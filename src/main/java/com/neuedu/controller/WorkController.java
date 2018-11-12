package com.neuedu.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.Page;
import com.neuedu.message.Message;
import com.neuedu.pojo.*;
import com.neuedu.service.student.IstudentService;
import com.neuedu.service.work.IworkService;
import com.neuedu.service.workCommit.IworkCommitService;
import com.neuedu.service.workdetails.IworkDetailsService;
import com.neuedu.service.workgrade.IworkGradeService;
import com.neuedu.service.workstudent.IworkstudentService;
import org.apache.commons.io.FileUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/work")
public class WorkController {

    @Resource
    IworkService workService;
    @Resource
    IworkGradeService workGradeService;
    @Resource
    IstudentService studentService;
    @Resource
    IworkCommitService  workCommitService;
    @Resource
    IworkstudentService workstudentService;
    @GetMapping("/list")
    public Result list(Work work, Date dat){
        List<Work> list = workService.list(work,dat);
        for (Work entry : list){
            int donecount = workstudentService.checkcount(entry.getId());
            int stucount = studentService.count(entry.getGid());
            if(stucount!=0)
                entry.setDone(donecount*100/stucount);
            Workgrade last = workGradeService.getLast(entry.getId());
            if(last!=null)
                if(stucount!=0)
                    entry.setCode((last.getAdds()-last.getDels())/stucount);
        }
        if(list instanceof Page)
            return new Result(list,((Page<Work>)list).getPages(),((Page<Work>)list).getPageNum());
        else
            return new Result(list,1,1);
    }
    @PostMapping("/add")
    public Message add(Work work){
        return new Message(workService.add(work));
    }
    @PostMapping("/del")
    public Message del(Work work){
        return new Message(workService.update(work));
    }

    @GetMapping("/getOne")
    public String getOne(int id){
        Work work = workService.getWorkById(id);
        work.setWorkgrade(workGradeService.list(work.getId()));
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        return JSONObject.toJSONString(work, SerializerFeature.WriteMapNullValue,SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat,SerializerFeature.PrettyFormat);
    }
    @RequestMapping("/git")
    @Transactional
    public String gitLoad(@RequestBody Map<String, String> parameterMap) {
        // TODO Auto-generated method stub
        try {
            workService.gitLoad(parameterMap);
        }catch (Exception ex){
            File file = new File("/error.txt");
            try {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw, true);
                ex.printStackTrace(pw);
                pw.flush();
                sw.flush();
                FileUtils.writeStringToFile(file, sw.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        StringBuilder builder=new StringBuilder();

        return builder.toString();
    }
    @GetMapping("/stuwork")
    public List<Student> stuwork(int wId,int gId){
        return studentService.getStudentWork(gId, wId);
    }
    @GetMapping("/checkwork")
    public List<Workgrade> checkwork(int wId){
        return workGradeService.list(wId);
    }
    @GetMapping("/studetails")
    public String studetails(Workcommit workcommit){
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        return JSONObject.toJSONString(workCommitService.getWorkCommits(workcommit), SerializerFeature.WriteMapNullValue,SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat,SerializerFeature.PrettyFormat);
    }
    @PostMapping("/check")
    public Message check(Workstudent workstudent){
        return new Message(workstudentService.update(workstudent));
    }
    @GetMapping("/timerpt")
    public String timerpt(Workcommit workcommit){
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        return JSONObject.toJSONString(workCommitService.getWorkCommitsByDat(workcommit), SerializerFeature.WriteMapNullValue,SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat,SerializerFeature.PrettyFormat);
    }
}
