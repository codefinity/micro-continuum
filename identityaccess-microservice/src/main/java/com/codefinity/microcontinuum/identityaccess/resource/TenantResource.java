package com.codefinity.microcontinuum.identityaccess.resource;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codefinity.microcontinuum.identityaccess.application.ApplicationServiceRegistry;
import com.codefinity.microcontinuum.identityaccess.application.IdentityApplicationService;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.Tenant;

@RequestMapping("/tenants")
public class TenantResource {

    public TenantResource() {
        super();
    }

    @RequestMapping(value="/{tenantId}", method=RequestMethod.GET)
    public ResponseEntity<Tenant>  getTenant(
            @PathParam("tenantId") String aTenantId) {

        Tenant tenant = this.identityApplicationService().tenant(aTenantId);

        if (tenant == null) {
        	
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Tenant>(tenant, HttpStatus.OK);
    }

    private IdentityApplicationService identityApplicationService() {
        return ApplicationServiceRegistry.identityApplicationService();
    }
}
