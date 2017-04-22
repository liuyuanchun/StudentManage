package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.Student;
	/**
	 * 对Student操作的接口
	 * @ author liu
	 */
public interface IStudentDao {
	/**
	 * 添加学生
	 * @param liu
	 * @return true:添加成功  false：添加失败
	 */
	public abstract boolean add(Student student);
	/**
	 * 根据id删除学生
	 * @param liu
	 * @return true:删除成功  false：删除失败
	 */
	public abstract boolean delete(int id);
	/**
	 * 更新Student
	 * @param liu
	 * @return true:更新成功  false：更新失败
	 */
	public abstract boolean update(Student student);
	/**
	 * 根据id查找指定的学生
	 * @param student
	 * @return
	 */
	public abstract Student findById(int id);
	/**
	 * 查询所有学生
	 * @param i
	 * @return
	 */
	public abstract List<Student> findAll();
	/**
	 * 检查指定的名字在数据库中是否存在
	 * @return true:存在  false: 不存在
	 */
	public abstract boolean checkStudent(String name);
}
