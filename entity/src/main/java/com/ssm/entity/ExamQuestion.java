package com.ssm.entity;

import lombok.Data;

@Data
public class ExamQuestion {
	private int id; 
	private int examid;
	private String questtions ;
	private String optionA; 			
	private String optionB; 
	private String optionC; 
	private String optionD; 
	private String answer;//答案
	private int type;//题目类型：1.单选题或者判断题，2.多选题
	private Integer value; //分值

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExamid() {
		return examid;
	}

	public void setExamid(int examid) {
		this.examid = examid;
	}

	public String getQuesttions() {
		return questtions;
	}

	public void setQuesttions(String questtions) {
		this.questtions = questtions;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
