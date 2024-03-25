package Alura.ScreenMatch.modelo;

import Alura.ScreenMatch.calculo.Classificavel;

public class Filme extends Titulo implements Classificavel {  //"Extends" palavra reservada para aplicar heranca a uma classe
    private String diretor;

    public Filme (String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public void setDiretor(String diretor) {

        this.diretor = diretor;
    }
    public String getDiretor(){
        return diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) retornaMedia()/2;
    }

    @Override
    public String toString() {
        return "Filme: " +getNome() + " (" + getAno() + ")";
    }
}