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
//import gasstation_management.DTO.QuyenTaiKhoan;
import java.util.ArrayList;
import java.util.Vector;

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
    
     QuanLyQuyenTaiKhoan_DAO quanLyQuyenTaiKhoan_DAO = new QuanLyQuyenTaiKhoan_DAO();
        ArrayList<TaiKhoan> danhSachTaiKhoan = new ArrayList<>();
        ArrayList<Quyen> danhSachQuyen = new ArrayList<>();
        QuanLyTaiKhoan_DAO quanlytaikhoan_Dao = new QuanLyTaiKhoan_DAO();
   public QuanLyQuyenTaiKhoan_BUS()
    {
        
        
    }
    public void DisplayAccountCheckBox(int selectedRow) {
        
        
        
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
         ArrayList arrlist = new ArrayList<>();
        for (TaiKhoan taiKhoan : danhSachTaiKhoan) {
            ArrayList<String> dsQuyen = new ArrayList<>();
            String chuoiQuyen = "";
            String ngaySuaGanNhat = "";
            for (QuyenTaiKhoan quyen : danhSachQuyenTaiKhoan) {
                if (taiKhoan.getTenDangNhap().equalsIgnoreCase(quyen.getTenDangNhap())) {
                    dsQuyen.add(quyen.getMaQuyen());
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
            chuoiQuyen = chuoiQuyen.substring(0, chuoiQuyen.length() - 2);
            Vector data = new Vector();
                data.add(taiKhoan.getTenDangNhap());
                data.add(chuoiQuyen);
                data.add(taiKhoan.getTrangThai());
                data.add(ngaySuaGanNhat);
                arrlist.add(data);
        }
        return arrlist;
    }

    // lấy tên tài khoản dựa vào dòng được chọn từ bản
    public ArrayList PrivilegeListAccountSelected(int indexRow) {
           return null;
    }
}
