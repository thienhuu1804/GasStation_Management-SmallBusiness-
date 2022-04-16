/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management.DTO;

/**
 *
 * @author admin
 */
public class DanhSachQuyen_DTO {
    String MaQuyen;
    String moTaQuyen;

    public DanhSachQuyen_DTO(String MaQuyen, String moTaQuyen) {
        this.MaQuyen = MaQuyen;
        this.moTaQuyen = moTaQuyen;
    }

    public String getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public String getMoTaQuyen() {
        return moTaQuyen;
    }

    public void setMoTaQuyen(String moTaQuyen) {
        this.moTaQuyen = moTaQuyen;
    }

}
//can mot khoa day do DATA tu SQL len JTABLE lam tren 3 lop