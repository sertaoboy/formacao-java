package Alura.ScreenMatch.modelo;

public class Serie extends Titulo {
    private int temporadas;
    private int episodiosPorTemporada;
    private boolean ativo;
    private int minutosPorTemporada;

    public Serie(String nome, int anoDelancamento) {
        super(nome, anoDelancamento);
    }

    public void setTemporadas(int temporadas){
        this.temporadas=temporadas;
    }
    public void setEpisodiosPorTemporada(int episodiosPorTemporada){
        this.episodiosPorTemporada=episodiosPorTemporada;
    }
    public void setAtivo(boolean ativo){
        this.ativo=ativo;
    }
    public void setMinutosPorTemporada(int minutosPorTemporada){
        this.minutosPorTemporada=minutosPorTemporada;
    }

    public int getTemporadas(){
        return temporadas;
    }
    public int getEpisodiosPorTemporada(){
        return episodiosPorTemporada;
    }
    public boolean getAtivo(){
        return ativo;
    }
    public int getMinutosPorTemporada(){
        return minutosPorTemporada;
    }

    @Override //Override possibilita a sobrescrita de um metodo da classe MAE
    public int getDuracao(){
        return getTemporadas() * getEpisodiosPorTemporada() * getMinutosPorTemporada();
    }

    @Override
    public String toString() {
        return "Serie: "+getNome() + " ("+getAno()+")";
    }
}
