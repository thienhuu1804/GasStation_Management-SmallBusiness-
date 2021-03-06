/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gasstation_management.UI.MainContentPanels;

import gasstation_management.BUS.QuanLyNhanVien_BUS;
import gasstation_management.BUS.QuanLyTaiKhoan_BUS;
import gasstation_management.DTO.NhanVien;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Vuong
 */
public class SuaNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form SuaNhanVien
     */
    JDialog owner = null;
        QuanLyTaiKhoan_BUS quanLyN = new QuanLyTaiKhoan_BUS();
        QuanLyNhanVien_BUS quanLyNhanVien_Bus = new QuanLyNhanVien_BUS();
        NhanVien nv = new NhanVien();
        public  int indexRow;
    public SuaNhanVien(JDialog owner) {
        this.owner = owner;
        setSize(new Dimension(600, 400));
        initComponents();
    }
 public void setupThongTin(NhanVien nv,int indexRow) {
        this.nv = nv;
        this.indexRow = indexRow;
        displayThongTinSua();
    }
 // hiển thị các thông tin của nhân viên được chọn ra các ô nhập
    public void displayThongTinSua()
    {
       
        suaCmnd.setText(nv.getCmnd());
       suaManv.setText(nv.getManv());
       suaTennv.setText(nv.getTennv());
      suaSdt.setText( nv.getSdt());
      suaDiachi.setText(nv.getDiachi());
      suaTrangthai.setText( nv.getTrangthai());
    }
    // Kiểm tra thông tin trên các ô chỉnh sửa
    public void CheckInfor()
    {
        NhanVien nhanvien = new NhanVien();
       String manv = suaManv.getText();
       String tennv = suaTennv.getText();
       String sdt = suaSdt.getText();
       String diachi = suaDiachi.getText();
       String cmnd = suaCmnd.getText();
       String trangthai = suaTrangthai.getText();
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
      
      if(manv.equals("") || tennv.equals("") || diachi.equals("") || sdt.equals("") || cmnd.equals("") || trangthai.equals(""))
       {
                                 JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                                 flag = false;
       }
        System.out.println(indexRow);
       // Kiểm tra có trùng mã nhân viên không,  nếu thõa thì lưu vào hệ thống
       Boolean ma = quanLyNhanVien_Bus.checkManv_Sua(manv,indexRow);
       String manvcu = quanLyNhanVien_Bus.getMaNhanViencu(indexRow);
       if(flag == true)
       {
          if(ma==false)
            {  
                      JOptionPane.showMessageDialog(null, "Mã Nhân Viên đã tồn tại");
             }
          else
          {  
              int result = JOptionPane.showConfirmDialog(null,
                "Bạn có muốn Sửa thông tin không?", "Xác nhận sửa ",
                JOptionPane.YES_NO_OPTION);
              if (result == JOptionPane.YES_OPTION) {

                 quanLyNhanVien_Bus.SuaNhanVien_Bus(nhanvien,manvcu);
                 owner.dispose();
                 }
               else if (result == JOptionPane.NO_OPTION) {
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        suaManv = new javax.swing.JTextField();
        suaSdt = new javax.swing.JTextField();
        suaDiachi = new javax.swing.JTextField();
        suaTennv = new javax.swing.JTextField();
        suaCmnd = new javax.swing.JTextField();
        suaTrangthai = new javax.swing.JTextField();
        btnSuaNhanVien = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã nhân viên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên nhân viên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Số điện thoại");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Địa chỉ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Chứng minh nhân dân");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Trạng thái");

        btnSuaNhanVien.setText("Sửa thông tin");
        btnSuaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNhanVienActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Sửa thông tin nhân viên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(suaManv, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(suaCmnd, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(suaSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(suaTennv)
                    .addComponent(suaDiachi)
                    .addComponent(suaTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnSuaNhanVien))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel7)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suaManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suaTennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suaSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suaDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suaCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suaTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSuaNhanVien)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNhanVienActionPerformed
        // TODO add your handling code here:
        CheckInfor();
    }//GEN-LAST:event_btnSuaNhanVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField suaCmnd;
    private javax.swing.JTextField suaDiachi;
    private javax.swing.JTextField suaManv;
    private javax.swing.JTextField suaSdt;
    private javax.swing.JTextField suaTennv;
    private javax.swing.JTextField suaTrangthai;
    // End of variables declaration//GEN-END:variables
}
