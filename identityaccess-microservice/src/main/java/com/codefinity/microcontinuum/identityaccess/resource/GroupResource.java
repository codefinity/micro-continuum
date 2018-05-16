/*package com.codefinity.microcontinuum.identityaccess.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codefinity.microcontinuum.identityaccess.domain.model.identity.Group;

@RequestMapping("/tenants/{tenantId}/groups")
public class GroupResource extends AbstractResource {

    public GroupResource() {
        super();
    }

    @RequestMapping(value="/groupName", method=RequestMethod.GET)
    public ResponseEntity<Group> getGroup(
    		@PathVariable String tenantId,
    		@PathVariable String groupName) {

        Group group =
                this.identityApplicationService()
                    .group(tenantId, groupName);

        if (group == null) {
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Group>(group, HttpStatus.OK);
    }

}
*/