/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author LENOVO
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;
import util.KoneksiDB;

public class UserDAO {
    
    //Login
    public User login(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        
        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                user = new User();
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return user;
    } 
    
    //Cek Username (Untuk Daftar)
    public boolean cekUsername(String username) {
        String sql = "SELECT * FROM user WHERE username=?";
        
        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            return rs.next(); // true jika sudah ada
        } catch (Exception e) {
            System.out.println("Cek username error: " + e.getMessage());
        }
        return false;
    }
    
    //Insert User Baru
    public void insert(User user) {
        String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
        
        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Insert user error: " + e.getMessage());
        }
    }
}
