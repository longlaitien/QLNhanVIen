/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.dal;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlnhanvien.model.Login_Model;

/**
 *
 * @author nhatnguyen
 */
public class Login_DAL {

    public Login_DAL() {
    }

    public ArrayList<Login_Model> getLogin(String user,String pw) {
        Login_Model model = new Login_Model();
        ArrayList<Login_Model> listModel = new ArrayList<>();
        
        String sql = "SELECT * FROM Login WHERE username='" + user + "' and password='"+pw+"'";
        try {

            Statement stm = SQLConnect.DBConnect().createStatement();
            ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                model.setUsername(rs.getString("username"));
                model.setPassword(rs.getString("password"));
                listModel.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listModel;
    }

//    public static void main(String[] args) {
//        Login_DAL obj = new Login_DAL();
//        ArrayList<Login_Model> list = new ArrayList<>();
//        list = obj.getLogin("admin", "admin");
//        for(Login_Model lg : list){
//            System.out.println(lg.getUsername());
//            System.out.println(lg.getPassword());
//        }
//    }
}
