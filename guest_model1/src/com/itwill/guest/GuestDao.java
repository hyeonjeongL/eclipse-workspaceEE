package com.itwill.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestDao {
	
	private DataSource dataSource;
	
	public GuestDao() {
		DataSource dataSource = new DataSource();
	}
	public List<Guest> selectAll() throws Exception{
		List<Guest> guestList = new ArrayList<Guest>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			guestList.add(new Guest(rs.getInt("guest_no"), 
								   (rs.getString("guest_name")), 
								   (rs.getString("guest_date")), 
								   (rs.getString("guest_email")), 
								   (rs.getString("guest_homepage")), 
								   (rs.getString("guest_title")), 
								   (rs.getString("guest_content"))));
		}

		
		rs.close();
		pstmt.close();
		con.close();
		
		
		return guestList;
	}
	
	
	public Guest selectByNO(int no) throws Exception {
		Guest guest = null;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_BY_NO);
		
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String name = rs.getString("guest_name");
			String date = rs.getString("guest_date");
			String email = rs.getString("guest_email");
			String homepage = rs.getString("guest_homepage");
			String title = rs.getString("guest_title");
			String content = rs.getString("guest_content");
			
			guest = new Guest(no, name, date, email, homepage, title, content);
		}
		
		
		rs.close();
		pstmt.close();
		con.close();
		
		
		return guest;
	}
	public int insertGuest(Guest guest) {
		return 0;
	}
	public int updateGuest(Guest guest) {
		return 0;
	}
	public int deleteGuest(int no) {
		return 0;
	}
	

}
