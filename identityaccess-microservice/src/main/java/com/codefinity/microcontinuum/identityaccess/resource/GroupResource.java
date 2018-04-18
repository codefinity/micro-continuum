/*package com.codefinity.microcontinuum.identityaccess.resource;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.xml.ws.Response;

import com.codefinity.microcontinuum.common.media.OvationsMediaType;
import com.codefinity.microcontinuum.common.serializer.ObjectSerializer;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.Group;

@Path("/tenants/{tenantId}/groups")
public class GroupResource extends AbstractResource {

    public GroupResource() {
        super();
    }

    @GET
    @Path("{groupName}")
    @Produces({ OvationsMediaType.ID_OVATION_TYPE })
    public Response getGroup(
            @PathParam("tenantId") String aTenantId,
            @PathParam("groupName") String aGroupName,
            @Context Request aRequest) {

        Group group =
                this.identityApplicationService()
                    .group(aTenantId, aGroupName);

        if (group == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        Response response = this.groupResponse(aRequest, group);

        return response;
    }

    private Response groupResponse(
            Request aRequest,
            Group aGroup) {

        Response response = null;

        String representation = ObjectSerializer.instance().serialize(aGroup);

        response =
            Response
                .ok(representation)
                .cacheControl(this.cacheControlFor(30))
                .build();

        return response;
    }
}
*/