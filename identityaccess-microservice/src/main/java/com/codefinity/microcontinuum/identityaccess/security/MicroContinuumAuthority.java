package com.codefinity.microcontinuum.identityaccess.security;

import org.springframework.security.core.GrantedAuthority;

public class MicroContinuumAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	private String authority;

	public MicroContinuumAuthority(String authority) {
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
		if (!(obj instanceof MicroContinuumAuthority))
			return false;
		return ((MicroContinuumAuthority) obj).getAuthority().equals(authority);
	}

}
