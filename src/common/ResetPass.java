/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ResetPass extends javax.swing.JFrame {

 Connection con=null;
  Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public String cpass;
    public ResetPass() {
        initComponents();
    }
    void config(){
    try {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/super_shop", "root", "");
        
    } catch (SQLException ex) {
        
    }
}
    void resetpassword(String m,String n){
        try {
                config();
                String ss="UPDATE `super_shop`.`login` SET `Password` =? WHERE `Password`=?";
                ps=con.prepareStatement(ss);
                ps.setString(1, m);
                ps.setString(2,n);
                int i=ps.executeUpdate();
                if(i>0){
                    JOptionPane.showMessageDialog(this, "Reset password success");
                    b4.setText("");
                    b5.setText("");
                   dispose();
                   testPass tp=new testPass();
                    tp.setVisible(false);
                   
                }
                else{
                    JOptionPane.showMessageDialog(this, "Reset password failed","Error message",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
              JOptionPane.showMessageDialog(this,ex.getMessage());
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
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        b5 = new javax.swing.JPasswordField();
        b4 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Account Settings");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(null);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(188, 250, 247));
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(620, 200, 20, 21);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("New Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 140, 200, 40);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirm Password");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(130, 190, 200, 40);

        b5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        b5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b5KeyPressed(evt);
            }
        });
        jPanel1.add(b5);
        b5.setBounds(340, 190, 300, 40);

        b4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        b4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b4KeyPressed(evt);
            }
        });
        jPanel1.add(b4);
        b4.setBounds(340, 140, 300, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Exit");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(500, 330, 150, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Reset");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(150, 330, 150, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Clear");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(330, 330, 150, 40);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("...................................................................");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 30, 690, 50);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Change Your Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 20, 420, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 810, 440);

        setSize(new java.awt.Dimension(817, 475));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       b4.setText("");
       b5.setText("");
               
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
         b4.setEchoChar((char)0);
         b5.setEchoChar((char)0);
      }else{
          b4.setEchoChar('*');
          b5.setEchoChar('*');
      }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int i=JOptionPane.showConfirmDialog(this, "Are you want to exit?","Confirm message",JOptionPane.YES_NO_OPTION);
       if(i==JOptionPane.YES_OPTION){
           dispose();
       }
       else{
           b4.requestFocus();
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(b4.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "New password is empty!!","Error Message",JOptionPane.ERROR_MESSAGE);
            b4.requestFocus();
        }
        else if(b5.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Confirm password is empty!!","Error Message",JOptionPane.ERROR_MESSAGE);
            b5.requestFocus();
        }
        else{
            if(b4.getText().length()>15 || b4.getText().length()<6){
             JOptionPane.showMessageDialog(this, "Pasword must be 6-15 character","Error message",JOptionPane.ERROR_MESSAGE);
             b4.setText("");
             b4.requestFocus();
         }
         else if(b5.getText().length()>15 || b5.getText().length()<6){
             JOptionPane.showMessageDialog(this, "Pasword must be 6-15 character","Error message",JOptionPane.ERROR_MESSAGE);
             b5.setText("");
             b5.requestFocus();
         }
         else{ String pass1=b4.getText();
                String pass2=b5.getText();
                if(pass1.compareTo(pass2)==0){
            resetpassword(pass1,cpass);
        }
                else{
                    JOptionPane.showMessageDialog(this, "Password isn't matching","Error message",JOptionPane.ERROR_MESSAGE);
                b4.setText("");
                b5.setText("");
                b4.requestFocus();
                }
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void b4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b4KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           if(b4.getText().isEmpty()){
               JOptionPane.showMessageDialog(this, "New Password is empty.","Warning message",JOptionPane.WARNING_MESSAGE);
           b4.requestFocus();
       }
        else{
            b5.requestFocus();
        }
        }
    }//GEN-LAST:event_b4KeyPressed

    private void b5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b5KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           if(b5.getText().isEmpty()){
               JOptionPane.showMessageDialog(this, "Confirm Password is empty.","Warning message",JOptionPane.WARNING_MESSAGE);
           b5.requestFocus();
       }
           else{
        if(b4.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "New password is empty!!","Error Message",JOptionPane.ERROR_MESSAGE);
            b4.requestFocus();
        }
        else if(b5.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Confirm password is empty!!","Error Message",JOptionPane.ERROR_MESSAGE);
            b5.requestFocus();
        }
        else{String pass1=b4.getText();
                String pass2=b5.getText();
                if(pass1.compareTo(pass2)==0){
            resetpassword(pass1,cpass);
        }
                else{
                    JOptionPane.showMessageDialog(this, "Password isn't matching","Error message",JOptionPane.ERROR_MESSAGE);
                b4.setText("");
                b5.setText("");
                b4.requestFocus();
                }
        }}}
    }//GEN-LAST:event_b5KeyPressed

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
            java.util.logging.Logger.getLogger(ResetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField b4;
    private javax.swing.JPasswordField b5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
