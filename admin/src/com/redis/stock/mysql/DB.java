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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

/**
 *
 * @author Redjan Shabani
 */
public class DB {
	private static final Preferences PREFERENCES = Preferences.userNodeForPackage(DB.class);
	
	
	public static String getUrl() {return PREFERENCES.get("url", "jdbc:mysql://localhost:3306/redis-stock");}	
	public static String getUsername() {return PREFERENCES.get("username", "redis-stock");}	
	public static String getPassword() {return PREFERENCES.get("password", "redis-stock");}
	
	public static void setUrl(String url) {PREFERENCES.put("url", "jdbc:mysql://localhost:3306/redis-stock");}	
	public static void setUsername(String username) {PREFERENCES.put("username", "redis-stock");}	
	public static void setPassword(String password) {PREFERENCES.put("password", "redis-stock");}
	
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB.getUrl(), DB.getUsername(), DB.getPassword());
	}
	
	public static void store(File file) {
		Properties properties = new Properties();
		
		properties.put("url", DB.getUrl());
		properties.put("username", DB.getUsername());
		properties.put("password", DB.getPassword());
		
		try(OutputStream outputStream = new FileOutputStream(file)) {
			properties.storeToXML(outputStream, "");
		} 
		catch (IOException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void load(File file) {
		Properties properties = new Properties();
		
		try(InputStream inputStream = new FileInputStream(file)) {
			properties.loadFromXML(inputStream);
		} 
		catch (IOException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		DB.setUrl(properties.getProperty("url", "jdbc:mysql://localhost:3306/redis-stock"));
		DB.setUsername(properties.getProperty("username", "redis-stock"));
		DB.setPassword(properties.getProperty("password", "redis-stock"));
	}
	
	public static void main(String[] args) {
		DB.store(new File("./database.xml"));
	}
}
