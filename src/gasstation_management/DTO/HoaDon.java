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
    private String matrubom;
    private String masp;
    private LocalDateTime ngaytao;
    private float soluong;
    private String tongtien;

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setMatrubom(String matrubom) {
        this.matrubom = matrubom;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setNgaytao(LocalDateTime ngaytao) {
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

    public String getMatrubom() {
        return matrubom;
    }

    public String getMasp() {
        return masp;
    }

    public LocalDateTime getNgaytao() {
        return ngaytao;
    }

    public float getSoluong() {
        return soluong;
    }

    public String getTongtien() {
        return tongtien;
    }
            
           
}
