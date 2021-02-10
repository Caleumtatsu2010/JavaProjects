/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VDialog;

import DAO.MatHangDAO;
import Model.MatHang;
import Utils.PatternRegexs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author quang
 */
public class MatHangDialog extends javax.swing.JDialog {

    /**
     * Creates new form MatHangDialog
     */
    
    private MatHang matHang;
    private boolean isChinhSua;
    private MatHangDAO matHangDAO;
    private String tieuDe;
    
     private void prepareDialog() {
         //this.txtMaMatHang.setEditable(true);
         //this.txtMaMatHang.setText(getMaMatHangMoi());
         if (this.isChinhSua) {
             this.txtMaMatHang.setEditable(false);
             this.txtMaMatHang.setText(this.matHang.getMaMatHang());
         }
        
         
         if (this.isChinhSua) this.txtTenMatHang.setText(this.matHang.getTenMatHang());
         
          
        if (this.isChinhSua) {
            this.txtHangSanXuat.setText(this.matHang.getHangSanXuat());
            
        }
        
        
        //this.comTinhTrang.setEnabled(false);
        //this.comTinhTrang.setSelectedItem("Moi");
        if (this.isChinhSua){
            this.comTinhTrang.setEnabled(true);
            this.comTinhTrang.setSelectedItem(this.matHang.isTinhTrang() ? "Moi" : "Hong");
        }
        
        
        if (this.isChinhSua){  this.txtDonGia.setText(this.matHang.getDonGia()+"");}
             
        if (this.isChinhSua){ this.txtGhiChu.setText(this.matHang.getGhiChu());}
          
        if (this.isChinhSua){  this.txtSoLuongTon.setText( this.matHang.getSoLuongTon()+"");}
        
        if (this.isChinhSua){  this.txtLoaiMathang.setText(this.matHang.getTheLoai()+"");}
       
        
        this.btnThem.addActionListener(btnLuu_Click());
    }
    
    private ActionListener btnLuu_Click() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // kiểm tra dữ liệu nhập
                

                // lấy thông tin mat hàng
                matHang = new MatHang(
                        txtMaMatHang.getText().trim(),
                        txtTenMatHang.getText().trim(),
                        txtLoaiMathang.getText().trim(),
                        String.valueOf(comTinhTrang.getSelectedItem()).equalsIgnoreCase("Moi"),
                        txtHangSanXuat.getText().trim(),
                        txtGhiChu.getText().trim(),
                        Double.parseDouble(txtDonGia.getText().trim()),
                        Integer.parseInt(txtSoLuongTon.getText().trim())
                );

                // đóng dialog
                dispose();
            }
        };
    }
    
    
    
    
    /**
     * Generate mã băng đãi mới
     *
     * @return
     */
    private String getMaMatHangMoi() {
        String lastID = "";
        String newID = "";

        // lấy mã mat hang cuối trong DB
        try {
            lastID = matHangDAO.getMaBangDiaCuoi();
        } catch (Exception e) {
        }

        // nếu chưa có mat hang nào trong DB thì trả về mã mặc định đầu tiên
        if (lastID.isEmpty()) {
            return "BD00001";
        }

        // generate mã
        Pattern pattern = Pattern.compile(PatternRegexs.REGEX_MABANGDIA);
        Matcher matcher = pattern.matcher(lastID);
        if (matcher.find()) {
            int number = Integer.parseInt(matcher.group(1));
            number++;

            newID = String.format("BD%05d", number);
        }

        return newID;
    }
    
    
    public MatHang getMatHang(){
        return matHang;
    }
    
  
    
    public MatHangDialog(JFrame frame, MatHang matHang) throws Exception {
        super(frame, true);
        initComponents();
        
        this.matHang = matHang;
        // lấy instance kết nối với db (table MATHANG)
        try {
            matHangDAO = MatHangDAO.getInstance();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        /**
         * Đặt tiêu đề cho dialog
         * Nếu param matHang = null > Thêm mat hang
         * Nếu param matHang != null > Cập nhật thông tin mat hang
         */
        if (matHang == null) {
            tieuDe = "Thêm mat hang";
            isChinhSua = false;
        } else {
            tieuDe = "Cập nhật thông tin mat hang";
            isChinhSua = true;
        }

        // tạo GUI
        prepareDialog();

        // đặt button mặc định khi bấm Enter
        JRootPane rootPane = SwingUtilities.getRootPane(this);
        rootPane.setDefaultButton(btnThem);

        // cấu hình cho dialog
        setResizable(false);
       // setSize(600, 620);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        //setUndecorated(true);
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
        txtMaMatHang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenMatHang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLoaiMathang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHangSanXuat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comTinhTrang = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mặt hàng");

        jPanel1.setToolTipText("");

        jLabel1.setText("Mã mặt hàng");

        jLabel2.setText("Tên mặt hàng");

        jLabel3.setText("Loại hàng");

        jLabel4.setText("Hãng sản xuất");

        jLabel5.setText("Số lượng tồn");

        txtSoLuongTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongTonActionPerformed(evt);
            }
        });

        jLabel6.setText("Tình trạng");

        comTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Moi", "Hong" }));

        jLabel7.setText("Đơn giá");

        jLabel8.setText("Ghi chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comTinhTrang, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(txtDonGia)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaMatHang, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                    .addComponent(txtLoaiMathang)
                                    .addComponent(txtTenMatHang)
                                    .addComponent(txtHangSanXuat)
                                    .addComponent(txtSoLuongTon)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(11, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLoaiMathang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(comTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnThoat))
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoLuongTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongTonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongTonActionPerformed

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
       matHang = null;
       MatHangDialog.this.dispose();
    }//GEN-LAST:event_btnThoatMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
//         matHang = new MatHang(
//                        txtMaMatHang.getText().trim(),
//                        txtTenMatHang.getText().trim(),
//                        txtLoaiMathang.getText().trim(),
//                        String.valueOf(comTinhTrang.getSelectedItem()).equalsIgnoreCase("Moi"),
//                        txtHangSanXuat.getText().trim(),
//                        txtGhiChu.getText().trim(),
//                        Double.parseDouble(txtDonGia.getText().trim()),
//                        Integer.parseInt(txtSoLuongTon.getText().trim())
//                );
//
//                // đóng dialog
//                MatHangDialog.this.dispose();
    }//GEN-LAST:event_btnThemMouseClicked

//        public  static void main(String args[]){
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new MatHangDialog(new JFrame(),null).setVisible(true);
//                } catch (Exception ex) {
//                    Logger.getLogger(KhachHangDialog.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    
//    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> comTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHangSanXuat;
    private javax.swing.JTextField txtLoaiMathang;
    private javax.swing.JTextField txtMaMatHang;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTenMatHang;
    // End of variables declaration//GEN-END:variables
}
