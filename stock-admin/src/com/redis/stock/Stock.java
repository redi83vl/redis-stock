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
package com.redis.stock;

import com.redis.stock.core.Customer;
import com.redis.stock.core.Product;
import com.redis.stock.core.Supplier;
import com.redis.stock.core.Warehouse;
import com.redis.stock.mysql.Customers;
import com.redis.stock.mysql.Products;
import com.redis.stock.mysql.Suppliers;
import com.redis.stock.mysql.Warehouses;
import com.redis.stock.swing.FrameStock;
import com.redis.stock.utils.Dataset;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Redjan Shabani
 */
public class Stock {
	
	public Dataset<Warehouse> warehouses(){
		return Warehouses.getDataset();
	}
	
	public Dataset<Customer> customers(){
		return Customers.getDataset();
	}
	
	public Dataset<Supplier> suppliers(){
		return Suppliers.getDataset();
	}
	
	public Dataset<Product> products() {
		return Products.getDataset();
	}
	
	
	
	
	public static Stock getInstance() {
		return new Stock();
	}
	
	
	public static void main(String args[]) {
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get (key);
			if (value instanceof javax.swing.plaf.FontUIResource)
			UIManager.put (key, new javax.swing.plaf.FontUIResource("Serif",Font.PLAIN,10));
		}		
		
		try {
			UIManager.setLookAndFeel(com.jtattoo.plaf.smart.SmartLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
			Logger.getLogger(FrameStock.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(() -> {
			new FrameStock().setVisible(true);
		});
	}
}
