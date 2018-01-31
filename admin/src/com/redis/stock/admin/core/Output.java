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
import com.redis.stock.admin.Stock;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redjan Shabani
 */
public class Output extends ArrayList<Item>{
	private final Integer id;
	private final String code;
	private Instant instant;
	private final Employee author;
	private final Client target;
	private boolean paid;
	
	private Output(Integer id, String code, Instant instant, Employee author, Client target, boolean paid) {
		this.id = id;
		this.code = code;
		this.instant = instant;
		this.author = author;
		this.target = target;
		this.paid = paid;
	}

	private Output(Integer id, String code, Instant instant, Employee author, Client target, boolean paid, Collection<Item> items) {
		this.id = id;
		this.code = code;
		this.instant = instant;
		this.author = author;
		this.target = target;
		this.paid = paid;
		super.addAll(items);
	}

	public Integer getId() {return id;}
	public String getCode() {return code;}
	public Instant getInstant() {return instant;}
	public Employee getAuthor() {return author;}
	public Client getTarget() {return target;}
	public boolean isPaid() {return paid;}
	
	public double getValue(){return super.stream().mapToDouble(Item::getValue).sum();}
	public double getTaxValue(){return super.stream().mapToDouble(Item::getTaxValue).sum();}	
	public double getGrossValue(){return this.getValue() + this.getTaxValue();}
	
