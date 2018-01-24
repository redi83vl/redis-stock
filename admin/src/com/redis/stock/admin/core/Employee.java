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
package com.redis.stock.admin.core;

import com.redis.stock.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `Employee` SET `email` = ? WHERE `id` = ?");

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

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 43 * hash + Objects.hashCode(this.code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Employee other = (Employee) obj;
		if (!Objects.equals(this.code, other.code)) {
			return false;
		}
		return true;
	}
	
	
	public boolean isActive() {
		
		boolean active = false;
		
		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat;
			ResultSet rset;
			
			pstat = conn.prepareStatement("SELECT COUNT(*) FROM mysql.user WHERE user = ?;");
			pstat.setString(1, this.code);
			
			rset = pstat.executeQuery();
			if(rset.next()) 
				active = rset.getInt(1) > 0;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return active;
	}
	
	public void setActive(boolean active) {
		if(active) {
			try(Connection conn = SQL.getConnection()) {
				PreparedStatement pstat;

				pstat = conn.prepareStatement("CREATE USER IF NOT EXISTS ?@'%' IDENTIFIED BY ?");
				pstat.setString(1, this.code);
				pstat.setString(2, this.code);
				pstat.execute();

				pstat = conn.prepareStatement("GRANT ALL PRIVILEGES ON *.* TO ?@'%';");
				pstat.setString(1, this.code);
				pstat.execute();
			} 
			catch (SQLException ex) {
				Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		else {
			try(Connection conn = SQL.getConnection()) {
				PreparedStatement pstat;

				pstat = conn.prepareStatement("DROP USER IF EXISTS ?;");
				pstat.setString(1, this.code);			
				pstat.execute();
			} 
			catch (SQLException ex) {
				Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
			}
		}		
	}
	
	
	public static Employee create(String code, String name, String address, String phone, String email) {
		
		Employee result = null;
		
		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(
				"INSERT INTO `Employee` (`code`, `name`, `address`, `phone`, `email`) VALUES (?,?,?,?,?) ", 
				PreparedStatement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, code);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, phone);
			preparedStatement.setString(5, email);
			preparedStatement.execute();
			
			//get generated id
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next())
				result = new Employee(resultSet.getInt(1), code, name, address, phone, email);
				
		} 
		catch (SQLException ex) {
			Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
		}	

		return result;
	}
		
	public static Employee read(int id) {
		Employee employee = null;

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `code`, `name`, `address`, `phone`, `email` "
				+ "FROM `Employee` "
				+ "WHERE `id` = ?");

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				employee = new Employee(
					id,
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
	
	public static Employee read(String code) {
		Employee employee = null;

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `id`, `code`, `name`, `address`, `phone`, `email` "
				+ "FROM `Employee` "
				+ "WHERE `code` = ?");

			preparedStatement.setString(1, code);

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


	public static List<Employee> read() {
		List<Employee> employees = new ArrayList<>();

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `id`, `code`, `name`, `address`, `phone`, `email` "
				+ "FROM `Employee` ");

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				employees.add(new Employee(
						resultSet.getInt("id"),
						resultSet.getString("code"), 
						resultSet.getString("name"), 
						resultSet.getString("address"), 
						resultSet.getString("phone"), 
						resultSet.getString("email")
					)
				);
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
		}

		return employees;
	}

	public static int delete(Employee employee) {
		
		int result = -1;

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `Employee` WHERE `id` = ?");

			preparedStatement.setInt(1, employee.getId());

			result = preparedStatement.executeUpdate();
		} 
		catch (SQLException ex) {
			Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
		}

		return result;
	}
}