package com.ewaiter.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ewaiter.dto.User;
import com.ewaiter.service.UserService;

//Controller mapped only for employees of restaurant.
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService uservice;
	
	@Autowired
	HttpSession session;
		
	//Home page for application
	@GetMapping("/")
	public String loginPage()
	{
		try
		{
			//If session is already present then directly redirected to welcome page of admin.manager or employee depending on conditions.
			//otherwise redirected to employee login page.
			
			if(!(session.getAttribute("logged").equals(0)))
			{
				
				//If value of logged is equal to 1 then redirect to ADMIN WELCOME page.
				if(session.getAttribute("logged").equals(1))
					return "welcomeadmin";
				
				//If value of logged is equal to 1 then redirect to MANAGER WELCOME page.
				else if(session.getAttribute("logged").equals(2))
					return "welcomemgr";
				
				//Else redirect Employee WELCOME page.(Common for CHEF and WAITER)
				else
					return "welcomeemp";
			}
		}
		catch(Exception e) {e.getMessage();}
		return "login";
	}
	
	/*  When employee login button is pressed request comes to this mapping.
	 * 	1-admin
	 *	2-manager
	 *	3-chef
	 *  4-waiter

	 */

	
	
	@PostMapping("/login") 
	public String login(User user)
	{	
		//Service class method loginService is called with user as parameter. 
		
		int user_type = 0;
		try{user_type = uservice.loginService(user);}
		catch(Exception e) {System.out.println(e);}

		//logged session variable is populated with user type id.
		//If value of logged is equal to 1 then redirect to ADMIN WELCOME page.

		if(user_type==1)
		{
			session.setAttribute("logged", user_type);
			return "welcomeadmin";
		}
		
		//logged session variable is populated with user type id.
		//If value of logged is equal to 1 then redirect to ADMIN WELCOME page.
		
		else if(user_type==2)
		{
			session.setAttribute("logged", user_type);
			return "welcomemgr";
		}
		
		//logged session variable is populated with user type id.
		//If value of logged is equal to 1 then redirect to ADMIN WELCOME page.
		
		else if(user_type==3 )
		{
			session.setAttribute("logged", user_type);
			return "welcomeemp";
		}
		
		//If not then redirected to employee login page.
		else
			return "login";
	}
	
	
	//Only admin and manager can add , remove or view an employee. 
	
	@GetMapping("/register")
	public String registerPage()
	{
		try
		{

			//if session is already present then directly redirected to welcome.jsp page
			//if not then redirected to register page.
			
			if((session.getAttribute("logged").equals(1)||session.getAttribute("logged").equals(2)))
			{
			return "register";
			}
		}
		catch(Exception e) {System.out.println(e);}
		return "login";
	}
	
	//User registration post method.
	//User entity contains entered data of employee.
	//Which is passed to service class method registerService.

	@PostMapping("/register")
	public String Register(User user)
	{
		boolean flag = false;
		try
		{
		flag = uservice.registerService(user);
		}
		catch(Exception e)
		{e.getMessage();}
		
		//If data added to database then redirect to home page.
		
		if(flag)
			return "redirect:/user/";
		
		//Otherwise redirect to same register page for as try again to register .
		
		else
			return "register ";
	}
	
	
	//Get method for session.invalidate as sign out.
	
	@GetMapping("/logout")
	public String logout()
	{
		try
		{
		session.invalidate();
		}
		catch(IllegalStateException e)
		{
			System.out.println(e);
		}
		return "login";
		
	}
	
	//Only admin and manager can get employee data.
	
	@GetMapping("/showemp")
	public ModelAndView findAll(ModelAndView mv) {
		
		//If user ID is 1 or 2 then findAll method of Service class is called.
		//It returns list of all employees which is stored in li variable of type List.
		//It is added to ModelAndView object as name "listEmployees" and returned to view (showemp).
		
		if((session.getAttribute("logged").equals(1)||session.getAttribute("logged").equals(2)))
		{
			mv.setViewName("showemp");
	        List<User> li = uservice.findAll();
	        mv.addObject("listEmployees",li);
		}
		
		//else redirected to employee welcome page.
		
		else
		{
			mv.setViewName("welcomeemp");
		}


        return mv;
		
    }
	
	//When remove button inside showemp.jsp is pressed it will take ID as GET parameter which is stored in int id.

    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
    	
    	//If ID is 1 then redirected to same page because user_type_id as 1 cannot be deleted as it is an admin itelf.
    	//admin can add another admin but cannot delete itself.
    	
		if((session.getAttribute("logged").equals(1)||session.getAttribute("logged").equals(2)))
		{
			if(id==1)
	            return "redirect:/user/showemp";
	    	else
	    		//If ID is not equal to 1 then that ID is passed to service class method removeUser.
	    		
	    		uservice.removeUser(id);
	        return "redirect:/user/showemp";
			
		}
		return "redirect:/user/";
    }

	//When Edit button inside "showemp.jsp" is pressed it will take ID as GET parameter which is stored in int id.
    
    @GetMapping("/editUser/{id}")
    public ModelAndView editUser(@PathVariable("id") int id,ModelAndView mv)
    {
    	//Only if ADMIN or MANAGER is present allow the edit.
		if((session.getAttribute("logged").equals(1)||session.getAttribute("logged").equals(2)))
		{
	    	//View name of ModelAndView object "mv" is set to "edituser.jsp".
	    	mv.setViewName("edituser");
	    		
	    	//getUser method of service class is called with id as parameter which returns a single user with id,finally "mv" object is returned
	    	//which is consumed by "edituser.jsp" which shows all data of that employee in editable form.
	    	User user = uservice.getUser(id);
	    	mv.addObject("user",user);		
		}
		else
		{
	    	mv.setViewName("welcomeemp");
		}
        return mv;
    }
    
    //The changes can made in form inside view "edituser" and when Update button is pressed request will come to POST edituser() method.
    
    @PostMapping("/editUser/editUser")
    public  String editUser(User user){
    	
    	//It will call editUser method of Service class with updated user as a parameter, which updates the values in database.
    	//Finally it will return to same "showemp" page where updated information will be shown.
    	
    	
    	
    	uservice.editUser(user);
        return "redirect:/user/showemp";
    }
	
}





