/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;

import gasstation_management.DBConnect;
import gasstation_management.DTO.NhanVien;
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
public class QuanLyNhanVien_DAO {
        DBConnect db = new DBConnect();
    ResultSet rs = null;
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
    //
}
