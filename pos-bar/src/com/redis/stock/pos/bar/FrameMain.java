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
package com.redis.stock.pos.bar;

import com.redis.stock.pos.core.Client;
import com.redis.stock.pos.core.Employee;
import com.redis.stock.pos.core.Invoice;
import com.redis.stock.pos.core.Product;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Redjan Shabani
 */
public class FrameMain extends javax.swing.JFrame implements ActionListener{
	private Instant startInstant;
	private Integer size;
	private Double value;
	private Employee employee;
	private List<Client> clients;
	private List<Product> products;	
	private Map<Client, Invoice> invoices = new HashMap<>();	
	
	private final Map<JButton, Client> buttons = new HashMap<>();
	
	
	public FrameMain() {
		initComponents();	
	}
	
	private void start(String code) {
		this.startInstant = Instant.now();
		this.size = 0;
		this.value = 0.0d;
		
		employee = Employee.get(code);
		clients = Client.getAll();
		products = Product.getAll();
		
		this.clients.forEach( client -> {
			System.out.println(client);
			
			JButton button = new JButton();
			button.setActionCommand(client.getCode());
			button.setIcon(new ImageIcon(this.getClass().getResource("/icons/restaurant-table-64.png")));
			button.setText(client.getName());
			button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			button.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
			button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
			button.setBackground(Color.GREEN);
			
			button.addActionListener(this);
						
			this.panelCenter.add(button);			
			this.buttons.put(button, client);
		});
	}
	
	
	private static final File SESSION = new File("session.dat");
	private void pause() {
		Map<String, Object> session = new HashMap<>();
		session.put("start_instant", this.startInstant);
		session.put("employee", this.employee);
		session.put("clients", this.clients);
		session.put("products", this.products);
		session.put("invoices", this.invoices);
		
		try (FileOutputStream fos = new FileOutputStream(SESSION); 
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(session);
		}
		catch (IOException ex) {
			Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
		}
         
	}
	
	private void resume() {
		try(FileInputStream fis = new FileInputStream(SESSION); 
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			Map<String, Object> session = (Map<String, Object>) ois.readObject();
			this.startInstant = (Instant) session.get("start_instant");
			this.employee = (Employee) session.get("employee");
			this.clients = (List<Client>) session.get("clients");
			this.products = (List<Product>) session.get("products");
			this.invoices = (Map<Client, Invoice>) session.get("invoices");
			
			this.clients.forEach( client -> {
				System.out.println(client);

				JButton button = new JButton();
				button.setActionCommand(client.getCode());
				button.setIcon(new ImageIcon(this.getClass().getResource("/icons/restaurant-table-64.png")));
				button.setText(client.getName());
				button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
				button.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
				button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
				button.setBackground(Color.GREEN);

				button.addActionListener(this);

				this.panelCenter.add(button);			
				this.buttons.put(button, client);
			});
			
			this.refresh();
		} 
		catch (IOException | ClassNotFoundException ex) {
			Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
		} 
	}
	
	private void close() {
		if(!invoices.isEmpty()){
			int choice = JOptionPane.showOptionDialog(
				this, 
				"Faturat e hapura do te humbasin.\nE konfirmoni daljen?", 
				"Kujdes!", JOptionPane.WARNING_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION,
				null, 
				new String[]{"PO","JO"},
				"JO"
			);
			if(choice != 0){
				return;
			}
		}
		if(SESSION.exists())
			SESSION.delete();
		
		System.exit(0);
	}
	
	
	
	
	
	
	
	
	
	
	private void refresh() {		
		this.buttons.entrySet().forEach(entry -> {
			JButton button = entry.getKey();
			Client client = entry.getValue();
			
			if(invoices.containsKey(client))
				button.setBackground(Color.RED);
			else
				button.setBackground(Color.GREEN);
		});		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if(source instanceof JButton) {			
			if(this.buttons.containsKey((JButton) source)) {
				Client client = this.buttons.get((JButton) source);
				
				if(!this.invoices.containsKey(client)) {
					Invoice invoice = new Invoice(
						LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss")), 
						Instant.now(), 
						employee, 
						client
					);
					
					this.invoices.put(client, invoice);
				}
				refresh();
				show(client);
			}
		}
	}
	
