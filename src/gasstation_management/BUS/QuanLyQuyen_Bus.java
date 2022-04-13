/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;

//import gasstation_management.DAO.QuanLyQuyen_Dao;

import gasstation_management.DAO.QuanLyQuyen_Dao;
import gasstation_management.UI.AccountPower_management;
import java.sql.SQLException;


/**
 *
 * @author Vuong
 */
public class QuanLyQuyen_Bus {
   public QuanLyQuyen_Bus()
    {
        
        
    }
    public String[][] ShowListAccount() throws SQLException
    {
        
      QuanLyQuyen_Dao ql = new QuanLyQuyen_Dao();
      String[][] str = ql.LoadDataAccount();
      return str;
    }
}
