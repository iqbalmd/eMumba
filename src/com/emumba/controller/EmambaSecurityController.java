package com.emumba.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emumba.model.User;
import com.emumba.service.UserService;


@Controller
public class EmambaSecurityController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/secured/allusers")
    public String allUsersPublicPage(ModelMap model,Principal principal,HttpServletRequest request) {		
		List<User> list = userService.getUsers();
		model.addAttribute("users",list);
        model.addAttribute("message", "This page private page viewing all users.");
        return "/secured/s_allusers";
    }
	
	@RequestMapping("/secured/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id, ModelMap model,Principal principal,HttpServletRequest request) {
		System.out.println("ID# "+id);
		User deleteUser = userService.getUserById(id.intValue());
		if(deleteUser == null){
			model.addAttribute("message", "You enter the wrong ID of the user.");
			List<User> list = userService.getUsers();			
			model.addAttribute("users",list);
	        return "/secured/s_allusers";				
		}
		System.out.println(deleteUser.toString());
		userService.deleteUser(deleteUser);
		List<User> list = userService.getUsers();			
		model.addAttribute("users",list);
        model.addAttribute("message", "The user has successfully delete.");	 
        return "/secured/s_allusers";
	}
		
    @RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "/login";
	}
    
    @RequestMapping(value="/secured/createNewUser", method = RequestMethod.GET)
   	public String createNewUser() {
    	return "/secured/s_createNewUser";
   	}
    
//  @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    @RequestMapping(value="/secured/create", method = RequestMethod.POST)
   	public String create(ModelMap model,Principal principal,HttpServletRequest request) {		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String authority = request.getParameter("authority");		
		User newUser = new User();
		newUser.setName(username);
		newUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
		newUser.setEmail(email);
		newUser.setAuthority(authority);
		User user = userService.getUserByEmail(email);
		if(user == null){
			userService.insertUser(newUser);
		}
		else{
			model.addAttribute("message","Duplicate Name");  			
			return "/secured/s_createNewUser";
		}
//    	userService.insertUser(newUser);  //FIXME remove it
		//Note: Check for duplicate "name"    		
		//TODO Use the following instead of try{ ..} catch(..)
		//@ExceptionHandler(DataIntegrityViolationException.class)
		/*try{
			userService.insertUser(newUser);	
		}catch (org.springframework.dao.DataIntegrityViolationException e) {
			model.addAttribute("message","Duplicate Name");  			
			return "/secured/s_createNewUser";
		}catch (Exception e) {    			  			
			return "/home";
		}*/
		
		List<User> list = userService.getUsers();
		model.addAttribute("users",list);
		
		return "/secured/s_allusers";
   	}
    
    @RequestMapping(value="/home", method = RequestMethod.GET)
  	public String home(ModelMap model, Principal principal) {
    	String uname = principal.getName();
    	model.put("message", uname);
  		return "/home";
   
  	}
    
	@RequestMapping(value="/fail2login", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "/login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) { 
		return "/login";
	}
	
	@RequestMapping(value="/timeout", method = RequestMethod.GET)
	public String timeout(ModelMap model) {
		return "/login";
	}
	
	@RequestMapping(value = "/secured/update/{id}" , method = RequestMethod.GET)
    public String updateRequest(@PathVariable Integer id, ModelMap model,Principal principal,HttpServletRequest request) {
		User updateUser = userService.getUserById(id.intValue());
		if(updateUser == null){
			model.addAttribute("message", "You enter the wrong id of User...!");
			return "/home";
		}
		System.out.println(updateUser.toString());			
        model.addAttribute("message", "To update the User fill the form.");
		model.addAttribute("updateUser",updateUser);
		model.addAttribute("back","/secured/allusers");			
        return "/secured/s_updateExitingUser";
    }
	
	
	@RequestMapping(value = "/secured/update/{id}" , method = RequestMethod.POST)
    public String updateUser(@ModelAttribute User u,@PathVariable Integer id, ModelMap model,Principal principal,HttpServletRequest request) {
		
			System.out.println("principal.getName(): "+principal.getName());
			if(request.isUserInRole("ROLE_USER")){
		    	String uname = principal.getName();
		    	model.put("message", uname);
		  		return "/secured/s_home";
			}
			System.out.println("ID## "+id);
			//Before updating change the password from normal form to MD5
			u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
			userService.updateUser(u);		
			List<User> list = userService.getUsers();
			model.addAttribute("users",list);
	        model.addAttribute("message", "The user "+u.getName() + " has been updated.");
	 
	        return "/secured/s_allusers";
		
    }
}
