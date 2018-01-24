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
package com.redis.stock.admin.swing.input;

import com.redis.stock.admin.core.Supplier;
import com.redis.stock.admin.core.Employee;
import com.redis.stock.admin.core.Input;
import java.time.Instant;
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
public class TableModelInputs implements TableModel{
	
	private final List<TableModelListener> listeners = new ArrayList();
	private final List<Input> inputs = new ArrayList<>();
		
	public void setInputs(Collection<Input> inputs) {
		this.inputs.clear();
		this.inputs.addAll(inputs);
		
		this.listeners.forEach(listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}

	public List<Input> getInputs() {
		return inputs;
	}
	
	
	@Override
	public int getRowCount() {return this.inputs.size();}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public String getColumnName(int i) {
		switch(i) {
			case 0: return "Kodi";
			case 1: return "Data/Ora";
			case 2: return "Autori";
			case 3: return "Shitesi";
			case 4: return "Vlera";
			case 5: return "TVSH";
			case 6: return "Total";
			case 7: return "Paguar";
			default: return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int i) {
		switch(i) {
			case 0: return String.class;
			case 1: return Instant.class;
			case 2: return Employee.class;
			case 3: return Supplier.class;
			case 4: return Double.class;
			case 5: return Double.class;
			case 6: return Double.class;
			case 7: return Boolean.class;
			default: return null;
		}
	}

	@Override
	public boolean isCellEditable(int i, int i1) {
		switch(i1) {
			case 7: return true;
			default: return Boolean.FALSE;
		}
	}

	@Override
	public Object getValueAt(int i, int i1) {
		switch(i1) {
			case 0: return this.inputs.get(i).getCode();
			case 1: return this.inputs.get(i).getInstant();
			case 2: return this.inputs.get(i).getAuthor();
			case 3: return this.inputs.get(i).getSource();
			case 4: return this.inputs.get(i).getValue();
			case 5: return this.inputs.get(i).getTaxValue();
			case 6: return this.inputs.get(i).getGrossValue();
			case 7: return this.inputs.get(i).isPaid();
			default: return null;
		}
	}

	@Override
	public void setValueAt(Object o, int i, int i1) {
		switch(i1) {
			case 7: this.inputs.get(i).setPaid((boolean) o); break;
			default: return;
		}
		
		this.listeners.forEach(listener -> {
			listener.tableChanged(new TableModelEvent(this, i, i));
		});
	}

	@Override
	public void addTableModelListener(TableModelListener tl) {this.listeners.add(tl);}

	@Override
	public void removeTableModelListener(TableModelListener tl) {this.listeners.remove(tl);}
	
}
