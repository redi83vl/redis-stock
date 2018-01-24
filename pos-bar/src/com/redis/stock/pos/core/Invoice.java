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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redjan Shabani
 */
public class Invoice extends ArrayList<Invoice.Entry> implements Serializable{
	
	private final String code;
	private Instant instant;
	private Employee author;
	private Client target;
	
	public Invoice(String code, Instant instant, Employee author, Client target) {
		this.code = code;
		this.instant = instant;
		this.author = author;
		this.target = target;
	}

	public String getCode() {
		return code;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public Client getTarget() {
		return target;
	}	

	public void setTarget(Client target) {
		this.target = target;
	}

	public Employee getAuthor() {
		return author;
	}

	public void setAuthor(Employee author) {
		this.author = author;
	}

	@Override
	public boolean add(Entry entry) {
		return super.add(entry);
	}
	

	public double getValue() {
		return super.stream().mapToDouble(Invoice.Entry::getValue).sum();
	}

	public double getTaxValue() {
		return super.stream().mapToDouble(Invoice.Entry::getTaxValue).sum();
	}

	public double getGrossValue() {
		return super.stream().mapToDouble(Invoice.Entry::getGrossValue).sum();
	}
	
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.code);
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
		final Invoice other = (Invoice) obj;
		return Objects.equals(this.code, other.code);
	}
	
	public static class Entry implements Serializable{
		private final String code, name, unit;
		private double size, price, tax;

		public Entry(String code, String name, String unit, double size, double price, double tax) {
			this.code = code;
			this.name = name;
			this.unit = unit;
			this.size = size;
			this.price = price;
			this.tax = tax;
		}

		public String getCode() {return code;}
		public String getName() {return name;}
		public String getUnit() {return unit;}
		public double getSize() {return size;}
		public double getPrice() {return price;}
		public double getTax() {return tax;}		
		public double getValue() {return size * price;}		
		public double getTaxValue() {return size * price * tax;}	
		public double getGrossPrice() {return price * (1 + tax);}	
		public double getGrossValue() {return size * price * ( 1 + tax);}
		
		public void setSize(double size) {this.size = size;}
		public void setPrice(double price) {this.price = price;}
		public void setTax(double tax) {this.tax = tax;}		

		@Override
		public String toString() {return code;}

		@Override
		public int hashCode() {
			int hash = 5;
			hash = 13 * hash + Objects.hashCode(this.code);
			hash = 13 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
			hash = 13 * hash + (int) (Double.doubleToLongBits(this.tax) ^ (Double.doubleToLongBits(this.tax) >>> 32));
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
			final Entry other = (Entry) obj;
			if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
				return false;
			}
			if (Double.doubleToLongBits(this.tax) != Double.doubleToLongBits(other.tax)) {
				return false;
			}
			return Objects.equals(this.code, other.code);
		}
	}
	
	
	
	public static File toHtml(Invoice invoice) {
		
		//READING HTML TEMPLATE
		String html = "";		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("./sellout.html"))) {			
			String line;
			while((line = bufferedReader.readLine()) != null)
				html += line;
		} 
		catch (IOException ex) {
			Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		html = html.replace("DOC_CODE", invoice.getCode());
		html = html.replace("DOC_DATE_TIME", new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Date.from(invoice.getInstant())));
		html = html.replace("DOC_TARGET", String.valueOf(invoice.getTarget()));
		
		String rows = "";
		for(Invoice.Entry entry : invoice) {
			rows += "<tr>" 
				+ "<td>" + entry.getCode() + "</td>" 
				+ "<td>" + entry.getName() + "</td>" 
				+ "<td>" + entry.getUnit() + "</td>" 
				+ "<td align='right'>" + new DecimalFormat("0.00").format(entry.getSize()) + "</td>" 
				+ "<td align='right'>" + new DecimalFormat("0.00").format(entry.getPrice()) + "</td>" 
				+ "<td align='right'>" + new DecimalFormat("0.00").format(entry.getValue()) + "</td>" 
				+ "<td align='right'>" + new DecimalFormat("0.00").format(entry.getTaxValue()) + "</td>" 
				+ "<td align='right'>" + new DecimalFormat("0.00").format(entry.getGrossValue()) + "</td>" 
				+ "</tr>";
		}
		
		rows += "<tr>" 
				+ "<td colspan='5' style='font-weight:bold'>TOTAL</td>" 
				+ "<td align='right' style='font-weight:bold'>" + new DecimalFormat("0.00").format(invoice.getValue()) + "</td>" 
				+ "<td align='right' style='font-weight:bold'>" + new DecimalFormat("0.00").format(invoice.getTaxValue()) + "</td>" 
				+ "<td align='right' style='font-weight:bold'>" + new DecimalFormat("0.00").format(invoice.getGrossValue()) + "</td>" 
				+ "</tr>";
		
		html = html.replace("DOCE_ENTRIES", rows);
		
		
		
		File file = new File("./temp/" + invoice.getCode() + ".html");
		
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
			bufferedWriter.write(html);
		} 
		catch (IOException ex) {
			Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return file;
	}
	
	
	
	
	private static final String SQL_ADD = ""
		+ "INSERT INTO `Output` (`code`, `instant`, `author`, `target`, `paid`) "
		+ "VALUES (?,?,?,?,?)";
	
	private static final String SQL_ADD_ENTRY = ""
		+ "INSERT INTO `OutputEntry` (`output`, `code`, `name`, `unit`, `size`, `price`, `tax`) "
		+ "VALUES (?,?,?,?,?,?,?)";
	
	public static boolean add(Invoice invoice){
		boolean result = false;
		
		try(Connection cn = SQL.getConnection()) {
			PreparedStatement ps = cn.prepareStatement(SQL_ADD, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, invoice.getCode());
			ps.setTimestamp(2, Timestamp.from(invoice.getInstant()));
			ps.setInt(3, invoice.getAuthor().getId());
			ps.setInt(4, invoice.getTarget().getId());
			ps.setBoolean(5, true);
			ps.execute();
			
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				int invoiceId = rs.getInt(1);
				
				ps = cn.prepareStatement(SQL_ADD_ENTRY);
				
				for(Invoice.Entry entry : invoice){
					ps.setInt(1, invoiceId);
					ps.setString(2, entry.getCode());
					ps.setString(3, entry.getName());
					ps.setString(4, entry.getUnit());
					ps.setDouble(5, entry.getSize());
					ps.setDouble(6, entry.getPrice());
					ps.setDouble(7, entry.getTax());
					ps.addBatch();
				}
				
				ps.executeBatch();
				
				result = true;
			}
		} 
		catch (SQLException ex) {
			Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return result;
	}
	
	
}
