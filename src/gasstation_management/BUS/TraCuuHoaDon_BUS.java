/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.BUS;
import com.mysql.cj.result.LocalDateTimeValueFactory;
import gasstation_management.DAO.TraCuuHoaDon_DAO;
import gasstation_management.DAO.QuanLyQuyen_DAO;
import gasstation_management.DTO.Quyen;
import gasstation_management.DTO.HoaDon;
import gasstation_management.DTO.QuyenTaiKhoan;
import gasstation_management.DTO.TaiKhoan;
import static gasstation_management.Main.DATETIME_FORMATTER;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;


/**
 *
 * @author Vuong
 */
public class TraCuuHoaDon_BUS {

    TraCuuHoaDon_DAO traCuuHoaDon_DAO = new TraCuuHoaDon_DAO();
    public ArrayList getDanhSanhHoaDon(int selected, String key,Date dateStart,Date dateEnd ) {
         SimpleDateFormat dcn = new SimpleDateFormat("dd-MM-yyyy");
         LocalDateTime lb;
         String date;
         if(dateStart!=null)
         {
         }
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
        if (selected == 0) {
            danhSachHoaDon= traCuuHoaDon_DAO.getDanhSachHoaDon();
            
        }
        if(selected==1 && (dateStart==null || dateEnd==null))
        {
           ArrayList<HoaDon> danhSachHoaDonTimKiem = new ArrayList<>();
            danhSachHoaDonTimKiem= traCuuHoaDon_DAO.getDanhSachHoaDon();
 
            for(HoaDon hd : danhSachHoaDonTimKiem)
            {
                if(hd.getMahd().contains(key))
                {
                    danhSachHoaDon.add(hd);
                }
            }
        }
        if(selected==1 && (dateStart!=null && dateEnd!=null))
        {
            ArrayList<HoaDon> danhSachHoaDonTimKiemAndThoiGian = new ArrayList<>();
            danhSachHoaDonTimKiemAndThoiGian= traCuuHoaDon_DAO.getDanhSachHoaDon();
 
            for(HoaDon hd : danhSachHoaDonTimKiemAndThoiGian)
            {
                if(hd.getMahd().contains(key) && compareDate(hd.getNgaytao(), dateStart, dateEnd)==true )
                {
                    danhSachHoaDon.add(hd);
                }
            }

        }
        if(selected==2 && (dateStart==null || dateEnd==null))
        {
            ArrayList<HoaDon> danhSachHoaDonTimKiemAndThoiGian= new ArrayList<>();
            danhSachHoaDonTimKiemAndThoiGian= traCuuHoaDon_DAO.getDanhSachHoaDon();
 
            for(HoaDon hd : danhSachHoaDonTimKiemAndThoiGian)
            {
                if(hd.getMasp().contains(key))
                {
                    danhSachHoaDon.add(hd);
                }
            }

        }
        if(selected==2 && (dateStart!=null && dateEnd!=null))
        {
            ArrayList<HoaDon> danhSachHoaDonTimKiemAndThoiGian= new ArrayList<>();
            danhSachHoaDonTimKiemAndThoiGian= traCuuHoaDon_DAO.getDanhSachHoaDon();
 
            for(HoaDon hd : danhSachHoaDonTimKiemAndThoiGian)
            {
                if(hd.getMasp().contains(key) && compareDate(hd.getNgaytao(), dateStart, dateEnd)==true )
                {
                    danhSachHoaDon.add(hd);
                }
            }

        }
        
//        
       int stt =1;
        ArrayList arrlist = new ArrayList();
            for(HoaDon hd : danhSachHoaDon)
            {
            Vector data = new Vector();
                data.add(stt);
                data.add(hd.getMahd());
                data.add(hd.getMatrubom());
                data.add(hd.getMasp());
                data.add(hd.getNgaytao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss")));
                data.add(hd.getSoluong());
                data.add(hd.getTongtien());
                arrlist.add(data);
                stt++;
            }
        return arrlist;
    }
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

    public ArrayList getDetailHoaDon_BUS(String mahd) {
        return traCuuHoaDon_DAO.getDetailHoaDon_DAO(mahd);
    }

    public ArrayList getDetailAllHoaDon_BUS(Vector indexMahd) {
                ArrayList list = new ArrayList();
                     list=   traCuuHoaDon_DAO.getDetailALLHoaDon_DAO();
                     ArrayList result = new ArrayList();
                  for (int j=0;j<list.size();j++)
                  {
                        Vector<String> x = new Vector<>();
                             x = (Vector) list.get(j);
                      for(int i=0;i<indexMahd.size();i++)
                       {
                                                 System.out.println(indexMahd.get(i));
                          String y=              (String) indexMahd.get(i);
                          if(x.get(0).equals(y)==true)
                           {
                               System.out.println("Vuong");
                             result.add(x);
                           }
                       }
              }
        return result;
    }
}
