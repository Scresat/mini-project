
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Satyam
 */
public class mp_bill extends javax.swing.JFrame {

    /**
     * Creates new form mp_bill
     */
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    public void Close() {//method to close the window
        WindowEvent wce = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wce);
    }
    public mp_bill() {
        initComponents();
        conn = mysqlConnect.connectDB();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/hospital.png")));
        UpdateTable();
        ClearCart();
        btn_addtocart.setEnabled(false);
        btn_bill.setEnabled(false);
        btn_remove.setEnabled(false);
        btn_clear.setEnabled(false);
    }
     public void UpdateTable() {
        try {
            String sql = "select * from medicine where quantity > 0 and id not in (select id from cart);;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            table_medicines.setModel(DbUtils.resultSetToTableModel(rs));
            table_medicines.getTableHeader().setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        txt_quantity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_addtocart = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_bill = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_medicines = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_cart = new javax.swing.JTable();
        btn_remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Enter Quantity");

        btn_addtocart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_addtocart.setText("Add to cart");
        btn_addtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addtocartActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_clear.setText("Clear Cart");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_bill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_bill.setText("Generate Bill");
        btn_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_billActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        table_medicines.setAutoCreateRowSorter(true);
        table_medicines.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        table_medicines.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        table_medicines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_medicines.setGridColor(new java.awt.Color(255, 255, 255));
        table_medicines.setRowHeight(25);
        table_medicines.setRowSorter(null);
        table_medicines.setSelectionBackground(new java.awt.Color(122, 72, 221));
        table_medicines.getTableHeader().setResizingAllowed(false);
        table_medicines.getTableHeader().setReorderingAllowed(false);
        table_medicines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_medicinesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_medicines);

        jScrollPane2.setBorder(null);

        table_cart.setAutoCreateRowSorter(true);
        table_cart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        table_cart.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        table_cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_cart.setGridColor(new java.awt.Color(255, 255, 255));
        table_cart.setRowHeight(25);
        table_cart.setSelectionBackground(new java.awt.Color(122, 72, 221));
        table_cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cartMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_cart);

        btn_remove.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_remove.setText("Remove Selection");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_quantity)
                            .addComponent(btn_addtocart, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_remove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_bill))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(31, 31, 31)
                        .addComponent(btn_addtocart))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_bill)
                            .addComponent(btn_clear)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btn_remove)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addtocartActionPerformed
        String quantity_validate = txt_quantity.getText();
        
        // validating for every field
        // even if one of the field doesn't validate, the 'save' code in else won't be saved
        int row = table_medicines.getSelectedRow();
        String table_click = table_medicines.getModel().getValueAt(row, 0).toString(); // employee id is taken into table_click variable

        try {
            String sql = "select * from medicine where id =" + table_click + ";";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                price = rs.getString("price");
                quantity = rs.getString("quantity");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if (quantity_validate.equals("")){
            JOptionPane.showMessageDialog(null, "Enter quantity");
        }
        else if (Integer.parseInt(quantity_validate) > Integer.parseInt(quantity)) {
            JOptionPane.showMessageDialog(null, "Not enough stock available!");
         }
        
         else {
            try {
                String sql = "insert into cart (id, price, quantity)values(?,?,?);";
                pst = conn.prepareStatement(sql);
                String currentSelectedID = empID;
                pst.setString(1, empID);
                pst.setString(2, price);
                pst.setString(3, txt_quantity.getText());
             

                pst.execute();
                UpdateCart();
                updateQuantityAfterAddingToCart(currentSelectedID);
                btn_bill.setEnabled(true);
                btn_clear.setEnabled(true);
                txt_quantity.setText("");
                noincart++;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally { // gurantees this section will be executed, even if error is encountered
                try {
                    rs.close();
                    pst.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } 
    }//GEN-LAST:event_btn_addtocartActionPerformed
    
    private void updateQuantityAfterAddingToCart(String currentSelectedID) {
        try{
            String sql = "update medicine set medicine.quantity = medicine.quantity-(select cart.quantity from cart, medicine where medicine.id = ? and cart.id = ?) where medicine.id = ?";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, currentSelectedID);
            pst.setString(2, currentSelectedID);
            pst.setString(3, currentSelectedID);
            pst.execute();
            UpdateCart();
            UpdateTable();
            btn_addtocart.setEnabled(false);   
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void UpdateCart() {
        try {
            String sql = "select medicine.name as \"Name\",cart.id as \"ID\", cart.quantity as \"Quantity\", cart.price*cart.quantity as \"Total Price\" from cart, medicine where medicine.id = cart.id";
            pst = conn.prepareStatement(sql);
            rs2 = pst.executeQuery();
            table_cart.setModel(DbUtils.resultSetToTableModel(rs2));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }    
    private void ClearCart(){
        try{
            String sql = "update medicine med1 set quantity = quantity+(select quantity from cart where id = med1.id) where exists (select quantity from cart where id = med1.id)";
            pst = conn.prepareStatement(sql);
            pst.execute();
            UpdateCart();
            UpdateTable();
            btn_addtocart.setEnabled(false);   
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
                String sql = "delete from cart;";
                pst = conn.prepareStatement(sql);
                pst.execute();
                UpdateCart();
                btn_bill.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
            ClearCart();
            UpdateTable();
            UpdateCart();
            txt_quantity.setText("");
            btn_remove.setEnabled(false);
            btn_clear.setEnabled(false);
            btn_bill.setEnabled(false);
    }//GEN-LAST:event_btn_clearActionPerformed
    
   
    private void btn_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_billActionPerformed
        try{      
            
            insertIntoBill();
            
            
            UpdateCart();
            UpdateTable();
            btn_addtocart.setEnabled(false);
            txt_quantity.setText("");
            mp_generatedbill bill = new mp_generatedbill();
            bill.setVisible(true);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_billActionPerformed

    public void insertIntoBill(){
        try {
            
            java.util.Date date=new java.util.Date();
			
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());

            PreparedStatement ps=conn.prepareStatement("insert into bill (price, date, time) values ((select sum(price*quantity) from cart), ?,?);");
            ps.setDate(1,sqlDate);
            ps.setTimestamp(2,sqlTime);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        UpdateCart();
    }//GEN-LAST:event_formWindowGainedFocus

    private void table_medicinesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_medicinesMouseClicked
        btn_addtocart.setEnabled(true);
        int row = table_medicines.getSelectedRow();
        String table_click = table_medicines.getModel().getValueAt(row, 0).toString(); 

        try {
            String sql = "select * from medicine where id =" + table_click + ";";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                empID = rs.getString("id");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_table_medicinesMouseClicked

    private void table_cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cartMouseClicked
        int row = table_cart.getSelectedRow();
        String table_click = table_cart.getModel().getValueAt(row, 1).toString();

        try {
            String sql = "select * from cart where id =" + table_click + ";";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                cartID = rs.getString("id");
                btn_remove.setEnabled(true);
            }
            else
            {
                btn_clear.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_table_cartMouseClicked

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
         try{
            String sql = "update medicine set medicine.quantity = medicine.quantity+(select cart.quantity from cart, medicine where medicine.id = ? and cart.id = ?) where medicine.id = ?";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, cartID);
            pst.setString(2, cartID);
            pst.setString(3, cartID);
            pst.execute();
            UpdateCart();
            UpdateTable();
            btn_addtocart.setEnabled(false);  
            noincart--;
            if (noincart == 0){
                btn_clear.setEnabled(false);
                btn_bill.setEnabled(false);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            String sql = "delete from cart where id = ?;";
            pst = conn.prepareStatement(sql);
            pst.setString(1, cartID);
            pst.execute();
            UpdateTable();
            UpdateCart();
            btn_remove.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_btn_removeActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ClearCart();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        UpdateTable();
        btn_bill.setEnabled(false);
    }//GEN-LAST:event_formWindowActivated
 
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mp_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mp_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mp_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mp_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mp_bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addtocart;
    private javax.swing.JButton btn_bill;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_remove;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_cart;
    private javax.swing.JTable table_medicines;
    private javax.swing.JTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
    
    String empID = "";
    String quantity = "";
    String price = "";
    
    String cartID = "";
    int noincart = 0;
}
