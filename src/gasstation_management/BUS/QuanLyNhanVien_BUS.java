/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;

import gasstation_management.DAO.QuanLyQuyenTaiKhoan_DAO;
import gasstation_management.DAO.QuanLyQuyen_DAO;
import gasstation_management.DAO.QuanLyNhanVien_DAO;

import gasstation_management.DAO.QuanLyTaiKhoan_DAO;
import gasstation_management.DTO.NhanVien;
import gasstation_management.DTO.Quyen;
import gasstation_management.DTO.QuyenTaiKhoan;
import gasstation_management.DTO.TaiKhoan;
import static gasstation_management.Main.DATETIME_FORMATTER;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Vuong
 */
public class QuanLyNhanVien_BUS {

     QuanLyNhanVien_DAO quanLyNhanVien_DAO = new QuanLyNhanVien_DAO();
    public ArrayList getDanhSanhNhanVien() {
        
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();
        ArrayList<Vector> arrlist = new ArrayList<>();
        danhSachNhanVien = quanLyNhanVien_DAO.getDanhNhanVien();
        for (NhanVien nhanvien : danhSachNhanVien) {
            Vector data = new Vector();
                data.add(nhanvien.getManv());
                data.add(nhanvien.getTennv());
                data.add(nhanvien.getSdt());
                data.add(nhanvien.getDiachi());
                data.add(nhanvien.getTrangthai());                         
                arrlist.add(data);
        }
        return arrlist;
    
}
    // check mã nhân viên
    public Boolean checkManv_Them(String manv) {
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();
        danhSachNhanVien = quanLyNhanVien_DAO.getDanhNhanVien();
        Boolean flag = true;
        for(NhanVien nhanvien:danhSachNhanVien)
        {
         if(nhanvien.getManv().equalsIgnoreCase(manv))
         {
         flag = false;
         }
        }
        return flag;
    }
    
    // Hàm thêm một nhân viên
    public void addNhanVien_Bus(NhanVien nhanvien) {
        quanLyNhanVien_DAO.addNhanVien_Dao(nhanvien);
    }
    // Kiểm tra mã nhân viên có trùng không
    public Boolean checkManv_Sua(String manv, int selectedRow) {
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();
        danhSachNhanVien = quanLyNhanVien_DAO.getDanhNhanVien();
        Boolean flag = true;
        int count=0;
        for(NhanVien nhanvien:danhSachNhanVien)
        {
         if(nhanvien.getManv().equalsIgnoreCase(manv) && count!=selectedRow)
         {
         flag = false;
         }
                     count++;
        }
         return flag ;
        
    }

    // Sửa thông tin nhân viên
    public void SuaNhanVien_Bus(NhanVien nhanvien,String manvCu) {
        
        quanLyNhanVien_DAO.updateNhanVien(nhanvien,manvCu);
    }
   // xử lý lấy mã nhân viên được chọn để sửa
    public String getMaNhanViencu(int indexRow) {
        
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();
        danhSachNhanVien = quanLyNhanVien_DAO.getDanhNhanVien();
        return danhSachNhanVien.get(indexRow).getManv();
    }

    public void deleleNhanVien(String manv) {
        
        quanLyNhanVien_DAO.deleteNhanVien_DAO(manv);
    }
}
