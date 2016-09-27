package com.codemonkey.lonelyboy.cps.tools;

import java.util.*;


public class ConfigUtil {
	private static ResourceBundle bundle = ResourceBundle.getBundle("Config");

	public static String getString(String prop) {

		return bundle.getString(prop);
	}

	public static String getProperty(String prop) {

		return getString(prop);
	}

	public static String getStringPath(Object obj, String prop) {
		String path = (obj.getClass().getResource("/").getPath()).replaceFirst(
				"/", "");
		int index = path.indexOf("WEB-INF");
		if (index == -1) {
			index = path.indexOf("classes");
		}
		if (index == -1) {
			index = path.indexOf("bin");
		}
		path = path.substring(0, index) + getString(prop);
		return path;
	}


}