	public void setInstant(Instant instant) {
		try(Connection conn = SQL.getInstance().getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("UPDATE `Output` SET `instant` = ? WHERE `id` = ?");
			pstat.setInt(2, this.id);
			pstat.setTimestamp(1, Timestamp.from(instant));
			
			pstat.execute();
			
			this.instant = instant;			
		}
		catch (SQLException ex) {
			Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setPaid(boolean paid) {
		try(Connection conn = SQL.getInstance().getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("UPDATE `Output` SET `paid` = ? WHERE `id` = ?");
			pstat.setBoolean(1, paid);
			pstat.setInt(2, this.id);
			
			pstat.execute();
			
			this.paid = paid;			
		}
		catch (SQLException ex) {
			Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static File toHtml(Output output) {
		
		//READING HTML TEMPLATE
		String html = "";		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("./output.html"))) {			
			String line;
			while((line = bufferedReader.readLine()) != null)
				html += line;
		} 
		catch (IOException ex) {
			Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		Stock stock = Stock.getInstance();		
		html = html.replace("STOCK_CODE", stock.getCode());
		html = html.replace("STOCK_NAME", stock.getName());
		html = html.replace("STOCK_ADDRESS", stock.getAddress());
		html = html.replace("STOCK_PHONE", stock.getPhone());
		html = html.replace("STOCK_EMAIL", stock.getEmail());
		
		html = html.replace("DOC_CODE", output.getCode());
		html = html.replace("DOC_DATE_TIME", new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Date.from(output.getInstant())));
		html = html.replace("DOC_TARGET", String.valueOf(output.getTarget()));
		html = html.replace("DOC_VALUE", new DecimalFormat("0.00").format(output.getGrossValue()));
		
		String rows = "";
		for(Item item : output) {
			rows += "<tr>" 
				+ "<td>" + item.getCode() + "</td>" 
				+ "<td>" + item.getName() + "</td>" 
				+ "<td>" + item.getUnit() + "</td>" 
				+ "<td align='right'>" + new DecimalFormat("0.00").format(item.getSize()) + "</td>" 
				+ "<td align='right'>" + new DecimalFormat("0.00").format(item.getPrice()) + "</td>" 
				+ "<td align='right'>" + new DecimalFormat("0.00").format(item.getValue()) + "</td>" 
				+ "<td align='right'>" + new DecimalFormat("0.00").format(item.getTaxValue()) + "</td>" 
				+ "<td align='right'>" + new DecimalFormat("0.00").format(item.getGrossValue()) + "</td>" 
				+ "</tr>";
		}
		
		rows += "<tr>" 
				+ "<td colspan='5' style='font-weight:bold'>TOTAL</td>" 
				+ "<td align='right' style='font-weight:bold'>" + new DecimalFormat("0.00").format(output.getValue()) + "</td>" 
				+ "<td align='right' style='font-weight:bold'>" + new DecimalFormat("0.00").format(output.getTaxValue()) + "</td>" 
				+ "<td align='right' style='font-weight:bold'>" + new DecimalFormat("0.00").format(output.getGrossValue()) + "</td>" 
				+ "</tr>";
		
		html = html.replace("DOC_ENTRIES", rows);
		
		
		
		File file = new File("./temp/" + output.getCode() + ".html");
		
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
			bufferedWriter.write(html);
		} 
		catch (IOException ex) {
			Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return file;
	}
	
	public static Output create(String code, Instant instant, Employee author, Client target, boolean paid, Collection<Item> items) {
		Output output = null;
		
		try(Connection conn = SQL.getInstance().getConnection()) {
			PreparedStatement pstat = conn.prepareStatement(""
				+ "INSERT INTO `Output` (`code`, `instant`, `author`, `target`, `paid`) "
				+ "VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstat.setString(1, code);
			pstat.setTimestamp(2, Timestamp.from(instant));
			pstat.setInt(3, author.getId());
			pstat.setInt(4, target.getId());
			pstat.setBoolean(5, paid);
			
			pstat.execute();
			
			ResultSet rset = pstat.getGeneratedKeys();
			
			if(rset.next()) {
				int id = rset.getInt(1);		
				
				pstat = conn.prepareStatement("INSERT INTO OutputEntry (output, code, name, unit, size, price, tax) VALUES (?,?,?,?,?,?,?)");
				
				for(Item item : items) {
					pstat.setInt(1, id);
					pstat.setString(2, item.getCode());
					pstat.setString(3, item.getName());
					pstat.setString(4, item.getUnit());
					pstat.setDouble(5, item.getSize());
					pstat.setDouble(6, item.getPrice());
					pstat.setDouble(7, item.getTax());
					
					pstat.addBatch();
				} 
				
				pstat.executeBatch();
				
				output = new Output(id, code, instant, author, target, paid, items);
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return output;
	}
	
	public static List<Output> read() {
		List<Output> outputs = new ArrayList<>();

		try(Connection conn = SQL.getInstance().getConnection()) {
			PreparedStatement pstat = conn.prepareStatement(""
				+ "SELECT `o`.`id`, `o`.`code`, `o`.`instant`, `o`.`author`, `o`.`target`, `o`.`paid`, SUM(`e`.`size` * `e`.`price`) AS `value`, SUM(`e`.`size` * `e`.`price` * `e`.`tax`) AS `taxValue` "
				+ "FROM `Output` `o` LEFT JOIN `OutputEntry` `e` ON `o`.`id` = `e`.`output` "
				+ "GROUP BY `o`.`id` "
				+ "ORDER BY `o`.`instant` DESC");
			
			ResultSet rset = pstat.executeQuery();
			
			while(rset.next()) {
				Integer id = rset.getInt("id");
				String code = rset.getString("code");
				Instant instant = rset.getTimestamp("instant").toInstant();
				Employee author = Employee.read(rset.getInt("author"));
				Client target = Client.read(rset.getInt("target"));
				boolean paid = rset.getBoolean("paid");
				
				Output output = new Output(id, code, instant, author, target, paid);
				
				
				PreparedStatement pstat1 = conn.prepareStatement("SELECT `code`, `name`, `unit`, `size`, `price`, `tax` FROM `OutputEntry` WHERE `output` = ?");
				pstat1.setInt(1, id);
				ResultSet rset1 = pstat1.executeQuery();
				while(rset1.next()) {
					Item item = new Item(
						rset1.getString("code"),
						rset1.getString("name"),
						rset1.getString("unit"), 
						rset1.getDouble("size"), 
						rset1.getDouble("price"),
						rset1.getDouble("tax")
					);
					
					output.add(item);
				}
				
				outputs.add(output);
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
		}

		return outputs;
	}
	
	
	public static Output read(Integer id) {
		Output output = null;

		try(Connection conn = SQL.getInstance().getConnection()) {
			PreparedStatement pstat = conn.prepareStatement(""
				+ "SELECT `id`, `code`, `instant`, `target`, `paid` "
				+ "FROM `Output` "
				+ "WHERE `id` = ?");
			
			pstat.setInt(1, id);
			
			ResultSet rset = pstat.executeQuery();
			
			if(rset.next()) {
				String code = rset.getString("code");
				Instant instant = rset.getTimestamp("instant").toInstant();
				Employee author = Employee.read(rset.getInt("author"));
				Client target = Client.read(rset.getInt("target"));
				boolean paid = rset.getBoolean("paid");
				
				output = new Output(id, code,instant,author,target,paid);
				
				pstat.close();
				
				pstat = conn.prepareStatement("SELECT `code`, `name`, `unit`, `size`, `price`, `tax` FROM `OutputEntry` WHERE `output` = ?");
				rset = pstat.executeQuery();
				while(rset.next()) {
					Item item = new Item(
						rset.getString("code"),
						rset.getString("name"),
						rset.getString("unit"), 
						rset.getDouble("size"), 
						rset.getDouble("price"),
						rset.getDouble("tax")
					);
				}
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
		}

		return output;
	}
	
	
	public static Output read(String code) {
		Output output = null;

		try(Connection conn = SQL.getInstance().getConnection()) {
			PreparedStatement pstat = conn.prepareStatement(""
				+ "SELECT `id`, `code`, `instant`, `author`, `target`, `paid` "
				+ "FROM `Output` "
				+ "WHERE `code` = ?");
			
			pstat.setString(1, code);
			
			ResultSet rset = pstat.executeQuery();
			
			if(rset.next()) {
				Integer id = rset.getInt("id");
				Instant instant = rset.getTimestamp("instant").toInstant();
				Employee author = Employee.read(rset.getInt("author"));
				Client target = Client.read(rset.getInt("target"));
				boolean paid = rset.getBoolean("paid");
				
				output = new Output(id, code, instant, author, target, paid);
				
				
				pstat = conn.prepareStatement("SELECT `code`, `name`, `unit`, `size`, `price`, `tax` FROM `OutputEntry` WHERE `output` = ?");
				pstat.setInt(1, id);
				rset = pstat.executeQuery();
				while(rset.next()) {
					Item item = new Item(
						rset.getString("code"),
						rset.getString("name"),
						rset.getString("unit"), 
						rset.getDouble("size"), 
						rset.getDouble("price"),
						rset.getDouble("tax")
					);
					
					output.add(item);
				}
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
		}

		return output;
	}
	
	public static Output read(Connection conn, String code) throws SQLException {
		Output output = null;

		PreparedStatement pstat;
		ResultSet rset;
		
		
		
		pstat = conn.prepareStatement(""
				+ "SELECT `id`, `code`, `instant`, `author`, `target`, `paid` "
				+ "FROM `Output` "
				+ "WHERE `code` = ?");			
		pstat.setString(1, code);
		rset = pstat.executeQuery();

		if(rset.next()) {
			Integer id = rset.getInt("id");
			Instant instant = rset.getTimestamp("instant").toInstant();
			Employee author = Employee.read(rset.getInt("author"));
			Client target = Client.read(rset.getInt("target"));
			boolean paid = rset.getBoolean("paid");

			output = new Output(id, code, instant, author, target, paid);			

			pstat = conn.prepareStatement("SELECT `code`, `name`, `unit`, `size`, `price`, `tax` FROM `OutputEntry` WHERE `output` = ?");
			pstat.setInt(1, id);
			rset = pstat.executeQuery();
			while(rset.next()) {
				Item item = new Item(
					rset.getString("code"),
					rset.getString("name"),
					rset.getString("unit"), 
					rset.getDouble("size"), 
					rset.getDouble("price"),
					rset.getDouble("tax")
				);

				output.add(item);
			}
		}
		
		return output;
	}

	public static boolean delete(Output output) {
		boolean result = false;
		
		try(Connection conn = SQL.getInstance().getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("DELETE FROM  `Output` WHERE `id` = ?");
			pstat.setInt(1, output.getId());
			
			pstat.execute();
			
			result = true;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return result;
	}
	
}


