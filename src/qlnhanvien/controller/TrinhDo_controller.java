/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.controller;

import java.util.ArrayList;
import qlnhanvien.dal.TrinhDo_dal;
import qlnhanvien.model.Trinhdo_model;

/**
 *
 * @author nhatnguyen
 */
public class TrinhDo_controller {

    TrinhDo_dal dal = new TrinhDo_dal();

    public ArrayList<Trinhdo_model> getDataTable() {
        return dal.DataTable();
    }

    public int get_Insert_TrinhDo(String matdhv, String tentd, int trangthai) {
        return dal.Insert_TrinhDo(matdhv, tentd, trangthai);
    }

    public int get_Update_TrinhDo(String matdhv, String tentd, int trangthai) {
        return dal.Update_TrinhDo(matdhv, tentd, trangthai);
    }

    public int get_Delete_TrinhDo(String matdhv) {
        return dal.Delete_TrinhDo(matdhv);
    }

//    public static void main(String[] args) {
//        TrinhDo_controller obj = new TrinhDo_controller();
//        ArrayList<Trinhdo_model> list = new ArrayList<>();
//        list = obj.getDataTable();
//        for (Trinhdo_model lg : list) {
//            System.out.println(lg.getMatdhv());
//            System.out.println(lg.getTentd());
//        }
//    }
}
