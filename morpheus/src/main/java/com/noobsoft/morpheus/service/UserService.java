package com.noobsoft.morpheus.service;

import java.util.List;

import com.noobsoft.morpheus.dto.UserDTO;
import com.noobsoft.morpheus.exception.UserServiceException;

public interface UserService {
	
	public UserDTO getUser(int UserId) throws UserServiceException;
	
	public List<UserDTO> getAllUsers() throws UserServiceException;
	
}
