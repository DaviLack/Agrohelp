package com.mycompany.agrohelp;

public class Terreno {
    
    private int idTerreno;
    private String nomeTerreno;
    private double areaTerreno;
    private String textura;
    private String relevoTerreno;
    private String regiaoTerreno;
    private String climaTerreno;
    private int idUsuario;

    public Terreno(int idTerreno, String nomeTerreno, double areaTerreno, String textura,
            String relevoTerreno, String regiaoTerreno, String climaTerreno, int idUsuario) {
        this.idTerreno = idTerreno;
        this.nomeTerreno = nomeTerreno;
        this.areaTerreno = areaTerreno;
        this.textura = textura;
        this.relevoTerreno = relevoTerreno;
        this.regiaoTerreno = regiaoTerreno;
        this.climaTerreno = climaTerreno;
        this.idUsuario = idUsuario;
    }
    
    /**
     * @return the idTerreno
     */
    public int getIdTerreno() {
        return idTerreno;
    }

    /**
     * @param idTerreno the idTerreno to set
     */
    public void setIdTerreno(int idTerreno) {
        this.idTerreno = idTerreno;
    }

    /**
     * @return the nomeTerreno
     */
    public String getNomeTerreno() {
        return nomeTerreno;
    }

    /**
     * @param nomeTerreno the nomeTerreno to set
     */
    public void setNomeTerreno(String nomeTerreno) {
        this.nomeTerreno = nomeTerreno;
    }

    /**
     * @return the areaTerreno
     */
    public double getAreaTerreno() {
        return areaTerreno;
    }

    /**
     * @param areaTerreno the areaTerreno to set
     */
    public void setAreaTerreno(double areaTerreno) {
        this.areaTerreno = areaTerreno;
    }

    /**
     * @return the textura
     */
    public String getTextura() {
        return textura;
    }

    /**
     * @param textura the textura to set
     */
    public void setTextura(String textura) {
        this.textura = textura;
    }

    /**
     * @return the relevoTerreno
     */
    public String getRelevoTerreno() {
        return relevoTerreno;
    }

    /**
     * @param relevoTerreno the relevoTerreno to set
     */
    public void setRelevoTerreno(String relevoTerreno) {
        this.relevoTerreno = relevoTerreno;
    }

    /**
     * @return the regiaoTerreno
     */
    public String getRegiaoTerreno() {
        return regiaoTerreno;
    }

    /**
     * @param regiaoTerreno the regiaoTerreno to set
     */
    public void setRegiaoTerreno(String regiaoTerreno) {
        this.regiaoTerreno = regiaoTerreno;
    }

    /**
     * @return the climaTerreno
     */
    public String getClimaTerreno() {
        return climaTerreno;
    }

    /**
     * @param climaTerreno the climaTerreno to set
     */
    public void setClimaTerreno(String climaTerreno) {
        this.climaTerreno = climaTerreno;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    @Override
    public String toString() {
        return this.nomeTerreno;
    }

    
}
