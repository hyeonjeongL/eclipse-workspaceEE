package com.itwill.datasource;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class BasicDataSourceExample {
	public static void main(String[] args) throws Exception {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@182.237.126.19:1521:XE");
		basicDataSource.setUsername("jdeveloper20");
		basicDataSource.setPassword("jdeveloper20");
		/******************** << javax.sql.DataSource >> **************************/
		DataSource dataSource = (DataSource) basicDataSource;
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from userinfo");
		while (rs.next()) {
			System.out.println(rs.getInt("userid") + " " + rs.getString("password") + " " + rs.getString("name") + " " + rs.getString("email"));
		}
		con.close();
		/************************************************************************/
		basicDataSource.close();
	}

}
