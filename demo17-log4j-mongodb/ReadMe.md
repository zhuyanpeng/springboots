注意:

    因为是log4j所以配置得放在log4j.properties中，其中类的日志的添加使用了private Logger logger = 
    Logger.getLogger("MongoDB");这句话的含义是说在log4j.properties总有一个log4j.logger.MongoDB=DEBUG,mongodb 的配置，
    如果是Logger.getLogger("aaa")那么对应的就得改为log4j.logger.aaa.
    
<pre>
并且会将前缀为此（本文为log4j.logger.MongoDB）的所有属性加载到对应的log4j的扩展配置中，扩展的配置类的配置文件的写法为 
log4j.appender.mongodb=全地址，本文的是com.study.www.demo17log4jmongodb.config.MongoAppender所以需要找到MongoAppender,
扩展类中拥有getset方法的属性会自动与配置文件对应的配置栏匹配例如本文中MongoAppender的host属性就会自动与配置文件中的
log4j.appender.mongodb.host=120.24.62.63配对.</pre>

<pre>log中的info会对应到扩展内的append方法.例如本文中的MongoAppender.append将会与Logger.getLogger("mongodb").info
配对</pre>