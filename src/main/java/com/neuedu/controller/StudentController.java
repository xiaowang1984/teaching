package com.neuedu.controller;

import com.neuedu.message.Message;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Student;
import com.neuedu.service.student.IstudentService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    IstudentService studentService;
    @GetMapping("/list")
    public Grade list(Student student){
        return studentService.list(student);
    }
    @PostMapping("/add")
    public Message add(Student student){
        return new Message(studentService.add(student));
    }
    @GetMapping("/edit")
    public Student getStudent(int id){
        return studentService.getStudent(id);
    }
    @PostMapping("/edit")
    public Message update(Student student){
        return new Message(studentService.update(student));
    }
    @GetMapping("/del")
    public Message del(int id){
        return new Message(studentService.del(id),"删除成功");
    }
    @PostMapping("/upload")
    public Message fileUpload(MultipartFile sfile,Integer gId){
        int result=0;
        try {
            List<Student> students=new ArrayList<>();
            HSSFWorkbook workbook=new HSSFWorkbook(sfile.getInputStream());
            HSSFSheet sheet = workbook.getSheetAt(0);
            int count=4;
            Row row=null;
            while((row= sheet.getRow(count++))!=null){
                if(row.getCell(3)==null||row.getCell(3).toString().trim().equals(""))
                    break;
                Student student=new Student();
                float no=Float.parseFloat(row.getCell(3).toString().trim());
                student.setNo(Math.round(no));
                student.setgId(gId);
                student.setName(row.getCell(4).toString());
                if(row.getCell(5).toString().trim().equals("男"))
                    student.setGender(1);
                else
                    student.setGender(0);
                student.setNation(row.getCell(6).toString());
                student.setSale(row.getCell(8).toString());
                student.setSchool(row.getCell(9).toString());
                student.setSpecialty(row.getCell(10).toString());
                student.setEducation(row.getCell(12).toString());
                row.getCell(16).setCellType(Cell.CELL_TYPE_STRING);
                student.setPhone(row.getCell(16).getStringCellValue());
                student.setAddress(row.getCell(17).toString());
                row.getCell(18).setCellType(Cell.CELL_TYPE_STRING);
                student.setWeChar(row.getCell(18).getStringCellValue());
                student.setRoomNo(row.getCell(19).toString());
                row.getCell(21).setCellType(Cell.CELL_TYPE_STRING);
                student.setQq(row.getCell(21).getStringCellValue());
                student.setEmail(row.getCell(22).toString());
                row.getCell(23).setCellType(Cell.CELL_TYPE_STRING);
                student.setIdCard(row.getCell(23).getStringCellValue());
                student.setCycle(row.getCell(24).toString());
                if(row.getCell(25).toString().trim().equals("是"))
                    student.setRefund(1);
                else
                    student.setRefund(0);
                if(row.getCell(26)!=null)
                    student.setGit(row.getCell(26).toString().trim());
                students.add(student);
            }
            result=studentService.bathUpdate(students);
        } catch (IOException e) {
            e.printStackTrace();
            result=0;
        }
        return new Message(result);
    }
    @GetMapping("/checkIdCard")
    public Map<String,String> checkIdCard(Student student){

        Map<String,String> map = new HashMap<>();
        if(studentService.checkIdCard(student)==0)
            map.put("getdata","true");
        return map;
    }
    @GetMapping("/getStudents")
    public List<Student> getStudents(int gId){
        return studentService.getStudentsByGid(gId);
    }
}
