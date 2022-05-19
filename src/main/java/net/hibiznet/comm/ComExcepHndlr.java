package net.hibiznet.comm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Class Name : EgovComExcepHndlr.java
 * @Description : 怨듯넻�꽌鍮꾩뒪�쓽 exception 泥섎━ �겢�옒�뒪
 * @Modification Information
 *
 *    �닔�젙�씪       �닔�젙�옄         �닔�젙�궡�슜
 *    -------        -------     -------------------
 *    2009. 3. 13.     �씠�궪�꽠
 *
 * @author 怨듯넻 �꽌鍮꾩뒪 媛쒕컻�� �씠�궪�꽠
 * @since 2009. 3. 13.
 * @version
 * @see
 *
 */
public class ComExcepHndlr {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComExcepHndlr.class);

    /*
    @Resource(name = "otherSSLMailSender")
    private SimpleSSLMail mailSender;
     */
    /**
     * 諛쒖깮�맂 Exception�쓣 泥섎━�븳�떎.
     */
    public void occur(Exception ex, String packageName) {
    	//log.debug(" EgovServiceExceptionHandler run...............");
    	
    	/*
		try {
			mailSender. send(ex, packageName);
			log.debug(" sending a alert mail  is completed ");		
		} catch (Exception e) {
			LOGGER.error(packageName, ex);
		}
		*/
		
    	LOGGER.error(packageName, ex);
	}
}
