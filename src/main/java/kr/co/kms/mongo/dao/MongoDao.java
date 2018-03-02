package kr.co.kms.mongo.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import kr.co.kms.mongo.vo.MongoTestVo;

@Component
public class MongoDao {
	
	@Autowired
	private MongoTemplate mongotemplate;
	
	public void saveMongoData(MongoTestVo mongoTestVo) {
		mongotemplate.save(mongoTestVo); //save를 이용해서 저장하기
	}
	
	public MongoTestVo findMongoData(String key, String value) {
		//MongoTemplate에서 조건을 검색하기 위해 Criteria 클래스를 사용 
		Criteria criteria = new Criteria(key);
		criteria.is(value); //일치하는 값을 찾기위해 is 메소드 사용
		
		//쿼리객체 작성
		Query query = new Query(criteria);
				
		MongoTestVo vo = mongotemplate.findOne(query, MongoTestVo.class);
		return vo;
	}

}
