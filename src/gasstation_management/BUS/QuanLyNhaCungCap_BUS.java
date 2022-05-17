/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;

import gasstation_management.DTO.NhaCungCap;
import gasstation_management.DAO.QuanLyNhaCungCap_DAO;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Vuong
 */
public class QuanLyNhaCungCap_BUS {

    QuanLyNhaCungCap_DAO quanLyNhaCungCap_DAO = new QuanLyNhaCungCap_DAO();
    public Boolean checkMancc_Them(String mancc) {
        ArrayList<NhaCungCap> danhSachNhaCungCap = new ArrayList<>();
        danhSachNhaCungCap = quanLyNhaCungCap_DAO.getDanhSachNhaCungCap();
        Boolean flag = true;
        for(NhaCungCap ncc:danhSachNhaCungCap)
        {
         if(ncc.getMancc().equalsIgnoreCase(mancc))
         {
         flag = false;
         }
        }
        return flag;
    }

    public void addNhaCungCap_BUS(NhaCungCap ncc) {
        
                quanLyNhaCungCap_DAO.addNhaCungCap_Dao(ncc);

    }
// hàm lấy thông tin của nhà cung cấp để hiển thị ra bảng
    public ArrayList getDanhSachNhaCungCap_BUS() {
        ArrayList<NhaCungCap> danhSachNhaCungCap = new ArrayList<>();
        danhSachNhaCungCap = quanLyNhaCungCap_DAO.getDanhSachNhaCungCap();
        ArrayList<Vector> arrlist = new ArrayList<>();
        int STT=1;
        for (NhaCungCap nhancc : danhSachNhaCungCap) {
            Vector data = new Vector();
                data.add(STT);
                data.add(nhancc.getMancc());
                data.add(nhancc.getTenncc());
                data.add(nhancc.getDiachi());
                data.add(nhancc.getSDT());                         
                arrlist.add(data);
                STT++;
        }
        return arrlist;
    }

    public String autoAddMancc() {
        
        ArrayList<NhaCungCap> danhSachNhaCungCap = new ArrayList<>();
        danhSachNhaCungCap = quanLyNhaCungCap_DAO.getDanhSachNhaCungCap();
        int i=0;
        for(NhaCungCap ncc: danhSachNhaCungCap)
        {
            i++;
        }
        NhaCungCap ncc = danhSachNhaCungCap.get(i-1);
        String mancc=ncc.getMancc();
        String[] list= mancc.split("NCC");
        int value = Integer.parseInt(list[1]);
        String y = Integer.toString(value+1);
        
        return "NCC".concat(y);
    }
    
}
