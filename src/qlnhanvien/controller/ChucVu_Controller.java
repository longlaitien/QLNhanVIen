/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.controller;

import java.util.ArrayList;
import qlnhanvien.dal.ChucVu_dal;
import qlnhanvien.model.Chucvu_model;

/**
 *
 * @author nhatnguyen
 */
public class ChucVu_Controller {

    ChucVu_dal dal = new ChucVu_dal();

    public ArrayList<Chucvu_model> getDataTable() {
        return dal.DataTable();
    }

    public int get_Insert_ChucVu(String macv, String tencv, int trangthai) {
        return dal.Insert_ChucVu(macv, tencv, trangthai);
    }

    public int get_Update_ChucVu(String macv, String tencv, int trangthai) {
        return dal.Update_ChucVu(macv, tencv, trangthai);
    }

    public int get_Delete_ChucVu(String macv) {
        return dal.Delete_ChucVu(macv);
    }
}
