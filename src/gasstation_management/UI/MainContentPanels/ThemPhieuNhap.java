/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gasstation_management.UI.MainContentPanels;

import gasstation_management.BUS.QuanLyPhieuNhap_BUS;
import gasstation_management.DTO.NhanVien;
import gasstation_management.DTO.PhieuNhap;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Vuong
 */
public class ThemPhieuNhap extends javax.swing.JPanel {

    /**
     * Creates new form ThemPhieuNhap
     */
    QuanLyPhieuNhap_BUS quanLyPhieuNhap_BUS = new QuanLyPhieuNhap_BUS();
    JDialog owner = null;

    public ThemPhieuNhap(JDialog owner) {
        this.owner = owner;
        setSize(new Dimension(700, 400));
        ArrayList<String> listItem = new ArrayList();
        listItem = quanLyPhieuNhap_BUS.getManv();

        initComponents();

        cbTrangThai.removeAllItems();
        cbTrangThai.addItem("Đã thanh toán");
        cbTrangThai.addItem("Chưa thanh toán");
        txtMapn.setEditable(false);
        txtTongTien.setEditable(false);

        cbbManv.removeAllItems();
        for (String i : listItem) {
            cbbManv.addItem(i);
        }
        listItem = quanLyPhieuNhap_BUS.getMasp();
        cbbMasp.removeAllItems();
        for (String i : listItem) {
            cbbMasp.addItem(i);
        }
        cbbMancc.removeAllItems();
        listItem = quanLyPhieuNhap_BUS.getMancc();
        for (String i : listItem) {
            cbbMancc.addItem(i);
        }
        LocalDateTime now = LocalDateTime.now();
        txtNgayTao.setText(now.format(DateTimeFormatter.ofPattern("hh:mm:ss dd-MM-yyy")));
        ArrayList<Vector> dspn_temp = quanLyPhieuNhap_BUS.getDanhSanhPhieuNhap(0, "");
        int newNumb = Integer.parseInt(dspn_temp.get(dspn_temp.size() - 1).get(1).toString().split("PN")[1]) + 1;
        txtMapn.setText("PN" + newNumb);

        txtGiaNhap.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                autoSum();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                autoSum();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                autoSum();
            }
        });
        txtSL.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                autoSum();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                autoSum();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                autoSum();
            }
        });
    }

    public void CheckInfor() {
        PhieuNhap pn = new PhieuNhap();
        String mapn = txtMapn.getText();
        String masp = (String) cbbMasp.getSelectedItem();
        String manv = (String) cbbManv.getSelectedItem();
        String mancc = (String) cbbMancc.getSelectedItem();
        String ngaytao = txtNgayTao.getText();
        String trangthai = cbTrangThai.getSelectedItem().toString();
        String SL = txtSL.getText();
        String gianhap = txtGiaNhap.getText();
        String tongtien = txtTongTien.getText();
        ArrayList<String> arrInput = new ArrayList();

        arrInput.add(mapn);
        arrInput.add(masp);
        arrInput.add(manv);
        arrInput.add(mancc);
        arrInput.add(ngaytao);
        arrInput.add(SL);
        arrInput.add(gianhap);
        arrInput.add(tongtien);
        arrInput.add(trangthai);

        Boolean flag = true;
        // Kiểm tra và hiển thị thông báo nhập sai, lỗi
        if (mapn.equals("") || masp.equals("") || manv.equals("") || mancc.equals("") || ngaytao.equals("") || trangthai.equals("") || SL.equals("") || gianhap.equals("") || tongtien.equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            pn.setMapn(mapn);
            flag = false;

        } else {
            pn.setMapn(mapn);
            pn.setMasp(masp);
            pn.setManv(manv);
            pn.setMancc(mancc);
            pn.setNgaytao(ngaytao);
            pn.setSoluong(Integer.parseInt(SL));
            pn.setGianhap(Integer.parseInt(gianhap));
            pn.setTrangthai(trangthai);
            pn.setTongtien(Integer.toString(Integer.parseInt(SL) * Integer.parseInt(gianhap)));
            Boolean ma = quanLyPhieuNhap_BUS.checkMapn(mapn);

            //Kiểm tra có trùng mã phiếu nhập có trùng không,  nếu thõa thì lưu vào hệ thống
            if (flag == true) {
                if (ma == false) {
                    JOptionPane.showMessageDialog(null, "Mã phi đã tồn tại");
                } else {
                    int result = JOptionPane.showConfirmDialog(null,
                            "Bạn có muốn thêm không?", "Xác nhận thêm ",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {

                        quanLyPhieuNhap_BUS.addPhieuNhap_BUS(pn);
                        owner.dispose();
                    } else if (result == JOptionPane.NO_OPTION) {
//            changePwdDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//             owner.dispose();
                    }
                }
            }
        }

    }

    private boolean autoSum() {
        try {
            int soLuong = Integer.parseInt(txtSL.getText());
            int gia = Integer.parseInt(txtGiaNhap.getText());
            int sum = soLuong * gia;
            txtTongTien.setText(String.valueOf(sum));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMapn = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbbMasp = new javax.swing.JComboBox<>();
        cbbManv = new javax.swing.JComboBox<>();
        cbbMancc = new javax.swing.JComboBox<>();
        addPhieuNhap = new javax.swing.JButton();
        cbTrangThai = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm Phiếu nhập hàng");

        jLabel2.setText("Mã Phiếu nhập:");

        jLabel3.setText("Ngày tạo");

        jLabel4.setText("Mã sản phẩm");

        jLabel5.setText("Trạng thái");

        jLabel6.setText("Mã nhân viên:");

        jLabel7.setText("Số lượng:");

        jLabel8.setText("Mã nhà cung cấp:");

        jLabel9.setText("Tổng tiền:");

        jLabel10.setText("Giá Nhập:");

        cbbMasp.setEditable(true);
        cbbMasp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbManv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbManv.setBorder(null);

        cbbMancc.setEditable(true);
        cbbMancc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addPhieuNhap.setText("Thêm phiếu nhập");
        addPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPhieuNhapActionPerformed(evt);
            }
        });

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMapn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbManv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbMancc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(55, 55, 55)
                        .addComponent(cbbMasp, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addComponent(txtNgayTao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSL)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(cbTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(addPhieuNhap)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtMapn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(cbbMasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cbbMancc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)))
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(addPhieuNhap)
                .addGap(29, 29, 29))
        );

        cbbMancc.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void addPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPhieuNhapActionPerformed
        // TODO add your handling code here:
        CheckInfor();
    }//GEN-LAST:event_addPhieuNhapActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPhieuNhap;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JComboBox<String> cbbMancc;
    private javax.swing.JComboBox<String> cbbManv;
    private javax.swing.JComboBox<String> cbbMasp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMapn;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
