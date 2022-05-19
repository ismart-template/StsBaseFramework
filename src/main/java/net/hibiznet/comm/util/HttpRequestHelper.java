package net.hibiznet.comm.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Class Name : EgovHttpRequestHelper.java
 * @Description : HTTP Request �젙蹂� 痍⑤뱷 Helper �겢�옒�뒪
 * @Modification Information
 *
 *    �닔�젙�씪         �닔�젙�옄         �닔�젙�궡�슜
 *    -------        -------     -------------------
 *    2014.09.11	�몴以��봽�젅�엫�썙�겕		理쒖큹�깮�꽦
* @author Vincent Han
 * @since 2014.09.11
 * @version 3.5
 * @see <pre>
 * web.xml �긽�뿉 �떎�쓬怨� 媛숈� Listener �벑濡� �븘�슂
 * &lt;listener&gt;
 *	  &lt;listener-class&gt;org.springframework.web.context.request.RequestContextListener&lt;/listener-class&gt;
 * &lt;/listener&gt;
 * </pre>
 */
public class HttpRequestHelper {
	
	public static boolean isInHttpRequest() {
		try {
			getCurrentRequest();
		} catch (IllegalStateException ise) {
			return false;
		}
		
		return true;
	}
	
	public static HttpServletRequest getCurrentRequest() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		
		return sra.getRequest();
	}
	
	public static String getRequestIp() {
		return getCurrentRequest().getRemoteAddr();
	}
	
	public static String getRequestURI() {
		return getCurrentRequest().getRequestURI();
	}
	
	public static HttpSession getCurrentSession() {
		return getCurrentRequest().getSession();
	}
}
