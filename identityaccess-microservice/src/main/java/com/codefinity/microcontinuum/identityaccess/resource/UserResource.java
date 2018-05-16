package com.codefinity.microcontinuum.identityaccess.resource;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codefinity.microcontinuum.identityaccess.application.IdentityApplicationService;
import com.codefinity.microcontinuum.identityaccess.dto.SignInDto;

@RestController
@RequestMapping("/tenants/{tenantid}/users")
public class UserResource extends AbstractResource {

	@Autowired
	private IdentityApplicationService identityApplicationService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
    public UserResource() {
        super();
    }

    @RequestMapping(value="/{tenantId}/authenticate", method=RequestMethod.POST)
    public ResponseEntity<String> getAuthenticUser(
    							@PathVariable String tenantId,
    							@RequestBody SignInDto signInDto) {
    	
    	
    	String username = signInDto.getUsername();
        String password = signInDto.getPassword();
        
        
        //Commented because the DB code is not yet completed.
        //This is skipped for making the token generation code work.
        /*UserDescriptor userDescriptor =
                this.identityApplicationService
                    .authenticateUser(
                            new AuthenticateUserCommand(
                                    tenantId,
                                    username,
                                    password));

        if (userDescriptor.isNullDescriptor()) {
        	
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }*/
        
        
        // throws authenticationException if it fails !
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);

        try {
        	
			String secret = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("secret.key"), Charset.defaultCharset());
		
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int expirationInMinutes = 24*60;

        //String token = generateHMACToken(username, authentication.getAuthorities(), secret, expirationInMinutes);
        
        //Return token
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

    /*@RequestMapping(value="/username", method=RequestMethod.GET)
    public ResponseEntity<UserRepresentation> getUser(
    		@PathVariable String tenantId,
    		@PathVariable String username) {

        User user = this.identityApplicationService().user(tenantId, username);

        if (user == null) {
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        UserRepresentation userRepresentation = new UserRepresentation(user);


        return new ResponseEntity<UserRepresentation>(userRepresentation, HttpStatus.OK);
    }*/

    /*@RequestMapping(value="/{username}/inRole/{role}", method=RequestMethod.GET)
    public ResponseEntity<UserInRoleRepresentation> getUserInRole(
    		@PathVariable String aTenantId,
    		@PathVariable String aUsername,
    		@PathVariable String aRoleName) {


        User user = null;
        UserInRoleRepresentation userInRoleRepresentation = null;

        try {
            user = this.accessApplicationService()
                       .userInRole(
                               aTenantId,
                               aUsername,
                               aRoleName);
        } catch (Exception e) {
            // fall through
        }        

        if (user != null) {
        	userInRoleRepresentation = new UserInRoleRepresentation(user, aRoleName);
        } else {
        	return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<UserInRoleRepresentation>(userInRoleRepresentation, HttpStatus.OK);
    }*/

}
