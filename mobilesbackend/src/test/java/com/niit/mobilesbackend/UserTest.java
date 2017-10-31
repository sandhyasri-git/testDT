package com.niit.mobilesbackend;

/*import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mobilebackend.dao.IUserDao;
import com.niit.mobilebackend.model.User;

public class UserTest {
	static AnnotationConfigApplicationContext context;
	static IUserDao userDao;
	static User user;
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		userDao=(IUserDao)context.getBean("userDao");
	}

	@Test
	public void test() {
		user=new User();
		List<User>list=userDao.getAllUsers();
		user.setFirstname("ameer");
		user.setLastname("pasha");
		user.setUsername("mohammad");
		user.setEmailid("ameer@gmail.com");
		user.setPhone("9989");
		user.setPassword("ameerabhi");
		user.setRole("Role_USER");
		assertEquals("inserted",true,userDao.addUser(user));
		Iterator<User>it=list.iterator();
		while(it.hasNext())
		{
			User u=(User)it.next();
			System.out.println(u.getFirstname()+" "+u.getLastname());
		}
		
	}

}
*/