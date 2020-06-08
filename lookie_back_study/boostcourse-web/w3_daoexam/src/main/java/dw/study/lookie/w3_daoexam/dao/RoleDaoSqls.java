package dw.study.lookie.w3_daoexam.dao;

public class RoleDaoSqls { //sql문 모음 -> 상수형태
	
	 public static final String SELECT_ALL = "SELECT role_id, description FROM role order by role_id";
	 public static final String UPDATE = "UPDATE role set description = :description where role_id = :roleId";
	 //:~ 값으로 바인딩 될 부분
	 public static final String SELECT_BY_ROLE_ID = "SELECT role_id, description FROM role WHERE role_id = :roleId";
	 public static final String DELETE_BY_ROLE_ID = "DELETE FROM role where role_id = :roleId";
	

}
