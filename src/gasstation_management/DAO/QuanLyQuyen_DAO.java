/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;

import java.sql.PreparedStatement;
import gasstation_management.DBConnect;
import gasstation_management.DTO.Quyen;
import gasstation_management.UI.MainContentPanels.DanhSachQuyen_GUI;
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
public class QuanLyQuyen_DAO {

    DBConnect conn = new DBConnect();
    ResultSet rs = null;
    public QuanLyQuyen_DAO() {
    }

    public ArrayList<Quyen> QuyenAll() {
        ArrayList<Quyen> listQuyen = new ArrayList<>();
        ArrayList<Quyen> dsq = new ArrayList<>();
        conn.setupConnection();
        try {
            PreparedStatement stm = conn.getConnection().prepareStatement("select * from quyen");
            rs = conn.sqlQry(stm);
            while (rs.next()) {
                Quyen q = new Quyen();
                q.setMaQuyen(rs.getString("maquyen"));
                q.setMoTaQuyen(rs.getString("motaquyen"));
                dsq.add(q);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conn.closeConnection();
        }

        return dsq;
    }
    
public String getMaQuyen(String privilegeName)
{
    String name = null;
         try {
            PreparedStatement stm = conn.getConnection().prepareStatement("select maquyen from quyen where motaquyen='"+privilegeName+"'");
            rs =  stm.executeQuery();
                while (rs.next()) {
                      name= rs.getString("maquyen");
                }
                return name;
        }catch (SQLException ex)
        {
          return null;  
        }
}
}