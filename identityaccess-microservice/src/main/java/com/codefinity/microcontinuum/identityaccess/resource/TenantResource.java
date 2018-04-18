/*package com.codefinity.microcontinuum.identityaccess.resource;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.xml.ws.Response;

import org.jboss.resteasy.annotations.cache.Cache;

import com.codefinity.microcontinuum.common.media.OvationsMediaType;
import com.codefinity.microcontinuum.common.serializer.ObjectSerializer;
import com.codefinity.microcontinuum.identityaccess.application.ApplicationServiceRegistry;
import com.codefinity.microcontinuum.identityaccess.application.IdentityApplicationService;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.Tenant;

@Path("/tenants")
public class TenantResource {

    public TenantResource() {
        super();
    }

    @GET
    @Path("{tenantId}")
    @Produces({ OvationsMediaType.ID_OVATION_TYPE })
    @Cache(maxAge=3600)
    public Response getTenant(
            @PathParam("tenantId") String aTenantId) {

        Tenant tenant = this.identityApplicationService().tenant(aTenantId);

        if (tenant == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        String tenantRepresentation = ObjectSerializer.instance().serialize(tenant);

        Response response = Response.ok(tenantRepresentation).build();

        return response;
    }

    private IdentityApplicationService identityApplicationService() {
        return ApplicationServiceRegistry.identityApplicationService();
    }
}
*/