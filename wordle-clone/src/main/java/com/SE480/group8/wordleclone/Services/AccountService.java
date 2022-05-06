package com.SE480.group8.wordleclone.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SE480.group8.wordleclone.Entities.Account;
import com.SE480.group8.wordleclone.Repositories.AccountRepo;

@Service
public class AccountService {
	
	@Autowired
	AccountRepo accountRepo;
	
	public boolean createUser(Account account) {
		
		if(accountRepo.findAccountByEmail(account.getEmail())!=null){
			
			System.out.println("User is already created!");
			return false;
			
		}
		else {
			System.out.println("Created");
			accountRepo.save(account);
			return true;
		}
		 
		
	}
	
	public boolean checkCredentials(Account account) {
		
		if(accountRepo.findAccountByEmail(account.getEmail())!=null){
			Account user = accountRepo.findAccountByEmail(account.getEmail());
			if(account.getPass().equals(user.getPass())) {
				return true;
			}
			
			
		}
			return false;
	}

}
