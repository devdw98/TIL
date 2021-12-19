package dw.study.lookie.pr_todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dw.study.lookie.pr_todo.dto.TodoDto;

public class TodoDao {
	private static String dbURL = "jdbc:mysql://localhost:3306/lookiedb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "dw";
	private static String dbPassword = "dw";

	public int addTodo(TodoDto todo) {
		int insertCount = 0;
		String sql = "INSERT INTO todo (title, name, sequence) VALUES (?, ?, ?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();
		String sql1 = "SELECT id, title, name, sequence, type, regdate FROM todo ORDER BY regdate desc";
		String sql2 = "SELECT id, title, name, sequence, type, regdate FROM todo where type='TODO' ORDER BY regdate desc";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql1)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Long id = rs.getLong("id");
					String title = rs.getString("title");
					String name = rs.getString("name");
					int sequence = rs.getInt("sequence");
					String type = rs.getString("type");
					String regDate = rs.getString("regdate");

					TodoDto todo = new TodoDto(id, title, name, sequence, type, regDate);
					list.add(todo);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int updateTodo(TodoDto todo) {
		int updateCount = 0;
		String sql = "UPDATE todo SET type = ? WHERE id = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, todo.getType());
			ps.setLong(2, todo.getId());
			updateCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return updateCount;
	}
}
