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
package com.redis.stock.admin.swing.supplier;

import com.redis.stock.admin.core.Supplier;
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
public class TableModelSupplier implements TableModel {
	private final List<TableModelListener> listeners;
	private final List<Supplier> suppliers;
	
	public TableModelSupplier() {
		this.listeners = new ArrayList<>();
		this.suppliers = new ArrayList<>();
	}
	
	public Supplier getSupplier(int idx) {
		if(idx < 0 || idx > this.suppliers.size()-1)
			return null;
		return this.suppliers.get(idx);
	}
	
	public void setSuppliers(Collection<Supplier> suppliers) {
		this.suppliers.clear();
		this.suppliers.addAll(suppliers);
		
		this.listeners.forEach(listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}

	@Override
	public int getRowCount() {return this.suppliers.size();}

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
		switch(i1) {
			case 0: return Boolean.TRUE;
			case 1: return Boolean.TRUE;
			case 2: return Boolean.TRUE;
			case 3: return Boolean.TRUE;
			case 4: return Boolean.TRUE;
			default: return Boolean.FALSE;
		}
	}

	@Override
	public Object getValueAt(int i, int i1) {
		switch(i1) {
			case 0: return this.suppliers.get(i).getCode();
			case 1: return this.suppliers.get(i).getName();
			case 2: return this.suppliers.get(i).getAddress();
			case 3: return this.suppliers.get(i).getPhone();
			case 4: return this.suppliers.get(i).getEmail();
			default: return null;
		}
	}

	@Override
	public void setValueAt(Object o, int i, int i1) {
		switch(i1) {
			case 0: this.suppliers.get(i).setCode((String) o); break;
			case 1: this.suppliers.get(i).setName((String) o); break;
			case 2: this.suppliers.get(i).setAddress((String) o); break;
			case 3: this.suppliers.get(i).setPhone((String) o); break;
			case 4: this.suppliers.get(i).setEmail((String) o); break;
			default: return;
		}
		
		this.listeners.forEach( listener -> {
			listener.tableChanged(new TableModelEvent(this, i, i));
		});
	}

	@Override
	public void addTableModelListener(TableModelListener tl) {this.listeners.add(tl);}

	@Override
	public void removeTableModelListener(TableModelListener tl) {this.listeners.remove(tl);}
	
}
