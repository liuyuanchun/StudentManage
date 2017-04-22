package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.entity.Student;
import com.situ.student.util.JdbcUtil;

public class StudentDaoMySqlImpl implements IStudentDao{

	@Override
	public boolean add(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = JdbcUtil.getConnection();
		String sql = "INSERT INTO student(NAME,age,gender) VALUES (?,?,?);";
		boolean result = false;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			int result1 = preparedStatement.executeUpdate();
			if(result1 > 0){
				result = true;
			}else{
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = JdbcUtil.getConnection();
		boolean result = false;
		String sql = "DELETE FROM student WHERE id =?;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int result1 = preparedStatement.executeUpdate();
			if(result1 > 0){
				result = true;
			}else{
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public boolean update(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = JdbcUtil.getConnection();
		boolean result = false;
		String sql = "UPDATE student SET NAME = ?,age =?,gender = ? WHERE id =?;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setInt(4, student.getId());
			int result1 = preparedStatement.executeUpdate();
			if(result1 > 0){
				result = true;
			}else{
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public Student findById(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Student student = null;
		connection = JdbcUtil.getConnection();
		String sql = "SELECT * FROM student WHERE id = ?;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				int studentId = resultSet.getInt("id");
				String 	name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				student = new Student(studentId,name,age,gender);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(resultSet, connection, preparedStatement);
		}
		return student;
	}
	@Override
	public List<Student> findAll() {
		List<Student> list = new ArrayList<Student>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = null;
		connection = JdbcUtil.getConnection();
		String sql = "SELECT * FROM student;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
			    student = new Student(id,name,age,gender);
			    list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(resultSet, connection, preparedStatement);
		}
		return list;
	}

	@Override
	public boolean checkStudent(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = null;
		boolean isFound = false;
		String sql = "SELECT * FROM student WHERE NAME = ?;";
		try {
			connection = JdbcUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				isFound = true;
			}else{
				isFound = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isFound;
	}
}
