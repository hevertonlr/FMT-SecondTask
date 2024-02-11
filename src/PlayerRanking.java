import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayerRanking {
    private List<Player> playerList;

    public PlayerRanking(){
        this.playerList = new ArrayList<>();
    }

    /**
     * Adicionar jogador ao ranking
     * @param player jogador a ser adicionado
     */
    public void addPlayer(Player player){ playerList.add(player); }

    /**
     * Obtem o ranking dos jogadores
     * @return retorna a lista de jogadores ordenado por pontuação (do maior para o menor)
     */
    public List<Player> getRanking(){
        playerList.sort(Comparator.comparingInt(Player::getScore).reversed());
        return playerList;
    }

    /**
     * Exibe as informações do ranking de jogadores
     * @return texto com informações do ranking de jogadores
     */
    @Override
    public String toString() {
        List<Player> rankingAtual = getRanking();
        int tamanhoLista = Math.min(rankingAtual.size(),10);

        String rankingList = "Top 10 jogadores:\n";
        for (int i = 0; i < tamanhoLista; i++) {
            rankingList +=  rankingAtual.get(i).getName()+ " - "+(i + 1)+"\n";
        }
        return rankingList;
    }

}
