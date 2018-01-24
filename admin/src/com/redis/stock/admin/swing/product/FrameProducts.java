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

import com.redis.stock.admin.core.Output;
import com.redis.stock.admin.core.Product;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author Redjan Shabani
 */
public class FrameProducts extends javax.swing.JInternalFrame {
	
	public FrameProducts() {
		initComponents();
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
		Set<RowFilter<TableModel, Integer>> filters = new HashSet<>();
		if(tree.getSelectionPath() != null && tree.getSelectionPath().getPathCount() == 2)
			filters.add(RowFilter.regexFilter(String.valueOf(tree.getSelectionPath().getLastPathComponent()), 1));
		filters.add(RowFilter.regexFilter("(?i)" + this.searchField.getText(), 0, 1, 2));
		
		this.table.setRowFilter(RowFilter.andFilter(filters));
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          tableModel = new com.redis.stock.admin.swing.product.TableModelProducts();
          jSplitPane1 = new javax.swing.JSplitPane();
          jPanel1 = new javax.swing.JPanel();
          jPanel2 = new javax.swing.JPanel();
          searchField = new org.jdesktop.swingx.JXSearchField();
          jScrollPane1 = new javax.swing.JScrollPane();
          table = new org.jdesktop.swingx.JXTable();
          jScrollPane2 = new javax.swing.JScrollPane();
          tree = new org.jdesktop.swingx.JXTree();
          jToolBar1 = new javax.swing.JToolBar();
          buttonReload = new javax.swing.JButton();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          buttonPut = new javax.swing.JButton();
          buttonRemove = new javax.swing.JButton();

          setClosable(true);
          setIconifiable(true);
          setMaximizable(true);
          setResizable(true);
          setTitle("ARTIKUJT (GJENDJET)");
          setPreferredSize(new java.awt.Dimension(800, 450));
          addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
               public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
               }
               public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
               }
               public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
               }
               public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
               }
               public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
               }
               public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
               }
               public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                    formInternalFrameOpened(evt);
               }
          });

          jSplitPane1.setDividerLocation(250);

          jPanel1.setLayout(new java.awt.BorderLayout());

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

          jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

          table.setModel(tableModel);
          table.setHighlighters(HighlighterFactory.createAlternateStriping());
          table.setShowHorizontalLines(false);
          table.setShowVerticalLines(false);
          jScrollPane1.setViewportView(table);
          if (table.getColumnModel().getColumnCount() > 0) {
               table.getColumnModel().getColumn(0).setPreferredWidth(50);
               table.getColumnModel().getColumn(1).setPreferredWidth(100);
               table.getColumnModel().getColumn(2).setPreferredWidth(200);
               table.getColumnModel().getColumn(3).setPreferredWidth(50);
               table.getColumnModel().getColumn(4).setPreferredWidth(50);
               table.getColumnModel().getColumn(5).setPreferredWidth(50);
               table.getColumnModel().getColumn(6).setPreferredWidth(50);
               table.getColumnModel().getColumn(7).setPreferredWidth(50);
          }

          jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

          jSplitPane1.setRightComponent(jPanel1);

          tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
               public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                    treeValueChanged(evt);
               }
          });
          jScrollPane2.setViewportView(tree);

          jSplitPane1.setLeftComponent(jScrollPane2);

          getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

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

          buttonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete-16.png"))); // NOI18N
          buttonRemove.setFocusable(false);
          buttonRemove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          buttonRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          buttonRemove.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonRemoveActionPerformed(evt);
               }
          });
          jToolBar1.add(buttonRemove);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void buttonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReloadActionPerformed
          Set<Product> products = Product.getAll();
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Te Gjithe");
		products.stream().map(Product::getGroup).distinct().sorted().forEach( group -> {
			root.add(new DefaultMutableTreeNode(group));
		});
		((DefaultTreeModel) this.tree.getModel()).setRoot(root);
		
		this.tableModel.setProducts(products);
		
		
		this.tree.setSelectionRow(0);
     }//GEN-LAST:event_buttonReloadActionPerformed

     private void buttonPutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPutActionPerformed
          DialogProduct dialog = new DialogProduct(SwingUtilities.windowForComponent(this));
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
		this.buttonReloadActionPerformed(evt);
     }//GEN-LAST:event_buttonPutActionPerformed

     private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
          Product product = this.getSelectedProduct();
		if(product!=null){
			int choice = JOptionPane.showConfirmDialog(
				this, 
				"Konfirmo veprimin e fshirjes!", 
				"Kujdes!", 
				JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.WARNING_MESSAGE
			);

			if(choice == 0){
				if(Product.delete(product)) {
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Gabim gjate veprimit te fshirjes!", "Error!", JOptionPane.ERROR_MESSAGE);
				}

				this.buttonReloadActionPerformed(evt);
			}
		}
		
     }//GEN-LAST:event_buttonRemoveActionPerformed

     private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeValueChanged
          this.setTableRowFilter();
     }//GEN-LAST:event_treeValueChanged

     private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
          this.setTableRowFilter();
     }//GEN-LAST:event_searchFieldActionPerformed

     private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
          this.buttonReloadActionPerformed(null);
     }//GEN-LAST:event_formInternalFrameOpened


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton buttonPut;
     private javax.swing.JButton buttonReload;
     private javax.swing.JButton buttonRemove;
     private javax.swing.Box.Filler filler1;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JSplitPane jSplitPane1;
     private javax.swing.JToolBar jToolBar1;
     private org.jdesktop.swingx.JXSearchField searchField;
     private org.jdesktop.swingx.JXTable table;
     private com.redis.stock.admin.swing.product.TableModelProducts tableModel;
     private org.jdesktop.swingx.JXTree tree;
     // End of variables declaration//GEN-END:variables
}
