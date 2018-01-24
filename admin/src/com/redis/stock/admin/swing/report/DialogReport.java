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
package com.redis.stock.admin.swing.report;

import com.redis.stock.admin.core.Report;
import com.redis.utils.export.ExcelIO;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author Redjan Shabani
 */
public class DialogReport extends javax.swing.JDialog {
	
	private Report report;
	
	public DialogReport(java.awt.Frame parent) {
		super(parent, true);
		initComponents();
	}
	
	public Report getReport() {
		return this.report;
	}
	
	public void setReport(Report report) {
		Objects.requireNonNull(report);
		
		this.report = report;
		super.setTitle(report.getName());
	}
	
	private void reload() {		
		this.jXTable1.setModel(report == null ? new DefaultTableModel() : this.report.getTableModel());
		this.jXTable1.packAll();
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jScrollPane1 = new javax.swing.JScrollPane();
          jXTable1 = new org.jdesktop.swingx.JXTable();
          jToolBar2 = new javax.swing.JToolBar();
          jButton1 = new javax.swing.JButton();
          filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton3 = new javax.swing.JButton();
          jButton2 = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setPreferredSize(new java.awt.Dimension(800, 450));
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });

          jXTable1.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {

               },
               new String [] {

               }
          ));
          jXTable1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jXTable1.setHighlighters(HighlighterFactory.createSimpleStriping());
          jXTable1.setShowHorizontalLines(false);
          jXTable1.setShowVerticalLines(false);
          jScrollPane1.setViewportView(jXTable1);

          getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

          jToolBar2.setFloatable(false);
          jToolBar2.setRollover(true);
          jToolBar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

          jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh-16.png"))); // NOI18N
          jButton1.setFocusable(false);
          jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          jToolBar2.add(jButton1);
          jToolBar2.add(filler3);

          jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excel-16.png"))); // NOI18N
          jButton3.setFocusable(false);
          jButton3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton3.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
               }
          });
          jToolBar2.add(jButton3);

          jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print-16.png"))); // NOI18N
          jButton2.setFocusable(false);
          jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
               }
          });
          jToolBar2.add(jButton2);

          getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_START);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          ExcelIO io = new ExcelIO();
		File file = io.export("./export.xls", jXTable1);
		try {
			Desktop.getDesktop().open(file);
		} 
		catch (IOException ex) {
			Logger.getLogger(DialogReport.class.getName()).log(Level.SEVERE, null, ex);
		}
     }//GEN-LAST:event_jButton3ActionPerformed

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          this.reload();
     }//GEN-LAST:event_jButton1ActionPerformed

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          this.reload();
     }//GEN-LAST:event_formWindowOpened

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		try {
			this.jXTable1.print();
		} 
		catch (PrinterException ex) {
			Logger.getLogger(DialogReport.class.getName()).log(Level.SEVERE, null, ex);
		}
     }//GEN-LAST:event_jButton2ActionPerformed


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.Box.Filler filler3;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JToolBar jToolBar2;
     private org.jdesktop.swingx.JXTable jXTable1;
     // End of variables declaration//GEN-END:variables

	
}
