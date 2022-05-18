/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.UI.Shared;

import gasstation_management.UI.MainContentPanels.PrivilegeManagementPanel;
import gasstation_management.UI.MainContentPanels.QuanLyNhaCungCap;
import gasstation_management.UI.MainContentPanels.QuanLyNhanVien;
import gasstation_management.UI.MainContentPanels.QuanLyPhieuNhap;
import gasstation_management.UI.MainContentPanels.QuanLySanPham;
import gasstation_management.UI.MainContentPanels.QuanLyTaiKhoan;
import gasstation_management.UI.MainContentPanels.ThongKeBaoCao;
import gasstation_management.UI.MainContentPanels.TraCuuHoaDon;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nguye
 */
public class SideMenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form SideMenuPanel
     */
    private int bottomPos = 0;
    private ArrayList<JButton> navItems = new ArrayList<>();
    int BUTTON_HEIGHT = 52;
    int HEIGHT = 800;
    int WIDTH = 177;
    JPanel showingPanel;
    JPanel pnlContent;
    JFrame mainFrame;

    public SideMenuPanel( JFrame frame, JPanel pnlContent) {
        initComponents();
        setLayout(null);
        setBounds(new Rectangle(0, 0, WIDTH, HEIGHT));
//        this.pnlContent = pnlContent;
        this.mainFrame = frame;
        this.pnlContent = pnlContent;
        createMenuButtons();
    }

    public void addItem(JButton item, boolean fullWidth) {
        if (fullWidth) {
            item.setBounds(0, bottomPos, WIDTH, BUTTON_HEIGHT);
        } else {
            item.setLocation(item.getBounds().x, item.getBounds().y);
        }

        bottomPos += item.getHeight();
        navItems.add(item); // add to arraylist
        add(item); // add to jpanel
    }

    private void createMenuButtons() {
        JButton btnHoaDon = new JButton("Hoá Đơn");
        btnHoaDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new TraCuuHoaDon();
                showingPanel.setSize(showingPanel.getPreferredSize());
                showingPanel.setVisible(true);
                pnlContent.removeAll();
                pnlContent.add(showingPanel); 
                mainFrame.revalidate();
                mainFrame.repaint();
//                mainFrame.pack();
                
            }
        });
        
        JButton btnPhieuNhap = new JButton("Phiếu nhập");
        btnPhieuNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new QuanLyPhieuNhap();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        JButton btnSanPham = new JButton("Sản phẩm");
        btnSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new QuanLySanPham();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        JButton btnTaiKhoan = new JButton("Tài khoản");
        btnTaiKhoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new QuanLyTaiKhoan();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        JButton btnPhanQuyen = new JButton("Phân quyền");
        btnPhanQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new PrivilegeManagementPanel();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        
        JButton btnNhanVien = new JButton("Nhân viên");
        btnNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new QuanLyNhanVien();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        JButton btnNhaCungCap = new JButton("Nhà cung cấp");
        btnNhaCungCap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new QuanLyNhaCungCap();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        
        JButton btnThongKe = new JButton("Thống kê");
        btnThongKe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new ThongKeBaoCao();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });

        
        
        
        addItem(btnHoaDon, true);
        addItem(btnPhieuNhap, true);
        addItem(btnSanPham, true);
        addItem(btnNhanVien, true);
        addItem(btnNhaCungCap, true);
        addItem(btnTaiKhoan, true);
        addItem(btnPhanQuyen, true);
        addItem(btnThongKe, true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
