/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Pelanggan {
    
    private int idPelanggan;
    private String nama;
    private String email;
    private String noHp;
    private int idUser;

    // constructor kosong
    public Pelanggan() {
        
    }
    
    // construktor opsional
    public Pelanggan(int idPelanggan, String nama, String email, String noHp, int idUser) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.idUser = idUser;
    }
    
    // ===== getter & setter =====
    
    public int getIdPelanggan() {
        return idPelanggan;
    }
    
    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNoHp() {
        return noHp;
    }
    
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
    
    public int getIdUser() {
        return idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
}