package com.codefinity.microcontinuum.identityaccess.resource;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codefinity.microcontinuum.identityaccess.application.command.AuthenticateUserCommand;
import com.codefinity.microcontinuum.identityaccess.application.representation.UserInRoleRepresentation;
import com.codefinity.microcontinuum.identityaccess.application.representation.UserRepresentation;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.User;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.UserDescriptor;

@RequestMapping("/tenants/{tenantId}/users")
public class UserResource extends AbstractResource {

    public UserResource() {
        super();
    }

    @RequestMapping(value="{username}/autenticatedWith/{password}", method=RequestMethod.GET)
    public ResponseEntity<UserDescriptor> getAuthenticUser(
    		@PathVariable String tenantId,
    		@PathVariable String username,
    		@PathVariable String password) {

        UserDescriptor userDescriptor =
                this.identityApplicationService()
                    .authenticateUser(
                            new AuthenticateUserCommand(
                                    tenantId,
                                    username,
                                    password));

        if (userDescriptor.isNullDescriptor()) {
        	
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<UserDescriptor>(userDescriptor, HttpStatus.OK);
    }

    @RequestMapping(value="/username", method=RequestMethod.GET)
    public ResponseEntity<UserRepresentation> getUser(
    		@PathVariable String tenantId,
    		@PathVariable String username) {

        User user = this.identityApplicationService().user(tenantId, username);

        if (user == null) {
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        UserRepresentation userRepresentation = new UserRepresentation(user);


        return new ResponseEntity<UserRepresentation>(userRepresentation, HttpStatus.OK);
    }

    @RequestMapping(value="/{username}/inRole/{role}", method=RequestMethod.GET)
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
    }

}
