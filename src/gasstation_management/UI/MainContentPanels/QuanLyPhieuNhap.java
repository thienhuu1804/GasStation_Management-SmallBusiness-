/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gasstation_management.UI.MainContentPanels;

import gasstation_management.DataTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import gasstation_management.BUS.QuanLyPhieuNhap_BUS;
import gasstation_management.DTO.NhanVien;
import gasstation_management.DTO.PhieuNhap;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import gasstation_management.XuatExcel;

/**
 *
 * @author Vuong
 */
public class QuanLyPhieuNhap extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyPhieuNhap
     */
    QuanLyPhieuNhap_BUS quanLyPhieuNhap_BUS = new QuanLyPhieuNhap_BUS();
        DataTable table = new DataTable();

    public QuanLyPhieuNhap() {
        initComponents();
        cbbTimKiem.removeAllItems();
        cbbTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTableData();
                txtTimKiem.setBorder(new TitledBorder(cbbTimKiem.getSelectedItem().toString()));
            }
        });
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
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
        cbbTimKiem.addItem("Tất cả");
        cbbTimKiem.addItem("Theo mã phiếu nhập ");
        cbbTimKiem.addItem("Theo mã sản phẩm");
        cbbTimKiem.addItem("Theo trạng thái");
        table.setHeaders(new String[]{"STT","Mã PN", "Mã sp", "Số lượng","Ngay Tạo","Trạng thái","Tổng tiền"});
        table.setSize(table.getPreferredSize());
        table.getTable().setAutoCreateRowSorter(true);


        setTableData();
        // Dòng này chỉnh tỉ lệ các cột
        table.setJTableColumnsWidth(table.getWidth(), new double[]{0.5,1,1,1,2,1,2});
        scrollTable.add(table);
    }
public void setTableData()
    {  
    // Do something with sqldate

        int selected = cbbTimKiem.getSelectedIndex();
        if(selected==0)
        {
            txtTimKiem.setEditable(false);
        }
        if(selected==1)
        {
            txtTimKiem.setEditable(true);
        }
        if(selected==2)
        {
                        txtTimKiem.setEditable(true);

        }
        table.clear();
        ArrayList dataList = new ArrayList<>();
      dataList=quanLyPhieuNhap_BUS.getDanhSanhPhieuNhap(selected,txtTimKiem.getText());
      for(int i=0;i<dataList.size();i++)
      { 
          table.addRow((Vector) dataList.get(i));
      }
      }
 public JDialog showChangePwdFrame(String mapn) {
        Window win = SwingUtilities.getWindowAncestor(this);
        JDialog changePwdDialog = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
//        changePwdDialog.setUndecorated(true);

        changePwdDialog.setLayout(new BorderLayout());
        changePwdDialog.setBackground(Color.yellow);
        DetailPhieuNhap pnlXemChiTietPhieuNhap = new DetailPhieuNhap(changePwdDialog,mapn);
        changePwdDialog.setSize(pnlXemChiTietPhieuNhap.getSize());
        changePwdDialog.add(pnlXemChiTietPhieuNhap);
        changePwdDialog.setLocationRelativeTo(this);

        changePwdDialog.setVisible(true);
        return changePwdDialog;
    }
 public JDialog showAddPNPwdFrame() {
        Window win = SwingUtilities.getWindowAncestor(this);
        JDialog changePwdDialog = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
//        changePwdDialog.setUndecorated(true);

        changePwdDialog.setLayout(new BorderLayout());
        changePwdDialog.setBackground(Color.yellow);
        ThemPhieuNhap tpn = new ThemPhieuNhap(changePwdDialog);
        changePwdDialog.setSize(tpn.getSize());
        changePwdDialog.add(tpn);
        changePwdDialog.setLocationRelativeTo(this);

        changePwdDialog.setVisible(true);
        return changePwdDialog;
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
        cbbTimKiem = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnXemChiTiet = new javax.swing.JButton();
        btnThemPhieuNhap = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại tìm kiếm"));
        cbbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Phiếu Nhập");

        txtTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Từ khóa tìm kiếm"));

        btnXemChiTiet.setText("Xem Chi tiết");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        btnThemPhieuNhap.setText("Thêm phiếu nhập");
        btnThemPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPhieuNhapActionPerformed(evt);
            }
        });

        jButton1.setText("Xuất Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 43, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton1)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXemChiTiet)
                                    .addComponent(btnThemPhieuNhap))
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThemPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(37, 37, 37)))
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTimKiemActionPerformed

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        // TODO add your handling code here:
        
             int indexRow = table.getTable().getSelectedRow();
             String mapn = (table.getTable().getValueAt(indexRow, 1).toString());
             System.out.println(mapn);

            JDialog dl = showChangePwdFrame(mapn);
            dl.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    setTableData();
                }
            });        
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnThemPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPhieuNhapActionPerformed
        // TODO add your handling code here:
        

            JDialog dl = showAddPNPwdFrame();
            dl.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    setTableData();
                }
            });   
    }//GEN-LAST:event_btnThemPhieuNhapActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int rowCount =table.getTable().getRowCount();
        XuatExcel xexcel = new XuatExcel();
        Vector<String> indexMapn= new Vector<>();
        System.out.println(rowCount);
        for(int i=0;i<rowCount;i++)
        {
            indexMapn.add(table.getTable().getValueAt(i, 1).toString());
        }
        xexcel.xuatFilePhieuNhap(indexMapn);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemPhieuNhap;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JComboBox<String> cbbTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private java.awt.ScrollPane scrollTable;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
