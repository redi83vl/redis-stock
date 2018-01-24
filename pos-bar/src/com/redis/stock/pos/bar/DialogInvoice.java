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
package com.redis.stock.pos.bar;

import com.redis.stock.pos.core.Invoice;
import com.redis.stock.pos.core.Invoice.Entry;
import com.redis.stock.pos.core.Product;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author Redjan Shabani
 */
public abstract class DialogInvoice extends javax.swing.JDialog {
	private Invoice invoice;
	
	public DialogInvoice(java.awt.Frame parent) {
		super(parent, true);
		initComponents();
	}
	
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
		
		this.setTitle(invoice == null ? "" : invoice.getTarget().getName());
		this.fieldValue.setValue(invoice == null ? 0 : invoice.getGrossValue());
		this.tableModel.setInvoice(invoice);
	}
	
	public void refresh() {
		
	}
	
	public abstract Product getProduct(String code);
	
	public abstract void onCancel(Invoice invoice);
	
	public abstract void onSubmit(Invoice invoice);
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          tableModel = new com.redis.stock.pos.bar.TableModelInvoice();
          jPanel1 = new javax.swing.JPanel();
          jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
          jToolBar1 = new javax.swing.JToolBar();
          jButton2 = new javax.swing.JButton();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton3 = new javax.swing.JButton();
          jPanel2 = new javax.swing.JPanel();
          jScrollPane1 = new javax.swing.JScrollPane();
          table = new org.jdesktop.swingx.JXTable();
          jToolBar2 = new javax.swing.JToolBar();
          filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          fieldValue = new javax.swing.JFormattedTextField();

          tableModel.addTableModelListener(new javax.swing.event.TableModelListener() {
               public void tableChanged(javax.swing.event.TableModelEvent evt) {
                    tableModelTableChanged(evt);
               }
          });

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setTitle("FATURE TAVOLINE");
          setPreferredSize(new java.awt.Dimension(800, 450));
          setResizable(false);

          jXSearchField1.setColumns(25);
          jXSearchField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          jXSearchField1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jXSearchField1.setSearchMode(org.jdesktop.swingx.JXSearchField.SearchMode.REGULAR);
          jXSearchField1.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jXSearchField1MouseClicked(evt);
               }
          });
          jXSearchField1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jXSearchField1ActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(229, Short.MAX_VALUE)
                    .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(230, Short.MAX_VALUE))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5))
          );

          getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);

          jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
          jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel-16.png"))); // NOI18N
          jButton2.setText("Anullo!");
          jButton2.setFocusable(false);
          jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton2);
          jToolBar1.add(filler1);

          jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
          jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-money-16.png"))); // NOI18N
          jButton3.setText("Paguaj!");
          jButton3.setFocusable(false);
          jButton3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton3.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton3);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

          jPanel2.setLayout(new java.awt.BorderLayout());

          table.setModel(tableModel);
          table.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          table.setHighlighters(HighlighterFactory.createSimpleStriping());
          table.setShowHorizontalLines(false);
          table.setShowVerticalLines(false);
          table.getTableHeader().setReorderingAllowed(false);
          table.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tableMouseClicked(evt);
               }
          });
          jScrollPane1.setViewportView(table);
          if (table.getColumnModel().getColumnCount() > 0) {
               table.getColumnModel().getColumn(0).setPreferredWidth(50);
               table.getColumnModel().getColumn(0).setHeaderValue("Kodi");
               table.getColumnModel().getColumn(1).setPreferredWidth(250);
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

          jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

          jToolBar2.setFloatable(false);
          jToolBar2.setRollover(true);
          jToolBar2.add(filler2);

          fieldValue.setEditable(false);
          fieldValue.setColumns(10);
          fieldValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
          fieldValue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
          fieldValue.setMaximumSize(new java.awt.Dimension(86, 19));
          jToolBar2.add(fieldValue);

          jPanel2.add(jToolBar2, java.awt.BorderLayout.PAGE_END);

          getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          onCancel(invoice);
		dispose();
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          onSubmit(invoice);
		dispose();
     }//GEN-LAST:event_jButton3ActionPerformed

     private void jXSearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXSearchField1ActionPerformed
          if(this.jXSearchField1.getText().length() < 3) 
			return;
		
		Product product = this.getProduct(this.jXSearchField1.getText());
		if(product == null) {
			JOptionPane.showMessageDialog(this, "Artikulli nuk u gjet!", "Error!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Invoice.Entry entry = new Invoice.Entry(
			product.getCode(), 
			product.getName(), 
			product.getUnit(),
			1.0d, 
			product.getPrice(),
			product.getTax()
		);
		
		this.invoice.add(entry);
		this.tableModel.fireDatasetChanged();
		this.jXSearchField1.setText("");
     }//GEN-LAST:event_jXSearchField1ActionPerformed

     private void jXSearchField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXSearchField1MouseClicked
           if(evt.getClickCount() == 2) {
			DialogProductList dialoag = new DialogProductList((Frame) SwingUtilities.windowForComponent(this));
			dialoag.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent we) {
					Product product = dialoag.getSelectedProduct();
					if(product == null) 
						return;

					Invoice.Entry entry = new Invoice.Entry(
						product.getCode(), 
						product.getName(), 
						product.getUnit(),
						1.0d, 
						product.getPrice(),
						product.getTax()
					);

					invoice.add(entry);
					tableModel.fireDatasetChanged();
					jXSearchField1.setText("");
				}
				
			});
			dialoag.setLocationRelativeTo(this);
			dialoag.setVisible(true);
			
			
			evt.consume();
		}
     }//GEN-LAST:event_jXSearchField1MouseClicked

     private void tableModelTableChanged(javax.swing.event.TableModelEvent evt) {//GEN-FIRST:event_tableModelTableChanged
          this.fieldValue.setValue(invoice == null ? 0 : invoice.getGrossValue());
     }//GEN-LAST:event_tableModelTableChanged

     private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
          int idx = this.table.rowAtPoint(evt.getPoint());
		if(idx != -1) {
			idx = table.convertRowIndexToModel(idx);
			Entry entry = tableModel.getInvoice().get(idx);
			entry.setSize(entry.getSize()-1.0d);
			if(entry.getSize()<=0.0d)
				tableModel.getInvoice().remove(idx);
			
			tableModel.fireDatasetChanged();
			
			
			evt.consume();
		}
     }//GEN-LAST:event_tableMouseClicked


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JFormattedTextField fieldValue;
     private javax.swing.Box.Filler filler1;
     private javax.swing.Box.Filler filler2;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JToolBar jToolBar1;
     private javax.swing.JToolBar jToolBar2;
     private org.jdesktop.swingx.JXSearchField jXSearchField1;
     public org.jdesktop.swingx.JXTable table;
     private com.redis.stock.pos.bar.TableModelInvoice tableModel;
     // End of variables declaration//GEN-END:variables
}
