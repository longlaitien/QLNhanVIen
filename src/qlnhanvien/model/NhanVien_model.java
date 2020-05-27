/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.model;

import java.util.Date;

/**
 *
 * @author nhatnguyen
 */
public class NhanVien_model {

    String manv, hoten;
    String ngaysinh;
    String quequan, gioitinh, dantoc, sodt;
    float heso, luongcb;
    String image, mapb, macv, matdhv;

    public NhanVien_model() {
    }

    public NhanVien_model(String manv, String hoten, String ngaysinh, String quequan, String gioitinh, String dantoc, String sodt, float heso, float luongcb, String image, String mapb, String macv, String matdhv) {
        this.manv = manv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.quequan = quequan;
        this.gioitinh = gioitinh;
        this.dantoc = dantoc;
        this.sodt = sodt;
        this.heso = heso;
        this.luongcb = luongcb;
        this.image = image;
        this.mapb = mapb;
        this.macv = macv;
        this.matdhv = matdhv;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDantoc() {
        return dantoc;
    }

    public void setDantoc(String dantoc) {
        this.dantoc = dantoc;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public float getHeso() {
        return heso;
    }

    public void setHeso(float heso) {
        this.heso = heso;
    }

    public float getLuongcb() {
        return luongcb;
    }

    public void setLuongcb(float luongcb) {
        this.luongcb = luongcb;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMapb() {
        return mapb;
    }

    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public String getMacv() {
        return macv;
    }

    public void setMacv(String macv) {
        this.macv = macv;
    }

    public String getMatdhv() {
        return matdhv;
    }

    public void setMatdhv(String matdhv) {
        this.matdhv = matdhv;
    }

}
