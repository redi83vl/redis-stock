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
package com.redis.stock.admin;

import com.redis.stock.SQL;
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
public class Stock {
	private final Properties properties;

	private Stock(Properties properties) {this.properties = properties;}
	
	public String getCode() {return properties.getProperty("code");}
	public String getName() {return properties.getProperty("name");}
	public String getPhone() {return properties.getProperty("phone");}
	public String getAddress() {return properties.getProperty("address");}
	public String getEmail() {return properties.getProperty("email");}	
	
	
	
	
	
	public static Stock getInstance() {
		Properties props = new Properties();
		
		try(FileInputStream fis = new FileInputStream(new File("stock.xml"))){
			props.loadFromXML(fis);
		} 
		catch (IOException ex) {
			Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return new Stock(props);		
	}	
			
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("code", "L76604205F");
		props.setProperty("name", "REDIS IT");
		props.setProperty("address", "L. PAVARESIA, RR. KOSOVA, VLORE 9403");
		props.setProperty("phone", "+355 69 20 48 755");
		props.setProperty("email", "REDJAN.SHABANI@GMAIL.COM");
		try(FileOutputStream fos = new FileOutputStream(new File("stock.xml"))){
			props.storeToXML(fos, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss")));
		}
		catch (IOException ex) {
			Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
		}		
	}

	
}
