package com.neuedu.controller;

import com.github.pagehelper.Page;
import com.neuedu.message.Message;
import com.neuedu.pojo.Result;
import com.neuedu.pojo.Storehouse;
import com.neuedu.service.storehouse.IstorehouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/storehouse")
public class StoreHouseController {
    @Resource
    IstorehouseService storehouseService;
    @GetMapping("/list")
    public Result list(Storehouse storehouse){
        List<Storehouse> list = storehouseService.getStoreHouse(storehouse);
        if(list instanceof Page)
            return new Result(list,((Page<Storehouse>)list).getPages(),((Page<Storehouse>)list).getPageNum());
        else
            return new Result(list,1,1);
    }
    @PostMapping("/add")
    public Message add(Storehouse storehouse){
        return new Message(storehouseService.add(storehouse));
    }
    @GetMapping("/edit")
    public Storehouse getStoreHouse(int id){
        return storehouseService.getStoreHouseById(id);
    }
    @PostMapping("/edit")
    public Message update(Storehouse storehouse){
        return new Message(storehouseService.update(storehouse));
    }
    @GetMapping("/getByCid")
    public List<Storehouse> getByCid(int cId){
        return  storehouseService.getStoreHouseByCid(cId);
    }
}
