package it.myst.swf.utility.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Table(name = "CUSTOMER")
public class User implements Serializable {

    private static final long serialVersionUID = -3652559447682574722L;
    
    private static Logger logger = LoggerFactory.getLogger(User.class);

    private String username;

    private String password;

    private String name;

    public User() {
    	
    }

    public User(String username, String password, String name) {
    	this.username = username;
    	this.password = password;
    	this.name = name;
    }

    @Id
    public String getUsername() {
    	return username;
    }

    public void setUsername(String username) {
    	this.username = username;
    }

    public String getPassword() {
    	return password;
    }

    public void setPassword(String password) {
    	this.password = password;
    }

    public String getName() {
    	return name;
    }

    public void setName(String name) {
    	this.name = name;
    }

    @Override
    public String toString() {
    	return "User(" + username + ")";
    }
    
    @Cacheable("usercache") 
	public String getCachedUser(int usrId){
		logger.debug("---Inside getCachedUser() Method---");
		if(usrId == 1){			
			return "user-id-1";
		}else{
			return "user-id-not-1";
		}
	}
    
}
