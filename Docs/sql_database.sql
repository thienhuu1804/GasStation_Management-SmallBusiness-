-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.5-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for fuelmanagement
CREATE DATABASE IF NOT EXISTS `fuelmanagement` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `fuelmanagement`;

-- Dumping structure for table fuelmanagement.gia
CREATE TABLE IF NOT EXISTS `gia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `masp` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ngayapdung` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `gia` int(11) NOT NULL DEFAULT 0,
  `ngayketthuc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Unique_Pair` (`masp`,`ngayapdung`) USING BTREE,
  CONSTRAINT `FK_gia_sanpham` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table fuelmanagement.gia: ~2 rows (approximately)
/*!40000 ALTER TABLE `gia` DISABLE KEYS */;
INSERT INTO `gia` (`id`, `masp`, `ngayapdung`, `gia`, `ngayketthuc`) VALUES
	(0, 'A90', '17:05:10 11-02-2022', 15000, NULL),
	(6, 'A95', '17:05:10 11-02-2022', 15000, NULL),
	(7, 'DO005', '17:05:10 11-02-2022', 15000, NULL);
/*!40000 ALTER TABLE `gia` ENABLE KEYS */;

-- Dumping structure for table fuelmanagement.hoadon
CREATE TABLE IF NOT EXISTS `hoadon` (
  `mahd` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `matrubom` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `masp` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ngaytao` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `soluong` float NOT NULL,
  `tongtien` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mahd`),
  KEY `matrubom` (`matrubom`),
  KEY `FK_hoadon_sanpham` (`masp`),
  CONSTRAINT `FK_hoadon_sanpham` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`),
  CONSTRAINT `FK_hoadon_trubom` FOREIGN KEY (`matrubom`) REFERENCES `trubom` (`matrubom`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table fuelmanagement.hoadon: ~0 rows (approximately)
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;

-- Dumping structure for table fuelmanagement.nhacungcap
CREATE TABLE IF NOT EXISTS `nhacungcap` (
  `mancc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tenncc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mancc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table fuelmanagement.nhacungcap: ~1 rows (approximately)
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` (`mancc`, `tenncc`, `diachi`, `sdt`) VALUES
	('NCC1', 'Vinamilk', 'HCM', '0909009');
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;

-- Dumping structure for table fuelmanagement.nhanvien
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `manv` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tennv` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `cmnd` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `trangthai` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`manv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table fuelmanagement.nhanvien: ~2 rows (approximately)
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` (`manv`, `tennv`, `sdt`, `diachi`, `cmnd`, `trangthai`) VALUES
	('nv1', 'Nguyễn Văn A', '0909090909', 'abcdc', '073215648', 'Active'),
	('nv2', 'Nguyễn Văn b', '0909090909', 'abcdc', '073215648', 'Active');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;

