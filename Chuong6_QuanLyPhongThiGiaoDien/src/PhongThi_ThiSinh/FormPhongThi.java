package PhongThi_ThiSinh;

import javax.swing.JOptionPane;

public class FormPhongThi extends javax.swing.JFrame {
    private PhongThi phong=new PhongThi();     
    public FormPhongThi() {
        initComponents();
        setLocation(0,0);
        loadTable();
        lockTextDetail(false);
     }  
    /**
     * gán lại bảng theo mẫu
     */
    public void loadTable() {
        jtblThiSinh.setModel(new CustomTable(phong.getDsTS()));      
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblThiSinh = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sd = new javax.swing.JLabel();
        jtfSBD = new javax.swing.JTextField();
        jtfTen = new javax.swing.JTextField();
        jtfMaPhongThi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfDToan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfDLy = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfDHoa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfDiaChiPT = new javax.swing.JTextField();
        jbtnThem = new javax.swing.JButton();
        jbtnSua = new javax.swing.JButton();
        jbtnXoa = new javax.swing.JButton();
        jbtnThoat = new javax.swing.JButton();
        jtfSoTS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jbtnNhapDSTS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtblThiSinh.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblThiSinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblThiSinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblThiSinh);

        jLabel1.setText("SBD");

        jLabel2.setText("Họ tên");

        sd.setText("Mã phòng thi");

        jtfSBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSBDActionPerformed(evt);
            }
        });

        jtfTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTenActionPerformed(evt);
            }
        });

        jtfMaPhongThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMaPhongThiActionPerformed(evt);
            }
        });

        jLabel4.setText("Điểm toán");

        jtfDToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDToanActionPerformed(evt);
            }
        });

        jLabel5.setText("Điểm lý");

        jLabel6.setText("Điểm hóa");

        jLabel7.setText("Dia  chi Phong");

        jtfDiaChiPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDiaChiPTActionPerformed(evt);
            }
        });

        jbtnThem.setText("Thêm");
        jbtnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnThemMouseClicked(evt);
            }
        });
        jbtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });

        jbtnSua.setText("Sửa");
        jbtnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnSuaMouseClicked(evt);
            }
        });

        jbtnXoa.setText("xóa");
        jbtnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnXoaMouseClicked(evt);
            }
        });
        jbtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoaActionPerformed(evt);
            }
        });

        jbtnThoat.setText("Thoát");
        jbtnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnThoatMouseClicked(evt);
            }
        });

        jtfSoTS.setText("10");
        jtfSoTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSoTSActionPerformed(evt);
            }
        });

        jLabel3.setText("So TS");

        jbtnNhapDSTS.setText("Nhap DSTS");
        jbtnNhapDSTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnNhapDSTSMouseClicked(evt);
            }
        });
        jbtnNhapDSTS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNhapDSTSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnThem)
                                .addGap(38, 38, 38)
                                .addComponent(jbtnSua)
                                .addGap(36, 36, 36)
                                .addComponent(jbtnXoa))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfTen)
                                    .addComponent(jtfSBD, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnThoat)
                            .addComponent(jtfDHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDLy)
                            .addComponent(jtfDToan, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfDiaChiPT, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sd)
                                .addGap(31, 31, 31)
                                .addComponent(jtfMaPhongThi)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnNhapDSTS, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfSoTS, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbtnSua, jbtnThem, jbtnThoat, jbtnXoa});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtfDHoa, jtfDLy, jtfDToan, jtfDiaChiPT, jtfMaPhongThi, jtfSBD, jtfTen});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMaPhongThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sd)
                    .addComponent(jtfSoTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfDiaChiPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnNhapDSTS))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jtfDToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jtfDLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jtfDHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnThem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnSua)
                        .addComponent(jbtnXoa))
                    .addComponent(jbtnThoat))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * xóa trắng các ô nhập liẹu
     */
    public void clearTextDetail() {
        jtfSBD.setText("");
        jtfTen.setText("");
        jtfDToan.setText("");
        jtfDLy.setText("");
        jtfDHoa.setText("");  
    }
    @SuppressWarnings("unchecked")
    //Khóa textBox
    /**
     * đặt thuộc tính cấm sửa cho các ô nhập detail
     */
    private void lockTextDetail(boolean state) {
        jtfSBD.setEditable(state);
        jtfTen.setEditable(state);
        jtfDHoa.setEditable(state);
        jtfDLy.setEditable(state);
        jtfDToan.setEditable(state);
     }
    /**
     * setTextDetail đặt giá trin cho các ô nhập liệu
     * @param ts kiểu ThiSinh
     * gán giá trị cho các nhập liệu tương ứng với các thuộc tính 
     */
    private void setTextDetail(ThiSinh ts){
        jtfSBD.setText(ts.getSoBD());
        jtfTen.setText(ts.getHoTen());
        jtfDToan.setText(String.valueOf(ts.getDiemToan()));
        jtfDLy.setText(String.valueOf(ts.getDiemLy()));
        jtfDHoa.setText(String.valueOf(ts.getDiemHoa())); 
        
    }
    /**
     * TetThiSinhDetail() lấy thông tin trên các ô nhập liệu
     * @return đối tượng ThiSinh
     */
     private ThiSinh getThiSinhDetail(){
        String  soBD=jtfSBD.getText().trim();
        String hoTen=jtfTen.getText().trim();
        float diemToan=Float.parseFloat(jtfDToan.getText());
        float diemLy=Float.parseFloat(jtfDLy.getText());
        float diemHoa=Float.parseFloat(jtfDHoa.getText()); 
        return new ThiSinh(soBD,hoTen,diemToan,diemLy,diemHoa);
    }
    //Khóa textBox phần master
    private void lockTextMaster(boolean state) {
        jtfMaPhongThi.setEditable(state);
        jtfDiaChiPT.setEditable(state);
        jtfSoTS.setEditable(state);
     }  
    private void jbtnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnThemMouseClicked
        try {             
            //tao đối tượng Thí sinh mới lấy thông tin từ giao diện
            ThiSinh ts = getThiSinhDetail();
            //thêm 1 bản ghi vào dsTS
            phong.themThiSinh(ts);
            //vì dsTS đã thay đổi nên load lại bảng
            loadTable();
            //xóa các ô nhập liệu
            clearTextDetail();            
        } catch (Exception ex) {
            System.out.println("lỗi = " + ex.toString());
        }               
    }//GEN-LAST:event_jbtnThemMouseClicked

    private void jbtnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnThoatMouseClicked
          int click=JOptionPane.showConfirmDialog(null,"Chắc chắn thoát","Thoát?",JOptionPane.YES_NO_OPTION);
          if (click==JOptionPane.YES_OPTION) {    
               System.exit(1);
          }
    }//GEN-LAST:event_jbtnThoatMouseClicked

    private void jbtnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnXoaMouseClicked
        try {
            int click=JOptionPane.showConfirmDialog(null,"Chắc chắn xoa thi sinh nay","Xoa?",JOptionPane.YES_NO_OPTION);
            if (click==JOptionPane.YES_OPTION) {
                //lấy dòng chọn hiện thời trong table
                int row=jtblThiSinh.getSelectedRow();
                //lấy số báo danh ở cột 0
                String  soBD=jtblThiSinh.getValueAt(row, 0).toString();
                //truyền vào phognf thi xóa theo sbd
                phong.XoaThisinh(soBD);
                clearTextDetail();
                loadTable();}
        } catch (Exception ex) {            
            JOptionPane.showMessageDialog(null, "Không xoa duoc "+ ex.toString() );
        }
    }//GEN-LAST:event_jbtnXoaMouseClicked

    private void jbtnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSuaMouseClicked
        try {
            //lấy dòng chọn trong table
            int row=jtblThiSinh.getSelectedRow();
            //lấy dữ liệu từ giao diện tạo thí sinh mới
            String  soBD=jtblThiSinh.getValueAt(row, 0).toString();          
            //lấy thí sinh từ giao diện làm thành thí sinh mới
            ThiSinh newTS=getThiSinhDetail();
            if(phong.SuaThongtinTS(soBD, newTS))
                System.out.println("Sửa thành công");
            else
                System.out.println("Không sửa được!");
            //lấy lại dữ liệu cho bảng
             loadTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không xoa duoc "+ ex.toString() );
        }
    }//GEN-LAST:event_jbtnSuaMouseClicked

    private void jtblThiSinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblThiSinhMouseClicked
        // tấy thông tin ở dòng hiện tại,đổ lên giao diện
        int row=jtblThiSinh.getSelectedRow();
        //thí sinh trên dòng chọn chính là bản ghi tứ i trong dsts
        ThiSinh ts=phong.getDsTS().get(row);
        // gan du lieu cho cac o text tương ứng dòng chọn 
        setTextDetail(ts);     
    }//GEN-LAST:event_jtblThiSinhMouseClicked

    private void jbtnNhapDSTSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnNhapDSTSMouseClicked
        //Khoi tao doi tuong phong thi co thong tin tren o text
        String maPT=jtfMaPhongThi.getText();
        String diaChiPT=jtfDiaChiPT.getText();
        int soTS=Integer.parseInt(jtfSoTS.getText().toString());
        //gán dữ liệu đã lấy đc lưu vào biến phòng
        phong.setMsPT(maPT);
        phong.setDiachiPT(diaChiPT);
        phong.setLuongTS(soTS);  
        lockTextDetail(true);
        lockTextMaster(false);
    }//GEN-LAST:event_jbtnNhapDSTSMouseClicked

    private void jtfMaPhongThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMaPhongThiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMaPhongThiActionPerformed

    private void jtfDiaChiPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDiaChiPTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDiaChiPTActionPerformed

    private void jtfSoTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSoTSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSoTSActionPerformed

    private void jbtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnXoaActionPerformed

    private void jbtnNhapDSTSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNhapDSTSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnNhapDSTSActionPerformed

    private void jtfSBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSBDActionPerformed

    private void jtfTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTenActionPerformed

    private void jtfDToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDToanActionPerformed

    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnThemActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              new FormPhongThi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnNhapDSTS;
    private javax.swing.JButton jbtnSua;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JButton jbtnThoat;
    private javax.swing.JButton jbtnXoa;
    public javax.swing.JTable jtblThiSinh;
    private javax.swing.JTextField jtfDHoa;
    private javax.swing.JTextField jtfDLy;
    private javax.swing.JTextField jtfDToan;
    private javax.swing.JTextField jtfDiaChiPT;
    private javax.swing.JTextField jtfMaPhongThi;
    private javax.swing.JTextField jtfSBD;
    private javax.swing.JTextField jtfSoTS;
    private javax.swing.JTextField jtfTen;
    private javax.swing.JLabel sd;
    // End of variables declaration//GEN-END:variables

}
