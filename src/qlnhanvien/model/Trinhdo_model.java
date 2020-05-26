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
public class Trinhdo_model {

    String matdhv, tentd;

    public Trinhdo_model(String matdhv, String tentd) {
        this.matdhv = matdhv;
        this.tentd = tentd;
    }

    public Trinhdo_model() {
    }

    public String getMatdhv() {
        return matdhv;
    }

    public void setMatdhv(String matdhv) {
        this.matdhv = matdhv;
    }

    public String getTentd() {
        return tentd;
    }

    public void setTentd(String tentd) {
        this.tentd = tentd;
    }

}
