/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gasstation_management.UI;

import gasstation_management.BUS.DanhSachQuyen_BUS;
import gasstation_management.DBConnect;
import gasstation_management.DTO.DanhSachQuyen_DTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class DanhSachQuyen_GUI extends javax.swing.JPanel {

    /**
     * Creates new form PowerList
     */
    public DanhSachQuyen_GUI() {
        initComponents();
        loadQuyenAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Quyen", "Mo Ta Quyen"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(534, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
 public void loadQuyenAll(){
        String[] header = {"Quyen","Mo Ta Quyen"};
        DefaultTableModel dtm = new DefaultTableModel(header,0);
        ArrayList<DanhSachQuyen_DTO> arr = new ArrayList<DanhSachQuyen_DTO>();
        arr = DanhSachQuyen_BUS.QuyenAll();
        DanhSachQuyen_DTO quyen = new DanhSachQuyen_DTO();
        for(int i = 0; i < arr.size(); i++){
            quyen = arr.get(i);            
            String MaQuyen = quyen.getMaQuyen();
            String MoTaQuyen = quyen.getMoTaQuyen();
            Object[] row = {MaQuyen,MoTaQuyen};
            dtm.addRow(row);
        }
        jTable1.setModel(dtm);
}
}
