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
public class TaiKhoan {

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    String tenDangNhap;
    String maNV;
    String matKhau;
    LocalDateTime ngayTao;
    String trangThai;
}
