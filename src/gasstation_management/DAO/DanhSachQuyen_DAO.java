/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;

import java.sql.PreparedStatement;
import gasstation_management.DBConnect;
import gasstation_management.DTO.DanhSachQuyen_DTO;
import gasstation_management.UI.DanhSachQuyen_GUI;
import java.awt.List;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author admin
 */
public class DanhSachQuyen_DAO {

    



public DanhSachQuyen_DAO(){
}
public static ArrayList<DanhSachQuyen_DTO> QuyenAll()
    {
        ArrayList<DanhSachQuyen_DTO> listQuyen = new ArrayList<>();
        DBConnect conn = new DBConnect();
        ResultSet rs = null;
        ArrayList<DanhSachQuyen_DTO> dsq = new ArrayList<>();
        try {
           
            PreparedStatement stm = conn.getConnection().prepareStatement("select * from quyen");
            rs = conn.sqlQry((com.mysql.jdbc.PreparedStatement) stm);
            while(rs.next())
            {
                DanhSachQuyen_DTO q= new DanhSachQuyen_DTO();
                q.setMaQuyen (rs.getString("maquyen"));
                q.setMoTaQuyen (rs.getString("motaquyen"));
                dsq.add(q);
            }
            rs.close();
            conn.closeConnect();
            
        } catch (SQLException ex) {
           
        }
        
        return dsq;
    }
}