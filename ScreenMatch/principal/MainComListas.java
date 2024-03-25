package Alura.ScreenMatch.principal;

import Alura.ScreenMatch.modelo.Filme;
import Alura.ScreenMatch.modelo.Serie;
import Alura.ScreenMatch.modelo.Titulo;

import java.util.*;

public class MainComListas {
    public static void main(String[] args) {
        Filme filme1 = new Filme("O Poderoso Chefao", 1978);
        filme1.avalia(10);
        Filme filme2 = new Filme("O Resgate do Soldado Ryan", 1998);
        filme2.avalia(9.4);
        var filme3 = new Filme("Dogville", 2003);
        filme3.avalia(7.8);
        Serie serie1 = new Serie("Lost", 2000);
        serie1.avalia(8.8);

        Filme f3 = filme3; //A variavel do tipo Filme f3, se referencia a mesma caracteristica que filme3, porem nao sao iguais (VARIAVEL != OBJETO), sao referencias; Se realmente fosse um novo objeto precisaria do "new" -----> Variaveis de referencia

        List<Titulo> lista = new ArrayList<>(); //List -> interface implementada com ArrayList e outros; CONTRATOS; Bom habito se referenciar atraves de Interfaces; Lembrando: Nao se pode dar new em uma Interface, nao possui metodos concretos, talvez ate nao seria uma Classe(?)
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(serie1);

        for (Titulo item : lista ) {
            System.out.println(item.getNome());
            if(item instanceof Filme filme && filme.getClassificacao() > 2) {
//                Filme filme = (Filme) item;            //CASTING de uma classe Mae para classe Filha (Titulo -> Filme)
                System.out.println("Classificacao: " + filme.getClassificacao());
            }

        }

        ArrayList<String>buscaPorArtista = new ArrayList<>();  // Como sortear essa lista por ordem alfabetica? -> Collections.sort()
        buscaPorArtista.add("Brad Pitt");
        buscaPorArtista.add("Tom Hanks");
        buscaPorArtista.add("Adam Sandler");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenacao: " + buscaPorArtista);
        System.out.println("Lista de Titulos ordenados: ");
        Collections.sort(lista); //CompareTo -> Comparar tipos primitivos e facil, mas como compara Objetos? Alem disso, qual o paramentro pra comapracao? ----> INTERFACE Comparable
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAno)); //Maneira de comparacao != algo comparavel;
        System.out.println("Ordenando por ano: "+lista);
    }
}
