package com.noobsoft.morpheus.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.noobsoft.morpheus.dto.UserDTO;
import com.noobsoft.morpheus.exception.UserServiceException;
import com.noobsoft.morpheus.service.UserService;
import com.noobsoft.morpheus.service.UserServiceImpl;

@Path("/user")
@Produces("application/xml")
@Consumes("application/xml")
public class UserRestService {
	
	@GET
	@Path("/get/{userid}")
	public UserDTO getUser(@PathParam("userid") String userId){
		
		UserService service = new UserServiceImpl();
		
		UserDTO userDTO;
		
		try {
			userDTO = service.getUser(Integer.valueOf(userId));
			return userDTO;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		} catch (UserServiceException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@GET
	@Path("/getall")
	public List<UserDTO> getAllUsers(){
		UserService service = new UserServiceImpl();
		
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		
		
		try {
			userDTOs = service.getAllUsers();
		} catch (UserServiceException e) {
			e.printStackTrace();
		}
		
		return userDTOs;
	}

}
