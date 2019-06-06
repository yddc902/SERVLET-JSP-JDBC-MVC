package com.yashdesai.model;

import java.util.Date;

public class EmployeeModel {

	private int empId;
	private String empName;
	private String empDept;
	private Date empDOJ;
	private int empSalary;


	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	/*public Date getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(Date empDOJ) {
		this.empDOJ = empDOJ;
	}*/

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}


	public void setEmpDOJ(Date date) {
    	this.empDOJ = (Date) date.clone();
	}

	public Date getEmpDOJ() {
    	return (Date) this.empDOJ.clone();
	}

}
