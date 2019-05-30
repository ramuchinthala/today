package com.pawana.employee.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawana.employee.vo.Employee;

@Service
public class EmployeeService {

	@Autowired
	private DataSource dataSource;

	public Employee getEmployee(Integer id ) {

		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from emp where id="+id);
			
			while(resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(String.valueOf(resultSet.getInt("id")));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("adderess"));
				return employee;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;

	}

}