-- Dumping structure for table fuelmanagement.phieunhap
CREATE TABLE IF NOT EXISTS `phieunhap` (
  `mapn` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `masp` varchar(50) CHARACTER SET utf8 NOT NULL,
  `manv` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `mancc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ngaytao` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `soluong` int(11) NOT NULL DEFAULT 0,
  `gianhap` int(11) NOT NULL DEFAULT 0,
  `tongtien` varchar(1000) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`mapn`),
  KEY `FK_phieunhap_sanpham` (`masp`),
  KEY `FK_phieunhap_nhanvien` (`manv`),
  KEY `FK_phieunhap_nhacungcap` (`mancc`),
  CONSTRAINT `FK_phieunhap_nhacungcap` FOREIGN KEY (`mancc`) REFERENCES `nhacungcap` (`mancc`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_phieunhap_nhanvien` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_phieunhap_sanpham` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table fuelmanagement.phieunhap: ~1 rows (approximately)
/*!40000 ALTER TABLE `phieunhap` DISABLE KEYS */;
INSERT INTO `phieunhap` (`mapn`, `masp`, `manv`, `mancc`, `ngaytao`, `soluong`, `gianhap`, `tongtien`) VALUES
	('PN1', 'A90', 'nv2', 'NCC1', '', 600, 15000, '9000000');
/*!40000 ALTER TABLE `phieunhap` ENABLE KEYS */;

-- Dumping structure for table fuelmanagement.quyen
CREATE TABLE IF NOT EXISTS `quyen` (
  `maquyen` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `motaquyen` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`maquyen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table fuelmanagement.quyen: ~4 rows (approximately)
/*!40000 ALTER TABLE `quyen` DISABLE KEYS */;
INSERT INTO `quyen` (`maquyen`, `motaquyen`) VALUES
	('q1', 'tài khoản và quyền'),
	('q2', 'bán hàng'),
	('q3', 'kho hàng'),
	('q4', 'thống kê báo cáo');
/*!40000 ALTER TABLE `quyen` ENABLE KEYS */;

-- Dumping structure for table fuelmanagement.sanpham
CREATE TABLE IF NOT EXISTS `sanpham` (
  `masp` varchar(50) NOT NULL,
  `tensp` varchar(50) NOT NULL,
  `soluong` float NOT NULL DEFAULT 0,
  PRIMARY KEY (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table fuelmanagement.sanpham: ~4 rows (approximately)
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` (`masp`, `tensp`, `soluong`) VALUES
	('A90', 'RON 90', 600),
	('A95', 'RON 95', 500),
	('DO005', 'DO 0.05S', 800),
	('DO025', 'DO 0.25S', 700);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;

-- Dumping structure for table fuelmanagement.taikhoan
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `tendangnhap` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `manv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `matkhau` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `ngaytao` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `trangthai` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`tendangnhap`),
  KEY `FK__nhanvien` (`manv`),
  CONSTRAINT `FK__nhanvien` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table fuelmanagement.taikhoan: ~2 rows (approximately)
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` (`tendangnhap`, `manv`, `matkhau`, `ngaytao`, `trangthai`) VALUES
	('nv1', 'nv1', 'm/DhzEB+/lZlC2M14WjGYQ==$NcUmViMG+PZRXCjSyXpN1jcCzuV2eaJxE90JzD+DRaN52IBQhcR9wmna8S4z2gVu3bWOVHaaYL80B3odpa8HDA==', '19:52:25 16-04-2022', 'Active'),
	('nv2', 'nv2', 'lIu5RaFr21dlCQ9kfVOZDQ==$9Hoyx8iKK2F18FjZnJj4qEVACrrZrLk8/Azj0SXbZAUEjkX43eo87Df4EhDIFLMUMpiLp5jzMxsQE63gXSI9YQ==', '19:52:25 16-04-2022', 'Active');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;

-- Dumping structure for table fuelmanagement.taikhoan_quyen
CREATE TABLE IF NOT EXISTS `taikhoan_quyen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tendangnhap` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `maquyen` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ngaysua` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `FK__taikhoan` (`tendangnhap`),
  KEY `FK__quyen` (`maquyen`),
  CONSTRAINT `FK__quyen` FOREIGN KEY (`maquyen`) REFERENCES `quyen` (`maquyen`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK__taikhoan` FOREIGN KEY (`tendangnhap`) REFERENCES `taikhoan` (`tendangnhap`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table fuelmanagement.taikhoan_quyen: ~3 rows (approximately)
/*!40000 ALTER TABLE `taikhoan_quyen` DISABLE KEYS */;
INSERT INTO `taikhoan_quyen` (`id`, `tendangnhap`, `maquyen`, `ngaysua`) VALUES
	(1, 'nv1', 'q2', '19:52:25 16-04-2022'),
	(2, 'nv1', 'q4', '19:52:25 16-04-2022'),
	(3, 'nv2', 'q3', '19:52:25 16-04-2022');
/*!40000 ALTER TABLE `taikhoan_quyen` ENABLE KEYS */;

-- Dumping structure for table fuelmanagement.trubom
CREATE TABLE IF NOT EXISTS `trubom` (
  `matrubom` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `manv` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `masp` varchar(50) NOT NULL,
  `trangthai` varchar(50) NOT NULL,
  PRIMARY KEY (`matrubom`),
  KEY `FK_trubom_nhanvien` (`manv`),
  KEY `FK_trubom_sanpham` (`masp`),
  CONSTRAINT `FK_trubom_nhanvien` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_trubom_sanpham` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table fuelmanagement.trubom: ~0 rows (approximately)
/*!40000 ALTER TABLE `trubom` DISABLE KEYS */;
/*!40000 ALTER TABLE `trubom` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
