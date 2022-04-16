/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import gasstation_management.DBConnect;
import gasstation_management.DTO.TaiKhoan;
import gasstation_management.DTO.TaiKhoan_Quyen;

import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuong
 */
//
public class QuanLyQuyen_Dao {

    DBConnect conn = new DBConnect();
    ResultSet rs;
    public QuanLyQuyen_Dao() {
        
        
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
    public void updateAccountPower(String str)
    {
        
    }
}
