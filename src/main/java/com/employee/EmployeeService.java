package com.employee;

import java.util.List;

public interface EmployeeService
{


	void sortEmployeeByName(List<EmployeeBean> employeeList);
	void sortEmployeeByID(List<EmployeeBean> employeeList);
	void sortEmployeeBySalary(List<EmployeeBean> employeeList);
	void sortEmployeeByAge(List<EmployeeBean> employeeList);
	void sortEmployeeByAgeR(List<EmployeeBean> employeeList);
	
}
