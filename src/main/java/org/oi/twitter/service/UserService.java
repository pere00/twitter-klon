package org.oi.twitter.service;

import java.util.List;

import org.oi.twitter.dao.UserDao;
import org.oi.twitter.dao.UserRoleDao;
import org.oi.twitter.domain.User;
import org.oi.twitter.domain.ui.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;

	public List<User> listUsers() {
		return userDao.listUsers();
	}

	public List<UserInfo> fetchUserListForUser(String username) {// fetch all
																	// users
																	// except
																	// logged in
																	// user
		return userDao.fetchUserInfoListForUser(username);
	}

	public void saveUser(User user) {
		userDao.saveNewUser(user);
		userRoleDao.addUserRole(user.getId(), "ROLE_USER");
	}

	public User fetchUser(String username) {
		return userDao.fetchUserByName(username);
	}

	public UserInfo fetchUserInfo(String username, String authenticatedUserName) {
		return userDao.fetchUserInfo(username, authenticatedUserName);
	}

	public boolean checkIfUsernameIsAvailable(String username) {
		return userDao.checkIfUsernameIsAvailable(username);
	}

	public boolean checkIfpassAtLeast6char(String password) {
		return password.length() >= 6;
	}

	public boolean checkIfPassIsHard(String password) {

		boolean has1Lower = password.matches(".*[a-z]+.*");

		boolean has1Upper = password.matches(".*[A-Z]+.*");

		boolean has1num = password.matches(".*[0-9]+.*");

		boolean has1special = password.matches(".*\\W+.*");

		return has1Lower && has1Upper && (has1special || has1num);

	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}
}
