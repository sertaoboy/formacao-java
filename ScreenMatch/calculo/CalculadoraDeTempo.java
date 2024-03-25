package Alura.ScreenMatch.calculo;

import Alura.ScreenMatch.modelo.Filme;
import Alura.ScreenMatch.modelo.Serie;
import Alura.ScreenMatch.modelo.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

//    public void setTempoTotal(int tempoTotal){
//        this.tempoTotal=tempoTotal;
//   } ----------> nesse caso o metodo Setter nao e preciso, pq o metodo inclui ja faz esse processo de "setar" um tempo para algum filme
    public int getTempoTotal(){
        return this.tempoTotal;
    }


//    public void inclui(Filme f){
//        this.tempoTotal = tempoTotal + f.getDuracao();
//    }
//
////    public void inclui(Serie s){
////        this.tempoTotal = tempoTotal + s.getDuracao();
////    }

    public void inclui(Titulo t) {
        System.out.println("Adicionando duracao em minutos de "+t);
        this.tempoTotal = tempoTotal + t.getDuracao();
    }
    //Exemplo de polimorfismo => Nao necessariamente eu preciso usar as classes Serie e Filme para o metodo inclui, uma vez que ambas sao um Titulo, herdam dessa classe mae; Poli "MUITAS" morfismo "FORMAS"
}
