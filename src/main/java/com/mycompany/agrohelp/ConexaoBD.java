package com.mycompany.agrohelp;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD{

    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "agrohelp";
    private static String usuario = "root";
    private static String senha = "mestredor8";

    public static Connection obterConexao() throws Exception {
        String url = String.format(
                "jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=America/Sao_Paulo",
                host,
                porta,
                db
        );
        return DriverManager.getConnection(url, usuario, senha);
    }
}

