package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	private int emp_id;
	private String emp_name;
	
	@ManyToOne
	@JoinColumn(name="emp_dept_ID")
	private Department dept;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Employee(int emp_id, String emp_name, Department dept) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.dept = dept;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", dept=" + dept + "]";
	}
	
	
	
}