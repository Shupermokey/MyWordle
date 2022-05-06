package com.SE480.group8.wordleclone.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SE480.group8.wordleclone.Entities.Word;
import com.SE480.group8.wordleclone.Repositories.WordRepo;

@Service
public class WordService {

	@Autowired
	WordRepo wordRepo;
	
	public void save(Word word) {
		if(word != null) {
			wordRepo.save(word);
		}
		
	}
	
	public List<Word> findAll(){
		
		return wordRepo.findAll();
	}

	public void setWordStatus(String word, String status) {
		
		Word wordUpdate = wordRepo.findWordByWord(word);
		if(wordUpdate != null) {
			System.out.println("Word updated status to: " + status);
			wordUpdate.setStatus(status);
		}
		
	}
	
	public Word findWord(String word) {
		Word theWord = wordRepo.findWordByWord(word);
		if(theWord != null) {
			System.out.println("Word found: " + word);
			return theWord;
		}
		
		return null;
		
	}
	
	
	
}
