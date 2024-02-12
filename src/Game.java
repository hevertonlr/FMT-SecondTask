import java.util.List;
import java.util.Scanner;

public class Game {
    private static Scanner scanner;
    private PlayerRanking ranking;
    private Player bestPlayer;
    private int playTimes;
    private Player currentPlayer;

    public Game() {
        this.ranking = new PlayerRanking();
        this.bestPlayer = null;
        this.playTimes = 0;
    }

    //region GetterAndSetters
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public int getPlayTimes() {
        return this.playTimes;
    }

    public Player getBestPlayer() {
        return this.bestPlayer;
    }

    public void addPlayerToRanking() {
        this.ranking.addPlayer(this.currentPlayer);
    }
    //endregion

    /**
     * Inicializa o jogo "Pedra, Papel e Tesoura"
     */
    public void play(boolean setNewPlayer) {
        if (setNewPlayer)
            newPlayer();

        System.out.println("Bem-vindo ao Pedra, Papel e Tesoura!");

        System.out.print("Digite sua jogada (pedra, papel ou tesoura): ");
        Scanner scanner = new Scanner(System.in);
        String playerMove = scanner.nextLine().toLowerCase();

        mathResults(playerMove);

        System.out.println("Pontuação atual: " + currentPlayer.getScore());
        setBestPlayer();
        playTimes++;

        System.out.print("Deseja jogar novamente? (s/n): ");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("s")) play(false);
    }

    /**
     * Verifica o resultado do jogo
     *
     * @param playerMove escolha do jogador
     */
    private void mathResults(String playerMove) {
        String[] options = {"pedra", "papel", "tesoura"};
        String oppositeMove = options[(int) (Math.random() * options.length)];
        System.out.println("Adversário escolheu: " + oppositeMove);

        if (playerMove.equals(oppositeMove)) {
            System.out.println("Empate!");
        } else if ((playerMove.equals("pedra") && oppositeMove.equals("tesoura")) ||
                (playerMove.equals("papel") && oppositeMove.equals("pedra")) ||
                (playerMove.equals("tesoura") && oppositeMove.equals("papel"))) {
            System.out.println("Você ganhou!");
            currentPlayer.upScore(1);
        } else {
            System.out.println("Você perdeu!");
        }
        currentPlayer.addAttempt();
    }

    /**
     * Verifica e seta o melhor jogador até o momento
     */
    private void setBestPlayer() {
        List<Player> currentRanking = this.ranking.getRanking();
        if (this.bestPlayer == null || this.currentPlayer.getScore() > currentRanking.stream()
                .mapToInt(Player::getScore)
                .max()
                .orElse(0)) {
            this.bestPlayer = this.currentPlayer;
        }
    }

    /**
     * Realiza a leitura do jogador atual
     *
     * @return o jogador atual
     */
    private Player readPlayer() {
        scanner = new Scanner(System.in);
        String playerName = readAndValidatePlayerName(ranking.getRanking());
        if (playerName.equalsIgnoreCase("sair")) return null;

        int playerAge = readAndValidatePlayerAge();

        return new Player(playerName, playerAge);
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
     *
     * @return idade do jogador
     */
    private static int readAndValidatePlayerAge() {
        System.out.println("Digite a idade do jogador: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Tente novamente");
            scanner.next();
        }
        int playerAge = scanner.nextInt();
        scanner.nextLine();

        return playerAge;
    }

    /**
     * Adiciona novo Jogador
     */
    private void newPlayer() {
        Player player = readPlayer();
        if (player == null) return;
        System.out.println("Jogador criado: " + player.getName());
        setCurrentPlayer(player);
    }
}
