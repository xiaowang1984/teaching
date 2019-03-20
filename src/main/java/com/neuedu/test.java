package com.neuedu;

import com.neuedu.service.workstudent.IworkstudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {
    @Resource
    IworkstudentService workstudentService;
    public static void main(String[] args) throws ParseException {
        double a = 2.4;
        System.out.println(a);
    }
    @Test
    public void handler(){
        System.out.println(workstudentService.batchload(new Date()));
    }
}
