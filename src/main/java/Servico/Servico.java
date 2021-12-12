package Servico;

import padrao.Game;
import padrao.Plataforma;
import padrao.Produtora;

import java.util.ArrayList;
import java.util.List;

public class Servico {

    public static List<Game> getListByPlataforma(List<Game> games, Plataforma plataforma){
        List<Game> gamesByPlataforma = new ArrayList<>();

        games.stream().filter((game -> game.getPlataforma().equals(plataforma.nome()))).forEach(game -> gamesByPlataforma.add(game));

        return gamesByPlataforma;
    }


    public static List<Game> getByProdutora(List<Game> games ,Produtora produtora){
        List<Game> gamesByProdutora = new ArrayList<>();

        games.stream().filter((game ->
                        game.getbyProdutora().replaceAll("\\s+", "").equals(produtora.nome()))).
                forEach(game -> gamesByProdutora.add(game));

        return gamesByProdutora;
    }
}
