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
public class Chucvu_model {
    String macv,tencv;

    public Chucvu_model() {
    }

    public Chucvu_model(String macv, String tencv) {
        this.macv = macv;
        this.tencv = tencv;
    }

    public String getMacv() {
        return macv;
    }

    public void setMacv(String macv) {
        this.macv = macv;
    }

    public String getTencv() {
        return tencv;
    }

    public void setTencv(String tencv) {
        this.tencv = tencv;
    }

}
