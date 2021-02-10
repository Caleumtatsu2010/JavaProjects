/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VDialog;

import DAO.HoaDonDAO;
import Model.DanhSachKhachHang;
import Model.DanhSachMatHang;
import Model.HoaDon;
import Model.KhachHang;
import Model.MatHang;
import Utils.Formats;
import Utils.PatternRegexs;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author quang
 */
public class ChoThueDialog extends javax.swing.JDialog {

    /**
     * Creates new form ChoThueDialog
     */
    
    private HoaDon hoaDon;
    private String tieuDe;
    private boolean isChinhSua;
    private DanhSachKhachHang danhSachKhachHang;
    private DanhSachMatHang danhSachMatHang;
    private HoaDonDAO hoaDonDAO;
    
    
    private void prepareDialog() {
        
        // set the txtMaHoaDon
        txtMaHoaDon.setText(getMaHoaDonMoi());
        txtMaHoaDon.setEditable(false);
        if (isChinhSua) txtMaHoaDon.setText(hoaDon.getMaHoaDon());
        
        // set the comboBox khachHang
        for (KhachHang khachHang : danhSachKhachHang.getAll())
            cbMaKhachHang.addItem(String.format("[%s] %s", khachHang.getMaKH(), khachHang.getHoTen()));
        if (isChinhSua)
            cbMaKhachHang.setSelectedItem(String.format("[%s] %s",
                    hoaDon.getKhachHang().getMaKH(),
                    hoaDon.getKhachHang().getHoTen()));
        
        // set the comboBox matHang
        for (MatHang matHang : danhSachMatHang.getAll())
            if (matHang.getSoLuongTon() > 0)
                cbMaMatHang.addItem(String.format("[%s] %s", matHang.getMaMatHang(), matHang.getTenMatHang()));

        if (isChinhSua) {
            cbMaMatHang.addItem(String.format("[%s] %s",
                    hoaDon.getBangDia().getMaMatHang(), hoaDon.getBangDia().getTenMatHang()));

            cbMaMatHang.setSelectedItem(String.format("[%s] %s",
                    hoaDon.getBangDia().getMaMatHang(), hoaDon.getBangDia().getTenMatHang()));
        }
        
        // set for the date time 
        dateChooser = new JDateChooser(Formats.DATE_FORMAT.toPattern(), "##/##/####", '_');
        dateChooser.setMaxSelectableDate(new java.util.Date());

        if (isChinhSua) {
            dateChooser.setDate(hoaDon.getNgayLap());
        }
        else {
            dateChooser.setDate(new java.util.Date());
        }
        
        
        //set the soLuong
        if (isChinhSua) txtSoLuong.setText(String.valueOf(hoaDon.getSoLuong()));
        
        // set the soNgayDuocMuon
        if (isChinhSua) txtSoNgayDuocMuon.setText(String.valueOf(hoaDon.getSoNgayDuocMuon()));
         
        
        //set the button Thoat
        btnThoat.addActionListener(btnThoat_Click());
        
        
        //set the button Luu
        btnLuu.addActionListener(btnLuu_Click());
        
        
    }
    
