/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlnhanvien.model.NhanVien_model;

/**
 *
 * @author nhatnguyen
 */
public class NhanVien_DAL {

    public int Insert_Nhanvien(NhanVien_model nvmodel) {
        int rowInserted = 0;
        String sql = "INSERT INTO NhanVien (manv,hoten,ngaysinh,quequan,gioitinh,dantoc,sodt,heso,luongcb,image,mapb,macv,matdhv,trangthai) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = SQLConnect.DBConnect().prepareStatement(sql);
            pre.setString(1, nvmodel.getManv());
            pre.setString(2, nvmodel.getHoten());
            pre.setString(3, nvmodel.getNgaysinh());
            pre.setString(4, nvmodel.getQuequan());
            pre.setString(5, nvmodel.getGioitinh());
            pre.setString(6, nvmodel.getDantoc());
            pre.setString(7, nvmodel.getSodt());
            pre.setFloat(8, nvmodel.getHeso());
            pre.setFloat(9, nvmodel.getLuongcb());
            pre.setString(10, nvmodel.getImage());
            pre.setString(11, nvmodel.getMapb());
            pre.setString(12, nvmodel.getMacv());
            pre.setString(13, nvmodel.getMatdhv());
            pre.setInt(14, 1);
            rowInserted = pre.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowInserted;
    }

    public int Update_Nhanvien(NhanVien_model nvmodel) {
        int rowInserted = 0;
        String sql = "UPDATE NhanVien SET hoten=?,ngaysinh=?,quequan=?,gioitinh=?,dantoc=?,sodt=?,heso=?,luongcb=?,image=?,mapb=?,macv=?,matdhv=?,trangthai=? WHERE manv=?";
        try {
            PreparedStatement pre = SQLConnect.DBConnect().prepareStatement(sql);

            pre.setString(1, nvmodel.getHoten());
            pre.setString(2, nvmodel.getNgaysinh());
            pre.setString(3, nvmodel.getQuequan());
            pre.setString(4, nvmodel.getGioitinh());
            pre.setString(5, nvmodel.getDantoc());
            pre.setString(6, nvmodel.getSodt());
            pre.setFloat(7, nvmodel.getHeso());
            pre.setFloat(8, nvmodel.getLuongcb());
            pre.setString(9, nvmodel.getImage());
            pre.setString(10, nvmodel.getMapb());
            pre.setString(11, nvmodel.getMacv());
            pre.setString(12, nvmodel.getMatdhv());
            pre.setInt(13, 1);
            pre.setString(14, nvmodel.getManv());
            rowInserted = pre.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowInserted;
    }

    public int Delete_NhanVien(String manv) {
        int rowDeleted = 0;
        String sql = "DELETE FROM NhanVien WHERE manv=?";
        PreparedStatement statement;
        try {
            statement = SQLConnect.DBConnect().prepareStatement(sql);
            statement.setString(1, manv);

            rowDeleted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowDeleted;
    }

    public ArrayList<NhanVien_model> TimKiem_NhanVien(String manv) {
        NhanVien_model nv = new NhanVien_model();
        ArrayList<NhanVien_model> listModel = new ArrayList<>();

        String sql = "SELECT * FROM NhanVien WHERE manv LIKE '%" + manv + "%'";
        try {
            Statement stm;
            stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                nv = new NhanVien_model(rs.getString("manv"), rs.getString("hoten"), rs.getString("ngaysinh"), rs.getString("quequan"), rs.getString("gioitinh"), rs.getString("dantoc"), rs.getString("sodt"), rs.getFloat("heso"), rs.getFloat("luongcb"), rs.getString("image"), rs.getString("mapb"), rs.getString("macv"), rs.getString("matdhv"));
                listModel.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listModel;
    }
}
