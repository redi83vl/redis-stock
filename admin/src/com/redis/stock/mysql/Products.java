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

	private static final String INSERT = ""
		+ "INSERT INTO Product (code, `group`, name, unit, costPrice, buyPrice, sellPrice, taxRatio) VALUES (?,?,?,?,?,?,?,?) "
		+ "ON DUPLICATE KEY UPDATE `group` = ?, name = ?, unit = ?, costPrice = ?, buyPrice = ?, sellPrice = ?, taxRatio = ?";
	@Override
	public boolean add(Product entry) {
		boolean success = false;
		
		try(Connection conn = DB.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement(INSERT);
			
			//INSERT INTO ... VALUES ...
			pstat.setString(1, entry.getCode());
			pstat.setString(2, entry.getGroup());
			pstat.setString(3, entry.getName());
			pstat.setString(4, entry.getUnit());
			pstat.setDouble(5, entry.getCostPrice());
			pstat.setDouble(6, entry.getBuyPrice());
			pstat.setDouble(7, entry.getSellPrice());
			pstat.setDouble(8, entry.getTaxRatio());
			
			//ON DUPLICATE KEY UPDATE ...
			pstat.setString(9, entry.getGroup());
			pstat.setString(10, entry.getName());
			pstat.setString(11, entry.getUnit());
			pstat.setDouble(12, entry.getCostPrice());
			pstat.setDouble(13, entry.getBuyPrice());
			pstat.setDouble(14, entry.getSellPrice());
			pstat.setDouble(15, entry.getTaxRatio());
			
			pstat.execute();
			
			success = true;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return success;
	}

	private static final String DELETE = "DELETE FROM Product WHERE code = ?";
	@Override
	public boolean remove(Product entry) {
		boolean success = false;	
		
		try(Connection conn = DB.getConnection()) {
			
			PreparedStatement pstat = conn.prepareStatement(DELETE);
			pstat.setString(1, entry.getCode());
			
			pstat.execute();
			
			success = true;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
		}		
		
		return success;
	}

	private static final String SELECT = "SELECT code, `group`, name, unit, costPrice, buyPrice, sellPrice, taxRatio FROM Product ORDER BY name ASC";
	@Override
	public boolean forEach(Consumer<Product> consumer) {
		boolean success = false;		
		
		try(Connection conn = DB.getConnection()) {
			
			PreparedStatement pstat = conn.prepareStatement(SELECT);
			
			ResultSet rset = pstat.executeQuery();
			
			while(rset.next()) {
				Product warehouse = new Product(
					rset.getString("code"), 
					rset.getString("group"), 
					rset.getString("name"),
					rset.getString("unit"), 
					rset.getDouble("costPrice"),
					rset.getDouble("buyPrice"),
					rset.getDouble("sellPrice"),
					rset.getDouble("taxRatio")
				);
				
				consumer.accept(warehouse);
			}		
			
			success = true;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
		}		
		
		return success;
	}
	
	public static Dataset<Product> getDataset() {
		return new Products();
	}
	
}
