start from template 04_SpringBoot_2.7.7_v1 54b58cc


# use ehcache by xml
pom dependency
```
<!-- for cache -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-cache</artifactId>
</dependency>
<dependency>
	<groupId>javax.cache</groupId>
	<artifactId>cache-api</artifactId>
	<version>1.1.1</version>
</dependency>
<dependency>
	<groupId>org.ehcache</groupId>
	<artifactId>ehcache</artifactId>
	<version>3.10.8</version>
</dependency>
```


/resources add ehcache.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<config xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://www.ehcache.org/v3"
	xmlns:jsr107="http://www.ehcache.org/v3/jsr107"
	xsi:schemaLocation="http://www.ehcache.org/v3 
	                        http://www.ehcache.org/schema/ehcache-core-3.2.xsd
	                        http://www.ehcache.org/v3/jsr107
	                        http://www.ehcache.org/schema/ehcache-107-ext-3.2.xsd">

	<persistence directory="java.io.tmpdir" />

	<cache-template name="default">
		<resources>
			<heap unit="entries">10</heap>
			<offheap unit="MB">10</offheap>
		</resources>
	</cache-template>

    <!-- 重點 -->
	<cache alias="Users" uses-template="default">
        <key-type>java.lang.Integer</key-type>
        <value-type>com.rohim.web.models.User</value-type>
		<expiry>
			<ttl unit="seconds">10</ttl>
		</expiry>
	</cache>

	<cache alias="Orders" uses-template="default">
		<expiry>
			<ttl unit="seconds">600</ttl>
		</expiry>
	</cache>

</config>
```


application-dev.properties 新增
```
# 讓springboot使用ehcache
spring.cache.jcache.config=classpath:ehcache.xml
```


ApplicationStart.java 新增 @EnableCaching
```
@SpringBootApplication
@EnableCaching
public class ApplicationStart {
```


/web/models 新增 User.java
```
package com.rohim.web.models;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```


/web/services 新增 UserService.java
```
package com.rohim.web.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rohim.web.models.User;

@CacheConfig(cacheNames = "Users")
@Service
public class UserService {

    private final static ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();
    
    // org.springframework.cache.CacheManager
    @Autowired
    private CacheManager cacheManager; 

    /**
	 * 新增用户
	 */
	@CachePut(key = "#user.id")
	public User insertUser(User user) {
		System.out.println("\n----------正在執行insertUser()----------");
        users.put(user.getId(),  user);
		return user;
	}

    /**
	 * 經由id查詢單個用户
	 */
	@Cacheable(key = "#id")
	public User findUserById(Integer id) {
		System.out.println("\n----------正在執行findUserById()----------");
        User user = users.get(id);
		return user;
	}

    /**
	 * 經由id查詢單個用户
	 */
	public User findUserById_WithCacheManager(Integer id) {
		System.out.println("\n----------正在執行findUserById_WithCacheManager()----------");

        // org.springframework.cache.Cache
        Cache cache = cacheManager.getCache("Users");

        User user = null;
        ValueWrapper userWrapper = cache.get(id);
        if (userWrapper != null) {
            user = (User)userWrapper.get();
        } else {
            System.out.println("\n----------正在執行重設Cache----------");
            cache.put(1, new User(1, "Jeff"));
        }

		return user;
	}

    /**
	 * 更新
	 */
	public User udpateUser(User user) {
		System.out.println("\n----------正在執行updateUser()----------");
        users.put(user.getId(),  user);
		return user;
	}

    /**
	 * 回傳所有
	 */
    public List<User> findAll() {
        System.out.println("\n----------正在執行findAll()----------");
        List<User> usersFromDb = new ArrayList<User>();
        for (User user : users.values()) {
            usersFromDb.add(user);
        }
        return usersFromDb;
    }
}
```


HomeController.java 新增以下接口
```
@Autowired
private UserService userService;

@RequestMapping(path = "insert", method = RequestMethod.GET)
@ResponseBody
public Object t1() {
    this.userService.insertUser(new User(1, "John"));
    return "Hello World1";
}


@RequestMapping(path = "get/{id}", method = RequestMethod.GET)
@ResponseBody
public Object t2(@PathVariable Integer id) {
    User user = this.userService.findUserById(id);
    return user;
}

@RequestMapping(path = "get2/{id}", method = RequestMethod.GET)
@ResponseBody
public Object t5(@PathVariable Integer id) {
    User user = this.userService.findUserById_WithCacheManager(id);
    return user;
}

@RequestMapping(path = "getall", method = RequestMethod.GET)
@ResponseBody
public Object t4() {
    List<User> users = this.userService.findAll();
    return users;
}

@RequestMapping(path = "update/{id}", method = RequestMethod.GET)
@ResponseBody
public Object t3(@PathVariable Integer id, @RequestParam(required=false) String name) {
    User user = this.userService.udpateUser(new User(id, name));
    return user;
}
```

## 試跑看看
```
start.bat
# 新增一筆User John
http://localhost:8088/insert
# 馬上用非cache方式update一下
http://localhost:8088/update/1?name=abcdefg
# 馬上用Cache撈一下，還會是John
http://localhost:8088/getByCacheAnno/1
# 10秒後再撈，Cache逾期後應該就會變abcdefg了
http://localhost:8088/getByCacheAnno/1
```