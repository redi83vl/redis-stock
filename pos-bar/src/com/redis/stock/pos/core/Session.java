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

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Redjan Shabani
 */
public class Session implements Serializable {
	private final Employee employee;
	private final List<Product> products;
	private final List<Client> clients;
	private final List<Invoice> invoices;

	public Session(Employee employee, List<Product> products, List<Client> clients, List<Invoice> invoices) {
		this.employee = employee;
		this.products = products;
		this.clients = clients;
		this.invoices = invoices;
	}

	public Employee getEmployee() {
		return employee;
	}

	public List<Product> getProducts() {
		return products;
	}

	public List<Client> getClients() {
		return clients;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}
	
	
}
