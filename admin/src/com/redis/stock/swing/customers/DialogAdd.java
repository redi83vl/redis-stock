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
package com.redis.stock.swing.customers;

import com.redis.stock.core.Customer;
import com.redis.stock.mysql.Customers;
import com.redis.stock.utils.Dataset;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Redjan Shabani
 */
public abstract class DialogAdd extends javax.swing.JDialog {
	
	public abstract Dataset<Customer> getDataset();
	
	public DialogAdd(java.awt.Frame parent) {
		super(parent, true);
		initComponents();
		
		this.fieldCode.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent de) {validateForm();}
			@Override
			public void removeUpdate(DocumentEvent de) {validateForm();}
			@Override
			public void changedUpdate(DocumentEvent de) {validateForm();}
		});
		
		this.fieldName.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent de) {validateForm();}
			@Override
			public void removeUpdate(DocumentEvent de) {validateForm();}
			@Override
			public void changedUpdate(DocumentEvent de) {validateForm();}
		});
	}
	
	private void validateForm() {
		this.jButton1.setEnabled(this.fieldCode.getText().length() >= 2 && this.fieldName.getText().length() >= 3);
	}
	
	public Customer get() {
		String code = this.fieldCode.getText();
		String name = this.fieldName.getText();
		String address = this.fieldAddress.getText();
		String phone = this.fieldPhone.getText();
		String email = this.fieldEmail.getText();
		
		return new Customer(code, name, address, phone, email);
	}
	
	public void set(Customer customer) {
		this.fieldCode.setText(customer.getCode());
		this.fieldName.setText(customer.getName());
		this.fieldAddress.setText(customer.getAddress());
		this.fieldPhone.setText(customer.getPhone());
		this.fieldEmail.setText(customer.getEmail());
		
		this.fieldCode.setEditable(false);
	}
	
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          fieldName = new javax.swing.JTextField();
          fieldCode = new javax.swing.JTextField();
          jLabel1 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jLabel5 = new javax.swing.JLabel();
          fieldPhone = new javax.swing.JTextField();
          jLabel2 = new javax.swing.JLabel();
          fieldEmail = new javax.swing.JTextField();
          fieldAddress = new javax.swing.JTextField();
          jToolBar1 = new javax.swing.JToolBar();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton1 = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setResizable(false);

          jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          fieldName.setColumns(25);

          fieldCode.setColumns(10);

          jLabel1.setText("Kodi");

          jLabel3.setText("Adresa");

          jLabel4.setText("Telefoni");

          jLabel5.setText("Email-i");

          fieldPhone.setColumns(25);

          jLabel2.setText("Emertimi");

          fieldEmail.setColumns(25);

          fieldAddress.setColumns(25);

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel1)
                         .addComponent(jLabel2)
                         .addComponent(jLabel3)
                         .addComponent(jLabel4)
                         .addComponent(jLabel5))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(fieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(fieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
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
                    .addGap(5, 5, 5))
          );

          getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);
          jToolBar1.add(filler1);

          jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/submit-16.png"))); // NOI18N
          jButton1.setEnabled(false);
          jButton1.setFocusable(false);
          jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton1);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.SOUTH);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		boolean success = this.getDataset().add(this.get());
		if(!success)
			JOptionPane.showMessageDialog(this, "Gabim gjate ruajtjes se te dhenave.", "Gabim!", JOptionPane.ERROR_MESSAGE);
		else
			this.dispose();
		
		
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
