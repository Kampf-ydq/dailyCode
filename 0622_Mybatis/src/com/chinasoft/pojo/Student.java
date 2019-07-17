package com.chinasoft.pojo;

public class Student {

	private String s_id;
 	private String s_name;
 	private String s_age;
 	private String s_sex;
 	private String s_class;
 	
 	//private String roleName; //此属性为表r_role所对应的字段
 	
 	private Role role;
 	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String s_id, String s_name, String s_age, String s_sex, String s_class) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_age = s_age;
		this.s_sex = s_sex;
		this.s_class = s_class;
	}
	
	
	
	/*public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}*/

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getS_id() {
		return s_id;
	}
	
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_age() {
		return s_age;
	}
	public void setS_age(String s_age) {
		this.s_age = s_age;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}

	
	
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", s_age=" + s_age + ", s_sex=" + s_sex + ", s_class="
				+ s_class + "]";
	}
}
