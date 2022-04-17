/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.DAO;

import gasstation_management.DBConnect;
//import gasstation_management.DTO.QuyenTaiKhoan;
import gasstation_management.DTO.TaiKhoan;
import gasstation_management.DTO.TaiKhoan_Quyen;
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


       
        DBConnect conn = new DBConnect();
    ResultSet rs;
    public QuanLyQuyenTaiKhoan_DAO() {
        
        
    }
    // Lấy tất cã dữ liệu từ bảng taikhoan_quyen
     public ArrayList loadDataAccount2()
    {
        ArrayList<TaiKhoan_Quyen> powerList = new ArrayList<>();
        try {
            PreparedStatement stm = conn.getConnection().prepareStatement("select id,tendangnhap,maquyen,ngaysua from taikhoan_quyen");
            rs = stm.executeQuery();
            while (rs.next()) {
                TaiKhoan_Quyen tkq = new TaiKhoan_Quyen();
                tkq.setId(rs.getInt("id"));
                tkq.setTendangnhap(rs.getString("tendangnhap"));
                tkq.setMaquyen(rs.getString("maquyen"));
                tkq.setNgaysua(rs.getString("ngaysua"));
                powerList.add(tkq);
            }
            return powerList;
                  
        }
        catch (Exception e) {
            return null;
        }        
        
    }
    // mảng tất cã quyền của tất cã tài khoản
    public String[][] LoadDataAccount()
    {
        int count;
       count =1;
       String[][] result = new String[0][3];
        try {
            PreparedStatement stm = conn.getConnection().prepareStatement("select tendangnhap,quyen.motaquyen from taikhoan_quyen,quyen where taikhoan_quyen.maquyen=quyen.maquyen");
            rs = stm.executeQuery();
            while (rs.next()) { // will traverse through all rows
                       boolean flag = false;
                ArrayList<String> list = new ArrayList<String>();
                String tenDangNhap = rs.getString("tendangnhap");
                String maquyen = rs.getString("motaquyen");
                list.add(tenDangNhap);
                list.add(maquyen);
                for(int i=0;i<count-1;i++)      
                {
                   if(result[i][0].equals(rs.getString("tendangnhap")))
                           {
                               result[i][1]=result[i][1]+"+ "+rs.getString("motaquyen");
                           flag = true;
                           break;
                           }
                }
                if(flag==false)
                {
                String[] arr = new String[list.size()];
                list.toArray(arr);
                String[][] result2 = new String[count][3];
                for(int i=0;i<count-1;i++)      
                {
                    for(int j=0;j<2;j++)
                    {
                        result2[i][j] = result[i][j];
                    }
                }
                for(int k=0;k<2;k++)
                {
                    result2[count-1][k]=arr[k];
                }
                count++;
                result=result2;
                }
            }
            return result;
        } catch (Exception e) {
            return null;
        }
        }
   
    // lấy tất cả quyền của một tài khoản nhất định
    public ArrayList getAllPowerOfAccount(String tendangnhap)
    { 
        ArrayList<String> powerList = new ArrayList();
        try {
                    PreparedStatement stm = conn.getConnection().prepareStatement("select quyen.motaquyen from taikhoan_quyen,quyen where taikhoan_quyen.maquyen=quyen.maquyen and taikhoan_quyen.tendangnhap ='"+tendangnhap+"'");
            rs = stm.executeQuery();
            while(rs.next())
            {
               String moTaQuyen = rs.getString("motaquyen");
               powerList.add(moTaQuyen);
            }
            return powerList;
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyQuyen_Dao.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
        }
    }
    // Cập nhật quyền của một tài khoản
    public void UpdateAccountPower_Dao(ArrayList result, String text) {
 }
//    public ArrayList<QuyenTaiKhoan> getDanhSachQuyenTaiKhoan() {
//        ArrayList<QuyenTaiKhoan> result = new ArrayList<>();
//        try {
//            PreparedStatement stm = db.getConnection().prepareStatement("select * from taikhoan_quyen");
//            rs = db.sqlQry(stm);
//            if (rs != null) {
//                while (rs.next()) {
//                    QuyenTaiKhoan temp = new QuyenTaiKhoan();
//                    temp.setId(rs.getInt(1));
//                    temp.setTenDangNhap(rs.getString(2));
//                    temp.setMaQuyen(rs.getString(3));
//                    temp.setNgaySua(LocalDateTime.parse(rs.getString(4), DATETIME_FORMATTER));
//                    result.add(temp);
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
//
//    public boolean addQuyenTaiKhoan(QuyenTaiKhoan quyen) {
//        boolean success = false;
//        try {
//            PreparedStatement stm = db.getConnection().prepareStatement("insert into taikhoan_quyen (?,?,?,?,?)");
//            stm.setInt(1, 0);
//            stm.setString(2, quyen.getTenDangNhap());
//            stm.setString(3, quyen.getMaQuyen());
//            stm.setString(4, quyen.getNgaySua().format(DATETIME_FORMATTER));
//            success = db.sqlUpdate(stm);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyQuyenTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return success;
}
