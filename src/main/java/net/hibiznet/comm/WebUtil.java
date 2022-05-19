package net.hibiznet.comm;

import java.util.regex.Pattern;

/**
 * 援먯감�젒�냽 �뒪�겕由쏀듃 怨듦꺽 痍⑥빟�꽦 諛⑹�(�뙆�씪誘명꽣 臾몄옄�뿴 援먯껜)
 *
 * <pre>
 * << 媛쒖젙�씠�젰(Modification Information) >>
 *
 *   �닔�젙�씪              �닔�젙�옄           �닔�젙�궡�슜
 *  -----------  --------  ---------------------------
 *   2011.10.10  �븳�꽦怨�           理쒖큹 �깮�꽦
 *	 2017-02-07   �씠�젙��           �떆�걧�뼱肄붾뵫(ES) - �떆�걧�뼱肄붾뵫 寃쎈줈 議곗옉 諛� �옄�썝 �궫�엯[CWE-22, CWE-23, CWE-95, CWE-99]
 *   2018.08.17  �떊�슜�샇           filePathBlackList �닔�젙
 *   2018.10.10  �떊�슜�샇           . => \\.�쑝濡� �닔�젙
 * </pre>
 */

public class WebUtil {
	public static String clearXSSMinimum(String value) {
		if (value == null || value.trim().equals("")) {
			return "";
		}

		String returnValue = value;

		returnValue = returnValue.replaceAll("&", "&amp;");
		returnValue = returnValue.replaceAll("<", "&lt;");
		returnValue = returnValue.replaceAll(">", "&gt;");
		returnValue = returnValue.replaceAll("\"", "&#34;");
		returnValue = returnValue.replaceAll("\'", "&#39;");
		returnValue = returnValue.replaceAll("\\.", "&#46;");
		returnValue = returnValue.replaceAll("%2E", "&#46;");
		returnValue = returnValue.replaceAll("%2F", "&#47;");
		return returnValue;
	}

	public static String clearXSSMaximum(String value) {
		String returnValue = value;
		returnValue = clearXSSMinimum(returnValue);

		returnValue = returnValue.replaceAll("%00", null);

		returnValue = returnValue.replaceAll("%", "&#37;");

		// \\. => .

		returnValue = returnValue.replaceAll("\\.\\./", ""); // ../
		returnValue = returnValue.replaceAll("\\.\\.\\\\", ""); // ..\
		returnValue = returnValue.replaceAll("\\./", ""); // ./
		returnValue = returnValue.replaceAll("%2F", "");

		return returnValue;
	}

	public static String filePathBlackList(String value) {
		String returnValue = value;
		if (returnValue == null || returnValue.trim().equals("")) {
			return "";
		}

		returnValue = returnValue.replaceAll("\\.\\.", "");

		return returnValue;
	}

	/**
	 * �뻾�븞遺� 蹂댁븞痍⑥빟�젏 �젏寃� 議곗튂 諛⑹븞.
	 *
	 * @param value
	 * @return
	 */
	public static String filePathReplaceAll(String value) {
		String returnValue = value;
		if (returnValue == null || returnValue.trim().equals("")) {
			return "";
		}

		returnValue = returnValue.replaceAll("/", "");
		returnValue = returnValue.replaceAll("\\", "");
		returnValue = returnValue.replaceAll("\\.\\.", ""); // ..
		returnValue = returnValue.replaceAll("&", "");

		return returnValue;
	}

	public static String fileInjectPathReplaceAll(String value) {
		String returnValue = value;
		if (returnValue == null || returnValue.trim().equals("")) {
			return "";
		}

		returnValue = returnValue.replaceAll("/", "");
		returnValue = returnValue.replaceAll("\\..", ""); // ..
		returnValue = returnValue.replaceAll("\\\\", "");// \
		returnValue = returnValue.replaceAll("&", "");

		return returnValue;
	}

	public static String filePathWhiteList(String value) {
		return value;
	}

	public static boolean isIPAddress(String str) {
		Pattern ipPattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");

		return ipPattern.matcher(str).matches();
	}

	public static String removeCRLF(String parameter) {
		return parameter.replaceAll("\r", "").replaceAll("\n", "");
	}

	public static String removeSQLInjectionRisk(String parameter) {
		return parameter.replaceAll("\\p{Space}", "").replaceAll("\\*", "").replaceAll("%", "").replaceAll(";", "")
			.replaceAll("-", "").replaceAll("\\+", "").replaceAll(",", "");
	}

	public static String removeOSCmdRisk(String parameter) {
		return parameter.replaceAll("\\p{Space}", "").replaceAll("\\*", "").replaceAll("|", "").replaceAll(";", "");
	}

	/**
	 * LDAP �뙆�씪誘명꽣�뿉�꽌 �듅�닔臾몄옄 �젣嫄�.
	 * �뙆�씪誘명꽣 蹂꾨줈 �젣嫄곕�� �빐�빞 �븿.
	 * �씪愿� �뿰寃곕맂 �뙆�씪誘명꽣�뱾�� �뵲濡� 泥섎━�빐�빞 �븿.
	 * TODO : LDAP Injection Prevent 濡쒖쭅 異붽� �븘�슂
	 * @param value
	 * @return
	 */
	public static String removeLDAPInjectionRisk(String value) {

		String returnValue = value;
		if (returnValue == null || returnValue.trim().equals("")) {
			return "";
		}

		/*紐⑤뱺 �듅�닔臾몄옄 �젣嫄�*/
//		String match = "[^\uAC00-\uD7A30-9a-zA-Z]";//�듅�닔臾몄옄 = �븳湲�,�닽�옄,�쁺臾� �젣�쇅
//		returnValue = returnValue.replaceAll(match, "");

		/*�듅�닔臾몄옄 �꽑�깮�쟻 �젣嫄�*/
		returnValue = returnValue.replaceAll("*", "");
		returnValue = returnValue.replaceAll("&", "");
		returnValue = returnValue.replaceAll("|", "");
		returnValue = returnValue.replaceAll("//", "");
		//...
		//媛쒕퀎濡� �븘�슂�븳 �빆紐⑸뱾 異붽� �븘�슂

		return returnValue;
	}

}