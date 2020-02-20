package com.ssm.entity;

import lombok.Data;

//考试成绩类
@Data
public class EScore {
	
	private int id;
	private Exam exam;
	private int examid;
	private Clazz clazz;
	private int clazzid;
	private int gradeid;
	private Course course;
	private int courseid;
	private Student student;
	private int studentid;
	private int score;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public int getExamid() {
		return examid;
	}

	public void setExamid(int examid) {
		this.examid = examid;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public int getClazzid() {
		return clazzid;
	}

	public void setClazzid(int clazzid) {
		this.clazzid = clazzid;
	}

	public int getGradeid() {
		return gradeid;
	}

	public void setGradeid(int gradeid) {
		this.gradeid = gradeid;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public EScore(int examid, int clazzid, Integer studentid, int gradeid, int courseid) {
		this.examid=examid;
		this.studentid=studentid;
		this.clazzid=clazzid;
		this.gradeid=gradeid;
		this.courseid=courseid;
	}

	public EScore() {
	}
}
