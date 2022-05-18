
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management;

import gasstation_management.BUS.QuanLyQuyenTaiKhoan_BUS;
import gasstation_management.BUS.QuanLyTaiKhoan_BUS;
import gasstation_management.DAO.QuanLyTaiKhoan_DAO;
import gasstation_management.DTO.TaiKhoan;
import gasstation_management.UI.Login;
import gasstation_management.UI.MainContentPanels.DanhSachQuyen_GUI;
import gasstation_management.UI.MainContentPanels.PrivilegeManagementPanel;
import gasstation_management.UI.MainContentPanels.QuanLyTaiKhoan;
import gasstation_management.UI.MainContentPanels.QuanLyNhanVien;
import gasstation_management.UI.MainContentPanels.QuanLyPhieuNhap;
import gasstation_management.UI.MainContentPanels.TraCuuHoaDon;
import gasstation_management.UI.MainContentPanels.ThongKeBaoCao;
import gasstation_management.UI.MainContentPanels.QuanLyNhaCungCap;


import gasstation_management.UI.Shared.MainPanel;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author nguye
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
     public static String TenDangNhap ; 

    public static void main(String[] args) {
Login lg = new Login();
//        new Login().setVisible(true);
        // Create mainframe
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLayout(new BorderLayout());
//        
//        MainPanel pnlMain = new MainPanel();
////        pnlMain.setLayout(new BorderLayout());
//        pnlMain.setVisible(true);
//        //Làm gì thì add giao diện đó vào pnlMain
//        PrivilegeManagementPanel privPanel = new PrivilegeManagementPanel();
//        privPanel.setSize(privPanel.getPreferredSize());
////        DanhSachQuyen_GUI test = new DanhSachQuyen_GUI();
////        test.setSize(test.getPreferredSize());
//
//        QuanLyTaiKhoan ui_qltk = new QuanLyTaiKhoan();
//        ui_qltk.setSize(ui_qltk.getPreferredSize());
////          
//        QuanLyNhanVien qlnv = new QuanLyNhanVien();
//        qlnv.setSize(qlnv.getPreferredSize());
//        TraCuuHoaDon tchd = new TraCuuHoaDon();
//        tchd.setSize(tchd.getPreferredSize());
//        ThongKeBaoCao tkbc = new ThongKeBaoCao();
//        tkbc.setSize(tkbc.getPreferredSize());
//          
//<<<<<<< HEAD
//        QuanLyNhanVien qlnv = new QuanLyNhanVien();
//        qlnv.setSize(qlnv.getPreferredSize());
//        TraCuuHoaDon tchd = new TraCuuHoaDon();
//        tchd.setSize(tchd.getPreferredSize());
//        ThongKeBaoCao tkbc = new ThongKeBaoCao();
//        tkbc.setSize(tkbc.getPreferredSize());
//          
//        QuanLyPhieuNhap qlpn = new QuanLyPhieuNhap();
//        qlpn.setSize(qlpn.getPreferredSize());
//    
//         QuanLyNhaCungCap qlncc = new QuanLyNhaCungCap();
//         qlncc.setSize(qlncc.getPreferredSize());
//        pnlMain.getPnlMainContent().add(qlpn);
//        frame.setSize(pnlMain.getPreferredSize());
//        frame.setLocationRelativeTo(null);
//        frame.add(pnlMain);
//        frame.setVisible(true);
//=======
//        QuanLyPhieuNhap qlpn = new QuanLyPhieuNhap();
//        qlpn.setSize(qlpn.getPreferredSize());
//    
//         QuanLyNhaCungCap qlncc = new QuanLyNhaCungCap();
//         qlncc.setSize(qlncc.getPreferredSize());
//        pnlMain.getPnlMainContent().add(tchd);
//        frame.setSize(pnlMain.getPreferredSize());
//        frame.setLocationRelativeTo(null);
//        frame.add(pnlMain);
//        frame.setVisible(true);
//>>>>>>> master

//        System.out.println(LocalDateTime.now().format(DATETIME_FORMATTER));
//        QuanLyQuyenTaiKhoan_BUS qltk = new QuanLyQuyenTaiKhoan_BUS();
//        QuanLyTaiKhoan_BUS qultkbus = new QuanLyTaiKhoan_BUS();
//        System.out.println(qultkbus.timKiemTheoTenDangNhap("nv1"));
    }

}
