
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

    public static void main(String[] args) {

        new Login().setVisible(true);
        // Create mainframe

//        System.out.println(LocalDateTime.now().format(DATETIME_FORMATTER));
//        QuanLyQuyenTaiKhoan_BUS qltk = new QuanLyQuyenTaiKhoan_BUS();
//        QuanLyTaiKhoan_BUS qultkbus = new QuanLyTaiKhoan_BUS();
//        System.out.println(qultkbus.timKiemTheoTenDangNhap("nv1"));
    }

}
