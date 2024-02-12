import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        rockPaperScissors(game);

        System.out.println("Finalizando o jogo...");
    }

    /**
     * Inicializa o jogo "Pedra, Papel e Tesoura"
     */
    private static void rockPaperScissors(Game game) {
        Scanner scanner = new Scanner(System.in);
        game.play(true);
        game.addPlayerToRanking();

        System.out.println("Número total de jogadas: " + game.getPlayTimes());
        Player bestPlayer = game.getBestPlayer();
        System.out.println("Melhor jogador: " + bestPlayer);

        System.out.print("Deseja iniciar um novo Jogo? (s/n): ");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("s")) rockPaperScissors(game);

    }
}