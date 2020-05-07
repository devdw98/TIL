package dw.study.lookie.pr_todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import dw.study.lookie.pr_todolist.dto.TodoDto;

public class TodoDao {
	
	private static String dbURL = "jdbc:mysql://localhost:3306/lookiedb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "dw";
	private static String dbPassword = "dw";

	public int addTodo(TodoDto todo) { //입력
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		String sql = "insert into todo(title, name, sequence) values(?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return insertCount;
	}
	
	public List<TodoDto> getTodos(){ //조회
		List<TodoDto> list = new ArrayList<TodoDto>();
		
		return list;
	}
	
	public int updatdTodo(TodoDto todo) { //수정
		int updateCount = 0;
		
		return updateCount;
	}
}
