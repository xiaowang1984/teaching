package com.neuedu.controller;

import com.neuedu.service.arrangeList.IarrangeListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/arrangeList")
public class ArrangeListController {
    @Resource
    IarrangeListService arrangeListService;
    @GetMapping("/getDates")
    public List<Date> getDates(int gId){
        return arrangeListService.getDates(gId);
    }
    @GetMapping("/getDatesWithoutAid")
    public List<Date> getDates(int gId,int aId){
        return arrangeListService.getDates(gId, aId);
    }
}
