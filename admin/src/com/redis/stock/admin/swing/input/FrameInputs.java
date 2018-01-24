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
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author Redjan Shabani
 */
public class FrameInputs extends javax.swing.JInternalFrame {
	
	public FrameInputs() {
		initComponents();
		
		this.table.getColumn(0).setCellRenderer(new DefaultTableCellRenderer(){
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
				super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
				
				this.setText((String) o);
				this.setHorizontalAlignment(CENTER);				
				
				return this;
			}
		});
		
		this.table.getColumn(1).setCellRenderer(new DefaultTableCellRenderer(){
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
				super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
				
				this.setText(new SimpleDateFormat("dd.MM.yyyy").format(Date.from((Instant) o)));
				this.setHorizontalAlignment(CENTER);				
				
				return this;
			}
		});
		
		this.table.setDefaultRenderer(Double.class, new DefaultTableCellRenderer(){
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
				super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
				
				this.setText(new DecimalFormat("0.00").format(o));
				this.setHorizontalAlignment(RIGHT);
				
				
				return this;
			}
		});
	}
	
	public Input getSelectedInput() {
		int row = this.table.getSelectedRow();
		
		if(row == -1)
			return null;
				
		return Input.read((String) this.table.getValueAt(row, 0));
	}
	
	private void reload() {
		List<Input> inputs = Input.read();
		
		inputs.stream().map(Input::getInstant).min(Instant::compareTo).ifPresent(instant -> datePickerMin.setDate(Date.from(instant)));
		inputs.stream().map(Input::getInstant).max(Instant::compareTo).ifPresent(instant -> datePickerMax.setDate(Date.from(instant)));
		
		comboAuthor.removeAllItems();
		comboAuthor.addItem("- TE GJITHE -");
		inputs.stream().map(Input::getAuthor).distinct().forEach(employee -> comboAuthor.addItem(employee));
		comboAuthor.setSelectedIndex(0);
		
		comboSource.removeAllItems();
		comboSource.addItem("- TE GJITHE -");
		inputs.stream().map(Input::getSource).distinct().forEach(supplier -> comboSource.addItem(supplier));
		comboSource.setSelectedIndex(0);
		
		comboPaid.setSelectedIndex(0);
		
		this.tableModel.setInputs(inputs);
	}
	
	private void filter() {
		List<RowFilter<TableModelInputs, Integer>> filters = new ArrayList<>();
		
		RowFilter<TableModelInputs, Integer> filterDate = new RowFilter<TableModelInputs, Integer>() {
			@Override
			public boolean include(RowFilter.Entry<? extends TableModelInputs, ? extends Integer> entry) {
				return 
					!entry.getModel().getInputs().get(entry.getIdentifier()).getInstant().isBefore(datePickerMin.getDate().toInstant()) &&
					!entry.getModel().getInputs().get(entry.getIdentifier()).getInstant().isAfter(datePickerMax.getDate().toInstant().plusSeconds(86400));
			}
		};
		filters.add(filterDate);
		
		RowFilter<TableModelInputs, Integer> filterAuthor = new RowFilter<TableModelInputs, Integer>() {
			@Override
			public boolean include(RowFilter.Entry<? extends TableModelInputs, ? extends Integer> entry) {
				return 
					comboAuthor.getSelectedIndex() == 0 || 
					entry.getModel().getInputs().get(entry.getIdentifier()).getAuthor().equals(comboAuthor.getSelectedItem());
			}
		};
		filters.add(filterAuthor);
		
		RowFilter<TableModelInputs, Integer> filterSource = new RowFilter<TableModelInputs, Integer>() {
			@Override
			public boolean include(RowFilter.Entry<? extends TableModelInputs, ? extends Integer> entry) {
				return 
					comboSource.getSelectedIndex() == 0 || 
					entry.getModel().getInputs().get(entry.getIdentifier()).getSource().equals(comboSource.getSelectedItem());
			}
		};
		filters.add(filterSource);
		
		RowFilter<TableModelInputs, Integer> filterPaid = new RowFilter<TableModelInputs, Integer>() {
			@Override
			public boolean include(RowFilter.Entry<? extends TableModelInputs, ? extends Integer> entry) {
				return 
					comboPaid.getSelectedIndex() == 0 || 
					(comboPaid.getSelectedIndex() == 1 && entry.getModel().getInputs().get(entry.getIdentifier()).isPaid()) ||
					(comboPaid.getSelectedIndex() == 2 && !entry.getModel().getInputs().get(entry.getIdentifier()).isPaid());
			}
		};
		filters.add(filterPaid);
		
		this.table.setRowFilter(RowFilter.andFilter(filters));
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          tableModel = new com.redis.stock.admin.swing.input.TableModelInputs();
          jToolBar1 = new javax.swing.JToolBar();
          jButton1 = new javax.swing.JButton();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton2 = new javax.swing.JButton();
          jButton3 = new javax.swing.JButton();
          jScrollPane2 = new javax.swing.JScrollPane();
          table = new org.jdesktop.swingx.JXTable();
          jPanel1 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          datePickerMin = new org.jdesktop.swingx.JXDatePicker();
          datePickerMax = new org.jdesktop.swingx.JXDatePicker();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          comboAuthor = new javax.swing.JComboBox<>();
          jLabel4 = new javax.swing.JLabel();
          comboSource = new javax.swing.JComboBox<>();
          jLabel5 = new javax.swing.JLabel();
          comboPaid = new javax.swing.JComboBox<>();

          setClosable(true);
          setIconifiable(true);
          setMaximizable(true);
          setResizable(true);
          setTitle("Daljet (Shitjet)");
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

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);

          jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh-16.png"))); // NOI18N
          jButton1.setFocusable(false);
          jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton1);
          jToolBar1.add(filler1);

          jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus-16.png"))); // NOI18N
          jButton2.setFocusable(false);
          jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton2);

          jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete-16.png"))); // NOI18N
          jButton3.setFocusable(false);
          jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton3.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton3);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

          jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          table.setModel(tableModel);
          table.setHighlighters(HighlighterFactory.createSimpleStriping());
          table.setShowHorizontalLines(false);
          table.setShowVerticalLines(false);
          table.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tableMouseClicked(evt);
               }
          });
          jScrollPane2.setViewportView(table);
          if (table.getColumnModel().getColumnCount() > 0) {
               table.getColumnModel().getColumn(0).setPreferredWidth(100);
               table.getColumnModel().getColumn(0).setHeaderValue("Kodi");
               table.getColumnModel().getColumn(1).setPreferredWidth(100);
               table.getColumnModel().getColumn(1).setHeaderValue("Data");
               table.getColumnModel().getColumn(2).setPreferredWidth(200);
               table.getColumnModel().getColumn(2).setHeaderValue("Autori");
               table.getColumnModel().getColumn(3).setPreferredWidth(200);
               table.getColumnModel().getColumn(3).setHeaderValue("Shitesi");
               table.getColumnModel().getColumn(4).setPreferredWidth(50);
               table.getColumnModel().getColumn(4).setHeaderValue("Vlera");
               table.getColumnModel().getColumn(5).setPreferredWidth(50);
               table.getColumnModel().getColumn(5).setHeaderValue("TVSH");
               table.getColumnModel().getColumn(6).setPreferredWidth(50);
               table.getColumnModel().getColumn(6).setHeaderValue("Total");
               table.getColumnModel().getColumn(7).setPreferredWidth(50);
               table.getColumnModel().getColumn(7).setHeaderValue("Paguar");
          }

          getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

          jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

          jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel1.setText("Periudha:");

          datePickerMin.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          datePickerMin.setFormats("dd.MM.yyyy");
          datePickerMin.setMaximumSize(new java.awt.Dimension(100, 20));
          datePickerMin.setMinimumSize(new java.awt.Dimension(100, 20));
          datePickerMin.setPreferredSize(new java.awt.Dimension(100, 20));
          datePickerMin.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    datePickerMinActionPerformed(evt);
               }
          });

          datePickerMax.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          datePickerMax.setFormats("dd.MM.yyyy");
          datePickerMax.setMaximumSize(new java.awt.Dimension(100, 20));
          datePickerMax.setMinimumSize(new java.awt.Dimension(100, 20));
          datePickerMax.setPreferredSize(new java.awt.Dimension(100, 20));
          datePickerMax.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    datePickerMaxActionPerformed(evt);
               }
          });

          jLabel2.setText("-");

          jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel3.setText("Autori:");

          comboAuthor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          comboAuthor.setMaximumRowCount(15);
          comboAuthor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- TE GJITHE -" }));
          comboAuthor.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboAuthorActionPerformed(evt);
               }
          });

          jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel4.setText("Shitesi:");

          comboSource.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          comboSource.setMaximumRowCount(15);
          comboSource.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- TE GJITHE -" }));
          comboSource.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboSourceActionPerformed(evt);
               }
          });

          jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel5.setText("Paguar:");

          comboPaid.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          comboPaid.setMaximumRowCount(3);
          comboPaid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- TE GJITHE -", "PO", "JO" }));
          comboPaid.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboPaidActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel1)
                         .addComponent(jLabel3)
                         .addComponent(jLabel4)
                         .addComponent(jLabel5))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(datePickerMin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(jLabel2)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(datePickerMax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addComponent(comboAuthor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(comboSource, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(comboPaid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel1)
                         .addComponent(datePickerMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(datePickerMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel3)
                         .addComponent(comboAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel4)
                         .addComponent(comboSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel5)
                         .addComponent(comboPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(341, Short.MAX_VALUE))
          );

          getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          this.reload();
     }//GEN-LAST:event_jButton1ActionPerformed

     private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
          this.reload();
     }//GEN-LAST:event_formInternalFrameOpened

     private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
		if(evt.getClickCount() == 2) {
			Input input = this.getSelectedInput();
			
			if(input != null) {
				DialogInputView dialog = new DialogInputView((java.awt.Frame) SwingUtilities.windowForComponent(this));
				dialog.setInput(input);
				dialog.setLocationRelativeTo(this);
				dialog.setVisible(true);
				
				this.reload();
			}
			
			
			
			
		}
     }//GEN-LAST:event_tableMouseClicked

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          DialogInputCreate dialog = new DialogInputCreate((java.awt.Frame) SwingUtilities.windowForComponent(this));
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
		
		this.reload();
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		Input input = this.getSelectedInput();
		if(input != null){
			int choice = JOptionPane.showConfirmDialog(
				this, 
				"Konfirmo veprimin e fshirjes!", 
				"Kujdes!", 
				JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.WARNING_MESSAGE
			);

			if(choice == 0){
				if(Input.delete(input)) {
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Gabim gjate veprimit te fshirjes!", "Error!", JOptionPane.ERROR_MESSAGE);
				}

				this.reload();
			}
		}
     }//GEN-LAST:event_jButton3ActionPerformed

     private void comboPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPaidActionPerformed
          this.filter();
     }//GEN-LAST:event_comboPaidActionPerformed

     private void comboSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSourceActionPerformed
          this.filter();
     }//GEN-LAST:event_comboSourceActionPerformed

     private void comboAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAuthorActionPerformed
          this.filter();
     }//GEN-LAST:event_comboAuthorActionPerformed

     private void datePickerMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerMinActionPerformed
          this.filter();
     }//GEN-LAST:event_datePickerMinActionPerformed

     private void datePickerMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerMaxActionPerformed
          this.filter();
     }//GEN-LAST:event_datePickerMaxActionPerformed


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JComboBox<Object> comboAuthor;
     private javax.swing.JComboBox<String> comboPaid;
     private javax.swing.JComboBox<Object> comboSource;
     private org.jdesktop.swingx.JXDatePicker datePickerMax;
     private org.jdesktop.swingx.JXDatePicker datePickerMin;
     private javax.swing.Box.Filler filler1;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JToolBar jToolBar1;
     private org.jdesktop.swingx.JXTable table;
     private com.redis.stock.admin.swing.input.TableModelInputs tableModel;
     // End of variables declaration//GEN-END:variables
}
