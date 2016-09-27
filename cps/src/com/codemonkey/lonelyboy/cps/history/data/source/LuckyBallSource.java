package com.codemonkey.lonelyboy.cps.history.data.source;

import java.util.ArrayList;
import java.util.List;

import com.codemonkey.lonelyboy.cps.history.data.bean.Ssq;
import com.codemonkey.lonelyboy.cps.tools.ConfigUtil;

public class LuckyBallSource {

	public static List<Ssq> getSsqHistory(int year){
		List<Ssq> listSsq = new ArrayList<Ssq>();
		//获取网站地址
		
		//解析地址返回的数据，单个解析能
		
		
		
		return listSsq;
	}
	
	
	private static String getWebSite(int year ,String pz){
		String webSite = ConfigUtil.getProperty("khj.history.web");
		webSite = webSite.replaceAll("#pz#", pz);
		webSite = webSite.replaceAll("#year#", String.valueOf(year));
		return webSite;
	}
	
	
}
