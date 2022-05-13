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

     QuanLyNhanVien_DAO quanLyNhanVien_Dao = new QuanLyNhanVien_DAO();
    public ArrayList getDanhSanhNhanVien() {
        
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();
        ArrayList<Vector> arrlist = new ArrayList<>();
        danhSachNhanVien = quanLyNhanVien_Dao.getDanhNhanVien();
        for (NhanVien nhanvien : danhSachNhanVien) {
            Vector data = new Vector();
                data.add(nhanvien.getManv());
                data.add(nhanvien.getTennv());
                data.add(nhanvien.getSdt());
                data.add(nhanvien.getDiachi());
                data.add(nhanvien.getCmnd());
                data.add(nhanvien.getTrangthai());                         
                arrlist.add(data);
        }
        return arrlist;
    
}
}
