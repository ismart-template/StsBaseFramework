package net.hibiznet.comm.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * EgovMybaitsUtil �겢�옒�뒪
 *
 * @author �옣�룞�븳
 * @since 2016.06.07
 * @version 1.0
 * @see
 *
 * <pre>
 * << 媛쒖젙�씠�젰(Modification Information) >>
 *
 *   �닔�젙�씪        �닔�젙�옄           �닔�젙�궡�슜
 *  -------      -------------  ----------------------
 *   2016.06.07  �옣�룞�븳           理쒖큹 �깮�꽦
 *   2017.03.03     議곗꽦�썝 	  �떆�걧�뼱肄붾뵫(ES)-�삤瑜� 硫붿떆吏�瑜� �넻�븳 �젙蹂대끂異�[CWE-209]
 *   2017.07.21  �옣�룞�븳 			isEquals�뿉�꽌 String Character 鍮꾧탳 媛��뒫�븯�룄濡�
 *   
 * </pre>
 */
public class MybaitsUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(MybaitsUtil.class); 
	
    /**
	 * Empty �뿬遺�瑜� �솗�씤�븳�떎.
	 * @param o Object
	 * @return boolean
	 * @exception IllegalArgumentException
	 */
	public static boolean isEmpty(Object o) throws IllegalArgumentException {
		try {
			if(o == null) return true;
		
			if(o instanceof String) {
				if(((String)o).length() == 0){
					return true;
				}
			} else if(o instanceof Collection) {
				if(((Collection)o).isEmpty()){
				return true;
				}
			} else if(o.getClass().isArray()) {
				if(Array.getLength(o) == 0){
				return true;
				}
			} else if(o instanceof Map) {
				if(((Map)o).isEmpty()){
				return true;
				}
			}else {
				return false;
			}
		
			return false;
		//2017.03.03 	議곗꽦�썝 	�떆�걧�뼱肄붾뵫(ES)-�삤瑜� 硫붿떆吏�瑜� �넻�븳 �젙蹂대끂異�[CWE-209]
		} catch(IllegalArgumentException e) {
			logger.error("[IllegalArgumentException] Try/Catch...usingParameters Runing : "+ e.getMessage());
		} catch(Exception e) {
			logger.error("["+e.getClass()+"] Try/Catch...Exception : " + e.getMessage());
		}
		return false;
	}

    /**
	 * Not Empty �뿬遺�瑜� �솗�씤�븳�떎.
	 * @param o Object
	 * @return boolean
	 * @exception IllegalArgumentException
	 */
	public static boolean isNotEmpty(Object o) {
		return !isEmpty(o);
	}

    /**
	 * Equal �뿬遺�瑜� �솗�씤�븳�떎.
	 * @param obj Object, obj Object
	 * @return boolean
	 */
	
    public static boolean isEquals(Object obj, Object obj2){
    	if(isEmpty(obj)) return false;

    	if(obj instanceof String && obj2 instanceof String) {
    		if( (String.valueOf(obj)).equals( String.valueOf(obj2) )){
				return true;
			}
    	}else if(obj instanceof String && obj2 instanceof Character) {
     		if( (String.valueOf(obj) ).equals( String.valueOf(obj2) )){
     			return true;
     		}
    	}else if(obj instanceof String && obj2 instanceof Integer) {
    		if( (String.valueOf(obj)).equals( String.valueOf((Integer)obj2) )){
				return true;
			}
    		
    	}else if(obj instanceof Integer && obj2 instanceof String) {
    		if( (String.valueOf(obj2)).equals( String.valueOf((Integer)obj) )){
				return true;
			}
		} else if(obj instanceof Integer && obj instanceof Integer) {
    		if((Integer)obj == (Integer)obj2){
				return true;
			}
		}
    	
        return false;	
    }
    
    /**
	 * String�쓽 Equal �뿬遺�瑜� �솗�씤�븳�떎.
	 * @param obj Object, obj Object
	 * @return boolean
	 */
    public static boolean isEqualsStr(Object obj, String s){
    	if(isEmpty(obj)) return false;
    	
    	if(s.equals(String.valueOf(obj))){
    		 return true;
    	}
        return false;
    }
    
}
