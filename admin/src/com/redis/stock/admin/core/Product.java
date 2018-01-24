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
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redjan Shabani
 */
public class Product implements Comparable<Product>{
	private final String code;
	private String group, name, unit;
	private double size, cost, price, tax;

	public Product(String code, String group, String name, String unit, double size, double cost, double price, double tax) {
		this.code = code;
		this.group = group;
		this.name = name;
		this.unit = unit;
		this.size = size;
		this.cost = cost;
		this.price = price;
		this.tax = tax;
	}

	public String getCode() {
		return code;
	}

	public String getGroup() {
		return group;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public double getSize() {
		return size;
	}

	public double getCost() {
		return cost;
	}
	
	public double getValue() {
		return size * cost;
	}

	public double getPrice() {
		return price;
	}
	public double getPriceMargin() {
		return this.getCost() == 0 ? 0.0d : (this.getPrice() - this.getCost()) / this.getCost();
	}

	public double getTax() {
		return tax;
	}	
	
	public double getGrossPrice() {
		return this.getPrice() * (1 + this.getTax());
	}
	
	public double getGrossPriceMargin() {
		return this.getCost() == 0 ? 0.0d : (this.getGrossPrice() - this.getCost()) / this.getCost();
	} 

	public void setGroup(String group) {
		this.group = group;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setSize(double size) {
		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("UPDATE `Product` SET `size` = ? WHERE `code` = ?");
			pstat.setDouble(1, size);
			pstat.setString(2, this.code);
			pstat.execute();
			this.size = size;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void setCost(double cost) {
		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("UPDATE `Product` SET `cost` = ? WHERE `code` = ?");
			pstat.setDouble(1, cost);
			pstat.setString(2, this.code);
			pstat.execute();
			this.cost = cost;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	

	public void setPrice(double price) {
		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("UPDATE `Product` SET `price` = ? WHERE `code` = ?");
			pstat.setDouble(1, price);
			pstat.setString(2, this.code);
			pstat.execute();
			this.price = price;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void setTax(double tax) {
		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("UPDATE `Product` SET `tax` = ? WHERE `code` = ?");
			pstat.setDouble(1, tax);
			pstat.setString(2, this.code);
			pstat.execute();
			this.tax = tax;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 89 * hash + Objects.hashCode(this.code);
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
		final Product other = (Product) obj;
		return Objects.equals(this.code, other.code);
	}

	@Override
	public String toString() {
		return code;
	}

	@Override
	public int compareTo(Product product) {
		return (this.group + this.name).compareTo(product.group + product.name);
	}
	
	
	
	public static int getId(Product product) {
		int id = -1;

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT `id` FROM `Product` WHERE `code` = ?");			
			preparedStatement.setString(1, product.getCode());			
			ResultSet resultSet = preparedStatement.executeQuery();			
			if (resultSet.next())
				id = resultSet.getInt("id");
		} 
		catch (SQLException ex) {
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}
		return id;
	}
	
	public static Product get(int id) {
		Product product = null;

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `code`, `group`, `name`, `unit`, `size`, `cost`, `price`, `tax`"
				+ "FROM `Product` "
				+ "WHERE `id` = ?");

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				product = new Product(
					resultSet.getString("code"), 
					resultSet.getString("group"), 
					resultSet.getString("name"), 
					resultSet.getString("unit"), 
					resultSet.getDouble("size"), 
					resultSet.getDouble("cost"), 
					resultSet.getDouble("price"), 
					resultSet.getDouble("tax")
				);
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}

		return product;
	}
		
	public static Set<Product> getAll() {
		Set<Product> products = new  HashSet();

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `code`, `group`, `name`, `unit`, `size`, `cost`, `price`, `tax`"
				+ "FROM `Product` "
				+ "ORDER BY `group`, `name`, `code`");

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				products.add(
					new Product(
						resultSet.getString("code"), 
						resultSet.getString("group"), 
						resultSet.getString("name"), 
						resultSet.getString("unit"), 
						resultSet.getDouble("size"), 
						resultSet.getDouble("cost"), 
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
	
	public static List<Product> read() {
		List<Product> products = new  ArrayList<>();

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "SELECT `code`, `group`, `name`, `unit`, `size`, `cost`, `price`, `tax`"
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
						resultSet.getDouble("cost"), 
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
	
	public static int put(Product entry) {
		int id = -1;

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(""
				+ "REPLACE INTO `Product` (`code`, `group`, `name`, `unit`, `size`, `cost`, `price`, `tax`) "
				+ "VALUES (?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

			//INSERT INTO ... VALUES ...
			preparedStatement.setString(1, entry.getCode());
			preparedStatement.setString(2, entry.getGroup());
			preparedStatement.setString(3, entry.getName());
			preparedStatement.setString(4, entry.getUnit());
			preparedStatement.setDouble(5, entry.getSize());
			preparedStatement.setDouble(6, entry.getCost());
			preparedStatement.setDouble(7, entry.getSize());
			preparedStatement.setDouble(8, entry.getSize());

			preparedStatement.execute();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if(rs.next())
				id = rs.getInt(1);
		} 
		catch (SQLException ex) { 	
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return id;
	}
	
	
	public static int remove(Product product) {
		int id = Product.getId(product);

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `Product` WHERE `id` = ?");

			preparedStatement.setInt(1, id);

			preparedStatement.execute();
		} 
		catch (SQLException ex) { 
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}

		return id;
	}
	
	public static boolean delete(Product product) {
		boolean success = false;

		try(Connection connection = SQL.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `Product` WHERE `code` = ?");

			preparedStatement.setString(1, product.getCode());

			preparedStatement.execute();
			
			success = true;
		} 
		catch (SQLException ex) { 
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}

		return success;
	}
}
