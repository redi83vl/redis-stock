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
package com.redis.stock.swing.product;

import com.redis.stock.Stock;
import com.redis.stock.core.Product;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Redjan Shabani
 */
public class DialogProductInsert extends javax.swing.JDialog {
	
	
	public DialogProductInsert(java.awt.Frame parent) {
		super(parent, true);
		initComponents();
		
		this.fieldCode.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent de) {validateProduct();}
			@Override
			public void removeUpdate(DocumentEvent de) {validateProduct();}
			@Override
			public void changedUpdate(DocumentEvent de) {validateProduct();}
		});
		
		this.fieldName.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent de) {validateProduct();}
			@Override
			public void removeUpdate(DocumentEvent de) {validateProduct();}
			@Override
			public void changedUpdate(DocumentEvent de) {validateProduct();}
		});
		
		
		
	}
	
	private void validateProduct() {
		this.jButton1.setEnabled(this.fieldCode.getText().length() >= 2 && this.fieldName.getText().length() >= 3);
	}
	
	public Product get() {
		String code = this.fieldCode.getText();
		String name = this.fieldName.getText();
		String group = (String) this.comboGroup.getEditor().getItem();
		String unit = (String) this.comboUnit.getEditor().getItem();
		Double 
			size = (Double) spinnerSize.getValue(), 
			cost = (Double) spinnerCost.getValue(),
			price = (Double) spinnerPrice.getValue(), 
			tax = (Double) spinnerTax.getValue();
		
		return new Product(code, group, name, unit, size, cost, price, tax / 100);
	}
	
	public void set(Product entry) {
		this.fieldCode.setText(entry.getCode());
		this.comboGroup.setSelectedItem(entry.getGroup());
		this.fieldName.setText(entry.getName());
		this.comboUnit.setSelectedItem(entry.getUnit());
		this.spinnerSize.setValue(entry.getSize());
		this.spinnerCost.setValue(entry.getCost());
		this.spinnerPrice.setValue(entry.getPrice());
		this.spinnerTax.setValue(entry.getTax()*100.0d);
		
		this.fieldCode.setEditable(false);
		this.jButton1.setEnabled(true);
	}
	
	
	
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          comboUnit = new com.alee.laf.combobox.WebComboBox();
          fieldName = new com.alee.laf.text.WebTextField();
          comboGroup = new com.alee.laf.combobox.WebComboBox();
          fieldCode = new com.alee.laf.text.WebTextField();
          jToolBar1 = new javax.swing.JToolBar();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton1 = new javax.swing.JButton();
          jPanel2 = new javax.swing.JPanel();
          spinnerTax = new com.alee.laf.spinner.WebSpinner();
          spinnerPrice = new com.alee.laf.spinner.WebSpinner();
          spinnerCost = new com.alee.laf.spinner.WebSpinner();
          jLabel6 = new javax.swing.JLabel();
          jLabel7 = new javax.swing.JLabel();
          jLabel8 = new javax.swing.JLabel();
          jLabel9 = new javax.swing.JLabel();
          spinnerSize = new com.alee.laf.spinner.WebSpinner();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setResizable(false);

          jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          jLabel1.setText("Kodi");

          jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          jLabel3.setText("Emertimi");

          jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          jLabel4.setText("Njesia");

          jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          jLabel2.setText("Kategoria");

          comboUnit.setEditable(true);

          fieldName.setColumns(30);

          comboGroup.setEditable(true);

          fieldCode.setColumns(10);

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel1)
                         .addComponent(jLabel3)
                         .addComponent(jLabel2)
                         .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                         .addComponent(comboGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                         .addComponent(comboUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                         .addComponent(jLabel1)
                         .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(2, 2, 2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                         .addComponent(comboGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                         .addComponent(jLabel4)
                         .addComponent(comboUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

          jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          spinnerTax.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));

          spinnerPrice.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

          spinnerCost.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

          jLabel6.setText("Kosto");

          jLabel7.setText("Cmim");

          jLabel8.setText("Tatim %");

          jLabel9.setText("Sasi");

          spinnerSize.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel9)
                         .addComponent(jLabel6)
                         .addComponent(jLabel7)
                         .addComponent(jLabel8))
                    .addGap(5, 5, 5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel2Layout.createSequentialGroup()
                              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(spinnerCost, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(spinnerTax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(spinnerPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGap(5, 5, 5))
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                              .addComponent(spinnerSize, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addContainerGap())))
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(spinnerSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel9))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(spinnerCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel6))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(spinnerPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel7))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(spinnerTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel8))
                    .addGap(5, 5, 5))
          );

          getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		boolean success = Stock.getInstance().products().insert(this.get());
		if(!success)
			JOptionPane.showMessageDialog(this, "Gabim gjate ruajtjes se te dhenave.", "Gabim!", JOptionPane.ERROR_MESSAGE);
		else
			this.dispose();
		
		
     }//GEN-LAST:event_jButton1ActionPerformed
	
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private com.alee.laf.combobox.WebComboBox comboGroup;
     private com.alee.laf.combobox.WebComboBox comboUnit;
     private com.alee.laf.text.WebTextField fieldCode;
     private com.alee.laf.text.WebTextField fieldName;
     private javax.swing.Box.Filler filler1;
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JLabel jLabel7;
     private javax.swing.JLabel jLabel8;
     private javax.swing.JLabel jLabel9;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JToolBar jToolBar1;
     private com.alee.laf.spinner.WebSpinner spinnerCost;
     private com.alee.laf.spinner.WebSpinner spinnerPrice;
     private com.alee.laf.spinner.WebSpinner spinnerSize;
     private com.alee.laf.spinner.WebSpinner spinnerTax;
     // End of variables declaration//GEN-END:variables

	
}
