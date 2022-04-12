/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nguye
 */
public class DBConnect {

    Statement stm = null;
    ResultSet rs = null;
    Connection conn = null;

    String server = "localhost:3306";
    String dbName = "fuelmanagement";
    String userName = "root";
    String pass = "";

    public DBConnect() {
        checkDriver();
        setupConnection();
    }
    
    public DBConnect(String dbName) {
        checkDriver();
        server = "localhost:3306";
        this.dbName = dbName;
        userName = "FuelAdmin";
        this.pass = "";
        setupConnection();
    }

    public DBConnect(String dbName, String userName, String pass, String server) {
        checkDriver();
        this.dbName = dbName;
        this.userName = userName;
        this.pass = pass;
        this.server = server;
        setupConnection();
    }

    public DBConnect(String dbName, String userName, String pass) {
        checkDriver();
        this.dbName = dbName;
        this.userName = userName;
        this.pass = pass;
        setupConnection();
    }

    public void logIn(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
        setupConnection();
    }

    public void setupConnection() {
        try {
            String url = "jdbc:mysql://" + server + "/" + dbName;
            conn = DriverManager.getConnection(url, userName, pass);
            stm = conn.createStatement();
            System.err.println("Ket noi thanh cong");
//            JOptionPane.showMessageDialog(null, "Ket noi database " + dbName + " thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Khong the ket noi toi " + dbName);
        }
    }

    public ResultSet sqlQry(String qry) {
        if (checkConnection()) {
            try {
                rs = stm.executeQuery(qry);
//                JOptionPane.showMessageDialog(null, "Thuc thi Query thanh cong !!");
                return rs;
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Loi thuc thi query !!");
            }
        }
        return null;
    }

    public Boolean sqlUpdate(String qry) {
        if (checkConnection()) {
            try {
                stm.executeUpdate(qry);
//                JOptionPane.showMessageDialog(null, "Thuc thi Update thanh cong !!");
                return true;
            } catch (SQLException e) {
//                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gia tri cua khoa vua nhap khong ton tai !!");
            }
        }
        return false;
    }

    public ArrayList<String> getHeaders(String tableName) {
        ArrayList<String> headers = new ArrayList<>();
        if (checkConnection()) {
            try {
                rs = sqlQry("SELECT * FROM " + tableName+";");
                ResultSetMetaData rsMetaData = rs.getMetaData();
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    headers.add(rsMetaData.getColumnName(i));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Khong the lay ten cac cot!!");
            }
        }
        return headers;
    }

    public Boolean checkConnection() {
        if (conn == null || stm == null) {
            return false;
        }
        return true;
    }

    public void checkDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Khong tim thay Driver mysql !!");
        }
    }

    public void closeConnect() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stm != null) {
                stm.close();
            }
//            System.out.println("Success! Đóng kết nối tới '" + dbName + "' thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "-- ERROR! Không thể đóng kết nối tới " + dbName);
        }
    }
    public String[][] getInforPowerOfAllAccount() throws SQLException
    {
        int count;
        String[][] result = new String[0][3];

        PreparedStatement selectStatement1 = conn.prepareStatement("select distinct tendangnhap from taikhoan_quyen");
        PreparedStatement selectStatement = conn.prepareStatement("select id,tendangnhap,maquyen from taikhoan_quyen");
        ResultSet rs = selectStatement.executeQuery();
        count =1;
            while (rs.next()) { // will traverse through all rows
                ArrayList<String> list = new ArrayList<String>();
                int iD = rs.getInt("id");
                String tenDangNhap = rs.getString("tendangnhap");
                String maquyen = rs.getString("maquyen");
                list.add(Integer.toString(iD));
                list.add(tenDangNhap);
                list.add(maquyen);
                String[] arr = new String[list.size()];
                list.toArray(arr);
                String[][] result2 = new String[count][3];
                for(int i=0;i<count-1;i++)      
                {
                    for(int j=0;j<3;j++)
                    {
                        result2[i][j] = result[i][j];
                    }
                }
                for(int k=0;k<3;k++)
                {
                    result2[count-1][k]=arr[k];
                }
                count++;
                result=result2;
                }
            return result;

//           

    } 
     public ArrayList getPowerOfAccount(String loginName) throws SQLException
    {
        
        ArrayList<String> list = new ArrayList<String>();
        PreparedStatement selectStatement1 = conn.prepareStatement("select distinct tendangnhap from taikhoan_quyen");
        PreparedStatement selectStatement = conn.prepareStatement("select id,tendangnhap,maquyen from taikhoan_quyen");
        ResultSet rs = selectStatement.executeQuery();
            while (rs.next()) {
                // will traverse through all rows
                String maquyen = rs.getString("maquyen");
                list.add(maquyen);
                
            }
     return list;       
//   

    }
}