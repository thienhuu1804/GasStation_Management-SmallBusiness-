/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;

import gasstation_management.DBConnect;
import gasstation_management.DTO.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utech
 */
public class QuanLySanPham_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public ArrayList<SanPham> getDanhSachSanPham() {
        ArrayList<SanPham> result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from sanpham");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    SanPham temp = new SanPham();
                    temp.setMaSanPham(rs.getString(1));
                    temp.setTenSanPham(rs.getString(2));
                    temp.setSoLuong(Float.parseFloat(rs.getString(3)));
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

    public boolean addSanPham(SanPham sp) {
        boolean success = false;
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("insert into sanpham values (?,?,?)");
            stm.setString(1, sp.getMaSanPham());
            stm.setString(2, sp.getTenSanPham());
            stm.setFloat(3, sp.getSoLuong());
            success = db.sqlUpdate(stm);

        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyQuyenTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        return success;
    }

    public void deleteSanPham(String masp) {

        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("delete from sanpham where masp=?");
            stm.setString(1, masp);
            db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyQuyenTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
    }

    public Boolean updateSanPham(SanPham sp, String maspCu) {

        db.setupConnection();
        try {
            String sql = "update sanpham set masp=?, tensp=?, soluong=?  where manv=?";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);

            stm.setString(1, sp.getMaSanPham());
            stm.setString(2, sp.getTenSanPham());
            stm.setFloat(3, sp.getSoLuong());
            stm.setString(4, maspCu);
            return db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList getMotSanPham(String masp) {
        ArrayList<String> result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from sanpham where masp=?");
            stm.setString(1, masp);
            rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("masp"));
                result.add(rs.getString("tensp"));
                result.add(String.valueOf(rs.getFloat("soluong")));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            db.closeConnection();
        }
    }
    
    
}
