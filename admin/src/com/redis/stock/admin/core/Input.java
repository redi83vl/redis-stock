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
public class Input extends ArrayList<Item>{
	private final Integer id;
	private final String code;
	private Instant instant;
	private final Employee author;
	private final Supplier source;
	private boolean paid;
	
	private Input(Integer id, String code, Instant instant, Employee author, Supplier source, boolean paid) {
		this.id = id;
		this.code = code;
		this.instant = instant;
		this.author = author;
		this.source = source;
		this.paid = paid;
	}

	private Input(Integer id, String code, Instant instant, Employee author, Supplier source, boolean paid, Collection<Item> items) {
		this.id = id;
		this.code = code;
		this.instant = instant;
		this.author = author;
		this.source = source;
		this.paid = paid;
		super.addAll(items);
	}

	public Integer getId() {return id;}
	public String getCode() {return code;}
	public Instant getInstant() {return instant;}
	public Employee getAuthor() {return author;}
	public Supplier getSource() {return source;}
	public boolean isPaid() {return paid;}
	
	public double getValue(){return super.stream().mapToDouble(Item::getValue).sum();}
	public double getTaxValue(){return super.stream().mapToDouble(Item::getTaxValue).sum();}	
	public double getGrossValue(){return this.getValue() + this.getTaxValue();}
	
