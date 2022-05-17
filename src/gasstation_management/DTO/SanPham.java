/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DTO;

/**
 *
 * @author Utech
 */
public class SanPham {
    private String MaSanPham;
    private String TenSanPham;
    private float SoLuong;

    public String getMaSanPham() {
        return MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public float getSoLuong() {
        return SoLuong;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public void setSoLuong(float SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}
