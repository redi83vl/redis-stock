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
package com.redis.stock.admin.swing.employee;

import com.redis.stock.admin.core.Employee;
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
public class TableModelEmployees implements TableModel {
	private final List<TableModelListener> listeners;
	private final List<Employee> employees;
	
	public TableModelEmployees() {
		this.listeners = new ArrayList<>();
		this.employees = new ArrayList<>();
	}
	
	public void setEmployees(Collection<Employee> employees) {
		this.employees.clear();
		this.employees.addAll(employees);
		
		this.listeners.forEach(listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}

	@Override
	public int getRowCount() {return this.employees.size();}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public String getColumnName(int i) {
		switch(i) {
			case 0: return "Kodi";
			case 1: return "Emertimi";
			case 2: return "Adresa";
			case 3: return "Telefoni";
			case 4: return "Email";
			case 5: return "Aktiv";
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
			case 5: return Boolean.class;
			default: return null;
		}
	}

	@Override
	public boolean isCellEditable(int i, int i1) {
		switch(i1) {
			case 0: return Boolean.FALSE;
			case 1: return Boolean.FALSE;
			case 2: return Boolean.TRUE;
			case 3: return Boolean.TRUE;
			case 4: return Boolean.TRUE;
			case 5: return Boolean.TRUE;
			default: return Boolean.FALSE;
		}
	}

	@Override
	public Object getValueAt(int i, int i1) {
		switch(i1) {
			case 0: return this.employees.get(i).getCode();
			case 1: return this.employees.get(i).getName();
			case 2: return this.employees.get(i).getAddress();
			case 3: return this.employees.get(i).getPhone();
			case 4: return this.employees.get(i).getEmail();
			case 5: return this.employees.get(i).isActive();
			default: return null;
		}
	}

	@Override
	public void setValueAt(Object o, int i, int i1) {
		switch(i1) {
			case 2: this.employees.get(i).setAddress((String) o); break;
			case 3: this.employees.get(i).setPhone((String) o); break;
			case 4: this.employees.get(i).setEmail((String) o); break;
			case 5: this.employees.get(i).setActive((boolean) o); break;
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
