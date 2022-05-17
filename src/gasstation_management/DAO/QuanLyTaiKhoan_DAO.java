/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.DAO;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import gasstation_management.DBConnect;
import gasstation_management.DTO.TaiKhoan;
import static gasstation_management.Main.DATETIME_FORMATTER;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class QuanLyTaiKhoan_DAO {

    ArrayList<TaiKhoan> dstk = new ArrayList<>();
    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public ArrayList<TaiKhoan> getDanhSachTaiKhoan() {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from taikhoan");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    TaiKhoan temp = new TaiKhoan();
                    temp.setTenDangNhap(rs.getString(1));
                    temp.setMaNV(rs.getString(2));
                    temp.setMatKhau(rs.getString(3));
                    temp.setNgayTao(LocalDateTime.parse(rs.getString(4), DATETIME_FORMATTER));
                    temp.setTrangThai(rs.getString(5));
                    result.add(temp);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        dstk = result;
        return result;
    }

    public ArrayList<TaiKhoan> timKiemTheoTenDangNhap(String tenDangNhap) {
        db.setupConnection();
        ArrayList<TaiKhoan> result = new ArrayList<>();
        try {
            String sql = "select * from taikhoan where tendangnhap=?";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);
            stm.setString(1, tenDangNhap);
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    TaiKhoan temp = new TaiKhoan();
                    temp.setTenDangNhap(rs.getString(1));
                    temp.setMaNV(rs.getString(2));
                    temp.setMatKhau(rs.getString(3));
                    temp.setNgayTao(LocalDateTime.parse(rs.getString(4), DATETIME_FORMATTER));
                    temp.setTrangThai(rs.getString(5));
                    result.add(temp);
                }
            }
        } catch (SQLException ex) {
            System.out.println("exx");
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        dstk = result;
        return result;
    }

    public ArrayList<TaiKhoan> timKiemTheoTrangThai(String trangThai) {
        db.setupConnection();
        ArrayList<TaiKhoan> result = new ArrayList<>();
        try {
            String sql = "select * from taikhoan where trangthai=?";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);
            stm.setString(1, trangThai);
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    TaiKhoan temp = new TaiKhoan();
                    temp.setTenDangNhap(rs.getString(1));
                    temp.setMaNV(rs.getString(2));
                    temp.setMatKhau(rs.getString(3));
                    temp.setNgayTao(LocalDateTime.parse(rs.getString(4), DATETIME_FORMATTER));
                    temp.setTrangThai(rs.getString(5));
                    result.add(temp);
                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        dstk = result;
        return result;
    }

    public void addTaiKhoan(TaiKhoan tk) {
        db.setupConnection();
        
        try {
            String sql = "insert into taikhoan (?,?,?,?,?)";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);
            stm.setString(1, tk.getTenDangNhap());
            stm.setString(2, tk.getMaNV());
            stm.setString(3, tk.getMatKhau());
            stm.setString(4, tk.getNgayTao().format(DATETIME_FORMATTER));
            stm.setString(5, tk.getTrangThai());
            System.out.println(stm);
            db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } finally {
            db.closeConnection();
        }
    }

    public boolean updateTaiKhoan(TaiKhoan tk) {
        db.setupConnection();
        try {
            String sql = "update taikhoan set manv=?, matkhau=?, ngaytao=?, trangthai=? where tendangnhap=?";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);

            stm.setString(1, tk.getMaNV());
            stm.setString(2, tk.getMatKhau());
            stm.setString(3, tk.getNgayTao().format(DATETIME_FORMATTER));
            stm.setString(4, tk.getTrangThai());
            stm.setString(5, tk.getTenDangNhap());
            return db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            db.closeConnection();
        }
    }
    public void KhoaTaiKhoan(String tenTK){
        db.setupConnection();
        try{
            String sql = "update taikhoan set trangthai = ? where tendangnhap =? ";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);
            stm.setString(1,"Unactive");
            stm.setString(2, tenTK);
            db.sqlUpdate(stm);
    }catch(SQLException ex){
        Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        return;
    }finally{db.closeConnection();}
    }
    
    public void MoTaiKhoan(String tenTK){
        db.setupConnection();
        try{
            String sql = "update taikhoan set trangthai = ? where tendangnhap =? ";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);
            stm.setString(1,"Active");
            stm.setString(2, tenTK);
            db.sqlUpdate(stm);
    }catch(SQLException ex){
        Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        return;
    }finally{db.closeConnection();}
    }

    public TaiKhoan checkLogin(String tenDangNhap) throws Exception {
        db.setupConnection();
        String sql = "select tendangnhap from taikhoan where tendangnhap = ?";
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(sql);
            stm.setString(1, tenDangNhap);

            rs = db.sqlQry(stm);
            if (rs.next()) {
                TaiKhoan account = new TaiKhoan();
                account.setTenDangNhap(tenDangNhap);
                return account;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return null;
    }

}
