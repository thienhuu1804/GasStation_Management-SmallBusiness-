/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.DTO;

import java.time.LocalDateTime;

/**
 *
 * @author nguye
 */
public class Gia {
    String masp;
    LocalDateTime ngayApDung;
    int gia;
    LocalDateTime ngayKetThuc;

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public LocalDateTime getNgayApDung() {
        return ngayApDung;
    }

    public void setNgayApDung(LocalDateTime ngayApDung) {
        this.ngayApDung = ngayApDung;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public LocalDateTime getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDateTime ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
    
}
