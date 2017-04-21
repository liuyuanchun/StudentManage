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
			System.out.println("==========ѧ������ϵͳ============");
			System.out.println("1����ѯ����ѧ����Ϣ");
			System.out.println("2�����");
			System.out.println("3���޸�");
			System.out.println("4��ɾ��");
			System.out.println("0���˳�");
			int type = scanner.nextInt();
			if(type == 0){
				break;
			}
			switch (type) {
			case 1://��ʾ����ͬѧ��Ϣ
				showStudentInfos();
				break;
			case 2://���ѧ����Ϣ
				addStudent();
				break;
			case 3://����ѧ����Ϣ
				updateStudent();
				break;
			case 4://ɾ��ѧ����Ϣ
				deleteStudent();
				break;
			default:
				break;
			}
		}
	}

	private void deleteStudent() {
		showStudentInfos();
		System.out.println("=========ɾ��ѧ����Ϣ============");
		System.out.println("������Ҫɾ����ѧ����id:");
		int id = scanner.nextInt();
		boolean flag = studentService.delete(id);
		if(flag){
			System.out.println("ɾ���ɹ�!");
		}else{
			System.out.println("ɾ��ʧ��!");
		}
	}

	private void updateStudent() {
		showStudentInfos();
		System.out.println("=========����ѧ����Ϣ===========");
		System.out.println("������Ҫ�޸�ѧ����Id");
		int id = scanner.nextInt();
		Student student = studentService.findById(id);
		System.out.println("1���޸����� 2���޸����� 3���޸��Ա�");
		int type = scanner.nextInt();
		switch(type){
		case 1:
			System.out.println("������Ҫ�޸ĵ�����:");
			String name = scanner.next();
			student.setName(name);
			break;
		case 2:
			System.out.println("������Ҫ�޸ĵ�����:");
			int age = scanner.nextInt();
			student.setAge(age);
			break;
		case 3:
			System.out.println("������Ҫ�޸ĵ�ѧ���Ա�");
			String gender = scanner.next();
			student.setGender(gender);
			break;
			default:
				break;
		}
		boolean flag = studentService.update(student);
		if(flag){
			System.out.println("�޸ĳɹ�!");
		}else{
			System.out.println("�޸�ʧ��!");
		}
	}

	private void addStudent() {
		System.out.println("=======���ѧ����Ϣ=======");
		System.out.println("������ѧ��������:");
		String name = scanner.next();
		System.out.println("������ѧ��������:");
		int age = scanner.nextInt();
		System.out.println("������ѧ�����Ա�:");
		String gender = scanner.next();
		Student student = new Student(name,age,gender);
		boolean flag = studentService.add(student);
		if(flag){
			System.out.println("��ӳɹ�!");
		}else{
			System.out.println("���ʧ��!");
		}
	}

	private void showStudentInfos() {
		System.out.println("=======��ʾѧ��������Ϣ=======");
		List<Student> list = studentService.findAll();
		for(Student student:list){
			System.out.println(student);
		}
	}
}
