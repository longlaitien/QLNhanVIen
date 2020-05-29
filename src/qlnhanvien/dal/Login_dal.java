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
import qlnhanvien.model.Login_model;

/**
 *
 * @author nhatnguyen
 */
public class Login_dal {

    public Login_dal() {
    }

    public ArrayList<Login_model> getLogin(String user, String pw) {
        Login_model model;
        ArrayList<Login_model> listModel = new ArrayList<>();

        String sql = "SELECT * FROM Login WHERE username='" + user + "' and password='" + pw + "'";
        try {
            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                model = new Login_model(rs.getString("username"), rs.getString("password"), rs.getInt("role"));
                listModel.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listModel;
    }

//    public static void main(String[] args) {
//        Login_dal obj = new Login_dal();
//        ArrayList<Login_model> list = new ArrayList<>();
//        list = obj.getLogin("admin", "admin");
//        for(Login_model lg : list){
//            System.out.println(lg.getUsername());
//            System.out.println(lg.getPassword());
//        }
//    }
}
