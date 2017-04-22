package com.situ.student.service;

import java.util.List;

import com.situ.student.entity.Student;
import com.situ.student.exception.NameRepeatException;

public interface IStudentService {
	/**
	 * ���ѧ��
	 * @param liu
	 * @return true:��ӳɹ�  false�����ʧ��
	 */
	public abstract boolean add(Student student) throws NameRepeatException; 
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
	 * @param student
	 * @return
	 */
	public abstract List<Student> findAll();
}
