/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.DAO;

import gasstation_management.DBConnect;
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
 * @author nguye
 */
public class QuanLyQuyenTaiKhoan_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public ArrayList<QuyenTaiKhoan> getDanhSachQuyenTaiKhoan() {
        ArrayList<QuyenTaiKhoan> result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from taikhoan_quyen");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    QuyenTaiKhoan temp = new QuyenTaiKhoan();
                    temp.setId(rs.getInt(1));
                    temp.setTenDangNhap(rs.getString(2));
                    temp.setMaQuyen(rs.getString(3));
                    temp.setNgaySua((LocalDateTime.parse(rs.getString(4), DATETIME_FORMATTER)));
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
    // Lấy tất cã quyền của một tài khoản
    public ArrayList getQuyenCuaMotTaiKhoan(String accountName)
    {
    ArrayList<String> result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select quyen.motaquyen from taikhoan_quyen,quyen where taikhoan_quyen.maquyen=quyen.maquyen and taikhoan_quyen.tendangnhap =");
            stm.setString(1,accountName);
            rs =  stm.executeQuery();
                while (rs.next()) {
                     result.add(rs.getString("motaquyen"));
                }
            return result;
        }catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            db.closeConnection();
        }
}
    public boolean addQuyenTaiKhoan(QuyenTaiKhoan quyen) {
        boolean success = false;
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("insert into taikhoan_quyen values (?,?,?,?)");
            stm.setInt(1, quyen.getId());
            stm.setString(2, quyen.getTenDangNhap());
            stm.setString(3, quyen.getMaQuyen());
            stm.setString(4, quyen.getNgaySua().format(DATETIME_FORMATTER));
            success = db.sqlUpdate(stm);

        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyQuyenTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.closeConnection();
        }
        return success;
    }
    
    public boolean addDanhSachQuyenTaiKhoan(ArrayList<QuyenTaiKhoan> danhSachQuyenTaiKhoan){
        for(QuyenTaiKhoan quyen: danhSachQuyenTaiKhoan){
            addQuyenTaiKhoan(quyen);
        }
        return true;
    }
    
    public boolean removeAllQuyenTaiKhoan(String tenDangNhap){
        boolean success = false;
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("delete from taikhoan_quyen where tendangnhap=?");
            stm.setString(1, tenDangNhap);
            success = db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyQuyenTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            db.closeConnection();
        }
        return success;
    }

   
}
