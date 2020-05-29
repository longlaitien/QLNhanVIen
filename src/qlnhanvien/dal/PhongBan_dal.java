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
import qlnhanvien.model.Phongban_model;

/**
 *
 * @author nhatnguyen
 */
public class PhongBan_dal {

    Phongban_model pb;

    public ArrayList<Phongban_model> DataTable() {
        ArrayList<Phongban_model> list = new ArrayList<>();
        String sql = "SELECT mapb,tenpb,diachi,sodtpb,trangthai FROM PhongBan";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                pb = new Phongban_model(rs.getString("mapb"), rs.getString("tenpb"), rs.getString("diachi"), rs.getString("sodtpb"), rs.getInt("trangthai"));
                list.add(pb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int Insert_PhongBan(String mapb, String tenpb, String diachi, String sodtpb, int trangthai) {
        int rowInserted = 0;
        String sql = "INSERT INTO PhongBan VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pre = SQLConnect.DBConnect().prepareStatement(sql);
            pre.setString(1, mapb);
            pre.setString(2, tenpb);
            pre.setString(3, diachi);
            pre.setString(4, sodtpb);
            pre.setInt(5, trangthai);

            rowInserted = pre.executeUpdate();
        } catch (SQLException e) {
//            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Mã phòng ban đã tồn tại!");
        }
        return rowInserted;
    }

    public int Update_PhongBan(String mapb, String tenpb, String diachi, String sodtpb, int trangthai) {
        int rowUpdated = 0;
        String sql = "UPDATE PhongBan SET tenpb = ?,diachi = ?,sodtpb = ?,trangthai = ? WHERE mapb = ?";
        try {
            PreparedStatement pre = SQLConnect.DBConnect().prepareStatement(sql);
            pre.setString(1, tenpb);
            pre.setString(2, diachi);
            pre.setString(3, sodtpb);
            pre.setInt(4, trangthai);
            pre.setString(5, mapb);

            rowUpdated = pre.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowUpdated;
    }

    public int Delete_PhongBan(String mapb) {
        int rowDeleted = 0;
        String sql = "DELETE FROM PhongBan WHERE mapb=?";
        PreparedStatement statement;
        try {
            statement = SQLConnect.DBConnect().prepareStatement(sql);
            statement.setString(1, mapb);

            rowDeleted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowDeleted;
    }
}
