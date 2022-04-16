/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;

//import gasstation_management.DAO.QuanLyQuyen_Dao;

import gasstation_management.DAO.QuanLyQuyen_Dao;
import gasstation_management.UI.AccountPower_management;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Vuong
 */
public class QuanLyQuyen_Bus {
   
    QuanLyQuyen_Dao qld = new QuanLyQuyen_Dao();
   public QuanLyQuyen_Bus()
    {
        
        
    }
   // Hiển thị thông tin quyền tài khoản ra bảng table
    public String[][] ShowListAccount() throws SQLException
    {
        
      String[][] str = qld.LoadDataAccount();
      return str;
    }
    // Lấy tất cã quyền của tài khoản đã được chọn 
    public ArrayList PowerListAccountSelected(int indexRow) {
        
       String[][] str = qld.LoadDataAccount();
       String tendangnhap;
       tendangnhap = str[indexRow][0];
       return qld.getAllPowerOfAccount(tendangnhap); // Trả về mảng quyền của một tài khoản được chọn       
            
    }
}
