package com.codefinity.microcontinuum.identityaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableAutoConfiguration
//@EnableDiscoveryClient
//OAuth client and server annotations. Not working.
//@EnableResourceServer
//@EnableAuthorizationServer
@ComponentScan(basePackages = {"com.codefinity.microcontinuum"})
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
