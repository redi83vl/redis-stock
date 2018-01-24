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
package com.redis.stock.pos.market;

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
		return this.invoice == null ? 0 : this.invoice.size() + 1;
	}
	
	public static final int FIELD_COUNT = 6;
	@Override
	public int getColumnCount() {return FIELD_COUNT;}	
	
	public static final String[] FIELD_NAMES = {"Kodi", "Emertimi", "Njesia", "Sasia", "Cmimi", "Vlera"};
	@Override
	public String getColumnName(int i) {return FIELD_NAMES[i];}

	public static final Class[] FIELD_TYPES = new Class[]{String.class, String.class, String.class, Double.class, Double.class, Double.class};
	@Override
	public Class<?> getColumnClass(int i) {
		return FIELD_TYPES[i];
	}

	public static final Boolean[] FIELD_EDITS = {	Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE};
	@Override
	public boolean isCellEditable(int row, int col) {
		if(row == this.invoice.size()) return false;
		
		return FIELD_EDITS[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		if(row == this.invoice.size()) {
			switch(col) {
				case 8: return invoice.getGrossValue();
				default: return null;
			}
		}
		
		
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
		if(row == this.invoice.size()) {
			return;
		}
		
		switch(col) {
			case 3: if(o instanceof Number) invoice.get(row).setSize(((Number) o).doubleValue()); break;
			default: return;
		}
		
		this.fireDatasetChanged();
	}

	
	private final Set<TableModelListener> listeners = new HashSet<>();
	
	public void fireDatasetChanged() {
		this.listeners.forEach( listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}
	
	public void fireEntryChanged(int idx) {
		this.listeners.forEach( listener -> {
			listener.tableChanged(new TableModelEvent(this, idx, idx));
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
