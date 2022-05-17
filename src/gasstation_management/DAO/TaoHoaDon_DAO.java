/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import gasstation_management.DBConnect;
import gasstation_management.DTO.HoaDon;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utech
 */
public class TaoHoaDon_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
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
                    temp.setNgaytao(rs.getString(4));
                    temp.setSoluong(Float.parseFloat(rs.getString(5)));
                    temp.setTongtien(rs.getString(6));
                    result.add(temp);
                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        return result;
    }
    
    public boolean addHoaDon(HoaDon hd) {
        
        db.setupConnection();
        try {
            String sql = "insert into hoadon values (?,?,?,?,?,?)";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);
            stm.setString(1, hd.getMahd());
            stm.setString(2, hd.getMatrubom());
            stm.setString(3, hd.getMasp());
            stm.setObject(4, hd.getNgaytao());
            stm.setFloat(5, hd.getSoluong());
            stm.setString(6, hd.getTongtien());
            return db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            db.closeConnection();
        }
    }
    
}
