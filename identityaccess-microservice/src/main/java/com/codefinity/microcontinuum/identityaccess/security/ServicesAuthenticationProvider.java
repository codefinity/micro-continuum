package com.codefinity.microcontinuum.identityaccess.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class ServicesAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private ServicesUserDetailsService userManagementService;

	//public UserManagementService getUserService() {
	//	return userManagementService;
	//}

	//public void setUserManagementService(UserManagementService userManagementService) {
	//	this.userManagementService = userManagementService;
	//}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();		
		
		UserDetails user = userManagementService.loadUserByUsername(username);
      

		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.equals(UsernamePasswordAuthenticationToken.class);
	}

}
