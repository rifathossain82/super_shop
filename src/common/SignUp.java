/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author RH RIFAT
 */
public class SignUp extends javax.swing.JFrame {

 Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
 
 
 
    public SignUp() {
        initComponents();
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("supermarket.png")));
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
       b3.setToolTipText("Enter your email address");
       b4.setToolTipText("Enter your password");
       b1.setToolTipText("Enter your first name");
       b2.setToolTipText("Enter your last name");
       b5.setToolTipText("Enter your confirm password");
       b6.setToolTipText("Enter your phone no.");
       
       //getContentPane().setBackground(Color.orange);
      
        
    }
void cldata(){
    b1.setText("");
    b2.setText("");
    b3.setText("");
    b4.setText("");
    b5.setText("");
    b6.setText("");
    b1.requestFocus();
    
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        b6 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        b1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        b5 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        b2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        b4 = new javax.swing.JPasswordField();
        b3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sign up");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);
        getContentPane().setLayout(null);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(188, 250, 247));
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jCheckBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCheckBox1KeyPressed(evt);
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(650, 330, 20, 21);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Phone  no.");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(160, 420, 200, 40);

        b6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        b6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b6KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                b6KeyTyped(evt);
            }
        });
        getContentPane().add(b6);
        b6.setBounds(370, 420, 300, 40);

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Female");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jRadioButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(510, 370, 160, 40);

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Male");
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButton2KeyPressed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(370, 370, 130, 40);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Gender");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(160, 370, 200, 40);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("First Name");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(160, 120, 200, 40);

        b1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        b1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                b1KeyTyped(evt);
            }
        });
        getContentPane().add(b1);
        b1.setBounds(370, 120, 300, 40);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Back");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(450, 540, 120, 40);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirm Password");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(160, 320, 200, 40);

        b5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        b5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b5KeyPressed(evt);
            }
        });
        getContentPane().add(b5);
        b5.setBounds(370, 320, 300, 40);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Last Name");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(160, 170, 200, 40);

        b2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        b2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                b2KeyTyped(evt);
            }
        });
        getContentPane().add(b2);
        b2.setBounds(370, 170, 300, 40);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Sign up");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(230, 540, 110, 40);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Exit");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(570, 540, 110, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Clear");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(340, 540, 110, 40);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 204));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Vanilla-0.6s-286px.gif"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 10, 290, 60);

        b4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        b4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b4KeyPressed(evt);
            }
        });
        getContentPane().add(b4);
        b4.setBounds(370, 270, 300, 40);

        b3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        b3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b3KeyPressed(evt);
            }
        });
        getContentPane().add(b3);
        b3.setBounds(370, 220, 300, 40);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 220, 200, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 270, 200, 40);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 80, 360, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/common/t1-.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 730, 660);

        setSize(new java.awt.Dimension(727, 692));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     cldata();
    }//GEN-LAST:event_jButton2ActionPerformed
