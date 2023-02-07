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

