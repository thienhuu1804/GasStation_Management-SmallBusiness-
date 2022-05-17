/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DTO;

/**
 *
 * @author Vuong
 */
public class PhieuNhap {
    public String getMapn() {
        return mapn;
    }

    public String getMasp() {
        return masp;
    }

    public String getManv() {
        return manv;
    }

    public String getMancc() {
        return mancc;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getGianhap() {
        return gianhap;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setMapn(String mapn) {
        this.mapn = mapn;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }
    private String mancc;
    private String ngaytao;
    private int soluong;
    private int gianhap;
    private String tongtien;
    private String mapn;
    private String masp;
    private String manv;
    private String trangthai;

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getTrangthai() {
        return trangthai;
    }
    
}
