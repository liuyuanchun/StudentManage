package com.situ.student.service.impl;

import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoMySqlImpl;
import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
	private IStudentDao studentDao = new StudentDaoMySqlImpl();
	@Override
	public boolean add(Student student) {
		// ���ѧ�������������ݿ����������Ͳ������
		return studentDao.add(student);
	}
	
	@Override
	public boolean delete(int id) {
		return studentDao.delete(id);
	}

	@Override
	public boolean update(Student student) {
		return studentDao.update(student);
	}

	@Override
	public Student findById(int id) {
		return studentDao.findById(id);
	}

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}
}
