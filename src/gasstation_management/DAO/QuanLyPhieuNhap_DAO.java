/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DAO;

import gasstation_management.DBConnect;
import gasstation_management.DTO.PhieuNhap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuong
 */
public class QuanLyPhieuNhap_DAO {
      DBConnect db = new DBConnect();
    ResultSet rs = null;
    // Lấy thông tin của các phiếu nhập
    public ArrayList getALLPhieuNhap() {
        
        ArrayList result = new ArrayList<>();
        db.setupConnection();
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select phieunhap.mapn,phieunhap.masp,phieunhap.soluong,phieunhap.ngaytao,phieunhap.trangthai,phieunhap.tongtien from phieunhap");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    PhieuNhap pn=  new PhieuNhap();
                    pn.setMapn(rs.getString(1));
                    pn.setMasp(rs.getString(2));
                    pn.setSoluong(Integer.parseInt(rs.getString(3)));
                    pn.setNgaytao(rs.getString(4));
                    pn.setTrangthai(rs.getString(5));
                    pn.setTongtien(rs.getString(6));
                    result.add(pn);
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
// Lấy thông tin chi tiết của phiếu nhập
    public ArrayList getDetailPhieuNhap(String mapn) {
        
        ArrayList result = new ArrayList<>();
        db.setupConnection();
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select phieunhap.mapn,phieunhap.masp,phieunhap.mancc,nhanvien.tennv ,sanpham.tensp,phieunhap.soluong,phieunhap.ngaytao,phieunhap.trangthai,phieunhap.gianhap, phieunhap.tongtien from phieunhap, sanpham,nhanvien where phieunhap.masp=sanpham.masp and phieunhap.manv=nhanvien.manv and phieunhap.mapn=?");
            stm.setString(1,mapn);
            rs = db.sqlQry(stm);
                                System.out.println(rs);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString(1));
                    result.add(rs.getString(2));
                    result.add(rs.getString(3));
                    result.add(rs.getString(4));
                    result.add(rs.getString(5));
                    result.add(Integer.toString(rs.getInt(6)));
                    result.add(rs.getString(7));
                    result.add(rs.getString(8));
                    result.add(Integer.toString(rs.getInt(9)));
                    result.add(rs.getString(10));

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

    public ArrayList getManv() {
        
        
        
        ArrayList result = new ArrayList<>();
        db.setupConnection();
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select manv from nhanvien");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString(1));
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
    
     public ArrayList getMapn() {
        
        
        
        ArrayList result = new ArrayList<>();
        db.setupConnection();
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select mapn from phieunhap");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString(1));
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
     
      public ArrayList getMancc() {
        
        
        
        ArrayList result = new ArrayList<>();
        db.setupConnection();
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select mancc from nhacungcap");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString(1));
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
      
       public ArrayList getMasp() {
        
        
        
        ArrayList result = new ArrayList<>();
        db.setupConnection();
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select masp from sanpham");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString(1));
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
// Hàm thêm phiếu nhập
    public boolean addPhieuNhap(PhieuNhap pn) {
        
        db.setupConnection();
        try {
            String sql = "insert into phieunhap values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);
            stm.setString(1,pn.getMapn());
            stm.setString(2,pn.getMasp());
            stm.setString(3,pn.getManv());
            stm.setString(4,pn.getMancc());
            stm.setString(5,pn.getNgaytao());
            stm.setInt(6,pn.getSoluong());
            stm.setInt(7,pn.getGianhap());
            stm.setString(8,pn.getTrangthai());
            stm.setString(9,pn.getTongtien());


            return db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            db.closeConnection();
        }
    }
   // Lấy thông tin để xuất excel
    public ArrayList getALLPhieuNhap2() {
        
         ArrayList result = new ArrayList<>();
        db.setupConnection();
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select phieunhap.mapn,sanpham.tensp,nhacungcap.tenncc,nhanvien.tennv,phieunhap.soluong,phieunhap.gianhap,phieunhap.ngaytao,phieunhap.trangthai, phieunhap.tongtien from phieunhap, sanpham,nhanvien,nhacungcap where phieunhap.masp=sanpham.masp and phieunhap.manv=nhanvien.manv and phieunhap.mancc=nhacungcap.mancc");
            rs = db.sqlQry(stm);
                                System.out.println(rs);
            if (rs != null) {
                while (rs.next()) {
                   
                    Vector arr = new Vector();
                    arr.add(rs.getString(1));
                    arr.add(rs.getString(2));
                    arr.add(rs.getString(3));
                    arr.add(rs.getString(4));
                    arr.add(Integer.toString(rs.getInt(5)));
                    arr.add(Integer.toString(rs.getInt(6)));
                    arr.add(rs.getString(7));
                    arr.add(rs.getString(8));
                    arr.add(rs.getString(9));

                    result.add(arr);
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

    public Boolean addSoLuongSanpham(String masp,Double soluong) {
        
        
        
        db.setupConnection();
        try {
            String sql = "UPDATE sanpham set soluong=? where masp=?";
            PreparedStatement stm = db.getConnection().prepareStatement(sql);
            stm.setFloat(1,soluong.floatValue());
            stm.setString(2,masp);

            
            return db.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            db.closeConnection();
        }
    }
        
        
    }
   