package cn.craftsman18.dormitory.pojo;

public class User {
	private Integer id;
	private String name;
	private String passwd;
	private Integer permission;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Integer getPermission() {
		return permission;
	}
	public void setPermission(Integer permission) {
		this.permission = permission;
	}
	
}
