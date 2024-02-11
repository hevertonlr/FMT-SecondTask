public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();

        player1.name="Heverton";
        player1.age = 36;
        player1.score = 0;
        player1.attempts = 0;

        player1.upScore(10);
        player1.addAttempt();

        System.out.println(player1);
    }
}