/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DTO;
import java.time.LocalDateTime;

/**
 *
 * @author Vuong
 */
public class ThongKeNhapVao {
    private String masp;
    private String tensp;
    private String mapn;
    private String ncc;
    private int soluong;
    private int gianhap;
    private LocalDateTime thoigian;
    private int tongtien;

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setMapn(String mapn) {
        this.mapn = mapn;
    }

    public void setNcc(String ncc) {
        this.ncc = ncc;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public void setThoigian(LocalDateTime thoigian) {
        this.thoigian = thoigian;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getMasp() {
        return masp;
    }

    public String getTensp() {
        return tensp;
    }

    public String getMapn() {
        return mapn;
    }

    public String getNcc() {
        return ncc;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getGianhap() {
        return gianhap;
    }

    public LocalDateTime getThoigian() {
        return thoigian;
    }

    public int getTongtien() {
        return tongtien;
    }
    
}
