package com.neuedu.service.student;

import com.neuedu.core.DESUtils;
import com.neuedu.dao.StudentMapper;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.GradeExample;
import com.neuedu.pojo.Student;
import com.neuedu.pojo.StudentExample;
import com.neuedu.service.grade.IgradeService;
import com.neuedu.service.teacher.IteacherService;
import com.neuedu.service.workstudent.IworkstudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IstudentService {
    @Resource
    StudentMapper studentMapper;
    @Resource
    IgradeService gradeService;
    @Resource
    IworkstudentService workstudentService;
    @Override
    public Grade list(Student student) {
        StudentExample studentExample=new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if(student!=null){
            if(student.getgId()!=null)
                criteria.andGIdEqualTo(student.getgId());
            if(StringUtils.isNotBlank(student.getName()))
                criteria.andNameLike("%"+student.getName()+"%");
            if(student.getGender()!=null)
                criteria.andGenderEqualTo(student.getGender());
            if(student.getStatus()!=null)
                criteria.andStatusEqualTo(student.getStatus());
            criteria.andIsDelEqualTo(1);
        }
        studentExample.setOrderByClause("no asc");
        Grade grade=gradeService.getGradeById(student.getgId());
        gradeService.gradeDetails(grade);
        grade.setStudents(studentMapper.selectByExample(studentExample));
        return grade;
    }

    @Override
    public int add(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public Student getStudent(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int del(int id) {
        return studentMapper.deleteByPrimaryKey(id);
    }
    @Override
    @Transactional
    public synchronized int bathUpdate(List<Student> list) {
        // TODO Auto-generated method stub
        int result=0;
        for (Student student : list) {
            StudentExample studentExample=new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andIdCardEqualTo(student.getIdCard().trim());
            if(studentMapper.countByExample(studentExample)>0){
                student.setPwd(null);
               result += studentMapper.updateByExampleSelective(student, studentExample);
            }else{
                result += studentMapper.insertSelective(student);
            }
        }
        return result;
    }

    @Override
    public int count(int gId) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andGIdEqualTo(gId);
        return studentMapper.countByExample(studentExample);
    }

    @Override
    public int offerCount(int gId) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andGIdEqualTo(gId).andStatusEqualTo(3);
        return studentMapper.countByExample(studentExample);
    }

    @Override
    public int checkIdCard(Student student) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andIdCardEqualTo(student.getIdCard());
        return studentMapper.countByExample(studentExample);
    }

    @Override
    public List<Student> getStudentsByGid(int gId) {
        StudentExample example = new StudentExample();
        example.createCriteria().andGIdEqualTo(gId).andIsDelEqualTo(1);
        return studentMapper.selectByExample(example);
    }

    @Override
    public Student getStudentByGit(String git) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andGitEqualTo(git);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if(students.size()==1)
            return students.get(0);
        return null;
    }

    @Override
    public List<Student> getStudentWork(int gId, int wId) {
        StudentExample studentExample=new StudentExample();
        studentExample.createCriteria().andGIdEqualTo(gId);
        List<Student> students = studentMapper.selectByExample(studentExample);
        for(Student student : students){
            student.setWorks(workstudentService.list(wId, student.getId()));
        }
        return students;
    }

    @Override
    public Student login(String loginId) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andIsDelEqualTo(1).andStatusEqualTo(1).andPhoneEqualTo(loginId);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if(students.size()==1)
            return students.get(0);
        return null;
    }

    @Override
    public int studentcount(int gId) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andGIdEqualTo(gId).andIsDelEqualTo(1).andStatusEqualTo(1);
        return studentMapper.countByExample(studentExample);
    }

    @Override
    public int changepwd(Student student) {
        student.setPwd(DESUtils.getEncryptString(student.getPwd()));
        return update(student);
    }

    @Override
    public List<Student> getStudentsByGid(int gId, int status) {
        StudentExample example = new StudentExample();
        example.createCriteria().andGIdEqualTo(gId).andIsDelEqualTo(1).andStatusEqualTo(status);
        return studentMapper.selectByExample(example);
    }

}
