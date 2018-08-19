package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.department.dao.DepartmentDAO;
import com.department.vo.DepartmentVO;
import com.employee.dao.EmployeeDAO;
import com.employee.vo.EmployeeVO;
import com.user.dao.UserDAO;
import com.user.vo.UserVO;

@Controller

public class EmployeeController {
	
	@Autowired
	EmployeeDAO empdao;
	@Autowired
	DepartmentDAO depdao;
	@Autowired
	UserDAO userdao;
	@RequestMapping(method=RequestMethod.GET, value="/registerEmployee")
	public ModelAndView registerEmployee() {
		List departmentList=depdao.listDepartments();
		return new ModelAndView("registerEmployee", "data", new EmployeeVO()).addObject("title", "Register Yourself!").addObject("departmentList", departmentList);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/insert")
	public ModelAndView insert(@ModelAttribute EmployeeVO vo) {
		empdao.insert(vo);
		return new ModelAndView("../../index");
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/searchEmployeeByEmpName")
	public ModelAndView searchEmployeeByEmpName() {
		return new ModelAndView("searchEmployee", "data", new EmployeeVO()).addObject("title", "Search By Employee Name!");
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/searchByEmployeeInDB")
	public ModelAndView searchByEmployeeInDB(@ModelAttribute EmployeeVO vo, @RequestParam ("firstName") String firstName) {
		vo.setFirstName(firstName);
		List searchedEmployee = empdao.searchByEmployeeName(vo);
		return new ModelAndView("viewEmployee", "searchedEmployee", searchedEmployee).addObject("data", vo);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/searchByDepartment")
	public ModelAndView searchByDepartment() {
		List departmentList=depdao.listDepartments();
		return new ModelAndView("searchEmployee", "data", new EmployeeVO()).addObject("title", "Search By Department!").addObject("departmentList", departmentList);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/searchByDepartmentInDB")
	public ModelAndView searchByDepartmentInDB(@ModelAttribute EmployeeVO vo) {
		List searchedEmployee = empdao.searchByDepartment(vo);
		return new ModelAndView("viewEmployee", "searchedEmployee", searchedEmployee).addObject("data", vo);
	}

	@RequestMapping(method=RequestMethod.GET, value="/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam("empId") String empId) {
		int employeeId=Integer.parseInt(empId);
		EmployeeVO vo=new EmployeeVO();
		vo.setEmployeeId(employeeId);
		int userId= empdao.getUserId(vo);
		UserVO uservo=new UserVO();
		uservo.setUserId(userId);
		empdao.deleteEmployee(vo);
		userdao.delete(uservo);
		return new ModelAndView("searchEmployee", "data", new EmployeeVO()).addObject("title", "Search By Employee Name!");
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/deleteByDepartment")
	public ModelAndView deleteByDepartment() {
		List departmentList=depdao.listDepartments();
		return new ModelAndView("searchEmployee", "data", new EmployeeVO()).addObject("title", "Delete By Department!").addObject("departmentList", departmentList);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/deleteByDepartmentInDB")
	public ModelAndView deleteByDepartmentInDB(@ModelAttribute EmployeeVO vo) {
		List searchedEmployee = empdao.searchByDepartment(vo);
		DepartmentVO depvo=new DepartmentVO();
		while (searchedEmployee.size() >=0)
		{
			System.out.println(Integer.parseInt(searchedEmployee.get(0).toString()));
			vo.setEmployeeId(Integer.parseInt(searchedEmployee.get(0).toString()));
			int userId= empdao.getUserId(vo);
			UserVO uservo=new UserVO();
			uservo.setUserId(userId);
			empdao.deleteEmployee(vo);
			userdao.delete(uservo);
			depvo.setDepartmentId(vo.getDepartment().getDepartmentId());
		}
		depdao.delete(depvo);
		return new ModelAndView("viewEmployee", "searchedEmployee", searchedEmployee).addObject("data", vo);
	}
}
