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
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redjan Shabani
 */
public final class Product implements Comparable<Product>{
	private final String code, group, name, unit;
	private final double size, price, tax;
	

	public Product(String code, String group, String name, String unit, double size, double price, double tax) {
		this.code = code;
		this.group = group;
		this.name = name;
		this.unit = unit;
		this.size = size;
		this.price = price;
		this.tax = tax;
	}

	public String getCode() {return code;}
	public String getGroup() {return group;}
	public String getName() {return name;}
	public String getUnit() {return unit;}
	public double getSize() {return size;}
	public double getPrice() {return price;}
	public double getTax() {return tax;}	
	public double getGrossPrice() {return price * ( 1 + tax ); }
	public int compareTo(Product t) {return (this.group + this.name + this.code).compareTo(t.group + t.name + t.code);}

	@Override
	public String toString() {
		return code;
	}
	
	
	
	
	
	public static Product get(String code) {
		Product item = null;
		
		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `code`, `group`, `name`, `unit`, `size`, `price`, `tax`"
				+ "FROM `Product` "
				+ "WHERE `code` = ?");
			
			preparedStatement.setString(1, code);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				item = new Product(
					resultSet.getString("code"),
					resultSet.getString("group"), 
					resultSet.getString("name"), 
					resultSet.getString("unit"), 
					resultSet.getDouble("size"),
					resultSet.getDouble("price"), 
					resultSet.getDouble("tax")
				);
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return item;
	}
	
	public static Set<Product> getAll() {
		Set<Product> products = new TreeSet<>();
		
		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `code`, `group`, `name`, `unit`, `size`, `price`, `tax`"
				+ "FROM `Product`");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				products.add(
					new Product(
						resultSet.getString("code"),
						resultSet.getString("group"), 
						resultSet.getString("name"), 
						resultSet.getString("unit"), 
						resultSet.getDouble("size"),
						resultSet.getDouble("price"), 
						resultSet.getDouble("tax")
					)
				);
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return products;
	}

	

	
}
