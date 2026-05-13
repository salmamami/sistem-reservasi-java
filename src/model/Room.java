/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author donHarumi4
 */

public class Room {
    private int id;
    private String nomorKamar;
    private String tipe;
    private Double harga;
    private String status;
    
    public Room() {}
    
    // Getter Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNomorKamar() { return nomorKamar; }
    public void setNomorKamar(String nomorKamar) { this.nomorKamar = nomorKamar; }
    public String getTipe() { return tipe; }
    public void setTipe(String tipe) { this.tipe = tipe; }
    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

