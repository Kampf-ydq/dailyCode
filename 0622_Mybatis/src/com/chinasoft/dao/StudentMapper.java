package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.pojo.Student;

/*
 * 对于Mapper.xml中的ID来创建接口里的方法
 */
public interface StudentMapper {

	public List<Student> getStuList();
	
	public List<Student> getStuByClass(Student student);
	
	public List<Student> getStuByTwoTable(Student student);
}
