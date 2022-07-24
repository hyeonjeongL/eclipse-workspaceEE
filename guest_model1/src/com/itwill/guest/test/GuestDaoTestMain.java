package com.itwill.guest.test;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception {
		GuestDao guestDao = new GuestDao();
		System.out.println("--------insertGuest--------");
		System.out.println(guestDao.insertGuest(new Guest(0, "이름", null, "guard@naver.com", "http://www.naver.com", "타이틀", "컨텐츠")));
		System.out.println("--------updateGuest--------");
		System.out.println(guestDao.updateGuest(new Guest(12, "변경이름", null, "change@naver.com", "http://www.change.com", "변경타이틀","변경컨텐츠")));
		System.out.println("--------deleteGuest--------");
		System.out.println(guestDao.deleteGuest(11));
		System.out.println("--------selectByNo--------");
		System.out.println(guestDao.selectByNO(0));
		System.out.println("--------selectAll--------");
		System.out.println(guestDao.selectAll());
	}

}

