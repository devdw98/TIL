package dw.study.lookie.pr_naver_reservation_api.dao;

public class UserRoleDaoSqls {
	public static final String SELECT_ALL_BY_EMAIL = "select user_role.id, user_role.user_id, user_role.role_name from user inner join user_role on user.id = user_role.user_id where email = :email";

}
