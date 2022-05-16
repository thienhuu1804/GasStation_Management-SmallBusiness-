/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;

import gasstation_management.DBConnect;
import gasstation_management.DTO.NhanVien;
import gasstation_management.DTO.QuyenTaiKhoan;
import gasstation_management.DTO.TaiKhoan;
import static gasstation_management.Main.DATETIME_FORMATTER;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuong
 */
public class QuanLyNhanVien_DAO {
    DBConnect db = new DBConnect();
    ResultSet rs = null;
    // Thêm một nhân viên
    public boolean addNhanVien_Dao(NhanVien nv) {
        
        db.setupConnection();
        try {
            String sql = "insert into nhanvien values (?,?,?,?,?,?)";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);
            stm.setString(1,nv.getManv());
            stm.setString(2,nv.getTennv());
            stm.setString(3,nv.getSdt());
            stm.setString(4,nv.getDiachi());
            stm.setString(5,nv.getCmnd());
            stm.setString(6,nv.getTrangthai());
            return db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            db.closeConnection();
        }
    }

    // Lấy thông tin của tất cã nhân viên
     public ArrayList<NhanVien> getDanhNhanVien() {
        ArrayList<NhanVien> result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from nhanvien");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    NhanVien temp = new NhanVien();
                    temp.setManv(rs.getString(1));
                    temp.setTennv(rs.getString(2));
                    temp.setSdt(rs.getString(3));
                    temp.setDiachi(rs.getString(4));
                    temp.setCmnd(rs.getString(5));
                    temp.setTrangthai(rs.getString(6));
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
     // Hàm lấy mã nhân viên của một nhân viên
     public ArrayList getMotNhanVien(String manv)
    {
    ArrayList<String> result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from NhanVien where manv=?");
            stm.setString(1,manv);
            rs =  stm.executeQuery();
                while (rs.next()) {
                     result.add(rs.getString("manv"));
                     result.add(rs.getString("tennv"));
                     result.add(rs.getString("sdt"));
                     result.add(rs.getString("diachi"));
                     result.add(rs.getString("cmnd"));
                     result.add(rs.getString("trangthai"));

                }
            return result;
        }catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            db.closeConnection();
        }
}
    // 
    public Boolean updateNhanVien(NhanVien nhanvien, String manvCu) {
        
        db.setupConnection();
        try {
            String sql = "update nhanvien set manv=?, tennv=?, sdt=?, diachi=?, cmnd=?, trangthai=?  where manv=?";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);

            stm.setString(1,nhanvien.getManv());
            stm.setString(2,nhanvien.getTennv());
            stm.setString(3,nhanvien.getSdt());
            stm.setString(4,nhanvien.getDiachi());
            stm.setString(5,nhanvien.getCmnd());
            stm.setString(6,nhanvien.getTrangthai());
            stm.setString(7,manvCu);
            return db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            db.closeConnection();
        }
    }

    public void deleteNhanVien_DAO(String manv) {
        
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("delete from nhanvien where manv=?");
            stm.setString(1, manv);
            db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyQuyenTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.closeConnection();
        }
    }
    }
