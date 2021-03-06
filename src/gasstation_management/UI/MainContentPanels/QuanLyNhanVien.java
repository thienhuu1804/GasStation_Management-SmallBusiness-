/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gasstation_management.UI.MainContentPanels;

import gasstation_management.BUS.QuanLyQuyenTaiKhoan_BUS;
import gasstation_management.BUS.QuanLyQuyen_BUS;
import gasstation_management.BUS.QuanLyNhanVien_BUS;
import gasstation_management.BUS.QuanLyTaiKhoan_BUS;
import gasstation_management.DTO.Quyen;
import gasstation_management.DTO.NhanVien;
import gasstation_management.DTO.QuyenTaiKhoan;
import gasstation_management.DTO.TaiKhoan;
import gasstation_management.DataTable;
import static gasstation_management.Main.DATETIME_FORMATTER;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Vuong
 */
public class QuanLyNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyPhieuNhap
     */
   ArrayList<TaiKhoan> danhSachTaiKhoan = new ArrayList<>();
    ArrayList<QuyenTaiKhoan> danhSachQuyenTaiKhoan = new ArrayList<>();
    ArrayList<Quyen> danhSachQuyen = new ArrayList<>();

    QuanLyTaiKhoan_BUS quanLyTaiKhoan = new QuanLyTaiKhoan_BUS();
    QuanLyQuyenTaiKhoan_BUS quanLyQuyenTaiKhoan_Bus = new QuanLyQuyenTaiKhoan_BUS();
    QuanLyQuyen_BUS quanLyQuyen = new QuanLyQuyen_BUS();
    QuanLyNhanVien_BUS quanLyNhanVien_Bus = new QuanLyNhanVien_BUS();
    DataTable table = new DataTable();
    public QuanLyNhanVien() {
        initComponents();
        table.setHeaders(new String[]{"Mã nhân viên", "Họ và tên", "SDT", "Địa chỉ","CMND","Trạng thái"});
        table.setSize(table.getPreferredSize());

        setTableData();
        // Dòng này chỉnh tỉ lệ các cột
        table.setJTableColumnsWidth(table.getWidth(), new double[]{1,3,2,4,2,1});
        scrollPane1.add(table);

    }
     public void setTableData()
    {  
//        int selected = cbTimKiem.getSelectedIndex();
        table.clear();
        ArrayList dataList = new ArrayList<>();
      dataList=quanLyNhanVien_Bus.getDanhSanhNhanVien();
     for(int i=0;i<dataList.size();i++)
     {
         table.addRow((Vector) dataList.get(i));
     }
      }
//     public void DefaultCheckBox()
//    {
//      jCheckBox1.setSelected(false);
//      jCheckBox2.setSelected(false);
//      jCheckBox3.setSelected(false);
//    }
    public JDialog showAddFrame(NhanVien nv) {
        Window win = SwingUtilities.getWindowAncestor(this);
        JDialog changePwdDialog = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
//        changePwdDialog.setUndecorated(true);
        
        changePwdDialog.setLayout(new BorderLayout());
        changePwdDialog.setBackground(Color.yellow);

        ThemNhanVien pnlThemNhanVien = new ThemNhanVien(changePwdDialog);
        pnlThemNhanVien.setupThongTin(nv);
        changePwdDialog.setSize(pnlThemNhanVien.getSize());
        changePwdDialog.add(pnlThemNhanVien);
        changePwdDialog.setLocationRelativeTo(this);

        changePwdDialog.setVisible(true);
        return changePwdDialog;
    }
     public JDialog showChangePwdFrame(NhanVien nv,int indexRow) {
        Window win = SwingUtilities.getWindowAncestor(this);
        JDialog changePwdDialog = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
//        changePwdDialog.setUndecorated(true);

        changePwdDialog.setLayout(new BorderLayout());
        changePwdDialog.setBackground(Color.yellow);

        SuaNhanVien pnlSuaNhanVien = new SuaNhanVien(changePwdDialog);
        pnlSuaNhanVien.setupThongTin(nv,indexRow);
        changePwdDialog.setSize(pnlSuaNhanVien.getSize());
        changePwdDialog.add(pnlSuaNhanVien);
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

        btnThemNhanVien = new javax.swing.JButton();
        scrollPane1 = new java.awt.ScrollPane();
        bntSuaNhanVien = new javax.swing.JButton();
        btnXoaNhanVien = new javax.swing.JButton();

        btnThemNhanVien.setText("Thêm nhân viên");
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        bntSuaNhanVien.setText("Sửa nhân viên");
        bntSuaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSuaNhanVienActionPerformed(evt);
            }
        });

        btnXoaNhanVien.setText("Xóa nhân viên");
        btnXoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnThemNhanVien)
                        .addGap(58, 58, 58)
                        .addComponent(bntSuaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnXoaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntSuaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanVienActionPerformed

            NhanVien nv = new NhanVien();
            JDialog dl = showAddFrame(nv);
            dl.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    setTableData();
                }
            });           
    }//GEN-LAST:event_btnThemNhanVienActionPerformed

    private void bntSuaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSuaNhanVienActionPerformed
        // TODO add your handling code here:
        
         int indexRow = table.getTable().getSelectedRow();
        if (table.getTable().getSelectedRow() >= 0) {
            NhanVien nv = new NhanVien();
            nv.setManv(table.getTable().getValueAt(indexRow, 0).toString());
            nv.setTennv(table.getTable().getValueAt(indexRow, 1).toString());
            nv.setDiachi(table.getTable().getValueAt(indexRow, 2).toString());

            nv.setSdt(table.getTable().getValueAt(indexRow, 3).toString());
            nv.setCmnd((table.getTable().getValueAt(indexRow, 4).toString()));
          nv.setTrangthai(table.getTable().getValueAt(indexRow, 5).toString());
           JDialog dl = showChangePwdFrame(nv,indexRow);
            dl.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    setTableData();
                }
            });  
    }//GEN-LAST:event_bntSuaNhanVienActionPerformed
    }
    private void btnXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhanVienActionPerformed
        // TODO add your handling code here:
        
        NhanVien nv = new NhanVien();
                  int indexRow = table.getTable().getSelectedRow();
         nv.setManv(table.getTable().getValueAt(indexRow, 0).toString());
         int result = JOptionPane.showConfirmDialog(null,
                "Bạn có muốn xóa không?", "Xác nhận xóa nhân viên ",
                JOptionPane.YES_NO_OPTION);
              if (result == JOptionPane.YES_OPTION) {

              quanLyNhanVien_Bus.deleleNhanVien(nv.getManv());
               setTableData();
                 }
               else if (result == JOptionPane.NO_OPTION) {
//            changePwdDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//             owner.dispose();
           }
         


    }//GEN-LAST:event_btnXoaNhanVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSuaNhanVien;
    private javax.swing.JButton btnThemNhanVien;
    private javax.swing.JButton btnXoaNhanVien;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
