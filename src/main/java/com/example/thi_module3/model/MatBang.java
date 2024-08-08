package com.example.thi_module3.model;

import java.util.Date;

public class MatBang {
    private int id;
    private String maMb;
    private int dienTich;
    private String trangThai;
    private int tang;
    private String loaiVp;
    private String moTa;
    private int gia;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public MatBang() {
    }


    public MatBang(int id, String maMb, int dienTich, String trangThai, int tang, String loaiVp, String moTa, int gia, Date ngayBatDau, Date ngayKetThuc) {
        this.id = id;
        this.maMb = maMb;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiVp = loaiVp;
        this.moTa = moTa;
        this.gia = gia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMb() {
        return maMb;
    }

    public void setMaMb(String maMb) {
        this.maMb = maMb;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public String getLoaiVp() {
        return loaiVp;
    }

    public void setLoaiVp(String loaiVp) {
        this.loaiVp = loaiVp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
