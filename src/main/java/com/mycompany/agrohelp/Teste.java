package com.mycompany.agrohelp;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Teste {
    public static void criarTela() {
        JFrame tela = new JFrame ("Conversor");
        JTextField celsiusTextField = new JTextField(10);
        JLabel celsiusLabel = new JLabel("\u00B0C");
        JButton convertButton = new JButton("Converter");
        JLabel valorConvertidoLabel = new JLabel("");
        Container painelDeConteudo = tela.getContentPane();
        painelDeConteudo.setLayout(new GridLayout(2, 4, 2, 4));
        painelDeConteudo.setLayout(new GridLayout(2, 4, 2, 4));
        painelDeConteudo.add(celsiusTextField);
        painelDeConteudo.add(celsiusLabel);
        painelDeConteudo.add(convertButton);
        painelDeConteudo.add(valorConvertidoLabel);
        
        convertButton.addActionListener((e) -> {
            double celsius = Double.parseDouble(
            celsiusTextField.getText()
            );
            double fahrenheit = celsius/5 * 9 + 32;
            valorConvertidoLabel.setText(
                String.format("%.2f\u00B0F", fahrenheit));
        });
       tela.pack();
       tela.setLocationRelativeTo(null);
       tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       tela.setVisible(true);
        
    }
}
