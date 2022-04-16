/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management;

import gasstation_management.UI.MainPanel;
import gasstation_management.UI.DanhSachQuyen_GUI;
import java.awt.BorderLayout;
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
    public static void main(String[] args) {
        // Create mainframe
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        MainPanel pnlMain = new MainPanel();
        //Làm gì thì add giao diện đó vào pnlMain
        DanhSachQuyen_GUI pnlQuyen = new DanhSachQuyen_GUI();
        
        frame.setSize(pnlMain.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.add(pnlMain);
        frame.setVisible(true);
        DBConnect connector = new DBConnect();
        System.out.println(connector.getHeaders("quyen"));

    }

}
