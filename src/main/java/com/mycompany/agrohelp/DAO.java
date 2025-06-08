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

    public void carregarDados(Usuario usuario) throws Exception {
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
                long cpf = rs.getLong("CPF");
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
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ps.setString(1, Integer.toString(usuario.getIdUsuario()));
            ResultSet rs = ps.executeQuery();
            int totalDeTerrenos = rs.last() ? rs.getRow() : 0;
            Terreno[] terrenos = new Terreno[totalDeTerrenos + 1];
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
        String sql1 = "DELETE FROM caixa WHERE idTerreno = ?";
        String sql2 = "DELETE FROM terreno WHERE idTerreno = ?";

        try (Connection conexao = ConexaoBD.obterConexao(); PreparedStatement ps = conexao.prepareStatement(sql1); PreparedStatement ps2 = conexao.prepareStatement(sql2)) {

            ps.setInt(1, terreno.getIdTerreno());
            ps.execute();
            ps2.setInt(1, terreno.getIdTerreno());
            ps2.execute();
        }
    }

    public void atualizarUsuario(Usuario usuario) throws Exception {
        String sql = "UPDATE usuario SET email = ?, senha = ?, nomePerfil = ?, dataNascimento = ?, sexo = ?, CPF = ?, user = ? WHERE idUsuario = ?";

        try (Connection conexao = ConexaoBD.obterConexao(); PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getNomePerfil());
            ps.setInt(4, usuario.getDataNascimento());
            ps.setString(5, String.valueOf(usuario.getSexo()));
            ps.setLong(6, usuario.getCPF());
            ps.setString(7, usuario.getUser());
            ps.setInt(8, usuario.getIdUsuario());
            ps.execute();
        }
    }
    
    public void removerUsuario(Usuario usuario) throws Exception {
        String sql = "DELETE FROM usuario WHERE idUsuario = ?";

        try (Connection conexao = ConexaoBD.obterConexao(); PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, usuario.getIdUsuario());
            ps.execute();
        }
    }

    public Planta[] obterPlantas(Usuario usuario) throws Exception {
    String sql = "SELECT * FROM planta";

    try (
        java.sql.Connection conn = ConexaoBD.obterConexao();
        java.sql.PreparedStatement ps = conn.prepareStatement(
            sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
        )
    ) {
        
        ResultSet rs = ps.executeQuery();
        
        int totalDePlantas = rs.last() ? rs.getRow() : 0;
        Planta[] plantas = new Planta[totalDePlantas + 1]; 
        rs.beforeFirst();

        int contador = 0;
        plantas[contador++] = new Planta(0, "Adicionar Planta", "", 0, 0, "", "", "", "");

        while (rs.next()) {
            int idPlanta = rs.getInt("idPlanta");
            String nomePlanta = rs.getString("nomePlanta");
            String texturaSoloIdeial = rs.getString("texturaSoloIdeial");
            int tempoIrrigacao = rs.getInt("tempoIrrigacao");
            int tempoColheita = rs.getInt("tempoColheita");
            String condicaoColheita = rs.getString("condicaoColheita");
            String relevoIdeial = rs.getString("relevoIdeial");
            String climaIdeal = rs.getString("climaIdeal");
            String regiaoRecomendada = rs.getString("regiaoRecomendada");

            plantas[contador++] = new Planta(idPlanta, nomePlanta, texturaSoloIdeial, tempoIrrigacao, tempoColheita,
                                             condicaoColheita, relevoIdeial, climaIdeal, regiaoRecomendada);
        }
        return plantas;
    }
}
    public Planta[] obterPlantasUsuario(Usuario usuario) throws Exception {
    String sql = "SELECT p.* FROM planta p JOIN caixa c ON p.idPlanta = c.idPlanta WHERE c.idUsuario = ?";

    try (
        java.sql.Connection conn = ConexaoBD.obterConexao();
        java.sql.PreparedStatement ps = conn.prepareStatement(
            sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
        )
    ) {
        ps.setString(1, Integer.toString(usuario.getIdUsuario()));
        ResultSet rs = ps.executeQuery();

        int totalDePlantas = rs.last() ? rs.getRow() : 0;
        Planta[] plantas = new Planta[totalDePlantas + 1]; 
        rs.beforeFirst();

        int contador = 0;
        plantas[contador++] = new Planta(0, "Adicionar Planta", "", 0, 0, "", "", "", "");

        while (rs.next()) {
            int idPlanta = rs.getInt("idPlanta");
            String nomePlanta = rs.getString("nomePlanta");
            String texturaSoloIdeial = rs.getString("texturaSoloIdeial");
            int tempoIrrigacao = rs.getInt("tempoIrrigacao");
            int tempoColheita = rs.getInt("tempoColheita");
            String condicaoColheita = rs.getString("condicaoColheita");
            String relevoIdeial = rs.getString("relevoIdeial");
            String climaIdeal = rs.getString("climaIdeal");
            String regiaoRecomendada = rs.getString("regiaoRecomendada");

            plantas[contador++] = new Planta(idPlanta, nomePlanta, texturaSoloIdeial, tempoIrrigacao, tempoColheita,
                                             condicaoColheita, relevoIdeial, climaIdeal, regiaoRecomendada);
        }
        return plantas;
    }
}
    
    
    public void adicionarNaCaixa(int idUsuario, int idTerreno, int idPlanta) throws Exception {
        String sql="INSERT INTO caixa (idUsuario, idTerreno, idPlanta) VALUES (?,?,?)";
        
        try(
                java.sql.Connection conn= ConexaoBD.obterConexao();
                java.sql.PreparedStatement ps=conn.prepareStatement(sql);
                ){
                    ps.setInt(1, idUsuario);
                    ps.setInt(2, idTerreno);
                    ps.setInt(3, idPlanta);
                    ps.executeUpdate();
                    }
        }
            
    
}



