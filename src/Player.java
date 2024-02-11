public class Player {
    public String name;
    public int age;
    public int score;
    public int attempts;

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
     * Exibe as informações do Jogador
     * @return
     */
    @Override
    public String toString(){
        return "Jogador { \n" +
                "   nome=" + name + ",\n" +
                "   idade=" + age + ",\n" +
                "   pontuacao=" + score + ",\n" +
                "   numeroTentativas=" + attempts + "\n" +
                '}';

    }
}
