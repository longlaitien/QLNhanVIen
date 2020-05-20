/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhanvien.dal;

import java.sql.Statement;
import java.util.ArrayList;
import qlnhanvien.controller.Login_Controller;
import qlnhanvien.controller.SQLConnect;
import qlnhanvien.model.Login_Model;

/**
 *
 * @author nhatnguyen
 */
public class Login_DAL {
    Login_Controller login;

    public Login_DAL() {
        login = new Login_Controller();
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
