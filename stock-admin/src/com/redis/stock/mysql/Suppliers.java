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

import com.redis.stock.core.Supplier;
import com.redis.stock.utils.Dataset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redjan Shabani
 */
public class Suppliers implements Dataset<Supplier>{
	
	private Suppliers(){}
	
	public static Dataset<Supplier> getDataset() {
		return new Suppliers();
	}
	
	private static final String INSERT = "INSERT INTO Supplier (code, name, address, phone, email) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE name = ?, address = ?, phone = ?, email = ?";
	@Override
	public boolean insert(Supplier entry) {
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

			pstat.execute();

			success = true;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Suppliers.class.getName()).log(Level.SEVERE, null, ex);
		}

		return success;
	}

	private static final String DELETE = "DELETE FROM Supplier WHERE code = ?";
	@Override
	public boolean delete(Supplier entry) {
		boolean success = false;	

		try(Connection conn = DB.getConnection()) {

			PreparedStatement pstat = conn.prepareStatement(DELETE);
			pstat.setString(1, entry.getCode());

			pstat.execute();

			success = true;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Suppliers.class.getName()).log(Level.SEVERE, null, ex);
		}		

		return success;
	}

	private static final String SELECT = "SELECT code, name, address, phone, email FROM Supplier ORDER BY name ASC";
	@Override
	public boolean forEach(Consumer<Supplier> consumer) {
		boolean success = false;		

		try(Connection conn = DB.getConnection()) {

			PreparedStatement pstat = conn.prepareStatement(SELECT);

			ResultSet rset = pstat.executeQuery();

			while(rset.next()) {
				Supplier subject = new Supplier(
					rset.getString("code"), 
					rset.getString("name"), 
					rset.getString("address"),
					rset.getString("phone"), 
					rset.getString("email")
				);

				consumer.accept(subject);
			}		

			success = true;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Suppliers.class.getName()).log(Level.SEVERE, null, ex);
		}		

		return success;
	}

	@Override
	public Supplier select(String key) {
		Supplier customer =  null;
		
		try(Connection conn = DB.getConnection()) {

			PreparedStatement pstat = conn.prepareStatement(SELECT);

			ResultSet rset = pstat.executeQuery();

			while(rset.next()) {
				customer = new Supplier(
					rset.getString("code"), 
					rset.getString("name"), 
					rset.getString("address"),
					rset.getString("phone"), 
					rset.getString("email")
				);
			}		
		} 
		catch (SQLException ex) {
			Logger.getLogger(Warehouses.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return customer;
	}
	
	
	
	
	
}
