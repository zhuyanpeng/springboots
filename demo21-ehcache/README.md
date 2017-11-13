运行test可以明显看到findByName明显有两次查询而findBYAccount只有一次查询，因为接口中的Cacheabe会进行缓存还因去application中开启缓存EnableCaching
<br /> 
@CacheConfig:用来配置在该类里面会公用到的缓存参数，例如例子中的cacheNames就是指定一个缓存对象的名字如果不写chache会自动来生成
<br /> 
@Cacheabble:配置的函数的返回值将会被加入到缓存中去。同时在查询时会有限从缓存中获取，若不存在才发起对数据的访问：其内部包
含参数有value、cacheNames两者一样只不过是前后的版本命名不同，key缓存在缓存对象中key的名字，如果自行配制可以使用SpEL表达
式例如@Cacheable(key = "#p0")：使用函数第一个参数作为缓存的key值，更多关于SpEL表达式的详细内容可参考：
http://docs.spring.io/spring/docs/current/spring-framework-reference/html/cache.html#cache-spel-context
condition:缓存条件缓存对象的条件，非必需，也需使用SpEL表达式，只有满足表达式条件的内容才会被缓存，
比如：@Cacheable(key = "#p0", condition = "#p0.length() < 2")，表示只有当第一个参数的长度小于2的时候才会被缓存，
若做此配置上面的mirror用户就不会被缓存
unless：另外一个缓存条件参数，非必需，需使用SpEL表达式。它不同于condition参数的地方在于它的判断时机，该条件是在函数被调用
之后才做判断的，所以它可以通过对result进行判断。