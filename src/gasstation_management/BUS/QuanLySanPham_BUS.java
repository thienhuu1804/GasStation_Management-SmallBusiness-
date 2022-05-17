/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;

import gasstation_management.DAO.QuanLySanPham_DAO;
import gasstation_management.DTO.SanPham;
import java.util.ArrayList;

/**
 *
 * @author Utech
 */
public class QuanLySanPham_BUS {
    QuanLySanPham_DAO quanLySanPham_DAO = new QuanLySanPham_DAO();
    
    public ArrayList<SanPham> getDanhSachSanPham() {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        sanPhams = quanLySanPham_DAO.getDanhSachSanPham();
        return sanPhams;
    }
    
    public boolean themSanPham(SanPham sp) {
        return quanLySanPham_DAO.addSanPham(sp);
    }
    
    public void suaSanPham(SanPham sp, String maspCu) {
        quanLySanPham_DAO.updateSanPham(sp, maspCu);
    }

    public void xoaSanPham(String masp) {
        quanLySanPham_DAO.deleteSanPham(masp);
    }
    
    public String getMaSanPhamcu(int index) {
        
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        sanPhams = quanLySanPham_DAO.getDanhSachSanPham();
        return sanPhams.get(index).getMaSanPham();
    }
}
