/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlnhanvien.model.Bacluong_model;
import qlnhanvien.model.Chucvu_model;
import qlnhanvien.model.Phongban_model;
import qlnhanvien.model.Trinhdo_model;

/**
 *
 * @author nhatnguyen
 */
public class GetComboxBox_dal {

    Chucvu_model cv;
    Phongban_model pb;
    Trinhdo_model td;
    Bacluong_model bl;

    public GetComboxBox_dal() {

    }

    public ArrayList<Chucvu_model> Combo_ChucVu() {
        ArrayList<Chucvu_model> list = new ArrayList<>();
        String sql = "SELECT macv,tencv FROM ChucVu";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cv = new Chucvu_model(rs.getString("macv"), rs.getString("tencv"));
                list.add(cv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Phongban_model> Combo_PhongBan() {
        ArrayList<Phongban_model> list = new ArrayList<>();
        String sql = "SELECT mapb,tenpb,diachi,sodtpb FROM PhongBan";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                pb = new Phongban_model(rs.getString("mapb"), rs.getString("tenpb"),rs.getString("diachi"),rs.getString("sodtpb"));
                list.add(pb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Trinhdo_model> Combo_TrinhDo() {
        ArrayList<Trinhdo_model> list = new ArrayList<>();
        String sql = "SELECT matdhv,tentd FROM TrinhDo";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                td = new Trinhdo_model(rs.getString("matdhv"), rs.getString("tentd"));
                list.add(td);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
