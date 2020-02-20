package com.ssm.service.impl;

import com.ssm.dao.StudentDao;
import com.ssm.entity.Student;
import com.ssm.entity.StudentVO;
import com.ssm.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStuByPageHalper(Integer pageNum, Integer pageSize) {
        return studentDao.getStuByPageHelper(pageNum,pageSize);
    }

    @Override
    public Student getById(String number) {
        return studentDao.getById(number);
    }

    @Override
    public void insert(StudentVO student) {
        studentDao.insert(student);
    }

    @Override
    public void delete(int id) {
        studentDao.delete(id);
    }

    @Override
    public void update(StudentVO  student) {
        Student student1=new Student();
        BeanUtils.copyProperties(student,student1);
        System.out.println("student1 = " + student1);
        studentDao.update(student1);
    }

    @Override
    public List<Student> getStuByClazzid(Integer clazzid) {
        return studentDao.getStuByClazzid(clazzid);
    }

    @Override
    public void deleteByGradeId(int id) {
        studentDao.deleteByGradeId(id);
    }

    @Override
    public void deleteByClazzId(int id) {
        studentDao.deleteByClazzId(id);
    }

    @Override
    public Student getStudentByNumber(String number) {
        return studentDao.getStudentByNumber(number);
    }

    @Override
    public List<Student> getStuByStuClazzid(int page,int rows,int clazzid) {
        return  studentDao.getStuByStuClazzid(page,rows,clazzid);
    }

    @Override
    public void updatePhoto(Student student) {
        studentDao.updatePhoto(student);
    }

    @Override
    public int count() {
        return studentDao.count();
    }

    @Override
    public Student getStudentByExamId(int examid) {
        return studentDao.getStudentByExamId(examid);
    }
}
