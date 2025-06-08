package com.mycompany.agrohelp;

public class Planta {

    /**
     * @return the idPlanta
     */
    public int getIdPlanta() {
        return idPlanta;
    }

    /**
     * @param idPlanta the idPlanta to set
     */
    public void setIdPlanta(int idPlanta) {
        this.idPlanta = idPlanta;
    }

    /**
     * @return the nomePlanta
     */
    public String getNomePlanta() {
        return nomePlanta;
    }

    /**
     * @param nomePlanta the nomePlanta to set
     */
    public void setNomePlanta(String nomePlanta) {
        this.nomePlanta = nomePlanta;
    }

    /**
     * @return the texturaSoloIdeial
     */
    public String getTexturaSoloIdeial() {
        return texturaSoloIdeial;
    }

    /**
     * @param texturaSoloIdeial the texturaSoloIdeial to set
     */
    public void setTexturaSoloIdeial(String texturaSoloIdeial) {
        this.texturaSoloIdeial = texturaSoloIdeial;
    }

    /**
     * @return the tempoIrrigacao
     */
    public int getTempoIrrigacao() {
        return tempoIrrigacao;
    }

    /**
     * @param tempoIrrigacao the tempoIrrigacao to set
     */
    public void setTempoIrrigacao(int tempoIrrigacao) {
        this.tempoIrrigacao = tempoIrrigacao;
    }

    /**
     * @return the tempoColheita
     */
    public int getTempoColheita() {
        return tempoColheita;
    }

    /**
     * @param tempoColheita the tempoColheita to set
     */
    public void setTempoColheita(int tempoColheita) {
        this.tempoColheita = tempoColheita;
    }

    /**
     * @return the condicaoColheita
     */
    public String getCondicaoColheita() {
        return condicaoColheita;
    }

    /**
     * @param condicaoColheita the condicaoColheita to set
     */
    public void setCondicaoColheita(String condicaoColheita) {
        this.condicaoColheita = condicaoColheita;
    }

    /**
     * @return the relevoIdeial
     */
    public String getRelevoIdeial() {
        return relevoIdeial;
    }

    /**
     * @param relevoIdeial the relevoIdeial to set
     */
    public void setRelevoIdeial(String relevoIdeial) {
        this.relevoIdeial = relevoIdeial;
    }

    /**
     * @return the climaIdeal
     */
    public String getClimaIdeal() {
        return climaIdeal;
    }

    /**
     * @param climaIdeal the climaIdeal to set
     */
    public void setClimaIdeal(String climaIdeal) {
        this.climaIdeal = climaIdeal;
    }

    /**
     * @return the regiaoRecomendada
     */
    public String getRegiaoRecomendada() {
        return regiaoRecomendada;
    }

    /**
     * @param regiaoRecomendada the regiaoRecomendada to set
     */
    public void setRegiaoRecomendada(String regiaoRecomendada) {
        this.regiaoRecomendada = regiaoRecomendada;
    }
    
    private int idPlanta;
    private String nomePlanta;
    private String texturaSoloIdeial;
    private int tempoIrrigacao;
    private int tempoColheita;
    private String condicaoColheita;
    private String relevoIdeial;
    private String climaIdeal;
    private String regiaoRecomendada;

    public Planta(int idPlanta, String nomePlanta, String texturaSoloIdeial, int tempoIrrigacao,
                  int tempoColheita, String condicaoColheita, String relevoIdeial, String climaIdeal,
                  String regiaoRecomendada) {
        this.idPlanta = idPlanta;
        this.nomePlanta = nomePlanta;
        this.texturaSoloIdeial = texturaSoloIdeial;
        this.tempoIrrigacao = tempoIrrigacao;
        this.tempoColheita = tempoColheita;
        this.condicaoColheita = condicaoColheita;
        this.relevoIdeial = relevoIdeial;
        this.climaIdeal = climaIdeal;
        this.regiaoRecomendada = regiaoRecomendada;
    }

    @Override
    public String toString() {
        return getNomePlanta();
    }


}
    

