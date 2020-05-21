/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.controller;

import java.sql.Statement;
import java.util.ArrayList;
import qlnhanvien.dal.Login_DAL;
import qlnhanvien.dal.SQLConnect;
import qlnhanvien.model.Login_Model;

/**
 *
 * @author nhatnguyen
 */
public class LoginController {
    Login_DAL login;

    public LoginController() {
        login = new Login_DAL();
    }
    public boolean getResult(String user, String pw){
        ArrayList<Login_Model> list = new ArrayList<>();
        list=login.getLogin(user,pw);
        for(Login_Model l : list){
            if(user.equals(l.getUsername().trim()) && pw.equals(l.getPassword().trim())){
                return true;
            }
            System.out.println(l.getUsername()+","+l.getPassword());
        }
        return false;
    }

}
