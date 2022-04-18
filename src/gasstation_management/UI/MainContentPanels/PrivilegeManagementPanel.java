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
import static gasstation_management.Main.DATETIME_FORMATTER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
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

        accountName.setText("jLabel1");

        jCheckBox1.setText("jCheckBox1");

        jCheckBox2.setText("jCheckBox2");

        jCheckBox3.setText("jCheckBox3");

        jCheckBox4.setText("jCheckBox4");

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Lưu kết quả");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modifypanelLayout = new javax.swing.GroupLayout(modifypanel);
        modifypanel.setLayout(modifypanelLayout);
        modifypanelLayout.setHorizontalGroup(
            modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifypanelLayout.createSequentialGroup()
                .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modifypanelLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(accountName))
                    .addGroup(modifypanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(modifypanelLayout.createSequentialGroup()
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox4))
                            .addGroup(modifypanelLayout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(43, 43, 43)
                                .addComponent(jCheckBox2))))
                    .addGroup(modifypanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        modifypanelLayout.setVerticalGroup(
            modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifypanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modifypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(10, Short.MAX_VALUE))
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
                    .addComponent(modifypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTiemKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnSuaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
//               accountName.setText("Vuong");
        DisplayAccountCheckBox(table.getIndexRow());
    }//GEN-LAST:event_btnSuaQuyenActionPerformed

    public void DisplayAccountCheckBox(int indexRow) {
        ArrayList list = new ArrayList();
        jCheckBox1.setText("deptrai");
        jCheckBox2.setText("hathay");
        jCheckBox3.setText("dagioi");
        String[] power = {"deptrai", "hathay",};
        list = quanLyQuyenTaiKhoan_Bus.PrivilegeListAccountSelected(indexRow);  // Đã lấy được các quyền của tài khoản được chọn
        // Hiển thị đã chọn trên các nút checkbox
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JPanel modifypanel;
    private java.awt.ScrollPane scrollTable;
    private javax.swing.JTextField txtTiemKiem;
    // End of variables declaration//GEN-END:variables
}
