package main;

import ui.FormLogin;

public class MainApp {
    public static void main(String[] args) {

        // Set look and feel Nimbus (opsional, sama seperti form lain)
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // boleh diabaikan, fallback ke default LAF
        }

        // Jalankan aplikasi, buka form login Alya
        java.awt.EventQueue.invokeLater(() -> {
            new FormLogin().setVisible(true);
        });
    }
}
