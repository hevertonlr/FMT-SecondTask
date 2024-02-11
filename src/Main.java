public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Heverton", 36,0,0);
        player1.upScore(10);
        player1.addAttempt();

        System.out.println(player1);
    }
}