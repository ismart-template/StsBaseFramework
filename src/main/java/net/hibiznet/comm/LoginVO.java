package net.hibiznet.comm;

import java.io.Serializable;

/**
 * @Class Name : LoginVO.java
 * @Description : Login VO class
 * @Modification Information
 * @
 * @  �닔�젙�씪         �닔�젙�옄                   �닔�젙�궡�슜
 * @ -------    --------    ---------------------------
 * @ 2009.03.03		諛뺤��슧		理쒖큹 �깮�꽦
 * @ 2021.05.30		�젙吏꾩삤		�뵒吏��꽭�썝�뙣�뒪 �궗�슜�옄�궎/�꽭�뀡媛� 異붽�
 *
 *  @author 怨듯넻�꽌鍮꾩뒪 媛쒕컻�� 諛뺤��슧
 *  @since 2009.03.03
 *  @version 1.0
 *  @see
 *  
 */
public class LoginVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8274004534207618049L;
	
	/** �븘�씠�뵒 */
	private String id;
	/** �씠由� */
	private String name;
	/** 二쇰�쇰벑濡앸쾲�샇 */
	private String ihidNum;
	/** �씠硫붿씪二쇱냼 */
	private String email;
	/** 鍮꾨�踰덊샇 */
	private String password;
	/** 鍮꾨�踰덊샇 �엺�듃 */
	private String passwordHint;
	/** 鍮꾨�踰덊샇 �젙�떟 */
	private String passwordCnsr;
	/** �궗�슜�옄援щ텇 */
	private String userSe;
	/** 議곗쭅(遺��꽌)ID */
	private String orgnztId;
	/** 議곗쭅(遺��꽌)紐� */
	private String orgnztNm;
	/** 怨좎쑀�븘�씠�뵒 */
	private String uniqId;
	/** 濡쒓렇�씤 �썑 �씠�룞�븷 �럹�씠吏� */
	private String url;
	/** �궗�슜�옄 IP�젙蹂� */
	private String ip;
	/** GPKI�씤利� DN */
	private String dn;
	/** �뵒吏��꽭�썝�뙣�뒪 �궗�슜�옄�궎 */
	private String onepassUserkey;
	/** �뵒吏��꽭�썝�뙣�뒪 �궗�슜�옄�꽭�뀡媛� */
	private String onepassIntfToken;

	/**
	 * id attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getId() {
		return id;
	}
	/**
	 * id attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param id String
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * name attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getName() {
		return name;
	}
	/**
	 * name attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ihidNum attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getIhidNum() {
		return ihidNum;
	}
	/**
	 * ihidNum attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param ihidNum String
	 */
	public void setIhidNum(String ihidNum) {
		this.ihidNum = ihidNum;
	}
	/**
	 * email attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * email attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param email String
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * password attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * password attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param password String
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * passwordHint attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getPasswordHint() {
		return passwordHint;
	}
	/**
	 * passwordHint attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param passwordHint String
	 */
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}
	/**
	 * passwordCnsr attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getPasswordCnsr() {
		return passwordCnsr;
	}
	/**
	 * passwordCnsr attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param passwordCnsr String
	 */
	public void setPasswordCnsr(String passwordCnsr) {
		this.passwordCnsr = passwordCnsr;
	}
	/**
	 * userSe attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getUserSe() {
		return userSe;
	}
	/**
	 * userSe attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param userSe String
	 */
	public void setUserSe(String userSe) {
		this.userSe = userSe;
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
	/**
	 * url attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * url attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param url String
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * ip attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * ip attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param ip String
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * dn attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getDn() {
		return dn;
	}
	/**
	 * dn attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param dn String
	 */
	public void setDn(String dn) {
		this.dn = dn;
	}
	/**
	 * @return the orgnztNm
	 */
	public String getOrgnztNm() {
		return orgnztNm;
	}
	/**
	 * @param orgnztNm the orgnztNm to set
	 */
	public void setOrgnztNm(String orgnztNm) {
		this.orgnztNm = orgnztNm;
	}
	
	/**
	 * �뵒吏��꽭�썝�뙣�뒪 �궗�슜�옄�궎瑜� 由ы꽩�븳�떎.
	 * @return onepassUserkey
	 */
	public String getOnepassUserkey() {
		return onepassUserkey;
	}
	/**
	 * �뵒吏��꽭�썝�뙣�뒪 �궗�슜�옄�궎瑜� �꽕�젙�븳�떎.
	 * @param onepassUserkey
	 */
	public void setOnepassUserkey(String onepassUserkey) {
		this.onepassUserkey = onepassUserkey;
	}
	/**
	 * �뵒吏��꽭�썝�뙣�뒪 �궗�슜�옄�꽭�뀡媛믪쓣 由ы꽩�븳�떎.
	 * @return
	 */
	public String getOnepassIntfToken() {
		return onepassIntfToken;
	}
	/**
	 * �뵒吏��꽭�썝�뙣�뒪 �궗�슜�옄�꽭�뀡媛믪쓣 �꽕�젙�븳�떎.
	 * @param onepassIntfToken
	 */
	public void setOnepassIntfToken(String onepassIntfToken) {
		this.onepassIntfToken = onepassIntfToken;
	}

}
