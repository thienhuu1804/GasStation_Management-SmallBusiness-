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

    ArrayList<TaiKhoan> list_Account = new ArrayList<>();
    DBConnect conn = new DBConnect();
    ResultSet rs = null;

    public ArrayList<TaiKhoan> getDanhSachTaiKhoan() {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        try {
            PreparedStatement stm = conn.getConnection().prepareStatement("select * from taikhoan");
            rs = conn.sqlQry(stm);
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
        }
        return result;
    }
}
