package com.neuedu.controller;

import com.neuedu.message.Message;
import com.neuedu.pojo.LanguageWithBLOBs;
import com.neuedu.service.language.IlanguageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Resource
    IlanguageService languageService;
    @GetMapping("/list")
    public List<LanguageWithBLOBs> list(LanguageWithBLOBs language){
        return languageService.getLanguages(language);
    }
    @PostMapping("/add")
    public Message add(LanguageWithBLOBs language){
        return new Message(languageService.add(language));
    }
    @PostMapping("/del")
    public Message del(LanguageWithBLOBs language){
        return  new Message(languageService.update(language));
    }
    @GetMapping("/edit")
    public LanguageWithBLOBs getLanguageById(int id){
        return languageService.getLanguageById(id);
    }
    @PostMapping("/edit")
    public Message update(LanguageWithBLOBs language){
        return new Message(languageService.update(language));
    }
}
