/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author donHarumi4
 */

import model.Room;
import util.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Room;
import util.KoneksiDB;

public class RoomDAO {
    
        public List<Room> getKamarKosong() {
            List<Room> list = new ArrayList<>();
            String sql = "SELECT * FROM rooms WHERE status = 'kosong'";
            
            try (Connection conn = KoneksiDB.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery()) {
                
                while (rs.next()) {
                    Room r = new Room();
                    r.setId(rs.getInt("id_room"));

                    r.setNomorKamar(rs.getString("nomor_kamar"));
                    r.setTipe(rs.getString("tipe"));
                    r.setHarga(rs.getDouble("harga"));
                    r.setStatus(rs.getString("status"));
                    list.add(r);
                }
            } catch (Exception e) {
                System.out.println("getKamarKosong error: " + e.getMessage());
            }
            return list;
        }
    
    public void create(Room room) throws SQLException {
        String sql = "INSERT INTO rooms (nomor_kamar, tipe, harga, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, room.getNomorKamar());
            ps.setString(2, room.getTipe());
            ps.setDouble(3, room.getHarga());
            ps.setString(4, room.getStatus());
            ps.executeUpdate();
        }
    }
    
    public void update(Room room) throws SQLException {
        String sql = "UPDATE rooms SET nomor_kamar=?, tipe=?, harga=?, status=? WHERE id=?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, room.getNomorKamar());
            ps.setString(2, room.getTipe());
            ps.setDouble(3, room.getHarga());
            ps.setString(4, room.getStatus());
            ps.setInt(5, room.getId());
            ps.executeUpdate();
        }
    }
    
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM rooms WHERE id=?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
    public List<Room> getAll() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setNomorKamar(rs.getString("nomor_kamar"));
                room.setTipe(rs.getString("tipe"));
                room.setHarga(rs.getDouble("harga"));
                room.setStatus(rs.getString("status"));
                rooms.add(room);
            }
        }
        return rooms;
    }
    
    /*/*
    public List<Room> getKamarKosong() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms WHERE status = 'kosong'";
        // sama seperti getAll() tapi filter status='kosong'
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Room r = new Room();
                r.setId(rs.getInt("id"));
                r.setNomorKamar(rs.getString("nomor_kamar"));
                r.setTipe(rs.getString("tipe"));
                r.setHarga(rs.getDouble("harga"));
                r.setStatus(rs.getString("status"));
            }
        }
        return rooms;
    }
*/
    
    public void loadTable(DefaultTableModel model) throws SQLException {
        model.setRowCount(0);
        List<Room> rooms = getAll();
        for (Room room : rooms) {
            model.addRow(new Object[]{
                room.getId(),
                room.getNomorKamar(),
                room.getTipe(),
                room.getHarga(),
                room.getStatus()
            });
        }
    }
    
    public Room getById(int id) throws SQLException {
        String sql = "SELECT * FROM rooms WHERE id=?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setNomorKamar(rs.getString("nomor_kamar"));
                room.setTipe(rs.getString("tipe"));
                room.setHarga(rs.getDouble("harga"));
                room.setStatus(rs.getString("status"));
                return room;
            }
        }
        return null;
    }
    
    public void updateStatusKamar(int idRoom, String status) throws SQLException {
    String sql = "UPDATE rooms SET status=? WHERE id=?";
    try (Connection conn = KoneksiDB.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, status);
        ps.setInt(2, idRoom);
        ps.executeUpdate();
    }
}

}

