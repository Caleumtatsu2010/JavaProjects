package VectorGUI;

import VectorGUI.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFVector_SinhVien extends javax.swing.JFrame {

    Vector tableRecords = new Vector();//Vector chứa các dòng dữ liệu của bảng.
    Vector tableTitle = new Vector();//Vector chứa các tiêu đề của bảng.
    
    Vector<SinhVien> data=new Vector<SinhVien>();// ds trung gian
    SinhVien sv=new SinhVien();//biến trung gian
    
    public JFVector_SinhVien() {
        initComponents();
        tableTitle.add("ID");
        tableTitle.add("Name");
       /**
        * với mẫu hàm cần truyền cho bảng: data,title
        * tableSV.setModel(new DefaultTableModel(data, tableTitle));
        */       
         tableSV.setModel(new DefaultTableModel(tableRecords, tableTitle));
        setLocationRelativeTo(null);
        setTitle("Demo Vector");
        /**
         * có thể set độ cao của hàng:
         * jTable.setRowHeight(50);        
         * còn set độ rộng của cột : 
         * table.getColumnModel().getColumn(i).setPreferredWidth(50);
         * trong đó  i là thứ tự cột
         */
    }

    public void optionTable() {
        //Tạo model cho table 
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override//Override lại phương thức isCellEditable 
            public boolean isCellEditable(int row, int column) {
                return false;//Trả về false không cho edit. 
            }
        };
        tableSV.setModel(tableModel);//set Model cho table 

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableSV = new javax.swing.JTable();
        txtMaSV = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSV);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 380, 152));

        txtMaSV.setText("msv");
        getContentPane().add(txtMaSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 32, 130, -1));

        txtTen.setText("ten");
        getContentPane().add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 130, -1));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 110, 72, -1));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 110, 78, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 110, -1, -1));

        jLabel1.setText("ID Student");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 35, -1, -1));

        jLabel2.setText("Full Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 73, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Vector record = new Vector();
        record.add(txtMaSV.getText());
        record.add(txtTen.getText());       
        txtMaSV.setText("");
        txtTen.setText("");
        txtMaSV.requestFocus();        
        sv=new SinhVien(txtMaSV.getText(),txtTen.getText());
        //thêm 1 bản ghi mưới vào vector
        data.addElement(sv);
        tableRecords.add(record);
        tableSV.setModel(new DefaultTableModel(tableRecords, tableTitle));
        System.out.println("Kich thuoc"+data.size());
        //JOptionPane.showMessageDialog(rootPane, "Thêm thành công");

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int iDongDaChon = tableSV.getSelectedRow();
        if (iDongDaChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn record cần xóa");
        } else {
            Vector vDongDaChon = (Vector) tableRecords.get(iDongDaChon);
            String idCuaDongDaChon = vDongDaChon.get(0).toString();
            if (JOptionPane.showConfirmDialog(rootPane, 
                    "Bạn có chắc chắn muốn xóa dòng đã chọn có id: " +
                            idCuaDongDaChon, "Lua chon", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                tableRecords.remove(iDongDaChon);
                data.remove(iDongDaChon);
                data.remove(iDongDaChon);
                //set lại table model khi tableRecords bị thay đổi dl
                tableSV.setModel(new DefaultTableModel(tableRecords, tableTitle));

            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int iDongDaChon = tableSV.getSelectedRow();
        if (iDongDaChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Xin vui lòng chọn dòng cần sửa");
        } else {
            Vector record = new Vector();
            record.add(txtMaSV.getText());
            record.add(txtTen.getText());
            tableRecords.set(iDongDaChon, record);
            tableSV.setModel(new DefaultTableModel(tableRecords, tableTitle));
            JOptionPane.showMessageDialog(rootPane, "Cập nhật xong");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tableSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSVMouseClicked
        // TODO add your handling code here:
        int iDongDaChon = tableSV.getSelectedRow();
        if (iDongDaChon != -1) {
            Vector vDongDaChon = (Vector) tableRecords.get(iDongDaChon);
            String id = vDongDaChon.get(0).toString();
            String name = vDongDaChon.get(1).toString();
            txtMaSV.setText(id);
            txtTen.setText(name);
        }
    }//GEN-LAST:event_tableSVMouseClicked

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
            java.util.logging.Logger.getLogger(JFVector_SinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFVector_SinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFVector_SinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVector_SinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFVector_SinhVien().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSV;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
