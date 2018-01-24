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
package com.redis.stock.admin.swing.product;

import com.redis.stock.admin.core.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Redjan Shabani
 */
public class TableModelProducts implements TableModel{
	
	private final List<TableModelListener> listeners;
	private final List<Product> products;

	public TableModelProducts() {
		listeners = new ArrayList();
		products = new ArrayList<>();
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(Collection<Product> products) {
		this.products.clear();
		this.products.addAll(products);
		
		this.listeners.forEach(listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}
	
	
	@Override
	public int getRowCount() {return this.products.size();}

	@Override
	public int getColumnCount() {
		return 9;
	}

	@Override
	public String getColumnName(int i) {
		switch(i) {
			case 0: return "Kodi";
			case 1: return "Kategoria";
			case 2: return "Emertimi";
			case 3: return "Njesia";
			case 4: return "Sasia";
			case 5: return "Kosto";
			case 6: return "Vlera";
			case 7: return "Cmimi";
			case 8: return "Tvsh";
			default: return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int i) {
		switch(i) {
			case 0: return String.class;
			case 1: return String.class;
			case 2: return String.class;
			case 3: return String.class;
			case 4: return Double.class;
			case 5: return Double.class;
			case 6: return Double.class;
			case 7: return Double.class;
			case 8: return Double.class;
			default: return null;
		}
	}

	@Override
	public boolean isCellEditable(int i, int i1) {
		switch(i1) {
			case 0: return false;
			case 1: return false;
			case 2: return false;
			case 3: return false;
			case 4: return true;
			case 5: return true;
			case 6: return false;
			case 7: return true;
			case 8: return true;
			default: return false;
		}
	}

	@Override
	public Object getValueAt(int i, int i1) {
		switch(i1) {
			case 0: return this.products.get(i).getCode();
			case 1: return this.products.get(i).getGroup();
			case 2: return this.products.get(i).getName();
			case 3: return this.products.get(i).getUnit();
			case 4: return this.products.get(i).getSize();
			case 5: return this.products.get(i).getCost();
			case 6: return this.products.get(i).getValue();
			case 7: return this.products.get(i).getPrice();
			case 8: return this.products.get(i).getTax();
			default: return null;
		}
	}

	@Override
	public void setValueAt(Object o, int i, int i1) {
		switch(i1) {
			case 4: this.products.get(i).setSize((double) o); break;
			case 5: this.products.get(i).setCost((double) o); break;
			case 7: this.products.get(i).setPrice((double) o); break;
			case 8: this.products.get(i).setTax((double) o); break;
			default: return;
		}
		
		this.listeners.forEach(listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}

	@Override
	public void addTableModelListener(TableModelListener tl) {this.listeners.add(tl);}

	@Override
	public void removeTableModelListener(TableModelListener tl) {this.listeners.remove(tl);}
	
}
