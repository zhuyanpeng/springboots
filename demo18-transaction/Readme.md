本章内容主要讲springboot中的事务的管理用到的缓存是H2，不知道为何不能使用远程进行链接H2只能使用本地的进行链接（/(ㄒoㄒ)/~~）！

##Transactional注解
<br>此注解的作用是使得当前的函数的逻辑进行事务管理一般是用在service的接口上面，如果是多个数据源的话
可以在后面加上Value进行对应的选择（多数据源请参考demo7或者demo8)不仅有value进行选择还有隔离界别和传
播行为可以选择。</br>
####Isolation隔离级别
<br>其中隔离界别(Isolation)可以选择的有
 DEFAULT：通常就是Read_committed
 READ_UNCOMMITTED:可以读取任意修改后的数据不管是否已经提交
 READ_COMMITTED：只能读取到用户已修改的数据
 REPEATABLE_READ：可以被多次操作某个查询属性，查询记录会被忽略
 SERIALIZABLE：全部实物按照队列模式进行
 </br>
####Propagation传播行为
<br>
REQUIRED:如果当前事务已存在，则将事务加入到该事务；如果当期无事务则创建一个事务
SUPPORTS：如果当前事务已存在,则加入该事务；如果当前没有事务，则以非事务的方式继续运行
MANDATORY：如果当前事务已存在，则加入该事务；如果当前没有事务，则抛出异常
REQUIRES_NEW:如果当前事务已存在则挂起当前事务，创建一个新的事务
NO_SUPPORTED:如果当前事务已存在则挂起当前事务，以非事务方式运行
</br>
 