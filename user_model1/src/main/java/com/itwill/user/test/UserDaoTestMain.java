package com.itwill.user.test;

import com.itwill.user.User;
import com.itwill.user.UserDao;

public class UserDaoTestMain {

	public static void main(String[] args) throws Exception{
		UserDao userDao=new UserDao();
		System.out.println("1.insert:"+
				userDao.create(new User("guard5", "5555", "오경호", "guard554@gmail.com")));
		User updateUser = new User("guard5", "5555", "오이호", "change55@gmail.com");
		System.out.println("2.update:"+userDao.update(updateUser));
		System.out.println("3.findUser:"+userDao.findUser("guard1"));
		System.out.println("4.remove:"+userDao.remove("guard1"));
		System.out.println("5.findUserList:"+userDao.findUserList());
		System.out.println("6.existedUser:"+userDao.existedUser("guard1"));
		System.out.println("6.existedUser:"+userDao.existedUser("guard2"));
		
		
	}

}
