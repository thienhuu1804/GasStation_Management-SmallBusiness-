/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// *
// * @author Vuong
// */
package gasstation_management.DTO;
//
public class TaiKhoan_Quyen {

    @Override
    public String toString() {
        return "TaiKhoan_Quyen{" + "id=" + id + ", tendangnhap=" + tendangnhap + ", maquyen=" + maquyen + ", ngaysua=" + ngaysua + '}';
    }

    public TaiKhoan_Quyen() {
    }
    
    public int getId() {
        return id;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public String getMaquyen() {
        return maquyen;
    }

    public String getNgaysua() {
        return ngaysua;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }

    public void setNgaysua(String ngaysua) {
        this.ngaysua = ngaysua;
    }
    
    private int id;
    private String tendangnhap;
    private String maquyen;
    private String ngaysua;
    
}
