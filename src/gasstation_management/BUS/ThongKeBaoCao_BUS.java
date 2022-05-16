/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;

import gasstation_management.DTO.HoaDon;
import java.util.ArrayList;
import gasstation_management.DAO.ThongKeBaoCao_DAO;
import java.util.Date;
import gasstation_management.DTO.ThongkeBanRa;
import gasstation_management.DTO.ThongKeNhapVao;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Vector;

/**
 *
 * @author Vuong
 */
public class ThongKeBaoCao_BUS {

    ThongKeBaoCao_DAO thongKeBaoCao_DAO = new ThongKeBaoCao_DAO();
    
    
    
    // Hàm thống kê phiếu nhập vào
    public ArrayList getThongkeNhapVao_BUS(int selectedIndex,String textTimKiem,Date dateStart,Date dateEnd) {
        
        ArrayList<ThongKeNhapVao> listThongke = new ArrayList();
        if (selectedIndex == 0 && (dateStart==null || dateEnd==null) && textTimKiem.equals("")) {
           ArrayList<ThongKeNhapVao>  listThongKeNhapVao  = new ArrayList<>(); 
                    listThongke= thongKeBaoCao_DAO.getThongKeNhapVao();
        }
        
        if(selectedIndex==0 && (dateStart!=null && dateEnd!=null))
        {
         ArrayList<ThongKeNhapVao>  listThongKeNhapVao  = new ArrayList<>(); 

           listThongKeNhapVao= thongKeBaoCao_DAO.getThongKeNhapVao();
 
            for(ThongKeNhapVao tknv: listThongKeNhapVao)
            {
                if(compareDate(tknv.getThoigian(), dateStart, dateEnd)==true )
                {
                   
                    listThongke.add(tknv);
                }
            }

        }
        
        if(selectedIndex==0 && (dateStart==null || dateEnd==null) && textTimKiem.equals("")==false)
        {
         ArrayList<ThongKeNhapVao>  listThongKeNhapVao  = new ArrayList<>(); 

           listThongKeNhapVao= thongKeBaoCao_DAO.getThongKeNhapVao();
 
            for(ThongKeNhapVao tknv: listThongKeNhapVao)
            {
                if(textTimKiem.equals(tknv.getMasp()))
                {
                    listThongke.add(tknv);
                }
                if(textTimKiem.equals(tknv.getMapn()))
                {
                    listThongke.add(tknv);
                }
                if(textTimKiem.equals(tknv.getTensp()))
                {
                    listThongke.add(tknv);
                }
                if(textTimKiem.equals(tknv.getNcc()))
                {
                    listThongke.add(tknv);
                }
                
            }

        }
        
        
        // Lấy các mã sản phẩm của phiếu nhập
        ArrayList<String> eleUnique= new ArrayList();
        for(ThongKeNhapVao tknv: listThongke)
        {
            eleUnique.add(tknv.getMasp());
        }
         // Lấy mã sản phẩm duy nhất

        HashSet<String> uniqueValues = new HashSet<>(eleUnique);
        int stt=1;
        int tongtien;
        ArrayList arrlist = new ArrayList();
        for(String uniqueEle : uniqueValues)
           {
             tongtien = 0;
            for(ThongKeNhapVao tknv: listThongke)
            {
                
                    if(tknv.getMasp().equals(uniqueEle))
                    {
                Vector data = new Vector();
                data.add(stt);
                data.add(tknv.getMasp());
                data.add(tknv.getTensp());
                data.add(tknv.getMapn());
                data.add(tknv.getNcc());
                data.add(tknv.getSoluong());
                data.add(tknv.getGianhap());

                data.add(tknv.getThoigian().format(DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss")));
                data.add(tknv.getTongtien());
                arrlist.add(data);
                stt++;
                tongtien +=tknv.getTongtien();
                }
            }
           Vector tongTienPhieuNhap = new Vector();

            for(int i=0;i<9;i++)
            {
                if(i!=8)
                {
                                  tongTienPhieuNhap.add("");

                }
                else
                {
                    tongTienPhieuNhap.add(tongtien);
                }
            }
            arrlist.add(tongTienPhieuNhap);
            stt=1;
           }
        return arrlist;
                
    }
    
    
    
    
    // Hàm so sánh thời gian
    public Boolean compareDate(LocalDateTime localdatetime,Date dateStart,Date dateEnd)
          {
        Instant instant = localdatetime.atZone(ZoneId.systemDefault()).toInstant();
	       Date date2 = Date.from(instant);
        Boolean flag=false;
        if(date2.after(dateStart)==true && dateEnd.after(date2)==true)
        {
            flag = true;
        }
        return flag;
        
         }
    
    
    
    
}
