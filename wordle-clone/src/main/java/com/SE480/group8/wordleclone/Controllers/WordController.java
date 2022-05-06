package com.SE480.group8.wordleclone.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SE480.group8.wordleclone.Entities.Word;
import com.SE480.group8.wordleclone.Services.WordService;

@Controller
public class WordController {
	
	@Autowired
	WordService wordService;
	
	@RequestMapping("/accountHistory")
	public String accountHistory(HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<Word> words= new ArrayList<>();
		if(wordService.findAll()!=null)
		{
			words.addAll(wordService.findAll());
			session.setAttribute("wordHistory", words);
		}
		
		return "accountPage";
	}

}
