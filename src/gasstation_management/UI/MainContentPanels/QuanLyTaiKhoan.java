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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author nguye
 */
public class QuanLyTaiKhoan extends javax.swing.JPanel {

    /**
     * Creates new form AccountManagementPanel
     */
    ArrayList<TaiKhoan> danhSachTaiKhoan = new ArrayList<>();
    ArrayList<QuyenTaiKhoan> danhSachQuyenTaiKhoan = new ArrayList<>();
    ArrayList<Quyen> danhSachQuyen = new ArrayList<>();

    QuanLyTaiKhoan_BUS quanLyTaiKhoan = new QuanLyTaiKhoan_BUS();
    QuanLyQuyenTaiKhoan_BUS quanLyQuyenTaiKhoan = new QuanLyQuyenTaiKhoan_BUS();
    QuanLyQuyen_BUS quanLyQuyen = new QuanLyQuyen_BUS();

    DataTable table = new DataTable();

    public QuanLyTaiKhoan() {
        initComponents();

        cbLoaiTimKiem.removeAllItems();
        cbLoaiTimKiem.addItem("Tất cả");
        cbLoaiTimKiem.addItem("Theo tên tài khoản");
        cbLoaiTimKiem.addItem("Theo trạng thái");
        table.setHeaders(new String[]{"Tên tài khoản", "Mã nhân viên", "Mật khẩu", "Ngày tạo", "Trạng thái"});
        cbLoaiTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTableData();
            }
        });

//        cbTrangThai.removeAllItems();
//        cbTrangThai.addItem("Active");
//        cbTrangThai.addItem("Inactive");
//        cbTrangThai.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setTableData();
//            }
//        });

        
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
        table.setSize(table.getPreferredSize());

        setTableData();
        // Dòng này chỉnh tỉ lệ các cột
        table.setJTableColumnsWidth(table.getWidth(), new double[]{1, 1, 3, 3, 1});
        scrollTable.add(table);
    }

    public void setTableData() {
        int selected = cbLoaiTimKiem.getSelectedIndex();
        table.clear();
        danhSachQuyenTaiKhoan = quanLyQuyenTaiKhoan.getDanhSachQuyenTaiKhoan();
        danhSachQuyen = quanLyQuyen.QuyenAll();
        if (selected == 0) {
            danhSachTaiKhoan = quanLyTaiKhoan.getDanhSachTaiKhoan();
        }
        if (selected == 1) {
            danhSachTaiKhoan = quanLyTaiKhoan.timKiemTheoTenDangNhap(txtTiemKiem.getText());
        }
        if (selected == 2) {
            danhSachTaiKhoan = quanLyTaiKhoan.timKiemTheoTrangThai(txtTiemKiem.getText());
        }

        // Setdata vào table
        for (TaiKhoan taiKhoan : danhSachTaiKhoan) {
            JComboBox cb = new JComboBox();
            cb.addItem("Active");
            cb.addItem("Inactive");
            Vector row = new Vector();
            row.add(taiKhoan.getTenDangNhap());
            row.add(taiKhoan.getMaNV());
            row.add(taiKhoan.getMatKhau());
            row.add(taiKhoan.getNgayTao().format(DATETIME_FORMATTER));
            cb.setSelectedIndex(taiKhoan.getTrangThai().equalsIgnoreCase("Active") ? 0 : 1);
            cb.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    JComboBox c = (JComboBox) e.getSource();
                    if(e.getStateChange() == e.SELECTED )
                    System.out.println(c.getSelectedItem().toString());
                }
            });
            table.getTable().getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(cb));
//            table.getTable().setColumnSelectionAllowed(true);
            row.add(taiKhoan.getTrangThai());
            table.addRow(row);
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

        scrollTable = new java.awt.ScrollPane();
        btnDoiMatKhau = new javax.swing.JButton();
        txtTiemKiem = new javax.swing.JTextField();
        cbLoaiTimKiem = new javax.swing.JComboBox<>();
        cbTrangThai = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(710, 546));

        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
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

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(cbLoaiTimKiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTiemKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTiemKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLoaiTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTiemKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiemKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiemKiemActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // test
        System.out.println(table.getTable().getValueAt(table.getTable().getSelectedRow(), 4));
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JComboBox<String> cbLoaiTimKiem;
    private javax.swing.JComboBox<String> cbTrangThai;
    private java.awt.ScrollPane scrollTable;
    private javax.swing.JTextField txtTiemKiem;
    // End of variables declaration//GEN-END:variables
}
