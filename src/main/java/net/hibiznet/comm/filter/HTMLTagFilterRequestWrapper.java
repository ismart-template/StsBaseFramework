/*
 * Copyright 2008-2009 MOPAS(MINISTRY OF SECURITY AND PUBLIC ADMINISTRATION).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hibiznet.comm.filter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
*
* HTMLTagFilterRequestWrapper 
* @author 怨듯넻而댄룷�꼳�듃 �� �떊�슜�샇
* @since 2018.03.21
* @version 1.0
* @see
*
* <pre>
* << 媛쒖젙�씠�젰(Modification Information) >>
*
*   �닔�젙�씪              �닔�젙�옄              �닔�젙�궡�슜
*  -------      --------    ---------------------------
*   2018.03.21  �떊�슜�샇              getParameterMap()援ы쁽 異붽�
*   2019.01.31  �떊�슜�샇              whiteList �깭洹� 異붽�
*
*/

public class HTMLTagFilterRequestWrapper extends HttpServletRequestWrapper {

	// Tag �솕�씠�듃 由ъ뒪�듃 ( �뿀�슜�븷 �깭洹� �벑濡� )
	static private String[] whiteListTag = { "<p>","</p>","<br />" };
	
	public HTMLTagFilterRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	public String[] getParameterValues(String parameter) {

		String[] values = super.getParameterValues(parameter);
		
		if(values==null){
			return null;			
		}
		
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				values[i] = getSafeParamData(values[i]);
				//System.out.println( "[HTMLTagFilter getParameterValues] "+ parameter + "===>>>"+values[i] );
			} else {
				values[i] = null;
			}
		}

		return values;
	}

	public String getParameter(String parameter) {
		
		String value = super.getParameter(parameter);
		
		if(value==null){
			return null;
		}
		
		value = getSafeParamData(value);
		//System.out.println( "[HTMLTagFilter getParameter] "+ parameter + "===>>>"+value );
		return value;
	}

	/**
	 * Map�쑝濡� 諛붿씤�뵫�맂 寃쎌슦瑜� 泥섎━�븳�떎.
	 *
	 * @return  Map - String Type Key / String諛곗뿴���엯 媛�
	 */
    public Map<String, String[]> getParameterMap() {
    	Map<String, String[]> valueMap = super.getParameterMap();

    	String[] values;
    	for( String key : valueMap.keySet() ){
    		values = valueMap.get(key);

    		for (int i = 0; i < values.length; i++) {			
    			if (values[i] != null) {				
    				values[i] = getSafeParamData(values[i]);
    				//System.out.println( "[HTMLTagFilter getParameterMap] "+ key + "===>>>"+values[i] );
    			} else {
    				values[i] = null;
    			}
    		}
    		
            //System.out.println( String.format("�궎 : %s, 媛� : %s", key, valueMap.get(key)) );
        }

    	return valueMap;
    }
    
	private String getSafeParamData(String value) {
		StringBuffer strBuff = new StringBuffer();

		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			switch (c) {
			case '<':
				if ( checkNextWhiteListTag(i, value) == false )
					strBuff.append("&lt;");
				else 
					strBuff.append(c);
				//System.out.println("checkNextWhiteListTag = "+checkNextWhiteListTag(i, value));
				break;
			case '>':
				if ( checkPrevWhiteListTag(i, value) == false )
					strBuff.append("&gt;");
				else 
					strBuff.append(c);
				//System.out.println("checkPrevWhiteListTag = "+checkPrevWhiteListTag(i, value));
				break;
			//case '&':
			//	strBuff.append("&amp;");
			//	break;
			case '"':
				strBuff.append("&quot;");
				break;
			case '\'':
				strBuff.append("&apos;");
				break;	
			default:
				strBuff.append(c);
				break;
			}
		}
		
		value = strBuff.toString();
		return value;
	}

	private boolean checkNextWhiteListTag(int index, String data) {
		String extractData = "";
		//int beginIndex = 0;
		int endIndex = 0;
		for(String whiteListData: whiteListTag) {
		    //System.out.println("===>>> whiteListData="+whiteListData);
			endIndex = index+whiteListData.length();
		    if ( data.length() > endIndex )
		    	extractData = data.substring(index, endIndex);
		    else
		    	extractData = "";
		    //System.out.println("extractData="+extractData);
		    if ( whiteListData.equals(extractData) ) return true; // whiteList ���긽�쑝濡� �뙋�젙
		}
		
		return false;
	}
	
	private boolean checkPrevWhiteListTag(int index, String data) {
		String extractData = "";
		int beginIndex = 0;
		int endIndex = 0;
		for(String whiteListData: whiteListTag) {
		    //System.out.println("===>>> whiteListData="+whiteListData);
			beginIndex = index-whiteListData.length()+1;
			endIndex = index+1;
		    //System.out.println("  range ["+beginIndex+" ~ "+endIndex+"]");
		    if ( beginIndex >= 0 )
		    	extractData = data.substring(beginIndex, endIndex);
		    else
		    	extractData = "";
		    //System.out.println("extractData="+extractData);
		    if ( whiteListData.equals(extractData) ) return true; // whiteList ���긽�쑝濡� �뙋�젙
		}
		
		return false;
	}

}