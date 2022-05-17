/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;

import java.util.ArrayList;
import gasstation_management.DAO.QuanLyPhieuNhap_DAO;
import gasstation_management.DTO.HoaDon;
import gasstation_management.DTO.PhieuNhap;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

/**
 *
 * @author Vuong
 */
public class QuanLyPhieuNhap_BUS {

    QuanLyPhieuNhap_DAO quanLyPhieuNhap_DAO= new QuanLyPhieuNhap_DAO();
    public ArrayList getDanhSanhPhieuNhap(int selected, String text) {
          ArrayList<PhieuNhap> listPhieuNhap = new ArrayList();
          
        
        if(selected==0)
        {
                      listPhieuNhap=quanLyPhieuNhap_DAO.getALLPhieuNhap();

        }
        if(selected==1)
        {
            ArrayList<PhieuNhap> listPhu = new ArrayList<>();
                      listPhu=quanLyPhieuNhap_DAO.getALLPhieuNhap();
                      for(PhieuNhap pn: listPhu )
                      {
                          if(pn.getMapn().contains(text))
                          {
                              listPhieuNhap.add(pn);
                              System.out.println(pn.getMapn());
                          }
                      }

        }
        if(selected==2)
        {
            ArrayList<PhieuNhap> listPhu = new ArrayList<>();
                      listPhu=quanLyPhieuNhap_DAO.getALLPhieuNhap();
                      for(PhieuNhap pn: listPhu )
                      {
                          if(pn.getMasp().contains(text))
                          {
                              listPhieuNhap.add(pn);
                          }
                      }

        }
        if(selected==3)
        {
            ArrayList<PhieuNhap> listPhu = new ArrayList<>();
                      listPhu=quanLyPhieuNhap_DAO.getALLPhieuNhap();
                      for(PhieuNhap pn: listPhu )
                      {
                          if(pn.getTrangthai().contains(text))
                          {
                              listPhieuNhap.add(pn);
                          }
                      }

        }
        int stt=1;
        ArrayList arrlist = new ArrayList();
            for(PhieuNhap pn : listPhieuNhap)
            {
            Vector data = new Vector();
                data.add(stt);
                data.add(pn.getMapn());
                data.add(pn.getMasp());
                data.add(pn.getSoluong());
                data.add(pn.getNgaytao());
                data.add(pn.getTrangthai());
                data.add(pn.getTongtien());
                arrlist.add(data);
                stt++;
            }
        return arrlist;
    }

    public ArrayList getDetailPhieuNhap_BUS(String mapn) {
        ArrayList listDetailPhieuNhap = new ArrayList();
        
        listDetailPhieuNhap=quanLyPhieuNhap_DAO.getDetailPhieuNhap(mapn);
        return listDetailPhieuNhap;
    }

    public ArrayList getManv() {
                
        return quanLyPhieuNhap_DAO.getManv();
    }
    public ArrayList getMasp() {
                
        return quanLyPhieuNhap_DAO.getMasp();
    }public ArrayList getMapn() {
                
        return quanLyPhieuNhap_DAO.getMapn();
    }public ArrayList getMancc() {
                
        return quanLyPhieuNhap_DAO.getMancc();
    }

    public Boolean checkMapn(String mapn) {
        
        ArrayList<String> list= quanLyPhieuNhap_DAO.getMapn();
        for(String item:list)
        {
            if(item.equals(mapn))
            {
                            return false;

            }
        }
        return true;
    }

    public void addPhieuNhap_BUS(PhieuNhap pn) {
        quanLyPhieuNhap_DAO.addPhieuNhap(pn);
        System.out.println(pn.getMancc());
                System.out.println(pn.getMasp());
        System.out.println(pn.getManv());

    }
    
    
    
    
    
}
