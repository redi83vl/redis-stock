/*
 * Copyright (C) 2017 Redjan Shabani
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.redis.stock.pos.core;

import com.redis.stock.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redjan Shabani
 */
public class Employee {
	private final Integer id;
	private String code, name, address, phone, email;

	private Employee(Integer id, String code, String name, String address, String phone, String email) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public Integer getId() {return id;}
	public String getCode() {return code;}
	public String getName() {return name;}
	public String getAddress() {return address;}
	public String getPhone() {return phone;}
	public String getEmail() {return email;}

	public void setCode(String code) {
		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `Employee` SET `code` = ? WHERE `id` = ?");

			preparedStatement.setString(1, code);
			preparedStatement.setInt(2, this.id);
			
			preparedStatement.execute();
			
			this.code = code;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void setName(String name) {
		
		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `Employee` SET `name` = ? WHERE `id` = ?");

			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, this.id);
			
			preparedStatement.execute();
			
			this.name = name;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setAddress(String address) {
		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `Employee` SET `address` = ? WHERE `id` = ?");

			preparedStatement.setString(1, address);
			preparedStatement.setInt(2, this.id);
			
			preparedStatement.execute();
			
			this.address = address;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setPhone(String phone) {
		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `Employee` SET `phone` = ? WHERE `id` = ?");

			preparedStatement.setString(1, phone);
			preparedStatement.setInt(2, this.id);
			
			preparedStatement.execute();
			
			this.phone = phone;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setEmail(String email) {
		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("PDATE `Employee` SET `email` = ? WHERE `id` = ?");

			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, this.id);
			
			preparedStatement.execute();
			
			this.email = email;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public String toString() {return name;}
	
	public static Employee get() {
		Employee employee = null;

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `id`, `code`, `name`, `address`, `phone`, `email` "
				+ "FROM `Employee` "
				+ "WHERE `code` = ?");

			preparedStatement.setString(1, SQL.getUsername());

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				employee = new Employee(
					resultSet.getInt("id"),
					resultSet.getString("code"), 
					resultSet.getString("name"), 
					resultSet.getString("address"), 
					resultSet.getString("phone"), 
					resultSet.getString("email")
				);
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
		}

		return employee;
	}
	
}