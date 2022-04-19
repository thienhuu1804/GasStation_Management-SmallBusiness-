/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.UI.MainContentPanels;

import gasstation_management.BUS.QuanLyQuyenTaiKhoan_BUS;
import gasstation_management.BUS.QuanLyQuyen_BUS;
import gasstation_management.BUS.QuanLyTaiKhoan_BUS;
import gasstation_management.DTO.Quyen;
import gasstation_management.DTO.QuyenTaiKhoan;
import gasstation_management.DTO.TaiKhoan;
import gasstation_management.DataTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author nguye
 */
public class PrivilegeManagementPanel extends javax.swing.JPanel {

    /**
     * Creates new form AccountManagementPanel
     */
    ArrayList<TaiKhoan> danhSachTaiKhoan = new ArrayList<>();
    ArrayList<QuyenTaiKhoan> danhSachQuyenTaiKhoan = new ArrayList<>();
    ArrayList<Quyen> danhSachQuyen = new ArrayList<>();

    QuanLyTaiKhoan_BUS quanLyTaiKhoan = new QuanLyTaiKhoan_BUS();
    QuanLyQuyenTaiKhoan_BUS quanLyQuyenTaiKhoan_Bus = new QuanLyQuyenTaiKhoan_BUS();
    QuanLyQuyen_BUS quanLyQuyen = new QuanLyQuyen_BUS();

    DataTable table = new DataTable();

