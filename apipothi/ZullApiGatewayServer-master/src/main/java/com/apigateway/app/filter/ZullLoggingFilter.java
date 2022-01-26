package com.apigateway.app.filter;
/*
 * Author    : API POTHI
 * YouTube   : https://www.youtube.com/apipothi
 * Web Site  : http://apipothi.com/
 * Play List : MICROSERVICE-SPRINGBOOT
 * JAVA      : 1.8
*/
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZullLoggingFilter extends ZuulFilter {
	
	private final static Logger logger = LoggerFactory.getLogger(ZullLoggingFilter.class);

	//Contains the logic that determines when to run this filter (this particular filter is always run).
	@Override
	public boolean shouldFilter() {
		return true;
	}

	//Contains the functionality of the filter
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("Request -> {} Request Mathod -> {} Request URI-> {}, Request URL-> {}", request, request.getMethod(),
				request.getRequestURI(), request.getRequestURL());
		return null;
	}
	
	// Returns a String that stands for the type of the filter — in this case, pre. 
	//(It would be route for a routing filter.
	@Override
	public String filterType() {
		return "pre";
	}

	// Gives the order in which this filter is to be run, relative to other filters.
	@Override
	public int filterOrder() {
		return 1;
	}

}
