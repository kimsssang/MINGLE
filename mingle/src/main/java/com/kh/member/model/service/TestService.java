package com.kh.member.model.service;

import java.sql.Connection;

import com.kh.member.model.dao.TestDao;

import static com.kh.common.JDBCTemplate.*;

public class TestService {
	
	public String test(String test) {
		
		Connection conn = getConnection();
		
		String user = new TestDao().test(conn, test);
		
		close(conn);
		
		return user;
		
	}

}
