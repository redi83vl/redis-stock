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
package com.redis.stock.admin.swing.output;

import com.redis.stock.admin.core.Client;
import com.redis.stock.admin.core.Employee;
import com.redis.stock.admin.core.Item;
import com.redis.stock.admin.core.Output;
import com.redis.stock.admin.core.Product;
import com.redis.stock.admin.swing.product.DialogProducts;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author Redjan Shabani
 */
public class DialogOutputCreate extends javax.swing.JDialog {
	
	private final List<Employee> authors = Employee.read();
	private final List<Client> targets = Client.read();
	private final List<Product> products = Product.read();
	
	
	public DialogOutputCreate(java.awt.Frame parent) {
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
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          tableModel = new com.redis.stock.admin.swing.item.TableModelItems();
          jPanel1 = new javax.swing.JPanel();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          fieldValue = new javax.swing.JFormattedTextField();
          checkBoxPaid = new javax.swing.JCheckBox();
          comboAuthor = new javax.swing.JComboBox<>();
          comboTarget = new javax.swing.JComboBox<>();
          jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
          jToolBar1 = new javax.swing.JToolBar();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton1 = new javax.swing.JButton();
          jPanel2 = new javax.swing.JPanel();
          jToolBar2 = new javax.swing.JToolBar();
          filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
          filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jScrollPane1 = new javax.swing.JScrollPane();
          table = new org.jdesktop.swingx.JXTable();

          tableModel.addTableModelListener(new javax.swing.event.TableModelListener() {
               public void tableChanged(javax.swing.event.TableModelEvent evt) {
                    tableModelTableChanged(evt);
               }
          });

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setPreferredSize(new java.awt.Dimension(800, 450));
          setResizable(false);
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });

          jLabel2.setText("Autori:");

          jLabel3.setText("Bleresi:");

          jLabel4.setText("Data:");

          fieldValue.setEditable(false);
          fieldValue.setColumns(10);
          fieldValue.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
          fieldValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
          fieldValue.setText("0.00");
          fieldValue.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

          checkBoxPaid.setText("Vlera");
          checkBoxPaid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
          checkBoxPaid.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
          checkBoxPaid.setIconTextGap(2);

          jXDatePicker1.setFormats("dd.MM.yyyy");

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
                    .addGap(4, 4, 4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(comboTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                              .addComponent(checkBoxPaid)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(comboAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel4)
                         .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel2)
                         .addComponent(comboAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(checkBoxPaid)
                         .addComponent(comboTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
          );

          getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);
          jToolBar1.add(filler1);

          jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save-16.png"))); // NOI18N
          jButton1.setText("Ruaj!");
          jButton1.setFocusable(false);
          jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton1);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

          jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
          jPanel2.setLayout(new java.awt.BorderLayout());

          jToolBar2.setFloatable(false);
          jToolBar2.setRollover(true);
          jToolBar2.add(filler3);

          jXSearchField1.setColumns(20);
          jXSearchField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          jXSearchField1.setToolTipText("");
          jXSearchField1.setLayoutStyle(org.jdesktop.swingx.JXSearchField.LayoutStyle.MAC);
          jXSearchField1.setMaximumSize(new java.awt.Dimension(250, 20));
          jXSearchField1.setPreferredSize(new java.awt.Dimension(250, 22));
          jXSearchField1.setSearchMode(org.jdesktop.swingx.JXSearchField.SearchMode.REGULAR);
          jXSearchField1.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jXSearchField1MouseClicked(evt);
               }
          });
          jXSearchField1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jXSearchField1ActionPerformed(evt);
               }
          });
          jToolBar2.add(jXSearchField1);
          jToolBar2.add(filler2);

          jPanel2.add(jToolBar2, java.awt.BorderLayout.NORTH);

          table.setModel(tableModel);
          table.setHighlighters(HighlighterFactory.createSimpleStriping());
          table.setShowHorizontalLines(false);
          table.setShowVerticalLines(false);
          table.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
               public void propertyChange(java.beans.PropertyChangeEvent evt) {
                    tablePropertyChange(evt);
               }
          });
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

          jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

          getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          Output output = Output.create(
			LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss")), 
			jXDatePicker1.getDate().toInstant(), 
			(Employee) comboAuthor.getSelectedItem(), 
			(Client) comboTarget.getSelectedItem(), 
			checkBoxPaid.isSelected(),
			tableModel.getItems()
		);
		
		if(output == null) {
			
			return;
		}
		this.dispose();
		
		DialogOutputView dialog = new DialogOutputView((java.awt.Frame) SwingUtilities.windowForComponent(this));
		dialog.setOutput(output);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jButton1ActionPerformed

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          this.jXDatePicker1.setDate(new Date());
		
		authors.forEach(employee -> {
			comboAuthor.addItem(employee);
		});
		
		targets.forEach(client -> {
			comboTarget.addItem(client);
		});
		
     }//GEN-LAST:event_formWindowOpened

     private void jXSearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXSearchField1ActionPerformed
		Product product = products
			.stream()
			.filter(prod -> jXSearchField1.getText().toUpperCase().equals(prod.getCode().toUpperCase()))
			.findFirst()
			.orElse(null);
		
		if(product == null) {
			JOptionPane.showMessageDialog(this, "Artikulli nuk gjet!", "Kujdes!", JOptionPane.WARNING_MESSAGE);			
			return;
		}
		
		jXSearchField1.setText("");
		tableModel.addRow(product.getCode(), product.getName(), product.getUnit(), 1.0d, product.getPrice(), product.getTax());
		
		
     }//GEN-LAST:event_jXSearchField1ActionPerformed

     private void tablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablePropertyChange
          // TODO add your handling code here:
     }//GEN-LAST:event_tablePropertyChange

     private void tableModelTableChanged(javax.swing.event.TableModelEvent evt) {//GEN-FIRST:event_tableModelTableChanged
          this.fieldValue.setValue(tableModel.getItems().stream().mapToDouble(Item::getGrossValue).sum());
     }//GEN-LAST:event_tableModelTableChanged

     private void jXSearchField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXSearchField1MouseClicked
          if(evt.getClickCount() == 2) {
			DialogProducts dialoag = new DialogProducts((Frame) SwingUtilities.windowForComponent(this)) {
				@Override
				public void productSelected(Product product) {
					tableModel.addItem(new Item(product.getCode(), product.getName(), product.getUnit(), 1.0d,product.getPrice(), product.getTax()));
				}
			};
			dialoag.setLocationRelativeTo(this);
			dialoag.setVisible(true);
			
			
			evt.consume();
		}
     }//GEN-LAST:event_jXSearchField1MouseClicked
	
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JCheckBox checkBoxPaid;
     private javax.swing.JComboBox<Employee> comboAuthor;
     private javax.swing.JComboBox<Client> comboTarget;
     private javax.swing.JFormattedTextField fieldValue;
     private javax.swing.Box.Filler filler1;
     private javax.swing.Box.Filler filler2;
     private javax.swing.Box.Filler filler3;
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JToolBar jToolBar1;
     private javax.swing.JToolBar jToolBar2;
     private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
     private org.jdesktop.swingx.JXSearchField jXSearchField1;
     private org.jdesktop.swingx.JXTable table;
     private com.redis.stock.admin.swing.item.TableModelItems tableModel;
     // End of variables declaration//GEN-END:variables
}
