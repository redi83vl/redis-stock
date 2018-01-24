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
package com.redis.stock.pos.core;

import com.redis.stock.pos.bar.FrameMain;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redjan Shabani
 */
public class Session implements Serializable {
	private final Instant startInstant;
	private final Employee employee;
	private final List<Product> products;
	private final List<Client> clients;
	private Map<Client, Invoice> invoices = new HashMap<>();

	public Session(Employee employee, List<Product> products, List<Client> clients) {
		this.startInstant = Instant.now();
		this.employee = employee;
		this.products = products;
		this.clients = clients;
		this.invoices = new HashMap<>();
	}

	public Instant getStartInstant() {return startInstant;}

	public Employee getEmployee() {return employee;}

	public List<Product> getProducts() {
		return products;
	}

	public List<Client> getClients() {
		return clients;
	}

	public Map<Client, Invoice> getInvoices() {
		return invoices;
	}
	
	private static final File SESSION = new File("session.dat");
	
	public static void store(Session session) throws IOException {
		try(	FileOutputStream fos = new FileOutputStream(SESSION); 
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(session);
		}
		catch (IOException ex) {
			Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static Session load() {
		Session session = null;
		
		try(	FileInputStream fis = new FileInputStream(SESSION);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			session = (Session) ois.readObject();
		} 
		catch (IOException | ClassNotFoundException ex) {
			Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return session;
	}
	
	public static Session newInstance(String employee) {
		return new Session(
			Employee.get(employee), 
			Product.getAll(), 
			Client.getAll()
		);
	}
	 
}
