package com.org.lab1.main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.org.lab1.employee.Employee;
import com.org.lab1.employee.service.interfac.EmployeeServiceInterface;
import com.org.lab1.employeeService.EmployeeService;

public class Main {
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.org.lab1");
		context.refresh();
		 Scanner s=new Scanner(System.in);
		  System.out.println("Enter the id no. :");
		  int id= s.nextInt();
		  
		  EmployeeServiceInterface service= context.getBean(EmployeeService.class);
		  Employee emp= service.getEmpById( id);
		  
		  if(emp!=null)
		  {
			  System.out.println("Show the details:");
			  
			  System.out.println("employee salary"+" ="+ emp.getSalary());
			  System.out.println("employee id"+" ="+ emp.getId());
			  System.out.println("employee name"+" ="+ emp.getName());
		  }
		  else
		  {
			  System.out.println("invalid id");
		  }
	}
}
