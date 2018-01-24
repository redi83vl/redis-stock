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

import com.redis.stock.pos.core.Client;
import com.redis.stock.pos.core.Employee;
import com.redis.stock.pos.core.Invoice;
import java.awt.Component;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author Redjan Shabani
 */
public class PanelInvoice extends javax.swing.JPanel {
	
	private Invoice invoice;
	
	public PanelInvoice() {		
		initComponents();
		
		
		
		
		
		table.setDefaultRenderer(Double.class, new DefaultTableCellRenderer(){
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focused, int i, int i1) {
				super.getTableCellRendererComponent(jtable, o, selected, focused, i, i1);
				
				this.setText(o == null ? null : new DecimalFormat("#0.00").format(o));
				
				this.setHorizontalAlignment(JLabel.RIGHT);
				this.setBackground(selected ? jtable.getSelectionBackground() : jtable.getBackground());
				this.setForeground(selected ? jtable.getSelectionForeground(): jtable.getForeground());
				
				return this;
			}
			
		});
	}
	
	public void clear() {
		this.invoice = null;
		
		this.refresh();
	}
	
	public void init() {
		this.invoice = new Invoice(
			LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss")), 
			Instant.now(), 
			Employee.get(),
			Client.get(0), 
			true
		);
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
		
		this.refresh();
	}

	public void add(Invoice.Entry e) {
		if(this.invoice == null) this.init();
		
		int idx = this.invoice.indexOf(e);
		if(idx != -1) {
			double size = this.invoice.get(idx).getSize() + e.getSize();
			this.invoice.get(idx).setSize(size);
		}
		else
			invoice.add(e);
		
		this.refresh();
	}
	
	
	
	private void refresh() {
		this.fieldCode.setValue(this.invoice == null ? null : this.invoice.getCode());
		this.fieldInstant.setValue(this.invoice == null ? null : Date.from(this.invoice.getInstant()));
		this.tableModel.setInvoice(invoice);
	}
	
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          tableModel = new com.redis.stock.pos.market.TableModelInvoice();
          jScrollPane1 = new javax.swing.JScrollPane();
          table = new org.jdesktop.swingx.JXTable();
          jPanel1 = new javax.swing.JPanel();
          fieldCode = new javax.swing.JFormattedTextField();
          fieldInstant = new javax.swing.JFormattedTextField();
          fieldValue = new javax.swing.JFormattedTextField();

          setPreferredSize(new java.awt.Dimension(520, 300));
          setLayout(new java.awt.BorderLayout());

          table.setModel(tableModel);
          table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
          table.setHighlighters(HighlighterFactory.createSimpleStriping());
          table.setShowHorizontalLines(false);
          table.setShowVerticalLines(false);
          table.getTableHeader().setReorderingAllowed(false);
          jScrollPane1.setViewportView(table);
          if (table.getColumnModel().getColumnCount() > 0) {
               table.getColumnModel().getColumn(0).setPreferredWidth(50);
               table.getColumnModel().getColumn(0).setHeaderValue("Kodi");
               table.getColumnModel().getColumn(1).setPreferredWidth(200);
               table.getColumnModel().getColumn(1).setHeaderValue("Emertimi");
               table.getColumnModel().getColumn(2).setPreferredWidth(50);
               table.getColumnModel().getColumn(2).setHeaderValue("Njesia");
               table.getColumnModel().getColumn(3).setPreferredWidth(50);
               table.getColumnModel().getColumn(3).setHeaderValue("Sasia");
               table.getColumnModel().getColumn(4).setPreferredWidth(50);
               table.getColumnModel().getColumn(4).setHeaderValue("Cmimi");
               table.getColumnModel().getColumn(5).setPreferredWidth(50);
               table.getColumnModel().getColumn(5).setHeaderValue("Vlera");
          }

          add(jScrollPane1, java.awt.BorderLayout.CENTER);

          fieldCode.setEditable(false);
          fieldCode.setColumns(10);
          fieldCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          fieldCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

          fieldInstant.setEditable(false);
          fieldInstant.setColumns(15);
          fieldInstant.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));
          fieldInstant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          fieldInstant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

          fieldValue.setEditable(false);
          fieldValue.setColumns(7);
          fieldValue.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
          fieldValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
          fieldValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(fieldInstant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                    .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(fieldInstant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
          );

          add(jPanel1, java.awt.BorderLayout.PAGE_END);
     }// </editor-fold>//GEN-END:initComponents


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JFormattedTextField fieldCode;
     private javax.swing.JFormattedTextField fieldInstant;
     private javax.swing.JFormattedTextField fieldValue;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JScrollPane jScrollPane1;
     public org.jdesktop.swingx.JXTable table;
     private com.redis.stock.pos.market.TableModelInvoice tableModel;
     // End of variables declaration//GEN-END:variables

	

}
