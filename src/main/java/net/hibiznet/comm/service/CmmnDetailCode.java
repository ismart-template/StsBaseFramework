package net.hibiznet.comm.service;

import java.io.Serializable;

/**
 * 공통상세코드 모델 클래스
 * @author 공통서비스 개발팀 이중호
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.01  이중호          최초 생성
 *   2017.09.07	이정은		표준프레임워크 v3.7 개선(clCode 추가)
 *
 * </pre>
 */
public class CmmnDetailCode implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * 遺꾨쪟肄붾뱶
	 */
	private String clCode = "";

	/*
	 * 肄붾뱶ID
	 */
    private String codeId = "";

    /*
     * 肄붾뱶ID紐�
     */
    private String codeIdNm = "";

    /*
     * �긽�꽭肄붾뱶
     */
	private String code = "";

	/*
	 * �긽�꽭肄붾뱶紐�
	 */
    private String codeNm = "";

    /*
     * �긽�꽭肄붾뱶�꽕紐�
     */
    private String codeDc = "";

    /*
     * �궗�슜�뿬遺�
     */
    private String useAt = "";

    /*
     * 理쒖큹�벑濡앹옄ID
     */
    private String frstRegisterId = "";

    /*
     * 理쒖쥌�닔�젙�옄ID
     */
    private String lastUpdusrId   = "";


    /**
     * clCode attribute 瑜� 由ы꽩�븳�떎.
     * @return String
     */
    public String getClCode() {
    	return clCode;
    }
    
    /**
     * clCode attribute 媛믪쓣 �꽕�젙�븳�떎.
     * @param clCode String
     */
    public void setClCode(String clCode) {
    	this.clCode = clCode;
    }

    /**
	 * codeId attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getCodeId() {
		return codeId;
	}

	/**
	 * codeId attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param codeId String
	 */
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	/**
	 * codeIdNm attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getCodeIdNm() {
		return codeIdNm;
	}

	/**
	 * codeIdNm attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param codeIdNm String
	 */
	public void setCodeIdNm(String codeIdNm) {
		this.codeIdNm = codeIdNm;
	}

	/**
	 * code attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * code attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param code String
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * codeNm attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getCodeNm() {
		return codeNm;
	}

	/**
	 * codeNm attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param codeNm String
	 */
	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}

	/**
	 * codeDc attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getCodeDc() {
		return codeDc;
	}

	/**
	 * codeDc attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param codeDc String
	 */
	public void setCodeDc(String codeDc) {
		this.codeDc = codeDc;
	}

	/**
	 * useAt attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getUseAt() {
		return useAt;
	}

	/**
	 * useAt attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param useAt String
	 */
	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	/**
	 * frstRegisterId attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getFrstRegisterId() {
		return frstRegisterId;
	}

	/**
	 * frstRegisterId attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param frstRegisterId String
	 */
	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	/**
	 * lastUpdusrId attribute 瑜� 由ы꽩�븳�떎.
	 * @return String
	 */
	public String getLastUpdusrId() {
		return lastUpdusrId;
	}

	/**
	 * lastUpdusrId attribute 媛믪쓣 �꽕�젙�븳�떎.
	 * @param lastUpdusrId String
	 */
	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}


}
