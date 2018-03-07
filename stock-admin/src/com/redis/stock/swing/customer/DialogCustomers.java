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
package com.redis.stock.swing.customer;

import com.redis.stock.swing.customer.*;
import com.redis.stock.core.Customer;
import com.redis.stock.mysql.Customers;
import com.redis.stock.utils.Dataset;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Redjan Shabani
 */
public class DialogCustomers extends javax.swing.JDialog {
	
	public DialogCustomers(java.awt.Frame parent) {
		super(parent, true);
		
		initComponents();
		
		this.jXTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.jXTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
			DialogCustomers.this.onSelect();
		});
	}
		
	private void reload() {
		this.tableModel.clear();	
		Customers.getDataset().forEach(customer -> {
			tableModel.add(customer);
		});
		
	}
	
	public Customer get(int idx) {
		Customer customer = null;
		if(idx != -1) {
			idx = this.jXTable1.convertRowIndexToModel(idx);
			customer = this.tableModel.get(idx);			
		}
		return customer;
	}
	
	public Customer getSelected() {
		return this.get(this.jXTable1.getSelectedRow());
	}
	
	private void onSelect() {
		this.buttonUpdate.setEnabled(this.jXTable1.getSelectedRow() != -1);
		this.buttonDelete.setEnabled(this.jXTable1.getSelectedRow() != -1);
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          tableModel = new com.redis.stock.swing.customer.TableModelCustomer();
          jToolBar1 = new javax.swing.JToolBar();
          jButton1 = new javax.swing.JButton();
          filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton2 = new javax.swing.JButton();
          buttonUpdate = new javax.swing.JButton();
          buttonDelete = new javax.swing.JButton();
          jPanel1 = new javax.swing.JPanel();
          jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
          jScrollPane1 = new javax.swing.JScrollPane();
          jXTable1 = new org.jdesktop.swingx.JXTable();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setTitle("MAGAZINAT");
          setResizable(false);
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);

          jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reload-16.png"))); // NOI18N
          jButton1.setFocusable(false);
          jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton1);
          jToolBar1.add(filler3);

          jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/insert-16.png"))); // NOI18N
          jButton2.setFocusable(false);
          jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton2);

          buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update-16.png"))); // NOI18N
          buttonUpdate.setEnabled(false);
          buttonUpdate.setFocusable(false);
          buttonUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          buttonUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonUpdateActionPerformed(evt);
               }
          });
          jToolBar1.add(buttonUpdate);

          buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete-16.png"))); // NOI18N
          buttonDelete.setEnabled(false);
          buttonDelete.setFocusable(false);
          buttonDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          buttonDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          buttonDelete.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonDeleteActionPerformed(evt);
               }
          });
          jToolBar1.add(buttonDelete);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

          jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 3, 3));

          jXSearchField1.setColumns(20);
          jXSearchField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          jXSearchField1.setPrompt("Kerko ...");
          jXSearchField1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jXSearchField1ActionPerformed(evt);
               }
          });
          jPanel1.add(jXSearchField1);

          getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

          jXTable1.setModel(tableModel);
          jXTable1.setShowVerticalLines(false);
          jScrollPane1.setViewportView(jXTable1);
          if (jXTable1.getColumnModel().getColumnCount() > 0) {
               jXTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
               jXTable1.getColumnModel().getColumn(0).setHeaderValue("Kodi");
               jXTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
               jXTable1.getColumnModel().getColumn(1).setHeaderValue("Emertimi");
               jXTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
               jXTable1.getColumnModel().getColumn(2).setHeaderValue("Adresa");
               jXTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
               jXTable1.getColumnModel().getColumn(3).setHeaderValue("Telefoni");
               jXTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
               jXTable1.getColumnModel().getColumn(4).setHeaderValue("Email");
          }

          getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		this.jXSearchField1.setText("");	
		this.reload();
     }//GEN-LAST:event_jButton1ActionPerformed

     private void jXSearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXSearchField1ActionPerformed
          this.jXTable1.setRowFilter(RowFilter.regexFilter("(?i)" + this.jXSearchField1.getText(), 0, 1));
     }//GEN-LAST:event_jXSearchField1ActionPerformed

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          DialogCustomerInsert dialog = new DialogCustomerInsert((Frame) SwingUtilities.windowForComponent(this));
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent we) {DialogCustomers.this.reload();}
		});
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jButton2ActionPerformed

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          this.reload();
     }//GEN-LAST:event_formWindowOpened

     private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
          Customer customer = this.getSelected();
		if(customer != null) {
			DialogCustomerInsert dialog = new DialogCustomerInsert((Frame) SwingUtilities.windowForComponent(this));
			dialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent we) {DialogCustomers.this.reload();}
			});
			dialog.setLocationRelativeTo(this);
			dialog.set(customer);
			dialog.setVisible(true);
		}		
     }//GEN-LAST:event_buttonUpdateActionPerformed

     private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
		Customer customer = this.getSelected();
		if(customer != null) {
			int choice = JOptionPane.showOptionDialog(
				this, 
				"Konfirmo fshirjen e te dhenave!", 
				"Kujdes!", 
				JOptionPane.WARNING_MESSAGE, 
				JOptionPane.OK_CANCEL_OPTION, 
				null, 
				new String[]{"Konfirmo!", "Anullo"}, 
				"Anullo"
			);
			
			if(choice == 0){
				
				boolean success = Customers.getDataset().delete(customer);
				if(success){
					tableModel.remove(customer);	
					DialogCustomers.this.reload();
				}
				else{
					JOptionPane.showMessageDialog(this, "Gabim gjate fshirjes se te dhenave.", "Gabim!", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
     }//GEN-LAST:event_buttonDeleteActionPerformed
	
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton buttonDelete;
     private javax.swing.JButton buttonUpdate;
     private javax.swing.Box.Filler filler3;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JToolBar jToolBar1;
     private org.jdesktop.swingx.JXSearchField jXSearchField1;
     private org.jdesktop.swingx.JXTable jXTable1;
     private com.redis.stock.swing.customer.TableModelCustomer tableModel;
     // End of variables declaration//GEN-END:variables
}
