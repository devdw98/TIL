package dw.study.lookie.pr_todo;

import java.util.List;

import dw.study.lookie.pr_todo.dao.TodoDao;
import dw.study.lookie.pr_todo.dto.TodoDto;

public class TodoTest {
	public static void main(String[] args) {
		TodoDao dao = new TodoDao();

		String title = "입력 테스트10";
		String name = "pdw1";
		int sequence = 2;
		TodoDto todo = new TodoDto(title, name, sequence);

//		int insertCount = dao.addTodo(todo);
//		System.out.println(insertCount);

//		TodoDto todo2 = new TodoDto((long) 7, "타입수정");
//		int updateCount = dao.updateTodo(todo2);
//		System.out.println(updateCount);

		List<TodoDto> list = dao.getTodos();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
