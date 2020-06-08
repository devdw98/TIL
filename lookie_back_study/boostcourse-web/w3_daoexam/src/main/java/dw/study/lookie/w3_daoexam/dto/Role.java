package dw.study.lookie.w3_daoexam.dto;

public class Role {
	private int roleId;
	private String description;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() { //실제 값들이 잘 들어가있는지 확인용
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}
	
}
