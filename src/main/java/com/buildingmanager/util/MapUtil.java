package com.buildingmanager.util;

import java.util.Map;

public class MapUtil {
	public static <T> T getObject(Map<String, Object> params, String key, Class<T> tClass) {
		Object object = params.getOrDefault(key, null);
		try {
			switch (tClass.getTypeName()) {
			case "java.lang.Integer":
				object = Integer.valueOf(object.toString());
				break;
			case "java.lang.Long":
				object = Long.valueOf(object.toString());
				break;
			case "java.lang.Double":
				object = Double.valueOf(object.toString());
				break;
			case "java.lang.Float":
				object = Float.valueOf(object.toString());
				break;
			case "java.lang.String":
				object = object.toString();
				break;
			
			default:
				break;
			}	
		} catch (Exception e) {
			object = null;
		}
		
		return tClass.cast(object);
	}
}
