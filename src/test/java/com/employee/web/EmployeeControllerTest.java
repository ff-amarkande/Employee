package com.employee.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.employee.domain.EmployeeBean;
import com.employee.service.EmployeeService;


@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class EmployeeControllerTest extends AbstractTestNGSpringContextTests {
	
	private List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();

	
	@Autowired
	private EmployeeContoller empcon;
	
	@Autowired
	private EmployeeService empService ;
	
	@BeforeMethod
	public void init(){
		EmployeeBean bean1=new EmployeeBean(1,"Ashwin",22,10000);
		EmployeeBean bean2=new EmployeeBean(3,"Sachin",24,40000);
		EmployeeBean bean3=new EmployeeBean(2,"Vivek",26,60000);
		EmployeeBean bean4=new EmployeeBean(4,"Krish",23,20000);
		EmployeeBean bean5=new EmployeeBean(5,"Amit",28,30000);
		employeeList.add(bean1);
		employeeList.add(bean2);
		employeeList.add(bean3);
		employeeList.add(bean4);
		employeeList.add(bean5);
	}
	
	@Test
	public void hello() throws Exception 
	{
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/hello");
        MockHttpServletResponse response = new MockHttpServletResponse();
		try 
		{

			ModelAndView mav = new AnnotationMethodHandlerAdapter().handle(request, response, empcon);
			System.out.println("view name [hello] =" + mav.getViewName());
			Assert.assertEquals("hello", mav.getViewName());

		} 
		catch (Exception e) 
		{
			System.out.println("Error massage from hello function "+e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void sortpage() 
	{
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/sortpage");
		request.setMethod("GET");
        MockHttpServletResponse response = new MockHttpServletResponse();
		try 
		{
			ModelAndView mav = new AnnotationMethodHandlerAdapter().handle(request, response, empcon);
			System.out.println("view name [sortpage] =" + mav.getViewName());
			Assert.assertEquals("Sortpage", mav.getViewName());
		}
		catch (Exception e)
		{

			System.out.println("Error massage from sortpage" + e.getMessage());
		}
	}
	
	@Test
	public void defaultpage()
	{
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/");
		request.setMethod("GET");
        MockHttpServletResponse response = new MockHttpServletResponse();
		try 
		{
			ModelAndView mav = new AnnotationMethodHandlerAdapter().handle(request, response, empcon);
			System.out.println("view name [defaultpage] =" + mav.getViewName());
			Assert.assertEquals("index", mav.getViewName());
		}
		catch (Exception e)
		{

			System.out.println("Error massage from sortpage" + e.getMessage());
		}
	}
	
	@Test
	public void sortOrderAndSortByName()
	{
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/sort/1/1");
		request.setMethod("GET");
        MockHttpServletResponse response = new MockHttpServletResponse();
	
		try 
		{
			ModelAndView mav = new AnnotationMethodHandlerAdapter().handle(request, response, empcon);
			List<EmployeeBean> emplist=empService.getAllEmployees();
			String name1=emplist.get(0).getEmployeeName();
			String name2=emplist.get(1).getEmployeeName();
			
			System.out.println("First name = "+name1);
			System.out.println("Second name = "+name2);
			
			
			Assert.assertEquals("Vivek",name1);
			Assert.assertEquals("Virat",name2);
	
			System.out.println("view name [sort] =" + mav.getViewName());
			Assert.assertEquals("sort", mav.getViewName());
		}
		catch (Exception e)
		{

			System.out.println("Error massage from sortpage" + e.getMessage());
		}
	}
	
	@Test
	public void sortAgeChecking()
	{
        MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/sort/2");
		request.setMethod("GET");
        MockHttpServletResponse response = new MockHttpServletResponse();
		
		try 
		{
			ModelAndView mav = new AnnotationMethodHandlerAdapter().handle(request, response, empcon);
			List<EmployeeBean> emplist=empService.getAllEmployees();
			
			int id1=emplist.get(0).getEmployeeAge();
			int id2=emplist.get(1).getEmployeeAge();
			
			Assert.assertEquals(22,id1);
			Assert.assertEquals(23,id2);
	
			System.out.println("view name [sort] =" + mav.getViewName());
			Assert.assertEquals("sort", mav.getViewName());
		}
		catch (Exception e)
		{

			System.out.println("Error massage from sortpage" + e.getMessage());
		}
	}
	
	@Test
	public void sortEmployeeSalary()
	{

		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/sort/3/1");
		request.setMethod("GET");
        MockHttpServletResponse response = new MockHttpServletResponse();
		
		try 
		{
			ModelAndView mav = new AnnotationMethodHandlerAdapter().handle(request, response, empcon);
			List<EmployeeBean> emplist=empService.getAllEmployees();
			
			int id1=emplist.get(0).getEmployeeSalary();
			int id2=emplist.get(1).getEmployeeSalary();
			
			Assert.assertEquals(60000,id1);
			Assert.assertEquals(40000,id2);
		    
			System.out.println("view name [sort] =" + mav.getViewName());
			Assert.assertEquals("sort", mav.getViewName());
		}
		catch (Exception e)
		{

			System.out.println("Error massage from sortpage" + e.getMessage());
		}
	}
	
	@Test
	public void sortInvalidParamater()
	{
     	MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/sort/8/8");
		request.setMethod("GET");
        MockHttpServletResponse response = new MockHttpServletResponse();
		
		try 
		{
			ModelAndView mav = new AnnotationMethodHandlerAdapter().handle(request, response, empcon);
			System.out.println("view name [sortInvalidParamater] =" + mav.getViewName());
			Assert.assertEquals("invalidargument", mav.getViewName());
		}
		catch (Exception e)
		{

			System.out.println("Error massage from sortpage" + e.getMessage());
		}
	}
}
