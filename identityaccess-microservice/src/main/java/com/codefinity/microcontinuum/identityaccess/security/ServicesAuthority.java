package com.codefinity.microcontinuum.identityaccess.security;

import org.springframework.security.core.GrantedAuthority;

public class ServicesAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	private String authority;

	public ServicesAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	@Override
	public int hashCode() {
		return authority.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof ServicesAuthority))
			return false;
		return ((ServicesAuthority) obj).getAuthority().equals(authority);
	}

}
