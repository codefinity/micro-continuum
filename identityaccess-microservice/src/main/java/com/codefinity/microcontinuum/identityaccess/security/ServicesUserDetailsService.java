package com.codefinity.microcontinuum.identityaccess.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ServicesUserDetailsService implements UserDetailsService {
	
	//private final UserRepository userRepository;
	//private final RoleRepository roleRepository;

	/*@Autowired
	public ServicesUserDetailsService(UserRepository userRepository) {

		//this.userRepository = userRepository;
		//this.roleRepository = roleRepository;
	}*/

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {

		//User user = userRepository.getUserByEmail(email);

		/*if (null == user) {

			throw new UsernameNotFoundException(
					"No user present with username: " + email);

		} else {

			List<String> roles = userRepository.getRoleByEmail(email);

			return new ServicesUserDetails(user, roles);

		}*/
		
		return null;
	}	

}
