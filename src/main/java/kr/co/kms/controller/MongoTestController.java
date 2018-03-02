package kr.co.kms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kms.mongo.dao.MongoDao;
import kr.co.kms.mongo.vo.MongoTestVo;

@Controller
public class MongoTestController {

	@Autowired
	MongoDao mongodao;
	
	@RequestMapping(value="/save")
	@ResponseBody public String saveTest() {
		
		MongoTestVo mongotestvo = new MongoTestVo();
		mongotestvo.set_id("1");
		mongotestvo.setData1("데이터1");
		mongotestvo.setData2("mydata2");
		
		mongodao.saveMongoData(mongotestvo);
		
		return mongotestvo.toString() + " saved!";		
	}
	
	@RequestMapping(value="/find")
	@ResponseBody public String findTest() {
		return mongodao.findMongoData("_id", "1").toString();
		
	}

}
