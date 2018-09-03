package com.example.HenriqueDPaula.testeaplicacaofirebase.Classes;


public enum NivelGraduacao {
    ENSINO_FUNDAMENTAL("Ensino fundamental"),
    ENSINO_MEDIO("Ensino Médio"),
    ENSINO_SUPERIOR("Ensino Superior"),
    POS_GRADUACAO("Pós-graduação"),
    MESTRADO("Mestrado");
	
    private String nomeNivel;

    NivelGraduacao(String s) {
        nomeNivel = s;
    }
    @Override public String toString() {
        return nomeNivel;
    }

}
