package util;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class KoneksiDB {
    
    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
               String url = "jdbc:mysql://localhost:3306/sistem_reservasi";
               String user = "root";
               String pass = "";
               
               Class.forName("com.mysql.cj.jdbc.Driver");
               conn = DriverManager.getConnection(url, user, pass);
               System.out.println("Koneksi database berhasil");
            }
        } catch (Exception e) {
            System.out.println("Koneksi database gagal: " + e.getMessage());
        }
        return conn;
    }
}