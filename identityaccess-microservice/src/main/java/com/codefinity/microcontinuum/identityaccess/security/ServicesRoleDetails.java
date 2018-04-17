package com.codefinity.microcontinuum.identityaccess.security;

import org.springframework.security.core.GrantedAuthority;

import com.codefinity.microcontinuum.identityaccess.domain.model.Role;

public class ServicesRoleDetails implements GrantedAuthority {
	
	private static final long serialVersionUID = 5917454223219488057L;

	private String roleName;

	public ServicesRoleDetails(Role role)
	{
		this.roleName = role.getName();
	}	
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return roleName;
	}
	
}
