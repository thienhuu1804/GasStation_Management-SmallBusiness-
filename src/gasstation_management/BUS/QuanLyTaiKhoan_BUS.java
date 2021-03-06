/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.BUS;

//import java.sql.PreparedStatement;
import gasstation_management.DAO.QuanLyTaiKhoan_DAO;
import gasstation_management.DTO.TaiKhoan;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class QuanLyTaiKhoan_BUS {

    ArrayList<TaiKhoan>  dstk = new ArrayList<>();
    QuanLyTaiKhoan_DAO qltkDAO = new QuanLyTaiKhoan_DAO();
    
    
    public ArrayList<TaiKhoan> timKiemTheoTenDangNhap(String tenDangNhap) {
        ArrayList<TaiKhoan> result = qltkDAO.timKiemTheoTenDangNhap(tenDangNhap);
        return result;
    }

    public ArrayList<TaiKhoan> timKiemTheoTrangThai(String tenDangNhap) {
        ArrayList<TaiKhoan> result = qltkDAO.timKiemTheoTrangThai(tenDangNhap);
        return result;
    }

    public ArrayList<TaiKhoan> getDanhSachTaiKhoan() {
        ArrayList<TaiKhoan> result = qltkDAO.getDanhSachTaiKhoan();
        return result;
    }

    public void addTaiKhoan(TaiKhoan tk) {
        qltkDAO = new QuanLyTaiKhoan_DAO();
        qltkDAO.addTaiKhoan(tk);
    }

    public boolean updateTaiKhoan(TaiKhoan tk) {
        return qltkDAO.updateTaiKhoan(tk);
    }

   public void toggleTaiKhoan(String tk, String status){
       qltkDAO = new QuanLyTaiKhoan_DAO();
       if(status.equals("Active"))
            qltkDAO.KhoaTaiKhoan(tk);
       if(status.equals("Unactive"))
            qltkDAO.MoTaiKhoan(tk);
   }
    public String getHashedPwd(String inputPwd) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return getHashedPwd(inputPwd, salt);
    }

    // Mã hoá chuỗi pwd khi có salt (Dùng khi muốn verify)
    public String getHashedPwd(String inputPwd, byte[] salt) {
        byte[] hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            hashedPassword = md.digest(inputPwd.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Pwd lưu lại có gắn salt ở đầu để sau này lấy ra verify
        return Base64.getEncoder().encodeToString(salt) + "$" + Base64.getEncoder().encodeToString(hashedPassword);
    }

    // Verify pwd. inputPwd: pwd nhận thẳng từ người dùng. hashedPwd: pwd lưu trong db
    public boolean verifyPwd(String inputPwd, String hashedPwd) {
        byte[] salt = Base64.getDecoder().decode(hashedPwd.split("\\$")[0].getBytes());
        String hashedInput = getHashedPwd(inputPwd, salt);
        return hashedInput.equalsIgnoreCase(hashedPwd);
    }

    public TaiKhoan checkLogin(String username, String password) {
        ArrayList<TaiKhoan> account = new ArrayList<>();
        try {
            QuanLyTaiKhoan_DAO dao = new QuanLyTaiKhoan_DAO();
            account = dao.timKiemTheoTenDangNhap(username);
            if (!account.isEmpty()) {
                boolean match = verifyPwd(password, account.get(0).getMatKhau());
                if (match) {
                    return account.get(0);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(QuanLyTaiKhoan_BUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean checkTenDN (String tenDN)
    {
        for (TaiKhoan tk: dstk)
            if(tk.getTenDangNhap().equals(tenDN))
                return true;
        return false;
    }
    public boolean checkMaNV (String maNV)
    {
        for (TaiKhoan tk: dstk)
            if(tk.getMaNV().equals(maNV))
                return true;
        return false;
    }
}
