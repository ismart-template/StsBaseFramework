package net.hibiznet.comm.util;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Utility class  to support to double submit preventer
 * @author Vincent Han
 * @since 2014.08.07
 * @version 1.0
 * @see
 *
 * <pre>
 * << 媛쒖젙�씠�젰(Modification Information) >>
 *   
 *   �닔�젙�씪        �닔�젙�옄       �닔�젙�궡�슜
 *  -------       --------    ---------------------------
 *   2014.08.07	�몴以��봽�젅�엫�썙�겕�꽱�꽣	理쒖큹 �깮�꽦
 *
 * </pre>
 */
public class DoubleSubmitHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(DoubleSubmitHelper.class);
		
	public final static String SESSION_TOKEN_KEY = "egovframework.double.submit.preventer.session.key";
	
	public final static String PARAMETER_NAME = "egovframework.double.submit.preventer.parameter.name";
	
	public final static String DEFAULT_TOKEN_KEY = "DEFAULT";
	
	public static String getNewUUID() {
		return UUID.randomUUID().toString().toUpperCase();
	}
	
	public static boolean checkAndSaveToken() {
		return checkAndSaveToken(DEFAULT_TOKEN_KEY);
	}
	
	public static boolean checkAndSaveToken(String tokenKey) {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		
		// check session...
		if (session.getAttribute(DoubleSubmitHelper.SESSION_TOKEN_KEY) == null) {
			throw new RuntimeException("Double Submit Preventer TagLig isn't set. Check JSP.");
		}

		String parameter = request.getParameter(DoubleSubmitHelper.PARAMETER_NAME);
		
		// check parameter
		if (parameter == null) {
			throw new RuntimeException("Double Submit Preventer parameter isn't set. Check JSP.");
		}
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) session.getAttribute(DoubleSubmitHelper.SESSION_TOKEN_KEY);
		
		if (parameter.equals(map.get(tokenKey))) {
			
			LOGGER.debug("[Double Submit] session token ({}) equals to parameter token.", tokenKey);
			
			map.put(tokenKey, getNewUUID());
			
			return true;
		}

		LOGGER.debug("[Double Submit] session token ({}) isn't equal to parameter token.", tokenKey);
		
		return false;
	}
}
