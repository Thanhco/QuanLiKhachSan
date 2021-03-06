USE [master]
GO
/****** Object:  Database [QuanLiKhachSan]    Script Date: 4/1/2018 10:57:26 PM ******/
CREATE DATABASE [QuanLiKhachSan] ON  PRIMARY 
( NAME = N'QuanLiKhachSan', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.MSSQLSERVER\MSSQL\DATA\QuanLiKhachSan.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QuanLiKhachSan_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.MSSQLSERVER\MSSQL\DATA\QuanLiKhachSan_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QuanLiKhachSan] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLiKhachSan].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLiKhachSan] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLiKhachSan] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLiKhachSan] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLiKhachSan] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLiKhachSan] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLiKhachSan] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLiKhachSan] SET RECOVERY FULL 
GO
ALTER DATABASE [QuanLiKhachSan] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLiKhachSan] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLiKhachSan] SET DB_CHAINING OFF 
GO
EXEC sys.sp_db_vardecimal_storage_format N'QuanLiKhachSan', N'ON'
GO
USE [QuanLiKhachSan]
GO
/****** Object:  Table [dbo].[ChiTietDatPhong]    Script Date: 4/1/2018 10:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDatPhong](
	[MSDP] [int] NULL,
	[MaPhong] [nvarchar](5) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietThuePhong]    Script Date: 4/1/2018 10:57:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietThuePhong](
	[MSPT] [int] NULL,
	[MaPhong] [int] NULL,
	[MaDichVu] [int] NULL,
	[NgayGio] [datetime] NULL,
	[SoLuong] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 4/1/2018 10:57:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[MaDichVu] [int] IDENTITY(1,1) NOT NULL,
	[TenDichVu] [nvarchar](50) NULL,
	[SoTien] [float] NULL,
	[MoTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[MaDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DoiPhong]    Script Date: 4/1/2018 10:57:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DoiPhong](
	[MSKH] [int] NULL,
	[MaPhongCu] [int] NULL,
	[MaPhongMoi] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/1/2018 10:57:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[MSPT] [int] NULL,
	[MSKH] [int] NULL,
	[NgayThang] [datetime] NULL,
	[SoTien] [float] NULL,
	[TenDangNhap] [nchar](10) NULL,
	[HinhThucThanhToan] [nvarchar](50) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/1/2018 10:57:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MSKH] [int] IDENTITY(1,1) NOT NULL,
	[Ho] [nvarchar](50) NULL,
	[Ten] [nchar](20) NULL,
	[GioiTinh] [nchar](10) NULL,
	[NgaySinh] [datetime] NULL,
	[CMND] [nchar](10) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[MSHD] [int] NULL,
	[MSDP] [int] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MSKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/1/2018 10:57:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MSNV] [int] IDENTITY(1,1) NOT NULL,
	[TenDangNhap] [nchar](10) NULL,
	[Ho] [nvarchar](50) NULL,
	[Ten] [nvarchar](20) NULL,
	[GioiTinh] [nchar](10) NULL,
	[NgaySinh] [datetime] NULL,
	[CMND] [nchar](10) NULL,
	[ChucVu] [nvarchar](50) NULL,
	[NgayVaoLam] [datetime] NULL,
	[DiaChi] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MSNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhieuDatPhong]    Script Date: 4/1/2018 10:57:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatPhong](
	[MSDP] [int] NOT NULL,
	[MSKH] [int] NULL,
	[NgayDat] [datetime] NULL,
	[NgayTra] [datetime] NULL,
	[TinhTrang] [nchar](20) NULL,
	[SoNguoi] [int] NULL,
	[SoLuongPhong] [int] NULL,
	[SoTien] [float] NULL,
 CONSTRAINT [PK_PhieuDatPhong] PRIMARY KEY CLUSTERED 
(
	[MSDP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PhieuThuePhong]    Script Date: 4/1/2018 10:57:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuThuePhong](
	[MSPT] [int] IDENTITY(1,1) NOT NULL,
	[TenDangNhap] [nchar](10) NULL,
	[MSDP] [int] NULL,
 CONSTRAINT [PK_PhieuThuePhong] PRIMARY KEY CLUSTERED 
(
	[MSPT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Phong]    Script Date: 4/1/2018 10:57:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[MaPhong] [nvarchar](5) NOT NULL,
	[TenPhong] [nvarchar](50) NULL,
	[Tang] [int] NULL,
	[GiaGio] [float] NULL,
	[GiaNgay] [float] NULL,
	[TrangThai] [int] NULL,
	[LoaiPhong] [nchar](10) NULL,
	[SoGiuong] [int] NULL,
	[MoTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 4/1/2018 10:57:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TenDangNhap] [nchar](10) NOT NULL,
	[MatKhau] [nchar](20) NOT NULL,
	[MSNV] [int] NOT NULL,
	[Rules] [nvarchar](20) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TrangThai]    Script Date: 4/1/2018 10:57:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TrangThai](
	[MaTrangThai] [int] IDENTITY(1,1) NOT NULL,
	[TrangThai] [nvarchar](50) NULL,
	[MauSac] [nvarchar](50) NULL,
 CONSTRAINT [PK_TrangThai] PRIMARY KEY CLUSTERED 
(
	[MaTrangThai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TrangThaiPhong]    Script Date: 4/1/2018 10:57:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TrangThaiPhong](
	[MaTrangThai] [int] IDENTITY(1,1) NOT NULL,
	[TenTrangThai] [nvarchar](50) NULL,
	[MauSac] [nvarchar](20) NULL,
 CONSTRAINT [PK_TrangThaiPhong] PRIMARY KEY CLUSTERED 
(
	[MaTrangThai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[ChiTietDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDatPhong_PhieuDatPhong] FOREIGN KEY([MSDP])
REFERENCES [dbo].[PhieuDatPhong] ([MSDP])
GO
ALTER TABLE [dbo].[ChiTietDatPhong] CHECK CONSTRAINT [FK_ChiTietDatPhong_PhieuDatPhong]
GO
ALTER TABLE [dbo].[ChiTietDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDatPhong_Phong] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[Phong] ([MaPhong])
GO
ALTER TABLE [dbo].[ChiTietDatPhong] CHECK CONSTRAINT [FK_ChiTietDatPhong_Phong]
GO
ALTER TABLE [dbo].[ChiTietThuePhong]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietThuePhong_DichVu] FOREIGN KEY([MaDichVu])
REFERENCES [dbo].[DichVu] ([MaDichVu])
GO
ALTER TABLE [dbo].[ChiTietThuePhong] CHECK CONSTRAINT [FK_ChiTietThuePhong_DichVu]
GO
ALTER TABLE [dbo].[ChiTietThuePhong]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietThuePhong_PhieuThuePhong] FOREIGN KEY([MSPT])
REFERENCES [dbo].[PhieuThuePhong] ([MSPT])
GO
ALTER TABLE [dbo].[ChiTietThuePhong] CHECK CONSTRAINT [FK_ChiTietThuePhong_PhieuThuePhong]
GO
ALTER TABLE [dbo].[DoiPhong]  WITH CHECK ADD  CONSTRAINT [FK_DoiPhong_KhachHang] FOREIGN KEY([MSKH])
REFERENCES [dbo].[KhachHang] ([MSKH])
GO
ALTER TABLE [dbo].[DoiPhong] CHECK CONSTRAINT [FK_DoiPhong_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MSKH])
REFERENCES [dbo].[KhachHang] ([MSKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_PhieuThuePhong] FOREIGN KEY([MSPT])
REFERENCES [dbo].[PhieuThuePhong] ([MSPT])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_PhieuThuePhong]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([TenDangNhap])
REFERENCES [dbo].[TaiKhoan] ([TenDangNhap])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatPhong_KhachHang] FOREIGN KEY([MSKH])
REFERENCES [dbo].[KhachHang] ([MSKH])
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PhieuDatPhong_KhachHang]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_TrangThaiPhong] FOREIGN KEY([TrangThai])
REFERENCES [dbo].[TrangThaiPhong] ([MaTrangThai])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_TrangThaiPhong]
GO
USE [master]
GO
ALTER DATABASE [QuanLiKhachSan] SET  READ_WRITE 
GO
