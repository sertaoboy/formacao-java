package Alura.ScreenMatch.calculo;


public class FiltroRecomendacao {

    public void filtra(Classificavel classicavel){
        if(classicavel.getClassificacao() >= 4) {
            System.out.println("Esta entre os mais assistidos");
        } else if(classicavel.getClassificacao() >=2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Assista depois");
        }
    }
}
