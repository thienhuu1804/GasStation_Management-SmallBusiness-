/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;

import gasstation_management.DBConnect;
import gasstation_management.DTO.NhaCungCap;
import gasstation_management.DTO.NhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;



/**
 *
 * @author Vuong
 */
public class QuanLyNhaCungCap_DAO {

     DBConnect db = new DBConnect();
    ResultSet rs = null;
    // Lấy thông tin nhà cung cấp
    public ArrayList<NhaCungCap> getDanhSachNhaCungCap() {
        
        ArrayList<NhaCungCap> result = new ArrayList<>();
        db.setupConnection();
        try {
            java.sql.PreparedStatement stm = db.getConnection().prepareStatement("select * from nhacungcap");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    NhaCungCap temp = new NhaCungCap();
                    temp.setMancc(rs.getString(1));
                    temp.setTenncc(rs.getString(2));
                   temp.setDiachi(rs.getString(3));
                    temp.setSDT(rs.getString(4));
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
    // Hàm thêm nhà cung cấp
    public Boolean addNhaCungCap_Dao(NhaCungCap ncc) {
        db.setupConnection();
        try {
            String sql = "insert into nhacungcap values (?,?,?,?)";
            java.sql.PreparedStatement stm = db.getConnection().prepareStatement(sql);
            stm.setString(1,ncc.getMancc());
            stm.setString(2,ncc.getTenncc());
            stm.setString(3,ncc.getDiachi());
            stm.setString(4,ncc.getSDT());
            return db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            db.closeConnection();
        }
    }

    public Boolean updateInforNhaCungCap(NhaCungCap ncc) {
        db.setupConnection();
        try {
            String sql = "update nhacungcap set tenncc=?, diachi=?, sdt=?  where mancc=?";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);

            stm.setString(1,ncc.getTenncc());
            stm.setString(2,ncc.getDiachi());
           stm.setString(3,ncc.getSDT());
           stm.setString(4,ncc.getMancc());
            
            return db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            db.closeConnection();
        }
    }
    
}
