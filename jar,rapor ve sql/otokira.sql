-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 23 Ara 2018, 12:52:18
-- Sunucu sürümü: 10.1.28-MariaDB
-- PHP Sürümü: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `otokira`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tblarac`
--

CREATE TABLE `tblarac` (
  `id` int(11) NOT NULL,
  `marka` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `model` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `yil` smallint(4) NOT NULL,
  `plaka` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `km` varchar(10) COLLATE utf8_turkish_ci NOT NULL,
  `ucret` double NOT NULL,
  `kiradaMi` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `tblarac`
--

INSERT INTO `tblarac` (`id`, `marka`, `model`, `yil`, `plaka`, `km`, `ucret`, `kiradaMi`) VALUES
(1, 'Fiat', 'Linea', 2012, '34FL3434', '120240', 25, 1),
(3, 'Renault', 'Fluence', 2012, '34HL6569', '115000', 8, 1),
(5, 'Wolkswagen', 'Polo', 2016, '59tgh78', '1', 300, 1),
(6, 'mercedes', 'e200', 2018, '61TS61', '0', 15, 1),
(7, 'BMW', 'M3', 2015, '34BM3481', '150000', 45, 1),
(8, 'Fiat', 'Doblo', 2018, '34FD8563', '2', 10, 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tblkira`
--

CREATE TABLE `tblkira` (
  `id` int(11) NOT NULL,
  `arac_id` int(11) NOT NULL,
  `musteri_id` int(11) NOT NULL,
  `alimTarih` datetime NOT NULL,
  `teslimTarih` datetime NOT NULL,
  `ucret` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `tblkira`
--

INSERT INTO `tblkira` (`id`, `arac_id`, `musteri_id`, `alimTarih`, `teslimTarih`, `ucret`) VALUES
(3, 3, 1, '2018-12-02 00:00:00', '2018-12-09 00:00:00', 1344),
(4, 1, 1, '2018-12-09 00:00:00', '2018-12-16 00:00:00', 4200),
(5, 4, 1, '2018-12-08 00:00:00', '2018-12-15 00:00:00', 13440),
(6, 5, 6, '2018-12-27 00:00:00', '2018-12-29 00:00:00', 14400),
(7, 6, 1, '2018-12-06 00:00:00', '2018-12-20 00:00:00', 4845),
(8, 7, 1, '2018-12-01 00:00:00', '2018-12-08 00:00:00', 7560);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tblkullanici`
--

CREATE TABLE `tblkullanici` (
  `id` int(11) NOT NULL,
  `kullaniciAd` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `kullaniciSifre` varchar(48) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `tblkullanici`
--

INSERT INTO `tblkullanici` (`id`, `kullaniciAd`, `kullaniciSifre`) VALUES
(1, 'omurserdarr', 'serdar61'),
(2, 'tolga', '1234');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tblmusteri`
--

CREATE TABLE `tblmusteri` (
  `id` int(11) NOT NULL,
  `TC` bigint(11) NOT NULL,
  `ad` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `soyad` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `telefon` bigint(20) NOT NULL,
  `adres` varchar(240) COLLATE utf8_turkish_ci DEFAULT NULL,
  `email` varchar(120) COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `tblmusteri`
--

INSERT INTO `tblmusteri` (`id`, `TC`, `ad`, `soyad`, `telefon`, `adres`, `email`) VALUES
(1, 41294004688, 'Ömürcan', 'Serdar', 5413, 'tuzla', 'omurserdarr@gmail.com'),
(2, 41829465892, 'Kir', 'sof', 5348659852, 'ataşehir', 'abuzer@yahoo.com'),
(3, 51243084689, 'altan', 'tekisimsahibi', 5418623547, 'fikirtepe', 'altan@msn.com'),
(4, 45286895277, 'furkan', 'kyk', 5412365879, 'aydınlı', 'gok@han'),
(5, 41294785688, 'güven', 'düzce', 5413589745, 'tuzla', 'guven@duzce'),
(6, 16181830002, 'Tolga', 'Hüner', 5367979686, 'istanbul', 'tolga@gmail.com'),
(7, 41294004685, 'gülsen', 'bubik', 5412879650, 'pendik', 'gul@sen.com');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `tblarac`
--
ALTER TABLE `tblarac`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tblkira`
--
ALTER TABLE `tblkira`
  ADD PRIMARY KEY (`id`),
  ADD KEY `arac_id` (`arac_id`),
  ADD KEY `musteri_id` (`musteri_id`);

--
-- Tablo için indeksler `tblkullanici`
--
ALTER TABLE `tblkullanici`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tblmusteri`
--
ALTER TABLE `tblmusteri`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `tblarac`
--
ALTER TABLE `tblarac`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `tblkira`
--
ALTER TABLE `tblkira`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `tblkullanici`
--
ALTER TABLE `tblkullanici`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `tblmusteri`
--
ALTER TABLE `tblmusteri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
