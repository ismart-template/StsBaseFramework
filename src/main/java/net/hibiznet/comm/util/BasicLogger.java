package net.hibiznet.comm.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class  to support to logging information
 * @author Vincent Han
 * @since 2014.09.18
 * @version 1.0
 * @see
 *
 * <pre>
 * << 媛쒖젙�씠�젰(Modification Information) >>
 *   
 *   �닔�젙�씪        �닔�젙�옄       �닔�젙�궡�슜
 *  -------       --------    ---------------------------
 *   2014.09.18	�몴以��봽�젅�엫�썙�겕�꽱�꽣	理쒖큹 �깮�꽦
 *
 * </pre>
 */
public class BasicLogger {
	private static final Level IGNORE_INFO_LEVEL = Level.OFF;
	private static final Level DEBUG_INFO_LEVEL = Level.FINEST;
	private static final Level INFO_INFO_LEVEL = Level.INFO;
	
	private static final Logger ignoreLogger = Logger.getLogger("ignore");
	private static final Logger debugLogger = Logger.getLogger("debug");
	private static final Logger infoLogger = Logger.getLogger("info");
	
	/**
	 * 湲곕줉�씠�굹 泥섎━媛� 遺덊븘�슂�븳 寃쎌슦 �궗�슜.
	 * @param message
	 * @param exception
	 */
	public static void ignore(String message, Exception exception) {
		if (exception == null) {
			ignoreLogger.log(IGNORE_INFO_LEVEL, message);
		} else {
			ignoreLogger.log(IGNORE_INFO_LEVEL, message, exception);
		}
	}
	
	/**
	 * 湲곕줉�씠�굹 泥섎━媛� 遺덊븘�슂�븳 寃쎌슦 �궗�슜.
	 * @param message
	 * @param exception
	 */
	public static void ignore(String message) {
		ignore(message, null);
	}
	
	/**
	 * �뵒踰꾧렇 �젙蹂대�� 湲곕줉�븯�뒗 寃쎌슦 �궗�슜.
	 * @param message
	 * @param exception
	 */
	public static void debug(String message, Exception exception) {
		if (exception == null) {
			debugLogger.log(DEBUG_INFO_LEVEL, message);
		} else {
			debugLogger.log(DEBUG_INFO_LEVEL, message, exception);
		}
	}
	
	/**
	 * �뵒踰꾧렇 �젙蹂대�� 湲곕줉�븯�뒗 寃쎌슦 �궗�슜.
	 * @param message
	 * @param exception
	 */
	public static void debug(String message) {
		debug(message, null);
	}
	
	/**
	 * �씪諛섏쟻�씠 �젙蹂대�� 湲곕줉�븯�뒗 寃쎌슦 �궗�슜.
	 * @param message
	 * @param exception
	 */
	public static void info(String message) {
		infoLogger.log(INFO_INFO_LEVEL, message);
	}
}
