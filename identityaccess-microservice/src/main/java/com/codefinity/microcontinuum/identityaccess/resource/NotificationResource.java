/*package com.codefinity.microcontinuum.identityaccess.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codefinity.microcontinuum.common.notification.NotificationLog;
import com.codefinity.microcontinuum.identityaccess.application.representation.NotificationLogRepresentation;

@RequestMapping("/notifications")
public class NotificationResource extends AbstractResource {

    public NotificationResource() {
        super();
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ResponseEntity<NotificationLogRepresentation>  getCurrentNotificationLog(
    		HttpServletRequest request) {

        NotificationLog currentNotificationLog =
            this.notificationApplicationService()
                .currentNotificationLog();
        
        String uriInfo = request.getContextPath();

        if (currentNotificationLog == null) {
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        NotificationLogRepresentation log =
                new NotificationLogRepresentation(currentNotificationLog);


        return new ResponseEntity<NotificationLogRepresentation>(log, HttpStatus.OK);
    }

    @RequestMapping(value="/{notificationId}", method=RequestMethod.GET)
    public ResponseEntity<NotificationLogRepresentation>  getNotificationLog(
    		@PathVariable String notificationId,
    		HttpServletRequest request) {

        NotificationLog notificationLog =
            this.notificationApplicationService()
                .notificationLog(notificationId);

        if (notificationLog == null) {
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        NotificationLogRepresentation log =
                new NotificationLogRepresentation(notificationLog);

        return new ResponseEntity<NotificationLogRepresentation>(log, HttpStatus.OK);
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