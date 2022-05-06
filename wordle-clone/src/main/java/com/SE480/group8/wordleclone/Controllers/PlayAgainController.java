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
public class PlayAgainController {
	
	@Autowired
	WordService wordService;
	
	private static List<String> wordsToGuessArray = new ArrayList<>();
	private static int num = 0;
	
	static {
		wordsToGuessArray.add("tests");
		wordsToGuessArray.add("count");
		wordsToGuessArray.add("feign");
		wordsToGuessArray.add("tools");
		wordsToGuessArray.add("cafes");
	}
	
	@RequestMapping("/playAgain")
	public String playAgain(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String sessionNames[] = session.getValueNames();
		for(String name: sessionNames) {
			session.removeAttribute(name);
		}
		
		Word word = new Word();
		word.setWord(wordsToGuessArray.get(num));
		wordService.save(word);
		
		
		session.setAttribute("mainWord", wordsToGuessArray.get(num));
		num++;
		
		return "homePage";
	}

}
