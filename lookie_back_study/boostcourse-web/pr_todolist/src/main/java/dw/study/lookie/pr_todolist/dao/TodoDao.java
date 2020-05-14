package dw.study.lookie.pr_todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dw.study.lookie.pr_todolist.dto.TodoDto;

public class TodoDao {

	private static String dbURL = "jdbc:mysql://localhost:3306/lookiedb?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true";
	private static String dbUser = "dw";
	private static String dbPassword = "dw";

	public int addTodo(TodoDto todo) { // 입력
		int insertCount = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql = "insert into todo(title, name, sequence) values(?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
			insertCount = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return insertCount;
	}

	public List<TodoDto> getTodos() { // 조회
		List<TodoDto> list = new ArrayList<TodoDto>();
		String sql = "SELECT id, title, name, sequence, type, regdate FROM todo ORDER BY regdate DESC";
		String sql2 = " select id, title, name, sequence, type, regdate from todo where type = 'TODO' order by regdate desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql)){
			try (ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Long id = rs.getLong(1);
					String title = rs.getString(2);
					String name = rs.getString(3);
					int sequence = rs.getInt(4);
					String type = rs.getString(5);
					String regDate = rs.getString(6);
					TodoDto todo = new TodoDto(id,title, name, sequence, type, regDate);
					list.add(todo);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int updateTodo(TodoDto todo) { // 수정
		int updateCount = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "UPDATE todo set type = ? where id = ?";

		try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try {
				ps.setString(1, todo.getType());
				ps.setLong(2, todo.getId());

				updateCount = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return updateCount;
	}
}
