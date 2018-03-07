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
package com.redis.stock.core;

import java.util.Objects;

/**
 *
 * @author Redjan Shabani
 */
public class Product {
	private final String code, group, name, unit;
	private final Double size, cost, price, tax;

	public Product(String code, String group, String name, String unit, Double size, Double cost, Double price, Double tax) {
		this.code = code;
		this.group = group;
		this.name = name;
		this.unit = unit;
		this.size = size;
		this.cost = cost;
		this.price = price;
		this.tax = tax;
	}

	public String getCode() {
		return code;
	}

	public String getGroup() {
		return group;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public Double getSize() {
		return size;
	}

	public Double getCost() {
		return cost;
	}
	
	public Double getValue() {
		return size * cost;
	}
	

	public Double getPrice() {
		return price;
	}

	public Double getTax() {
		return tax;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 83 * hash + Objects.hashCode(this.code);
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
		final Product other = (Product) obj;
		return Objects.equals(this.code, other.code);
	}

	
}
