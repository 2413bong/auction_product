package com.auction.product.fileupload;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;


public class ParseMap {
	
	 public static Object MapToVo(Map<String,Object> map,Object obj){
	        Iterator<String> itr = map.keySet().iterator();
	        
	        while(itr.hasNext()){
	        	String keyAttribute = (String) itr.next();
	        	String methodString = "set"+keyAttribute.substring(0,1).toUpperCase()+keyAttribute.substring(1);            
	            Method[] methods = obj.getClass().getDeclaredMethods();
	            for(int i=0;i<methods.length;i++){
	                if(methodString.equals(methods[i].getName())){
	                    try{
	                        methods[i].invoke(obj, map.get(keyAttribute));
	                    }catch(Exception e){
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	        return obj;
	    }
	

}
