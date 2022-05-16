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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
//        setSize(710, 546);
//        table.setSize(scrollTable.getSize());
        System.out.println(scrollTable.getSize());

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
        table.getTable().setAutoCreateRowSorter(true);
        //https://stackoverflow.com/questions/10128064/jtable-selected-row-click-event
        table.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                //https://stackoverflow.com/questions/12461627/jlist-fires-valuechanged-twice-when-a-value-is-changed-via-mouse
                if (!event.getValueIsAdjusting()) {
                    if (table.getTable().getSelectedRow() > -1) {
                        // print first column value from selected row
                        System.out.println(table.getTable().getSelectedRow());
                    }
                }
            }
        });
        scrollTable.add(table);
    }

    public JDialog showChangePwdFrame(TaiKhoan tk) {
        Window win = SwingUtilities.getWindowAncestor(this);
        JDialog changePwdDialog = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
        changePwdDialog.setUndecorated(true);

        changePwdDialog.setLayout(new BorderLayout());
        changePwdDialog.setBackground(Color.yellow);

        DoiMatKhau pnlDoiMatKhau = new DoiMatKhau(changePwdDialog);
        pnlDoiMatKhau.setupThongTin(tk);
        changePwdDialog.setSize(pnlDoiMatKhau.getSize());
        changePwdDialog.add(pnlDoiMatKhau);
        changePwdDialog.setLocationRelativeTo(this);

        changePwdDialog.setVisible(true);
        return changePwdDialog;
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
                    if (e.getStateChange() == e.SELECTED) {
                        System.out.println(c.getSelectedItem().toString());
                    }
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
        btnSuaTaiKhoan = new javax.swing.JButton();
        btnThemTaiKhoan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlTimKiem = new javax.swing.JPanel();
        txtTiemKiem = new javax.swing.JTextField();
        cbLoaiTimKiem = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(710, 546));

        scrollTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollTable.setMinimumSize(new java.awt.Dimension(0, 0));
        scrollTable.setPreferredSize(new java.awt.Dimension(690, 388));

        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        btnSuaTaiKhoan.setText("Sửa tài khoản");
        btnSuaTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTaiKhoanActionPerformed(evt);
            }
        });

        btnThemTaiKhoan.setText("Thêm tài khoản");
        btnThemTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTaiKhoanActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh Sách Tài Khoản");

        txtTiemKiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên tài khoản"));
        txtTiemKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiemKiemActionPerformed(evt);
            }
        });

        cbLoaiTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLoaiTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại tìm kiếm"));

        javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
        pnlTimKiem.setLayout(pnlTimKiemLayout);
        pnlTimKiemLayout.setHorizontalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbLoaiTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTiemKiem))
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTiemKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLoaiTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(pnlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSuaTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTiemKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiemKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiemKiemActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // test
        int selectedRow = table.getTable().getSelectedRow();
        if (table.getTable().getSelectedRow() >= 0) {
            TaiKhoan tk = new TaiKhoan();
            tk.setTenDangNhap(table.getTable().getValueAt(selectedRow, 0).toString());
            tk.setMaNV(table.getTable().getValueAt(selectedRow, 1).toString());
            tk.setMatKhau((table.getTable().getValueAt(selectedRow, 2).toString()));
            tk.setNgayTao(LocalDateTime.parse(table.getTable().getValueAt(selectedRow, 3).toString(), DATETIME_FORMATTER));
            tk.setTrangThai(table.getTable().getValueAt(selectedRow, 4).toString());
            JDialog dl = showChangePwdFrame(tk);
            dl.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    setTableData();
                }
            });
        }
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnSuaTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaTaiKhoanActionPerformed

    private void btnThemTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemTaiKhoanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnSuaTaiKhoan;
    private javax.swing.JButton btnThemTaiKhoan;
    private javax.swing.JComboBox<String> cbLoaiTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlTimKiem;
    private java.awt.ScrollPane scrollTable;
    private javax.swing.JTextField txtTiemKiem;
    // End of variables declaration//GEN-END:variables
}
