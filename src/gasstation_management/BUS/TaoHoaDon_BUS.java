/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;

import gasstation_management.DAO.TaoHoaDon_DAO;
import gasstation_management.DTO.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author Utech
 */
public class TaoHoaDon_BUS {

    TaoHoaDon_DAO taoHoaDon_DAO = new TaoHoaDon_DAO();

    public ArrayList<HoaDon> getDanhSachHoaDon() {
        return taoHoaDon_DAO.getDanhSachHoaDon();
    }

    public boolean addHoaDon(HoaDon hd) {
//        QuanLySanPham_BUS
        return taoHoaDon_DAO.addHoaDon(hd);
    }
}
