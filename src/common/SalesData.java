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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
public class SalesData extends javax.swing.JFrame {

 Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    int sl;
    public SalesData() {
        initComponents();
        Cldata();
        JTextFieldDateEditor jj=(JTextFieldDateEditor) date.getDateEditor();
        jj.setEditable(false);
        
    }
    void config(){
     try {
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/super_shop", "root", "");
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
}
void Cldata(){
    a1.setText(""+autobill());
    Date d=new Date();
    date.setDate(d);
    a2.setText("");
    a3.setText("");
    a4.setText("");
    s.setText("");
    bi.setText("");
    da.setText("");
    DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
    dt.setRowCount(0);
    jComboBox2.setSelectedIndex(0);
    autoname();
    sl=0;
    b2.setText("0");
    b1.setText("0");
    b3.setText("0");
 }
void clsome(){
    a2.setText("");
    a3.setText("");
    a4.setText("");
    stock.setText("");
    jComboBox1.setSelectedIndex(0);
    jComboBox1.requestFocus();
}
void clsometest(){
    a1.setText(""+autobill());
    Date d=new Date();
    date.setDate(d);
    a2.setText("");
    a3.setText("");
    a4.setText("");
    jComboBox1.setSelectedIndex(0);
}
int autobill(){ int p=0;
     try {
         config();
        String rr="SELECT * FROM `super_shop`.`saledata`";
         ps=con.prepareStatement(rr);
         rs=ps.executeQuery();
         while(rs.next()){
             p=rs.getInt(2);
         }
         p++;
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(this, ex.getMessage());
     }
     return p;
}
void autoname(){ int p=0;
     try {jComboBox1.removeAll();
         config();
        String ss="SELECT * FROM `super_shop`.`Sales_product2`";
         ps=con.prepareStatement(ss);
         rs=ps.executeQuery();
         while(rs.next()){
             jComboBox1.addItem(rs.getString(2));
         }
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(this, ex.getMessage());
     }
}
void showdata(String m){
     try {
         DefaultTableModel kp=(DefaultTableModel)jTable1.getModel();
         config();
         String kk="SELECT * FROM `super_shop`.`saledata` WHERE `Bill no.`=?";
         ps=con.prepareStatement(kk);
         ps.setString(1, m);
         rs=ps.executeQuery();
         kp.setRowCount(0);
         int y=0,o=0,k=0;
         while(rs.next()){
             k++;
             bi.setText(rs.getString(2));
             da.setText(rs.getString(3));
             y=rs.getInt(5)*rs.getInt(6);
             o=o+y;
             kp.addRow(new Object[]{rs.getString(1),rs.getString(4),rs.getString(5),rs.getString(6),y,rs.getString(7)});
         }
         b1.setText(""+o);
         b3.setText(""+o);
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
}
int stock(String m){int t=0;
     try {
         config();
         String sp="SELECT SUM(`Product Quantity`) AS Total FROM `super_shop`.`purchase` WHERE `Product Name`=? GROUP BY `Product Name`";
         ps=con.prepareStatement(sp);
         ps.setString(1, m);
         rs=ps.executeQuery();
         if(rs.next()){
            t=rs.getInt(1);
         }
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(this, "Not Responding","Error message",JOptionPane.ERROR_MESSAGE);
     }
    return t;
}
int sakeqq(String m){int p=0;
     try {
         config();
         String sp="SELECT SUM(`Quantity`) AS Total FROM `super_shop`.`saledata` WHERE `Product name`=? GROUP BY `Product name`";
         ps=con.prepareStatement(sp);
         ps.setString(1, m);
         rs=ps.executeQuery();
         if(rs.next()){
            p=rs.getInt(1);
         }
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(this, "Not Responding","Error message",JOptionPane.ERROR_MESSAGE);
     }
    return p;
}
void showtest(String m){
     try {
         DefaultTableModel kp=(DefaultTableModel)jTable1.getModel();
         config();
         String kk="SELECT * FROM `super_shop`.`saledata` WHERE `Bill no.`=?";
         ps=con.prepareStatement(kk);
         ps.setString(1, m);
         rs=ps.executeQuery();
         kp.setRowCount(0);
         int y=0,o=0,k=0;
         while(rs.next()){
         sl=rs.getInt(1);
         }
         sl++;
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
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
            gp.scale(0.95, 1.2);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        a3 = new javax.swing.JTextField();
        a1 = new javax.swing.JTextField();
        a2 = new javax.swing.JTextField();
        s = new javax.swing.JTextField();
        date = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        a4 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        stock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        da = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bi = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        b2 = new javax.swing.JTextField();
        b3 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        ltime = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        b1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SalesData");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Details");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 400, 120, 50);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sales Data");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 10, 390, 60);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bill no.          ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 150, 120, 50);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 200, 120, 50);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Product Name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 250, 120, 50);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 300, 120, 50);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantity");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 350, 120, 50);

