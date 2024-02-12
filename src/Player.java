/**
 * Classe Jogador
 */
public class Player {
    private String name;
    private int age;
    private int score;
    private int attempts;

    /**
     * Construtor da classe Jogador
     *
     * @param name nome do jogador
     * @param age  idade do jogador
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.score = 0;
        this.attempts = 0;
    }

    /**
     * Adiciona pontos
     *
     * @param add valor de pontos adicionados
     */
    public void upScore(int add) {
        this.score += add;
    }

    /**
     * Remove pontos
     *
     * @param remove valor de pontos removidos
     */
    public void downScore(int remove) {
        this.score -= remove;
    }

    /**
     * Adiciona Tentativa (+1)
     */
    public void addAttempt() {
        this.attempts++;
    }


    /**
     * Exibe o nome e pontuação do jogador
     *
     * @return texto para exibição de nome e pontuação
     * @deprecated será removida na proxima versão caso não seja mais necessária
     */
    @Deprecated
    public String toRanking() {
        return name + " - Pontuação: " + score;
    }

    /**
     * Exibe as informações do Jogador
     *
     * @return texto com informações do Jogador
     */
    @Override
    public String toString() {
        return name + " - " + age + " anos (" + score + " pontos - " + attempts + " tentativas)";
    }

    //region Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    //endregion
}
