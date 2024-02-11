import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    public static void main(String[] args) {
        PlayerRanking ranking = new PlayerRanking();
        scanner = new Scanner(System.in);
        while (true) {
            String playerName = readAndValidatePlayerName(ranking.getRanking());
            if (playerName.equalsIgnoreCase("sair")) break;

            int playerAge = readAndValidatePlayerAge();

            Player player = new Player(playerName, playerAge);
            ranking.addPlayer(player);

            System.out.println("Jogador criado: " + player.getName()+"\n");
        }
        scanner.close();
        System.out.println("\nLista de jogadores:");
        ranking.getRanking().forEach(p -> System.out.println(p.getName()));
    }

    /**
     * Obtém e valida o nome informado para um novo jogador
     *
     * @param players lista de jogadores existentes
     * @return nome do jogador
     */
    private static String readAndValidatePlayerName(List<Player> players) {
        boolean isValid = true;
        String finalName = "";
        do {
            System.out.println((isValid
                    ? "Digite o nome do jogador "
                    : "Este nome já existe. Tente outro ") + "(ou 'sair' para encerrar):");
            String playerName = finalName = scanner.nextLine();
            if (!players.isEmpty())
                isValid = players.stream().noneMatch(p -> p.getName().equalsIgnoreCase(playerName));
        } while (!isValid);
        return finalName;
    }

    /**
     * Obtém e valida a idade informada para o novo jogador
     * @return idade do jogador
     */
    private static int readAndValidatePlayerAge(){
        System.out.println("Digite a idade do jogador: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Tente novamente");
            scanner.next();
        }
        int playerAge = scanner.nextInt();
        scanner.nextLine();

        return playerAge;
    }
}