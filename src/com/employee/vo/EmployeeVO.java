package com.employee.vo;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.department.vo.DepartmentVO;
import com.user.vo.UserVO;

@Entity
@Table(name="Employee")
public class EmployeeVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	private String firstName;
	private String lastName;
	@ManyToOne
	private DepartmentVO department;
	@OneToOne(cascade= {CascadeType.ALL})
	private UserVO user;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public DepartmentVO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
}