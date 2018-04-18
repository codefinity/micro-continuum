package com.codefinity.microcontinuum.identityaccess.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationServiceRegistry implements ApplicationContextAware  {

    private static ApplicationContext applicationContext;

    public static AccessApplicationService accessApplicationService() {
        return (AccessApplicationService) applicationContext.getBean("accessApplicationService");
    }

    public static IdentityApplicationService identityApplicationService() {
        return (IdentityApplicationService) applicationContext.getBean("identityApplicationService");
    }

    public static NotificationApplicationService notificationApplicationService() {
        return (NotificationApplicationService) applicationContext.getBean("notificationApplicationService");
    }

    @Override
    public synchronized void setApplicationContext(
            ApplicationContext anApplicationContext)
    throws BeansException {

        if (ApplicationServiceRegistry.applicationContext == null) {
            ApplicationServiceRegistry.applicationContext = anApplicationContext;
        }
    }
}
