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

import com.redis.stock.SQL;
import com.redis.stock.admin.Stock;

/**
 *
 * @author Redjan Shabani
 */
public class DialogConfig extends javax.swing.JDialog {
	
	public DialogConfig(java.awt.Frame parent) {
		super(parent, true);
		initComponents();
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jToolBar1 = new javax.swing.JToolBar();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton1 = new javax.swing.JButton();
          jTabbedPane1 = new javax.swing.JTabbedPane();
          jPanel2 = new javax.swing.JPanel();
          jLabel5 = new javax.swing.JLabel();
          textStockCode = new javax.swing.JTextField();
          jLabel6 = new javax.swing.JLabel();
          textStockName = new javax.swing.JTextField();
          jLabel7 = new javax.swing.JLabel();
          textStockAddress = new javax.swing.JTextField();
          jLabel8 = new javax.swing.JLabel();
          textStockPhone = new javax.swing.JTextField();
          jLabel9 = new javax.swing.JLabel();
          textStockEmail = new javax.swing.JTextField();
          jPanel1 = new javax.swing.JPanel();
          textSqlSchemaName = new javax.swing.JTextField();
          textSqlPassword = new javax.swing.JPasswordField();
          jLabel4 = new javax.swing.JLabel();
          textSqlUsername = new javax.swing.JTextField();
          textSqlHostUrl = new javax.swing.JTextField();
          jLabel3 = new javax.swing.JLabel();
          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setTitle("KONFIGURIM MAGAZINA");
          setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
          setResizable(false);
          setType(java.awt.Window.Type.POPUP);
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });

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

          jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

          jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel5.setText("NIPT");

          textStockCode.setColumns(10);
          textStockCode.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

          jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel6.setText("Emertimi");

          textStockName.setColumns(20);
          textStockName.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

          jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel7.setText("Adresa");

          textStockAddress.setColumns(20);
          textStockAddress.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

          jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel8.setText("Telefon");

          textStockPhone.setColumns(20);
          textStockPhone.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

          jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel9.setText("Email");

          textStockEmail.setColumns(20);
          textStockEmail.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel5)
                         .addComponent(jLabel6)
                         .addComponent(jLabel7)
                         .addComponent(jLabel8)
                         .addComponent(jLabel9))
                    .addGap(5, 5, 5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(textStockCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(textStockPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                         .addComponent(textStockAddress)
                         .addComponent(textStockName)
                         .addComponent(textStockEmail))
                    .addGap(5, 5, 5))
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(textStockCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel5))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel6)
                         .addComponent(textStockName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel7)
                         .addComponent(textStockAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel8)
                         .addComponent(textStockPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel9)
                         .addComponent(textStockEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5))
          );

          jTabbedPane1.addTab("Info Magazina", jPanel2);

          textSqlSchemaName.setColumns(20);
          textSqlSchemaName.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

          textSqlPassword.setColumns(20);
          textSqlPassword.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

          jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel4.setText("Password");

          textSqlUsername.setColumns(20);
          textSqlUsername.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

          textSqlHostUrl.setColumns(20);
          textSqlHostUrl.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

          jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel3.setText("Username");

          jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel1.setText("Host URL");

          jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel2.setText("Schema");

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
                         .addComponent(jLabel4))
                    .addGap(5, 5, 5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(textSqlHostUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                         .addComponent(textSqlSchemaName)
                         .addComponent(textSqlUsername)
                         .addComponent(textSqlPassword))
                    .addGap(5, 5, 5))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel1)
                         .addComponent(textSqlHostUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel2)
                         .addComponent(textSqlSchemaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(textSqlUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel4)
                         .addComponent(textSqlPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5))
          );

          jTabbedPane1.addTab("Databaza MySQL", jPanel1);

          getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          textSqlHostUrl.setText(SQL.getHostUrl());
		textSqlSchemaName.setText(SQL.getSchemaName());
		textSqlUsername.setText(SQL.getUsername());
		textSqlPassword.setText(SQL.getPassword());
		
		textStockCode.setText(Stock.getCode());
		textStockName.setText(Stock.getName());
		textStockAddress.setText(Stock.getAddress());
		textStockPhone.setText(Stock.getPhone());
		textStockEmail.setText(Stock.getEmail());
     }//GEN-LAST:event_formWindowOpened

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          Stock.setCode(this.textStockCode.getText());
		Stock.setName(this.textStockName.getText());
		Stock.setAddress(this.textStockAddress.getText());
		Stock.setPhone(this.textStockPhone.getText());
		Stock.setEmail(this.textStockEmail.getText());
		
		SQL.setHostUrl(this.textSqlHostUrl.getText());
		SQL.setSchemaName(this.textSqlSchemaName.getText());
		SQL.setUsername(this.textSqlUsername.getText());
		SQL.setPassword(this.textSqlPassword.getText());
		
		this.dispose();
     }//GEN-LAST:event_jButton1ActionPerformed
	
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.Box.Filler filler1;
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JLabel jLabel7;
     private javax.swing.JLabel jLabel8;
     private javax.swing.JLabel jLabel9;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JTabbedPane jTabbedPane1;
     private javax.swing.JToolBar jToolBar1;
     private javax.swing.JTextField textSqlHostUrl;
     private javax.swing.JPasswordField textSqlPassword;
     private javax.swing.JTextField textSqlSchemaName;
     private javax.swing.JTextField textSqlUsername;
     private javax.swing.JTextField textStockAddress;
     private javax.swing.JTextField textStockCode;
     private javax.swing.JTextField textStockEmail;
     private javax.swing.JTextField textStockName;
     private javax.swing.JTextField textStockPhone;
     // End of variables declaration//GEN-END:variables
}
