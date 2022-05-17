/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gasstation_management.UI.MainContentPanels;

import gasstation_management.BUS.QuanLyNhaCungCap_BUS;
import gasstation_management.DTO.NhaCungCap;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Vuong
 */
public class SuaNhaCungCap extends javax.swing.JPanel {

    /**
     * Creates new form SuaNhaCungCap
     */
    QuanLyNhaCungCap_BUS quanLyNhaCungCap_BUS=new QuanLyNhaCungCap_BUS();
    JDialog owner = null;
    NhaCungCap ncc1= new NhaCungCap();
    SuaNhaCungCap(JDialog owner) {
        this.owner = owner;
        initComponents();
        setSize(new Dimension(500, 400));
      
    }
    void setupThongTin(NhaCungCap ncc1) {
        this.ncc1=ncc1;
        txtMancc.setText(ncc1.getMancc());
      txtTenNcc.setText(ncc1.getTenncc());
      txtDiaChi.setText(ncc1.getDiachi());
      txtSDT.setText(ncc1.getSDT());
      txtMancc.setEditable(false);
    }
    
    public void CheckInfor()
    {
        NhaCungCap ncc = new NhaCungCap();
       String mancc = txtMancc.getText();
       String tenncc= txtTenNcc.getText();
       String sdt = txtSDT.getText();
       String diachi = txtDiaChi.getText();
       ArrayList<String>  arrInput = new ArrayList();
        System.out.println(mancc);
       arrInput.add(mancc);
       arrInput.add(tenncc);
       arrInput.add(sdt);
       arrInput.add(diachi);
       
       ncc.setMancc(mancc);
       ncc.setTenncc(tenncc);
       ncc.setSDT(sdt);
       ncc.setDiachi(diachi);
       Boolean flag = true;
       // Kiểm tra và hiển thị thông báo nhập sai, lỗi
       if(mancc.equals("") || tenncc.equals("") || diachi.equals("") || sdt.equals(""))
       {
                                 JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                                 flag = false;
       }
        
       // Kiểm tra có trùng mã nhân viên không,  nếu thõa thì lưu vào hệ thống
       if(flag == true)
       {
              int result = JOptionPane.showConfirmDialog(null,
                "Bạn có muốn sửa không?", "Xác nhận sửa ",
                JOptionPane.YES_NO_OPTION);
              if (result == JOptionPane.YES_OPTION) {

                 quanLyNhaCungCap_BUS.updateNhaCungCap_BUS(ncc);
                 owner.dispose();
                 }
               else if (result == JOptionPane.NO_OPTION) {
//            changePwdDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//             owner.dispose();
           
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
        txtMancc = new javax.swing.JTextField();
        txtTenNcc = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btnSuaThongTin = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sửa thông tin nhà cung cấp");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã nhà cung cấp:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên nhà cung cấp:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Địa chỉ:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        btnSuaThongTin.setText("Sửa thông tin");
        btnSuaThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(164, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(txtMancc, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(txtDiaChi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(txtTenNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(txtSDT))))
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSuaThongTin)
                .addGap(215, 215, 215))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMancc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnSuaThongTin)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnSuaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThongTinActionPerformed
        // TODO add your handling code here:
        CheckInfor();
    }//GEN-LAST:event_btnSuaThongTinActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaThongTin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMancc;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNcc;
    // End of variables declaration//GEN-END:variables

}
