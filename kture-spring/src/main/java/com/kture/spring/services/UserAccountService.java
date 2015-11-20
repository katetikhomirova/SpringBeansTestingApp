package com.kture.spring.services;

import java.util.List;

import com.kture.spring.dao.UserAccountDAO;
import com.kture.spring.entity.UserAccount;
import com.kture.spring.exceptions.InsufficientFundsException;

public class UserAccountService extends AbstractService<UserAccountDAO> {

	public UserAccount getUserAccount(long userId) {
		return dao.getByUserId(userId);
	}

	public UserAccount updateUserAccountFund(long userId, int fund)
			throws InsufficientFundsException {
		if (dao.getByUserId(userId).getFund() + fund < 0)
			throw new InsufficientFundsException(
					"Can't update user account by setting fund < 0");
		UserAccount a = new UserAccount(userId, dao.getByUserId(userId)
				.getFund() + fund);
		log.info("Update userAccount " + userId + " set fund = " + a.getFund());
		a.setId(dao.getByUserId(userId).getId());
		return dao.update(a);
	}

	public UserAccount createUserAccount(long userId) {
		return dao.create(new UserAccount(userId, 0));
	}

	public List<UserAccount> getUserAccounts() {
		return dao.getUserAccounts();
	}

	public boolean deleteUserAccount(long userId) {
		return dao.delete(userId);
	}

}
