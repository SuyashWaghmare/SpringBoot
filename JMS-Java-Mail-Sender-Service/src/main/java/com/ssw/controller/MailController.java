package com.ssw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssw.model.User;
import com.ssw.service.MailService;

@RestController
public class MailController {

	@Autowired
	private MailService service;

	@RequestMapping("/")
	public String checkApp() {

		return "App is working";

	}

	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	public List<User> getAllUser() {

		List<User> ulist = service.getUser();

		return ulist;

	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@RequestBody User user) {
		service.saveUser(user);
		System.out.println(user);

		return "User Saved";
	}

	@RequestMapping(value = "/loginUser/{username}/{password}", method = RequestMethod.POST)
	public Object loginUser(@PathVariable String username, @PathVariable String password) {

		User use = service.loginUser(username, password);

		boolean flag = use != null;

		if (flag) {

			return use;
		} else
			return "UserName or Password Invalid";

	}

	@RequestMapping(value = "/deleteUserById/{uid}", method = RequestMethod.DELETE)
	public String deleteUserById(@PathVariable int uid) {

		return service.deleteUserById(uid);

	}

}
