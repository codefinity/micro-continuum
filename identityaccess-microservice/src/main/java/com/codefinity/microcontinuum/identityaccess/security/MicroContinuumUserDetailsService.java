package com.codefinity.microcontinuum.identityaccess.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.codefinity.microcontinuum.identityaccess.domain.model.User;
import com.codefinity.microcontinuum.identityaccess.repository.UserRepository;

public class MicroContinuumUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;
	//private final RoleRepository roleRepository;

	@Autowired
	public MicroContinuumUserDetailsService(UserRepository userRepository) {

		this.userRepository = userRepository;
		//this.roleRepository = roleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {

		User user = userRepository.getUserByEmail(email);

		if (null == user) {

			throw new UsernameNotFoundException(
					"No user present with username: " + email);

		} else {

			List<String> roles = userRepository.getRoleByEmail(email);

			return new MicroContinuumUserDetails(user, roles);

		}
	}	

}
