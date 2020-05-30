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
public class NhanVien_dal {

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
            pre.setInt(14, nvmodel.getTrangthai());
            rowInserted = pre.executeUpdate();
        } catch (SQLException e) {
//            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Mã nhân viên đã tồn tại!");
        }
        return rowInserted;
    }

    public int Update_Nhanvien(NhanVien_model nvmodel) {
        int rowUpdated = 0;
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
            pre.setInt(13, nvmodel.getTrangthai());
            pre.setString(14, nvmodel.getManv());
            rowUpdated = pre.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowUpdated;
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

    public ArrayList<NhanVien_model> TimKiem_NhanVien(String tk_nv) {
        NhanVien_model nv = new NhanVien_model();
        ArrayList<NhanVien_model> listModel = new ArrayList<>();

        String sql = "SELECT manv, hoten, ngaysinh, quequan, gioitinh, dantoc, sodt, heso, luongcb, image, tenpb,tencv,tentd,trangthai FROM (NhanVien"
                + " inner join PhongBan on (NhanVien.mapb = PhongBan.mapb)"
                + " inner join ChucVu on (NhanVien.macv = ChucVu.macv)"
                + " inner join TrinhDo on (NhanVien.matdhv = TrinhDo.matdhv))"
                + " WHERE manv LIKE '%" + tk_nv + "%'";
        try {
            Statement pre = SQLConnect.DBConnect().createStatement();
            ResultSet rs = pre.executeQuery(sql);
            while (rs.next()) {
                nv = new NhanVien_model(rs.getString("manv"), rs.getString("hoten"), rs.getString("ngaysinh"), rs.getString("quequan"), rs.getString("gioitinh"), rs.getString("dantoc"), rs.getString("sodt"), rs.getFloat("heso"), rs.getFloat("luongcb"), rs.getString("image"), rs.getString("tenpb"), rs.getString("tencv"), rs.getString("tentd"), rs.getInt("trangthai"));
                listModel.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listModel;
    }
    
    public ArrayList<NhanVien_model> Lookup_NhanVien(String tk_nv) {
        NhanVien_model nv = new NhanVien_model();
        ArrayList<NhanVien_model> listModel = new ArrayList<>();

        String sql = "SELECT manv, hoten, ngaysinh, quequan, gioitinh, dantoc, sodt, heso, luongcb, image, tenpb,tencv,tentd,trangthai FROM (NhanVien"
                + " inner join PhongBan on (NhanVien.mapb = PhongBan.mapb)"
                + " inner join ChucVu on (NhanVien.macv = ChucVu.macv)"
                + " inner join TrinhDo on (NhanVien.matdhv = TrinhDo.matdhv))"
                + " WHERE manv ='"+ tk_nv +"'";
        try {
            Statement pre = SQLConnect.DBConnect().createStatement();
            ResultSet rs = pre.executeQuery(sql);
            while (rs.next()) {
                nv = new NhanVien_model(rs.getString("manv"), rs.getString("hoten"), rs.getString("ngaysinh"), rs.getString("quequan"), rs.getString("gioitinh"), rs.getString("dantoc"), rs.getString("sodt"), rs.getFloat("heso"), rs.getFloat("luongcb"), rs.getString("image"), rs.getString("tenpb"), rs.getString("tencv"), rs.getString("tentd"), rs.getInt("trangthai"));
                listModel.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listModel;
    }

    public ArrayList<NhanVien_model> Filter_Gender(String gender) {
        NhanVien_model nv = new NhanVien_model();
        ArrayList<NhanVien_model> listModel = new ArrayList<>();
        String sql;
        if (gender.equals("Tất cả")) {
            sql = "SELECT manv, hoten, ngaysinh, quequan, gioitinh, dantoc, sodt, heso, luongcb, image, tenpb,tencv,tentd,trangthai FROM (NhanVien"
                + " inner join PhongBan on (NhanVien.mapb = PhongBan.mapb)"
                + " inner join ChucVu on (NhanVien.macv = ChucVu.macv)"
                + " inner join TrinhDo on (NhanVien.matdhv = TrinhDo.matdhv))";
            
        } else {
            sql = "SELECT manv, hoten, ngaysinh, quequan, gioitinh, dantoc, sodt, heso, luongcb, image, tenpb,tencv,tentd,trangthai FROM (NhanVien"
                + " inner join PhongBan on (NhanVien.mapb = PhongBan.mapb)"
                + " inner join ChucVu on (NhanVien.macv = ChucVu.macv)"
                + " inner join TrinhDo on (NhanVien.matdhv = TrinhDo.matdhv))"
                + " WHERE gioitinh =N'"+ gender +"'";
        }
        try {
            Statement stm;
            stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                nv = new NhanVien_model(rs.getString("manv"), rs.getString("hoten"), rs.getString("ngaysinh"), rs.getString("quequan"), rs.getString("gioitinh"), rs.getString("dantoc"), rs.getString("sodt"), rs.getFloat("heso"), rs.getFloat("luongcb"), rs.getString("image"), rs.getString("tenpb"), rs.getString("tencv"), rs.getString("tentd"), rs.getInt("trangthai"));
                listModel.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listModel;
    }

//    public static void main(String[] args) {
//        NhanVien_dal obj = new NhanVien_dal();
//        ArrayList<NhanVien_model> list = new ArrayList<>();
//        obj.Filter_Gender("Nam");
//        
//    }
}
