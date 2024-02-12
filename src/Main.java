import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Game game = new Game();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Ver ranking completo");
                System.out.println("2 - Ver os 10 melhores");
                System.out.println("3 - Jogar novamente");
                System.out.println("4 - Encerrar o jogo");
                System.out.print("Opção escolhida: ");


                while (!scanner.hasNextInt()) {
                    System.out.println("Entrada inválida. Tente novamente");
                    scanner.next();
                }
                int option = scanner.nextInt();
                scanner.nextLine();


                switch (option) {
                    case 1:
                        System.out.println(game.getRanking());
                        break;
                    case 2:
                        game.getRanking().getTopTen();
                        break;
                    case 3:
                        gameModes(game);
                        break;
                    case 4:
                        System.out.println("Encerrando o jogo. Até mais!");
                        return;
                    default:
                        System.out.println("Opção inválida. Escolha novamente.");
                }
            }
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
            int mode = scanner.nextInt();
            scanner.nextLine();

            if (mode == 1) {
                rockPaperScissors(game);
            } else if (mode == 2) {
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