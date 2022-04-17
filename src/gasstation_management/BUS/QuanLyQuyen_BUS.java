/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;

import gasstation_management.DAO.QuanLyQuyen_DAO;
import gasstation_management.DTO.Quyen;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class QuanLyQuyen_BUS {

    QuanLyQuyen_DAO danhSachQuyen_DAO = new QuanLyQuyen_DAO();

    public ArrayList<Quyen> QuyenAll() {
        return danhSachQuyen_DAO.QuyenAll();
    }

}
