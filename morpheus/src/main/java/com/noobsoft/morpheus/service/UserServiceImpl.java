package com.noobsoft.morpheus.service;


import java.util.ArrayList;
import java.util.List;

import com.noobsoft.morpheus.dao.UserDAO;
import com.noobsoft.morpheus.dao.UserDAOImpl;
import com.noobsoft.morpheus.domain.User;
import com.noobsoft.morpheus.dto.UserDTO;
import com.noobsoft.morpheus.exception.TrinityException;
import com.noobsoft.morpheus.exception.UserNotFoundException;
import com.noobsoft.morpheus.exception.UserServiceException;
import com.noobsoft.morpheus.util.HibernateFactory;

public class UserServiceImpl implements UserService {

	/**
	 * 
	 */
	private UserDAO userDAO;

	public UserServiceImpl() {

		this.userDAO = new UserDAOImpl(new HibernateFactory());

	}

	private UserDTO parseUser(User user) {
		if (user == null) {
			return new UserDTO(0, "", "");
		} else
			return new UserDTO(user.getUserId(), user.getUserName(),
					user.getUserPass());
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDTO getUser(int userId) throws UserServiceException {
		User user;
		try {
			user = userDAO.find(userId);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			throw new UserServiceException();
		} catch (TrinityException e) {
			e.printStackTrace();
			throw new UserServiceException();
		}

		return parseUser(user);

	}

	public List<UserDTO> getAllUsers() throws UserServiceException {
		List<User> allUsers = new ArrayList<User>();

		try {
			allUsers = userDAO.findAll();
		} catch (TrinityException e) {
			e.printStackTrace();
			throw new UserServiceException();
		}

		if (allUsers.isEmpty()) {
			return null;
		} else {
			List<UserDTO> userDTOs = new ArrayList<UserDTO>();
			for (User user : allUsers) {
				userDTOs.add(parseUser(user));
			}

			return userDTOs;

		}
	}
}