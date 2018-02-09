/*
 * Copyright (C) 2018 Redjan Shabani
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
package com.redis.stock.mysql;

import com.redis.stock.core.Customer;
import com.redis.stock.utils.Dataset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redjan Shabani
 */
public class Customers implements Dataset<Customer>{

	private static final String INSERT = "INSERT INTO Customer (code, name, address, phone, email) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE name = ?, address = ?, phone = ?, email = ?";
	@Override
	public boolean insert(Customer entry) {
		boolean success = false;
		
		try(Connection conn = DB.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement(INSERT);
			
			//INSERT INTO ... VALUES ...
			pstat.setString(1, entry.getCode());
			pstat.setString(2, entry.getName());
			pstat.setString(3, entry.getAddress());
			pstat.setString(4, entry.getPhone());
			pstat.setString(5, entry.getEmail());
			
			//ON DUPLICATE KEY UPDATE ...
			pstat.setString(6, entry.getName());
			pstat.setString(7, entry.getAddress());
			pstat.setString(8, entry.getPhone());
			pstat.setString(9, entry.getEmail());
		} 
		catch (SQLException ex) {
			Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return success;
	}

	private static final String DELETE = "DELETE FROM Customer WHERE code = ?";
	@Override
	public boolean delete(Customer entry) {
		boolean success = false;	
		
		try(Connection conn = DB.getConnection()) {
			
			PreparedStatement pstat = conn.prepareStatement(DELETE);
			
			pstat.execute();
			
			success = true;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
		}		
		
		return success;
	}

	private static final String SELECT = "SELECT code, name, address, phone, email FROM Customer ORDER BY name ASC";
	@Override
	public boolean forEahc(Consumer<Customer> consumer) {
		boolean success = false;		
		
		try(Connection conn = DB.getConnection()) {
			
			PreparedStatement pstat = conn.prepareStatement(SELECT);
			
			ResultSet rset = pstat.executeQuery();
			
			while(rset.next()) {
				Customer warehouse = new Customer(
					rset.getString("code"), 
					rset.getString("name"), 
					rset.getString("address"),
					rset.getString("phone"), 
					rset.getString("email")
				);
				
				consumer.accept(warehouse);
			}		
			
			success = true;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
		}		
		
		return success;
	}
	
}
