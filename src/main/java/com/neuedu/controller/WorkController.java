package com.neuedu.controller;

import com.github.pagehelper.Page;
import com.neuedu.message.Message;
import com.neuedu.pojo.Result;
import com.neuedu.pojo.Work;
import com.neuedu.service.work.IworkService;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/work")
public class WorkController {
    @Resource
    IworkService workService;
    @GetMapping("/list")
    public Result list(Work work, Date dat){
        List<Work> list = workService.list(work,dat);
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
    public Work getOne(int id){
        return workService.getWorkById(id);
    }
    @RequestMapping("/up")
    public String gitLoad(@RequestBody Map<String, String> parameterMap) {
        // TODO Auto-generated method stub
        System.out.println("进入该方法");
        File file=new File("/abcd.txt");
        Set<String> keys= parameterMap.keySet();
        StringBuilder builder=new StringBuilder();
        for (String key : keys) {

            builder.append(key+":"+parameterMap.get(key)+"\n");
        }
        try {
            FileUtils.writeStringToFile(file, builder.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return builder.toString();
    }
}
