/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;

import gasstation_management.DBConnect;
import gasstation_management.DTO.HoaDon;
import gasstation_management.DTO.QuyenTaiKhoan;
import static gasstation_management.Main.DATETIME_FORMATTER;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Vuong
 */
public class TraCuuHoaDon_DAO {
    DBConnect db = new DBConnect();
    ResultSet rs = null;
    public ArrayList<HoaDon> getDanhSachHoaDon() {
        ArrayList<HoaDon> result = new ArrayList<>();
        db.setupConnection();
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from hoadon");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    HoaDon temp = new HoaDon();
                    temp.setMahd(rs.getString(1));
                    temp.setMatrubom(rs.getString(2));
                    temp.setMasp(rs.getString(3));
                    temp.setNgaytao((LocalDateTime.parse(rs.getString(4), DATETIME_FORMATTER)));
                    temp.setSoluong(rs.getFloat(5));
                    temp.setTongtien(rs.getString(6));
                    result.add(temp);
                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.closeConnection();
        }
        return result;
    }

    public ArrayList<HoaDon> getDanhSachHoaDonTheoTimKiem(String text) {
         ArrayList<HoaDon> result = new ArrayList<>();
        db.setupConnection();
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from hoadon");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    HoaDon temp = new HoaDon();
                    temp.setMahd(rs.getString(1));
                    temp.setMatrubom(rs.getString(2));
                    temp.setMasp(rs.getString(3));
                    temp.setNgaytao((LocalDateTime.parse(rs.getString(4), DATETIME_FORMATTER)));
                    temp.setSoluong(rs.getFloat(5));
                    temp.setTongtien(rs.getString(6));
                    result.add(temp);
                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.closeConnection();
        }
        return result;
        
    }
    
}