	private void show(Client client) {
		DialogInvoice dialog = new DialogInvoice(this) {
			@Override
			public void onCancel(Invoice invoice) {cancel(invoice.getTarget());}

			@Override
			public void onSubmit(Invoice invoice) {submit(invoice.getTarget());}

			@Override
			public Product getProduct(String code) {
				return products.stream().filter((Product t) -> {
					return Objects.equals(t.getCode(), code);
				}).findFirst().orElse(null);
				
				
			}
		};
		dialog.setInvoice(invoices.get(client));
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
	}
	
	private void cancel(Client client) {
		invoices.remove(client);
		refresh();
	}
	
	private void submit(Client client) {
		Invoice invoice = this.invoices.get(client);
		if(invoice != null) {
			invoice.setInstant(Instant.now());
			boolean success = Invoice.add(invoice);
			if(!success){ 
				JOptionPane.showMessageDialog(this, "Gabim gjate ruajtjes se fatures!", "Gabim", JOptionPane.ERROR_MESSAGE);
				return;
			}
			size += 1;
			value += invoice.getGrossValue();
		}
		cancel(client);		
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          wrapLayout1 = new com.redis.stock.pos.bar.WrapLayout();
          panelCenter = new javax.swing.JPanel();
          panelFooter = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          toolBar = new javax.swing.JToolBar();
          jButton1 = new javax.swing.JButton();
          filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
          jLabel3 = new javax.swing.JLabel();
          filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
          jLabel2 = new javax.swing.JLabel();

          wrapLayout1.setAlignment(java.awt.FlowLayout.LEFT);
          wrapLayout1.setHgap(25);
          wrapLayout1.setVgap(25);

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("REDIS STOCK - PORTALI I SHITJEVE");
          setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
          setMinimumSize(new java.awt.Dimension(400, 225));
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowClosing(java.awt.event.WindowEvent evt) {
                    formWindowClosing(evt);
               }
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });
          getContentPane().setLayout(new java.awt.BorderLayout(5, 5));
          getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);
          this.panelCenter.setLayout(this.wrapLayout1);

          jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
          jLabel1.setText("<html>\n\t<body>\n\t\t<p align=\"center\" >\n\t\t\t<b>2018 (C) Redjan Shabani</b><br/>\n\t\t\tL. Pavaresia, Rr. Kosova, Skele, Vlore (AL)<br/>\n\t\t\t<a href=\"mailto:redjan.shabani@gmail.com\">redjan.shabani@gmail.com</a> | <a href=\"mailto:redishabani@live.com\">redishabani@live.com</a><br/>\n\t\t\t+355 69 20 48 755<br/>\n\t\t</p>\n\t</body>\n</html>");
          panelFooter.add(jLabel1);

          getContentPane().add(panelFooter, java.awt.BorderLayout.PAGE_END);

          toolBar.setFloatable(false);
          toolBar.setRollover(true);

          jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout-16.png"))); // NOI18N
          jButton1.setFocusable(false);
          jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          toolBar.add(jButton1);
          toolBar.add(filler1);

          jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
          jLabel3.setForeground(java.awt.Color.red);
          jLabel3.setText("Data");
          toolBar.add(jLabel3);
          toolBar.add(filler2);

          jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
          jLabel2.setForeground(java.awt.Color.red);
          jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
          jLabel2.setText("Ora");
          toolBar.add(jLabel2);

          getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);
          EventQueue.invokeLater(() -> {
               ActionListener actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                         jLabel2.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                         jLabel3.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                    }
               };
               Timer timer = new Timer(1000, actionListener);
               timer.start();
          });

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          this.close();
     }//GEN-LAST:event_jButton1ActionPerformed

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

		if(SESSION.exists()){
			this.resume();
		}
		else{
			DialogLogin dialog = new DialogLogin(this) {
				@Override
				public void onLoginSuccess(String code) {
					FrameMain.this.start(code);
					this.dispose();
				}
			};
			dialog.setLocationRelativeTo(this);
			dialog.setVisible(true);
		}
		
		
		
		
		
     }//GEN-LAST:event_formWindowOpened

     private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
          this.pause();
     }//GEN-LAST:event_formWindowClosing
	
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.Box.Filler filler1;
     private javax.swing.Box.Filler filler2;
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JPanel panelCenter;
     private javax.swing.JPanel panelFooter;
     private javax.swing.JToolBar toolBar;
     private com.redis.stock.pos.bar.WrapLayout wrapLayout1;
     // End of variables declaration//GEN-END:variables

	
}
