package com.SE480.group8.wordleclone.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SE480.group8.wordleclone.Entities.Word;

@Repository
public interface WordRepo extends JpaRepository<Word, Long>{
	
	public Word findWordByWord(String word);

}
