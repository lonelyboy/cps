package com.codemonkey.lonelyboy.cps.history.data.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codemonkey.lonelyboy.cps.history.task.SsqHistoryDataDownloadTask;

@Controller
@RequestMapping("/init")
public class InitAction {

	@Autowired
	private SsqHistoryDataDownloadTask task;
	@RequestMapping("/getSsqHistoryData.do")
	public String getSsqHistoryData(){
		task.getHistoryData();
		return "";
	}
	
}
