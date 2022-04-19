/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.BUS;

import gasstation_management.DAO.QuanLyQuyenTaiKhoan_DAO;
import gasstation_management.DTO.Quyen;
import gasstation_management.DTO.QuyenTaiKhoan;
import gasstation_management.DTO.TaiKhoan;
import gasstation_management.DAO.QuanLyQuyen_DAO;
import gasstation_management.DAO.QuanLyTaiKhoan_DAO;

import static gasstation_management.Main.DATETIME_FORMATTER;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import gasstation_management.DTO.QuyenTaiKhoan;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author nguye
 */
public class QuanLyQuyenTaiKhoan_BUS {
     QuanLyQuyenTaiKhoan_DAO quanLyQuyenTaiKhoan_DAO = new QuanLyQuyenTaiKhoan_DAO();
        ArrayList<TaiKhoan> danhSachTaiKhoan = new ArrayList<>();
        ArrayList<Quyen> danhSachQuyen = new ArrayList<>();
        QuanLyTaiKhoan_DAO quanlytaikhoan_Dao = new QuanLyTaiKhoan_DAO();
        QuanLyQuyen_DAO quanLyQuyen = new QuanLyQuyen_DAO();
   public QuanLyQuyenTaiKhoan_BUS()
    {     
        
    }

    public ArrayList<QuyenTaiKhoan> getDanhSachQuyenTaiKhoan(){
        return quanLyQuyenTaiKhoan_DAO.getDanhSachQuyenTaiKhoan();
    }
    
    
    
    public ArrayList getDanhSanhtaiKhoanDaCongQuyen(int selected,String getTextOftxtTimKiem){
        ArrayList<QuyenTaiKhoan> danhSachQuyenTaiKhoan = new ArrayList<>();
        danhSachQuyenTaiKhoan = quanLyQuyenTaiKhoan_DAO.getDanhSachQuyenTaiKhoan();
        QuanLyQuyen_DAO quanLyQuyen = new QuanLyQuyen_DAO();
        danhSachQuyen = quanLyQuyen.QuyenAll();
        if (selected == 0) {
            danhSachTaiKhoan = quanlytaikhoan_Dao.getDanhSachTaiKhoan();
        }
        if (selected == 1) {
            danhSachTaiKhoan = quanlytaikhoan_Dao.timKiemTheoTenDangNhap(getTextOftxtTimKiem);
        }
        if (selected == 2){
            danhSachTaiKhoan = quanlytaikhoan_Dao.timKiemTheoTrangThai(getTextOftxtTimKiem);
        }
         // Setdata vào table
         ArrayList<Vector> arrlist = new ArrayList<>();
        for (TaiKhoan taiKhoan : danhSachTaiKhoan) {
            ArrayList<String> dsQuyen = new ArrayList<>();
            String chuoiQuyen = "";
            String ngaySuaGanNhat = "";
            for (QuyenTaiKhoan quyen : danhSachQuyenTaiKhoan) {
                if (taiKhoan.getTenDangNhap().equalsIgnoreCase(quyen.getTenDangNhap())) {
                    dsQuyen.add(quyen.getMaQuyen());  // Lấy được danh sách mã quyền của một tài khoản
                    ngaySuaGanNhat = quyen.getNgaySua().format(DATETIME_FORMATTER);
                }
            }
            for (String x : dsQuyen) {
                for (Quyen q : danhSachQuyen) {
                    if (x.equalsIgnoreCase(q.getMaQuyen())) {
                        chuoiQuyen += q.getMoTaQuyen() + ", ";
                    }
                }
            }
            if(chuoiQuyen.length()!=0)
            {
                chuoiQuyen = chuoiQuyen.substring(0, chuoiQuyen.length() - 1);
            }
            Vector data = new Vector();
                data.add(taiKhoan.getTenDangNhap());
                data.add(chuoiQuyen);
                data.add(taiKhoan.getTrangThai());
                data.add(ngaySuaGanNhat);
                arrlist.add(data);
        }
        return arrlist;
    }

    // lấy tên tài khoản dựa vào dòng được chọn từ bảng
    public String getAccountName(int indexRow) {
            ArrayList list = new ArrayList();
            Vector account = new Vector<>();
            list = getDanhSanhtaiKhoanDaCongQuyen(0,null);
            account = (Vector) list.get(indexRow);
            
           return (String) account.get(0);
    }
   // Lấy danh sách quyền của tài khoản được chọn
    public ArrayList getPrivilegeListOfAccount(String accountName){
         ArrayList list = new ArrayList<>();
            list = quanLyQuyenTaiKhoan_DAO.getQuyenCuaMotTaiKhoan(accountName);
        return list;
    }
   // cập nhật lại quyền tài khoản
    public void updatePrivilegeOfAccount_Bus(ArrayList privilegeList,String accountName) {
        ArrayList  list = new ArrayList();
        int lastId;
         String maquyen;
        quanLyQuyenTaiKhoan_DAO.removeAllQuyenTaiKhoan(accountName);
        // dannh sách tai khoản và quyền đang có trong database
       list = quanLyQuyenTaiKhoan_DAO.getDanhSachQuyenTaiKhoan();
      QuyenTaiKhoan quyen1 = new QuyenTaiKhoan();
       quyen1 = (QuyenTaiKhoan) list.get(list.size()-1);
       lastId = quyen1.getId(); // lấy chỉ số id cuối cùng trong bảng
           LocalDateTime now = LocalDateTime.now();
           String ngaysua= now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
       for(int i=0;i<privilegeList.size();i++)
       {
                      QuyenTaiKhoan quyen = new QuyenTaiKhoan();
           maquyen = quanLyQuyen.getMaQuyen((String) privilegeList.get(i));
           
           quyen.setId(i+1+lastId);
           quyen.setMaQuyen(maquyen);
           quyen.setTenDangNhap(accountName);
           quyen.setNgaySua(LocalDateTime.parse(ngaysua, DATETIME_FORMATTER));
          
           quanLyQuyenTaiKhoan_DAO.addQuyenTaiKhoan(quyen);
       }

       }
}
