/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import Entity.User;
import context.DBContext;
import java.util.ArrayList;

/**
 *
 * @author myths
 */
public class dao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        String query = "select * from Users";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(String.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getBoolean(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("List" + e.getMessage());
        }
        return list;
    }

    public User login(String name, String password) {
        String query = "select * from Users"
                + "where [name]=?\n"
                + "and password=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return new User(String.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6));
        } catch (Exception e) {
            System.out.println("Login" + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        dao a = new dao();
        System.out.println(a.login("Hanoi", "my"));
    }
}
