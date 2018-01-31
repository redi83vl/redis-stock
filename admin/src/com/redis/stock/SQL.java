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
package com.redis.stock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redjan Shabani
 */
public class SQL {		
	private final Properties properties;

	private SQL(Properties properties) {
		this.properties = properties;
	}
	
	public String getUrl() {return properties.getProperty("url");}
	public String getUsername() {return properties.getProperty("username");}
	public String getPassword() {return properties.getProperty("password");}
		
	public Connection getConnection() throws SQLException {		
		return DriverManager.getConnection(this.getUrl(),this.getUsername(), this.getPassword());
	}
	
	public static SQL getInstance() {
		Properties props = new Properties();
		
		try(FileInputStream fis = new FileInputStream(new File("mysql.xml"))){
			props.loadFromXML(fis);
		} 
		catch (IOException ex) {
			Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return new SQL(props);		
	}	
			
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("url", "jdbc:mysql//127.0.0.1:3306/redis-stock");
		props.setProperty("username", "admin");
		props.setProperty("password", "admin");
		try(FileOutputStream fos = new FileOutputStream(new File("mysql.xml"))){
			props.storeToXML(fos, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss")));
		}
		catch (IOException ex) {
			Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
		}		
	}
}

