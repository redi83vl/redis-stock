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

import com.redis.stock.core.Product;
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
public class Products implements Dataset<Product>{
	
	private Products(){}
	
	public static Dataset<Product> getDataset() {
		return new Products();
	}
	
	@Override
	public Product select(String code) {
		Product entry = null;
		
		String sql = "SELECT `code`, `group`, `name`, `unit`, `size`, `cost`, `price`, `tax` FROM `Product` WHERE `code` = ?;";
		try(Connection conn = DB.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				entry = new Product(
					rs.getString(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getString(4), 
					rs.getDouble(5), 
					rs.getDouble(6), 
					rs.getDouble(7), 
					rs.getDouble(8)
				);
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return entry;
	}

	@Override
	public boolean insert(Product entry) {
		boolean success = false;
		
		String sql = ""
			+ "INSERT INTO `Product` (`code`, `group`, `name`, `unit`, `size`, `cost`, `price`, `tax`) VALUES (?,?,?,?,?,?,?,?) "
			+ "ON DUPLICATE KEY UPDATE `group` = ?, `name` = ?, `unit` = ?, `size` = ?, `cost` = ?, `price` = ?, `tax` = ?;";
		
		try(Connection conn = DB.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//INSERT INTO ... VAKLUES ...
			ps.setString(1, entry.getCode());
			ps.setString(2, entry.getGroup());
			ps.setString(3, entry.getName());
			ps.setString(4, entry.getUnit());
			ps.setDouble(5, entry.getSize()); 
			ps.setDouble(6, entry.getCost());
			ps.setDouble(7, entry.getPrice());
			ps.setDouble(8, entry.getTax());
			
			// ON DUPLICATE KEYS UPDATE ...
			ps.setString(9, entry.getGroup());
			ps.setString(10, entry.getName());
			ps.setString(11, entry.getUnit());
			ps.setDouble(12, entry.getSize());
			ps.setDouble(13, entry.getCost());
			ps.setDouble(14, entry.getPrice());
			ps.setDouble(15, entry.getTax());
			
			ps.execute();
			
			success = true;
			
		} 
		catch (SQLException ex) {
			Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return success;
	}

	@Override
	public boolean delete(Product entry) {
		boolean success = false;
		
		String sql = "DELETE FROM `Product` WHERE `code` = ?;";
		
		try(Connection conn = DB.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, entry.getCode());
			ps.execute();
			
			success = true;
			
		} 
		catch (SQLException ex) {
			Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return success;
	}

	@Override
	public boolean forEach(Consumer<Product> consumer) {
		boolean success = false;
		
		String sql = "SELECT `code`, `group`, `name`, `unit`, `size`, `cost`, `price`, `tax` FROM `Product` ";
		try(Connection conn = DB.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				consumer.accept(
					new Product(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getDouble(5), 
						rs.getDouble(6), 
						rs.getDouble(7), 
						rs.getDouble(8)
					)
				);
			}
			
			success = true;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return success;
	}
}
