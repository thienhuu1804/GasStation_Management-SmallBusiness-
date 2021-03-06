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
public class ThemNhaCungCap extends javax.swing.JPanel {

    /**
     * Creates new form ThemNhaCungCap
     */
    QuanLyNhaCungCap_BUS quanLyNhaCungCap_BUS=new QuanLyNhaCungCap_BUS();
    JDialog owner = null;
    NhaCungCap ncc= new NhaCungCap();
    public ThemNhaCungCap(JDialog owner) {
                 this.owner = owner;
        initComponents();  
        setSize(new Dimension(500, 400));
        String mancc = quanLyNhaCungCap_BUS.autoAddMancc();
      txtMancc.setText(mancc);
      txtMancc.setEditable(false);
    }
    public void setupThongTin(NhaCungCap ncc) {
        this.ncc = ncc;
        }
    
    
    public void CheckInfor()
    {
        NhaCungCap ncc = new NhaCungCap();
       String mancc = txtMancc.getText();
       String tenncc= txtTenncc.getText();
       String sdt = txtSDT.getText();
       String diachi = txtDiachi.getText();
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
                "Bạn có muốn thêm không?", "Xác nhận thêm ",
                JOptionPane.YES_NO_OPTION);
              if (result == JOptionPane.YES_OPTION) {

                 quanLyNhaCungCap_BUS.addNhaCungCap_BUS(ncc);
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
        txtTenncc = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Mã ncc:");

        jLabel2.setText("Tên nhà cung cấp:");

        jLabel3.setText("Địa chỉ:");

        jLabel4.setText("Số điện thoại:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Thêm nhà cung cấp");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMancc, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(101, 101, 101))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtTenncc, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton1)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMancc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CheckInfor();
    }//GEN-LAST:event_jButton1ActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtMancc;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenncc;
    // End of variables declaration//GEN-END:variables
}
