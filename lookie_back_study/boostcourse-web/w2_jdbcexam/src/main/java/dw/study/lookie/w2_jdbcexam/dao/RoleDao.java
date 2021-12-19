package dw.study.lookie.w2_jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dw.study.lookie.w2_jdbcexam.dto.Role;

public class RoleDao { //기능 정의
	
	private static String dbURL = "jdbc:mysql://localhost:3306/lookiedb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "dw";
	private static String dbPassword = "dw";
	
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			String sql = "SELECT role_id, description FROM role where role_id=?"; //? 가 바인딩 되는 부분만 바뀜! 효율적!
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId); // 첫번째 ? 파라미터에, roleId 값을 넣어주세요
			rs = ps.executeQuery();//실행해주세요!
			
			if(rs.next()) {
				int id = rs.getInt("role_id");
				String description = rs.getString(2); // description
				role = new Role(id, description);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return role;
	}
	
	public int addRole(Role role) {
		int insertCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
	//	ResultSet은 할필요 없음 ( 반환해줄 객체가 없기 때문 ) 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			String sql = "INSERT INTO role (role_id, description) VALUES (?, ?)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			
			insertCount = ps.executeUpdate(); //insert, update, delete가 사용
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return insertCount;
	}
	
	public int updateRole(Role role) {
		int updateCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE role set description =? where role_id = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRoleId());
			
			updateCount = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return updateCount;
	}
	
	public int deleteRole(Integer roleId) {
		int deleteCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM role WHERE role_id = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			deleteCount = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return deleteCount;
	}
	
	public List<Role> getRoles(){
		List<Role> roles = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT description, role_id from role ORDER by role_id desc";
		
		try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql)){ //알아서 close 해줌
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id"); // "role_id"
					Role role = new Role(id, description);
					roles.add(role);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return roles;
	}
}
