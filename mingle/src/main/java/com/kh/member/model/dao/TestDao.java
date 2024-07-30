package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;

public class TestDao {
	
	private Properties prop = new Properties();
	
	public TestDao() {
		String filePath = TestDao.class.getResource("/db/sql/test.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String test(Connection conn, String test) {
		String user = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("test");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,test);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				user = rset.getString("user_id");
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		
		return user;
	}
}
