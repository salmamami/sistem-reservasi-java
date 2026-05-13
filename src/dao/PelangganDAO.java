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
import model.Pelanggan;
import util.KoneksiDB;
import java.util.ArrayList;
import java.util.List;

public class PelangganDAO {
    
    //Ambil data pelanggan berdasarkan id_user
    public Pelanggan getByUserId(int idUser) {
        Pelanggan p = null;
        String sql = "SELECT * FROM pelanggan WHERE id_user=?";
        
        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
      
            if (rs.next()) {
                p = new Pelanggan();
                p.setIdPelanggan(rs.getInt("id_pelanggan"));
                p.setNama(rs.getString("nama_pelanggan"));
                p.setNoHp(rs.getString("no_hp"));
                p.setEmail(rs.getString("email"));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }
    
    //Insert data pelanggan baru
    public void insert(Pelanggan p) {
        String sql = "INSERT INTO pelanggan (nama_pelanggan, no_hp, email, id_user) VALUES (?,?,?,?)";
        
        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNama());
            ps.setString(2, p.getNoHp());
            ps.setString(3, p.getEmail());
            ps.setInt(4, p.getIdUser());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Update pelanggan
    public void update(Pelanggan p) {
        String sql = "UPDATE pelanggan SET nama_pelanggan=?, no_hp=?, email=? WHERE id_user=?";
        
        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNama());
            ps.setString(2, p.getNoHp());
            ps.setString(3, p.getEmail());
            ps.setInt(4, p.getIdUser());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Update pelanggan error: " + e.getMessage());
        }
    }
    
    //Delete
    public void deleteByUserId(int idUser) {
        String sql = "DELETE FROM pelanggan WHERE id_user=?";
        
        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Hapus pelanggan error: " + e.getMessage());
        }
    }
    
    //search
    public List<Pelanggan> search(String keyword) {
    List<Pelanggan> list = new ArrayList<>();
    String sql = "SELECT * FROM pelanggan WHERE nama_pelanggan LIKE ?";

    try {
        Connection conn = KoneksiDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + keyword + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Pelanggan p = new Pelanggan();
            p.setIdPelanggan(rs.getInt("id_pelanggan"));
            p.setNama(rs.getString("nama_pelanggan"));
            p.setNoHp(rs.getString("no_hp"));
            p.setEmail(rs.getString("email"));
            p.setIdUser(rs.getInt("id_user"));
            list.add(p);
        }
    } catch (Exception e) {
        System.out.println("Search pelanggan error: " + e.getMessage());
    }
    return list;
}


}
