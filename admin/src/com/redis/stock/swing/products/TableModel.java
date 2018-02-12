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
package com.redis.stock.swing.products;

import com.redis.stock.core.Product;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Redjan Shabani
 */
public class TableModel implements javax.swing.table.TableModel{

	private final List<TableModelListener> listeners;
	private final List<Product> products;

	public TableModel() {
		this.products = new ArrayList<>();
		this.listeners = new ArrayList<>();
	}
	
	public void add(Product product) {
		int idx = this.products.size();
		this.products.add(idx, product);
		this.listeners.forEach( listener -> listener.tableChanged(new TableModelEvent(this, idx, idx, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT)));
	}
	
	public Product get(int idx) {
		return this.products.get(idx);
	}
	
	public void remove(Product product) {
		int idx = this.products.indexOf(product);
		this.remove(idx);
	}
	
	public void remove(int idx) {
		this.products.remove(idx);
		this.listeners.forEach( listener -> listener.tableChanged(new TableModelEvent(this, idx, idx, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE)));
	}
	
	public void clear() {
		this.products.clear();
		this.listeners.forEach( listener -> listener.tableChanged(new TableModelEvent(this)));
	}
	
	@Override
	public int getRowCount() {
		return products.size();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public String getColumnName(int i) {
		switch(i) {
			case 0: return "Kodi";
			case 1: return "Kategoria";
			case 2: return "Emertimi";
			case 3: return "Njesia";
			case 4: return "Kosto";
			case 5: return "Blerje";
			case 6: return "Shitje";
			case 7: return "Tatim";
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
			default: return null;
		}
	}

	@Override
	public boolean isCellEditable(int i, int i1) {
		switch(i) {
			default: return false;
		}
	}

	@Override
	public Object getValueAt(int i, int i1) {
		switch(i1) {
			case 0: return products.get(i).getCode();
			case 1: return products.get(i).getGroup();
			case 2: return products.get(i).getName();
			case 3: return products.get(i).getUnit();
			case 4: return products.get(i).getCostPrice();
			case 5: return products.get(i).getBuyPrice();
			case 6: return products.get(i).getSellPrice();
			case 7: return products.get(i).getTaxRatio();
			default: return null;
		}
	}

	@Override
	public void setValueAt(Object o, int i, int i1) {
		
	}

	@Override
	public void addTableModelListener(TableModelListener tl) {this.listeners.add(tl);}

	@Override
	public void removeTableModelListener(TableModelListener tl) {this.listeners.remove(tl);}	
}
