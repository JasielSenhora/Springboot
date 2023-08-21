package com.example.day4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Studentdetails")
public class StudentDetails {
	   @Id
	   @GeneratedValue(strategy= GenerationType.IDENTITY)
	   @Column(name="Stuid")
       private int stuId;
	   @Column(name="Stuname")
       private String stuName;
       private String dept;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
       
}
