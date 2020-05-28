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
import qlnhanvien.model.NhanVien_model;
import qlnhanvien.model.Phongban_model;
import qlnhanvien.model.Trinhdo_model;

/**
 *
 * @author nhatnguyen
 */
public class GetComboxBox_dal {

    NhanVien_model nv;
    Chucvu_model cv;
    Phongban_model pb;
    Trinhdo_model td;
    Bacluong_model bl;

    public GetComboxBox_dal() {

    }

    //Lay du lieu bang ChucVu do vao ComboBox
    public ArrayList<Chucvu_model> Combo_ChucVu() {
        ArrayList<Chucvu_model> list = new ArrayList<>();
        String sql = "SELECT macv,tencv,trangthai FROM ChucVu";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cv = new Chucvu_model(rs.getString("macv"), rs.getString("tencv"),rs.getInt("trangthai"));
                list.add(cv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //Lay du lieu bang PhongBan do vao ComboBox
    public ArrayList<Phongban_model> Combo_PhongBan() {
        ArrayList<Phongban_model> list = new ArrayList<>();
        String sql = "SELECT mapb,tenpb,diachi,sodtpb,trangthai FROM PhongBan";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                pb = new Phongban_model(rs.getString("mapb"), rs.getString("tenpb"), rs.getString("diachi"), rs.getString("sodtpb"),rs.getInt("trangthai"));
                list.add(pb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //Lay du lieu bang TrinhDo vao ComboBox
    public ArrayList<Trinhdo_model> Combo_TrinhDo() {
        ArrayList<Trinhdo_model> list = new ArrayList<>();
        String sql = "SELECT matdhv,tentd,trangthai FROM TrinhDo";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                td = new Trinhdo_model(rs.getString("matdhv"), rs.getString("tentd"),rs.getInt("trangthai"));
                list.add(td);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //Lay du lieu do vao Table trong giao dien chinh
    public ArrayList<NhanVien_model> DataTable() {
        ArrayList<NhanVien_model> list = new ArrayList<>();
        String sql = "SELECT manv, hoten, ngaysinh, quequan, gioitinh, dantoc, sodt, heso, luongcb, image, mapb, macv, matdhv FROM NhanVien WHERE trangthai = 1";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                nv = new NhanVien_model(rs.getString("manv"), rs.getString("hoten"), rs.getString("ngaysinh"), rs.getString("quequan"), rs.getString("gioitinh"), rs.getString("dantoc"), rs.getString("sodt"), rs.getFloat("heso"), rs.getFloat("luongcb"), rs.getString("image"), rs.getString("mapb"), rs.getString("macv"), rs.getString("matdhv"));
                list.add(nv);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    //3 hàm sau để lấy về giá trị khi click chuột vào combox ở form thêm và sửa nhân viên
    public String pb(String tenpb) {
        String cboPhongBan = "";
        String sql = "SELECT mapb FROM PhongBan WHERE tenpb=N'" + tenpb + "'";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cboPhongBan = rs.getString("mapb");
            }
        } catch (Exception e) {
        }
        return cboPhongBan;

    }

    public String cv(String tencv) {
        String cboChucVu = "";
        String sql = "SELECT macv FROM ChucVu WHERE tencv=N'" + tencv + "'";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cboChucVu = rs.getString("macv");
            }
        } catch (Exception e) {
        }
        return cboChucVu;
    }

    public String td(String tentd) {
        String cboTrinhDo = "";
        String sql = "SELECT matdhv FROM TrinhDo WHERE tentd=N'" + tentd + "'";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cboTrinhDo = rs.getString("matdhv");
            }
        } catch (Exception e) {
        }
        return cboTrinhDo;
    }
//    
//    public static void main(String[] args) {
//        GetComboxBox_dal obj = new GetComboxBox_dal();
//        ArrayList<NhanVien_model> list = new ArrayList<>();
//        list = obj.DataTable();
//        for(NhanVien_model lg : list){
//            System.out.println(lg.getMapb()+lg.getMacv()+lg.getMatdhv());
//        }
//    }
}
