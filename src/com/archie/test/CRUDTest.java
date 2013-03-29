package com.archie.test;


import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.archie.util.MongoUtil;
import com.archie.vo.User;

/**
 * 增删除查改测试
 * @author archie2010
 *
 * since 2013-3-22 下午04:43:39
 */
public class CRUDTest {

	public static void main(String[] args) {
		// For XML
	    //ApplicationContext ctx = new
		//GenericXmlApplicationContext("mongo-config.xml");

		// For Annotation
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(
		//		SpringMongoConfig.class);

		//MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
	    MongoOperations mongoOperation=MongoUtil.getMongoOperation();
	    User user = new User("archie", "123");
		// save
		mongoOperation.save(user, "users");

		
		
		Criteria criteriaName=Criteria.where("uname").is("tom");
		Criteria criteriaPwd=Criteria.where("upwd").is("123");
		
		Query query=new Query();
		query.addCriteria(criteriaName);
		query.addCriteria(criteriaPwd);
		
		
		
		User userLogin = mongoOperation.findOne(query, User.class,
				"users");
		System.out.println(userLogin);
		
		// find
		User savedUser = mongoOperation.findOne(
				new Query(Criteria.where("uname").is("archie")), User.class,
				"users");


		System.out.println("savedUser : " + savedUser);

		// update
		mongoOperation.updateMulti(
				new Query(Criteria.where("uname").is("archie")),
				Update.update("upwd", "1111111111"), "users");

		// find
		User updatedUser = mongoOperation.findOne(
				new Query(Criteria.where("uname").is("archie")), User.class,
				"users");

		System.out.println("updatedUser : " + updatedUser);

		// delete
		mongoOperation.remove(
				new Query(Criteria.where("uname").is("archie")), "users");

		// List
		List<User> listUser = mongoOperation.findAll(User.class, "users");
		System.out.println("Number of user = " + listUser.size());
		

	}

}
