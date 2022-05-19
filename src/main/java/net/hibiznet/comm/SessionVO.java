package net.hibiznet.comm;

import java.io.Serializable;

/**
 * �꽭�뀡 VO �겢�옒�뒪
 * @author 怨듯넻�꽌鍮꾩뒪 媛쒕컻�� 諛뺤��슧
 * @since 2009.03.06
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 媛쒖젙�씠�젰(Modification Information) >>
 * 
 *   �닔�젙�씪      �닔�젙�옄          �닔�젙�궡�슜
 *  -------    --------    ---------------------------
 *  2009.03.06  諛뺤��슧          理쒖큹 �깮�꽦 
 *  
 *  </pre>
 */
@SuppressWarnings("serial")
public class SessionVO implements Serializable {
	
	/** �븘�씠�뵒 */
	private String sUserId;
	/** �씠由� */
	private String sUserNm;
	/** �씠硫붿씪 */
	private String sEmail;
	/** �궗�슜�옄援щ텇 */
	private String sUserSe;
	/** 議곗쭅(遺��꽌)ID */
	private String orgnztId;
	/** 怨좎쑀�븘�씠�뵒 */
	private String uniqId;
	/**
	 * sUserId attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getSUserId() {
		return sUserId;
	}
	/**
	 * sUserId attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param sUserId String
	 */
	public void setSUserId(String userId) {
		sUserId = userId;
	}
	/**
	 * sUserNm attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getSUserNm() {
		return sUserNm;
	}
	/**
	 * sUserNm attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param sUserNm String
	 */
	public void setSUserNm(String userNm) {
		sUserNm = userNm;
	}
	/**
	 * sEmail attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getSEmail() {
		return sEmail;
	}
	/**
	 * sEmail attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param sEmail String
	 */
	public void setSEmail(String email) {
		sEmail = email;
	}
	/**
	 * sUserSe attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getSUserSe() {
		return sUserSe;
	}
	/**
	 * sUserSe attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param sUserSe String
	 */
	public void setSUserSe(String userSe) {
		sUserSe = userSe;
	}
	/**
	 * orgnztId attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getOrgnztId() {
		return orgnztId;
	}
	/**
	 * orgnztId attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param orgnztId String
	 */
	public void setOrgnztId(String orgnztId) {
		this.orgnztId = orgnztId;
	}
	/**
	 * uniqId attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getUniqId() {
		return uniqId;
	}
	/**
	 * uniqId attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param uniqId String
	 */
	public void setUniqId(String uniqId) {
		this.uniqId = uniqId;
	}
}
