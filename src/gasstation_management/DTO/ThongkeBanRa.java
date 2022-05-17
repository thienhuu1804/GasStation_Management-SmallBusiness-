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
public class ThongkeBanRa {
    private String masp;
    private String tensp;
    private String mahd;
    private float soluong;
    private int giaban;
    private LocalDateTime thoigian;
    private int tongtien;

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setSoluong(float soluong) {
        this.soluong = soluong;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
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

    public String getMahd() {
        return mahd;
    }

    public float getSoluong() {
        return soluong;
    }

    public int getGiaban() {
        return giaban;
    }

    public LocalDateTime getThoigian() {
        return thoigian;
    }

    public int getTongtien() {
        return tongtien;
    }
    
}
