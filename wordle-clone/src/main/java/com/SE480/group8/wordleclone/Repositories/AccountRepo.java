package com.SE480.group8.wordleclone.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SE480.group8.wordleclone.Entities.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	
	public Account findAccountByEmail(String email);

}
