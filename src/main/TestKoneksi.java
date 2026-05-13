/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author LENOVO
 */
import util.KoneksiDB;

public class TestKoneksi {
    public static void main(String[] args) {
        if (KoneksiDB.getConnection() != null) {
            System.out.println("Tes koneksi sukses"); 
        }
    }
}
