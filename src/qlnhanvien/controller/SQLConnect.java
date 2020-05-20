/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class SQLConnect {

    static String url = "jdbc:sqlserver://DESKTOP-G3PG01C\\NHATNGUYEN:1433;databaseName=QLNV";
    static String user = "sa";
    static String password = "123456";

    public static Connection DBConnect() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        DBConnect();
    }

}
