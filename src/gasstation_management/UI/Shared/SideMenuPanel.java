/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.UI.Shared;

import gasstation_management.BUS.QuanLyQuyenTaiKhoan_BUS;
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
import static gasstation_management.Main.TenDangNhap;

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
        JButton btnHoaDon = new JButton("Hoá Đơn");
        JButton btnPhieuNhap = new JButton("Phiếu nhập");
        JButton btnSanPham = new JButton("Sản phẩm");
        JButton btnTaiKhoan = new JButton("Tài khoản");
        JButton btnPhanQuyen = new JButton("Phân quyền");
        JButton btnNhanVien = new JButton("Nhân viên");
        JButton btnThongKe = new JButton("Thống kê");
        JButton btnNhaCungCap = new JButton("Nhà cung cấp");

    public SideMenuPanel( JFrame frame, JPanel pnlContent) {
        initComponents();
        setLayout(null);
        setBounds(new Rectangle(0, 0, WIDTH, HEIGHT));
//        this.pnlContent = pnlContent;
        this.mainFrame = frame;
        this.pnlContent = pnlContent;
        createMenuButtons();
        setColorBack();
        enableAllBtn();
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
        
        
        btnHoaDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new TraCuuHoaDon();
                showingPanel.setSize(showingPanel.getPreferredSize());
                showingPanel.setVisible(true);
                pnlContent.removeAll();
                pnlContent.add(showingPanel); 
                setColorBack();
                btnHoaDon.setBackground(Color.red);
                mainFrame.revalidate();
                mainFrame.repaint();
//                mainFrame.pack();
                
            }
        });
        
        btnPhieuNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new QuanLyPhieuNhap();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                setColorBack();
                btnPhieuNhap.setBackground(Color.red);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        btnSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new QuanLySanPham();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                setColorBack();
                btnSanPham.setBackground(Color.red);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        btnTaiKhoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new QuanLyTaiKhoan();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                setColorBack();
                btnTaiKhoan.setBackground(Color.red);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        btnPhanQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new PrivilegeManagementPanel();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                setColorBack();
                btnPhanQuyen.setBackground(Color.red);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        
        btnNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new QuanLyNhanVien();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                setColorBack();
                btnNhanVien.setBackground(Color.red);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        btnNhaCungCap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new QuanLyNhaCungCap();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                setColorBack();
                btnNhaCungCap.setBackground(Color.red);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
        
        btnThongKe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showingPanel = new ThongKeBaoCao();
                showingPanel.setSize(showingPanel.getPreferredSize());
                pnlContent.removeAll();
                pnlContent.add(showingPanel);
                setColorBack();
                btnThongKe.setBackground(Color.red);
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
    public void enableAllBtn()
    {
        btnHoaDon.setEnabled(false);
        btnNhaCungCap.setEnabled(false);
        btnNhanVien.setEnabled(false);
        btnPhanQuyen.setEnabled(false);
        btnPhieuNhap.setEnabled(false);
        btnSanPham.setEnabled(false);
        btnTaiKhoan.setEnabled(false);
        btnThongKe.setEnabled(false);
        
        QuanLyQuyenTaiKhoan_BUS quanLyQuyenTaiKhoan_BUS = new QuanLyQuyenTaiKhoan_BUS();
       ArrayList<String> list = quanLyQuyenTaiKhoan_BUS.getPrivilegeListOfAccount(TenDangNhap);
       for(String i: list)
       {
           if(i.equalsIgnoreCase("quản lý tài khoản"))
           {
               btnTaiKhoan.setEnabled(true);
           }
            if(i.equalsIgnoreCase("quản lý nhà cung cấp"))
           {
               btnNhaCungCap.setEnabled(true);
           } if(i.equalsIgnoreCase("quản lý sản phẩm"))
           {
               btnSanPham.setEnabled(true);
           } if(i.equalsIgnoreCase("thống kê báo cáo"))
           {
               btnThongKe.setEnabled(true);
           } if(i.equalsIgnoreCase("quản lý nhân viên"))
           {
               btnNhanVien.setEnabled(true);
           } if(i.equalsIgnoreCase("quản lý phiếu nhập"))
           {
               btnPhieuNhap.setEnabled(true);
           } if(i.equalsIgnoreCase("tra cứu hoá đơn"))
           {
               btnHoaDon.setEnabled(true);
           }
           if(i.equalsIgnoreCase("quản lý quyền"))
           {
               btnPhanQuyen.setEnabled(true);
           }
           
       }
//quản lý nhà cung 
//quản lý sản phẩm
//thống kê báo cáo
//quản lý nhân viên
//quản lý phiếu nhập
//tra cứu hoá đơn
//quản lý quyền

    }
  public void setColorBack()
  {
      btnHoaDon.setBackground(Color.BLACK);
        btnHoaDon.setForeground(Color.WHITE);
        btnHoaDon.setOpaque(true);
        
        
         btnNhaCungCap.setBackground(Color.BLACK);
        btnNhaCungCap.setForeground(Color.WHITE);
        btnNhaCungCap.setOpaque(true);
        
         btnNhanVien.setBackground(Color.BLACK);
        btnNhanVien.setForeground(Color.WHITE);
        btnNhanVien.setOpaque(true);
        
         btnPhanQuyen.setBackground(Color.BLACK);
        btnPhanQuyen.setForeground(Color.WHITE);
        btnPhanQuyen.setOpaque(true);
        
         btnPhieuNhap.setBackground(Color.BLACK);
        btnPhieuNhap.setForeground(Color.WHITE);
        btnPhieuNhap.setOpaque(true);
        
         btnSanPham.setBackground(Color.BLACK);
        btnSanPham.setForeground(Color.WHITE);
        btnSanPham.setOpaque(true);
        
         btnTaiKhoan.setBackground(Color.BLACK);
        btnTaiKhoan.setForeground(Color.WHITE);
        btnTaiKhoan.setOpaque(true);
        
         btnThongKe.setBackground(Color.BLACK);
        btnThongKe.setForeground(Color.WHITE);
        btnThongKe.setOpaque(true);
        
    
        
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
