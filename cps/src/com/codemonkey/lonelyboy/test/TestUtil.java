package com.codemonkey.lonelyboy.test;

import com.codemonkey.lonelyboy.cps.tools.HttpUtil;

public class TestUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String context =	HttpUtil.gethttpUriContext("http://blog.csdn.net/u010028869/article/details/49780515");
	System.out.println(context);
	}

}
