package com.neuedu.controller;

import com.github.pagehelper.Page;
import com.neuedu.message.Message;
import com.neuedu.pojo.Computer;
import com.neuedu.pojo.Result;
import com.neuedu.service.computer.IcomputerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/computer")
public class ComputerController {
    @Resource
    IcomputerService computerService;
    @GetMapping("/list")
    public Result list(Computer computer){
        List<Computer> list = computerService.list(computer);
        if(list instanceof Page)
            return new Result(list,((Page<Computer>)list).getPages(),((Page<Computer>)list).getPageNum());
        else
            return new Result(list,1,1);
    }
    @PostMapping("/add")
    public Message add(Computer computer){
        return new Message(computerService.add(computer));
    }
    @GetMapping("/edit")
    public Computer getComputerById(int id){
        return computerService.getComputerById(id);
    }
    @PostMapping("/edit")
    public Message update(Computer computer){
        return new Message(computerService.update(computer));
    }
    @GetMapping("/details")
    public List<Computer> details(int year,int month,int gId ){
        return computerService.details(year,month , gId);
    }
}
