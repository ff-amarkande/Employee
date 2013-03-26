package com.employee.web;

import java.util.*;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.domain.EmployeeBean;
import com.employee.domain.Order;
import com.employee.domain.SortBy;
import com.employee.service.EmployeeService;




@Controller
public class EmployeeContoller 
{
	
	@Autowired
	@Qualifier("employeeServiceImpl")
	EmployeeService empService;
	

	/*@Autowired
	@Qualifier("employeeServiceImpl2")
	EmployeeService empService2;*/
	
	@RequestMapping(value="/",method = RequestMethod.GET)
    public String defaultpage(Model model)
    {
		model.addAttribute("employeeList",empService.getAllEmployees());
		System.out.println("dfdf");		
		return "index";
    }
	
	
	
	@RequestMapping("/hello")
	    public String hello(Model model)
	    {
		
		   System.out.println("hiiiii");
		   model.addAttribute("employeeList",empService.getAllEmployees());
		   return "hello";
	    }
	
	@RequestMapping(value="/sort/{sortby}",method=RequestMethod.GET)
	 public String sortby(Model model,@PathVariable("sortby")  int sortby)
	 {
		if(sortby>=4)
			return "invalidargument";
		
		
		List<EmployeeBean> employeelist;

	 	String c=SortBy.values()[sortby].name();
	 	
	 	System.out.println("the  value is = "+c);
		
		employeelist=empService.sortEmployee(empService.getAllEmployees(), SortBy.values()[sortby],Order.Ascending);
		
		
		model.addAttribute("employeeList",employeelist);
		model.addAttribute("SortBy", c);
		model.addAttribute("Order", "Ascending by Default");
		return "sort";
	  	 
		
	 }
	
	@RequestMapping(value="/sort/{sortby}/{order}",method=RequestMethod.GET)
	 public String sortAndOrder(Model model,@PathVariable("sortby")  int sortby,@PathVariable("order")  int order)
	 {
		if(sortby>=4 || order>=2)
			return "invalidargument";
		
		
		List<EmployeeBean> employeelist;
			
	 	String c=SortBy.values()[sortby].name();
	 	String d=Order.values()[order].name();
		
		employeelist=empService.sortEmployee(empService.getAllEmployees(), SortBy.values()[sortby],Order.values()[order]);
		 
		
		model.addAttribute("employeeList",employeelist);
		model.addAttribute("SortBy", c);
		model.addAttribute("Order", d);
		
		return "sort";
	 }

	@RequestMapping(value="/sortpage",method = RequestMethod.GET)
    public String Sortpage(Model model)
    {
		model.addAttribute("employeeList",empService.getAllEmployees());
		System.out.println("dfdf");		
		return "Sortpage";
    }

	@RequestMapping(value="/sort",method=RequestMethod.GET)
	 public String order1(Model model,@RequestParam("sortoption") int sortby,@RequestParam("orderoption") int order)
	 {
		
		List<EmployeeBean> employeelist;
	   
		String c=SortBy.values()[sortby].name();
	 	String d=Order.values()[order].name();
		
		employeelist=empService.sortEmployee(empService.getAllEmployees(), SortBy.values()[sortby],Order.values()[order]);
		 
		
		model.addAttribute("employeeList",employeelist);
		model.addAttribute("SortBy", c);
		model.addAttribute("Order", d);
		
		return "sort";
	 }
	
	
	@RequestMapping(value="/addEmployee",method = RequestMethod.POST)
    public String addNewEmployee(@Valid @ModelAttribute("EmployeeBean") EmployeeBean employeeBean,BindingResult result,Model model)
    {
	 
		  //  System.out.println("Ename ="+employeeBean.getEmployeeName()+employeeBean.getEmployeeAge()+employeeBean.getEmployeeID()+employeeBean.getEmployeeSalary());
	     	if (result.hasErrors()) 
		    {
			//	System.out.println("In If");
				return "addNewEmployee";
		    }
	     	else 
	     	{
	     		//System.out.println("In else");
	     		empService.addEmployee(employeeBean);
	     	//	System.out.println("no of size ="+empService.getAllEmployees().size());
	     		model.addAttribute("employeeList",empService.getAllEmployees());
	     		return "index";
	     	}
	 	
	 
    }
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
    public ModelAndView add()
    {
		
		return new ModelAndView("addNewEmployee","EmployeeBean",new EmployeeBean());
	//	return new ModelAndView("addNewEmployee");
		
    }
	
	
	 
}
