/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.controller;

import java.util.ArrayList;
import qlnhanvien.dal.PhongBan_dal;
import qlnhanvien.model.Phongban_model;

/**
 *
 * @author nhatnguyen
 */
public class PhongBan_controller {
    PhongBan_dal dal = new PhongBan_dal();
    
   
    public ArrayList<Phongban_model> getDataTable() {
        return dal.DataTable();
    }

    public int get_Insert_PhongBan(String mapb, String tenpb, String diachi, String sodtpb, int trangthai) {
        return dal.Insert_PhongBan(mapb, tenpb, diachi, sodtpb, trangthai);
    }

    public int get_Update_PhongBan(String mapb, String tenpb, String diachi, String sodtpb, int trangthai) {
        return dal.Update_PhongBan(mapb, tenpb, diachi, sodtpb, trangthai);
    }
    
     public int get_Delete_PhongBan(String mapb) {
        return dal.Delete_PhongBan(mapb);
    }
}
