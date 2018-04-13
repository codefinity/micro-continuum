package com.codefinity.microcontinuum.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class CustomZuulFilter extends ZuulFilter{

	@Override
	public Object run() {	
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.getRequest().setAttribute("custom-attribute", "custom-value");
		
		System.out.println("Zuul filter run method");
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
 		return 1;
	}

	@Override
	public String filterType() {
		
	    //pre: filters are executed before the request is routed,
	    //route: filters can handle the actual routing of the request,
	    //post: filters are executed after the request has been routed, and
	    //error: filters execute if an error occurs in the course of handling the request.
		
 		return "pre";
	}

	
}
