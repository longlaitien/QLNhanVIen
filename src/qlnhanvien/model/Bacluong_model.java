/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.model;

/**
 *
 * @author nhatnguyen
 */
public class Bacluong_model {

    String mabacluong;
    float luongcoban, hesoluong, hesophucap;

    public Bacluong_model() {
    }

    public Bacluong_model(String mabacluong, float luongcoban, float hesoluong, float hesophucap) {
        this.mabacluong = mabacluong;
        this.luongcoban = luongcoban;
        this.hesoluong = hesoluong;
        this.hesophucap = hesophucap;
    }

    public String getMabacluong() {
        return mabacluong;
    }

    public void setMabacluong(String mabacluong) {
        this.mabacluong = mabacluong;
    }

    public float getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(float luongcoban) {
        this.luongcoban = luongcoban;
    }

    public float getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong(float hesoluong) {
        this.hesoluong = hesoluong;
    }

    public float getHesophucap() {
        return hesophucap;
    }

    public void setHesophucap(float hesophucap) {
        this.hesophucap = hesophucap;
    }

}
