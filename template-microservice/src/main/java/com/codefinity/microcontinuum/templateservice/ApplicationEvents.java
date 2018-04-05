package com.codefinity.microcontinuum.templateservice;

import org.springframework.boot.ExitCodeEvent;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.boot.autoconfigure.batch.JobExecutionEvent;
import org.springframework.boot.autoconfigure.jdbc.DataSourceSchemaCreatedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;

@Configuration
public class ApplicationEvents {

	@EventListener(ApplicationReadyEvent.class)
	public void applicationReady() {
		
		System.out.println("Application Ready Event");
		
	}
	
	@EventListener(ApplicationPreparedEvent.class)
	public void applicationPrepared() {
		
		System.out.println("Application Prepared Event");
		
	}
	
	@EventListener(ApplicationStartedEvent.class)
	public void applicationStarted() {
		
		System.out.println("Application Started Event");
		
	}
	
	@EventListener(ApplicationStartingEvent.class)
	public void applicationStarting() {
		
		System.out.println("Application Starting Event");
		
	}
	
	@EventListener(ApplicationEnvironmentPreparedEvent.class)
	public void applicationEnvironmentPrepared() {
		
		System.out.println("Application Environment Prepared Event");
		
	}
	
	@EventListener(ApplicationFailedEvent.class)
	public void applicationFailed() {
		
		System.out.println("Application Failed Event");
		
	}
	
	@EventListener(AuditApplicationEvent.class)
	public void auditApplicationEvent() {
		
		System.out.println("Application Audit Event");
		
	}
	
	@EventListener(JobExecutionEvent.class)
	public void jobExecutionEvent() {
		
		System.out.println("Job Execution Event");
		
	}
	
	@EventListener(ExitCodeEvent.class)
	public void exitCode() {
		
		System.out.println("Exit Code Event");
		
	}
	
	@EventListener(DataSourceSchemaCreatedEvent.class)
	public void dataSourceSchemaCreated() {
		
		System.out.println("Data Source Created Event");
		
	}
	
	@EventListener(ContextClosedEvent.class)
	public void contextClosed() {
		
		System.out.println("Context Closed Event");
		
	}
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshed() {
		
		System.out.println("Context Refreshed Event");
		
	}
	
	@EventListener(ContextStartedEvent.class)
	public void contextStarted() {
		
		System.out.println("Context Started Event");
		
	}
	
	@EventListener(ContextStoppedEvent.class)
	public void contextStoppedEvent() {
		
		System.out.println("Context Stopped Event");
		
	}

	
}
