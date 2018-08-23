package com.neuedu.controller;

import com.neuedu.message.Message;
import com.neuedu.pojo.Module;
import com.neuedu.service.module.ImoduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/module")
public class ModuleController {
    @Resource
    ImoduleService moduleService;
    @GetMapping("/list")
    public List<Module> list(Module module){
        return moduleService.getModules(module);
    }
    @PostMapping("/add")
    public Message add(Module module){
        return new Message(moduleService.add(module));
    }
    @GetMapping("/getModule")
    public  Module  getModuleById(int id){
        return moduleService.getModuleById(id);
    }
    @GetMapping("/getList")
    public List<Module> getList(int lId){
        return moduleService.getModules(lId);
    }
    @PostMapping("/edit")
    public Message update(Module module){
        return new Message(moduleService.update(module));
    }
    @PostMapping("/del")
    public Message del(Module module){
        module.setIsDel(0);
        return new Message(moduleService.update(module));
    }
    @GetMapping("/getModules")
    public List<Module> getSiblings(int id){
        return moduleService.getSiblings(id);
    }

}
