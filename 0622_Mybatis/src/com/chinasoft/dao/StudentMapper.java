package com.chinasoft.dao;

import java.util.List;

import com.chinasoft.pojo.Student;

/*
 * ����Mapper.xml�е�ID�������ӿ���ķ���
 */
public interface StudentMapper {

	public List<Student> getStuList();
	
	public List<Student> getStuByClass(Student student);
	
	public List<Student> getStuByTwoTable(Student student);
}
