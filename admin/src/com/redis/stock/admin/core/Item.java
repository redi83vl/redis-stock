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

import java.util.Objects;

/**
 *
 * @author Redjan Shabani
 */
public class Item {
	private final String code, name, unit;
	private double size, price, tax;

	public Item(String code, String name, String unit, double size, double price, double tax) {
		this.code = code;
		this.name = name;
		this.unit = unit;
		this.size = size;
		this.price = price;
		this.tax = tax;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public double getSize() {
		return size;
	}

	public double getPrice() {
		return price;
	}

	public double getTax() {
		return tax;
	}
	
	public double getValue() {
		return size * price;
	}
	
	public double getTaxValue() {
		return this.getValue() * this.getTax();
	}
	
	public double getGrossValue() {
		return this.getValue() + this.getTaxValue();
	}

	public void setSize(double size) {
		this.size = size;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 23 * hash + Objects.hashCode(this.code);
		hash = 23 * hash + Objects.hashCode(this.name);
		hash = 23 * hash + Objects.hashCode(this.unit);
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
		hash = 23 * hash + (int) (Double.doubleToLongBits(this.tax) ^ (Double.doubleToLongBits(this.tax) >>> 32));
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
		final Item other = (Item) obj;
		if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
			return false;
		}
		if (Double.doubleToLongBits(this.tax) != Double.doubleToLongBits(other.tax)) {
			return false;
		}
		if (!Objects.equals(this.code, other.code)) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		return Objects.equals(this.unit, other.unit);
	}
	
	
}
