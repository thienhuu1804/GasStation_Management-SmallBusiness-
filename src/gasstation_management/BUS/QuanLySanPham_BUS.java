/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;

import gasstation_management.DAO.QuanLySanPham_DAO;
import gasstation_management.DTO.SanPham;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Utech
 */
public class QuanLySanPham_BUS {

    QuanLySanPham_DAO quanLySanPham_DAO = new QuanLySanPham_DAO();

    public ArrayList<SanPham> getDanhSachSanPham(int selectedIndex, String textTimKiem) {
        ArrayList<SanPham> result = new ArrayList<>();
        if (selectedIndex == 0 && textTimKiem.equals("") == true) {
            ArrayList<SanPham> sanPhams = new ArrayList<>();

            sanPhams = quanLySanPham_DAO.getDanhSachSanPham();
            return result = sanPhams;
        }
        
        if(selectedIndex == 0 && textTimKiem.equals("") == false) {
            ArrayList<SanPham> sanPhams = new ArrayList<>();
            sanPhams = quanLySanPham_DAO.getDanhSachSanPham();
            
            for(SanPham sp : sanPhams) {
                if(textTimKiem.equalsIgnoreCase(sp.getMaSanPham()))
                    result.add(sp);
                if(textTimKiem.equalsIgnoreCase(sp.getTenSanPham()))
                    result.add(sp);
            }
            return result;
        }
        return null;
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