    public PrivilegeManagementPanel() {
        initComponents();
        modifypanel.setVisible(false);
        cbLoaiTimKiem.removeAllItems();
        cbLoaiTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTableData();
                txtTiemKiem.setBorder(new TitledBorder(cbLoaiTimKiem.getSelectedItem().toString()));
            }
        });
        txtTiemKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                setTableData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setTableData();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                setTableData();
            }
        });
        cbLoaiTimKiem.addItem("Tất cả");
        cbLoaiTimKiem.addItem("Theo tên tài khoản");
        cbLoaiTimKiem.addItem("Theo trạng thái");
        table.setHeaders(new String[]{"Tên tài khoản", "Quyền hạn", "Trạng thái", "Ngày sửa đổi gần nhất"});
        table.setSize(table.getPreferredSize());

        setTableData();
        // Dòng này chỉnh tỉ lệ các cột
        table.setJTableColumnsWidth(table.getWidth(), new double[]{1, 6, 1, 2});
        scrollTable.add(table);
    }
    public void setTableData()
    {  
        int selected = cbLoaiTimKiem.getSelectedIndex();
        table.clear();
        ArrayList dataList = new ArrayList<>();
      dataList=quanLyQuyenTaiKhoan_Bus.getDanhSanhtaiKhoanDaCongQuyen(selected,txtTiemKiem.getText());
      for(int i=0;i<dataList.size();i++)
      {
          table.addRow((Vector) dataList.get(i));
      }
      }
    public void DefaultCheckBox()
    {
      jCheckBox1.setSelected(false);
      jCheckBox2.setSelected(false);
      jCheckBox3.setSelected(false);
    }
    public void timTheoTenDangNhap() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTable = new java.awt.ScrollPane();
        btnSuaQuyen = new javax.swing.JButton();
        txtTiemKiem = new javax.swing.JTextField();
        cbLoaiTimKiem = new javax.swing.JComboBox<>();
        modifypanel = new javax.swing.JPanel();
        accountName = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(710, 546));

        btnSuaQuyen.setText("Sửa quyền");
        btnSuaQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaQuyenActionPerformed(evt);
            }
        });

        txtTiemKiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên tài khoản"));
        txtTiemKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiemKiemActionPerformed(evt);
            }
        });

        cbLoaiTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLoaiTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại tìm kiếm"));

        modifypanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        accountName.setText("jLabel1");

        jCheckBox1.setText("jCheckBox1");

        jCheckBox2.setText("jCheckBox2");

        jCheckBox3.setText("jCheckBox3");

        jCheckBox4.setText("jCheckBox4");

        saveButton.setBackground(new java.awt.Color(255, 51, 51));
        saveButton.setText("Lưu kết quả");
        saveButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel1.setText("Bảng Chỉnh Quyền");

        jLabel2.setText("Tên tài khoản :");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Quyền:");

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Quay lại");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modifypanelLayout = new javax.swing.GroupLayout(modifypanel);
        modifypanel.setLayout(modifypanelLayout);
        modifypanelLayout.setHorizontalGroup(
            modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modifypanelLayout.createSequentialGroup()
                .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(modifypanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(modifypanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, modifypanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(modifypanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(modifypanelLayout.createSequentialGroup()
                                .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox3)
                                    .addGroup(modifypanelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(accountName)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(61, 61, 61))
        );
        modifypanelLayout.setVerticalGroup(
            modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifypanelLayout.createSequentialGroup()
                .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modifypanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1))
                        .addGap(23, 23, 23))
                    .addGroup(modifypanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(accountName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)))
                .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4))
                .addGap(18, 18, 18)
                .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cbLoaiTimKiem, 0, 149, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTiemKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnSuaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(modifypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnSuaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTiemKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLoaiTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTiemKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiemKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiemKiemActionPerformed

    private void btnSuaQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaQuyenActionPerformed
        // TODO add your handling code here:
        modifypanel.setVisible(true);
        DefaultCheckBox();
        DisplayAccountCheckBox(table.getSelectedRow());
    }//GEN-LAST:event_btnSuaQuyenActionPerformed

    // Hiển thị bảng chỉnh sữa quyền
    public void DisplayAccountCheckBox(int indexRow) {
        ArrayList privilegeList = new ArrayList();
        String name;
        jCheckBox1.setText("Tài khoản và quyền");
        jCheckBox2.setText("Bán hàng");
        jCheckBox3.setText("Kho hàng");
        jCheckBox4.setText("Thống kế báo cáo");
        name = quanLyQuyenTaiKhoan_Bus.getAccountName(indexRow) ; // Đã lấy được tên của tài khoản được chọn
        accountName.setText(name);  // đặt tên tài khoản được chọn vào jlable (accountName)
        scrollTable.setVisible(false);
        
        privilegeList = quanLyQuyenTaiKhoan_Bus.getPrivilegeListOfAccount(accountName.getText());  // Đã lấy được các quyền của tài khoản được chọn
        // Hiển thị đã chọn trên các nút checkbox
//       String account_name = qlb.getLoginName(indexRow);
//       accountName.setText(account_name);  // Đặt tên tài khoản tại lable tài khoản
        System.out.println(privilegeList);
        for(int i=0;i<privilegeList.size();i++)
        {
             if(privilegeList.get(i).equals("tài khoản và quyền"))
                     {
                         jCheckBox1.setSelected(true);
                     }
         if(privilegeList.get(i).equals("bán hàng"))
                     {
                         jCheckBox2.setSelected(true);
                     }
        if(privilegeList.get(i).equals("kho hàng"))
                     {
                         jCheckBox3.setSelected(true);
                     }
        if(privilegeList.get(i).equals("thống kê báo cáo"))
                     {
                         jCheckBox3.setSelected(true);
                     }
                     
               
        }

    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<String> result = new ArrayList(); // Mảng lưu danh sách quyền của một tài khoản sau khi chỉnh sửa
        if(jCheckBox1.isSelected()==true)
        {
            result.add(jCheckBox1.getText());
        }  
         if(jCheckBox2.isSelected()==true)
        {
            result.add(jCheckBox2.getText());
        }
         if(jCheckBox3.isSelected()==true)
        {
            result.add(jCheckBox3.getText());
        }
         System.out.println("pri");
         quanLyQuyenTaiKhoan_Bus.updatePrivilegeOfAccount_Bus(result,accountName.getText());
         setTableData();
         scrollTable.setVisible(true);
         modifypanel.setVisible(false);
         
         // cập nhập lại quyền của tài khoản
         
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        modifypanel.setVisible(false);
        scrollTable.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountName;
    private javax.swing.JButton btnSuaQuyen;
    private javax.swing.JComboBox<String> cbLoaiTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel modifypanel;
    private javax.swing.JButton saveButton;
    private java.awt.ScrollPane scrollTable;
    private javax.swing.JTextField txtTiemKiem;
    // End of variables declaration//GEN-END:variables
}