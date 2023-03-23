package com.studentweb.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.studentweb.model.Student;

public class StudentDataUtil {
	List<Student> students = new ArrayList<>();
	private DataSource datasource;
	public StudentDataUtil(DataSource datasource) {
		this.datasource=datasource;

	}
	
	public void addStudent(String firstName,String lastName,String emailId) {
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			con=this.datasource.getConnection();
			String sql="insert into student(first_name, last_name, email)"+"values (?,?,?";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3,emailId);
			stmt.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(con,stmt,rs);
		}
	}
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			//get connection from the connection pool
			con=this.datasource.getConnection();
			stmt=con.createStatement();
			ResultSet resultSet=stmt.executeQuery("select * from student order by id");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String fname=resultSet.getString("first_name");
				String lname=resultSet.getString("last_name");
				String email=resultSet.getString("email");
				Student student = new Student(id,fname,lname,email);
				students.add(student);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(con,stmt,rs);
		}

		return students;
	}
	private void close(Connection con, Statement stmt, ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			if(rs !=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(con !=null) {
				con.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
