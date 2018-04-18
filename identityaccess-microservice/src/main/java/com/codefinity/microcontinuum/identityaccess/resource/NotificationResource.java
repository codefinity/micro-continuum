/*package com.codefinity.microcontinuum.identityaccess.resource;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.ws.Response;

import org.springframework.web.util.UriBuilder;

import com.codefinity.microcontinuum.common.media.Link;
import com.codefinity.microcontinuum.common.media.OvationsMediaType;
import com.codefinity.microcontinuum.common.notification.NotificationLog;
import com.codefinity.microcontinuum.common.serializer.ObjectSerializer;
import com.codefinity.microcontinuum.identityaccess.application.representation.NotificationLogRepresentation;

@Path("/notifications")
public class NotificationResource extends AbstractResource {

    public NotificationResource() {
        super();
    }

    @GET
    @Produces({ OvationsMediaType.ID_OVATION_TYPE })
    public Response getCurrentNotificationLog(
            @Context UriInfo aUriInfo) {

        NotificationLog currentNotificationLog =
            this.notificationApplicationService()
                .currentNotificationLog();

        if (currentNotificationLog == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        Response response =
            this.currentNotificationLogResponse(
                    currentNotificationLog,
                    aUriInfo);

        return response;
    }

    @GET
    @Path("{notificationId}")
    @Produces({ OvationsMediaType.ID_OVATION_TYPE })
    public Response getNotificationLog(
            @PathParam("notificationId") String aNotificationId,
            @Context UriInfo aUriInfo) {

        NotificationLog notificationLog =
            this.notificationApplicationService()
                .notificationLog(aNotificationId);

        if (notificationLog == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        Response response =
            this.notificationLogResponse(
                    notificationLog,
                    aUriInfo);

        return response;
    }

    private Response currentNotificationLogResponse(
            NotificationLog aCurrentNotificationLog,
            UriInfo aUriInfo) {

        NotificationLogRepresentation log =
            new NotificationLogRepresentation(aCurrentNotificationLog);

        log.setLinkSelf(
                this.selfLink(aCurrentNotificationLog, aUriInfo));

        log.setLinkPrevious(
            this.previousLink(aCurrentNotificationLog, aUriInfo));

        String serializedLog = ObjectSerializer.instance().serialize(log);

        Response response =
            Response
                .ok(serializedLog)
                .cacheControl(this.cacheControlFor(60))
                .build();

        return response;
    }

    private Response notificationLogResponse(
            NotificationLog aNotificationLog,
            UriInfo aUriInfo) {

        NotificationLogRepresentation log =
            new NotificationLogRepresentation(aNotificationLog);

        log.setLinkSelf(this.selfLink(aNotificationLog, aUriInfo));

        log.setLinkNext(this.nextLink(aNotificationLog, aUriInfo));

        log.setLinkPrevious(this.previousLink(aNotificationLog, aUriInfo));

        String serializedLog = ObjectSerializer.instance().serialize(log);

        Response response =
            Response
                .ok(serializedLog)
                .cacheControl(this.cacheControlFor(3600))
                .build();

        return response;
    }

    private Link linkFor(
            String aRelationship,
            String anId,
            UriInfo aUriInfo) {

        Link link = null;

        if (anId != null) {

            UriBuilder builder = aUriInfo.getBaseUriBuilder();

            String linkUrl =
                builder
                    .path("notifications")
                    .path(anId)
                    .build()
                    .toString();

            link = new Link(
                    linkUrl,
                    aRelationship,
                    null,
                    OvationsMediaType.ID_OVATION_TYPE);
        }

        return link;
    }

    private Link nextLink(
            NotificationLog aNotificationLog,
            UriInfo aUriInfo) {
        return
            this.linkFor(
                    "next",
                    aNotificationLog.nextNotificationLogId(),
                    aUriInfo);
    }

    private Link previousLink(
            NotificationLog aNotificationLog,
            UriInfo aUriInfo) {

        return
            this.linkFor(
                    "previous",
                    aNotificationLog.previousNotificationLogId(),
                    aUriInfo);
    }

    private Link selfLink(
            NotificationLog aNotificationLog,
            UriInfo aUriInfo) {
        return
            this.linkFor(
                    "self",
                    aNotificationLog.notificationLogId(),
                    aUriInfo);
    }
}
*/