/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;

import gasstation_management.DAO.DanhSachQuyen_DAO;
import gasstation_management.DTO.DanhSachQuyen_DTO;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DanhSachQuyen_BUS {

    public  ArrayList<DanhSachQuyen_DTO> QuyenAll(){
        return DanhSachQuyen_DAO.QuyenAll();
    }

}
    

