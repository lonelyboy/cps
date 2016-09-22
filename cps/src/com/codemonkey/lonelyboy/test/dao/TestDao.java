package com.codemonkey.lonelyboy.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codemonkey.lonelyboy.test.bean.User;

@Repository("testDao")
public class TestDao {
 
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactory;
	
	public List<Object> list(User user) throws Exception{
		SqlSessionFactory factory = sqlSessionFactory.getObject();
		SqlSession session =factory.openSession();
		List<Object> list =session.selectList("selectTiger","sssss");
		session.close();
		return list;
	}
}
