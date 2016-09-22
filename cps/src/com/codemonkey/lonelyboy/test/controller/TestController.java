package com.codemonkey.lonelyboy.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codemonkey.lonelyboy.test.dao.TestDao;
import com.mysql.jdbc.log.Log;


@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestDao testDao;
	
	Logger logger = LoggerFactory.getLogger(TestController.class);
	@RequestMapping("/test.do")
	public String toTest() throws Exception{
		logger.info("log");
		List<Object> objs =	testDao.list(null);
		return "test";
	}
}
