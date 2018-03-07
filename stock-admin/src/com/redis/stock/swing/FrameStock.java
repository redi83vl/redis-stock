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
package com.redis.stock.swing;

import com.redis.stock.Stock;
import com.redis.stock.swing.customer.DialogCustomers;
import com.redis.stock.swing.product.DialogProducts;
import com.redis.stock.swing.supplier.DialogSuppliers;
import com.redis.stock.swing.warehouse.DialogWarehouses;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Redjan Shabani
 */
public class FrameStock extends javax.swing.JFrame {
	
	private final Stock stock;
	
	public FrameStock() {
		this.stock = Stock.getInstance();
		initComponents();
	}
	
	
	private static final Preferences PREFERENCES = Preferences.userNodeForPackage(FrameStock.class);
	
	private String getLookAndFeel() {
		return PREFERENCES.get("look_and_feel", "");
	}
	private void setLookAndFeel(String lookAndFeel) {
		PREFERENCES.put("look_and_feel", lookAndFeel);
	}
	
	@Override
	public void repaint() {
		try {
			UIManager.setLookAndFeel(this.getLookAndFeel());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
			Logger.getLogger(FrameStock.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		super.repaint();
	}
	
	
	
	
	
	
	
	
	
	
//	private void reload() {
//		this.warehouses.clear();
//		Warehouses.getDataset().forEach(entry -> warehouses.put(entry.getCode(), entry));
//		
//		this.suppliers.clear();
//		Suppliers.getDataset().forEach(supplier -> suppliers.put(supplier.getCode(), supplier));
//		
//		this.customers.clear();
//		Customers.getDataset().forEach(entry -> customers.put(entry.getCode(), entry));
//		
//		this.products.clear();
//		Products.getDataset().forEach(entry -> products.put(entry.getCode(), entry));
//	}
	
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jToolBar1 = new javax.swing.JToolBar();
          jButton7 = new javax.swing.JButton();
          jButton5 = new javax.swing.JButton();
          jButton6 = new javax.swing.JButton();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton1 = new javax.swing.JButton();
          jButton2 = new javax.swing.JButton();
          jButton3 = new javax.swing.JButton();
          jButton4 = new javax.swing.JButton();
          jDesktopPane1 = new javax.swing.JDesktopPane();
          jPanel1 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          jMenuBar1 = new javax.swing.JMenuBar();
          jMenu1 = new javax.swing.JMenu();
          jMenu2 = new javax.swing.JMenu();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("REDIS STOCK ADMIN");
          setExtendedState(JFrame.MAXIMIZED_BOTH);
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowClosing(java.awt.event.WindowEvent evt) {
                    formWindowClosing(evt);
               }
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);

          jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/move-stock-16.png"))); // NOI18N
          jButton7.setText("LEVIZJET");
          jButton7.setFocusable(false);
          jButton7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton7.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton7ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton7);

          jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buyin-16.png"))); // NOI18N
          jButton5.setText("BLERJET");
          jButton5.setFocusable(false);
          jButton5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton5.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton5ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton5);

          jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pos-terminal-16.png"))); // NOI18N
          jButton6.setText("SHITJET");
          jButton6.setFocusable(false);
          jButton6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton6.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton6ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton6);
          jToolBar1.add(filler1);

          jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ingredients-16.png"))); // NOI18N
          jButton1.setText("ARTIKUJT");
          jButton1.setFocusable(false);
          jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton1);

          jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warehouse-16.png"))); // NOI18N
          jButton2.setText("MAGAZINAT");
          jButton2.setFocusable(false);
          jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton2);

          jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/supplier-16.png"))); // NOI18N
          jButton3.setText("FORNITORET");
          jButton3.setFocusable(false);
          jButton3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton3.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton3);

          jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer-16.png"))); // NOI18N
          jButton4.setText("KLIENTET");
          jButton4.setFocusable(false);
          jButton4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton4.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton4ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton4);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

          javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
          jDesktopPane1.setLayout(jDesktopPane1Layout);
          jDesktopPane1Layout.setHorizontalGroup(
               jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 901, Short.MAX_VALUE)
          );
          jDesktopPane1Layout.setVerticalGroup(
               jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 428, Short.MAX_VALUE)
          );

          getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

          jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel1.setText("<html><center>\n\tCopyright (C) 2018 REDIS I. T. L76604205F<br/>\n\tLagja Pavaresia, Rruga Kosova, Skele, Vlore (9403)<br/>\n\t+355 69 20 48 755 | redjan.shabani@gmail.com\n</center></html>");
          jPanel1.add(jLabel1);

          getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

          jMenu1.setText("File");
          jMenuBar1.add(jMenu1);

          jMenu2.setText("Konfigurime");
          jMenuBar1.add(jMenu2);

          setJMenuBar(jMenuBar1);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          JDialog dialog = new DialogWarehouses(this);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		JDialog dialog = new DialogSuppliers(this);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jButton3ActionPerformed

     private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
		JDialog dialog = new DialogCustomers(this);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jButton4ActionPerformed

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          JDialog dialog = new DialogProducts(this);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jButton1ActionPerformed

     private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
		
     }//GEN-LAST:event_jButton5ActionPerformed

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		
		
     }//GEN-LAST:event_formWindowOpened

     private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
          
		
     }//GEN-LAST:event_formWindowClosing

     private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_jButton6ActionPerformed

     private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_jButton7ActionPerformed

	
	

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.Box.Filler filler1;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JButton jButton4;
     private javax.swing.JButton jButton5;
     private javax.swing.JButton jButton6;
     private javax.swing.JButton jButton7;
     private javax.swing.JDesktopPane jDesktopPane1;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JMenu jMenu1;
     private javax.swing.JMenu jMenu2;
     private javax.swing.JMenuBar jMenuBar1;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JToolBar jToolBar1;
     // End of variables declaration//GEN-END:variables
}
