/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.BUS;

import gasstation_management.DAO.QuanLyQuyenTaiKhoan_DAO;
import java.sql.SQLException;
//import gasstation_management.DTO.QuyenTaiKhoan;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class QuanLyQuyenTaiKhoan_BUS {
//    ArrayList<QuyenTaiKhoan> danhSachTaiKhoan = new ArrayList<>();
//    QuanLyQuyenTaiKhoan_DAO quanLyTaiKhoan_DAO = new QuanLyQuyenTaiKhoan_DAO();
//    
//    public ArrayList<QuyenTaiKhoan> getDanhSachQuyenTaiKhoan(){
//        return quanLyTaiKhoan_DAO.getDanhSachQuyenTaiKhoan();
//    }
    
     QuanLyQuyenTaiKhoan_DAO qld = new QuanLyQuyenTaiKhoan_DAO();
   public QuanLyQuyenTaiKhoan_BUS()
    {
        
        
    }
   // Hiển thị thông tin quyền tài khoản ra bảng table
    public String[][] ShowListAccount() throws SQLException
    {
        
      String[][] str = qld.LoadDataAccount();
      return str;
    }
    // Hàm lấy tên của một tài khoản
    public String getLoginName(int indexRow)
    {
           String[][] str = qld.LoadDataAccount();  // Mảng quyền của tất cã tài khoản
           return str[indexRow][0];
    }
    // Lấy tất cã quyền của tài khoản đã được chọn 
    public ArrayList PowerListAccountSelected(int indexRow) {
        
       String tendangnhap;
       tendangnhap = getLoginName(indexRow);
       return qld.getAllPowerOfAccount(tendangnhap); // Trả về mảng quyền của một tài khoản được chọn       
            
    }
    // update quyền của tài khoản lên database
    public void UpdateAccountPower_Bus(ArrayList result, String text) {
        qld.UpdateAccountPower_Dao(result,text);
    }
}
