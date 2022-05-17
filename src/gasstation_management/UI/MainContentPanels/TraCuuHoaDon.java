/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gasstation_management.UI.MainContentPanels;

import gasstation_management.BUS.QuanLyQuyenTaiKhoan_BUS;
import gasstation_management.BUS.QuanLyQuyen_BUS;
import gasstation_management.BUS.TraCuuHoaDon_BUS;
import gasstation_management.BUS.QuanLyTaiKhoan_BUS;
import gasstation_management.DTO.HoaDon;
import gasstation_management.DTO.NhanVien;
import gasstation_management.DTO.Quyen;
import gasstation_management.DTO.QuyenTaiKhoan;
import gasstation_management.DTO.TaiKhoan;
import gasstation_management.DataTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import gasstation_management.UI.MainContentPanels.DetailHoaDon;
import gasstation_management.XuatExcel;

/**
 *
 * @author Vuong
 */
public class TraCuuHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form TraCuuHoaDon
     */
    ArrayList<TaiKhoan> danhSachTaiKhoan = new ArrayList<>();
    ArrayList<QuyenTaiKhoan> danhSachQuyenTaiKhoan = new ArrayList<>();
    ArrayList<Quyen> danhSachQuyen = new ArrayList<>();

    QuanLyTaiKhoan_BUS quanLyTaiKhoan = new QuanLyTaiKhoan_BUS();
    QuanLyQuyenTaiKhoan_BUS quanLyQuyenTaiKhoan_Bus = new QuanLyQuyenTaiKhoan_BUS();
    QuanLyQuyen_BUS quanLyQuyen = new QuanLyQuyen_BUS();
    TraCuuHoaDon_BUS traCuuHoaDon_BUS = new TraCuuHoaDon_BUS();

    DataTable table = new DataTable();
    public TraCuuHoaDon() {
        initComponents();
//        modifypanel.setVisible(false);
        cbbTimkiem.removeAllItems();
        cbbTimkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTableData();
                txtTimkiem.setBorder(new TitledBorder(cbbTimkiem.getSelectedItem().toString()));
            }
        });
        txtTimkiem.getDocument().addDocumentListener(new DocumentListener() {
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
        cbbTimkiem.addItem("Tất cả");
        cbbTimkiem.addItem("Theo mã hóa đơn ");
        cbbTimkiem.addItem("Theo mã sản phẩm");
        table.setHeaders(new String[]{"STT","Mã hd", "Mã tb", "Mã sp", "Ngay Tạo","Số lượng","Tổng tiền"});
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

        int selected = cbbTimkiem.getSelectedIndex();
        if(selected==0)
        {
            txtTimkiem.setEditable(false);
        }
        if(selected==1)
        {
            txtTimkiem.setEditable(true);
        }
        if(selected==2)
        {
            txtTimkiem.setEditable(true);

        }
        table.clear();
        ArrayList dataList = new ArrayList<>();
      dataList=traCuuHoaDon_BUS.getDanhSanhHoaDon(selected,txtTimkiem.getText(),dateStart.getDate(),dateEnd.getDate());
      for(int i=0;i<dataList.size();i++)
      { 
          table.addRow((Vector) dataList.get(i));
      }
      }
 public JDialog showChangePwdFrame(String mahd) {
        Window win = SwingUtilities.getWindowAncestor(this);
        JDialog changePwdDialog = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
//        changePwdDialog.setUndecorated(true);

        changePwdDialog.setLayout(new BorderLayout());
        changePwdDialog.setBackground(Color.yellow);
       System.out.println(mahd);
        DetailHoaDon pnlXemChiTietHoaDon = new DetailHoaDon(changePwdDialog,mahd);
        changePwdDialog.setSize(pnlXemChiTietHoaDon.getSize());
        changePwdDialog.add(pnlXemChiTietHoaDon);
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
        cbbTimkiem = new javax.swing.JComboBox<>();
        txtTimkiem = new javax.swing.JTextField();
        btnXemChiTiet = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        dateStart = new com.toedter.calendar.JDateChooser();
        dateEnd = new com.toedter.calendar.JDateChooser();
        btnXuatExcel = new javax.swing.JButton();

        cbbTimkiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTimkiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại Tìm kiếm"));
        cbbTimkiem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTimkiemItemStateChanged(evt);
            }
        });
        cbbTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimkiemActionPerformed(evt);
            }
        });

        txtTimkiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Tất cã"));

        btnXemChiTiet.setText("Xem chi tiết");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        dateStart.setBorder(javax.swing.BorderFactory.createTitledBorder("Từ ngày"));
        dateStart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateStartPropertyChange(evt);
            }
        });

        dateEnd.setBorder(javax.swing.BorderFactory.createTitledBorder("Đến ngày"));
        dateEnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateEndPropertyChange(evt);
            }
        });

        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbbTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReset)
                                .addGap(0, 44, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnXuatExcel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXemChiTiet)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnReset))
                            .addComponent(dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXuatExcel)))
                    .addComponent(cbbTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dateStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateStartPropertyChange
        // TODO add your handling code here:
        setTableData();
    
    }//GEN-LAST:event_dateStartPropertyChange

    private void dateEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateEndPropertyChange
     setTableData();
    }//GEN-LAST:event_dateEndPropertyChange

    private void cbbTimkiemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTimkiemItemStateChanged
        // TODO add your handling code here:
       dateStart.setCalendar(null);
       dateEnd.setCalendar(null);
       txtTimkiem.setText("");
    }//GEN-LAST:event_cbbTimkiemItemStateChanged

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        dateStart.setCalendar(null);
       dateEnd.setCalendar(null);
       setTableData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        // TODO add your handling code here:
        
        
         HoaDon hd = new HoaDon();
         
         
         
         int indexRow = table.getTable().getSelectedRow();
         hd.setMahd(table.getTable().getValueAt(indexRow, 1).toString());

            JDialog dl = showChangePwdFrame(hd.getMahd());
            dl.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    setTableData();
                }
            }); 
        
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        // TODO add your handling code here:
        int rowCount =table.getTable().getRowCount();
        XuatExcel xexcel = new XuatExcel();
        Vector<String> indexMahd= new Vector<>();
        System.out.println(rowCount);
        for(int i=0;i<rowCount;i++)
        {
            indexMahd.add(table.getTable().getValueAt(i, 1).toString());
        }
        xexcel.xuatFileExcelChiTietHoaDon(indexMahd);
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void cbbTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTimkiemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cbbTimkiem;
    private com.toedter.calendar.JDateChooser dateEnd;
    private com.toedter.calendar.JDateChooser dateStart;
    private java.awt.ScrollPane scrollTable;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}

