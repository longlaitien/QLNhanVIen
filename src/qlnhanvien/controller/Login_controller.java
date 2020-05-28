/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.controller;

import java.sql.Statement;
import java.util.ArrayList;
import qlnhanvien.dal.Login_dal;
import qlnhanvien.dal.SQLConnect;
import qlnhanvien.model.Login_model;

/**
 *
 * @author nhatnguyen
 */
public class Login_controller {

    Login_dal login;

    public Login_controller() {
        login = new Login_dal();
    }

    public ArrayList<Login_model> getResult(String user, String pw) {
//        for (Login_model l : list) {
//            if (user.equals(l.getUsername().trim()) && pw.equals(l.getPassword().trim())) {
//                return true;
//            }
//            System.out.println(l.getUsername() + "," + l.getPassword());
//        }
        return login.getLogin(user, pw);
    }

}
