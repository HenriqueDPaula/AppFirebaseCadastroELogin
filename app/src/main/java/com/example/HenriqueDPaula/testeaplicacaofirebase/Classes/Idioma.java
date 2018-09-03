package com.example.HenriqueDPaula.testeaplicacaofirebase.Classes;


public enum Idioma {
    PT_BR("Português Brasil", "PT_BR"),
    EN("English", "EN");

    private String descricaoIdioma;
    private String siglaIdioma;
    Idioma(String s, String sigla) {
        descricaoIdioma = s;
        siglaIdioma = sigla;
    }


    @Override public String toString() {
        return descricaoIdioma;
    }

    public String getSigla() {
        return siglaIdioma;
    }
}
