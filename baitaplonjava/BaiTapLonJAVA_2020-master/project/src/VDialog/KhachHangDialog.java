/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VDialog;

import DAO.KhachHangDAO;
import Model.KhachHang;
import Utils.Formats;
import Utils.PatternRegexs;
import View.Admin;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author quang
 */
public class KhachHangDialog extends javax.swing.JDialog {

    
    
    
    private String tieuDe;
    private KhachHang khachHang;
    private boolean isChinhSua;
    private KhachHangDAO khachHangDAO;

//    private KhachHangDialog() {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        prepareDialog();
//    }
    
    private void prepareDialog() {
//         this.txtMaKH = new JTextField(getMaKhachHangMoi());
//         this.txtMaKH.setEditable(false);
         if (this.isChinhSua) {
             this.txtMaKH.setEditable(false);
             this.txtMaKH.setText(this.khachHang.getMaKH());
         }
        
         //this.txtHoTen = new JTextField();
         if (this.isChinhSua) this.txtHoTen.setText(this.khachHang.getHoTen());
         
          //this.txtCMND = new JTextField();
        if (this.isChinhSua) {
            this.txtCMND.setText(this.khachHang.getcMND());
            this.txtCMND.setEditable(false);
        }
        
        //this.comGioiTinh = new JComboBox<>(new String[]{"Nam", "Nữ"});
        
        if (this.isChinhSua) this.comGioiTinh.setSelectedItem(this.khachHang.isGioiTinh() ? "Nam" : "Nữ");
        
        this.dateChooser = new JDateChooser(Formats.DATE_FORMAT.toPattern(), "##/##/####", '_');
        java.util.Date currentDate = new java.util.Date();
        //SimpleDateFormat SDate= new SimpleDateFormat("yyyy-MM-dd"); //them thu xem
        currentDate.setYear(currentDate.getYear() - 16);
        dateChooser.setMaxSelectableDate(currentDate);
        if (isChinhSua) dateChooser.setDate(khachHang.getNgaySinh());
        else dateChooser.setDate(currentDate);
        
        
        
        
        
        
        
       // txtSoDienThoai = new JTextField();
        if (isChinhSua) txtSoDienThoai.setText(khachHang.getSoDienThoai());
        
        
        //txtDiaChi = new JTextField();
        if (isChinhSua) txtDiaChi.setText(khachHang.getDiaChi());
        
        
        
        this.btnThem.addActionListener(btnLuu_Click());
    }
    
    private ActionListener btnLuu_Click() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // kiểm tra dữ liệu nhập
                

                // lấy thông tin khách hàng
                khachHang = new KhachHang(
                        txtCMND.getText().trim(),
                        txtHoTen.getText().trim(),
                        comGioiTinh.getSelectedItem().equals("Nam"),
                        txtSoDienThoai.getText().trim(),
                        txtDiaChi.getText().trim(),
                        Date.valueOf(Formats.DATE_FORMAT_SQL.format(dateChooser.getDate())),
                        txtMaKH.getText().trim()
                );

                // đóng dialog
                dispose();
            }
        };
    }
    
    
    
    
    
    private String getMaKhachHangMoi() {
        String lastID = "";
        String newID = "";

        // lấy mã khách hàng cuối trong DB
        try {
            lastID = khachHangDAO.getMaKhachHangCuoi();
        } catch (Exception e) {
        }

        // Nếu chưa có khách hàng trong DB thì trả về mã mặc định
        if (lastID.isEmpty()) {
            return "KH00001";
        }

        // generate mã khách hàng mới
        Pattern pattern = Pattern.compile(PatternRegexs.REGEX_MAKHACHHANG);
        Matcher matcher = pattern.matcher(lastID);
        if (matcher.find()) {
            int number = Integer.parseInt(matcher.group(1));
            number++;

            newID = String.format("KH%05d", number);
        }

        return newID;
    }
    
    public KhachHang getKhachHang() {
        return khachHang;
    }
    
    
    
    
    
    /**
     * Creates new form KhachHangDialog
     */
    public KhachHangDialog(JFrame frame, KhachHang khachHang) throws Exception {//
        super(frame, true);
        initComponents();
        
        
        this.khachHang = khachHang;

        // tạo kết nối db
        try {
            khachHangDAO = KhachHangDAO.getInstance();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        /**
         * Set tiêu đề cho dialog
         * Nếu param khachHang == null > Thêm khách hàng
         * Nếu param khachHang != null > Cập nhật thông tin khách hàng
         */
        if (khachHang == null) {
            tieuDe = "Thêm khách hàng";
            isChinhSua = false;
        } else {
            tieuDe = "Cập nhật thông tin khách hàng";
            isChinhSua = true;
        }

        // Tạo GUI
        prepareDialog();

        // set button mặc định khi nhấn Enter
        JRootPane rootPane = SwingUtilities.getRootPane(this);
        rootPane.setDefaultButton(btnThem);
        
        // cấu hình cho dialog
        setResizable(false);
        setSize(600, 500);
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
        txtMaKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comGioiTinh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnTroVe = new javax.swing.JButton();

        setTitle("Khách hàng");

        jLabel1.setText("Mã khách hàng");

        jLabel2.setText("Họ và tên");

        jLabel3.setText("Số CMND");

        jLabel4.setText("Giới tính");

        comGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nu", " " }));

        jLabel5.setText("Ngày sinh");

        jLabel6.setText("Số điện thoại");

        jLabel7.setText("Địa chỉ");

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");

        btnTroVe.setText("Trở về");
        btnTroVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTroVeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTroVe, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCMND, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comGioiTinh, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaKH)
                            .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(txtSoDienThoai)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi)
                    .addComponent(btnTroVe)
                    .addComponent(btnThem))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(155, 155, 155))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//        khachHang = new KhachHang(
//                        txtCMND.getText().trim(),
//                        txtHoTen.getText().trim(),
//                        comGioiTinh.getSelectedItem().equals("Nam"),
//                        txtSoDienThoai.getText().trim(),
//                        txtDiaChi.getText().trim(),
//                        Date.valueOf(Formats.DATE_FORMAT_SQL.format(dateChooser.getDate())),
//                        txtMaKH.getText().trim()
//                );
//
//                // đóng dialog
//                dispose();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
//         khachHang = new KhachHang(
//                        txtCMND.getText().trim(),
//                        txtHoTen.getText().trim(),
//                        comGioiTinh.getSelectedItem().equals("Nam"),
//                        txtSoDienThoai.getText().trim(),
//                        txtDiaChi.getText().trim(),
//                        Date.valueOf(Formats.DATE_FORMAT_SQL.format(dateChooser.getDate())),
//                        txtMaKH.getText().trim()
//                );
//
//                // đóng dialog
//                dispose();
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnTroVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTroVeMouseClicked
       khachHang = null;
       KhachHangDialog.this.dispose();
    }//GEN-LAST:event_btnTroVeMouseClicked

    /**
     *
     * @param args
     */
    public  static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new KhachHangDialog(new JFrame(),null).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(KhachHangDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTroVe;
    private javax.swing.JComboBox<String> comGioiTinh;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
