运行test可以明显看到findByName明显有两次查询而findBYAccount只有一次查询，因为接口中的Cacheabe会进行缓存还因去application，<br>
中开启缓存EnableCaching,application默认开启的是ConcurrentMapCache而并非Ehcache，所以需要在pom文件中引入和在yml中指定
<br /> 
@CacheConfig:用来配置在该类里面会公用到的缓存参数，例如例子中的cacheNames就是指定一个缓存对象的名字如果不写chache会自动来生成,注解加在抽象类上不知道为什么会出错
<br /> CacheConfig
@Cacheabble:配置的函数的返回值将会被加入到缓存中去。同时在查询时会有限从缓存中获取，若不存在才发起对数据的访问：其内部包<br>
含参数有value、cacheNames、key、condition、unless、keyGenerator、cacheManager、cacheResolver等参数。
<br>* 【`value和cacheNames`】两者一样只不过是前后的版本命名不同;
<br>* 【`key`】缓存在缓存对象中key的名字，如果自行配制可以使用SpEL表达式例如@Cacheable(key = "#p0")：使用函数第一个参数作为缓存
<br>的key值，更多关于SpEL表达式的详细内容可参考：http://docs.spring.io/spring/docs/current/spring-framework-reference/html/cache.html#cache-spel-context;
<br>* 【`condition`】:缓存条件缓存对象的条件，非必需，也需使用SpEL表达式，只有满足表达式条件的内容才会被缓存，比如：
<br>@Cacheable(key = "#p0", condition = "#p0.length() < 2")，表示只有当第一个参数的长度小于2的时候才会被缓存，若做此配置
<br>上面的mirror用户就不会被缓存
<br>* 【`unless`】：另外一个缓存条件参数，非必需，需使用SpEL表达式。它不同于condition参数的地方在于它的判断时机，该条件
<br>是在函数被调用之后才做判断的，所以它可以通过对返回的参数进行判断从而选中是否需要缓存。如果返回false，则放入缓存；（即跟condition相反）
<br>* 【`keyGenerator`】：用于指定key生成器，非必需。在使用时需要去实现org.springframework.cache.interceptor.keyGenerator
<br>接口,并使用该参数来指定。注意此参数和key是互斥的
<br>* 【`cacheManager`】:用户指定使用那个缓存管理器进行存储，只有当有多个缓存管理器的时候才需要进行使用
<br>* 【`cacheResolver`】:用户指定使用那个缓存解析器，非必须。需要通过org.springframework.cache.interceptor.CacheResolver
<br>接口来实现自己的缓存解析，并使用该参数进行指定。
<br />
@CachePut:配置于方法(无法配置于dao因为update返回值的问题如果走存储过程当我没说0.0)之上，能够根据参数定义条件来进行缓存，
它与@Cacheable不同的是，它每次都会真实调用方法，所以主要用于
数据新增和修改的操作上，它的参数与@Cacheable类似，它可以用来和Cacheable组合使用，例如当前查询用户的全部信息，之后
更新以一条该用户的信息如果更新的函数上面有Cacheput注解的话被Cacheale缓存的数据也会同时进行更新，注意必须操作的同一个
缓存实例，缓存的key和返回值必须是相同的。具体功能可以参考对@Cacheable参数的解析。见UserService.updateUserByAccount
<br />
@CacheEvict:配置于函数上，通常用于删除的方法上，用来从缓存中移除数据，其有两个参数分别是@allEntries：非必需，默认为false
当为true时会移除掉所有的数据；beforeInvocation:非必须，默认为false,会在调用方法之后移除数据。当为true时，会在调用方法
之前进行数据的移除。见UserService.removeByAccount

### 如果想要手动注入可以映入ehCacheCacheManager通过getCache的方法进行注入,如下例子:
```java
    @Autowired
    EhCacheCacheManager ehCacheCacheManager;
    public List<User> select(){
        List<User> userList= userRepository.findAll();
        Cache userCache = ehCacheCacheManager.getCache("users");
        for (User user : userList) {
            userCache.put(user.getAccount(),user);
        }
        return userList;
    }
```