void config(){
     try {
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/super_shop", "root", "");
     } catch (SQLException ex) {
         Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
     }
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int i=JOptionPane.showConfirmDialog(this, "Are you want to exit?","Confirm message",JOptionPane.YES_NO_OPTION);
       if(i==JOptionPane.YES_OPTION){
           dispose();
       }
       else{
           b1.requestFocus();
       }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     
     if(b1.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "First name is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b1.requestFocus();
         }
     else if(b2.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Last name is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b2.requestFocus();
         }
     else if(b3.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Email is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b3.requestFocus();
         }
     else if(b4.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Password is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b4.requestFocus();
         }
     else if(b5.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Confirm password is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b5.requestFocus();
         }
     else if(b6.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Phone no. is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b6.requestFocus();
         }
     else if(!(jRadioButton1.isSelected() || jRadioButton2.isSelected())){
         JOptionPane.showMessageDialog(this, "Gender isn't selected","Error message",JOptionPane.ERROR_MESSAGE);
         
         }
     else{
         try {
         String first=b1.getText();
         String last=b2.getText();
         String email=b3.getText();
         String pass=b4.getText();
         String cpass=b5.getText();
         String gender;
         if(jRadioButton2.isSelected()){
             gender=jRadioButton2.getText();
         }
         else{
             gender=jRadioButton1.getText();
         }
         String phone=b6.getText();
         if(b1.getText().length()>20){
             JOptionPane.showMessageDialog(this, "First name isn't response.","Error message",JOptionPane.ERROR_MESSAGE);
             b1.setText("");
             b1.requestFocus();
         }
         else if(b2.getText().length()>20){
             JOptionPane.showMessageDialog(this, "Last name isn't response.","Error message",JOptionPane.ERROR_MESSAGE);
             b2.setText("");
             b2.requestFocus();
         }
         else if((b3.getText().length()>20) || (!b3.getText().contains("@gmail.com"))){
             JOptionPane.showMessageDialog(this, "Email isn't response.","Error message",JOptionPane.ERROR_MESSAGE);
             b3.setText("");
             b3.requestFocus();
         }
         else if(b4.getText().length()>15 || b4.getText().length()<6){
             JOptionPane.showMessageDialog(this, "Pasword must be 6-15 character","Error message",JOptionPane.ERROR_MESSAGE);
             b4.setText("");
             b4.requestFocus();
         }
         else if(b5.getText().length()>15 || b5.getText().length()<6){
             JOptionPane.showMessageDialog(this, "Pasword must be 6-15 character","Error message",JOptionPane.ERROR_MESSAGE);
             b5.setText("");
             b5.requestFocus();
         }
         else if(b6.getText().length()>20){
             JOptionPane.showMessageDialog(this, "Phone isn't response.","Error message",JOptionPane.ERROR_MESSAGE);
             b6.setText("");
             b6.requestFocus();
         }else{
         config();
         String tq=b3.getText();
         String s="SELECT `Email` FROM `login` WHERE `Email`=?";
         ps=con.prepareStatement(s);
         ps.setString(1, tq);
         rs=ps.executeQuery();
         if(!rs.next()){
         if(pass.compareTo(cpass)==0){
         config();
         String ee="INSERT INTO `super_shop`.`login`(`First Name`,`Last Name`,`Email`,`Password`,`Gender`,`Phone no.`) VALUES(?,?,?,?,?,?)";
         ps=con.prepareStatement(ee);
         ps.setString(1,first);
         ps.setString(2,last);
         ps.setString(3,email);
         ps.setString(4,pass);
         ps.setString(5,gender);
         ps.setString(6,phone);
         int i=ps.executeUpdate();
         if(i>0){
             JOptionPane.showMessageDialog(this, "Sign up success");
             cldata();
             dispose();
             Homepage h=new Homepage();
             h.setVisible(true);
         }
         else{
             JOptionPane.showMessageDialog(this, "Sign up failed","Error message",JOptionPane.ERROR_MESSAGE);
             
         }
         }
         
         else{
             JOptionPane.showMessageDialog(this, "Password is not matching","Error message",JOptionPane.ERROR_MESSAGE);
             b4.setText("");
             b5.setText("");
             b4.requestFocus();
         }}
         else{
              JOptionPane.showMessageDialog(this, "Email address isn't acceptable","Error message",JOptionPane.ERROR_MESSAGE);   
         b6.requestFocus();
         }
         }
     }
         catch (SQLException ex) {
         Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
     }}
       
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

    private void b3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b3KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(b3.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Email address is empty.","Warning message",JOptionPane.WARNING_MESSAGE);
                b3.requestFocus();
            }
            else{
                b4.requestFocus();
            }
        }
    }//GEN-LAST:event_b3KeyPressed

    private void b4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b4KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(b4.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Password is empty.","Warning message",JOptionPane.WARNING_MESSAGE);
                b4.requestFocus();
            }
            else{
                b5.requestFocus();
            }
        }
    }//GEN-LAST:event_b4KeyPressed

    private void b2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b2KeyPressed
      if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        if(b2.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"Last name is empty.","Warning message",JOptionPane.WARNING_MESSAGE);
           b2.requestFocus();
       }
       else{
           b3.requestFocus();
       }}
    }//GEN-LAST:event_b2KeyPressed

    private void b5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b5KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        if(b5.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"Confirm Password is empty.","Warning message",JOptionPane.WARNING_MESSAGE);
           b5.requestFocus();
       }
       else{
          jRadioButton2.requestFocus();
       }}
    }//GEN-LAST:event_b5KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       dispose();
        Login l=new Login();
       l.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void b1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b1KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           if(b1.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"First name is empty.","Warning message",JOptionPane.WARNING_MESSAGE);
           b1.requestFocus();
       }
       else{
           b2.requestFocus();
           
       }}
    }//GEN-LAST:event_b1KeyPressed

    private void b6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b6KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
       if(b1.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "First name is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b1.requestFocus();
         }
     else if(b2.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Last name is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b2.requestFocus();
         }
     else if(b3.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Email is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b3.requestFocus();
         }
     else if(b4.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Password is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b4.requestFocus();
         }
     else if(b5.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Confirm password is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b5.requestFocus();
         }
     else if(b6.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Phone no. is empty.","Error message",JOptionPane.ERROR_MESSAGE);
         b6.requestFocus();
         }
     else if(!(jRadioButton1.isSelected() || jRadioButton2.isSelected())){
         JOptionPane.showMessageDialog(this, "Gender isn't selected","Error message",JOptionPane.ERROR_MESSAGE);
         
         }
     else{
         try {
         String first=b1.getText();
         String last=b2.getText();
         String email=b3.getText();
         String pass=b4.getText();
         String cpass=b5.getText();
         String gender;
         if(jRadioButton2.isSelected()){
             gender=jRadioButton2.getText();
         }
         else{
             gender=jRadioButton1.getText();
         }
         String phone=b6.getText();
         if(b1.getText().length()>20){
             JOptionPane.showMessageDialog(this, "First name isn't response.","Error message",JOptionPane.ERROR_MESSAGE);
             b1.setText("");
             b1.requestFocus();
         }
         else if(b2.getText().length()>20){
             JOptionPane.showMessageDialog(this, "Last name isn't response.","Error message",JOptionPane.ERROR_MESSAGE);
             b2.setText("");
             b2.requestFocus();
         }
         else if((b3.getText().length()>20) || (!b3.getText().contains("@gmail.com"))){
             JOptionPane.showMessageDialog(this, "Email isn't response.","Error message",JOptionPane.ERROR_MESSAGE);
             b3.setText("");
             b3.requestFocus();
         }
         else if(b4.getText().length()>15 || b4.getText().length()<6){
             JOptionPane.showMessageDialog(this, "Pasword must be 6-15 character","Error message",JOptionPane.ERROR_MESSAGE);
             b4.setText("");
             b4.requestFocus();
         }
         else if(b5.getText().length()>15 || b5.getText().length()<6){
             JOptionPane.showMessageDialog(this, "Pasword must be 6-15 character","Error message",JOptionPane.ERROR_MESSAGE);
             b5.setText("");
             b5.requestFocus();
         }
         else if(b6.getText().length()>20){
             JOptionPane.showMessageDialog(this, "Phone isn't response.","Error message",JOptionPane.ERROR_MESSAGE);
             b6.setText("");
             b6.requestFocus();
         }else{
         config();
         String tq=b3.getText();
         String s="SELECT `Email` FROM `login` WHERE `Email`=?";
         ps=con.prepareStatement(s);
         ps.setString(1, tq);
         rs=ps.executeQuery();
         if(!rs.next()){
         if(pass.compareTo(cpass)==0){
         config();
         String ee="INSERT INTO `super_shop`.`login`(`First Name`,`Last Name`,`Email`,`Password`,`Gender`,`Phone no.`) VALUES(?,?,?,?,?,?)";
         ps=con.prepareStatement(ee);
         ps.setString(1,first);
         ps.setString(2,last);
         ps.setString(3,email);
         ps.setString(4,pass);
         ps.setString(5,gender);
         ps.setString(6,phone);
         int i=ps.executeUpdate();
         if(i>0){
             JOptionPane.showMessageDialog(this, "Sign up success");
             cldata();
             dispose();
             Homepage h=new Homepage();
             h.setVisible(true);
         }
         else{
             JOptionPane.showMessageDialog(this, "Sign up failed","Error message",JOptionPane.ERROR_MESSAGE);
             
         }
         }
         
         else{
             JOptionPane.showMessageDialog(this, "Password is not matching","Error message",JOptionPane.ERROR_MESSAGE);
             b4.setText("");
             b5.setText("");
             b4.requestFocus();
         }}
         else{
              JOptionPane.showMessageDialog(this, "Email address isn't acceptable","Error message",JOptionPane.ERROR_MESSAGE);   
         b6.requestFocus();
         }
         }
     }
         catch (SQLException ex) {
         Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
     }}
       }
    }//GEN-LAST:event_b6KeyPressed

    private void jRadioButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton1KeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        if(!(jRadioButton1.isSelected() || jRadioButton2.isSelected())){
           JOptionPane.showMessageDialog(this,"Gender isn't selected.","Warning message",JOptionPane.WARNING_MESSAGE);
           
       }
       else{
           b6.requestFocus();
       }}
    }//GEN-LAST:event_jRadioButton1KeyPressed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jRadioButton1.requestFocus();
        }
    }//GEN-LAST:event_jRadioButton2KeyPressed

    private void jCheckBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBox1KeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             jRadioButton2.requestFocus();
         }
    }//GEN-LAST:event_jCheckBox1KeyPressed

    private void b1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b1KeyTyped
       char ch=evt.getKeyChar();
       if((Character.isDigit(ch)) || ch==KeyEvent.VK_ENTER || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE){
           evt.consume();
           if(b1.getText().length()>20){
             
           }
       }
    }//GEN-LAST:event_b1KeyTyped

    private void b2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b2KeyTyped
       char ch=evt.getKeyChar();
       if((Character.isDigit(ch)) || ch==KeyEvent.VK_ENTER || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE){
           evt.consume();
       }
    }//GEN-LAST:event_b2KeyTyped

    private void b6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b6KeyTyped
       char ch=evt.getKeyChar();
       if(!(Character.isDigit(ch)) || ch==KeyEvent.VK_ENTER || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE){
           evt.consume();
       }
    }//GEN-LAST:event_b6KeyTyped

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
       
    }//GEN-LAST:event_b1ActionPerformed

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField b1;
    private javax.swing.JTextField b2;
    private javax.swing.JTextField b3;
    private javax.swing.JPasswordField b4;
    private javax.swing.JPasswordField b5;
    private javax.swing.JTextField b6;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
