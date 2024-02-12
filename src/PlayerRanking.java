import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayerRanking {
    private List<Player> playerList;

    public PlayerRanking() {
        this.playerList = new ArrayList<>();
    }

    /**
     * Adicionar jogador ao ranking
     *
     * @param player jogador a ser adicionado
     */
    public void addPlayer(Player player) {
        playerList.add(player);
    }

    /**
     * Obtem o ranking dos jogadores
     *
     * @return retorna a lista de jogadores ordenado por pontuação (do maior para o menor)
     */
    public List<Player> getRanking() {
        playerList.sort(Comparator.comparingInt(Player::getScore).reversed());
        return playerList;
    }

    /**
     * Monta a lista do Ranking para exibição
     * @param limit limite de jogadores a serem exibidos
     * @return texto com a lista de jogadores
     */
    private String rankingToString(Integer limit){
        List<Player> currentRanking = getRanking();
        if(currentRanking.isEmpty())
            return "Ranking Vazio!";

        int listSize = limit!=null ? Math.min(currentRanking.size(), limit) : currentRanking.size();

        StringBuilder rankingList = new StringBuilder();
        for (int i = 0; i < listSize; i++) {
            rankingList.append(currentRanking.get(i).getName()).append(" - ").append(i + 1).append("\n");
        }
        return rankingList.toString();
    }

    /**
     * Exibe o Top 10 do Ranking
     */
    public void getTopTen(){
        System.out.println("Top 10 jogadores:\n"+rankingToString(10));
    }

    /**
     * Exibe as informações do ranking de jogadores
     *
     * @return texto com informações do ranking de jogadores
     */
    @Override
    public String toString() {
        return "Ranking geral de jogadores:\n"+rankingToString(10);
    }

}
