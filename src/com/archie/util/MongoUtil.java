package com.archie.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


/**
 * ������
 * @author archie2010
 *
 * since 2013-1-10 ����04:49:10
 */
public class MongoUtil {

	static ApplicationContext ctx = new
	GenericXmlApplicationContext("mongo-config.xml");

	private static MongoOperations mongoOperations=null;
	
	/**
	 * ���MongoOperations���󣨸���CRUD������
	 * @return
	 */
    public static MongoOperations getMongoOperation(){
    	if(mongoOperations==null){
    		mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
    	}
    	return mongoOperations;
    }
    /**
     * �������Ȳ����������ѯ����
     * @param criterias
     * @return
     */
    public static Query setQuery(Criteria...criterias){
    	Query query=new Query();
    	
    	for (int i = 0; i < criterias.length; i++) {
    		query.addCriteria(criterias[i]);
		}
    	return null;
    	
    }
}
