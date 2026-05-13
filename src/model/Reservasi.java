/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author LENOVO
 */
import java.math.BigDecimal;
import java.sql.Date;

public class Reservasi {
    
    private int idReservasi;
    private int idPelanggan;
    private int idUser;
    private int idRoom;
    private java.sql.Date tanggal;
    private int lamaMenginap;
    private BigDecimal totalHarga;
    private String status;
    private Date checkIn;
    private Date checkOut;
    private String namaPelanggan;

    
    public Reservasi() {}
    
    public int getIdReservasi() {
        return idReservasi;
    }
    
    public void setIdReservasi(int idReservasi) {
        this.idReservasi = idReservasi;
    }
    
    public int getIdPelanggan() {
        return idPelanggan;
    }
    
    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    
    public int getIdUser() {
        return idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }
    
    public Date getTanggal() {
        return tanggal;
    }
    
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    public int getLamaMenginap() {
        return lamaMenginap;
    }

    public void setLamaMenginap(int lamaMenginap) {
        this.lamaMenginap = lamaMenginap;
    }
    
    public BigDecimal getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(BigDecimal totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Date getCheckIn() {
        return checkIn;
    }
    
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }
    
    public Date getCheckOut() {
        return checkOut;
    }
    
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
    
    public String getNamaPelanggan() {
    return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
    this.namaPelanggan = namaPelanggan;
    }

}
