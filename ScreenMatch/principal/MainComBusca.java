package Alura.ScreenMatch.principal;
import Alura.ScreenMatch.excecao.ErroDeConversaoDeAnoException;
import Alura.ScreenMatch.modelo.Titulo;
import Alura.ScreenMatch.modelo.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.sound.midi.SysexMessage;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {


            System.out.println("Digite um filme para busca");
            busca = leitura.nextLine();

            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=44b93518";  //tratameto do problema de excecao quando o input inclui espaco; o espaco em branco e substituido pelo operador +, e faz a concatenecao deixando a URL acessivel
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco)) //factory
                        .build(); //builder
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());


                String json = response.body();
                System.out.println(json);


                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                //try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo convertido!");
                System.out.println(meuTitulo);
                titulos.add(meuTitulo);

//                FileWriter escrita = new FileWriter("filmes.txt");
//                escrita.write(meuTitulo.toString());
//                escrita.close();
            } catch (NumberFormatException erro) {
                System.out.println("Erro!");
                System.out.println(erro.getMessage());
            } catch (IllegalArgumentException erroChar) {
                System.out.println("Erro!");
                System.out.println(erroChar.getMessage());
            } catch (ErroDeConversaoDeAnoException excecao) {
                System.out.println(excecao.getMessage()); //excecoes podem ser previsiveis e trataveis, erros sao mais dificeis de tratar
            }

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }
        }
        System.out.println(titulos);


        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("O programa terminou a execucao");



    }
}
