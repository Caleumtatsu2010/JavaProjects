/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VTabbed;

import Model.DanhSachMatHang;
import Model.MatHang;
import VDialog.KhachHangDialog;
import VDialog.MatHangDialog;

import VDialog.XoaDialog;

import VTableModel.MatHangTableModel;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author quang
 */
public class QuanLyMatHangTab extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyMatHangTab
     */
    private int indexFilter = 0;
    private TableRowSorter<TableModel> sorter;
    private final Component rootComponent = this;
    private DanhSachMatHang danhSachMathang;
    private MatHangTableModel matHangTableModel;
    // private MatHang matHang;

    public void prepareUI() {
        matHangTableModel = new MatHangTableModel(danhSachMathang.getAll());

        sorter = new TableRowSorter<>(matHangTableModel);

        tblMatHang.setModel(matHangTableModel); //= new JTable(khachHangTableModel);
        tblMatHang.setRowSorter(sorter);
        refresh(true);
        
        cbFilterTimKiem.addActionListener(cbFilterTimKiem_Changed());

    }

    /**
     * Button Thêm action
     */
    private void btnThem_Action() {
        // dialog nhập mat hang mới
        MatHangDialog matHangDialog = null;

        try {
            matHangDialog = new MatHangDialog(new JFrame(), null); // 
            System.out.println("Click vao them");
            matHangDialog.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

        // lấy mat hàng vừa nhập
        MatHang matHang = matHangDialog.getMatHang();

        // nếu người dùng không muốn thêm mat hàng
        if (matHang == null) {
            return;
        }

        // thêm vào DB
        try {
            danhSachMathang.them(matHang);
            refresh(true);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, e1);
        }
    }

    /**
     * Button sửa
     */
    private void btnSua_Action() {
        // nếu người dùng chưa chọn thì thông báo
        if (getCurrentSelected() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mat Hang cần sửa");
            return;
        }

        // hiện dialog sửa mat hang
        MatHangDialog matHangDialog = null;
        try {
            matHangDialog = new MatHangDialog(new JFrame(),
                    danhSachMathang.getAll().get(getCurrentSelected()));
            // lấy thông tin mat hang vừa sửa
            MatHang matHang = matHangDialog.getMatHang();

            // nếu người dùng không sửa
            if (matHang == null) {
                return;
            }

            // sửa đồ dùng trong danh sách và DB
            try {
                danhSachMathang.sua(matHang);
                refresh(true);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    /**
     * Sự kiện button xoá đồ dùng hỏng
     *
     * @return
     */
    /**
     * Button xóa
     *
     * @return
     */
    private void btnXoa_Action() {
        // nếu người dùng chưa chọn dòng nào thì thông báo
        if (getCurrentSelected() == -1) {
            JOptionPane.showMessageDialog(this, "Chon o can Xoa");
            return;
        }

        // lấy thông tin đồ dùng đã chọn
        String maMatHang = tblMatHang.getModel().getValueAt(getCurrentSelected(), 0).toString();
        String tenMatHang = tblMatHang.getModel().getValueAt(getCurrentSelected(), 1).toString();
        int soLuong = Integer.parseInt(tblMatHang.getModel().getValueAt(getCurrentSelected(), 5).toString());

        XoaDialog xoaMatHangDialog = new XoaDialog(new JFrame(), maMatHang, tenMatHang, soLuong);

        int ketQua = xoaMatHangDialog.getKetQua();
        System.out.println(ketQua);
        if (ketQua == 0) {
            try {
                danhSachMathang.xoa(maMatHang);
                tblMatHang.clearSelection();
                refresh(true);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1);
            }
        } else if (ketQua > 0) {
            try {
                MatHang matHang = danhSachMathang.getAll().get(danhSachMathang.tim(maMatHang));
                matHang.setSoLuongTon(ketQua);

                danhSachMathang.sua(matHang);
                refresh(true);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1);
            }
        }
    }

    private void btnHangHong_Action() {
        // hiện dialog xác nhận xoá
        int reply = JOptionPane.showConfirmDialog(null, "Xoa Mat hang", "Xoa", JOptionPane.YES_NO_OPTION);

        // nếu người dùng đồng ý
        if (reply == JOptionPane.YES_OPTION) {
            try {
                danhSachMathang.xoaBangDiaHong();
                refresh(true);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1);
            }
        }
    }

    /**
     * Lấy vị trí đang chọn trong table
     *
     * @return
     */
    private int getCurrentSelected() {
        try {
            return tblMatHang.convertRowIndexToModel(tblMatHang.getSelectedRow());
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Set row được chọn
     *
     * @param oldSelected
     */
    private void setCurrentSelected(int oldSelected) {
        if (oldSelected != -1 && oldSelected <= tblMatHang.getModel().getRowCount()) {
            tblMatHang.setRowSelectionInterval(oldSelected, oldSelected);
        } else if (oldSelected != -1 && oldSelected > tblMatHang.getModel().getRowCount()) {
            tblMatHang.setRowSelectionInterval(oldSelected - 1, oldSelected - 1);
        } else if (oldSelected == -1 && tblMatHang.getModel().getRowCount() > 0) {
            tblMatHang.setRowSelectionInterval(0, 0);
        } else {
            tblMatHang.clearSelection();
        }
    }

    /**
     * Refresh giao diện khi có cập nhật
     */
    public void refresh(boolean reloadData) {
        int oldSelected = getCurrentSelected();

        if (reloadData) {
            // load lại dữ liệu từ DB
            try {
                danhSachMathang.loadData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootComponent, e);
            }

            // load lại table đồ dùng
            matHangTableModel.setModel(danhSachMathang.getAll());
            tblMatHang.setModel(matHangTableModel);

            sorter.setModel(matHangTableModel);

            tblMatHang.revalidate();
            tblMatHang.repaint();
            setCurrentSelected(oldSelected);
        }

        // Nếu chưa có đồ dùng nào hư hỏng thì tắt nút xoá đồ dùng hỏng
        btnHangHong.setEnabled(false);
        for (MatHang matHang : danhSachMathang.getAll()) {
            if (!matHang.isTinhTrang()) {
                btnHangHong.setEnabled(true);
                break;
            }
        }

        /**
         * Kiểm tra xem người dùng có chọn dòng nào không Nếu người dùng có chọn
         * thì bật nút xoá và sửa
         */
        if (tblMatHang.getSelectedRow() == -1) {
            btnSua.setToolTipText("Vui lòng chọn đồ dùng cần cập nhật thông tin");
            btnSua.setEnabled(false);

            btnXoa.setToolTipText("Vui lòng chọn đồ dùng cần xoá");
            btnXoa.setEnabled(false);
        } else {
            btnSua.setEnabled(true);
            btnSua.setToolTipText("[Alt + S] Cập nhật thông tin đồ dùng");

            btnXoa.setEnabled(true);
            btnXoa.setToolTipText("[Alt + X] Xoá đồ dùng");
        }
    }

    /**
     * Tìm kiếm record theo tên khách hàng Dùng đối tượng filter table
     *
     * @param filter_text
     */
    private void filterTable(String filter_text) {
        if (filter_text.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            try {
                RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
                    @Override
                    public boolean include(Entry<?, ?> entry) {
                        return (entry.getStringValue(indexFilter).contains(filter_text));
                    }
                };
                sorter.setRowFilter(filter);
            } catch (NumberFormatException e) {
                txtTimKiem.selectAll();
            }

        }
    }

    public QuanLyMatHangTab() {
        initComponents();
        try {
            danhSachMathang = new DanhSachMatHang();
            prepareUI();
            System.out.println("Load Bang Quan Ly Khach Hang");
        } catch (Exception ex) {
            Logger.getLogger(QuanLyKhachHangTab.class.getName()).log(Level.SEVERE, null, ex);
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

        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        cbFilterTimKiem = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatHang = new javax.swing.JTable();
        btnHangHong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1127, 639));

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

        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        cbFilterTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ma mat hang", "Ten mat hang", "The loai", "Hang san xuat" }));
        cbFilterTimKiem.setMaximumSize(new java.awt.Dimension(152, 34));
        cbFilterTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFilterTimKiemMouseClicked(evt);
            }
        });

        tblMatHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã MH", "Tên mặt hàng", "Tình trạng", "Đơn giá", "Số lượng tồn", "Hãng sản xuất", "Ghi chú"
            }
        ));
        jScrollPane1.setViewportView(tblMatHang);

        btnHangHong.setText("Xóa hàng hỏng");
        btnHangHong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHangHongMouseClicked(evt);
            }
        });
        btnHangHong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangHongActionPerformed(evt);
            }
        });

        jLabel1.setText("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnHangHong)
                .addGap(140, 140, 140)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(cbFilterTimKiem, 0, 170, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFilterTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHangHong)
                    .addComponent(jLabel1))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sự kiện khi chọn tìm kiếm theo gì
     *
     * @return
     */
    private ActionListener cbFilterTimKiem_Changed() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (cbFilterTimKiem.getSelectedIndex()) {
                    case 0:
                        indexFilter = 0;
                        break;
                    case 1:
                        indexFilter = 1;
                        break;
                    case 2:
                        indexFilter = 2;
                        break;
                    case 3:
                        indexFilter = 6;
                        break;
                }

                filterTable(txtTimKiem.getText().trim());
            }
        };
    }


    private void cbFilterTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFilterTimKiemMouseClicked
        switch (cbFilterTimKiem.getSelectedIndex()) {
            case 0:
                indexFilter = 0;
                break;
            case 1:
                indexFilter = 1;
                break;
            case 2:
                indexFilter = 2;
                break;
            case 3:
                indexFilter = 6;
                break;
        }

        filterTable(txtTimKiem.getText().trim());
    }//GEN-LAST:event_cbFilterTimKiemMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked

    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked

    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked

    }//GEN-LAST:event_btnThemMouseClicked
//
    private void btnHangHongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHangHongMouseClicked

    }//GEN-LAST:event_btnHangHongMouseClicked

    private void btnHangHongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangHongActionPerformed
        // TODO add your handling code here:
        this.btnHangHong_Action();
    }//GEN-LAST:event_btnHangHongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        this.btnThem_Action();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        this.btnSua_Action();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        this.btnXoa_Action();
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHangHong;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbFilterTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMatHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
