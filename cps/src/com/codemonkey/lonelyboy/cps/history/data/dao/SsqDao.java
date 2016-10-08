package com.codemonkey.lonelyboy.cps.history.data.dao;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.codemonkey.lonelyboy.cps.base.BaseDao;
import com.codemonkey.lonelyboy.cps.history.data.bean.Ssq;

@Repository("SsqDao")
public class SsqDao extends BaseDao{
	
	public void saveSsq(List<Ssq> ssqList) throws Exception{
		SqlSession sqlSession = this.sqlSessionFactory.getObject().openSession(ExecutorType.BATCH); 
		try{
			
			sqlSession.insert("saveSsqbatch", ssqList);
			sqlSession.commit();
		}catch(Exception e){
			logger.error("保存双色球数据列表失败",e);
			sqlSession.rollback();
		}finally{
			if(null==sqlSession){
				sqlSession.close();
			}
		}
	}
}
