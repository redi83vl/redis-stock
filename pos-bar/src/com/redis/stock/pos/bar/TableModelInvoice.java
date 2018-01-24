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
package com.redis.stock.pos.bar;

import com.redis.stock.pos.core.Invoice;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Redjan Shabani
 */
public class TableModelInvoice implements TableModel {
	
	private Invoice invoice;

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
		
		this.fireDatasetChanged();
	}

	
	
		
	

	

	
		
	@Override
	public int getRowCount() {
		return this.invoice == null ? 0 : this.invoice.size();
	}
	
	@Override
	public int getColumnCount() {
		return 6;
	}	
	
	@Override
	public String getColumnName(int col) {
		switch(col) {
			case 0: return "Kodi";
			case 1: return "Emertimi";
			case 2: return "Njesia";
			case 3: return "Sasia";
			case 4: return "Cmimi";
			case 5: return "Vlera";
			default: return null;
		}
	}

	public static final Class[] FIELD_TYPES = new Class[]{String.class, String.class, String.class, Double.class, Double.class, Double.class};
	@Override
	public Class<?> getColumnClass(int col) {
		switch(col) {
			case 0: return String.class;
			case 1: return String.class;
			case 2: return String.class;
			case 3: return Double.class;
			case 4: return Double.class;
			case 5: return Double.class;
			default: return null;
		}
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

	@Override
	public Object getValueAt(int row, int col) {			
		switch(col) {
			case 0: return invoice.get(row).getCode();
			case 1: return invoice.get(row).getName();
			case 2: return invoice.get(row).getUnit();
			case 3: return invoice.get(row).getSize();
			case 4: return invoice.get(row).getGrossPrice();
			case 5: return invoice.get(row).getGrossValue();
			default: return null;
		}
	}

	@Override
	public void setValueAt(Object o, int row, int col) {
		
	}

	
	private final Set<TableModelListener> listeners = new HashSet<>();
	
	public void fireDatasetChanged() {
		this.listeners.forEach( listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}
	
	@Override
	public void addTableModelListener(TableModelListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeTableModelListener(TableModelListener listener){ 
		listeners.remove(listener);
	}
	
}
