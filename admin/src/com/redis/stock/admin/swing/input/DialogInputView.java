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
package com.redis.stock.admin.swing.input;

import com.redis.stock.admin.core.Input;
import com.redis.stock.admin.utils.HTML;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author Redjan Shabani
 */
public class DialogInputView extends javax.swing.JDialog {
	
	private Input input = null;
	
	public DialogInputView(java.awt.Frame parent) {
		super(parent, true);
		initComponents();
		
		this.table.setDefaultRenderer(Double.class, new DefaultTableCellRenderer(){
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
				super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
				
				if(o instanceof Number){
					this.setText(new DecimalFormat("0.00").format(o));
					
				}
				this.setHorizontalAlignment(RIGHT);
				if(i == jtable.getRowCount()-1){
					this.setFont(jtable.getFont().deriveFont(Font.BOLD));
				}
				
				return this;
			}
		});
		
		this.table.getColumn(5).setCellRenderer(new DefaultTableCellRenderer(){
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
				super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
				
				if(o instanceof Number)
					this.setText(new DecimalFormat("0.00%").format(o));
				
				this.setHorizontalAlignment(RIGHT);
				
				
				return this;
			}
		});
	}
	
	public void setInput(Input input) {
		this.setTitle("Flete Hyrje (Blerje): " + input.getCode());
		this.fieldInstant.setValue(Date.from(input.getInstant()));
		this.fieldAuthor.setValue(input.getAuthor());
		this.fieldSource.setValue(input.getSource());
		this.checkBoxPaid.setSelected(input.isPaid());
		this.fieldValue.setValue(input.getGrossValue());
		
		this.tableModel.setItems(input);
		
		this.input = input;
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          tableModel = new com.redis.stock.admin.swing.item.TableModelItems();
          jPanel1 = new javax.swing.JPanel();
          jLabel2 = new javax.swing.JLabel();
          fieldAuthor = new javax.swing.JFormattedTextField();
          jLabel3 = new javax.swing.JLabel();
          fieldSource = new javax.swing.JFormattedTextField();
          jLabel4 = new javax.swing.JLabel();
          fieldInstant = new javax.swing.JFormattedTextField();
          fieldValue = new javax.swing.JFormattedTextField();
          checkBoxPaid = new javax.swing.JCheckBox();
          jToolBar1 = new javax.swing.JToolBar();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          buttonPrint = new javax.swing.JButton();
          jScrollPane1 = new javax.swing.JScrollPane();
          table = new org.jdesktop.swingx.JXTable();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setPreferredSize(new java.awt.Dimension(800, 450));
          setResizable(false);

          jLabel2.setText("Autori:");

          fieldAuthor.setEditable(false);
          fieldAuthor.setColumns(20);

          jLabel3.setText("Shitesi:");

          fieldSource.setEditable(false);
          fieldSource.setColumns(20);

          jLabel4.setText("Data");

          fieldInstant.setEditable(false);
          fieldInstant.setColumns(10);

          fieldValue.setEditable(false);
          fieldValue.setColumns(10);
          fieldValue.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
          fieldValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
          fieldValue.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

          checkBoxPaid.setText("Vlera");
          checkBoxPaid.setEnabled(false);
          checkBoxPaid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
          checkBoxPaid.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
          checkBoxPaid.setIconTextGap(2);
          checkBoxPaid.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    checkBoxPaidActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel4)
                         .addComponent(jLabel2)
                         .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(fieldSource, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                              .addComponent(checkBoxPaid)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(fieldInstant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(fieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel4)
                         .addComponent(fieldInstant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel2)
                         .addComponent(fieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(fieldSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(checkBoxPaid))
                    .addContainerGap())
          );

          getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);
          jToolBar1.add(filler1);

          buttonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print-16.png"))); // NOI18N
          buttonPrint.setText("Printo!");
          buttonPrint.setFocusable(false);
          buttonPrint.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          buttonPrint.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          buttonPrint.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonPrintActionPerformed(evt);
               }
          });
          jToolBar1.add(buttonPrint);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

          table.setModel(tableModel);
          table.setHighlighters(HighlighterFactory.createSimpleStriping());
          table.setShowHorizontalLines(false);
          table.setShowVerticalLines(false);
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
               table.getColumnModel().getColumn(5).setHeaderValue("Tvsh %");
               table.getColumnModel().getColumn(6).setPreferredWidth(50);
               table.getColumnModel().getColumn(6).setHeaderValue("Vlera");
               table.getColumnModel().getColumn(7).setPreferredWidth(50);
               table.getColumnModel().getColumn(7).setHeaderValue("Tvsh");
               table.getColumnModel().getColumn(8).setPreferredWidth(50);
               table.getColumnModel().getColumn(8).setHeaderValue("Total");
          }

          getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void checkBoxPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxPaidActionPerformed
          
		this.input.setPaid(checkBoxPaid.isSelected());
		this.checkBoxPaid.setSelected(input.isPaid());
     }//GEN-LAST:event_checkBoxPaidActionPerformed

     private void buttonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintActionPerformed
		try {
			Desktop.getDesktop().open(Input.toHtml(input));
		}
		catch (IOException ex) {
			Logger.getLogger(DialogInputView.class.getName()).log(Level.SEVERE, null, ex);
		}
     }//GEN-LAST:event_buttonPrintActionPerformed
	
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton buttonPrint;
     private javax.swing.JCheckBox checkBoxPaid;
     private javax.swing.JFormattedTextField fieldAuthor;
     private javax.swing.JFormattedTextField fieldInstant;
     private javax.swing.JFormattedTextField fieldSource;
     private javax.swing.JFormattedTextField fieldValue;
     private javax.swing.Box.Filler filler1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JToolBar jToolBar1;
     private org.jdesktop.swingx.JXTable table;
     private com.redis.stock.admin.swing.item.TableModelItems tableModel;
     // End of variables declaration//GEN-END:variables
}
