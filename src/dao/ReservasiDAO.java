/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*/*
package dao;

 *
 * @author LENOVO
 */

/*
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Reservasi;
import util.KoneksiDB;

public class ReservasiDAO {
    // Insert reservasi
    public void insert(Reservasi r) {
        String sql = "INSERT INTO reservasi (id_pelanggan, tanggal_reservasi, status_reservasi, id_user) VALUES (?, ?, ?, ?)";
        
        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, r.getIdPelanggan());
            ps.setDate(2, r.getTanggal());
            ps.setString(3, r.getStatus());
            ps.setInt(4, r.getIdUser());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Insert reservasi error: " + e.getMessage());
        }
    }
    
    // Ambil riwayat reservasi user login
    public List<Reservasi> getByUser(int idUser) {
        List<Reservasi> list = new ArrayList<>();
        String sql = "SELECT * FROM reservasi WHERE id_user = ?";
        
        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Reservasi r = new Reservasi();
                r.setIdReservasi(rs.getInt("id_reservasi"));
                r.setIdPelanggan(rs.getInt("id_pelanggan"));
                r.setIdUser(rs.getInt("id_user"));
                r.setTanggal(rs.getDate("tanggal_reservasi"));
                r.setStatus(rs.getString("status_reservasi"));
                list.add(r);
            }
        } catch (Exception e) {
            System.out.println("Get reservasi error: " + e.getMessage());
        }
        
        return list;
    }
    // Ambil reservasi + nama pelanggan + username (UNTUK ADMIN)
    public List<Reservasi> getAllWithNamaPelanggan() {
    List<Reservasi> list = new ArrayList<>();
    String sql = "SELECT r.id_reservasi, r.tanggal_reservasi, r.status_reservasi, p.nama_pelanggan " +
                 "FROM reservasi r " +
                 "JOIN pelanggan p ON r.id_pelanggan = p.id_pelanggan";

    try {
        Connection conn = KoneksiDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Reservasi r = new Reservasi();
            r.setIdReservasi(rs.getInt("id_reservasi"));
            r.setTanggal(rs.getDate("tanggal_reservasi"));
            r.setStatus(rs.getString("status_reservasi"));
            r.setNamaPelanggan(rs.getString("nama_pelanggan")); // baru
            list.add(r);
        }
    } catch (Exception e) {
        System.out.println("Load reservasi + nama pelanggan error: " + e.getMessage());
    }

    return list;
}

    // Update status reservasi (ADMIN)
    public void updateStatus(int idReservasi, String status) {
    String sql = "UPDATE reservasi SET status_reservasi=? WHERE id_reservasi=?";

    try {
        Connection conn = KoneksiDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, status);
        ps.setInt(2, idReservasi);
        ps.executeUpdate();
    } catch (Exception e) {
        System.out.println("Update reservasi error: " + e.getMessage());
    }
}

}
/*/

package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import model.Reservasi;
import util.KoneksiDB;

public class ReservasiDAO {

