/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.controller;

import java.util.ArrayList;
import qlnhanvien.dal.GetComboxBox_dal;
import qlnhanvien.model.Chucvu_model;
import qlnhanvien.model.NhanVien_model;
import qlnhanvien.model.Phongban_model;
import qlnhanvien.model.Trinhdo_model;
import qlnhanvien.view.AddEmployee;

/**
 *
 * @author nhatnguyen
 */
public class Combo_controller {

    GetComboxBox_dal cbo;

    public Combo_controller() {
        cbo = new GetComboxBox_dal();
    }

    public ArrayList<Chucvu_model> getCombo_ChucVu() {
        return cbo.Combo_ChucVu();
    }

    public ArrayList<Phongban_model> getCombo_PhongBan() {
        return cbo.Combo_PhongBan();
    }

    public ArrayList<Trinhdo_model> getCombo_TrinhDo() {
        return cbo.Combo_TrinhDo();
    }

    public ArrayList<NhanVien_model> getDataTable() {
        return cbo.DataTable();
    }

    public String mapb(String tenpb) {
        return cbo.pb(tenpb);
    }

    public String macv(String tencv) {
        return cbo.cv(tencv);
    }

    public String matdhv(String tentd) {
        return cbo.td(tentd);
    }

}
