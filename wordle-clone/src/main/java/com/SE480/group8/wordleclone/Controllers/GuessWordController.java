package com.SE480.group8.wordleclone.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.SE480.group8.wordleclone.Entities.Word;
import com.SE480.group8.wordleclone.Services.WordService;

@Controller
public class GuessWordController {
	
	@Autowired
	WordService wordService;
	 
	
	@RequestMapping("/guessOne")
	public ModelAndView guessWordOne(String w1p1, String w1p2, String w1p3, String w1p4,String w1p5, HttpServletRequest req ) {		
		String wordArray[] = {w1p1, w1p2, w1p3, w1p4, w1p5};
		HttpSession session = req.getSession();
		String wordToGuess = (String)session.getAttribute("mainWord");
		String wordToGuessArray[] = wordToGuess.split("");
		String w[] = {"fl","sl","tl","cl","pl"};
		ModelAndView mv = new ModelAndView();
		if(w1p1 != null && w1p2 != null && w1p3 != null && w1p4 != null && w1p5 != null) {
			session.setAttribute("w1p1", w1p1);
			session.setAttribute("w1p2", w1p2);
			session.setAttribute("w1p3", w1p3);
			session.setAttribute("w1p4", w1p4);
			session.setAttribute("w1p5", w1p5);
			List<String> list = new ArrayList<>();
			String guess = w1p1+w1p2+w1p3+w1p4+w1p5;
			for(int i =0; i<5; i++) {
				if(wordToGuessArray[i].equals(wordArray[i]) ) {
					list.add(wordArray[i]);
					session.setAttribute(w[i], true);
					System.out.print(wordToGuessArray[i] + " : "+ wordArray[i]+ "      ");
					System.out.println(w[i] +": true");
				}
				else {
					session.setAttribute(w[i], false);
					System.out.print(wordToGuessArray[i] + " : "+ wordArray[i]+ "      ");
					System.out.println(w[i] +": false");
				}
			}
			if(list.size()==5) {
				wordService.setWordStatus(wordToGuess, "W");
				wordService.save(wordService.findWord(wordToGuess));
				session.setAttribute("outcome", "Winner");
			}
			mv.setViewName("homePage");
		}
		return mv;
		
	}
	
	@RequestMapping("/guessTwo")
	public ModelAndView guessWordTwo(String w2p1, String w2p2, String w2p3, String w2p4,String w2p5, HttpServletRequest req ) {
		String wordArray[] = {w2p1, w2p2, w2p3, w2p4, w2p5};
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		String wordToGuess = (String)session.getAttribute("mainWord");
		String wordToGuessArray[] = wordToGuess.split("");
		String w[] = {"fl2","sl2","tl2","cl2","pl2"};
		List<String> list = new ArrayList<>();
		if(w2p1 != null && w2p2 != null && w2p3 != null && w2p4 != null && w2p5 != null) {
			session.setAttribute("w2p1", w2p1);
			session.setAttribute("w2p2", w2p2);
			session.setAttribute("w2p3", w2p3);
			session.setAttribute("w2p4", w2p4);
			session.setAttribute("w2p5", w2p5);
			String guess = w2p1+w2p2+w2p3+w2p4+w2p5;
			
			for(int i =0; i<5; i++) {
				if(wordToGuessArray[i].equals(wordArray[i]) ) {
					list.add(wordArray[i]);
					session.setAttribute(w[i], true);
					System.out.print(wordToGuessArray[i] + " : "+ wordArray[i]+ "      ");
					System.out.println(w[i] +": true");
				}
				else {
					session.setAttribute(w[i], false);
					System.out.print(wordToGuessArray[i] + " : "+ wordArray[i]+ "      ");
					System.out.println(w[i] +": false");
				}
			}
			if(list.size()==5) {
				wordService.setWordStatus(wordToGuess, "W");
				session.setAttribute("outcome", "Winner");
			}
			mv.setViewName("homePage");
		}
		return mv;
		
	}
	
