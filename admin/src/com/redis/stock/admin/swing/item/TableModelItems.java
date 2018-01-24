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
package com.redis.stock.admin.swing.item;

import com.redis.stock.admin.core.Item;
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
public class TableModelItems implements TableModel{
	
	private final List<TableModelListener> listeners;
	private final List<Item> items;

	public TableModelItems() {
		listeners = new ArrayList();
		items = new ArrayList<>();
	}
	
	public void addRow(String code, String name, String unit) {
		this.items.add(new Item(code, name, unit, 1.0, 0, 0));
		this.listeners.forEach(listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}
	
	public void addRow(String code, String name, String unit, Double size, Double price, Double tax) {
		this.items.add(new Item(code, name, unit, 1.0, price, tax));
		this.listeners.forEach(listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}
	
	public void addItem(Item item) {
		items.add(item);
		
		this.listeners.forEach(listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}

	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(Collection<Item> items) {
		this.items.clear();
		this.items.addAll(items);
		
		this.listeners.forEach(listener -> {
			listener.tableChanged(new TableModelEvent(this));
		});
	}
	
	
	@Override
	public int getRowCount() {return this.items.size() + 1;}

	@Override
	public int getColumnCount() {
		return 9;
	}

	@Override
	public String getColumnName(int i) {
		switch(i) {
			case 0: return "Kodi";
			case 1: return "Emertimi";
			case 2: return "Njesia";
			case 3: return "Sasia";
			case 4: return "Cmimi";
			case 5: return "Tvsh %";
			case 6: return "Vlera";
			case 7: return "Tvsh";
			case 8: return "Total";
			default: return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int i) {
		switch(i) {
			case 0: return String.class;
			case 1: return String.class;
			case 2: return String.class;
			case 3: return Double.class;
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
			case 3: return i != this.items.size() && true;
			case 4: return i != this.items.size() && true;
			case 5: return i != this.items.size() && true;
			default: return Boolean.FALSE;
		}
	}

	@Override
	public Object getValueAt(int i, int i1) {
		switch(i1) {
			case 0: return i == items.size() ? null : this.items.get(i).getCode();
			case 1: return i == items.size() ? null : this.items.get(i).getName();
			case 2: return i == items.size() ? null : this.items.get(i).getUnit();
			case 3: return i == items.size() ? null : this.items.get(i).getSize();
			case 4: return i == items.size() ? null : this.items.get(i).getPrice();
			case 5: return i == items.size() ? null : this.items.get(i).getTax();
			case 6: return i == items.size() ? this.items.stream().mapToDouble(Item::getValue).sum() :  this.items.get(i).getValue();
			case 7: return i == items.size() ? this.items.stream().mapToDouble(Item::getTaxValue).sum() : this.items.get(i).getTaxValue();
			case 8: return i == items.size() ? this.items.stream().mapToDouble(Item::getGrossValue).sum() : this.items.get(i).getGrossValue();
			default: return null;
		}
	}

	@Override
	public void setValueAt(Object o, int i, int i1) {
		switch(i1) {
			case 3: this.items.get(i).setSize((double) o); break;
			case 4: this.items.get(i).setPrice((double) o); break;
			case 5: this.items.get(i).setTax((double) o); break;
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
