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
public class HoaDon {
    private String mahd;
    private String masp;
    private String ngaytao;
    private float soluong;
    private String tongtien;

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public void setSoluong(float soluong) {
        this.soluong = soluong;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public String getMahd() {
        return mahd;
    }

    public String getMasp() {
        return masp;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public float getSoluong() {
        return soluong;
    }

    public String getTongtien() {
        return tongtien;
    }
            
           
}
