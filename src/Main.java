import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            gameModes(game);
        } catch (Exception e) {
            System.out.println("Finalizando o jogo...");
        }
    }

    /**
     * Demonstra a tela de escolha de modo de Jogo
     * @param game Instancia de Jogo
     */
    private static void gameModes(Game game) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("""
                    Escolha o modo de jogo\s
                    1 - Pedra, Papel e Tesoura\s
                    2 - Adivinhe o Número\s
                    Escolha a opção:""");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Tente novamente");
                scanner.next();
            }
            int modo = scanner.nextInt();
            scanner.nextLine();

            if (modo == 1) {
                rockPaperScissors(game);
            } else if (modo == 2) {
                pickANumber(game);
            } else {
                System.out.println("Modo inválido. Escolha 1 ou 2.");
                continue;
            }

            System.out.print("Deseja iniciar um novo Jogo? (s/n): ");
            String answer = scanner.nextLine().toLowerCase();
            if (!answer.equals("s")) break;
        }
    }

    /**
     * Inicializa o jogo "Pedra, Papel e Tesoura"
     */
    private static void rockPaperScissors(Game game) {
        game.play(true);
        game.addPlayerToRanking();

        System.out.println("Número total de jogadas: " + game.getPlayTimes());
        Player bestPlayer = game.getBestPlayer();
        System.out.println("Melhor jogador: " + bestPlayer);
    }

    /**
     * Inicializa o jogo "Adivinhe o Número"
     */
    private static void pickANumber(Game game) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número máximo (num): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Tente novamente");
            scanner.next();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        game.play(true, number);
        game.addPlayerToRanking();

        System.out.println("Número total de jogadas: " + game.getPlayTimes());
        Player bestPlayer = game.getBestPlayer();
        System.out.println("Melhor jogador: " + bestPlayer);
    }
}