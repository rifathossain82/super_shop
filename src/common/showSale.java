/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RH RIFAT
 */
public class showSale extends javax.swing.JFrame {
 Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public showSale() {
        initComponents();
        JTextFieldDateEditor jj=(JTextFieldDateEditor) date.getDateEditor();
        jj.setEditable(false);
    }
    void config(){
     try {
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/super_shop", "root", "");
     } catch (SQLException ex) {
         Logger.getLogger(showSale.class.getName()).log(Level.SEVERE, null, ex);
     }
}

    void showdata(String m){
     try {
         DefaultTableModel kp=(DefaultTableModel)jTable1.getModel();
         config();
         String kk="SELECT * FROM `super_shop`.`psalesdata` WHERE `Date`=?";
         ps=con.prepareStatement(kk);
         ps.setString(1, m);
         rs=ps.executeQuery();
         kp.setRowCount(0);
         int y=0,o=0,k=0,i=0,r=0;
         while(rs.next()){
             r++;
             y=rs.getInt(3)+y;
            o=rs.getInt(4)+o;
            k=rs.getInt(5)+k;
             kp.addRow(new Object[]{r,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
         }
         b1.setText(""+y);
         b2.setText(""+o);
         b3.setText(""+k);
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
}
void showdataall(){
     try {
         DefaultTableModel kp=(DefaultTableModel)jTable1.getModel();
         config();
         String kk="SELECT * FROM `super_shop`.`psalesdata`";
         ps=con.prepareStatement(kk);
         rs=ps.executeQuery();
         kp.setRowCount(0);
         int y=0,o=0,k=0,i=0,r=0;
         while(rs.next()){
             r++;
             y=rs.getInt(3)+y;
            o=rs.getInt(4)+o;
            k=rs.getInt(5)+k;
             kp.addRow(new Object[]{r,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
         }
         b1.setText(""+y);
         b2.setText(""+o);
         b3.setText(""+k);
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
}
void showtest(String m){
     try {
         DefaultTableModel kp=(DefaultTableModel)jTable1.getModel();
         config();
         String kk="SELECT * FROM `super_shop`.`psalesdata` WHERE `Paid Type`=?";
         ps=con.prepareStatement(kk);
         ps.setString(1, m);
         rs=ps.executeQuery();
         kp.setRowCount(0);
         int y=0,o=0,k=0,i=0,r=0;
         while(rs.next()){
             r++;
             y=rs.getInt(3)+y;
            o=rs.getInt(4)+o;
            k=rs.getInt(5)+k;
             kp.addRow(new Object[]{r,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
         }
         b1.setText(""+y);
         b2.setText(""+o);
         b3.setText(""+k);
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
}
void showtest22(){
     try {
         SimpleDateFormat dm=new SimpleDateFormat("yyy-MM-dd");
         DefaultTableModel kp=(DefaultTableModel)jTable1.getModel();
         config();
         String kk="SELECT * FROM `super_shop`.`psalesdata` WHERE `Paid Type`=? AND `Date`=?";
         ps=con.prepareStatement(kk);
         ps.setString(1, jComboBox2.getSelectedItem().toString());
         ps.setString(2, dm.format(date.getDate()));
         rs=ps.executeQuery();
         kp.setRowCount(0);
         int y=0,o=0,k=0,i=0,r=0;
         while(rs.next()){
             r++;
             y=rs.getInt(3)+y;
            o=rs.getInt(4)+o;
            k=rs.getInt(5)+k;
             kp.addRow(new Object[]{r,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
         }
         b1.setText(""+y);
         b2.setText(""+o);
         b3.setText(""+k);
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        b1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        b2 = new javax.swing.JTextField();
        b3 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ShowSale");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));
        jPanel1.setLayout(null);

        b1.setEditable(false);
        b1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(b1);
        b1.setBounds(380, 540, 130, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "sl no.", "Bill no.", "Date", "Amount", "Discount", "Paid", "Paid Type"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 190, 880, 340);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Sales List");
        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel17);
        jLabel17.setBounds(210, 10, 490, 60);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(280, 140, 110, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Exit");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(670, 140, 110, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Show All");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(410, 140, 110, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Clear");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(540, 140, 110, 40);

        b2.setEditable(false);
        b2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b2MouseClicked(evt);
            }
        });
        b2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                b2KeyTyped(evt);
            }
        });
        jPanel1.add(b2);
        b2.setBounds(510, 540, 130, 40);

        b3.setEditable(false);
        b3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(b3);
        b3.setBounds(640, 540, 130, 40);

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Date           :");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(10, 140, 100, 40);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Cash", "Debit Card", "Credit Card", "bkash", "Surecash" }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(120, 90, 140, 40);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Paid type   :");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(10, 90, 110, 40);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Total   :");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(jLabel21);
        jLabel21.setBounds(280, 540, 100, 40);
        jPanel1.add(date);
        date.setBounds(120, 140, 140, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 930, 600);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 51));
        jLabel19.setText("Amount     :");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(10, 430, 110, 40);

        setSize(new java.awt.Dimension(940, 637));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{SimpleDateFormat sm=new SimpleDateFormat("yyy-MM-dd");
        if(jComboBox2.getSelectedIndex()==0){
            //JOptionPane.showMessageDialog(this, "Input bill no. to search data","Warnning message",JOptionPane.WARNING_MESSAGE);
             showdata(sm.format(date.getDate()));
        }
        else if(date.getDate()==null){
           showtest(jComboBox2.getSelectedItem().toString());
        }
        else if ((jComboBox2.getSelectedIndex()==0) && (date.getDate()==null)){
           JOptionPane.showMessageDialog(this, "NO Responding");
        }
        else{
            showtest22();
        }}catch(Exception ex){
           JOptionPane.showMessageDialog(this, "NO Responding");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void b2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseClicked
        b2.setText("");
        b2.requestFocus();
    }//GEN-LAST:event_b2MouseClicked

    private void b2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b2KeyPressed
        
    }//GEN-LAST:event_b2KeyPressed

    private void b2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b2KeyTyped
       
    }//GEN-LAST:event_b2KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int i=JOptionPane.showConfirmDialog(this, "Are you want to exit?","Confirm message",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            dispose();
        }
        else{

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        showdataall();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
       dt.setRowCount(0);
       jComboBox2.setSelectedIndex(0);
       date.setDate(null);
       b1.setText("");
       b2.setText("");
       b3.setText("");
       
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(showSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new showSale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField b1;
    private javax.swing.JTextField b2;
    private javax.swing.JTextField b3;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