	public void setInstant(Instant instant) {
		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("UPDATE `Input` SET `instant` = ? WHERE `id` = ?");
			pstat.setInt(2, this.id);
			pstat.setTimestamp(1, Timestamp.from(instant));
			
			pstat.execute();
			
			this.instant = instant;			
		}
		catch (SQLException ex) {
			Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setPaid(boolean paid) {
		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("UPDATE `Input` SET `paid` = ? WHERE `id` = ?");
			pstat.setBoolean(1, paid);
			pstat.setInt(2, this.id);
			
			pstat.execute();
			
			this.paid = paid;			
		}
		catch (SQLException ex) {
			Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static File toHtml(Input input) {
		
		//READING HTML TEMPLATE
		String html = "";		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("./input.html"))) {			
			String line;
			while((line = bufferedReader.readLine()) != null)
				html += line;
		} 
		catch (IOException ex) {
			Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		html = html.replace("STOCK_CODE", Stock.getCode());
		html = html.replace("STOCK_NAME", Stock.getName());
		html = html.replace("STOCK_ADDRESS", Stock.getAddress());
		html = html.replace("STOCK_PHONE", Stock.getPhone());
		html = html.replace("STOCK_EMAIL", Stock.getEmail());
		
		html = html.replace("DOC_CODE", input.getCode());
		html = html.replace("DOC_DATE_TIME", new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Date.from(input.getInstant())));
		html = html.replace("DOC_SOURCE", String.valueOf(input.getSource()));
		html = html.replace("DOC_VALUE", new DecimalFormat("0.00").format(input.getGrossValue()));
		
		String rows = "";
		for(Item item : input) {
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
				+ "<td align='right' style='font-weight:bold'>" + new DecimalFormat("0.00").format(input.getValue()) + "</td>" 
				+ "<td align='right' style='font-weight:bold'>" + new DecimalFormat("0.00").format(input.getTaxValue()) + "</td>" 
				+ "<td align='right' style='font-weight:bold'>" + new DecimalFormat("0.00").format(input.getGrossValue()) + "</td>" 
				+ "</tr>";
		
		html = html.replace("DOC_ENTRIES", rows);
		
		
		
		File file = new File("./temp/" + input.getCode() + ".html");
		
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
			bufferedWriter.write(html);
		} 
		catch (IOException ex) {
			Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return file;
	}
	
	public static Input create(String code, Instant instant, Employee author, Supplier source, boolean paid, Collection<Item> items) {
		Input input = null;
		
		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement(""
				+ "INSERT INTO `Input` (`code`, `instant`, `author`, `source`, `paid`) "
				+ "VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstat.setString(1, code);
			pstat.setTimestamp(2, Timestamp.from(instant));
			pstat.setInt(3, author.getId());
			pstat.setInt(4, source.getId());
			pstat.setBoolean(5, paid);
			
			pstat.execute();
			
			ResultSet rset = pstat.getGeneratedKeys();
			
			if(rset.next()) {
				int id = rset.getInt(1);		
				
				pstat = conn.prepareStatement("INSERT INTO InputEntry (input, code, name, unit, size, price, tax) VALUES (?,?,?,?,?,?,?)");
				
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
				
				input = new Input(id, code, instant, author, source, paid, items);
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return input;
	}
	
	public static List<Input> read() {
		List<Input> inputs = new ArrayList<>();

		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement(""
				+ "SELECT `i`.`id`, `i`.`code`, `i`.`instant`, `i`.`author`, `i`.`source`, `i`.`paid`, SUM(`e`.`size` * `e`.`price`) AS `value`, SUM(`e`.`size` * `e`.`price` * `e`.`tax`) AS `taxValue` "
				+ "FROM `Input` `i` LEFT JOIN `InputEntry` `e` ON `i`.`id` = `e`.`input` "
				+ "GROUP BY `i`.`id` "
				+ "order by `i`.`instant` DESC");
			
			ResultSet rset = pstat.executeQuery();
			
			while(rset.next()) {
				Integer id = rset.getInt("id");
				String code = rset.getString("code");
				Instant instant = rset.getTimestamp("instant").toInstant();
				Employee author = Employee.read(rset.getInt("author"));
				Supplier source = Supplier.read(rset.getInt("source"));
				boolean paid = rset.getBoolean("paid");
				
				Input input = new Input(id, code, instant, author, source, paid);
				
				
				PreparedStatement pstat1 = conn.prepareStatement("SELECT `code`, `name`, `unit`, `size`, `price`, `tax` FROM `InputEntry` WHERE `input` = ?");
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
					
					input.add(item);
				}
				
				inputs.add(input);
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
		}

		return inputs;
	}
	
	
	public static Input read(Integer id) {
		Input input = null;

		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement(""
				+ "SELECT `id`, `code`, `instant`, `author`, `source`, `paid` "
				+ "FROM `Input` "
				+ "WHERE `id` = ?");
			
			pstat.setInt(1, id);
			
			ResultSet rset = pstat.executeQuery();
			
			if(rset.next()) {
				String code = rset.getString("code");
				Instant instant = rset.getTimestamp("instant").toInstant();
				Employee author = Employee.read(rset.getInt("author"));
				Supplier source = Supplier.read(rset.getInt("source"));
				boolean paid = rset.getBoolean("paid");
				
				input = new Input(id, code,instant,author,source,paid);
				
				pstat.close();
				
				pstat = conn.prepareStatement("SELECT `code`, `name`, `unit`, `size`, `price`, `tax` FROM `InputEntry` WHERE `input` = ?");
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
					input.add(item);
				}
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
		}

		return input;
	}
	
	
	public static Input read(String code) {
		Input input = null;

		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement(""
				+ "SELECT `id`, `code`, `instant`, `author`, `source`, `paid` "
				+ "FROM `Input` "
				+ "WHERE `code` = ?");
			
			pstat.setString(1, code);
			
			ResultSet rset = pstat.executeQuery();
			
			if(rset.next()) {
				Integer id = rset.getInt("id");
				Instant instant = rset.getTimestamp("instant").toInstant();
				Employee author = Employee.read(rset.getInt("author"));
				Supplier source = Supplier.read(rset.getInt("source"));
				boolean paid = rset.getBoolean("paid");
				
				input = new Input(id, code, instant, author, source, paid);
				
				
				pstat = conn.prepareStatement("SELECT `code`, `name`, `unit`, `size`, `price`, `tax` FROM `InputEntry` WHERE `input` = ?");
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
					
					input.add(item);
				}
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
		}

		return input;
	}

	public static boolean delete(Input input) {
		boolean result = false;
		
		try(Connection conn = SQL.getConnection()) {
			PreparedStatement pstat = conn.prepareStatement("DELETE FROM  `Input` WHERE `id` = ?");
			pstat.setInt(1, input.getId());
			
			pstat.execute();
			
			result = true;
		} 
		catch (SQLException ex) {
			Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return result;
	}
	
}


