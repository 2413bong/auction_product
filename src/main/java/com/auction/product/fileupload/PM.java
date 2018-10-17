package com.auction.product.fileupload;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;


public class PM {
	@SuppressWarnings("unchecked")
	public static <T> T MapToVo(Map<String, Object> map, Class<?> clazz) {
			T clas =null;
		try {
				 clas = (T)clazz.newInstance();
				BeanUtils.populate(clas, map);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return clas;

		
	}
}
