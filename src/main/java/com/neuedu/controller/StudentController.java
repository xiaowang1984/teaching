package com.neuedu.controller;

import com.neuedu.core.DESUtils;
import com.neuedu.core.MyUtils;
import com.neuedu.message.Message;
import com.neuedu.pojo.*;
import com.neuedu.service.computer.IcomputerService;
import com.neuedu.service.employment.IemploymentService;
import com.neuedu.service.grade.IgradeService;
import com.neuedu.service.interview.InterviewService;
import com.neuedu.service.interviewDetails.InterviewDetailsService;
import com.neuedu.service.job.IjobService;
import com.neuedu.service.score.IscoreService;
import com.neuedu.service.student.IstudentService;
import com.neuedu.service.studentlog.IstudentLogService;
import com.neuedu.service.work.IworkService;
import com.neuedu.service.workstudent.IworkstudentService;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.*;
import java.time.temporal.TemporalUnit;
import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    IstudentService studentService;
    @Resource
    IstudentLogService studentLogService;
    @Resource
    InterviewService interviewService;
    @Resource
    IcomputerService computerService;
    @Resource
    IworkstudentService workstudentService;
    @Resource
    IworkService workService;
    @Resource
    IgradeService gradeService;
    @Resource
    IscoreService scoreService;
    @Resource
    InterviewDetailsService interviewDetailsService;
    @Resource
    IemploymentService employmentService;
    @Resource
    IjobService jobService;
    @GetMapping("/list")
    public Grade list(Student student) {
        return studentService.list(student);
    }

    @PostMapping("/add")
    public Message add(Student student) {
        return new Message(studentService.add(student));
    }

    @GetMapping("/edit")
    public Student getStudent(int id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/edit")
    public Message update(Student student) {
        return new Message(studentService.update(student));
    }

    @GetMapping("/del")
    public Message del(int id) {
        return new Message(studentService.del(id), "删除成功");
    }

    @PostMapping("/upload")
    public Message fileUpload(MultipartFile sfile, Integer gId) {
        int result = 0;
        try {
            List<Student> students = new ArrayList<>();
            HSSFWorkbook workbook = new HSSFWorkbook(sfile.getInputStream());
            HSSFSheet sheet = workbook.getSheetAt(0);
            int count = 4;
            Row row = null;
            while ((row = sheet.getRow(count++)) != null) {
                if (row.getCell(3) == null || row.getCell(3).toString().trim().equals(""))
                    break;
                Student student = new Student();
                float no = Float.parseFloat(row.getCell(3).toString().trim());
                student.setNo(Math.round(no));
                student.setgId(gId);
                student.setName(row.getCell(4).toString());
                if (row.getCell(5).toString().trim().equals("男"))
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
                if (row.getCell(25).toString().trim().equals("是"))
                    student.setRefund(1);
                else
                    student.setRefund(0);
                if (row.getCell(26) != null)
                    student.setGit(row.getCell(26).toString().trim());
                student.setPwd(DESUtils.getEncryptString("123456"));
                students.add(student);
            }
            result = studentService.bathUpdate(students);
        } catch (IOException e) {
            e.printStackTrace();
            result = 0;
        }
        return new Message(result);
    }

    @GetMapping("/checkIdCard")
    public Map<String, String> checkIdCard(Student student) {

        Map<String, String> map = new HashMap<>();
        if (studentService.checkIdCard(student) == 0)
            map.put("getdata", "true");
        return map;
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents(int gId) {
        return studentService.getStudentsByGid(gId);
    }

    @PostMapping("/login")
    public Message login(String loginId, String pwd, HttpSession session, HttpServletRequest request) {
        Student student = studentService.login(loginId);
        if (student == null)
            return new Message(0, "用户名不存在");
        else {
            if (student.getPwd().equals(DESUtils.getEncryptString(pwd))) {
                session.setAttribute("user", student);
                return new Message(1, "登录成功");
            } else
                return new Message(0, "密码错误");
        }
    }

    @PostMapping("/logsave")
    public Message logsave(Studentlog studentlog, HttpSession session) {
        return new Message(studentLogService.save(studentlog, session));
    }

    @GetMapping("/getLogOne")
    public Studentlog getLogOne(Studentlog studentlog, HttpSession session) {
        Student student = (Student) session.getAttribute("user");
        studentlog.setSid(student.getId());
        Studentlog result = studentLogService.getStudentLogBySid(studentlog);
        if (result != null)
            return result;
        else
            return new Studentlog();
    }

    @GetMapping("/getLogs")
    public List<Studentlog> getLogs(int year, int month, HttpSession session) {
        Student student = (Student) session.getAttribute("user");
        return studentLogService.getLogs(year, month, student.getId());
    }

    @GetMapping("/getUser")
    public Message getStudentById(HttpSession session) {
        Student student = (Student) session.getAttribute("user");
        return new Message(1, studentService.getStudent(student.getId()));
    }

    @GetMapping("/getLogsByGid")
    public List<Student> getLogs(Date start, Date end, int gId) {
        return studentLogService.getLogsByGid(start, end, gId);
    }

    @PostMapping("/upimg")
    public Message upimg(MultipartFile upfile, Student student) throws Exception {
        String img = MyUtils.fileUpload(upfile);
        student.setImg(img);
        return new Message(studentService.update(student));
    }

    @PostMapping("/pwd")
    public Message changepwd(Student student) {
        return new Message(studentService.changepwd(student));
    }

    @GetMapping("/examcount")
    public Map<String, Integer> getExamCount(HttpSession session) {
        Map<String, Integer> result = new HashMap<>();
        Student student = (Student) session.getAttribute("user");
        result.put("interview", interviewService.countByStudent(student.getId()));
        result.put("computer", computerService.countByStudent(student.getId()));
        return result;
    }

    @GetMapping("/studentReport")
    public Map<String, Object> studentReport(HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        Student student = (Student) session.getAttribute("user");
        List<Date> dates = workstudentService.getDatesBySid(student.getId());
        Job job = new Job();
        job.setWithPage(0);
        result.put("student", studentService.getStudent(student.getId()));
        result.put("dates", dates);
        result.put("stuCode", workstudentService.getStuCode(student.getId(), dates));
        result.put("workcount", workService.count(student.getgId()));
        result.put("donecount", workstudentService.donecount(student.getId()).size());
        result.put("sumcode", workstudentService.sumbystu(student.getId()));
        result.put("avgmood", studentLogService.getListByGid(student.getgId()));
        result.put("moodlist", studentLogService.getLogsBySid(student.getId()));
        result.put("summood", getDaydeff(student.getgId()));
        result.put("avgscore", scoreService.avgbySid(student.getId()));
        result.put("avggradescore", scoreService.avggrade(student.getId()));
        result.put("avginterview", interviewDetailsService.avgbySid(student.getId()));
        result.put("avggradinterview", interviewDetailsService.avggrade(student.getId()));
        result.put("employmentlist", employmentService.list(student.getId()));
        result.put("joblist", jobService.getJobs(job));
        return result;
    }

    public int getDaydeff(Integer gId){
        LocalDate today=LocalDate.now();
        Grade grade = gradeService.getGradeById(gId);
        if(grade.getEnd()!=null){
            Instant instant = grade.getEnd().toInstant();
            ZoneId zone = ZoneId.systemDefault();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
            today=localDateTime.toLocalDate();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(grade.getStartDate());
        LocalDate oldDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
        return (int)(today.toEpochDay()-oldDate.toEpochDay());
    }
}
