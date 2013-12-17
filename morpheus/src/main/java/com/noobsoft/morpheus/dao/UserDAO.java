package com.noobsoft.morpheus.dao;

import java.util.List;

import com.noobsoft.morpheus.domain.User;
import com.noobsoft.morpheus.exception.TrinityException;
import com.noobsoft.morpheus.exception.UserNotFoundException;

public interface UserDAO {
	
	public User find(int userID) throws UserNotFoundException, TrinityException;
	
	public List<User> findAll() throws TrinityException;
	
	public void add(User user) throws TrinityException;
	
	public void batchAdd(List<User> users) throws TrinityException;
	
	public void update(User user) throws UserNotFoundException, TrinityException;
	
	public void batchUpdate(List<User> users) throws UserNotFoundException, TrinityException;
	
	public boolean remove(User user) throws UserNotFoundException, TrinityException;
	
	public boolean batchRemove(List<User> user) throws UserNotFoundException, TrinityException;

}
