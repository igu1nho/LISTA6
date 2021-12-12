package Main;

import padrao.Game;
import padrao.Plataforma;
import padrao.Produtora;
import Servico.Servico;
import Leitura.Ler;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Path caminho = null;
        try {
            caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        List<Game> gameList = Ler.readGameCsv(caminho);


        int numLines = gameList.size();
        System.out.println("Numero de linhas: " + numLines);

        List<Game> ps4Games = Servico.getListByPlataforma(gameList, Plataforma.PS4);

        System.out.println("Numero de jogos de ps4: " + ps4Games.size());
        ps4Games.forEach(e -> System.out.println(e.getNome()));//imprimindo o nome dos jogos de ps4
        System.out.println("");
        List<Game> activisionGames = Servico.getByProdutora(gameList, Produtora.Activision);
        System.out.println("Numero de jogos da activision: " + activisionGames.size());
        activisionGames.forEach(e -> System.out.println(e.getName()));//imprimindo o nome dos jogos da activison

    }
}
