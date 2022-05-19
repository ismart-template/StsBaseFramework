package net.hibiznet.comm;

/**
 * IncludedInfo annotation�쓣 諛뷀깢�쑝濡� �솕硫댁뿉 �몴�떆�븷 �젙蹂대�� 援ъ꽦�븯湲� �쐞�븳 VO �겢�옒�뒪
 * @author 怨듯넻而댄룷�꼳�듃 �젙吏꾩삤
 * @since 2011.08.26
 * @version 2.0.0
 * @see
 *
 * <pre>
 * << 媛쒖젙�씠�젰(Modification Information) >>
 *   
 *  �닔�젙�씪		�닔�젙�옄		�닔�젙�궡�슜
 *  -------    	--------    ---------------------------
 *  2011.08.26	�젙吏꾩삤 		理쒖큹 �깮�꽦
 *
 * </pre>
 */
public class IncludedCompInfoVO {
	
	private String name;
	private String listUrl;
	private int order;
	private int gid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getListUrl() {
		return listUrl;
	}
	public void setListUrl(String listUrl) {
		this.listUrl = listUrl;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
}
