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
package com.redis.stock.pos.market;

import com.redis.stock.pos.core.Product;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author Redjan Shabani
 */
public class DialogProductList extends javax.swing.JDialog {
	
	private Product selectedProduct = null;
	
	public DialogProductList(java.awt.Frame parent) {
		super(parent, true);
		initComponents();
		
		table.getColumn(3).setCellRenderer(new DefaultTableCellRenderer(){
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focused, int i, int i1) {
				super.getTableCellRendererComponent(jtable, o, selected, focused, i, i1);
				
				this.setText(new DecimalFormat("#0.00").format(o));
				
				this.setHorizontalAlignment(JLabel.RIGHT);
				this.setBackground(selected ? jtable.getSelectionBackground() : jtable.getBackground());
				this.setForeground(selected ? jtable.getSelectionForeground(): jtable.getForeground());
				
				return this;
			}
			
		});
		
		table.getColumn(4).setCellRenderer(new DefaultTableCellRenderer(){
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focused, int i, int i1) {
				super.getTableCellRendererComponent(jtable, o, selected, focused, i, i1);
				
				this.setText(new DecimalFormat("#0.00").format(o));
				
				this.setHorizontalAlignment(JLabel.RIGHT);
				this.setBackground(selected ? jtable.getSelectionBackground() : jtable.getBackground());
				this.setForeground(selected ? jtable.getSelectionForeground(): jtable.getForeground());
				
				return this;
			}
			
		});
		
		table.getColumn(5).setCellRenderer(new DefaultTableCellRenderer(){
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focused, int i, int i1) {
				super.getTableCellRendererComponent(jtable, o, selected, focused, i, i1);
				
				this.setText(new DecimalFormat("##.##%").format(o));
				
				this.setHorizontalAlignment(JLabel.RIGHT);
				this.setBackground(selected ? jtable.getSelectionBackground() : jtable.getBackground());
				this.setForeground(selected ? jtable.getSelectionForeground(): jtable.getForeground());
				
				return this;
			}			
		});
	}
	
	private void setTableRowFilter() {				
		this.table.setRowFilter(RowFilter.regexFilter("(?i)" + this.searchField.getText(), 0, 1, 2));
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel2 = new javax.swing.JPanel();
          searchField = new org.jdesktop.swingx.JXSearchField();
          jScrollPane1 = new javax.swing.JScrollPane();
          table = new org.jdesktop.swingx.JXTable();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });

          searchField.setColumns(25);
          searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          searchField.setLayoutStyle(org.jdesktop.swingx.JXSearchField.LayoutStyle.MAC);
          searchField.setPrompt("Kerko ...");
          searchField.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    searchFieldActionPerformed(evt);
               }
          });
          jPanel2.add(searchField);

          getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

          table.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {

               },
               new String [] {
                    "Kodi", "Emertimi", "Njesia", "Sasia", "Cmimi", "Tvsh", "Cmim + Tvsh"
               }
          ) {
               Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
               };
               boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, true
               };

               public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
               }

               public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
               }
          });
          table.setHighlighters(HighlighterFactory.createAlternateStriping());
          table.setShowHorizontalLines(false);
          table.setShowVerticalLines(false);
          table.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tableMouseClicked(evt);
               }
          });
          jScrollPane1.setViewportView(table);
          if (table.getColumnModel().getColumnCount() > 0) {
               table.getColumnModel().getColumn(0).setPreferredWidth(50);
               table.getColumnModel().getColumn(1).setPreferredWidth(200);
               table.getColumnModel().getColumn(2).setPreferredWidth(50);
               table.getColumnModel().getColumn(3).setPreferredWidth(50);
               table.getColumnModel().getColumn(4).setPreferredWidth(50);
               table.getColumnModel().getColumn(5).setPreferredWidth(50);
               table.getColumnModel().getColumn(6).setPreferredWidth(50);
          }

          getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
          this.setTableRowFilter();
     }//GEN-LAST:event_searchFieldActionPerformed

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          Product.getAll().stream().sorted().forEach( product -> {
               ((DefaultTableModel) this.table.getModel()).addRow(new Object[]{
                    product,
                    product.getName(),
                    product.getUnit(),
                    product.getSize(),
				product.getPrice(),
				product.getTax(),
				product.getGrossPrice()
               });
          });
     }//GEN-LAST:event_formWindowOpened

     private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
          if(evt.getClickCount() == 2 && table.getSelectedRow() != -1) {
			this.selectedProduct = (Product) table.getValueAt(table.getSelectedRow(), 0);
			super.dispose();			
		}
     }//GEN-LAST:event_tableMouseClicked
	
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JPanel jPanel2;
     private javax.swing.JScrollPane jScrollPane1;
     private org.jdesktop.swingx.JXSearchField searchField;
     private org.jdesktop.swingx.JXTable table;
     // End of variables declaration//GEN-END:variables


}
