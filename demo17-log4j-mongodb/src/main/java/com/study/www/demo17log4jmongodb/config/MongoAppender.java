package com.study.www.demo17log4jmongodb.config;


import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.context.annotation.Configuration;

/**
 * MongoAppender: 自己对log4j进行扩展
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/10/12    18:21
 **/
/*AppenderSkeleton用来对log4j进行扩展在此引入上个新的参数分别是connectionUrl,databaseName,collectionName所以log4j.properties也可以配置这三个了*/

public class MongoAppender extends AppenderSkeleton{
    private MongoClient mongoClient; //mongodb的链接客户端
    private MongoDatabase mongoDatabase;//日志记录的数据库
    private MongoCollection<BasicDBObject> mongoCollection;//日志记录集合

    private String connectionUrl; //mongodb的地址
    private String databaseName; //数据库名
    private String collectionName; //集合名

    @Override
    public void close() {
        if (mongoClient!=null){
            mongoClient.close();
        }
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    /*根据log4j.properties中的配置创建mongodb连接；LoggingEvent提供getMessage()函数来获取日志消息；往配置的记录日志的collection中插入日志消息*/
    @Override
    protected void append(LoggingEvent event) {
        if (mongoDatabase==null){
            MongoClientURI mongoClientURI = new MongoClientURI(connectionUrl);
            mongoClient = new MongoClient(mongoClientURI);
            mongoDatabase = mongoClient.getDatabase(databaseName);
            mongoCollection = mongoDatabase.getCollection(collectionName, BasicDBObject.class);
        }
        mongoCollection.insertOne((BasicDBObject)event.getMessage());
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}