	@RequestMapping("/guessThree")
	public ModelAndView guessWordThree(String w3p1, String w3p2, String w3p3, String w3p4,String w3p5, HttpServletRequest req ) {
		String wordArray[] = {w3p1, w3p2, w3p3, w3p4, w3p5};
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		String wordToGuess = (String)session.getAttribute("mainWord");
		String wordToGuessArray[] = wordToGuess.split("");
		String w[] = {"fl3","sl3","tl3","cl3","pl3"};
		List<String> list = new ArrayList<>();
		if(w3p1 != null && w3p2 != null && w3p3 != null && w3p4 != null && w3p5 != null) {
			session.setAttribute("w3p1", w3p1);
			session.setAttribute("w3p2", w3p2);
			session.setAttribute("w3p3", w3p3);
			session.setAttribute("w3p4", w3p4);
			session.setAttribute("w3p5", w3p5);
			String guess = w3p1+w3p2+w3p3+w3p4+w3p5;
			for(int i =0; i<5; i++) {
				if(wordToGuessArray[i].equals(wordArray[i]) ) {
					list.add(wordArray[i]);
					session.setAttribute(w[i], true);
					System.out.print(wordToGuessArray[i] + " : "+ wordArray[i]+ "      ");
					System.out.println(w[i] +": true");
				}
				else {
					session.setAttribute(w[i], false);
					System.out.print(wordToGuessArray[i] + " : "+ wordArray[i]+ "      ");
					System.out.println(w[i] +": false");
				}
			}
			if(list.size()==5) {
				wordService.setWordStatus(wordToGuess, "W");
				session.setAttribute("outcome", "Winner");
			}
			mv.setViewName("homePage");
		}
		return mv;
		
	}
	
	@RequestMapping("/guessFour")
	public ModelAndView guessWordFour(String w4p1, String w4p2, String w4p3, String w4p4,String w4p5, HttpServletRequest req ) {
		String wordArray[] = {w4p1, w4p2, w4p3, w4p4, w4p5};
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		String wordToGuess = (String)session.getAttribute("mainWord");
		String wordToGuessArray[] = wordToGuess.split("");
		String w[] = {"fl4","sl4","tl4","cl4","pl4"};
		List<String> list = new ArrayList<>();
		if(w4p1 != null && w4p2 != null && w4p3 != null && w4p4 != null && w4p5 != null) {
			session.setAttribute("w4p1", w4p1);
			session.setAttribute("w4p2", w4p2);
			session.setAttribute("w4p3", w4p3);
			session.setAttribute("w4p4", w4p4);
			session.setAttribute("w4p5", w4p5);
			String guess = w4p1+w4p2+w4p3+w4p4+w4p5;
			for(int i =0; i<5; i++) {
				if(wordToGuessArray[i].equals(wordArray[i]) ) {
					list.add(wordArray[i]);
					session.setAttribute(w[i], true);
					System.out.print(wordToGuessArray[i] + " : "+ wordArray[i]+ "      ");
					System.out.println(w[i] +": true");
				}
				else {
					session.setAttribute(w[i], false);
					System.out.print(wordToGuessArray[i] + " : "+ wordArray[i]+ "      ");
					System.out.println(w[i] +": false");
				}
			}
			if(list.size()==5) {
				wordService.setWordStatus(wordToGuess, "W");
				session.setAttribute("outcome", "Winner");
				
			}
			mv.setViewName("homePage");
		}
		return mv;
		
	}
	
	@RequestMapping("/guessFive")
	public ModelAndView guessWordFive(String w5p1, String w5p2, String w5p3, String w5p4,String w5p5, HttpServletRequest req ) {
		String wordArray[] = {w5p1, w5p2, w5p3, w5p4, w5p5};
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		String wordToGuess = (String)session.getAttribute("mainWord");
		String wordToGuessArray[] = wordToGuess.split("");
		List<String> list = new ArrayList<>();
		String w[] = {"fl5","sl5","tl5","cl5","pl5"};
		if(w5p1 != null && w5p2 != null && w5p3 != null && w5p4 != null && w5p5 != null) {
			session.setAttribute("w5p1", w5p1);
			session.setAttribute("w5p2", w5p2);
			session.setAttribute("w5p3", w5p3);
			session.setAttribute("w5p4", w5p4);
			session.setAttribute("w5p5", w5p5);
			String guess = w5p1+w5p2+w5p3+w5p4+w5p5;
			boolean flag = false;
			for(int i =0; i<5; i++) {
				if(wordToGuessArray[i].equals(wordArray[i]) ) {
					list.add(wordArray[i]);
					session.setAttribute(w[i], true);
					System.out.print(wordToGuessArray[i] + " : "+ wordArray[i]+ "      ");
					System.out.println(w[i] +": true");
				}
				else {
					session.setAttribute(w[i], false);
					System.out.print(wordToGuessArray[i] + " : "+ wordArray[i]+ "      ");
					System.out.println(w[i] +": false");
				}
			}
			if(list.size()==5) {
				wordService.setWordStatus(wordToGuess, "W");
				session.setAttribute("outcome", "Winner");
				
			}
			else {
				session.setAttribute("outcome", "Nice try");
				wordService.setWordStatus(wordToGuess, "L");
				
			}
			mv.setViewName("homePage");
		}
		return mv;
		
	}

}
