package com.csye6225.courseserviceDB.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.csye6225.courseserviceDB.datamodel.DynamoDBConnector;

public class BaseService {
	protected DynamoDBConnector dynamoDb;
	protected DynamoDBMapper dbMapper;
	
	public BaseService() {
		dynamoDb = new DynamoDBConnector();
		DynamoDBConnector.init();
		dbMapper = new DynamoDBMapper(dynamoDb.getClient());
	}
	
	protected DynamoDBMapper getDbMapper() {
		return dbMapper;
	}
}
