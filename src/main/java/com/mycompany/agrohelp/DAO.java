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
                long  cpf = rs.getLong("CPF");
                int idUsuario = rs.getInt("idUsuario");
                usuario.setNomePerfil(nomePerfil);
                usuario.setEmail(email);
                usuario.setSexo(sexo);
                usuario.setCPF(cpf);
                usuario.setIdUsuario(idUsuario);
                
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
            ps.setString(6, Long.toString(usuario.getCPF()));
            ps.setString(7, usuario.getUser());
            ps.execute();
            
            
            return true;
            
        }
    }
    
    public Terreno[] obterTerrenos(Usuario usuario) throws Exception {
        String sql = "SELECT * FROM terreno WHERE idUsuario = ?";
        try (java.sql.Connection conn = ConexaoBD.obterConexao(); java.sql.PreparedStatement ps = conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
            ps.setString(1, Integer.toString(usuario.getIdUsuario()));
            ResultSet rs = ps.executeQuery();
            int totalDeTerrenos = rs.last() ? rs.getRow() : 0;
            Terreno[] terrenos = new Terreno[totalDeTerrenos+1];
            rs.beforeFirst();
            
            int contador = 0;
            terrenos[contador++] = new Terreno(0, "Adicionar Terreno", 0, "",
                        "", "", "", 0);
            while (rs.next()) {
                int idTerreno = rs.getInt("idTerreno");
                String nomeTerreno = rs.getString("nomeTerreno");
                double areaTerreno = rs.getDouble("areaTerreno");
                String textura = rs.getString("textura");
                String relevoTerreno = rs.getString("relevoTerreno");
                String regiaoTerreno = rs.getString("regiaoTerreno");
                String climaTerreno = rs.getString("climaTerreno");
                int idUsuario = rs.getInt("idUsuario");
                terrenos[contador++] = new Terreno(idTerreno, nomeTerreno, areaTerreno, textura,
                        relevoTerreno, regiaoTerreno, climaTerreno, idUsuario);
            }
            return terrenos;
        }
    }
    
    public void inserirTerreno(Terreno terreno) throws Exception {
        String sql = "INSERT INTO terreno (nomeTerreno, areaTerreno, textura, relevoTerreno, regiaoTerreno, climaTerreno, idUsuario) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (Connection conexao = ConexaoBD.obterConexao(); PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, terreno.getNomeTerreno());
            ps.setDouble(2, terreno.getAreaTerreno());
            ps.setString(3, terreno.getTextura());
            ps.setString(4, terreno.getRelevoTerreno());
            ps.setString(5, terreno.getRegiaoTerreno());
            ps.setString(6, terreno.getClimaTerreno());
            ps.setInt(7, terreno.getIdUsuario());

            ps.execute();
        }
    }

    public void atualizarTerreno(Terreno terreno) throws Exception {
        String sql = "UPDATE terreno SET nomeTerreno = ?, areaTerreno = ?, textura = ?, relevoTerreno = ?, "
                + "regiaoTerreno = ?, climaTerreno = ?, idUsuario = ? WHERE idTerreno = ?";

        try (Connection conexao = ConexaoBD.obterConexao(); PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, terreno.getNomeTerreno());
            ps.setDouble(2, terreno.getAreaTerreno());
            ps.setString(3, terreno.getTextura());
            ps.setString(4, terreno.getRelevoTerreno());
            ps.setString(5, terreno.getRegiaoTerreno());
            ps.setString(6, terreno.getClimaTerreno());
            ps.setInt(7, terreno.getIdUsuario());
            ps.setInt(8, terreno.getIdTerreno());

            ps.execute();
        }
    }

    public void removerTerreno(Terreno terreno) throws Exception {
        String sql = "DELETE FROM terreno WHERE idTerreno = ?";

        try (Connection conexao = ConexaoBD.obterConexao(); PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, terreno.getIdTerreno());
            ps.execute();
        }
    }
}

