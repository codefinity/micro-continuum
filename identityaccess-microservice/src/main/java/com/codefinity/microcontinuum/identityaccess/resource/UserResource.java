/*package com.codefinity.microcontinuum.identityaccess.resource;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.xml.ws.Response;

import com.codefinity.microcontinuum.common.media.OvationsMediaType;
import com.codefinity.microcontinuum.common.serializer.ObjectSerializer;
import com.codefinity.microcontinuum.identityaccess.application.command.AuthenticateUserCommand;
import com.codefinity.microcontinuum.identityaccess.application.representation.UserInRoleRepresentation;
import com.codefinity.microcontinuum.identityaccess.application.representation.UserRepresentation;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.User;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.UserDescriptor;

@Path("/tenants/{tenantId}/users")
public class UserResource extends AbstractResource {

    public UserResource() {
        super();
    }

    @GET
    @Path("{username}/autenticatedWith/{password}")
    @Produces({ OvationsMediaType.ID_OVATION_TYPE })
    public Response getAuthenticUser(
            @PathParam("tenantId") String aTenantId,
            @PathParam("username") String aUsername,
            @PathParam("password") String aPassword,
            @Context Request aRequest) {

        UserDescriptor userDescriptor =
                this.identityApplicationService()
                    .authenticateUser(
                            new AuthenticateUserCommand(
                                    aTenantId,
                                    aUsername,
                                    aPassword));

        if (userDescriptor.isNullDescriptor()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        Response response = this.userDescriptorResponse(aRequest, userDescriptor);

        return response;
    }

    @GET
    @Path("{username}")
    @Produces({ OvationsMediaType.ID_OVATION_TYPE })
    public Response getUser(
            @PathParam("tenantId") String aTenantId,
            @PathParam("username") String aUsername,
            @Context Request aRequest) {

        User user = this.identityApplicationService().user(aTenantId, aUsername);

        if (user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        Response response = this.userResponse(aRequest, user);

        return response;
    }

    @GET
    @Path("{username}/inRole/{role}")
    @Produces({ OvationsMediaType.ID_OVATION_TYPE })
    public Response getUserInRole(
            @PathParam("tenantId") String aTenantId,
            @PathParam("username") String aUsername,
            @PathParam("role") String aRoleName) {

        Response response = null;

        User user = null;

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
            response = this.userInRoleResponse(user, aRoleName);
        } else {
            response = Response.noContent().build();
        }

        return response;
    }

    private Response userDescriptorResponse(
            Request aRequest,
            UserDescriptor aUserDescriptor) {

        Response response = null;

        String representation = ObjectSerializer.instance().serialize(aUserDescriptor);

        response =
            Response
                .ok(representation)
                .cacheControl(this.cacheControlFor(30))
                .build();

        return response;
    }

    private Response userInRoleResponse(User aUser, String aRoleName) {

        UserInRoleRepresentation userInRoleRepresentation =
                new UserInRoleRepresentation(aUser, aRoleName);

        String representation =
                ObjectSerializer
                    .instance()
                    .serialize(userInRoleRepresentation);

        Response response =
                Response
                    .ok(representation)
                    .cacheControl(this.cacheControlFor(60))
                    .build();

        return response;
    }

    private Response userResponse(Request aRequest, User aUser) {

        Response response = null;

        EntityTag eTag = this.userETag(aUser);

        ResponseBuilder conditionalBuilder = aRequest.evaluatePreconditions(eTag);

        if (conditionalBuilder != null) {
            response =
                    conditionalBuilder
                        .cacheControl(this.cacheControlFor(3600))
                        .tag(eTag)
                        .build();
        } else {
            String representation =
                    ObjectSerializer
                        .instance()
                        .serialize(new UserRepresentation(aUser));

            response =
                    Response
                        .ok(representation)
                        .cacheControl(this.cacheControlFor(3600))
                        .tag(eTag)
                        .build();
        }

        return response;
    }
}
*/