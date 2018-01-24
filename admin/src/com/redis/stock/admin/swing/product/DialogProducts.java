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
import java.util.Set;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author Redjan Shabani
 */
public abstract class DialogProducts extends javax.swing.JDialog {
	
	public DialogProducts(java.awt.Frame parent) {
		super(parent, true);
		initComponents();
		
		this.table.setSortable(false);
	}
	
	public Product getSelectedProduct() {
		int row = this.table.getSelectedRow();
		if( row != -1 ) {
			row = table.convertRowIndexToModel(row);
			return tableModel.getProducts().get(row);
		}
		return null;
	}
	
	private void setTableRowFilter() {				
		this.table.setRowFilter(RowFilter.regexFilter("(?i)" + this.searchField.getText(), 0, 1, 2));
	}
	
	public abstract void productSelected(Product product);
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          tableModel = new com.redis.stock.admin.swing.product.TableModelProducts();
          jPanel2 = new javax.swing.JPanel();
          searchField = new org.jdesktop.swingx.JXSearchField();
          jScrollPane1 = new javax.swing.JScrollPane();
          table = new org.jdesktop.swingx.JXTable();
          jToolBar1 = new javax.swing.JToolBar();
          buttonReload = new javax.swing.JButton();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          buttonPut = new javax.swing.JButton();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setPreferredSize(new java.awt.Dimension(800, 450));
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

          table.setModel(tableModel);
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
               table.getColumnModel().getColumn(0).setHeaderValue("Kodi");
               table.getColumnModel().getColumn(1).setPreferredWidth(100);
               table.getColumnModel().getColumn(1).setHeaderValue("Kategoria");
               table.getColumnModel().getColumn(2).setPreferredWidth(250);
               table.getColumnModel().getColumn(2).setHeaderValue("Emertimi");
               table.getColumnModel().getColumn(3).setPreferredWidth(50);
               table.getColumnModel().getColumn(3).setHeaderValue("Njesia");
               table.getColumnModel().getColumn(4).setPreferredWidth(50);
               table.getColumnModel().getColumn(4).setHeaderValue("Sasia");
               table.getColumnModel().getColumn(5).setPreferredWidth(50);
               table.getColumnModel().getColumn(5).setHeaderValue("Kosto");
               table.getColumnModel().getColumn(6).setPreferredWidth(50);
               table.getColumnModel().getColumn(6).setHeaderValue("Vlera");
               table.getColumnModel().getColumn(7).setPreferredWidth(50);
               table.getColumnModel().getColumn(7).setHeaderValue("Cmimi");
               table.getColumnModel().getColumn(8).setPreferredWidth(50);
               table.getColumnModel().getColumn(8).setHeaderValue("Tvsh");
          }

          getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);

          buttonReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh-16.png"))); // NOI18N
          buttonReload.setFocusable(false);
          buttonReload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          buttonReload.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          buttonReload.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonReloadActionPerformed(evt);
               }
          });
          jToolBar1.add(buttonReload);
          jToolBar1.add(filler1);

          buttonPut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus-16.png"))); // NOI18N
          buttonPut.setFocusable(false);
          buttonPut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          buttonPut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          buttonPut.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonPutActionPerformed(evt);
               }
          });
          jToolBar1.add(buttonPut);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
          this.setTableRowFilter();
     }//GEN-LAST:event_searchFieldActionPerformed

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          this.tableModel.setProducts(Product.getAll());
     }//GEN-LAST:event_formWindowOpened

     private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
          if(evt.getClickCount() == 2) {
			super.dispose();	
			if(this.getSelectedProduct() != null)
				this.productSelected(this.getSelectedProduct());
		}
     }//GEN-LAST:event_tableMouseClicked

     private void buttonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReloadActionPerformed
          Set<Product> products = Product.getAll();

          this.tableModel.setProducts(products);
     }//GEN-LAST:event_buttonReloadActionPerformed

     private void buttonPutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPutActionPerformed
          DialogProduct dialog = new DialogProduct(SwingUtilities.windowForComponent(this));
          dialog.setLocationRelativeTo(this);
          dialog.setVisible(true);
          this.buttonReloadActionPerformed(evt);
     }//GEN-LAST:event_buttonPutActionPerformed
	
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton buttonPut;
     private javax.swing.JButton buttonReload;
     private javax.swing.Box.Filler filler1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JToolBar jToolBar1;
     private org.jdesktop.swingx.JXSearchField searchField;
     private org.jdesktop.swingx.JXTable table;
     private com.redis.stock.admin.swing.product.TableModelProducts tableModel;
     // End of variables declaration//GEN-END:variables


}
