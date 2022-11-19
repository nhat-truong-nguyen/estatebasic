package com.buildingmanager.util;

import java.util.regex.Pattern;

public class ValidationUtil {
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	public static boolean isBlank(String str) {
		boolean check = false;
		Pattern pattern = Pattern.compile("^\\s*$");

		if (str == null) {
			check = true;
		}
		else {
			check = pattern.matcher(str).find();
		}
		return check;
	}
}
