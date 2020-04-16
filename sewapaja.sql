-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2020 at 04:40 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sewapaja`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabel_barang`
--

CREATE TABLE `tabel_barang` (
  `id_barang` int(11) NOT NULL,
  `merk` varchar(50) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `warna` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `harga` varchar(50) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_barang`
--

INSERT INTO `tabel_barang` (`id_barang`, `merk`, `jenis`, `warna`, `status`, `harga`, `image`) VALUES
(1, 'Nikon', 'Camera', 'Black', '0', '20000', 'https://cdn.pocket-lint.com/r/s/1200x/assets/images/147435-cameras-review-nikon-z6-review-image1-sizm65qcod.jpg'),
(2, 'Sony', 'Camera', 'Pink', '0', '150000', 'https://static.bhphoto.com/images/images1000x1000/1294398073_750065.jpg'),
(3, 'Leica', 'Camera', 'Black', '0', '200000', 'https://cdn.vox-cdn.com/thumbor/_IeUn2OMXM8IYDLcOeFhUDKXHww=/0x171:1506x959/fit-in/1200x630/cdn.vox-cdn.com/uploads/chorus_asset/file/13075479/LeicaSide.0.0.1430441592.jpg'),
(4, 'Leica', 'Camera', 'White', '0', '200000', 'https://cdn11.bigcommerce.com/s-r16b86mn51/images/stencil/original/products/2253/12939/M10-P_weiss_FRONT_RGB__73894.1576612211.jpg?c=2&imbypass=on&imbypass=on'),
(5, 'Sony', 'Camera', 'Black', '0', '150000', 'https://thegoodguys.sirv.com/products/50023829/50023829_97995.PNG?scale.height=505&scale.width=773&canvas.height=505&canvas.width=773&canvas.opacity=0&q=90'),
(6, 'Canon', 'Camera', 'Black', '0', '170000', 'https://www.bhphotovideo.com/images/images2500x2500/canon_1072c001_powershot_sx620_hs_digital_1251151.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_user`
--

CREATE TABLE `tabel_user` (
  `id` int(5) NOT NULL,
  `nik` int(50) NOT NULL,
  `nama` varchar(50) CHARACTER SET latin1 NOT NULL,
  `email` varchar(50) CHARACTER SET latin1 NOT NULL,
  `alamat` varchar(50) CHARACTER SET latin1 NOT NULL,
  `telp` int(12) NOT NULL,
  `username` varchar(25) CHARACTER SET latin1 NOT NULL,
  `pass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_user`
--

INSERT INTO `tabel_user` (`id`, `nik`, `nama`, `email`, `alamat`, `telp`, `username`, `pass`) VALUES
(2, 1111111, 'admin', 'admin@gmail.com', 'admin rumah', 8213681, 'admin', 'admin'),
(3, 1111710093, 'alvin', 'alvin@gmail.com', 'rumah alvin', 2147483647, 'alvin', 'alvin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tabel_barang`
--
ALTER TABLE `tabel_barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `tabel_user`
--
ALTER TABLE `tabel_user`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tabel_barang`
--
ALTER TABLE `tabel_barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tabel_user`
--
ALTER TABLE `tabel_user`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
