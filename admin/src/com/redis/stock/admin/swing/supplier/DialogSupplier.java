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
package com.redis.stock.admin.swing.supplier;

import com.redis.stock.admin.core.Supplier;
import javax.swing.JOptionPane;

/**
 *
 * @author Redjan Shabani
 */
public class DialogSupplier extends javax.swing.JDialog {
		
	public DialogSupplier(java.awt.Frame parent) {
		super(parent, true);
		initComponents();
	}
	
	public void setSupplier(Supplier supplier) {
		this.fieldCode.setText(supplier.getCode());
		this.fieldName.setText(supplier.getName());
		this.fieldAddress.setText(supplier.getAddress());
		this.fieldPhone.setText(supplier.getPhone());
		this.fieldEmail.setText(supplier.getEmail());
		this.fieldCode.setEditable(false);
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jToolBar1 = new javax.swing.JToolBar();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton1 = new javax.swing.JButton();
          jPanel1 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          fieldCode = new javax.swing.JTextField();
          jLabel2 = new javax.swing.JLabel();
          fieldName = new javax.swing.JTextField();
          jLabel3 = new javax.swing.JLabel();
          fieldAddress = new javax.swing.JTextField();
          jLabel4 = new javax.swing.JLabel();
          fieldPhone = new javax.swing.JTextField();
          jLabel5 = new javax.swing.JLabel();
          fieldEmail = new javax.swing.JTextField();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setResizable(false);

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

          getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

          jLabel1.setText("Kodi");

          fieldCode.setColumns(10);

          jLabel2.setText("Emertimi");

          fieldName.setColumns(25);

          jLabel3.setText("Adresa");

          fieldAddress.setColumns(25);

          jLabel4.setText("Telefon");

          fieldPhone.setColumns(25);

          jLabel5.setText("Email");

          fieldEmail.setColumns(25);

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel1)
                         .addComponent(jLabel2)
                         .addComponent(jLabel3)
                         .addComponent(jLabel4)
                         .addComponent(jLabel5))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(fieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                         .addComponent(fieldAddress)
                         .addComponent(fieldPhone)
                         .addComponent(fieldEmail)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                         .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(fieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel4)
                         .addComponent(fieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel5)
                         .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
          );

          getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		Supplier supplier = Supplier.create(
			fieldCode.getText(), 
			fieldName.getText(), 
			fieldAddress.getText(), 
			fieldPhone.getText(), 
			fieldEmail.getText()
		);

		if(supplier == null) {
			JOptionPane.showMessageDialog(this, "Gabim gjate ruajtjes se te dhenave!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		else {
			this.dispose();
			JOptionPane.showMessageDialog(this, "Te dhenat u ruajtn me sukses!", "Success!", JOptionPane.PLAIN_MESSAGE);	
		}	
     }//GEN-LAST:event_jButton1ActionPerformed
	
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JTextField fieldAddress;
     private javax.swing.JTextField fieldCode;
     private javax.swing.JTextField fieldEmail;
     private javax.swing.JTextField fieldName;
     private javax.swing.JTextField fieldPhone;
     private javax.swing.Box.Filler filler1;
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JToolBar jToolBar1;
     // End of variables declaration//GEN-END:variables
}
