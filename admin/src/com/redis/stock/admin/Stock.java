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

import java.util.prefs.Preferences;

/**
 *
 * @author Redjan Shabani
 */
public class Stock {
	private static final Preferences PREFERENCES = Preferences.userNodeForPackage(Stock.class);
	
	public static String getCode() {return PREFERENCES.get("stock_code", "");}
	public static String getName() {return PREFERENCES.get("stock_name", "");}
	public static String getAddress() {return PREFERENCES.get("stock_address", "");}
	public static String getPhone() {return PREFERENCES.get("stock_phone", "");}
	public static String getEmail() {return PREFERENCES.get("stock_email", "");}
	
	public static void setCode(String code) {PREFERENCES.put("stock_code", code);}
	public static void setName(String name) {PREFERENCES.put("stock_name", name);}
	public static void setAddress(String address) {PREFERENCES.put("stock_address", address);}
	public static void setPhone(String phone) {PREFERENCES.put("stock_phone", phone);}
	public static void setEmail(String email) {PREFERENCES.put("stock_email", email);}
	
	public static void main(String[] args) {
		Stock.setCode("L76604205F");
		Stock.setName("REDJAN SHABANI P. F.");
		Stock.setAddress("Lagja Pavaresia, Rruga F. Gjomema, Vlore 9403");
		Stock.setPhone("+355 69 20 48 755");
		Stock.setEmail("redjan.shabani@gmail.com");
	}
}
