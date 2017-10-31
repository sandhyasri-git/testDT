   package com.niit.frontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mobilebackend.dao.IProductDao;
import com.niit.mobilebackend.dao.IUserDao;
import com.niit.mobilebackend.model.Product;
import com.niit.mobilebackend.model.User;

@Controller
public class HomeController {
	
	@Autowired
	private JavaMailSender mailsender;
	
	@Autowired
	IUserDao userDao;
	
	
	@Autowired 
	User user;
	
	@Autowired
	IProductDao productDAO;
	
	@ModelAttribute
	public User returnObject() {
		
		return new User();
	}
		
		
	@RequestMapping("/")
	public String showHome()
	{
		ModelAndView mv=new ModelAndView("Welcome");
		return "Welcome";
	}
	@RequestMapping("/login")
	public String showLogin()
	{
		ModelAndView mv=new ModelAndView("login");
		return "login";
	}
	@RequestMapping("/registration")
	public String showRegister()
	{
		ModelAndView mv=new ModelAndView("adminhome");
				return "registration";
	}
	@RequestMapping("/aboutus")
	public String showaboutus()
	{
		ModelAndView mv=new ModelAndView("mainpage");
		return "aboutus";
	}
	@RequestMapping("/contactus")
	public String contactus()
	{
		ModelAndView mv=new ModelAndView("mainpage");
		return "contactus";
	}
	@RequestMapping("/Welcome")
	public String showWelcome()
	{
		ModelAndView mv=new ModelAndView("mainpage");
		return "Welcome";
	}
	
	@RequestMapping("/viewProducts")
	public ModelAndView showProducts()
	{
		ModelAndView mv=new ModelAndView("viewProducts");
		return mv;
	}
	@RequestMapping("/{id}viewProfile")
	public String showProfile(@PathVariable Integer id,ModelMap model)
	{
		model.addAttribute("user",userDao.getbyid(id));
		return "viewProfile";
	}
	 
	
	@RequestMapping("/{id}/viewDetails")
	public String showDetails(@PathVariable Integer id,ModelMap model)
	{
		model.addAttribute("product",productDAO.get(id));
		return "viewDetails";
	}
	 
	/*@RequestMapping("/AddProduct")
	 public String showAddProduct()
	 {
		 ModelAndView m=new ModelAndView("AddProduct");
		 
		 return "AddProduct";
	 }*/
	/*@RequestMapping("Mail")
	public void showMail()
	
	{
		String email1="ameerpashamohammad@gmail.com";
		String recipentaddress=email1;
		String subject="user registration";
		String message="user registred successfully";
		
     
	}*/
	
	@RequestMapping(value="/addus",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,BindingResult result,HttpServletRequest request, HttpSession session)throws IOException {
		System.out.println(user.getCpassword());
		System.out.println(user.getpassword());
		System.out.println(user.getEmailid());
		MultipartFile image=user.getImg();
		 Path path;
		 path=Paths.get("E:/S180108/mobilesproject-master/mobilesproject-master/mobilesfront/src/main/Webapp/pics/" + user.getUsername() + ".jpg");
		 System.out.println("Path=" + path);
		 System.out.println("file name" + user.getImg().getOriginalFilename());
		 if(image !=null && !image.isEmpty());
		 {
			 try
			 {
				 image.transferTo(new File(path.toString()));
				 System.out.println("image saved in" + path.toString());
			 }
			 catch(Exception e) {
				 e.printStackTrace();
				 System.out.println("image not saved");
			 }
		 }
		user.setEnabled("true");
		user.setRole("ROLE_USER");
		if(user.getCpassword().equals(user.getPassword())){
			userDao.addUser(user);
		}
		session = request.getSession(false);
		session.setAttribute("email1",user.getEmailid());
		session.setAttribute("loggedInUser", user.getUsername());
		String email1=(String) session.getAttribute("email1");
		String username=(String) session.getAttribute("loggedInUser");
		/*String email1 = null;*/
		String recipientAddress=email1;
		String subject="user Registration";
		String message="user registered successfully\n"+ "the details...." +"\n User Name:" + username +"\n phone no:" +user.getPhone();
		System.out.println("To:" + recipientAddress);
		System.out.println("subject:" + subject);
		System.out.println("Message:" + message);
		SimpleMailMessage email=new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		mailsender.send(email);
		return "login";
	}
	@RequestMapping("/Signout")
	public ModelAndView showLogout()
	{
		ModelAndView mv=new ModelAndView("mainpage");
		return mv;
	}
	@RequestMapping("perform_logout")
	public ModelAndView showLogout(HttpServletRequest request,HttpSession session) {
		System.out.println("logout");
		ModelAndView mv=new ModelAndView("mainpage");
		session.invalidate();
		session=request.getSession(true);
		mv.addObject("logOutMessage","u have successfully loggedout");
		mv.addObject("loggedOut","true");
		return mv;
		
	}
	@RequestMapping(value="/login_session_attributes")
	//getting values from textbox 
	public String login_session_attibutes(HttpSession session,Model model,@RequestParam(value="username") String id)
	{
		String name =SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("inside security check");
		session.setAttribute("name",name);
		System.out.println(name);
		
		user= userDao.get(id);
		int x=user.getUserid();
		session.setAttribute("email",user.getEmailid());
		session.setAttribute("loggedInUser",user.getUsername());
		session.setAttribute("loggedInUserId", x);
		session.setAttribute("LoggedIn", "true");
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext()
		.getAuthentication().getAuthorities();
		
		String role="ROLE_USER";
		for(GrantedAuthority authority : authorities) {
			
		
		
		if(authority.getAuthority().equals(role)) {
			System.out.println(role);
			return "LoginDisplay";
		}
		else
		{
			session.setAttribute("isadmin","true");
		}
		}
		
	
	return "Adminhome";
	}
}
			
			

