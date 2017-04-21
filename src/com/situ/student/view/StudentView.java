package com.situ.student.view;

import java.util.List;
import java.util.Scanner;

import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;

public class StudentView {
	private Scanner scanner = null;
	private IStudentService studentService = null;
	public static void main(String[] args) {
		StudentView studentView = new StudentView();
		studentView.init();
		studentView.showView();
	}

	private void init() {
		scanner = new Scanner(System.in);
		studentService = new StudentServiceImpl();
	}

	private void showView() {
		while(true){
			System.out.println("==========学生管理系统============");
			System.out.println("1、查询所有学生信息");
			System.out.println("2、添加");
			System.out.println("3、修改");
			System.out.println("4、删除");
			System.out.println("0、退出");
			int type = scanner.nextInt();
			if(type == 0){
				break;
			}
			switch (type) {
			case 1://显示所有同学信息
				showStudentInfos();
				break;
			case 2://添加学生信息
				addStudent();
				break;
			case 3://更新学生信息
				updateStudent();
				break;
			case 4://删除学生信息
				deleteStudent();
				break;
			default:
				break;
			}
		}
	}

	private void deleteStudent() {
		showStudentInfos();
		System.out.println("=========删除学生信息============");
		System.out.println("请输入要删除的学生的id:");
		int id = scanner.nextInt();
		boolean flag = studentService.delete(id);
		if(flag){
			System.out.println("删除成功!");
		}else{
			System.out.println("删除失败!");
		}
	}

	private void updateStudent() {
		showStudentInfos();
		System.out.println("=========更新学生信息===========");
		System.out.println("请输入要修改学生的Id");
		int id = scanner.nextInt();
		Student student = studentService.findById(id);
		System.out.println("1、修改名字 2、修改年龄 3、修改性别");
		int type = scanner.nextInt();
		switch(type){
		case 1:
			System.out.println("请输入要修改的姓名:");
			String name = scanner.next();
			student.setName(name);
			break;
		case 2:
			System.out.println("请输入要修改的年龄:");
			int age = scanner.nextInt();
			student.setAge(age);
			break;
		case 3:
			System.out.println("请输入要修改的学生性别");
			String gender = scanner.next();
			student.setGender(gender);
			break;
			default:
				break;
		}
		boolean flag = studentService.update(student);
		if(flag){
			System.out.println("修改成功!");
		}else{
			System.out.println("修改失败!");
		}
	}

	private void addStudent() {
		System.out.println("=======添加学生信息=======");
		System.out.println("请输入学生的姓名:");
		String name = scanner.next();
		System.out.println("请输入学生的年龄:");
		int age = scanner.nextInt();
		System.out.println("请输入学生的性别:");
		String gender = scanner.next();
		Student student = new Student(name,age,gender);
		boolean flag = studentService.add(student);
		if(flag){
			System.out.println("添加成功!");
		}else{
			System.out.println("添加失败!");
		}
	}

	private void showStudentInfos() {
		System.out.println("=======显示学生所有信息=======");
		List<Student> list = studentService.findAll();
		for(Student student:list){
			System.out.println(student);
		}
	}
}
