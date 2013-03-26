package com.employee.service;

import java.util.*;

import com.employee.domain.EmployeeBean;
import com.employee.domain.Order;
import com.employee.domain.SortBy;


public interface EmployeeService
{
	
	List<EmployeeBean> sortEmployee(List<EmployeeBean> employeeList,SortBy c,Order s);
	
	List<EmployeeBean> getAllEmployees();
	
	void addEmployee(EmployeeBean employee);
	
	

}
