package it.myst.swf.utility.business.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import it.myst.swf.utility.business.service.UserService;
import it.myst.swf.utility.domain.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Cacheable(value="userCache", key="#username")
	public User findUser(String username) {
		pause(3000L);
		User ud1 = new User();
		ud1.setName("nametest1");
		ud1.setPassword("pswtest1");
		ud1.setUsername(username);
	
		return ud1;
	}

	private void pause(long sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
