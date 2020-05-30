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
import qlnhanvien.model.Trinhdo_model;

/**
 *
 * @author nhatnguyen
 */
public class TrinhDo_dal {

    Trinhdo_model td;

    public ArrayList<Trinhdo_model> DataTable() {
        ArrayList<Trinhdo_model> list = new ArrayList<>();
        String sql = "SELECT * FROM TrinhDo";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                td = new Trinhdo_model(rs.getString("matdhv"), rs.getString("tentd"), rs.getInt("trangthai3"));
                list.add(td);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int Insert_TrinhDo(String matdhv, String tentd, int trangthai3) {
        int rowInserted = 0;
        String sql = "INSERT INTO TrinhDo VALUES (?,?,?)";
        try {
            PreparedStatement pre = SQLConnect.DBConnect().prepareStatement(sql);
            pre.setString(1, matdhv);
            pre.setString(2, tentd);
            pre.setInt(3, trangthai3);

            rowInserted = pre.executeUpdate();
        } catch (SQLException e) {
//            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Mã trình độ đã tồn tại!");
        }
        return rowInserted;
    }

    public int Update_TrinhDo(String matdhv, String tentd, int trangthai) {
        int rowUpdated = 0;
        String sql = "UPDATE TrinhDo SET tentd = ?,trangthai3 = ? WHERE matdhv= ?";
        try {
            PreparedStatement pre = SQLConnect.DBConnect().prepareStatement(sql);
            pre.setString(1, tentd);
            pre.setInt(2, trangthai);
            pre.setString(3, matdhv);

            rowUpdated = pre.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowUpdated;
    }

    public int Delete_TrinhDo(String matdhv) {
        int rowDeleted = 0;
        String sql = "DELETE FROM TrinhDo WHERE matdhv=?";
        PreparedStatement statement;
        try {
            statement = SQLConnect.DBConnect().prepareStatement(sql);
            statement.setString(1, matdhv);

            rowDeleted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowDeleted;
    }
//
//    public static void main(String[] args) {
//        TrinhDo_dal obj = new TrinhDo_dal();
//        ArrayList<Trinhdo_model> list = new ArrayList<>();
//        list = obj.DataTable();
//        for (Trinhdo_model lg : list) {
//            System.out.println(lg.getMatdhv());
//            System.out.println(lg.getTentd());
//        }
//    }
}
