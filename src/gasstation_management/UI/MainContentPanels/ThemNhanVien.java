/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gasstation_management.UI.MainContentPanels;

import gasstation_management.BUS.QuanLyTaiKhoan_BUS;
import gasstation_management.BUS.QuanLyNhanVien_BUS;

import gasstation_management.DTO.NhanVien;
import gasstation_management.DTO.TaiKhoan;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Vuong
 */
public class ThemNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
        JDialog owner = null;
        QuanLyNhanVien_BUS quanLyNhanVien_Bus = new QuanLyNhanVien_BUS();
        NhanVien nv = new NhanVien();
    public ThemNhanVien(JDialog owner) {
        this.owner = owner;
        setSize(new Dimension(600, 400));
        initComponents();
    }
    

    public void setupThongTin(NhanVien nv) {
        this.nv = nv;
    }
    public void CheckInfor()
    {
        NhanVien nhanvien = new NhanVien();
       String manv = addManv.getText();
       String tennv = addTenNV.getText();
       String sdt = addSDT.getText();
       String diachi = addDiaChi.getText();
       String cmnd = addCmnd.getText();
       String trangthai = addTrangThai.getText();
       ArrayList<String>  arrInput = new ArrayList();
      
       arrInput.add(manv);
       arrInput.add(tennv);
       arrInput.add(diachi);
       arrInput.add(cmnd);
       arrInput.add(sdt);
       arrInput.add(trangthai);
       
       nhanvien.setCmnd(cmnd);
       nhanvien.setManv(manv);
       nhanvien.setTennv(tennv);
       nhanvien.setSdt(sdt);
       nhanvien.setDiachi(diachi);
       nhanvien.setTrangthai(trangthai);
       Boolean flag = true;
       // Kiểm tra và hiển thị thông báo nhập sai, lỗi
       if(manv.equals("") || tennv.equals("") || diachi.equals("") || sdt.equals("") || cmnd.equals("") || trangthai.equals(""))
       {
                                 JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                                 flag = false;
       }
        
       // Kiểm tra có trùng mã nhân viên không,  nếu thõa thì lưu vào hệ thống
       Boolean ma = quanLyNhanVien_Bus.checkManv_Them(manv);
       if(flag == true)
       {
          if(ma==false)
            {  
                      JOptionPane.showMessageDialog(null, "Mã Nhân Viên đã tồn tại");
             }
          else
          {  
              int result = JOptionPane.showConfirmDialog(null,
                "Bạn có muốn thêm không?", "Xác nhận thêm ",
                JOptionPane.YES_NO_OPTION);
              if (result == JOptionPane.YES_OPTION) {

                 quanLyNhanVien_Bus.addNhanVien_Bus(nhanvien);
                 owner.dispose();
                 }
               else if (result == JOptionPane.NO_OPTION) {
//            changePwdDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//             owner.dispose();
           }
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addManv = new javax.swing.JTextField();
        addTenNV = new javax.swing.JTextField();
        addSDT = new javax.swing.JTextField();
        addTrangThai = new javax.swing.JTextField();
        addCmnd = new javax.swing.JTextField();
        addDiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnThemNhanVien = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tenNotify = new javax.swing.JLabel();
        diachiNotify = new javax.swing.JLabel();
        sdtNotify = new javax.swing.JLabel();
        cmndNotify = new javax.swing.JLabel();
        trangthaiNotify = new javax.swing.JLabel();
        manvNotify = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm nhân viên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Số điện thoại");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Chưng minh nhân dân");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tên nhân viên");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Địa chỉ");

        addTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTenNVActionPerformed(evt);
            }
        });

        addSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSDTActionPerformed(evt);
            }
        });

        addDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDiaChiActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Trạng thái");

        btnThemNhanVien.setText("Thêm");
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addManv, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(addCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(sdtNotify))
                                    .addComponent(cmndNotify))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(34, 34, 34)
                                .addComponent(manvNotify)))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(addTrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                        .addComponent(addDiaChi, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(tenNotify)
                                    .addComponent(diachiNotify)
                                    .addComponent(trangthaiNotify)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(btnThemNhanVien)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addManv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tenNotify)
                    .addComponent(manvNotify))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(diachiNotify))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sdtNotify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmndNotify)
                    .addComponent(trangthaiNotify))
                .addGap(10, 10, 10)
                .addComponent(btnThemNhanVien)
                .addGap(115, 115, 115))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTenNVActionPerformed

    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanVienActionPerformed
        // TODO add your handling code here:
        CheckInfor();
        
        
    }//GEN-LAST:event_btnThemNhanVienActionPerformed

    private void addDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addDiaChiActionPerformed

    private void addSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSDTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addCmnd;
    private javax.swing.JTextField addDiaChi;
    private javax.swing.JTextField addManv;
    private javax.swing.JTextField addSDT;
    private javax.swing.JTextField addTenNV;
    private javax.swing.JTextField addTrangThai;
    public javax.swing.JButton btnThemNhanVien;
    private javax.swing.JLabel cmndNotify;
    private javax.swing.JLabel diachiNotify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private static javax.swing.JLabel manvNotify;
    private javax.swing.JLabel sdtNotify;
    private javax.swing.JLabel tenNotify;
    private javax.swing.JLabel trangthaiNotify;
    // End of variables declaration//GEN-END:variables
}
