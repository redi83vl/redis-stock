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

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 *
 * @author Redjan Shabani
 */
public class SQL {	
	private static final Preferences PREFERENCES = Preferences.userNodeForPackage(SQL.class);
	
	public static String getHostUrl() {return SQL.PREFERENCES.get("sql_host_url", "");}
	public static String getSchemaName() {return SQL.PREFERENCES.get("sql_schema_name", "");}
	public static String getUsername() {return SQL.PREFERENCES.get("sql_username", "");}
	public static String getPassword() {return SQL.PREFERENCES.get("sql_password", "");}
	
	public static void setHostUrl(String hostUrl) {SQL.PREFERENCES.put("sql_host_url", hostUrl);}
	public static void setSchemaName(String schemaName) {SQL.PREFERENCES.put("sql_schema_name", schemaName);}
	public static void setUsername(String username) {SQL.PREFERENCES.put("sql_username", username);}
	public static void setPassword(String password) {SQL.PREFERENCES.put("sql_password", password);}
	
	public static Connection getConnection() throws SQLException {		
		return DriverManager.getConnection(SQL.getHostUrl() + "/" + SQL.getSchemaName(), 
			SQL.getUsername(), 
			SQL.getPassword()
		);
	}
	
	public static void store() {
		try {
			PREFERENCES.exportNode(new FileOutputStream("./sql.xml"));
		} 
		catch (IOException | BackingStoreException ex) {
			Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
			
	public static void main(String[] args) {
		SQL.setHostUrl("jdbc:mysql://localhost:3306");
		SQL.setSchemaName("redis-stock");
		SQL.setUsername("admin");
		SQL.setPassword("admin");
		
		SQL.store();
	}
}

