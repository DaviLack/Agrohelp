package com.mycompany.agrohelp;


public class Usuario {

    /**
     * @return the idUsuario
     */
   

    
    private String nomePerfil;
    private String email;
    private String senha;
    private int dataNascimento;
    private char sexo;
    private long CPF;
    private String user;
    private int idUsuario;
    
    /**
     * @return the nomePerfil
     */
    
    
    public Usuario(String user, String senha){
        this.nomePerfil = nomePerfil;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.CPF = CPF;
        this.user = user;
        
    }
    
    public String getNomePerfil() {
        return nomePerfil;
    }

    /**
     * @param nomePerfil the nomePerfil to set
     */
    public void setNomePerfil(String nomePerfil) {
    this.nomePerfil = nomePerfil;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the dataNascimento
     */
    public int getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the CPF
     */
    public long getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(long CPF) {
        this.CPF = CPF;
    }
    
    public String getUser() {
        return user;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    
     public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
