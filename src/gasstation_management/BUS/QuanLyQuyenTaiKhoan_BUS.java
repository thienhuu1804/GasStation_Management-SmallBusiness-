/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.BUS;

import gasstation_management.DAO.QuanLyQuyenTaiKhoan_DAO;
import gasstation_management.DTO.QuyenTaiKhoan;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class QuanLyQuyenTaiKhoan_BUS {
    ArrayList<QuyenTaiKhoan> danhSachTaiKhoan = new ArrayList<>();
    QuanLyQuyenTaiKhoan_DAO quanLyTaiKhoan_DAO = new QuanLyQuyenTaiKhoan_DAO();
    
    public ArrayList<QuyenTaiKhoan> getDanhSachQuyenTaiKhoan(){
        return quanLyTaiKhoan_DAO.getDanhSachQuyenTaiKhoan();
    }
}
