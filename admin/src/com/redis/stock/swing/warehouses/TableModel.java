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
package com.redis.stock.swing.warehouses;

import com.redis.stock.core.Warehouse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Redjan Shabani
 */
public class TableModel implements javax.swing.table.TableModel{

	private final List<TableModelListener> listeners;
	private final List<Warehouse> warehouses;

	public TableModel() {
		this.warehouses = new ArrayList<>();
		this.listeners = new ArrayList<>();
	}
	
	public void add(Warehouse warehouse) {
		int idx = this.warehouses.size();
		this.warehouses.add(idx, warehouse);
		this.listeners.forEach( listener -> listener.tableChanged(new TableModelEvent(this, idx, idx, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT)));
	}
	
	public Warehouse get(int idx) {
		return this.warehouses.get(idx);
	}
	
	public void remove(Warehouse warehouse) {
		int idx = this.warehouses.indexOf(warehouse);
		this.remove(idx);
	}
	
	public void remove(int idx) {
		this.warehouses.remove(idx);
		this.listeners.forEach( listener -> listener.tableChanged(new TableModelEvent(this, idx, idx, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE)));
	}
	
	public void clear() {
		this.warehouses.clear();
		this.listeners.forEach( listener -> listener.tableChanged(new TableModelEvent(this)));
	}
	
	@Override
	public int getRowCount() {
		return warehouses.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int i) {
		switch(i) {
			case 0: return "Kodi";
			case 1: return "Emertimi";
			case 2: return "Adresa";
			case 3: return "Telefoni";
			case 4: return "Email";
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
			case 4: return String.class;
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
			case 0: return warehouses.get(i).getCode();
			case 1: return warehouses.get(i).getName();
			case 2: return warehouses.get(i).getAddress();
			case 3: return warehouses.get(i).getPhone();
			case 4: return warehouses.get(i).getEmail();
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
