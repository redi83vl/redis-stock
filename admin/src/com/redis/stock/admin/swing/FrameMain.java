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
package com.redis.stock.admin.swing;

import com.redis.stock.admin.swing.report.DialogReport;
import com.redis.stock.admin.core.Report;
import com.redis.stock.admin.swing.client.DialogClients;
import com.redis.stock.admin.swing.employee.DialogEmployees;
import com.redis.stock.admin.swing.input.FrameInputs;
import com.redis.stock.admin.swing.output.FrameOutputs;
import com.redis.stock.admin.swing.product.FrameProducts;
import com.redis.stock.admin.swing.supplier.DialogSupplierList;
import java.awt.Frame;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


/**
 *
 * @author Redjan Shabani
 */
public class FrameMain extends javax.swing.JFrame {

	public FrameMain() {
		initComponents();
		
		Report.read().forEach(report -> {
			
			
			JMenuItem menuItem = this.jMenu2.add(report.getName());
			menuItem.addActionListener((ae) -> {
				DialogReport dialog = new DialogReport(FrameMain.this);
				dialog.setReport(report);
				dialog.setLocationRelativeTo(FrameMain.this);
				dialog.setVisible(true);
			});
			
		});
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jDesktopPane1 = new javax.swing.JDesktopPane();
          jToolBar1 = new javax.swing.JToolBar();
          jButton1 = new javax.swing.JButton();
          jButton2 = new javax.swing.JButton();
          jButton3 = new javax.swing.JButton();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jMenuBar1 = new javax.swing.JMenuBar();
          jMenu1 = new javax.swing.JMenu();
          jMenuItem5 = new javax.swing.JMenuItem();
          jMenu3 = new javax.swing.JMenu();
          jMenuItem1 = new javax.swing.JMenuItem();
          jMenuItem2 = new javax.swing.JMenuItem();
          jMenuItem3 = new javax.swing.JMenuItem();
          jMenu2 = new javax.swing.JMenu();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("REDIS STOCK - ADMINISTRATORI");
          setExtendedState(JFrame.MAXIMIZED_BOTH);
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });

          javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
          jDesktopPane1.setLayout(jDesktopPane1Layout);
          jDesktopPane1Layout.setHorizontalGroup(
               jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 701, Short.MAX_VALUE)
          );
          jDesktopPane1Layout.setVerticalGroup(
               jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 468, Short.MAX_VALUE)
          );

          getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);

          jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/notebook-24.png"))); // NOI18N
          jButton1.setText("Artikujt (Gjendjet)");
          jButton1.setToolTipText("Artikujt (Gjendjet)");
          jButton1.setFocusable(false);
          jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton1);

          jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sell-stock-24.png"))); // NOI18N
          jButton2.setText("Hyrjet (Blerjet)");
          jButton2.setToolTipText("Hyrjet (Blerjet)");
          jButton2.setFocusable(false);
          jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton2);

          jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cash-register-24.png"))); // NOI18N
          jButton3.setText("Daljet (Shitjet)");
          jButton3.setToolTipText("Daljet (Shitjet)");
          jButton3.setFocusable(false);
          jButton3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton3.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton3);
          jToolBar1.add(filler1);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

          jMenu1.setText("File");

          jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
          jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shutdown-16.png"))); // NOI18N
          jMenuItem5.setText("Dalje!");
          jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem5ActionPerformed(evt);
               }
          });
          jMenu1.add(jMenuItem5);

          jMenuBar1.add(jMenu1);

          jMenu3.setText("Aktoret");

          jMenuItem1.setText("Punonjesit");
          jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem1ActionPerformed(evt);
               }
          });
          jMenu3.add(jMenuItem1);

          jMenuItem2.setText("Fornitoret");
          jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem2ActionPerformed(evt);
               }
          });
          jMenu3.add(jMenuItem2);

          jMenuItem3.setText("Klientet");
          jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem3ActionPerformed(evt);
               }
          });
          jMenu3.add(jMenuItem3);

          jMenuBar1.add(jMenu3);

          jMenu2.setText("Raportet");
          jMenuBar1.add(jMenu2);

          setJMenuBar(jMenuBar1);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          for(JInternalFrame frame : this.jDesktopPane1.getAllFrames()){
			if(frame instanceof FrameProducts){
				frame.moveToFront();
				return;
			}
		}
		
		FrameProducts frame = new FrameProducts();
		this.jDesktopPane1.add(frame);
		frame.setVisible(true);	
		
		try {
			frame.setMaximum(true);
		} 
		catch (PropertyVetoException ex) {
			Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
		}
     }//GEN-LAST:event_jButton1ActionPerformed

     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          for(JInternalFrame frame : this.jDesktopPane1.getAllFrames()){
			if(frame instanceof FrameOutputs){
				frame.moveToFront();
				return;
			}
		}
		
		FrameOutputs frame = new FrameOutputs();
		this.jDesktopPane1.add(frame);
		frame.setVisible(true);	
		
		try {
			frame.setMaximum(true);
		} 
		catch (PropertyVetoException ex) {
			Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
		}
     }//GEN-LAST:event_jButton3ActionPerformed

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          for(JInternalFrame frame : this.jDesktopPane1.getAllFrames()){
			if(frame instanceof FrameInputs){
				frame.moveToFront();
				return;
			}
		}
		
		FrameInputs frame = new FrameInputs();
		this.jDesktopPane1.add(frame);
		frame.setVisible(true);	
		
		try {
			frame.setMaximum(true);
		} 
		catch (PropertyVetoException ex) {
			Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
		}
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
          DialogEmployees dialog = new DialogEmployees(this);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jMenuItem1ActionPerformed

     private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
          DialogSupplierList dialog = new DialogSupplierList((Frame) SwingUtilities.windowForComponent(this));
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jMenuItem2ActionPerformed

     private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
          DialogClients dialog = new DialogClients((Frame) SwingUtilities.windowForComponent(this));
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jMenuItem3ActionPerformed

     private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
          this.dispose();
     }//GEN-LAST:event_jMenuItem5ActionPerformed

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          // TODO add your handling code here:
     }//GEN-LAST:event_formWindowOpened

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(() -> {
			new FrameMain().setVisible(true);
		});
	}

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.Box.Filler filler1;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JDesktopPane jDesktopPane1;
     private javax.swing.JMenu jMenu1;
     private javax.swing.JMenu jMenu2;
     private javax.swing.JMenu jMenu3;
     private javax.swing.JMenuBar jMenuBar1;
     private javax.swing.JMenuItem jMenuItem1;
     private javax.swing.JMenuItem jMenuItem2;
     private javax.swing.JMenuItem jMenuItem3;
     private javax.swing.JMenuItem jMenuItem5;
     private javax.swing.JToolBar jToolBar1;
     // End of variables declaration//GEN-END:variables
}
