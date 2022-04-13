/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasstation_management.BUS;

import gasstation_management.DTO.TaiKhoan;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class QuanLyTaiKhoan_BUS {

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
        System.out.println(hashedInput);
        return hashedInput.equalsIgnoreCase(hashedPwd);
    }
}
