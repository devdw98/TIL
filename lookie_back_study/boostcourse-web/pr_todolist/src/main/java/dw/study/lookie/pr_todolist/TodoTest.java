package dw.study.lookie.pr_todolist;

import java.util.Iterator;
import java.util.List;

import dw.study.lookie.pr_todolist.dao.TodoDao;
import dw.study.lookie.pr_todolist.dto.TodoDto;

public class TodoTest {
	public static void main(String[] args) {
		String title = "입력 테스트9";
		String name = "pdw1";
		int sequence = 2;
		TodoDto todo = new TodoDto(title, name, sequence);
		
		TodoDao dao = new TodoDao();
//		int insertCount = dao.addTodo(todo);
//		System.out.println(insertCount);
		
		TodoDto todo2 = new TodoDto((long)2,"타입수정");
//		int updateCount = dao.updateTodo(todo2);
//		System.out.println(updateCount);

		List<TodoDto> list = dao.getTodos();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
		
	}
}
