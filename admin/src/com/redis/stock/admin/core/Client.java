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
public class Client {
	private final Integer id;
	private String code, name, address, phone, email;

	private Client(Integer id, String code, String name, String address, String phone, String email) {
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
		try(Connection connection = SQL.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `Client` SET `code` = ? WHERE `id` = ?");

			preparedStatement.setString(1, code);
			preparedStatement.setInt(2, this.id);
			
			preparedStatement.execute();
			
			this.code = code;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void setName(String name) {
		
		try(Connection connection = SQL.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `Client` SET `name` = ? WHERE `id` = ?");

			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, this.id);
			
			preparedStatement.execute();
			
			this.name = name;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setAddress(String address) {
		try(Connection connection = SQL.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `Client` SET `address` = ? WHERE `id` = ?");

			preparedStatement.setString(1, address);
			preparedStatement.setInt(2, this.id);
			
			preparedStatement.execute();
			
			this.address = address;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setPhone(String phone) {
		try(Connection connection = SQL.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `Client` SET `phone` = ? WHERE `id` = ?");

			preparedStatement.setString(1, phone);
			preparedStatement.setInt(2, this.id);
			
			preparedStatement.execute();
			
			this.phone = phone;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setEmail(String email) {
		try(Connection connection = SQL.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("PDATE `Client` SET `email` = ? WHERE `id` = ?");

			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, this.id);
			
			preparedStatement.execute();
			
			this.email = email;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public String toString() {return name;}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 71 * hash + Objects.hashCode(this.code);
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
		final Client other = (Client) obj;
		if (!Objects.equals(this.code, other.code)) {
			return false;
		}
		return true;
	}
	
	
	
	
	public static Client create(String code, String name, String address, String phone, String email) {
		
		Client result = null;
		
		try(Connection connection = SQL.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(
				"INSERT INTO `Client` (`code`, `name`, `address`, `phone`, `email`) VALUES (?,?,?,?,?) ", 
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
				result = new Client(resultSet.getInt(1), code, name, address, phone, email);
				
		} 
		catch (SQLException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}	

		return result;
	}
		
	public static Client read(int id) {
		Client client = null;

		try(Connection connection = SQL.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `id`, `code`, `name`, `address`, `phone`, `email` "
				+ "FROM `Client` "
				+ "WHERE `id` = ?");

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				client = new Client(
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
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}

		return client;
	}
	
	public static Client read(String code) {
		Client client = null;

		try(Connection connection = SQL.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `id`, `code`, `name`, `address`, `phone`, `email` "
				+ "FROM `Client` "
				+ "WHERE `code` = ?");

			preparedStatement.setString(1, code);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				client = new Client(
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
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}

		return client;
	}


	public static List<Client> read() {
		List<Client> clients = new ArrayList<>();

		try(Connection connection = SQL.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `id`, `code`, `name`, `address`, `phone`, `email` "
				+ "FROM `Client` ");

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				clients.add(new Client(
					resultSet.getInt("id"),
					resultSet.getString("code"), 
					resultSet.getString("name"), 
					resultSet.getString("address"), 
					resultSet.getString("phone"), 
					resultSet.getString("email")
				));
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}

		return clients;
	}

	public static int delete(Client client) {
		
		int result = -1;

		try(Connection connection = SQL.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `Client` WHERE `id` = ?");
			
			
			preparedStatement.setInt(1, client.getId());

			result = preparedStatement.executeUpdate();
		} 
		catch (SQLException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}

		return result;
	}
}