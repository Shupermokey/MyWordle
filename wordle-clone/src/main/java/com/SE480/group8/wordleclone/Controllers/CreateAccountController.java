package com.SE480.group8.wordleclone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SE480.group8.wordleclone.Entities.Account;
import com.SE480.group8.wordleclone.Services.AccountService;

@Controller
public class CreateAccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/createUser")
	public String createUser(Account account) {
		
		System.out.println(account.getEmail());
		System.out.println(account.getPass());
		accountService.createUser(account);
		
		return "redirect:/";
	}
	
	@RequestMapping("/createUserPage")
	public String createUserPage() {
		return "createUserPage";
	}

}
