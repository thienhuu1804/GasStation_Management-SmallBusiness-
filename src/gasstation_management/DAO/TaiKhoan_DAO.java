/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import gasstation_management.DBConnect;
import gasstation_management.DTO.TaiKhoan;

/**
 *
 * @author Utech
 */
public class TaiKhoan_DAO {
    DBConnect conn = new DBConnect();
    ResultSet rs = null;
    
    public TaiKhoan checkLogin(String tenDangNhap, String matKhau)  throws Exception {
        String sql = "select tendangnhap, matkhau from taikhoan where tendangnhap = ? and matkhau = ?";
        try {
            PreparedStatement stm = conn.getConnection().prepareStatement(sql);
            stm.setString(1, tenDangNhap);
            stm.setString(2, matKhau);
            
            rs = conn.sqlQry(stm);
            if(rs.next()) {
                TaiKhoan account = new TaiKhoan();
                account.setTenDangNhap(tenDangNhap);
                account.setMatKhau(matKhau);
                return account;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
