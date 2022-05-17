/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasstation_management;
import gasstation_management.BUS.TraCuuHoaDon_BUS;
import gasstation_management.BUS.QuanLyPhieuNhap_BUS;
import gasstation_management.BUS.ThongKeBaoCao_BUS;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
/**
 *
 * @author Vuong
 */
public class XuatExcel {
    FileDialog fd = new FileDialog(new JFrame(), "Xuất excel", FileDialog.SAVE);

    private String getFile() {
        fd.setFile("untitled.xls");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }
    
    public void xuatFileExcelNhanVien() {
        fd.setTitle("Xuất dữ liệu nhân viên ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Nhân viên");

//            QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();
            ArrayList list = new  ArrayList();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(2, CellType.STRING).setCellValue("Tên nhân viên");
            row.createCell(3, CellType.STRING).setCellValue("Ngày sinh");
            row.createCell(4, CellType.STRING).setCellValue("Địa chỉ");
            row.createCell(5, CellType.STRING).setCellValue("Số điện thoại");
            row.createCell(6, CellType.STRING).setCellValue("Trạng thái");

//            for (NhanVien nv : list) {
//                rownum++;
                 rownum=1;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue("A100");
                row.createCell(2, CellType.STRING).setCellValue("TranQuocVuong");
                row.createCell(3, CellType.STRING).setCellValue("06/03/2002");
                row.createCell(4, CellType.STRING).setCellValue("Vnh Xuan");
                row.createCell(5, CellType.STRING).setCellValue("2124512");
                row.createCell(6, CellType.STRING).setCellValue("Active");
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    public void xuatFileExcelChiTietHoaDon(Vector indexRow) {
        fd.setTitle("Xuất dữ liệu nhân viên ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Chi Tiết Hóa Đơn");

            TraCuuHoaDon_BUS traCuuHoaDon_BUS = new TraCuuHoaDon_BUS();
            
            ArrayList list = traCuuHoaDon_BUS.getDetailAllHoaDon_BUS(indexRow);
            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã hóa đơn");
            row.createCell(2, CellType.STRING).setCellValue("Mã sản phẩm");
            row.createCell(3, CellType.STRING).setCellValue("Mã trụ bơm");
            row.createCell(4, CellType.STRING).setCellValue("Tên nhân viên");
            row.createCell(5, CellType.STRING).setCellValue("Tên sản phẩm");
            row.createCell(6, CellType.STRING).setCellValue("Ngày tạo");
            row.createCell(7, CellType.STRING).setCellValue("Số lượng");
            row.createCell(8, CellType.STRING).setCellValue("Tổng tiền");

            
            for(int i=0;i<list.size();i++)
            {
                rownum++;
                row = sheet.createRow(rownum);
            Vector hoadon = new Vector();
            hoadon = (Vector) list.get(i);
            row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
            row.createCell(1, CellType.STRING).setCellValue((String) hoadon.get(0));
            row.createCell(2, CellType.STRING).setCellValue((String) hoadon.get(1));
            row.createCell(3, CellType.STRING).setCellValue((String) hoadon.get(2));
            row.createCell(4, CellType.STRING).setCellValue((String) hoadon.get(3));
            row.createCell(5, CellType.STRING).setCellValue((String) hoadon.get(4));
            row.createCell(6, CellType.STRING).setCellValue((String) hoadon.get(5));
            row.createCell(7, CellType.STRING).setCellValue((String) hoadon.get(6));
            row.createCell(8, CellType.STRING).setCellValue((String) hoadon.get(7));
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    
    public void xuatFilePhieuNhap(Vector indexRow) {
        fd.setTitle("Xuất dữ liệu nhân viên ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Chi Tiết Hóa Đơn");

            QuanLyPhieuNhap_BUS quanLyPhieuNhap_BUS=new QuanLyPhieuNhap_BUS();
            ArrayList list = quanLyPhieuNhap_BUS.getPhieuNhap_BUS(indexRow);
            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã PN");
            row.createCell(2, CellType.STRING).setCellValue("Tên SP");
            row.createCell(3, CellType.STRING).setCellValue("Tên NCC");
            row.createCell(4, CellType.STRING).setCellValue("Tên nhân viên");
            row.createCell(5, CellType.STRING).setCellValue("Số lượng");
            row.createCell(6, CellType.STRING).setCellValue("GiaNhap");
            row.createCell(7, CellType.STRING).setCellValue("Ngày tạo");
            row.createCell(8, CellType.STRING).setCellValue("TrangThai");
            row.createCell(9, CellType.STRING).setCellValue("Tổng tiền");

            
            for(int i=0;i<list.size();i++)
            {
                rownum++;
                row = sheet.createRow(rownum);
            Vector hoadon = new Vector();
            hoadon = (Vector) list.get(i);
            row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
            row.createCell(1, CellType.STRING).setCellValue((String) hoadon.get(0));
            row.createCell(2, CellType.STRING).setCellValue((String) hoadon.get(1));
            row.createCell(3, CellType.STRING).setCellValue((String) hoadon.get(2));
            row.createCell(4, CellType.STRING).setCellValue((String) hoadon.get(3));
            row.createCell(5, CellType.STRING).setCellValue((String) hoadon.get(4));
            row.createCell(6, CellType.STRING).setCellValue((String) hoadon.get(5));
            row.createCell(7, CellType.STRING).setCellValue((String) hoadon.get(6));
            row.createCell(8, CellType.STRING).setCellValue((String) hoadon.get(7));
            row.createCell(9, CellType.STRING).setCellValue((String) hoadon.get(8));
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    
    
    
    public void xuatFileThongKePhieuNhap(int selectedIndex,String text,Date dateStart,Date dateEnd) {
        fd.setTitle("Xuất dữ liệu nhân viên ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Thống kê phiếu nhâp");

           ThongKeBaoCao_BUS thongKeBaoCao_BUS = new ThongKeBaoCao_BUS();
            ArrayList list =thongKeBaoCao_BUS.getThongkeNhapVao_BUS(selectedIndex,text, dateStart, dateEnd);
            int rownum = 0;
            for(int k=0;k<list.size();k++)
            {
                System.out.println(list.get(k));
            }
            Row row = sheet.createRow(rownum);
             
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã SP");
            row.createCell(2, CellType.STRING).setCellValue("Tên SP");
            row.createCell(3, CellType.STRING).setCellValue("Tên PN");
            row.createCell(4, CellType.STRING).setCellValue("NCC");
            row.createCell(5, CellType.STRING).setCellValue("Số lượng");
            row.createCell(6, CellType.STRING).setCellValue("Gia nhap");
            row.createCell(7, CellType.STRING).setCellValue("Thời gian");
            row.createCell(8, CellType.STRING).setCellValue("Tổng tiền");

            
            for(int i=0;i<list.size();i++)
            {
                rownum++;
                row = sheet.createRow(rownum);
            Vector tkpn = new Vector();
            tkpn = (Vector) list.get(i);
    
            if(tkpn.get(0).equals(""))
            {
            row.createCell(8, CellType.STRING).setCellValue(Integer.toString((int) tkpn.get(8)));

            }
            else
            {
            row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
            row.createCell(1, CellType.STRING).setCellValue((String) tkpn.get(1));
            row.createCell(2, CellType.STRING).setCellValue((String) tkpn.get(2));
            row.createCell(3, CellType.STRING).setCellValue((String) tkpn.get(3));
            row.createCell(4, CellType.STRING).setCellValue((String) tkpn.get(4));
                System.out.println(tkpn.get(5));
            row.createCell(5, CellType.STRING).setCellValue( Integer.toString((int) tkpn.get(5)));
            row.createCell(6, CellType.STRING).setCellValue(Integer.toString((int) tkpn.get(6)));
            row.createCell(7, CellType.STRING).setCellValue((String) tkpn.get(7));
            row.createCell(8, CellType.STRING).setCellValue(Integer.toString((int) tkpn.get(8)));
            }
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    }
    
    
    
    
     public void xuatFileThongKeBanRa(int selectedIndex,String text,Date dateStart,Date dateEnd) {
        fd.setTitle("Xuất dữ liệu nhân viên ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Thống kê phiếu nhâp");

           ThongKeBaoCao_BUS thongKeBaoCao_BUS = new ThongKeBaoCao_BUS();
            ArrayList list =thongKeBaoCao_BUS.getThongkeBanRa_BUS(selectedIndex,text, dateStart, dateEnd);
            int rownum = 0;
            for(int k=0;k<list.size();k++)
            {
                System.out.println(list.get(k));
            }
            Row row = sheet.createRow(rownum);
             
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã SP");
            row.createCell(2, CellType.STRING).setCellValue("Tên SP");
            row.createCell(3, CellType.STRING).setCellValue("Tên HD");
            row.createCell(4, CellType.STRING).setCellValue("Số lượng");
            row.createCell(5, CellType.STRING).setCellValue("Gia bán");
            row.createCell(6, CellType.STRING).setCellValue("Thời gian");
            row.createCell(7, CellType.STRING).setCellValue("Tổng tiền");

            
            for(int i=0;i<list.size();i++)
            {
                rownum++;
                row = sheet.createRow(rownum);
            Vector tkpn = new Vector();
            tkpn = (Vector) list.get(i);
    
            if(tkpn.get(0).equals(""))
            {
            row.createCell(7, CellType.STRING).setCellValue(Integer.toString((int) tkpn.get(7)));

            }
            else
            {
            row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
            row.createCell(1, CellType.STRING).setCellValue((String) tkpn.get(1));
            row.createCell(2, CellType.STRING).setCellValue((String) tkpn.get(2));
            row.createCell(3, CellType.STRING).setCellValue((String) tkpn.get(3));
            row.createCell(4, CellType.STRING).setCellValue( Float.toString((float) tkpn.get(4)));
            row.createCell(5, CellType.STRING).setCellValue(Integer.toString((int) tkpn.get(5)));
            row.createCell(6, CellType.STRING).setCellValue((String) tkpn.get(6));
            row.createCell(7, CellType.STRING).setCellValue(Integer.toString((int)tkpn.get(7)));
            }
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    }
    
    
}
