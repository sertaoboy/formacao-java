package Alura.ScreenMatch.excecao;

public class ErroDeConversaoDeAnoException extends RuntimeException {
    private String mensagem;
    public ErroDeConversaoDeAnoException(String mensagem) {
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
