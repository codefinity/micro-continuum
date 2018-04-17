package com.codefinity.microcontinuum.identityaccess.repository;

import java.util.ArrayList;
import java.util.List;

import com.codefinity.microcontinuum.identityaccess.domain.model.User;

public class UserRepository {

	public User getUserByEmail(String email) {
		
		User user = new User();
		user.setFirstName("FirstName");
		user.setEmail("e@mail.com");
		user.setPassword("password");		
		
		return user;
	}
	
	public List<String> getRoleByEmail( String email){
		
		List<String> roles = new ArrayList<String>();
		roles.add("user");
		roles.add("admin");
		
		return roles;
	}
	
}
