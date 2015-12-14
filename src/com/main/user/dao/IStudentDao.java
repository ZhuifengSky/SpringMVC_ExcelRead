package com.main.user.dao;

import java.util.List;

import com.main.common.bean.Page;
import com.main.common.bean.PageBean;
import com.main.user.bean.StudentBean;
import com.main.user.model.Student;

public interface IStudentDao {

	/**
	 * 学生新增
	 * 
	 * @param student
	 * @return
	 */
	public Student addStudent(Student student);

	/**
	 * 学生条件查询
	 * 
	 * @param queryBean
	 * @return
	 */
	public Page<Student> findStudents(StudentBean queryBean,PageBean pageBean);

	/**
	 * 学生详情查看
	 * 
	 * @param sid
	 * @return
	 */
	public Student queryStident(String sid);
	
	
	/**
	 * 删除学生
	 * @param sid
	 */
	public void deleteStudent(String sid);
	
	/**
	 * 学生更新
	 * @param student
	 */
	public void updateStudent(Student student);
}
