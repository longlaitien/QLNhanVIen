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
public class Phongban_model {
    String mapb,tenpb,diachi,sodtpb;

    public Phongban_model() {
    }

    public Phongban_model(String mapb, String tenpb, String diachi, String sodtpb) {
        this.mapb = mapb;
        this.tenpb = tenpb;
        this.diachi = diachi;
        this.sodtpb = sodtpb;
    }

    public String getMapb() {
        return mapb;
    }

    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodtpb() {
        return sodtpb;
    }

    public void setSodtpb(String sodtpb) {
        this.sodtpb = sodtpb;
    }

}
