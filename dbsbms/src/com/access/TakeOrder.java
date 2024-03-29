/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.access;

import com.dbutil.CrudOperation;

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ABHISHEK MAURYA
 */
public class TakeOrder extends javax.swing.JFrame {
    
    Connection con=null;
    PreparedStatement ps, pscombo1,psqn, pscombo2, pscombo3,pscombo4,psbg, pscombo5=null;
    ResultSet rscombo1,rscombo2,rsqn, rscombo3, rscombo4,rs,rscombo5=null;
    int pr=0;
    double totprice=0;
    
    public static String bid,cusnam,salnam;
    public static double toamo;

    /**
     * Creates new form TakeOrder
     */
    public TakeOrder() {
        initComponents();
        
        con=CrudOperation.createConnection();
         setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        GenereateBillID();
        fillCombocid();
        cmbcid.setSelectedIndex(AddCustomer.getIndex());
        fillComboctid();
        
        
    }
    
     public void fillCombocid()
    {
        String strsql="select phno from customer";
        
        try{
            
            pscombo1=con.prepareStatement(strsql);
            rscombo1=pscombo1.executeQuery();
            
            while(rscombo1.next())
            {
                String data =rscombo1.getString("phno");
                cmbcid.addItem(data);
            }
            
            
        }
        
        catch(SQLException se)
        {
            System.out.println(se);
        }
    }
    private void GenereateBillID()
    {
       
        String a= (String)ExsltDatetime.dateTime().substring(0, 4);
        String b= (String)ExsltDatetime.dateTime().substring(5, 7);
        String c= (String)ExsltDatetime.dateTime().substring(8, 10);
        String d= (String)ExsltDatetime.dateTime().substring(10, 13);
        String e= (String)ExsltDatetime.dateTime().substring(14, 16);
        String f= (String)ExsltDatetime.dateTime().substring(17, 19);
        String billid = a+b+c+d+e+f;
        
        //String billid= (String)ExsltDatetime.dateTime().substring(0, 19);
        lblbillid.setText(billid);
        String da= (String)ExsltDatetime.dateTime().substring(0, 10);
        lbldate.setText(da);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblbillid = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbcid = new javax.swing.JComboBox();
        cmbpid = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbqtn = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        lblprice = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lbldate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblcname = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblpname = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbltotpr = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbctid = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Take Order");

        jButton1.setText("Generate New Bill ID");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Product ID");

        jLabel3.setText("Customer ID");

        cmbcid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Customer ID" }));
        cmbcid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcidActionPerformed(evt);
            }
        });

        cmbpid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Product ID" }));
        cmbpid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbpidActionPerformed(evt);
            }
        });

        jLabel5.setText("Quantity");

        cmbqtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbqtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Price");

        jButton2.setText("Add Item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Customer Name");

        jLabel1.setText("Product Name");

        jButton3.setText("Generate Bill");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Total Billed Amount");

        jLabel9.setText("Date:");

        jLabel10.setText("Bill ID  :");

        jLabel4.setText("Category ID");

        cmbctid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Category ID" }));
        cmbctid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbctidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbcid, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbltotpr, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cmbqtn, javax.swing.GroupLayout.Alignment.LEADING, 0, 126, Short.MAX_VALUE)
                                                .addComponent(lblprice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(lblcname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(cmbctid, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(97, 97, 97)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblpname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbpid, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblbillid, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblbillid, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbcid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcname, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbctid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblpname, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbqtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblprice, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltotpr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, lblbillid});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        TakeOrder to = new TakeOrder();
        to.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbcidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcidActionPerformed
        // TODO add your handling code here:
        
        String phno=(String)cmbcid.getSelectedItem();
        String strsql="select name from customer where phno=?";
       
        try{
            
            pscombo2=con.prepareStatement(strsql);
            pscombo2.setString(1, phno);
            rscombo2=pscombo2.executeQuery();
            rscombo2.next();
            String name=rscombo2.getString("name");
            
           
            lblcname.setText(name);
            cusnam=name;
            
            
            
           
            
        }
        catch(SQLException se)
        {
            System.out.println(se);
        }
               

        
    }//GEN-LAST:event_cmbcidActionPerformed

    private void cmbpidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpidActionPerformed
        // TODO add your handling code here:
        String pid = (String)cmbpid.getSelectedItem();
        String strsql="select * from products where pid = ?";
        
        try{
            
            pscombo4=con.prepareStatement(strsql);
            pscombo4.setString(1, pid);
            rscombo4=pscombo4.executeQuery();
            
            rscombo4.next();
            
                int data =rscombo4.getInt("quantity");
                for(int i=1; i<=data; i++)
                {
                cmbqtn.addItem(i);
                }
            String price = rscombo4.getString("price");
            String pname = rscombo4.getString("name");
            pr=rscombo4.getInt("price");
            
            lblprice.setText(price);
            lblpname.setText(pname);
        }
        
        catch(SQLException se)
        {
            System.out.println(se);
        }
        
    }//GEN-LAST:event_cmbpidActionPerformed

    private void cmbqtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbqtnActionPerformed
        // TODO add your handling code here:
        int q = (int) cmbqtn.getSelectedItem();
        int am= pr*q;
        
        String amo = String.valueOf(am);
        lblprice.setText(amo);
        
    }//GEN-LAST:event_cmbqtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         String strinsert;
        String billid=lblbillid.getText();
        String pid=(String)cmbpid.getSelectedItem();
        int quantity=(int) cmbqtn.getSelectedItem();
        String price=lblprice.getText();
        double tot = Double.parseDouble(lblprice.getText());
        totprice= totprice + tot;
        lbltotpr.setText(Double.toString(totprice));
        String quan = String.valueOf(quantity);
        
        
        
        if(checkEmpty(pid,price))
        {
            JOptionPane.showMessageDialog (this, "You have left one or more Fields BLANK", "ALERT!!!", JOptionPane.INFORMATION_MESSAGE);
        }
       
        else
        {
            strinsert = "insert into placeorder values(?,?,?,?)";
            String strqtnup= "update products set quantity=quantity-? where pid=?";
        
        
        try
        {
            ps=con.prepareStatement(strinsert);
            ps.setString(1, billid);
            ps.setString(2, pid);
            ps.setString(3, quan);
            ps.setString(4, price);
       
            int row= ps.executeUpdate();
            
            psqn=con.prepareStatement(strqtnup);
            psqn.setInt(1, quantity);
            psqn.setString(2, pid);
            psqn.executeUpdate();
            fillCombopid();
            
            if(row>0)
            {
                JOptionPane.showMessageDialog(this, " Item has been added successfully");
            }
            else {
                
                JOptionPane.showMessageDialog(this, " Item not added ");
            }
            
          
            
        }
        catch( SQLException ad)
        {   
            System.out.println(ad);
            
        }    
        
        }
        
        cmbpid.removeAllItems();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String strinsert;
        String custid=(String)cmbcid.getSelectedItem();
       
        String dt = lbldate.getText();
        String billid=lblbillid.getText();
        bid=billid;
        toamo=totprice;
        String totpr = Double.toString(totprice);
       
        if(checkEmpty2(custid,totpr,dt,billid))
        {
            JOptionPane.showMessageDialog (this, "You have left one or more Fields BLANK", "ALERT!!!", JOptionPane.INFORMATION_MESSAGE);
        }
       
        else
        {
            strinsert = "insert into transaction values(?,?,?,?)";
            
        
        
        try
        {
            psbg=con.prepareStatement(strinsert);
            psbg.setString(1, custid);
           
            psbg.setString(2, totpr);
            psbg.setString(3, dt);
            psbg.setString(4, billid);
            
            
            
            int row= psbg.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(this, " Bill Generated Successfully!!!");
            }
            else {
                
                JOptionPane.showMessageDialog(this, " Bill not Generated!!!");
            }
            
          
            
        }
        catch( SQLException ad)
        {   
            System.out.println(ad);
            
        }    
        
        }
        
        BillGeneration bg= new BillGeneration();
        bg.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cmbctidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbctidActionPerformed
        // TODO add your handling code here:
        cmbpid.removeAllItems();
        fillCombopid();
    }//GEN-LAST:event_cmbctidActionPerformed

    
    public void fillComboctid()
    {
        String strsql="select DISTINCT cid from products";
        
        try{
            
            pscombo5=con.prepareStatement(strsql);
            rscombo5=pscombo5.executeQuery();
            
            while(rscombo5.next())
            {
                String data =rscombo5.getString("cid");
                cmbctid.addItem(data);
            }
            
            
        }
        
        catch(SQLException se)
        {
            System.out.println(se);
        }
        
    }
    
    public void fillCombopid()
    {
        String strsql="select pid from products where cid = ?";
        String ctid=(String) cmbctid.getSelectedItem();
        
       
        try{
            
            pscombo3=con.prepareStatement(strsql);
            pscombo3.setString(1, ctid);
            rscombo3=pscombo3.executeQuery();
            
            while(rscombo3.next())
            {
                String data =rscombo3.getString("pid");
                cmbpid.addItem(data);
            }
            
            
        }
        
        catch(SQLException se)
        {
            System.out.println(se);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbcid;
    private javax.swing.JComboBox cmbctid;
    private javax.swing.JComboBox cmbpid;
    private javax.swing.JComboBox cmbqtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblbillid;
    private javax.swing.JLabel lblcname;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblpname;
    private javax.swing.JLabel lblprice;
    private javax.swing.JLabel lbltotpr;
    // End of variables declaration//GEN-END:variables

    private boolean checkEmpty(String pid,  String price) {
        
         if(pid.isEmpty() || price.isEmpty())
        {
            return true;
        }
        else
        {
        return false;
        }
    }
    
  public  boolean isNumeric(String str)  
{  
  try  
  {  
    double d = Double.parseDouble(str);  
  }  
  catch(NumberFormatException nfe)  
  {  
    JOptionPane.showMessageDialog(this, "Token ID Should be an Integer");
    return true;  
  }  
  return false;  
}

    private boolean checkEmpty2(String custid,String totpr, String dt, String billid) {
            if(custid.isEmpty() || totpr.isEmpty() || dt.isEmpty() || billid.isEmpty())
            {
                return true;
            }
            else
            {
                return false;
            }
    }
    
    public static String Billid()
    {
        return bid;
    }
    
    public static double TotalAmount()
    {
        return toamo;
    }
    
    public static String CustName()
    {
        
        return cusnam;
    }
    
}
