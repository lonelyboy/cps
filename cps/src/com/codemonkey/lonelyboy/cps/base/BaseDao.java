package com.codemonkey.lonelyboy.cps.base;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

public class BaseDao {

	public SqlSessionTemplate template;

	public SqlSessionFactoryBean factoryBean;
	
	public SqlSessionTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	public SqlSessionFactoryBean getFactoryBean() {
		return factoryBean;
	}

	public void setFactoryBean(SqlSessionFactoryBean factoryBean) {
		this.factoryBean = factoryBean;
	}

	
	
	
}
