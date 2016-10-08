package com.codemonkey.lonelyboy.cps.history.task;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemonkey.lonelyboy.cps.base.BaseDao;
import com.codemonkey.lonelyboy.cps.history.data.bean.Ssq;
import com.codemonkey.lonelyboy.cps.history.data.dao.SsqDao;
import com.codemonkey.lonelyboy.cps.history.data.source.LuckyBallSource;

@Service
public class SsqHistoryDataDownloadTask {
	public static Logger logger = LoggerFactory.getLogger(SsqHistoryDataDownloadTask.class);
	@Autowired
	private SsqDao dao;
	
	@PostConstruct
	public void init(){
		logger.info("初始化方法SsqHistoryDataDownloadTask init");
		List<Ssq> historyData = LuckyBallSource.getSsqHistory();
		try {
			dao.saveSsq(historyData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
