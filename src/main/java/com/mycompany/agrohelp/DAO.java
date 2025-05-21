package com.mycompany.agrohelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DAO {

    public boolean existe(Usuario usuario) throws Exception {
        String sql = "SELECT * FROM usuario WHERE user = ? AND senha = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    
    public void carregarDados(Usuario usuario) throws Exception{
        String sql = "SELECT * FROM usuario WHERE user = ? AND senha = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                String nomePerfil = rs.getString("nomePerfil");
                String email = rs.getString("email");
                Date dataNascimento = rs.getDate("dataNascimento");
                String sexo1 = rs.getString("sexo");
                char sexo = sexo1.charAt(0);
                int cpf = rs.getInt("CPF");
                usuario.setNomePerfil(nomePerfil);
                usuario.setEmail(email);
                usuario.setSexo(sexo);
                usuario.setCPF(cpf);
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String dataFormatada = sdf.format(dataNascimento);
                usuario.setDataNascimento(Integer.parseInt(dataFormatada));
                
            }
        }
        
    }
    
    public boolean cadastrar(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuario(email, senha, nomePerfil, dataNascimento, sexo, CPF, user) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getNomePerfil());
            ps.setString(4, Integer.toString(usuario.getDataNascimento()));
            ps.setString(5, String.valueOf(usuario.getSexo()));
            ps.setString(6, Integer.toString(usuario.getCPF()));
            ps.setString(7, usuario.getUser());
            ps.execute();
            
            return true;
            
        }
    }
    
}

