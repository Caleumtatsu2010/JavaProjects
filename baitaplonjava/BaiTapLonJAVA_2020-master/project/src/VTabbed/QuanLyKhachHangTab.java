/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VTabbed;

import Model.DanhSachKhachHang;
import Model.KhachHang;
import VDialog.KhachHangDialog;
import VTableModel.KhachHangTableModel;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author quang
 */
public class QuanLyKhachHangTab extends javax.swing.JPanel {

    private DanhSachKhachHang danhSachKhachHang;
    private int indexFilter = 0;
    private KhachHangTableModel khachHangTableModel;
    private TableRowSorter<TableModel> sorter;
    private final Component rootComponent = this;
//    private JTable tblKhachHang;

    public void prepareUI() {
        khachHangTableModel = new KhachHangTableModel(danhSachKhachHang.getAll());

        sorter = new TableRowSorter<>(khachHangTableModel);

        tblKhachHang.setModel(khachHangTableModel); //= new JTable(khachHangTableModel);
        tblKhachHang.setRowSorter(sorter);
        refresh(true);
    }
    
    /**
     * button Thêm action
     */
    private void btnThem_Action(){
        // dialog nhập khách hàng mới
        KhachHangDialog khachHangDialog = null;
        try {
            khachHangDialog = new KhachHangDialog(new JFrame(), null); // 
            khachHangDialog.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

        // lấy khách hàng vừa nhập
        KhachHang khachHang = khachHangDialog.getKhachHang();

        // nếu người dùng không muốn thêm khách hàng
        if (khachHang == null) {
            return;
        }

        // thêm vào DB
        try {
            danhSachKhachHang.them(khachHang);
            refresh(true);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, e1);
        }
    }

    /**
     * Lấy vị trí đang chọn trong table
     *
     * @return
     */
    private int getCurrentSelected() {
        try {
            return tblKhachHang.convertRowIndexToModel(tblKhachHang.getSelectedRow());
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
        if (oldSelected != -1 && oldSelected <= tblKhachHang.getModel().getRowCount()) {
            tblKhachHang.setRowSelectionInterval(oldSelected, oldSelected);
        } else if (oldSelected != -1 && oldSelected > tblKhachHang.getModel().getRowCount()) {
            tblKhachHang.setRowSelectionInterval(oldSelected - 1, oldSelected - 1);
        } else if (oldSelected == -1 && tblKhachHang.getModel().getRowCount() > 0) {
            tblKhachHang.setRowSelectionInterval(0, 0);
        } else {
            tblKhachHang.clearSelection();
        }
    }

    /**
     * Refresh giao diện khi có cập nhật
     */
    public void refresh(boolean reloadData) {
        int oldSelected = getCurrentSelected();

        if (reloadData) {
            // load lai dữ liệu
            try {
                danhSachKhachHang.loadData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Loi Khong load duoc du lieu");
            }

            // cập nhật table
            khachHangTableModel.setModel(danhSachKhachHang.getAll());
            tblKhachHang.setModel(khachHangTableModel);

            sorter.setModel(khachHangTableModel);

            tblKhachHang.revalidate();
            tblKhachHang.repaint();
            setCurrentSelected(oldSelected);
        }

        // bật tắt chức năng sữa, xoá
        if (getCurrentSelected() != -1) {
            btnSua.setEnabled(true);
            btnSua.setToolTipText("[Alt + S] Cập nhật thông tin khách hàng");

            btnXoa.setToolTipText("[Alt + X] Xoá khách hàng");
            btnXoa.setEnabled(true);
        } else {
            btnSua.setToolTipText("Vui lòng chọn khách hàng cần cập nhật thông tin");
            btnSua.setEnabled(false);

            btnXoa.setToolTipText("Vui lòng chọn khách hàng cần xoá");
            btnXoa.setEnabled(false);
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

    /**
     * Creates new form QuanLyKhachHang
     */
    public QuanLyKhachHangTab() {
        initComponents();
        try {
            danhSachKhachHang = new DanhSachKhachHang();
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
        tblKhachHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

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

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        cbFilterTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ma Khach Hang", "Ten Khach Hang", "CMND", "So Dien Thoai", "Dia Chi" }));
        cbFilterTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFilterTimKiemMouseClicked(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Tên KH", "Giới tính", "Ngày sinh", "CMND", "Sô điện thoại", "Địa chỉ", "Ngày hết hạn"
            }
        ));
        jScrollPane1.setViewportView(tblKhachHang);

        jLabel1.setText("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnThem)
                .addGap(56, 56, 56)
                .addComponent(btnSua)
                .addGap(68, 68, 68)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFilterTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFilterTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbFilterTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFilterTimKiemMouseClicked
        switch (cbFilterTimKiem.getSelectedIndex()) {
            case 0:
                indexFilter = 0;
                break;
            case 1:
                indexFilter = 1;
                break;
            case 2:
                indexFilter = 4;
                break;
            case 3:
                indexFilter = 5;
                break;
            case 4:
                indexFilter = 6;
                break;
        }

        filterTable(txtTimKiem.getText().trim());
    }//GEN-LAST:event_cbFilterTimKiemMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked

    }//GEN-LAST:event_btnThemMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked

    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // nếu người dùng chưa chọn dòn gnào
        if (getCurrentSelected() == -1) {
            JOptionPane.showMessageDialog(this, "Chon o can Xoa");
            return;
        }

        // lấy thông tin khách hàng ở dòng vừa chọn
        String maKhachHang = tblKhachHang.getModel().getValueAt(getCurrentSelected(), 0).toString();
        String tenKhachHang = tblKhachHang.getModel().getValueAt(getCurrentSelected(), 1).toString();

        // dialog cảnh báo người dùng
        int reply = JOptionPane.showConfirmDialog(null, "Xoa Khach Hang", "Xoa", JOptionPane.YES_NO_OPTION);

        // nếu người dùng đồng ý
        if (reply == JOptionPane.YES_OPTION) {
            try {
                danhSachKhachHang.xoa(maKhachHang);
                tblKhachHang.clearSelection();
                refresh(true);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1);
            }
        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        this.btnThem_Action();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        // nếu người dùng chưa chọn dòng nào thì thông báo
        if (getCurrentSelected() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần sửa");
            return;
        }

        KhachHang a = danhSachKhachHang.getAll().get(getCurrentSelected());

        // hiện dialog sửa thông tin khách hàng
        KhachHangDialog khachHangDialog = null;
        try {
            khachHangDialog = new KhachHangDialog(new JFrame(), a);//
//                            danhSachKhachHang.getAll().get(getCurrentSelected()));
//                    khachHangDialog.setVisible(true);
//                    System.out.println(danhSachKhachHang.getAll().get(getCurrentSelected()));

            // lấy thông tin khách hàng
            KhachHang khachHang = khachHangDialog.getKhachHang();
            // kiểm tra khách hàng có null không
            if (khachHang == null) {
                return;
            }

            // lưu thông tin thay đổi vào DB
            try {
                danhSachKhachHang.sua(khachHang);
                refresh(true);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbFilterTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
