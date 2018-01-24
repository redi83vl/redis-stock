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
package com.redis.stock.admin.swing.client;

import com.redis.stock.admin.core.Client;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author Redjan Shabani
 */
public class DialogClients extends javax.swing.JDialog {
		
	public DialogClients(java.awt.Frame parent) {
		super(parent, true);
		initComponents();
	}
	
	public Client getClient() {
		int row = this.jXTable1.getSelectedRow();
		
		return row == -1 ? null : Client.read((String) jXTable1.getValueAt(row, 0));
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          tableModel = new com.redis.stock.admin.swing.client.TableModelClients();
          jScrollPane1 = new javax.swing.JScrollPane();
          jXTable1 = new org.jdesktop.swingx.JXTable();
          jToolBar2 = new javax.swing.JToolBar();
          buttonRefresh = new javax.swing.JButton();
          filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          buttonAdd = new javax.swing.JButton();
          buttonDelete = new javax.swing.JButton();
          jPanel2 = new javax.swing.JPanel();
          jXSearchField1 = new org.jdesktop.swingx.JXSearchField();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setResizable(false);
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });

          jXTable1.setModel(tableModel);
          jXTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
          jXTable1.setShowHorizontalLines(false);
          jXTable1.setShowVerticalLines(false);
          jScrollPane1.setViewportView(jXTable1);
          if (jXTable1.getColumnModel().getColumnCount() > 0) {
               jXTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
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

          jToolBar2.setFloatable(false);
          jToolBar2.setRollover(true);

          buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh-16.png"))); // NOI18N
          buttonRefresh.setFocusable(false);
          buttonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          buttonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonRefreshActionPerformed(evt);
               }
          });
          jToolBar2.add(buttonRefresh);
          jToolBar2.add(filler3);

          buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus-16.png"))); // NOI18N
          buttonAdd.setFocusable(false);
          buttonAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          buttonAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          buttonAdd.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonAddActionPerformed(evt);
               }
          });
          jToolBar2.add(buttonAdd);

          buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete-16.png"))); // NOI18N
          buttonDelete.setFocusable(false);
          buttonDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          buttonDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          buttonDelete.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonDeleteActionPerformed(evt);
               }
          });
          jToolBar2.add(buttonDelete);

          getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_START);

          jXSearchField1.setColumns(25);
          jXSearchField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          jXSearchField1.setLayoutStyle(org.jdesktop.swingx.JXSearchField.LayoutStyle.MAC);
          jXSearchField1.setPrompt("Kerko ...");
          jXSearchField1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jXSearchField1ActionPerformed(evt);
               }
          });
          jPanel2.add(jXSearchField1);

          getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
          this.tableModel.setConsumers(Client.read());
     }//GEN-LAST:event_buttonRefreshActionPerformed

     private void jXSearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXSearchField1ActionPerformed
          this.jXTable1.setRowFilter(RowFilter.regexFilter("(?i)" + this.jXSearchField1.getText(), 0, 1));
     }//GEN-LAST:event_jXSearchField1ActionPerformed

     private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
          DialogClientCreate dialog = new DialogClientCreate((Frame) SwingUtilities.windowForComponent(this));
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent we) {
				buttonRefreshActionPerformed(null);
			}			
		});
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);		
     }//GEN-LAST:event_buttonAddActionPerformed

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          buttonRefreshActionPerformed(null);
     }//GEN-LAST:event_formWindowOpened

     private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
          Client consumer = this.getClient();
		
		if(consumer != null) {
			int choice = JOptionPane.showConfirmDialog(
				this, 
				"Konfirmo veprimin e fshirjes!", 
				"Kujdes!", 
				JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.WARNING_MESSAGE
			);

			if(choice == 0){
				int id = Client.delete(consumer);		
				if(id == -1) 
					JOptionPane.showMessageDialog(this, "Gabim gjate veprimit te fshirjes!", "Error!", JOptionPane.ERROR_MESSAGE);

				this.buttonRefreshActionPerformed(null);
			}
		}
     }//GEN-LAST:event_buttonDeleteActionPerformed
	
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton buttonAdd;
     private javax.swing.JButton buttonDelete;
     private javax.swing.JButton buttonRefresh;
     private javax.swing.Box.Filler filler3;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JToolBar jToolBar2;
     private org.jdesktop.swingx.JXSearchField jXSearchField1;
     private org.jdesktop.swingx.JXTable jXTable1;
     private com.redis.stock.admin.swing.client.TableModelClients tableModel;
     // End of variables declaration//GEN-END:variables
}
