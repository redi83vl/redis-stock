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
package com.redis.stock.admin.swing.output;

import com.redis.stock.admin.core.Client;
import com.redis.stock.admin.core.Employee;
import com.redis.stock.admin.core.Output;
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
public class TableModelOutputs implements TableModel{
	
	private final List<TableModelListener> listeners = new ArrayList();
	private final List<Output> outputs = new ArrayList<>();
		
	public void setOutputs(Collection<Output> outputs) {
		this.outputs.clear();
		this.outputs.addAll(outputs);
		
		this.listeners.forEach(listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}

	public List<Output> getOutputs() {
		return outputs;
	}
	
	
	@Override
	public int getRowCount() {return this.outputs.size();}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public String getColumnName(int i) {
		switch(i) {
			case 0: return "Kodi";
			case 1: return "Data/";
			case 2: return "Autori";
			case 3: return "Bleresi";
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
			case 3: return Client.class;
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
			case 0: return this.outputs.get(i).getCode();
			case 1: return this.outputs.get(i).getInstant();
			case 2: return this.outputs.get(i).getAuthor();
			case 3: return this.outputs.get(i).getTarget();
			case 4: return this.outputs.get(i).getValue();
			case 5: return this.outputs.get(i).getTaxValue();
			case 6: return this.outputs.get(i).getGrossValue();
			case 7: return this.outputs.get(i).isPaid();
			default: return null;
		}
	}

	@Override
	public void setValueAt(Object o, int i, int i1) {
		switch(i1) {
			case 7: this.outputs.get(i).setPaid((boolean) o); break;
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
