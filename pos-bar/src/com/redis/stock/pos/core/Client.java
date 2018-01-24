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
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redjan Shabani
 */
public class Client implements Serializable{
	private final Integer id;
	private final String code, name, address, phone, email;

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

	@Override
	public String toString() {return name;}

	public static List<Client> getAll() {
		List<Client> clients = new ArrayList<>();

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `id`, `code`, `name`, `address`, `phone`, `email` "
				+ "FROM `Client` "
				+ "ORDER BY `name` ASC");

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				clients.add(new Client(
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
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}

		return clients;
	}
}