package com.siti.student.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoMySqlImpl;
import com.situ.student.entity.Student;

public class StudentDaoTest {
	@Test
	public void testAdd(){
		IStudentDao studentDao = new StudentDaoMySqlImpl();
		Student student = new Student("������",20,"Ů");
		boolean result = studentDao.add(student);
		if(result){
			System.out.println("��ӳɹ�!");
		}else{
			System.out.println("���ʧ��!");
		}
	}
	@Test
	public void testDelete(){
		IStudentDao studentDao = new StudentDaoMySqlImpl();
		boolean result = studentDao.delete(2);
		if(result){
			System.out.println("ɾ���ɹ�!");
		}else{
			System.out.println("ɾ��ʧ��!");
		}
	}
	@Test
	public void testUpdate(){
		IStudentDao studentDao = new StudentDaoMySqlImpl();
		Student student = new Student(1,"��Ԫ��",20,"Ů");
		boolean result = studentDao.update(student);
		if(result){
			System.out.println("���³ɹ�!");
		}else{
			System.out.println("����ʧ��!");
		}
	}
	@Test
	public void testFindById(){
		IStudentDao studentDao = new StudentDaoMySqlImpl();
		Student student = studentDao.findById(1);
		if(student != null){
			System.out.println(student);
		}
	}
	@Test
	public void testFindAll(){
		IStudentDao studentDao = new StudentDaoMySqlImpl();
		List<Student> list = studentDao.findAll();
		if(list != null){
			for(Student student : list){
				System.out.println(student);
			}
		}
	}
}
