package net.hibiznet.comm;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 硫붿떆吏� 由ъ냼�뒪 �궗�슜�쓣 �쐞�븳 MessageSource �씤�꽣�럹�씠�뒪 諛� ReloadableResourceBundleMessageSource �겢�옒�뒪�쓽 援ы쁽泥�
 * @author 怨듯넻�꽌鍮꾩뒪 媛쒕컻�� �씠臾몄�
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 媛쒖젙�씠�젰(Modification Information) >>
 *   
 *   �닔�젙�씪      �닔�젙�옄           �닔�젙�궡�슜
 *  -------    --------    ---------------------------
 *   2009.03.11  �씠臾몄�          理쒖큹 �깮�꽦
 *   2017.07.21  �옣�룞�븳 			args, locale �꽕�젙
 *
 * </pre>
 */

public class CommonMessageSource extends ReloadableResourceBundleMessageSource implements MessageSource {

	private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

	/**
	 * getReloadableResourceBundleMessageSource() 
	 * @param reloadableResourceBundleMessageSource - resource MessageSource
	 * @return ReloadableResourceBundleMessageSource
	 */	
	public void setReloadableResourceBundleMessageSource(ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource) {
		this.reloadableResourceBundleMessageSource = reloadableResourceBundleMessageSource;
	}
	
	/**
	 * getReloadableResourceBundleMessageSource() 
	 * @return ReloadableResourceBundleMessageSource
	 */	
	public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource() {
		return reloadableResourceBundleMessageSource;
	}
	
	/**
	 * �젙�쓽�맂 硫붿꽭吏� 議고쉶
	 * @param code - 硫붿꽭吏� 肄붾뱶
	 * @return String
	 */	
	public String getMessage(String code) {
		return getReloadableResourceBundleMessageSource().getMessage(code, null, Locale.getDefault());
	}
	
	/**
	 * �젙�쓽�맂 硫붿꽭吏� 議고쉶
	 * @param code - 硫붿꽭吏� 肄붾뱶
	 * @param locale - 濡쒖��씪
	 * @return String
	 */	
	public String getMessage(String code, Locale locale) {
		return getReloadableResourceBundleMessageSource().getMessage(code, null, locale);
	}
	
	/**
	 * �젙�쓽�맂 硫붿꽭吏� 議고쉶
	 * @param code - 硫붿꽭吏� 肄붾뱶
	 * @param args - 留ㅺ컻蹂��닔
	 * @return String
	 */	
	public String getMessageArgs(String code, Object[] args) {
		return getReloadableResourceBundleMessageSource().getMessage(code, args, Locale.getDefault());
	}
	
	/**
	 * �젙�쓽�맂 硫붿꽭吏� 議고쉶
	 * @param code - 硫붿꽭吏� 肄붾뱶
	 * @param args - 留ㅺ컻蹂��닔
	 * @param locale - 濡쒖��씪
	 * @return String
	 */	
	public String getMessageArgsLocale(String code, Object[] args, Locale locale) {
		return getReloadableResourceBundleMessageSource().getMessage(code, args, locale);
	}

}
