import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlayerRanking ranking = new PlayerRanking();

        Player player1 = new Player("Heverton", 36,90,3);
        Player player2 = new Player("Camila",33,110,7);
        Player player3 = new Player("Ketherine",15,95,4);
        Player player4 = new Player("Arthur", 14, 105, 6);
        Player player5 = new Player("Laura", 8, 115, 8);
        Player player6 = new Player("Isis", 2, 85, 2);
        Player player7 = new Player("Bryan", 5, 120, 9);
        Player player8 = new Player("Fulano", 13, 10, 20);
        Player player9 = new Player("Beltrano", 17, 20, 5);
        Player player10 = new Player("Ciclano", 20, 60, 11);
        Player player11 = new Player("Deltrano", 31, 70, 15);
        Player player12 = new Player("Zé", 26, 88, 19);


        ranking.addPlayer(player1);
        ranking.addPlayer(player2);
        ranking.addPlayer(player3);
        ranking.addPlayer(player4);
        ranking.addPlayer(player5);
        ranking.addPlayer(player6);
        ranking.addPlayer(player7);
        ranking.addPlayer(player8);
        ranking.addPlayer(player9);
        ranking.addPlayer(player10);
        ranking.addPlayer(player11);
        ranking.addPlayer(player12);

        System.out.println(ranking);
    }
}