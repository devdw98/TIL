package dw.study.lookie.w3_guestbook.dao;

public class GuestbookDaoSqls {
	public static final String DELETE_BY_ID = "DELETE FROM guestbook WHERE id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM guestbook";
	public static final String SELECT_PAGING = "SELECT id, name, content, regdate FROM guestbook ORDER BY id DESC limit :start, :limit";
	//limit : 시작 값, 끝 값을 설정해서 특저 부분만 select 할 수 있음
}
