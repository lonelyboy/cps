package com.codemonkey.lonelyboy.test;

import com.codemonkey.lonelyboy.cps.tools.HttpUtil;

public class TestUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String context =	HttpUtil.gethttpUriContext("http://kjh.55128.cn/ssq-history-2013.htm");
	System.out.println(context);
	}

}
