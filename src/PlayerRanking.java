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

    @Override
    public String toString() {
        String rankingList = "Ranking dos melhores jogadores:\n";
        for (int i = 0; i < playerList.size(); i++) {
            rankingList += (i + 1) + ". " + playerList.get(i).toRanking()+"\n";
        }
        return rankingList;
    }

}
