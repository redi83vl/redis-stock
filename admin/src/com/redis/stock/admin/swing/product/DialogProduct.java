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
package com.redis.stock.admin.swing.product;

import com.redis.stock.admin.core.Product;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Redjan Shabani
 */
public class DialogProduct extends javax.swing.JDialog {

	public DialogProduct(Component parent) {
		super((java.awt.Frame) SwingUtilities.windowForComponent(parent), true);
		initComponents();
		
		comboGroup.addItem("");
		Product.getAll().stream().map(Product::getGroup).distinct().sorted().forEach( group -> {
			this.comboGroup.addItem(group);
		});
		
	}
	
	public Product getProduct() {
		return new Product(
			fieldCode.getText(), 
			(String) comboGroup.getSelectedItem(), 
			fieldName.getText(), 
			fieldUnit.getText(), 
			((Number) fieldSize.getValue()).doubleValue(), 
			((Number) fieldCost.getValue()).doubleValue(), 
			((Number) fieldPrice.getValue()).doubleValue(), 
			((Number) fieldTax.getValue()).doubleValue()
		);
	}

	public void setProduct(Product product) {
		this.fieldCode.setText(product.getCode()); this.fieldCode.setEditable(false);
		
		this.comboGroup.setSelectedItem(product.getGroup()); 
		this.fieldName.setText(product.getName());
		this.fieldUnit.setText(product.getUnit());
		this.fieldSize.setValue(product.getSize());
		this.fieldCost.setValue(product.getCost());
		this.fieldPrice.setValue(product.getPrice());
		this.fieldTax.setValue(product.getTax());
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          fieldCode = new javax.swing.JTextField();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          fieldUnit = new javax.swing.JTextField();
          jLabel4 = new javax.swing.JLabel();
          fieldName = new javax.swing.JTextField();
          jLabel5 = new javax.swing.JLabel();
          fieldSize = new javax.swing.JFormattedTextField();
          jLabel6 = new javax.swing.JLabel();
          fieldCost = new javax.swing.JFormattedTextField();
          jLabel11 = new javax.swing.JLabel();
          fieldPrice = new javax.swing.JFormattedTextField();
          jLabel12 = new javax.swing.JLabel();
          fieldTax = new javax.swing.JFormattedTextField();
          comboGroup = new javax.swing.JComboBox<>();
          jToolBar1 = new javax.swing.JToolBar();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton1 = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setResizable(false);
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });

          jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          jLabel1.setText("Kodi");

          fieldCode.setColumns(15);
          fieldCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);

          jLabel2.setText("Sektori");

          jLabel3.setText("Njesia");

          fieldUnit.setColumns(7);

          jLabel4.setText("Emertimi");

          fieldName.setColumns(30);

          jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
          jLabel5.setText("<html><u>S</u>asia");

          fieldSize.setColumns(7);
          fieldSize.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
          fieldSize.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

          jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
          jLabel6.setText("<html><u>K</u>osto");

          fieldCost.setColumns(7);
          fieldCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
          fieldCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

          jLabel11.setText("<html><u>C</u>mimi");

          fieldPrice.setColumns(7);
          fieldPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
          fieldPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

          jLabel12.setText("<html><u>T</u>vsh");

          fieldTax.setColumns(7);
          fieldTax.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
          fieldTax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

          comboGroup.setEditable(true);
          comboGroup.setMaximumRowCount(15);

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel1)
                         .addComponent(jLabel2)
                         .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel4)
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                              .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(fieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(fieldUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(fieldSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(fieldCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addComponent(comboGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel1)
                         .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel2)
                         .addComponent(comboGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel4)
                         .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(fieldUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(fieldSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(fieldCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(fieldTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(fieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
          );

          getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);
          jToolBar1.add(filler1);

          jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save-16.png"))); // NOI18N
          jButton1.setText("Ruaj!");
          jButton1.setFocusable(false);
          jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton1);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.SOUTH);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          this.fieldSize.setValue(0.0d);
		this.fieldCost.setValue(0.0d);
		this.fieldPrice.setValue(0.0d);
		this.fieldTax.setValue(0.0d);
     }//GEN-LAST:event_formWindowOpened

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		int id = Product.put(this.getProduct());
		if(id == -1) {
			JOptionPane.showMessageDialog(this, "Gabim gjate ruajtjes se te dhenave!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		else {
			super.dispose();
			JOptionPane.showMessageDialog(this, "Te dhenat u ruajten me sukses!", "Success!", JOptionPane.PLAIN_MESSAGE);			
		}	
     }//GEN-LAST:event_jButton1ActionPerformed

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JComboBox<String> comboGroup;
     private javax.swing.JTextField fieldCode;
     private javax.swing.JFormattedTextField fieldCost;
     private javax.swing.JTextField fieldName;
     private javax.swing.JFormattedTextField fieldPrice;
     private javax.swing.JFormattedTextField fieldSize;
     private javax.swing.JFormattedTextField fieldTax;
     private javax.swing.JTextField fieldUnit;
     private javax.swing.Box.Filler filler1;
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel11;
     private javax.swing.JLabel jLabel12;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JToolBar jToolBar1;
     // End of variables declaration//GEN-END:variables
}
