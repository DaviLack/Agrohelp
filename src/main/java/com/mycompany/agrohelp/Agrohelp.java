package com.mycompany.agrohelp;

import javax.swing.SwingUtilities;

public class Agrohelp {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });

    }
}
