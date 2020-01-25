package com.ewaiter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ewaiter.dto.Customer;
import com.ewaiter.service.CustomerService;

//Controller mapped for customers only
@Controller
public class CustomerController {

	
	@Autowired
	private CustomerService cservice;

	@Autowired
	HttpSession session;

	//Customer login page is default page.
	@GetMapping("/")
	public String custLogin() {
		
		//Checks if customer session is available.If yes redirect to men page otherwise redirect to login page.
		boolean flag=false;
		try{flag = !session.getAttribute("loggedcust").equals(null);}catch(NullPointerException e) {System.out.println(e);}
			if (flag)
				return "menu";
			else
				return "index";
	}


	
	//Request will come to post mapping after customer fills the form and clicks submit button.
	@PostMapping("/custLogin")
	public String custLogin(Customer customer) {
		boolean flag = false;
		
		//checks if any data entered is null.If found redirected to login page.
		
		if(customer.getName().equals(null)||customer.getMobile_no().equals(null)||customer.getTable_id()==0)
			return "index";
		
		//If data is not null then session variable loggedcust is popolated with customer name.
		//and data is inserted to database
		
		try
		{
		session.setAttribute("loggedcust", customer.getName());
		flag = cservice.custLoginService(customer);
		}
		catch(NullPointerException e)
		{
			
			System.out.println(e);
		}
		
		//if flag is true then data is added to database and redirected to menu page ,
		//if not then data is not added to database and redirected to customer login page..

		
		if (flag)
			return "menu";
		else
			return "index";
	}

	// Get method for session.invalidate as sign out.
	// If session attribute us already null then directly redirect to login page,otherwise invalidate the session and then redirect to login page.

	@GetMapping("/logout")
	public String logout() {
		try {

			String s = (String) session.getAttribute("loggedcust");
			if(s.equals(null))
				return "index";
			else
				session.invalidate();
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
		return "index";

	}

}
