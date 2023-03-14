package com.nav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.nav.dto.UserData;
import com.nav.entities.User;
import com.nav.service.UserService;





@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	


	//http://localhost:8080/create
		@RequestMapping( "/create")
		public String  viewCreateUserForm(Model model) {
			User user = new User();
			model.addAttribute("user",user);
			return "create_user";
		}
		
		@RequestMapping( "/save")
		public String saveOneUser(@ModelAttribute("user") User user,Model model) {
			userService.saveUserInformation(user);
			model.addAttribute("user", user);
			return "redirect:/listusers";
          }
		//http://localhost:8080/listusers
		@RequestMapping("/listusers")
		public String listUsers(Model model) {
			List<User> users = userService.getAllUsers();
			model.addAttribute("users",users);
			return "list_users";
		}
		@RequestMapping("/userInfo")
		public String userInfo(@RequestParam("id") long id, Model model) {
			User user=userService.findUserById(id);
			model.addAttribute("user", user);
			return "user_info";
		}
		
		@RequestMapping("/delete")
		public String deleteOneUser(@RequestParam("id") long id ,Model model) {
			userService.deleteUser(id);
			List<User> users = userService.getAllUsers();
			model.addAttribute("users",users);
			return "list_users";
		}
		
		@RequestMapping("/update")
		public String getUserInfo(@RequestParam("id") long id ,Model model) {
			User user=userService.getOneUser(id);
			
			model.addAttribute("user",user);
			return "update_user";
		}
		@RequestMapping("/updateUser")
		public String updateUserInfo(User data, Model model) {
		
			userService.saveUserInfo(data);
			
			List<User> users = userService.getAllUsers();
			model.addAttribute("users",users);
			return "redirect:/listusers";
			
		}
}
