package com.kture.spring.dao;

import java.util.List;

import com.kture.spring.entity.UserAccount;

public interface UserAccountDAO extends DAO<UserAccount> {

	public UserAccount getByUserId(long id);

	public List<UserAccount> getUserAccounts();

}
