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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Redjan Shabani
 */
public class Report {
	private final int id;
	private final String name;
	private final String description;
	private final String view;

	private Report(int id, String name, String description, String view) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.view = view;
	}

	public String getName() {return name;}

	public String getDescription() {return description;}
	
	public TableModel getTableModel() {
		DefaultTableModel tableModel = new DefaultTableModel();
		
		try(Connection c = SQL.getConnection()) {
			
			
			ResultSet rs = c.prepareStatement("SELECT * FROM " + this.view).executeQuery();
			
			
			//			
			int columnCount = rs.getMetaData().getColumnCount();
			String[] columnNames = new String[columnCount];
			Class[] columnClasses = new Class[columnCount];
			
			for(int i = 0; i < columnCount; i++) {				
				columnNames[i] = rs.getMetaData().getColumnName(i+1);
				
				try {columnClasses[i] = Class.forName(rs.getMetaData().getColumnClassName(i+1));} 
				catch (ClassNotFoundException ex) {columnClasses[i] = Object.class;}
			}			
			
			tableModel = new DefaultTableModel(columnNames, 0){
				@Override
				public boolean isCellEditable(int i, int i1) {return false;}

				@Override
				public Class<?> getColumnClass(int i) {return columnClasses[i];}
				
			};
			
			
			//
			while(rs.next()) {
				Object[] row = new Object[columnCount];
				for(int i = 0; i < columnCount; i++)
					row[i] = rs.getObject(columnNames[i], columnClasses[i]);
				tableModel.addRow(row);
			}
			
		} 
		catch (SQLException ex) {
			Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return tableModel;
	}
	
	public static List<Report> read() {
		List<Report> reports = new ArrayList<>();
		
		try(Connection connection = SQL.getConnection()) {
			ResultSet resultSet = connection.prepareStatement("SELECT `id`, `name`, `description`, `view` FROM `report`").executeQuery();
			while(resultSet.next()) {
				reports.add(
					new Report(
						resultSet.getInt("id"), 
						resultSet.getString("name"), 
						resultSet.getString("description"), 
						resultSet.getString("view")
					)
				);
			}
		}
		catch (SQLException ex) {
			Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return reports;
	}
}
