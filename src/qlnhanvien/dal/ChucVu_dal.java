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
import qlnhanvien.model.Chucvu_model;

/**
 *
 * @author nhatnguyen
 */
public class ChucVu_dal {
    Chucvu_model cv;
    
    public ArrayList<Chucvu_model> DataTable() {
        ArrayList<Chucvu_model> list = new ArrayList<>();
        String sql = "SELECT macv,tencv,trangthai FROM ChucVu";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cv = new Chucvu_model(rs.getString("macv"), rs.getString("tencv"), rs.getInt("trangthai"));
                list.add(cv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int Insert_ChucVu(String macv, String tencv, int trangthai) {
        int rowInserted = 0;
        String sql = "INSERT INTO ChucVu VALUES (?,?,?)";
        try {
            PreparedStatement pre = SQLConnect.DBConnect().prepareStatement(sql);
            pre.setString(1, macv);
            pre.setString(2, tencv);
            pre.setInt(3, trangthai);

            rowInserted = pre.executeUpdate();
        } catch (SQLException e) {
//            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Mã chức vụ đã tồn tại!");
        }
        return rowInserted;
    }

    public int Update_ChucVu(String macv, String tencv, int trangthai) {
        int rowUpdated = 0;
        String sql = "UPDATE ChucVu SET tencv = ?,trangthai = ? WHERE macv = ?";
        try {
            PreparedStatement pre = SQLConnect.DBConnect().prepareStatement(sql);
            pre.setString(1, tencv);
            pre.setInt(2, trangthai);
            pre.setString(3, macv);

            rowUpdated = pre.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowUpdated;
    }

    public int Delete_ChucVu(String macv) {
        int rowDeleted = 0;
        String sql = "DELETE FROM ChucVu WHERE macv=?";
        PreparedStatement statement;
        try {
            statement = SQLConnect.DBConnect().prepareStatement(sql);
            statement.setString(1, macv);

            rowDeleted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowDeleted;
    }
}