    public void insert(Reservasi r) {
        String sql = "INSERT INTO reservasi (id_pelanggan, tanggal_reservasi, status_reservasi, id_user) " + "VALUES (?, ?, ?, ?)";

        try (Connection conn = KoneksiDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, r.getIdPelanggan());
            ps.setDate(2, r.getTanggal());
            ps.setString(3, r.getStatus());
            ps.setInt(4, r.getIdUser());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Insert reservasi (simple) error: " + e.getMessage());
        }
    }

    
    public void insertBooking(Reservasi r) {
        String sql = "INSERT INTO reservasi " +
                "(id_pelanggan, id_room, tanggal_reservasi, lama_menginap, total_harga, status_reservasi, id_user) " +
                "VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, r.getIdPelanggan());
            ps.setInt(2, r.getIdRoom());
            ps.setDate(3, r.getTanggal());
            ps.setInt(4, r.getLamaMenginap());
            ps.setBigDecimal(5, r.getTotalHarga());
            ps.setString(6, r.getStatus());
            ps.setInt(7, r.getIdUser());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Insert booking error: " + e.getMessage());
        }
    }

    public List<Reservasi> getByUser(int idUser) {
        List<Reservasi> list = new ArrayList<>();
        String sql = "SELECT * FROM reservasi WHERE id_user = ? ORDER BY id_reservasi DESC";

        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reservasi r = new Reservasi();
                r.setIdReservasi(rs.getInt("id_reservasi"));
                r.setIdPelanggan(rs.getInt("id_pelanggan"));
                r.setIdUser(rs.getInt("id_user"));
                r.setIdRoom(rs.getInt("id_room"));
                r.setTanggal(rs.getDate("tanggal_reservasi"));
                r.setLamaMenginap(rs.getInt("lama_menginap"));
                r.setTotalHarga(rs.getBigDecimal("total_harga"));
                r.setStatus(rs.getString("status_reservasi"));
                list.add(r);
            }
        } catch (Exception e) {
            System.out.println("Get reservasi error: " + e.getMessage());
        }

        return list;
    }

    public List<Reservasi> getPendingRooms() {
        List<Reservasi> list = new ArrayList<>();
        String sql = "SELECT * FROM reservasi WHERE status_reservasi = 'Menunggu'";
        
        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Reservasi r = new Reservasi();
                r.setIdReservasi(rs.getInt("id_reservasi"));
                r.setIdPelanggan(rs.getInt("id_pelanggan"));
                r.setIdUser(rs.getInt("id_user"));
                r.setIdRoom(rs.getInt("id_room"));
                r.setTanggal(rs.getDate("tanggal_reservasi"));
                r.setLamaMenginap(rs.getInt("lama_menginap"));
                r.setTotalHarga(rs.getBigDecimal("total_harga"));
                r.setStatus(rs.getString("status_reservasi"));
                list.add(r);
            }
        } catch (Exception e) {
            System.out.println("Get pending rooms error: " + e.getMessage());
        }

    return list;
    }

    public void updateStatus(int idReservasi, String statusBaru) {
    String sql = "UPDATE reservasi SET status_reservasi=? WHERE id_reservasi=?";
    try (Connection conn = KoneksiDB.getConnection()) {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, statusBaru);
        ps.setInt(2, idReservasi);
        ps.executeUpdate();

        // kalau dikonfirmasi, set room jadi 'terisi'
        if ("Dikonfirmasi".equalsIgnoreCase(statusBaru)) {
            String sqlRoom = "UPDATE rooms r " +
                             "JOIN reservasi rv ON r.id = rv.id_room " +
                             "SET r.status = 'terisi' " +
                             "WHERE rv.id_reservasi = ?";
            PreparedStatement ps2 = conn.prepareStatement(sqlRoom);
            ps2.setInt(1, idReservasi);
            ps2.executeUpdate();
        }
    } catch (Exception e) {
        System.out.println("Update status error: " + e.getMessage());
    }
    }
    
    public List<Reservasi> getAllWithNamaPelanggan() {
        List<Reservasi> list = new ArrayList<>();
        String sql = "SELECT r.id_reservasi, r.tanggal_reservasi, r.status_reservasi, p.nama_pelanggan " + "FROM reservasi r " + "JOIN pelanggan p ON r.id_pelanggan = p.id_pelanggan";
        
        try {
            Connection conn = KoneksiDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Reservasi r = new Reservasi();
                r.setIdReservasi(rs.getInt("id_reservasi"));
                r.setTanggal(rs.getDate("tanggal_reservasi"));
                r.setStatus(rs.getString("status_reservasi"));
                r.setNamaPelanggan(rs.getString("nama_pelanggan")); // baru

                list.add(r);
            }
        } catch (Exception e) {
            System.out.println("Load reservasi + nama pelanggan error: " + e.getMessage());
        }
        return list;
    }
}
