
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management;

import gasstation_management.BUS.QuanLyTaiKhoan_BUS;
import gasstation_management.DAO.QuanLyTaiKhoan_DAO;
import gasstation_management.DTO.TaiKhoan;
import gasstation_management.UI.MainPanel;
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
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        // Create mainframe
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLayout(new BorderLayout());
//
//        MainPanel pnlMain = new MainPanel();
//        //Làm gì thì add giao diện đó vào pnlMain
//
//        frame.setSize(pnlMain.getPreferredSize());
//        frame.setLocationRelativeTo(null);
//        frame.add(pnlMain);
//        frame.setVisible(true);
        QuanLyTaiKhoan_BUS qltk = new QuanLyTaiKhoan_BUS();
        System.out.println(qltk.search("none").get(0).getMaNV());

    }

}
