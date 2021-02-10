/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author quang
 */
public class ThanhToanDialog extends javax.swing.JDialog {

    /**
     * Creates new form ThanhToanDialog
     */
    private int soLuong;
    private String tenKhachHang;
    private String tenMatHang;
    
    
    /**
     * Tạo GUI
     */
    private void prepareDialog() {
        txtTenKhachHang.setText(tenKhachHang);
        txtTenKhachHang.setEditable(false);
        
        txtTenMatHang.setText(tenMatHang);
        txtTenMatHang.setEditable(false);
        
        txtSoLuongHienTai.setText(soLuong+"");
        txtSoLuongHienTai.setEditable(false);
        
        
        txtSoLuongMuonThanhToan.addKeyListener(txtSoLuongMuonXoa_KeyListener());
        txtSoLuongConLai.setEditable(false);
        
        //set event for button HUY
        btnHuy.addActionListener(btnHuy_Click());
        
        
        //set event for button ThanhtoanHet
        btnThanhToanHet.addActionListener(btnThanhToanHet_Click());
        
        
        // set event for ThanhToan
        btnThanhToan.addActionListener(btnThanhToan_Click());
        
    }
    
    
    
    /**
     * Sự kiện button Huỷ
     *
     * @return
     */
    private ActionListener btnHuy_Click() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soLuong = -1;
                dispose();
            }
        };
    }
    
    /**
     * Sự kiện button Đồng ý
     *
     * @return
     */
    private ActionListener btnThanhToanHet_Click() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // dialog cảnh báo người dùng
                int reply = JOptionPane.showConfirmDialog(null,
                        "Bạn có muốn thanh toán hết hoá đơn này không ?",
                        "Thanh toán", JOptionPane.YES_NO_OPTION);

                // nếu người dùng đồng ý
                if (reply == JOptionPane.YES_OPTION) {
                    try {
                        soLuong = 0;
                    dispose();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(rootPane, e1);
                    }
                }
               
            }
        };
    }
    
     /**
     * Sự kiện button Đồng ý
     *
     * @return
     */
    private ActionListener btnThanhToan_Click() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // kiểm tra dữ liệu
                
                int reply = JOptionPane.showConfirmDialog(null,
                        "Bạn có muốn thanh toán"+txtSoLuongMuonThanhToan.getText().trim()+" hoá đơn này không ?",
                        "Thanh toán", JOptionPane.YES_NO_OPTION);

                // nếu người dùng đồng ý
                if (reply == JOptionPane.YES_OPTION) {
                    try {
                        soLuong = soLuong - Integer.parseInt(txtSoLuongMuonThanhToan.getText().trim());
                        dispose();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(rootPane, e1);
                    }
                }
            }
        };
    }
    
    
    
    /**
     * Sự kiện khi nhập text số lượng
     *
     * @return
     */
    private KeyListener txtSoLuongMuonXoa_KeyListener() {
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int soLuongMuonXoa = Integer.parseInt(txtSoLuongMuonThanhToan.getText().trim());

                    

                    txtSoLuongConLai.setText(String.valueOf(soLuong - soLuongMuonXoa));
                } catch (Exception ex) {
                    txtSoLuongConLai.setText(String.valueOf(soLuong));
                }
            }
        };
    }


    /**
     * Lấy kết quả người dùng chọn
     *
     * @return
     */
    public int getKetQua() {
        return soLuong;
    }

    
    
    
    
    
    
    
    public ThanhToanDialog(JFrame frame, String tenKhachHang, String tenMatHang, int soLuong) {
         super(frame, true);
        initComponents();
        

        this.tenKhachHang = tenKhachHang;
        this.tenMatHang = tenMatHang;
        this.soLuong = soLuong;

        prepareDialog();

        setResizable(false);
        setSize(550, 530);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
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
        jLabel1 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenMatHang = new javax.swing.JTextField();
        txtSoLuongHienTai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuongMuonThanhToan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoLuongConLai = new javax.swing.JTextField();
        btnHuy = new javax.swing.JButton();
        btnThanhToanHet = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tên khách hàng");

        jLabel2.setText("Tên mặt hàng");

        jLabel3.setText("Số lượng hiện tại");

        txtTenMatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMatHangActionPerformed(evt);
            }
        });

        jLabel4.setText("Số lượng thanh toán");

        jLabel5.setText("Số lượng còn lại");

        btnHuy.setText("Hủy");

        btnThanhToanHet.setText("Thanh toán hết");

        btnThanhToan.setText("Thanh toán");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenMatHang, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSoLuongHienTai)
                            .addComponent(txtTenKhachHang)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuongConLai, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(txtSoLuongMuonThanhToan))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThanhToanHet, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan)
                .addGap(9, 9, 9))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoLuongHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoLuongMuonThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoLuongConLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToanHet)
                    .addComponent(btnThanhToan)
                    .addComponent(btnHuy))
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenMatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMatHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMatHangActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThanhToanHet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtSoLuongConLai;
    private javax.swing.JTextField txtSoLuongHienTai;
    private javax.swing.JTextField txtSoLuongMuonThanhToan;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenMatHang;
    // End of variables declaration//GEN-END:variables
}
