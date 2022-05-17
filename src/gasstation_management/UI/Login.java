/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gasstation_management.UI;

import gasstation_management.BUS.QuanLyQuyenTaiKhoan_BUS;
import gasstation_management.BUS.QuanLyTaiKhoan_BUS;
import gasstation_management.DAO.QuanLyTaiKhoan_DAO;
import gasstation_management.DBConnect;
import gasstation_management.DTO.TaiKhoan;
import gasstation_management.UI.MainContentPanels.PrivilegeManagementPanel;
import gasstation_management.UI.MainContentPanels.QuanLyTaiKhoan;
import gasstation_management.UI.Shared.MainPanel;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Utech
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Login() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        txUsername = new javax.swing.JTextField();
        txPassword = new javax.swing.JPasswordField();
        btExit = new javax.swing.JButton();
        btLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tài khoản");

        jLabel2.setText("Mật khẩu");

        btExit.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\poly-sv\\src\\main\\resources\\com\\mycompany\\poly\\sv\\icons\\Button-Close-icon-16.png")); // NOI18N
        btExit.setText("Thoát");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        btLogin.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\poly-sv\\src\\main\\resources\\com\\mycompany\\poly\\sv\\icons\\10207-man-student-light-skin-tone-icon-16.png")); // NOI18N
        btLogin.setText("Đăng nhập");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btLogin)
                                                .addGap(18, 18, 18)
                                                .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addGap(39, 39, 39)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 64, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btExit)
                                        .addComponent(btLogin))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btExitActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        String userName = txUsername.getText();
        String passWord = String.valueOf(txPassword.getPassword());

        if (userName.equals("") || passWord.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ tài khoản và mật khẩu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                QuanLyTaiKhoan_BUS bus = new QuanLyTaiKhoan_BUS();
                TaiKhoan account = bus.checkLogin(userName, passWord);
                if (account == null) {
                    JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập hoặc mật khẩu sai", "Lỗi đăng nhập", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    this.dispose();
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    frame.setLayout(new BorderLayout());

                    MainPanel pnlMain = new MainPanel();
//        pnlMain.setLayout(new BorderLayout());
                    pnlMain.setVisible(true);
                    //Làm gì thì add giao diện đó vào pnlMain
//        PrivilegeManagementPanel privPanel = new PrivilegeManagementPanel();
//        privPanel.setSize(privPanel.getPreferredSize());
//        DanhSachQuyen_GUI test = new DanhSachQuyen_GUI();
//        test.setSize(test.getPreferredSize());
                    PrivilegeManagementPanel ui_qltk = new PrivilegeManagementPanel();
                    ui_qltk.setSize(ui_qltk.getPreferredSize());

                    pnlMain.getPnlMainContent().add(ui_qltk);
                    frame.setSize(pnlMain.getPreferredSize());
                    frame.setLocationRelativeTo(null);
                    frame.add(pnlMain);
                    frame.setVisible(true);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_btLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExit;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txPassword;
    private javax.swing.JTextField txUsername;
    // End of variables declaration//GEN-END:variables
}
