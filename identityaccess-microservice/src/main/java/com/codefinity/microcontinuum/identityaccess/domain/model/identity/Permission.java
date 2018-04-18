package com.codefinity.microcontinuum.identityaccess.domain.model.identity;

public class Permission {

	// @Id
	// @GeneratedValue
	private Long id;	

	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
