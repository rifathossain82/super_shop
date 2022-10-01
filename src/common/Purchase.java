/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
        
public class Purchase extends javax.swing.JFrame {

Connection con=null;
Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    int r=0;
    public Purchase() {
        initComponents();
        autoname();
        JTextFieldDateEditor tt=(JTextFieldDateEditor)jdate.getDateEditor();
        tt.setEditable(false);
    }
    void config(){
    try {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/super_shop", "root", "");
        
    } catch (SQLException ex) {
        
    }
}
  void autoname(){
    try {autoSupname();
        a1.setText(""+autobill());
        Date d=new Date();
        jdate.setDate(d);
        config();
        String ss="SELECT * FROM `super_shop`.`product2`";
        ps=con.prepareStatement(ss);
        rs=ps.executeQuery();
        jComboBox2.setSelectedIndex(0);
        int itemCount = jComboBox2.getItemCount();

        for(int i=itemCount;i!=1;){i--;
        jComboBox2.removeItemAt(i);
     }
        while(rs.next()){
            jComboBox2.addItem(rs.getString(2));
        }
    } catch (SQLException ex) {
        Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    void autoSupname(){
    try {
        config();
        String ss="SELECT * FROM `super_shop`.`suplier`";
        ps=con.prepareStatement(ss);
        rs=ps.executeQuery();
        jComboBox1.setSelectedIndex(0);
        int itemCount = jComboBox1.getItemCount();

        for(int i=itemCount;i!=1;){i--;
        jComboBox1.removeItemAt(i);
     }
        while(rs.next()){
            jComboBox1.addItem(rs.getString(2));
        }
    } catch (SQLException ex) {
        Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
  int autobill(){int t=0;
    try {r=0;
        config();
        String ss="SELECT * FROM `super_shop`.`showpurchase`";
        ps=con.prepareStatement(ss);
        rs=ps.executeQuery();
        while(rs.next()){
            t=rs.getInt(2);
        }
        t++;
    } catch (SQLException ex) {
        Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
    }
    return t;
    }
  void clsome(){
      jComboBox2.setSelectedIndex(0);
    a2.setText("");
    a3.setText("");
    a4.setText("");
  }
void cldata(){
    b.setText("");
    jComboBox1.setSelectedIndex(0);
    jComboBox2.setSelectedIndex(0);
    a2.setText("");
    a3.setText("");
    a4.setText("");
    bill.setText("");
    date.setText("");
    sname.setText("");
    total.setText("");
    q1.setText("");
    q2.setText("");
    q3.setText("");
    DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
    dt.setRowCount(0);
    autoname();
}
void showtest(String m){
    try {DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
    dt.setRowCount(0);
        config(); 
        String ty="SELECT * FROM `super_shop`.`purchase` WHERE `Bill NO.`=?";
        ps=con.prepareStatement(ty);
        ps.setString(1, m);
         rs=ps.executeQuery();
         int t=0,w=0,k=0,t1=0,t2,t3=0;
        while(rs.next()){k++;
         t=rs.getInt(5)*rs.getInt(6);
         w=w+t;
         bill.setText(rs.getString(1));
          date.setText(rs.getString(2));
          sname.setText(rs.getString(3));
           bill.setText(rs.getString(1));
         dt.addRow(new Object[]{k,rs.getString(4),rs.getString(5),rs.getString(6),t,rs.getString(7)});
        }
        total.setText(""+w);
        if(q1.getText().isEmpty()){
           q1.setText(""+t1);
        }
        else{
            t1=Integer.parseInt(q1.getText());
          }
        t2=w-t1;
        q2.setText(""+t2);
        q3.setText(""+t3);
    } catch (SQLException ex) {
        Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
    }
}
void printmemo(final JPanel jp){
    PrinterJob printerjob=PrinterJob.getPrinterJob();
    printerjob.setJobName("Print memo");
    printerjob.setPrintable(new Printable() {
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
          if(pageIndex>0){
              return Printable.NO_SUCH_PAGE;
          }
            Graphics2D gp=(Graphics2D)graphics;
            gp.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
            gp.scale(0.8,0.8);
            jp.paint(gp);
            return Printable.PAGE_EXISTS;
        }
    });
    boolean br=printerjob.printDialog();
    if(br){
        try {
            printerjob.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        a1 = new javax.swing.JTextField();
        a4 = new javax.swing.JTextField();
        a2 = new javax.swing.JTextField();
        a3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        b = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bill = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sname1 = new javax.swing.JLabel();
        sname = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        q3 = new javax.swing.JTextField();
        q1 = new javax.swing.JTextField();
        q2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jdate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Purchase Data");
        setBackground(new java.awt.Color(51, 0, 255));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Suplier name   :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 200, 130, 50);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bill no.             :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 100, 130, 50);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date                 :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 150, 130, 50);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Details              :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 400, 130, 50);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Product name  :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 250, 130, 50);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Price                 :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 300, 130, 50);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantity          :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 350, 130, 50);

        a1.setEditable(false);
        getContentPane().add(a1);
        a1.setBounds(150, 100, 320, 50);

        a4.setEditable(false);
        getContentPane().add(a4);
        a4.setBounds(150, 400, 320, 50);

        a2.setEditable(false);
        getContentPane().add(a2);
        a2.setBounds(150, 300, 320, 50);

        a3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                a3KeyTyped(evt);
            }
        });
        getContentPane().add(a3);
        a3.setBounds(150, 350, 320, 50);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(150, 200, 320, 50);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(150, 250, 320, 50);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 580, 140, 40);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 540, 140, 40);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(150, 540, 140, 40);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(280, 490, 100, 40);

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(80, 580, 140, 40);

        b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bKeyPressed(evt);
            }
        });
        getContentPane().add(b);
        b.setBounds(10, 489, 270, 40);

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(290, 540, 140, 40);

        jPanel2.setBackground(new java.awt.Color(51, 0, 153));
        jPanel2.setLayout(null);

        bill.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bill.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(bill);
        bill.setBounds(120, 30, 120, 50);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bill no. :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(50, 30, 70, 50);

        sname1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sname1.setForeground(new java.awt.Color(255, 255, 255));
        sname1.setText("Suplier  :");
        jPanel2.add(sname1);
        sname1.setBounds(50, 70, 80, 50);

        sname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(sname);
        sname.setBounds(130, 70, 210, 50);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Date :");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(450, 70, 50, 50);

        date.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(date);
        date.setBounds(500, 70, 160, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sl", "Product name", "Price", "Quantity", "Total", "Details"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(40, 130, 630, 310);

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setText("Purchase");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(200, 500, 140, 40);

        total.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.add(total);
        total.setBounds(460, 440, 180, 40);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Due");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(380, 560, 80, 40);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Paid");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(380, 520, 80, 40);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Discount");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(380, 480, 80, 40);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Amount");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(380, 440, 80, 40);

        q3.setEditable(false);
        jPanel2.add(q3);
        q3.setBounds(460, 560, 180, 40);

        q1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                q1MouseClicked(evt);
            }
        });
        q1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q1KeyPressed(evt);
            }
        });
        jPanel2.add(q1);
        q1.setBounds(460, 480, 180, 40);

        q2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q2KeyPressed(evt);
            }
        });
        jPanel2.add(q2);
        q2.setBounds(460, 520, 180, 40);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(10, 20, 30, 600);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(500, 80, 700, 650);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(null);

        jLabel9.setBackground(new java.awt.Color(255, 0, 102));
        jLabel9.setFont(new java.awt.Font("Georgia", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Purchase Data");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 0, 1200, 80);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1200, 80);

        jPanel3.setBackground(new java.awt.Color(51, 0, 153));
        jPanel3.setLayout(null);
        jPanel3.add(jdate);
        jdate.setBounds(150, 70, 320, 50);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 80, 500, 650);

        setSize(new java.awt.Dimension(1215, 760));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO exit
        int i=JOptionPane.showConfirmDialog(this, "Are you want to exit?","Confirm message",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            dispose();
        }
        else{
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO clear
        cldata();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
     try {
         String e=jComboBox2.getSelectedItem().toString();
        config();
        String ss="SELECT * FROM `super_shop`.`product2` WHERE `Product Name`=? ";
        ps=con.prepareStatement(ss);
        ps.setString(1, e);
        rs=ps.executeQuery();
        while(rs.next()){
            a2.setText(""+rs.getString(3));
            a4.setText(""+rs.getString(4));
            a3.requestFocus();
        }
    } catch (SQLException ex) {
        Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    private void a3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_a3KeyTyped
       char ch=evt.getKeyChar();
       if(!(Character.isDigit(ch)) || ch==KeyEvent.VK_ENTER || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE){
           evt.consume();
       }
    }//GEN-LAST:event_a3KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    //add
        try {
        SimpleDateFormat rr=new SimpleDateFormat("yyy-MM-dd");
        DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
        config();
        String bi=a1.getText();
        String da=rr.format(jdate.getDate());
        String suname=jComboBox1.getSelectedItem().toString();
        String pname=jComboBox2.getSelectedItem().toString();
        String price=a2.getText();
        String qua=a3.getText();
        String det=a4.getText();
        String ss="INSERT INTO  `super_shop`.`purchase` VALUES (?,?,?,?,?,?,?)";
        ps=con.prepareStatement(ss);
        ps.setString(1, bi);
        ps.setString(2, da);
        ps.setString(3, suname);
        ps.setString(4, pname);
        ps.setString(5, price);
        ps.setString(6, qua);
        ps.setString(7, det);
        int y=ps.executeUpdate();
        if(y>0){
           JOptionPane.showMessageDialog(this, "Data add success");
            showtest(bi);
            clsome();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data add failed");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO update
        int i=JOptionPane.showConfirmDialog(this, "Do you want to update?","Confirm message",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.NO_OPTION){
            
        }
        else{
          try {
        SimpleDateFormat rr=new SimpleDateFormat("yyy-MM-dd");
        DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
        config();
        String bi=a1.getText();
        String da=rr.format(jdate.getDate());
        String suname=jComboBox1.getSelectedItem().toString();
        String pname=jComboBox2.getSelectedItem().toString();
        String price=a2.getText();
        String qua=a3.getText();
        String det=a4.getText();
        String ss="UPDATE `super_shop`.`purchase` SET `Bill NO.` =?, `Date` = ?, `Suplier Name` =?, `Product Name` =?, `Product Price` = ?, `Product Quantity` =?, `Product Details` =? WHERE `Bill NO.` = ? AND `Product Name` = ? ";
        ps=con.prepareStatement(ss);
        ps.setString(1, bi);
        ps.setString(2, da);
        ps.setString(3, suname);
        ps.setString(4, pname);
        ps.setString(5, price);
        ps.setString(6, qua);
        ps.setString(7, det);
        String f=""+dt.getValueAt(jTable1.getSelectedRow(), 1);
        ps.setString(8, bill.getText());
        ps.setString(9, f);
        int y=ps.executeUpdate();
        if(y>0){
           JOptionPane.showMessageDialog(this, "Data update success");
            showtest(bi);
            clsome();
        }else{
             JOptionPane.showMessageDialog(this, "Data update failed");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
    }}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        showtest(b.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO delete
        int i=JOptionPane.showConfirmDialog(this, "Do you want to delete?","Confirm message",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.NO_OPTION){
            
        }
        else{
        try {
        DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
        config();
        String bi=a1.getText();
        String ss=" DELETE FROM `super_shop`.`purchase` WHERE `Bill NO.` = ? AND `Product Name` = ? ";
        ps=con.prepareStatement(ss);
        String f=""+dt.getValueAt(jTable1.getSelectedRow(), 1);
        ps.setString(1, bill.getText());
        ps.setString(2, f);
        int y=ps.executeUpdate();
        if(y>0){
           JOptionPane.showMessageDialog(this, "Data delete success");
            showtest(bi);
            clsome();
        }else{
             JOptionPane.showMessageDialog(this, "Data delete failed");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
    }}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void bKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           if(b.getText().isEmpty()){
               JOptionPane.showMessageDialog(this, "Bill no. is empty!!");
               b.requestFocus();
           }
           else{
               showtest(b.getText());
           }
       }
    }//GEN-LAST:event_bKeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            config();
            String ss="SELECT * FROM `super_shop`.`showpurchase` WHERE `Bill no.`=? AND `Amount`=?";
            ps=con.prepareStatement(ss);
            ps.setString(1, bill.getText());
            ps.setString(2, total.getText());
            rs=ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Memo already created");
            }
            else{
                try {
                    String ee="INSERT INTO `super_shop`.`showpurchase` (`Bill no.`,`Date`,`Suplier Name`,`Amount`,`Discount`,`Paid`,`Due`) VALUES(?,?,?,?,?,?,?)";
                    ps=con.prepareStatement(ee);
                    ps.setString(1, bill.getText());
                    ps.setString(2, date.getText());
                    ps.setString(3, sname.getText());
                    ps.setString(4, total.getText());
                    ps.setString(5, q1.getText());
                    ps.setString(6, q2.getText());
                    ps.setString(7, q3.getText());
                    int p=ps.executeUpdate();
                    if(p>0){
                        JOptionPane.showMessageDialog(this, "Memo add success");
                        printmemo(jPanel2);
                        cldata();
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Memo add failed");
                    }

                } catch (SQLException ex) {

                }}
            } catch (Exception ex) {
            }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
            SimpleDateFormat st=new SimpleDateFormat("yyy-MM-dd");
            a1.setText(bill.getText());
            jdate.setDate(st.parse(date.getText()));
            jComboBox1.setSelectedItem(sname.getText());
            jComboBox2.setSelectedItem(""+dt.getValueAt(jTable1.getSelectedRow(), 1));
            a2.setText(""+dt.getValueAt(jTable1.getSelectedRow(), 2));
            a3.setText(""+dt.getValueAt(jTable1.getSelectedRow(), 3));
            a4.setText(""+dt.getValueAt(jTable1.getSelectedRow(), 5));
        } catch (ParseException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void q1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_q1MouseClicked
        q1.setText("");
    }//GEN-LAST:event_q1MouseClicked

    private void q1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q1KeyPressed
      if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(q1.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Set discount");
                q1.requestFocus();
            }
            else{
                int i=Integer.parseInt(total.getText());
                int o=Integer.parseInt(q1.getText());
                i=i-o;
                q2.setText(""+i);
                q2.requestFocus();
            }
        }
    }//GEN-LAST:event_q1KeyPressed

    private void q2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(q2.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Set paid balance");
                q2.requestFocus();
            }
            else{
                int i=Integer.parseInt(total.getText());
                int o=Integer.parseInt(q1.getText());
                int u=Integer.parseInt(q2.getText());
                i=i-(o+u);
                q3.setText(""+i);
                q3.requestFocus();
            }
        }
    }//GEN-LAST:event_q2KeyPressed

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
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a1;
    private javax.swing.JTextField a2;
    private javax.swing.JTextField a3;
    private javax.swing.JTextField a4;
    private javax.swing.JTextField b;
    private javax.swing.JLabel bill;
    private javax.swing.JLabel date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdate;
    private javax.swing.JTextField q1;
    private javax.swing.JTextField q2;
    private javax.swing.JTextField q3;
    private javax.swing.JLabel sname;
    private javax.swing.JLabel sname1;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
