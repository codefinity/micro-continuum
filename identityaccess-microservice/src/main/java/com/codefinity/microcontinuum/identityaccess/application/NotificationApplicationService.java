/*package com.codefinity.microcontinuum.identityaccess.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.notification.NotificationPublisher;
//import org.springframework.transaction.annotation.Transactional;

import com.codefinity.microcontinuum.common.event.EventStore;
import com.codefinity.microcontinuum.common.notification.NotificationLog;
import com.codefinity.microcontinuum.common.notification.NotificationLogFactory;
import com.codefinity.microcontinuum.common.notification.NotificationLogId;

public class NotificationApplicationService {

    @Autowired
    private EventStore eventStore;

    @Autowired
    private NotificationPublisher notificationPublisher;

    public NotificationApplicationService() {
        super();
    }

    //@Transactional(readOnly=true)
    public NotificationLog currentNotificationLog() {
        NotificationLogFactory factory = new NotificationLogFactory(this.eventStore());

        return factory.createCurrentNotificationLog();
    }

    //@Transactional(readOnly=true)
    public NotificationLog notificationLog(String aNotificationLogId) {
        NotificationLogFactory factory = new NotificationLogFactory(this.eventStore());

        return factory.createNotificationLog(new NotificationLogId(aNotificationLogId));
    }

    //@Transactional
    public void publishNotifications() {
    	//
        //this.notificationPublisher().publishNotifications();
    }

    protected EventStore eventStore() {
        return this.eventStore;
    }

    protected NotificationPublisher notificationPublisher() {
        return this.notificationPublisher;
    }
}
*/