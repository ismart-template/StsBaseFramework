package net.hibiznet.comm.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.AntPathMatcher;

import net.hibiznet.comm.WebUtil;


/**
 * @Class Name : UrlRewriteFilter.java
 * @Description : UrlRewriteFilter Class
 * @Modification Information
 * @
 * @ �닔�젙�씪               �닔�젙�옄              �닔�젙�궡�슜
 * @ ----------   ---------   -------------------------------
 * @ 2014.09.30               理쒖큹�깮�꽦
 * @ 2020.11.02   �떊�슜�샇              KISA 蹂댁븞�빟�젏 議곗튂 (CRLF �젣嫄� 議곗튂)
 *
 * @author �쟾�옄�젙遺� �몴以��봽�젅�엫�썙�겕 �쑀吏�蹂댁닔
 * @since 2014. 09.30
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public class UrlRewriteFilter implements Filter {

	@SuppressWarnings("unused")
	private FilterConfig config;

	private String targetURI;
	private String httpsPort;
	private String httpPort;

	private String[] uriPatterns;

    @Override
    public void init(FilterConfig config) throws ServletException {

    	String delimiter = ",";
		this.config = config;

		this.targetURI = config.getInitParameter("targetURI");
		this.httpsPort = config.getInitParameter("httpsPort");
		this.httpPort = config.getInitParameter("httpPort");

		this.uriPatterns = targetURI.split(delimiter);

    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		String getProtocol = req.getScheme();
		String getDomain = req.getServerName();

		AntPathMatcher pm = new AntPathMatcher();

		for (String uriPattern : uriPatterns) {

			if (pm.match(uriPattern.trim(), uri)) {

				 if (getProtocol.toLowerCase().equals("http")) {

					 response.setContentType("text/html");

					 String httpsPath = "https" + "://" + getDomain + ":" + httpsPort + uri;
					 String site = new String(httpsPath);
					 res.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
					 res.setHeader("Location", WebUtil.removeCRLF(site));

				 }

			}else if(getProtocol.toLowerCase().equals("https")){

				response.setContentType("text/html");

				String httpPath = "http" + "://" + getDomain + ":" + httpPort + uri;

				String site = new String(httpPath);
				res.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
				res.setHeader("Location", WebUtil.removeCRLF(site));

			}
		}

		chain.doFilter(req, res);

	}

    @Override
    public void destroy() {
    	this.targetURI = null;
    	this.httpsPort = null;
		this.httpPort = null;
		this.uriPatterns = null;
    }

}
