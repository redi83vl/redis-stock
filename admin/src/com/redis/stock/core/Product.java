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

/**
 *
 * @author Redjan Shabani
 */
public class Product {
	private final String code, group, name, unit;
	private Double costPrice, buyPrice, sellPrice, taxRatio;

	public Product(String code, String group, String name, String unit, Double costPrice, Double buyPrice, Double sellPrice, Double taxRatio) {
		this.code = code;
		this.group = group;
		this.name = name;
		this.unit = unit;
		this.costPrice = costPrice;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.taxRatio = taxRatio;
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

	public Double getCostPrice() {
		return costPrice;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public Double getTaxRatio() {
		return taxRatio;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public void setTaxRatio(Double taxRatio) {
		this.taxRatio = taxRatio;
	}
}
