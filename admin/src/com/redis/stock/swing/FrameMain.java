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

import com.redis.stock.core.Customer;
import com.redis.stock.core.Product;
import com.redis.stock.core.Supplier;
import com.redis.stock.core.Warehouse;
import com.redis.stock.mysql.Customers;
import com.redis.stock.mysql.Products;
import com.redis.stock.mysql.Suppliers;
import com.redis.stock.mysql.Warehouses;
import com.redis.stock.utils.Dataset;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Redjan Shabani
 */
public class FrameMain extends javax.swing.JFrame {

	/**
	 * Creates new form FrameStock
	 */
	public FrameMain() {
		initComponents();
	}
	
	
	
	
	private static final Preferences PREFERENCES = Preferences.userNodeForPackage(FrameMain.class);
	
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
			Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		super.repaint();
	}
	
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jToolBar1 = new javax.swing.JToolBar();
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

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);
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
          com.redis.stock.swing.warehouses.DialogList dialog = new com.redis.stock.swing.warehouses.DialogList(this) {
			@Override
			public Dataset<Warehouse> getDataset() {
				return Warehouses.getDataset();
			}			
		};
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		com.redis.stock.swing.suppliers.DialogList dialog = new com.redis.stock.swing.suppliers.DialogList(this) {
			@Override
			public Dataset<Supplier> getDataset() {
				return Suppliers.getDataset();
			}			
		};
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jButton3ActionPerformed

     private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
		com.redis.stock.swing.customers.DialogList dialog = new com.redis.stock.swing.customers.DialogList(this) {
			@Override
			public Dataset<Customer> getDataset() {
				return Customers.getDataset();
			}			
		};
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jButton4ActionPerformed

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          com.redis.stock.swing.products.DialogList dialog = new com.redis.stock.swing.products.DialogList(this) {
			@Override
			public Dataset<Product> getDataset() {
				return Products.getDataset();
			}			
		};
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jButton1ActionPerformed

	
	
	
	
	
	public static void main(String args[]) {
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get (key);
			if (value instanceof javax.swing.plaf.FontUIResource)
			UIManager.put (key, new javax.swing.plaf.FontUIResource("Serif",Font.PLAIN,10));
		}		
		
		try {
//			UIManager.setLookAndFeel(com.jtattoo.plaf.hifi.HiFiLookAndFeel.class.getName());
//			UIManager.setLookAndFeel(com.jtattoo.plaf.luna.LunaLookAndFeel.class.getName());
//			UIManager.setLookAndFeel(com.jtattoo.plaf.mcwin.McWinLookAndFeel.class.getName());
			UIManager.setLookAndFeel(com.jtattoo.plaf.smart.SmartLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
			Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(() -> {
			new FrameMain().setVisible(true);
		});
	}

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.Box.Filler filler1;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JButton jButton4;
     private javax.swing.JDesktopPane jDesktopPane1;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JMenu jMenu1;
     private javax.swing.JMenu jMenu2;
     private javax.swing.JMenuBar jMenuBar1;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JToolBar jToolBar1;
     // End of variables declaration//GEN-END:variables
}