        a3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a3MouseClicked(evt);
            }
        });
        a3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                a3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                a3KeyTyped(evt);
            }
        });
        getContentPane().add(a3);
        a3.setBounds(150, 350, 280, 50);

        a1.setEditable(false);
        getContentPane().add(a1);
        a1.setBounds(150, 150, 280, 50);

        a2.setEditable(false);
        getContentPane().add(a2);
        a2.setBounds(150, 300, 280, 50);

        s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sMouseClicked(evt);
            }
        });
        s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sKeyTyped(evt);
            }
        });
        getContentPane().add(s);
        s.setBounds(50, 500, 280, 50);

        date.setDateFormatString("yyy-MM-dd");
        getContentPane().add(date);
        date.setBounds(150, 200, 280, 50);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(150, 250, 280, 50);

        jButton1.setText("Search");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 500, 140, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Add");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(50, 560, 140, 50);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Update");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(190, 560, 140, 50);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("Delete");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(330, 560, 140, 50);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("Clear");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(110, 610, 140, 50);

        a4.setEditable(false);
        getContentPane().add(a4);
        a4.setBounds(150, 400, 280, 50);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setText("Exit");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(250, 610, 140, 50);

        jPanel3.setBackground(new java.awt.Color(102, 153, 0));
        jPanel3.setLayout(null);

        stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockActionPerformed(evt);
            }
        });
        jPanel3.add(stock);
        stock.setBounds(430, 350, 70, 50);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Stock");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(430, 320, 70, 30);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 4));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Easy Brand Ltd.");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(150, 0, 350, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ajim Tower, 306 , Feni Sadar , Feni.");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(180, 20, 300, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Contact : 01885256993");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(260, 40, 130, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 650, 60);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sl no.", "Product Name", "Price", "Quantity", "Total", "Details"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 630, 340);

        da.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        da.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(da);
        da.setBounds(480, 70, 160, 40);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Bill no. :");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(20, 70, 67, 40);

        bi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bi.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(bi);
        bi.setBounds(90, 70, 130, 40);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Date :");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(420, 70, 60, 40);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Amount     :");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(10, 470, 110, 40);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Discount    :");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(10, 510, 110, 40);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText(" Paid          :");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(10, 550, 110, 40);

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Paid type   :");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(10, 590, 110, 40);

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
        b2.setBounds(120, 510, 200, 40);

        b3.setEditable(false);
        b3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(b3);
        b3.setBounds(120, 550, 200, 40);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Cash", "Debit Card", "Credit Card", "bkash", "Surecash" }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(120, 590, 200, 40);
        jPanel1.add(ltime);
        ltime.setBounds(450, 470, 190, 40);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setText("Sale");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(360, 590, 160, 40);

        b1.setEditable(false);
        b1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(b1);
        b1.setBounds(120, 470, 200, 40);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(520, 10, 650, 670);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1190, 690);

        setSize(new java.awt.Dimension(1190, 727));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int i=JOptionPane.showConfirmDialog(this, "Are you want to exit?","Confirm message",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            dispose();
        }
        else{

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Cldata();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     if(jComboBox1.getSelectedIndex()==0){
         JOptionPane.showMessageDialog(this, "Select Product","Error message",JOptionPane.ERROR_MESSAGE);
         jComboBox1.requestFocus();
     }
     else if(a3.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Quantity is Empty!!","Error message",JOptionPane.ERROR_MESSAGE);
         a3.requestFocus();
     }
     else{
        try {
         //add
         
         DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
         SimpleDateFormat sm=new SimpleDateFormat("yyy-MM-dd");
         String bill=a1.getText();
            showtest(bill);
         String jdate=((JTextFieldDateEditor)date.getDateEditor().getUiComponent()).getText();
         String pname=jComboBox1.getSelectedItem().toString();
         String price=a2.getText();
         String qua=a3.getText();
         int er=Integer.parseInt(a3.getText());
         int re=Integer.parseInt(stock.getText());
         if(er>re){
             JOptionPane.showMessageDialog(this, "Quantity cann't over from stock","Error message",JOptionPane.ERROR_MESSAGE);
             a3.setText("");
             a3.requestFocus();
         }else{
         String det=a4.getText();
         String slno=""+sl;
         config();
         String ii="INSERT INTO `super_shop`.`saledata` VALUES (?,?,?,?,?,?,?)";
         ps=con.prepareStatement(ii);
         ps.setString(1, slno);
         ps.setString(2, bill);
         ps.setString(3, jdate);
         ps.setString(4, pname);
         ps.setString(5, price);
         ps.setString(6, qua);
         ps.setString(7, det);
         int i=ps.executeUpdate();
         int x=0;
         if(i>0){
             JOptionPane.showMessageDialog(this, "Data add success");
             sl++;
             showdata(bill);
             clsome();
             
             
         }
         else{
             JOptionPane.showMessageDialog(this, "Data add failed");
         }
         }
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
        
     }  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
     try {
         config();
         String tt="SELECT * FROM `super_shop`.`Sales_product2` WHERE `Product Name`=?";
         ps=con.prepareStatement(tt);
         ps.setString(1, ""+jComboBox1.getSelectedItem());
         rs=ps.executeQuery();
         if(rs.next()){
             a2.setText(rs.getString(3));
             a4.setText(rs.getString(4));
             int x=stock(""+jComboBox1.getSelectedItem());
             int y=sakeqq(""+jComboBox1.getSelectedItem());
             int r=x-y;
             stock.setText(""+r);
             if(r<=50){
                 JOptionPane.showMessageDialog(this, "This product stocks are very low .","Warrning message",JOptionPane.WARNING_MESSAGE);
             }
             a3.requestFocus();
             
         }
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     try {
         DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
         SimpleDateFormat sm=new SimpleDateFormat("yyy-MM-dd");
         a1.setText(bi.getText());
         date.setDate(sm.parse(da.getText()));
         jComboBox1.setSelectedItem(dt.getValueAt(jTable1.getSelectedRow(), 1));
         a2.setText(""+dt.getValueAt(jTable1.getSelectedRow(), 2));
         a3.setText(""+dt.getValueAt(jTable1.getSelectedRow(), 3));
         a4.setText(""+dt.getValueAt(jTable1.getSelectedRow(), 5));
     } catch (ParseException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(s.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Input bill no. to search data","Warnning message",JOptionPane.WARNING_MESSAGE);
           s.requestFocus();
       }
       else{
           showdata(s.getText());
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int t=JOptionPane.showConfirmDialog(this, "Do you want to update?","Confirm message",JOptionPane.YES_NO_OPTION);
        if(t==JOptionPane.YES_OPTION){
        if(jComboBox1.getSelectedIndex()==0){
         JOptionPane.showMessageDialog(this, "Select Product","Error message",JOptionPane.ERROR_MESSAGE);
         jComboBox1.requestFocus();
     }
     else if(a3.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Quantity is Empty!!","Error message",JOptionPane.ERROR_MESSAGE);
         a3.requestFocus();
     }
     else{
        try {
         //update
         DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
         SimpleDateFormat sm=new SimpleDateFormat("yyy-MM-dd");
         String pname=jComboBox1.getSelectedItem().toString();
         String price=a2.getText();
         String qua=a3.getText();
         String det=a4.getText();
         config();
         String ii="UPDATE `super_shop`.`saledata` SET `Product Name` =?,`Price` =?,`Quantity` =?,`Details` =? WHERE `Sl no.` =? AND `Bill no.` =?";
         ps=con.prepareStatement(ii);
         ps.setString(1, pname);
         ps.setString(2, price);
         ps.setString(3, qua);
         ps.setString(4, det);
         ps.setString(5, ""+dt.getValueAt(jTable1.getSelectedRow(), 0));
         ps.setString(6, bi.getText());
         int i=ps.executeUpdate();
         int x=0;
         if(i>0){
             JOptionPane.showMessageDialog(this, "Data update success");
             showdata(bi.getText());
             clsometest();
             
         }
         else{
             JOptionPane.showMessageDialog(this, "Data update failed");
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
        
     }}
        else{
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int t=JOptionPane.showConfirmDialog(this, "Do you want to delete?","Confirm message",JOptionPane.YES_NO_OPTION);
        if(t==JOptionPane.YES_OPTION){
        if(jComboBox1.getSelectedIndex()==0 || a3.getText().isEmpty() || a2.getText().isEmpty() || a4.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Select data from table","Error message",JOptionPane.ERROR_MESSAGE);
     }
     else{
        try {
         //delete
         DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
         config();
         String ii="DELETE FROM `super_shop`.`saledata` WHERE `Sl no.` = ? AND `Bill no.` = ? ";
         ps=con.prepareStatement(ii);
         ps.setString(1, ""+dt.getValueAt(jTable1.getSelectedRow(), 0));
         ps.setString(2, bi.getText());
         int i=ps.executeUpdate();
         int x=0;
         if(i>0){
             JOptionPane.showMessageDialog(this, "Data delete success");
             showdata(bi.getText());
             clsometest();
             
         }
         else{
             JOptionPane.showMessageDialog(this, "Data delete failed");
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
        
     }}
        else{
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void b2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseClicked
        b2.setText("");
        b2.requestFocus();
    }//GEN-LAST:event_b2MouseClicked

    private void b2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b2KeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           if(b2.getText().isEmpty()){
               JOptionPane.showMessageDialog(this, "Discount is Enpty!!","Error Message",JOptionPane.ERROR_MESSAGE);
               b2.requestFocus();
           }
           else{
               int a=Integer.parseInt(b1.getText());
               int b=Integer.parseInt(b2.getText());
               a=a-b;
               b3.setText(""+a);
           }
       }
    }//GEN-LAST:event_b2KeyPressed

    private void a3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseClicked
        a3.setText("");
    }//GEN-LAST:event_a3MouseClicked

    private void a3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_a3KeyTyped
       char ch=evt.getKeyChar();
       if(!(Character.isDigit(ch)) || ch==KeyEvent.VK_ENTER || ch==KeyEvent.VK_DELETE || ch==KeyEvent.VK_BACK_SPACE){
           evt.consume();
       }
    }//GEN-LAST:event_a3KeyTyped

    private void b2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b2KeyTyped
      char ch=evt.getKeyChar();
       if(!(Character.isDigit(ch)) || ch==KeyEvent.VK_ENTER || ch==KeyEvent.VK_DELETE || ch==KeyEvent.VK_BACK_SPACE){
           evt.consume();
       }
    }//GEN-LAST:event_b2KeyTyped

    private void sKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sKeyTyped
              char ch=evt.getKeyChar();
       if(!(Character.isDigit(ch)) || ch==KeyEvent.VK_ENTER || ch==KeyEvent.VK_DELETE || ch==KeyEvent.VK_BACK_SPACE){
           evt.consume();
       }
    }//GEN-LAST:event_sKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    if(jComboBox2.getSelectedIndex()==0){
        JOptionPane.showMessageDialog(this, "Paid type is not selected","Error message",JOptionPane.ERROR_MESSAGE);
        jComboBox2.requestFocus();
    }
    else{
        try {
         config();
         String bill=bi.getText();
         String dd=da.getText();
         String ammount=b1.getText();
         String dis=b2.getText();
         String paid=b3.getText();
         String ptype=jComboBox2.getSelectedItem().toString();
         String yy="INSERT INTO `super_shop`.`psalesdata` VALUES (?,?,?,?,?,?)";
         ps=con.prepareStatement(yy);
         ps.setString(1, bill);
         ps.setString(2, dd);
         ps.setString(3, ammount);
         ps.setString(4, dis);
         ps.setString(5, paid);
         ps.setString(6, ptype);
         int p=ps.executeUpdate();
         if(p>0){
             JOptionPane.showMessageDialog(this, "Memo add success");
             printmemo(jPanel1);
             Cldata();
         }
         else{
             JOptionPane.showMessageDialog(this, "Memo add failed");
         }
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void a3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_a3KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(a3.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Quantity is empty!!","Error message",JOptionPane.ERROR_MESSAGE);
                a3.requestFocus();
            }
            else{
                if(jComboBox1.getSelectedIndex()==0){
         JOptionPane.showMessageDialog(this, "Select Product","Error message",JOptionPane.ERROR_MESSAGE);
         jComboBox1.requestFocus();
     }
     else if(a3.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Quantity is Empty!!","Error message",JOptionPane.ERROR_MESSAGE);
         a3.requestFocus();
     }
     else{
        try {
         //add
         
         DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
         SimpleDateFormat sm=new SimpleDateFormat("yyy-MM-dd");
         String bill=a1.getText();
            showtest(bill);
         String jdate=((JTextFieldDateEditor)date.getDateEditor().getUiComponent()).getText();
         String pname=jComboBox1.getSelectedItem().toString();
         String price=a2.getText();
         String qua=a3.getText();
         String det=a4.getText();
         String slno=""+sl;
         config();
         String ii="INSERT INTO `super_shop`.`saledata` VALUES (?,?,?,?,?,?,?)";
         ps=con.prepareStatement(ii);
         ps.setString(1, slno);
         ps.setString(2, bill);
         ps.setString(3, jdate);
         ps.setString(4, pname);
         ps.setString(5, price);
         ps.setString(6, qua);
         ps.setString(7, det);
         int i=ps.executeUpdate();
         int x=0;
         if(i>0){
             JOptionPane.showMessageDialog(this, "Data add success");
             sl++;
             showdata(bill);
             clsome();
             
         }
         else{
             JOptionPane.showMessageDialog(this, "Data add failed");
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(SalesData.class.getName()).log(Level.SEVERE, null, ex);
     }
        
     }  
            }
        }
    }//GEN-LAST:event_a3KeyPressed

    private void sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sMouseClicked
       s.setText("");
    }//GEN-LAST:event_sMouseClicked

    private void stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockActionPerformed

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
            java.util.logging.Logger.getLogger(SalesData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a1;
    private javax.swing.JTextField a2;
    private javax.swing.JTextField a3;
    private javax.swing.JTextField a4;
    private javax.swing.JTextField b1;
    private javax.swing.JTextField b2;
    private javax.swing.JTextField b3;
    private javax.swing.JLabel bi;
    private javax.swing.JLabel da;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel ltime;
    private javax.swing.JTextField s;
    private javax.swing.JTextField stock;
    // End of variables declaration//GEN-END:variables
}
