package Alura.ScreenMatch.modelo;

import Alura.ScreenMatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    //@SerializedName("Title")
    private String nome;
    //@SerializedName("Year")
    private int anoDelancamento;
    private double somaAvaliacao;
    private int totalAvaliacoes;
    private int duracaoEmMinutos;
    //encapsulamento: protecao dos atributos

    public Titulo(String nome, int anoDelancamento) {
        this.nome = nome;
        this.anoDelancamento = anoDelancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if(meuTituloOmdb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Nao foi possivel realizar a conversao do ano, mais de 4 caracteres.");
        }
        this.anoDelancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAno(int anoDelancamento){
        this.anoDelancamento=anoDelancamento;
    }
    public void setSoma(double somaAvaliacao) {
        this.somaAvaliacao=somaAvaliacao;
    }
    public void setTotal(int totalAvaliacoes){
        this.totalAvaliacoes=totalAvaliacoes;
    }
    public void setDuracao(int duracaoEmMinutos){
        this.duracaoEmMinutos=duracaoEmMinutos;
    }

    public String getNome(){
        return nome;
    }
    public int getAno(){
        return anoDelancamento;
    }
    public double getSoma(){
        return somaAvaliacao;
    }
    public int getTotal(){
        return totalAvaliacoes;
    }
    public int getDuracao(){
        return duracaoEmMinutos;
    }

    public void exibirFicha() {
        System.out.println("nome do filme: "+nome);
        System.out.println("ano de lancamento: "+anoDelancamento);
    }

    public void avalia(double nota){
        somaAvaliacao = somaAvaliacao + nota;
        totalAvaliacoes++;
    }

    public double retornaMedia() {
         return somaAvaliacao/totalAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return
                "(nome='" + nome + '\'' +
                ", anoDelancamento=" + anoDelancamento +", "
                +"duracao em minutos: "+ duracaoEmMinutos + ")";

    }
}

