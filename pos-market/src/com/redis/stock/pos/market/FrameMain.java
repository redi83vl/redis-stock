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

import com.redis.stock.SQL;
import com.redis.stock.pos.core.Invoice;
import com.redis.stock.pos.core.Product;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Redjan Shabani
 */
public class FrameMain extends javax.swing.JFrame {
	
	
	private final Set<Product> products = new TreeSet<>();
	
	public FrameMain() {
		initComponents();
	}	
	
	private void addInvoiceEntry(Product prod) {
		
		if(prod == null)
			return;
		
		
		Invoice.Entry entry = new Invoice.Entry(
			prod.getCode(), 
			prod.getName(),
			prod.getUnit(), 
			1.0d, 
			prod.getPrice(), 
			prod.getTax()
		);
		
		this.panelInvoice1.add(entry);

		this.jXSearchField1.setText("");
	}
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jToolBar1 = new javax.swing.JToolBar();
          jButton4 = new javax.swing.JButton();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jLabel1 = new javax.swing.JLabel();
          jSplitPane1 = new javax.swing.JSplitPane();
          jPanel2 = new javax.swing.JPanel();
          jToolBar3 = new javax.swing.JToolBar();
          jComboBox1 = new javax.swing.JComboBox<>();
          filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton3 = new javax.swing.JButton();
          panelProducts = new javax.swing.JPanel();
          jPanel5 = new javax.swing.JPanel();
          jToolBar2 = new javax.swing.JToolBar();
          filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
          filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jToolBar4 = new javax.swing.JToolBar();
          filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jButton2 = new javax.swing.JButton();
          jButton1 = new javax.swing.JButton();
          panelInvoice1 = new com.redis.stock.pos.market.PanelInvoice();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("REDIS STOCK - PORTALI I SHITJEVE");
          setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
          setMinimumSize(new java.awt.Dimension(400, 225));
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });
          getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

          jToolBar1.setFloatable(false);
          jToolBar1.setRollover(true);
          jToolBar1.setBorderPainted(false);

          jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout-16.png"))); // NOI18N
          jButton4.setFocusable(false);
          jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton4.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton4ActionPerformed(evt);
               }
          });
          jToolBar1.add(jButton4);
          jToolBar1.add(filler1);

          jLabel1.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
          new javax.swing.Timer(
               1000,      
               (actioEvent) -> {
                    jLabel1.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
               } 
          ).start();
          jToolBar1.add(jLabel1);

          getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

          jSplitPane1.setDividerLocation(450);

          jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ARTIKUJT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
          jPanel2.setPreferredSize(new java.awt.Dimension(520, 521));
          jPanel2.setLayout(new java.awt.BorderLayout());

          jToolBar3.setFloatable(false);
          jToolBar3.setRollover(true);

          jComboBox1.setMaximumSize(new java.awt.Dimension(150, 20));
          jComboBox1.setMinimumSize(new java.awt.Dimension(150, 20));
          jComboBox1.setPreferredSize(new java.awt.Dimension(150, 20));
          jComboBox1.addItemListener(new java.awt.event.ItemListener() {
               public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    jComboBox1ItemStateChanged(evt);
               }
          });
          jToolBar3.add(jComboBox1);
          jToolBar3.add(filler11);

          jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-16.png"))); // NOI18N
          jButton3.setFocusable(false);
          jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton3.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
               }
          });
          jToolBar3.add(jButton3);

          jPanel2.add(jToolBar3, java.awt.BorderLayout.PAGE_START);

          panelProducts.setLayout(new java.awt.BorderLayout());
          jPanel2.add(panelProducts, java.awt.BorderLayout.CENTER);

          jSplitPane1.setRightComponent(jPanel2);

          jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FATURA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
          jPanel5.setMinimumSize(new java.awt.Dimension(450, 195));
          jPanel5.setPreferredSize(new java.awt.Dimension(520, 536));
          jPanel5.setLayout(new java.awt.BorderLayout(2, 2));

          jToolBar2.setFloatable(false);
          jToolBar2.setRollover(true);
          jToolBar2.add(filler9);

          jXSearchField1.setColumns(25);
          jXSearchField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          jXSearchField1.setToolTipText("");
          jXSearchField1.setMaximumSize(new java.awt.Dimension(162, 22));
          jXSearchField1.setPrompt("");
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
          jToolBar2.add(filler8);

          jPanel5.add(jToolBar2, java.awt.BorderLayout.PAGE_START);

          jToolBar4.setFloatable(false);
          jToolBar4.setRollover(true);
          jToolBar4.add(filler10);

          jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
          jButton2.setForeground(java.awt.Color.red);
          jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close-16.png"))); // NOI18N
          jButton2.setText("Anullo!");
          jButton2.setFocusable(false);
          jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
               }
          });
          jToolBar4.add(jButton2);

          jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
          jButton1.setForeground(new java.awt.Color(0, 153, 51));
          jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save-16.png"))); // NOI18N
          jButton1.setText("Konfirmo!");
          jButton1.setFocusable(false);
          jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          jToolBar4.add(jButton1);

          jPanel5.add(jToolBar4, java.awt.BorderLayout.PAGE_END);
          jPanel5.add(panelInvoice1, java.awt.BorderLayout.CENTER);

          jSplitPane1.setLeftComponent(jPanel5);

          getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          DialogLogin dialog = new DialogLogin(this) {
			@Override
			public void onLoginSuccess() {
				this.dispose();
			}
			
			@Override
			public void onLoginError(String message) {
				JOptionPane.showMessageDialog(this, message, "EROOR!", JOptionPane.ERROR_MESSAGE);
			}
		};
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
		
		
		this.products.addAll(Product.getAll());
		jComboBox1.addItem("");
		this.products.stream().map(Product::getGroup).distinct().sorted().forEach(group -> {
			jComboBox1.addItem(group);
		});
     }//GEN-LAST:event_formWindowOpened

     private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
		panelProducts.removeAll();
		
		JPanel panel = new JPanel(new WrapLayout(WrapLayout.LEFT));
		
		
		String group = this.jComboBox1.getSelectedIndex() == 0 ? "" : (String) this.jComboBox1.getSelectedItem();
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		for(Product p : this.products){
			if(p.getGroup().contains(group)) {				
				JButton button = new JButton(""
					+ "<html><center>"
					+ "" + p.getCode() + "<br/>"
					+ "<b>" + (p.getName().length() > 30 ? p.getName().substring(0, 30) : p.getName()) + "</b><br/>"
					+ "(" + df.format(p.getPrice()) + ") <b>" + df.format(p.getGrossPrice()) + "</b><br/>"
					+ "</center></html>");
				button.setPreferredSize(new Dimension(250, 60));
				
				button.setActionCommand(p.getCode());
				
				button.addActionListener((ActionEvent ae) -> {
					jXSearchField1.setText(ae.getActionCommand());
					jXSearchField1ActionPerformed(null);
				});

				panel.add(button);
			}
		}
		
		panelProducts.add(new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
     }//GEN-LAST:event_jComboBox1ItemStateChanged

     private void jXSearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXSearchField1ActionPerformed
          if(this.jXSearchField1.getText().isEmpty()){
			this.jButton3ActionPerformed(null);
			
			return;
		}
		
		Optional<Product> optional = this.products
			.stream()
			.filter(prod -> {return prod.getCode().toUpperCase().equals(jXSearchField1.getText().toUpperCase());})
			.findFirst();
		if(optional.isPresent())
			addInvoiceEntry(optional.get());
		else
			JOptionPane.showMessageDialog(this, "Artikulli nuk u gjet!", "Error!", JOptionPane.ERROR_MESSAGE);
     }//GEN-LAST:event_jXSearchField1ActionPerformed

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         this.panelInvoice1.clear();
     }//GEN-LAST:event_jButton2ActionPerformed

     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          DialogProductList dialog = new DialogProductList(this);
		dialog.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosed(WindowEvent we) {
				addInvoiceEntry(dialog.getSelectedProduct());
			}			
		});
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
     }//GEN-LAST:event_jButton3ActionPerformed

     private void jXSearchField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXSearchField1MouseClicked
          if(evt.getClickCount() == 2) {
			this.jButton3ActionPerformed(null);
			evt.consume();
		}
     }//GEN-LAST:event_jXSearchField1MouseClicked

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          boolean success = Invoice.add(this.panelInvoice1.getInvoice());
		if(success){
			
			int print = JOptionPane.showConfirmDialog(
				this, 
				"Deshironi te printoni faturen!", 
				"Print!", 
				JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.PLAIN_MESSAGE
			);
			
			if(print == 0){
				File file = Invoice.toHtml(this.panelInvoice1.getInvoice());
				
				try {
					Desktop.getDesktop().open(file);
				} 
				catch (IOException ex) {
					Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			
			this.panelInvoice1.clear();
		}
		else{
			JOptionPane.showMessageDialog(this, "Gabim gjate ruajtjes se fatures!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
     }//GEN-LAST:event_jButton1ActionPerformed

     private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          SQL.setUsername("");
		SQL.setPassword("");
		this.dispose();
     }//GEN-LAST:event_jButton4ActionPerformed
	
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.Box.Filler filler1;
     private javax.swing.Box.Filler filler10;
     private javax.swing.Box.Filler filler11;
     private javax.swing.Box.Filler filler8;
     private javax.swing.Box.Filler filler9;
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JButton jButton4;
     private javax.swing.JComboBox<String> jComboBox1;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JPanel jPanel5;
     private javax.swing.JSplitPane jSplitPane1;
     private javax.swing.JToolBar jToolBar1;
     private javax.swing.JToolBar jToolBar2;
     private javax.swing.JToolBar jToolBar3;
     private javax.swing.JToolBar jToolBar4;
     private org.jdesktop.swingx.JXSearchField jXSearchField1;
     private com.redis.stock.pos.market.PanelInvoice panelInvoice1;
     private javax.swing.JPanel panelProducts;
     // End of variables declaration//GEN-END:variables
}
