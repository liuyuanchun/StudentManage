package com.situ.student.dao;

import java.util.List;

import com.situ.student.entity.Student;
	/**
	 * ��Student�����Ľӿ�
	 * @ author liu
	 */
public interface IStudentDao {
	/**
	 * ���ѧ��
	 * @param liu
	 * @return true:��ӳɹ�  false�����ʧ��
	 */
	public abstract boolean add(Student student);
	/**
	 * ����idɾ��ѧ��
	 * @param liu
	 * @return true:ɾ���ɹ�  false��ɾ��ʧ��
	 */
	public abstract boolean delete(int id);
	/**
	 * ����Student
	 * @param liu
	 * @return true:���³ɹ�  false������ʧ��
	 */
	public abstract boolean update(Student student);
	/**
	 * ����id����ָ����ѧ��
	 * @param student
	 * @return
	 */
	public abstract Student findById(int id);
	/**
	 * ��ѯ����ѧ��
	 * @param i
	 * @return
	 */
	public abstract List<Student> findAll();
	/**
	 * ���ָ�������������ݿ����Ƿ����
	 * @return true:����  false: ������
	 */
	public abstract boolean checkStudent(String name);
}
