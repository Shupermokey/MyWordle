package com.SE480.group8.wordleclone.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SE480.group8.wordleclone.Entities.Account;
import com.SE480.group8.wordleclone.Entities.Word;
import com.SE480.group8.wordleclone.Services.AccountService;
import com.SE480.group8.wordleclone.Services.WordService;

@Controller
public class LoginController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	WordService wordService;
	
	
	@RequestMapping("/")
	public String loginPage() {
		return "loginPage";
	}
	
	@RequestMapping("/checkCredentials")
	public String checkCredentials(Account account, Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String sessionNames[] = session.getValueNames();
		for(String name: sessionNames) {
			session.removeAttribute(name);
		}
		boolean check = accountService.checkCredentials(account);
		String w[] = {"fl","sl","tl","cl","pl"};
		String w2[] = {"fl2","sl2","tl2","cl2","pl2"};
		String w3[] = {"fl3","sl3","tl3","cl3","pl3"};
		String w4[] = {"fl4","sl4","tl4","cl4","pl4"};
		String w5[] = {"fl5","sl5","tl5","cl5","pl5"};

		for(int i =0; i<5; i++) {
			session.setAttribute(w[i], null);
			session.setAttribute(w2[i], null);
			session.setAttribute(w3[i], null);
			session.setAttribute(w4[i], null);
			session.setAttribute(w5[i], null);
		}
		if(check == true) {
			Word word = new Word();
			word.setWord("Hello");
			wordService.save(word);
			session.setAttribute("mainWord", "Hello");
			session.setAttribute("Username", account.getEmail());
			return "homePage";
		}
		else {
			System.out.println("Bad credentials");
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String sessionNames[] = session.getValueNames();
		for(String name: sessionNames) {
			session.removeAttribute(name);
		}
		return "loginPage";
	}

}
