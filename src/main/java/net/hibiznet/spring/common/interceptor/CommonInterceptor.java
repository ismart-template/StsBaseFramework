package net.hibiznet.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter {
	
	protected Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //if (logger.isDebugEnabled()) {
        	logger.debug("===================       START       ===================");
        	System.out.println("===================       START       ===================");
        	logger.debug(" Request URI \t:  " + request.getRequestURI());
        	System.out.println(" Request URI \t:  " + request.getRequestURI());
        //}
        return super.preHandle(request, response, handler);
    }

	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        //if (logger.isDebugEnabled()) {
        	logger.debug("===================        END        ===================\n");
        	System.out.println("===================        END        ===================\n");
        //}
    }

}
