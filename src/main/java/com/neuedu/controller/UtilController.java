package com.neuedu.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.core.Constants;
import com.neuedu.core.MyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class UtilController {
    @PostMapping("/imgupload")
    public String upload(String callBackPath,MultipartFile img){
        System.out.println("进入上传方法");
        String url = "";
        try {
            String str= MyUtils.fileUpload(img);
            url = "redirect:" + callBackPath + "?error=0&url="+Constants.IMGSERVER+ str;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            url = "redirect:" + callBackPath + "?error=1&message=上传错误";
            e.printStackTrace();
        }
        return url;
    }
}
