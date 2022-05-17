/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;

import gasstation_management.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import gasstation_management.DTO.ThongKeNhapVao;
import gasstation_management.DTO.ThongkeBanRa;
import static gasstation_management.Main.DATETIME_FORMATTER;
import java.time.LocalDateTime;

import java.util.Vector;

/**
 *
 * @author Vuong
 */
public class ThongKeBaoCao_DAO {
       DBConnect db = new DBConnect();
      ResultSet rs = null;

    public ArrayList getThongKeNhapVao() {
        ArrayList<ThongKeNhapVao> result = new ArrayList<>();
        db.setupConnection();
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select sanpham.masp,sanpham.tensp,phieunhap.mapn,nhacungcap.tenncc,phieunhap.soluong,phieunhap.gianhap,phieunhap.ngaytao,phieunhap.tongtien from phieunhap,sanpham,nhacungcap where phieunhap.masp=sanpham.masp and phieunhap.mancc=nhacungcap.mancc");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    ThongKeNhapVao listThongKeNhapVao = new ThongKeNhapVao();
                    listThongKeNhapVao.setMasp(rs.getString(1));
                    listThongKeNhapVao.setTensp(rs.getString(2));
                    listThongKeNhapVao.setMapn(rs.getString(3));
                    listThongKeNhapVao.setNcc(rs.getString(4));
                    listThongKeNhapVao.setSoluong(Integer.parseInt(rs.getString(5)));
                    listThongKeNhapVao.setGianhap(Integer.parseInt(rs.getString(6)));
                    listThongKeNhapVao.setThoigian(LocalDateTime.parse(rs.getString(7), DATETIME_FORMATTER));
                    listThongKeNhapVao.setTongtien(Integer.parseInt(rs.getString(8)));
                    result.add(listThongKeNhapVao);
                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
System.out.println("Lỗi");
        }finally{
            db.closeConnection();
        }
        return result;
    }

    public ArrayList<ThongkeBanRa> getThongKeBanRa() {
        ArrayList<ThongkeBanRa> result = new ArrayList<>();
        db.setupConnection();
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select sanpham.masp,sanpham.tensp,hoadon.mahd,hoadon.soluong,gia.gia,hoadon.ngaytao,hoadon.tongtien from hoadon,sanpham,gia where hoadon.masp=sanpham.masp and sanpham.masp=gia.masp");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    ThongkeBanRa listThongKeBanRa = new ThongkeBanRa();
                    listThongKeBanRa.setMasp(rs.getString(1));
                    listThongKeBanRa.setTensp(rs.getString(2));
                    listThongKeBanRa.setMahd(rs.getString(3));
                    listThongKeBanRa.setSoluong(rs.getFloat(4));
                    listThongKeBanRa.setGiaban(Integer.parseInt(rs.getString(5)));
                    listThongKeBanRa.setThoigian(LocalDateTime.parse(rs.getString(6), DATETIME_FORMATTER));
                    listThongKeBanRa.setTongtien(Integer.parseInt(rs.getString(7)));
                    result.add(listThongKeBanRa);
                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
System.out.println("Lỗi");
        }finally{
            db.closeConnection();
        }
        return result;
    }
    
}