     /**
     * Generate mã hoá đơn mới
     *
     * @return
     */
    private String getMaHoaDonMoi() {
        String lastID = "";
        String newID = "";

        // lấy mã hoá đơn cuối trong DB
        try {
            lastID = hoaDonDAO.getMaHoaDonCuoi();
        } catch (Exception e) {
        }

        // Nếu chưa có hoá đơn nào trong DB thì trả về mã mặc định
        if (lastID.isEmpty()) {
            return "HD00001";
        }

        // generate mã
        Pattern pattern = Pattern.compile(PatternRegexs.REGEX_MAHOADON);
        Matcher matcher = pattern.matcher(lastID);
        if (matcher.find()) {
            int number = Integer.parseInt(matcher.group(1));
            number++;

            newID = String.format("HD%05d", number);
        }

        return newID;
    }
    
    
     /**
     * Sự kiện nút Thoát
     *
     * @return
     */
    private ActionListener btnThoat_Click() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hoaDon = null;
                ChoThueDialog.this.dispose();
            }
        };
    }


    /**
     * Sự kiện nút Lưu
     *
     * @return
     */
    private ActionListener btnLuu_Click() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra dữ liệu nhập
                

                MatHang matHang = null;
                KhachHang khachHang = null;
                Pattern pattern = null;
                Matcher matcher = null;

                // lấy dữ liệu đồ dùng
                pattern = Pattern.compile("(BD\\d.*)]", Pattern.MULTILINE);
                matcher = pattern.matcher(String.valueOf(cbMaMatHang.getSelectedItem()));

                if (matcher.find())
                    matHang = danhSachMatHang.getAll().get(danhSachMatHang.tim(matcher.group(1)));

                // lấy dữ liệu khách hàng
                pattern = Pattern.compile("(KH\\d.*)]", Pattern.MULTILINE);
                matcher = pattern.matcher(cbMaKhachHang.getSelectedItem().toString());

                if (matcher.find())
                    khachHang = danhSachKhachHang.getAll().get(danhSachKhachHang.tim(matcher.group(1)));

                // tạo thông tin hoá đơn
                hoaDon = new HoaDon(
                        matHang,
                        Integer.parseInt(txtSoNgayDuocMuon.getText().trim()),
                        Integer.parseInt(txtSoLuong.getText().trim()),
                        txtMaHoaDon.getText().trim(),
                        khachHang,
                        Date.valueOf(Formats.DATE_FORMAT_SQL.format(dateChooser.getDate()))
                );
                
                System.out.println(hoaDon);

                // đóng dialog
                dispose();
            }
        };
    }
    
    
    
    
    /**
     * Trả về hoá đơn đã được thêm/chỉnh sửa
     *
     * @return
     */
    public HoaDon getHoaDon() {
        return hoaDon;
    }

    
    
    
    public ChoThueDialog(JFrame frame, HoaDon hoaDon) throws Exception {
        super(frame, true);
        initComponents();
        
        this.hoaDon = hoaDon;

        // Tạo kết nối đến db
        try {
            hoaDonDAO = HoaDonDAO.getInstance();
            danhSachKhachHang = new DanhSachKhachHang();
            danhSachMatHang = new DanhSachMatHang();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        /**
         * set tiêu đề cho dialog
         * Nếu param hoaDon == null > Cho thuê
         * Nếu param hoaDon != null > Cập nhật thông tin cho thuê
         */
        if (hoaDon == null) {
            this.tieuDe = "Cho thuê";
            isChinhSua = false;
        } else {
            this.tieuDe = "Cập nhật thông tin cho thuê";
            isChinhSua = true;
        }

        // Tạo GUI
        prepareDialog();

        // Button mặc định khi bấm Enter
        JRootPane rootPane = SwingUtilities.getRootPane(this);
        rootPane.setDefaultButton(btnLuu);

        // cấu hình cho dialog
        setResizable(false);
        setSize(600, 585);
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
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbMaKhachHang = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbMaMatHang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoNgayDuocMuon = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mã hóa đơn");

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Mã mặt hàng");

        jLabel4.setText("Ngày thuê");

        jLabel5.setText("Số lượng");

        jLabel6.setText("Số ngày mượn");

        txtSoNgayDuocMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNgayDuocMuonActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");

        btnThoat.setText("Thoát");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(59, 59, 59)
                                .addComponent(cbMaMatHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(49, 49, 49)
                                .addComponent(cbMaKhachHang, 0, 174, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txtSoNgayDuocMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(65, 65, 65)
                                .addComponent(txtMaHoaDon)))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbMaMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoNgayDuocMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnThoat))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoNgayDuocMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNgayDuocMuonActionPerformed
        
    }//GEN-LAST:event_txtSoNgayDuocMuonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cbMaKhachHang;
    private javax.swing.JComboBox<String> cbMaMatHang;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoNgayDuocMuon;
    // End of variables declaration//GEN-END:variables
}
