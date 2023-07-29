import java.util.Random;
import java.util.stream.Stream;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        while (1 == 1){
            MATERIALS player1 = MATERIALS.findById(generateRandom());
            System.out.println("1.Player : " + player1.name());
            MATERIALS player2 = MATERIALS.findById(generateRandom());
            System.out.println("2.Player : " + player2.name());

            if (player1 == player2){
                System.out.println("No one won! Trying again!\n");
            } else {
                if (player1.getWinnerId() == player2.getId()){
                    System.out.println("Victory Player2!");
                } else if (player2.getWinnerId() == player1.getId()){
                    System.out.println("Victory Player1!");
                }
                return;
            }
        }
    }

    private static int generateRandom() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    enum MATERIALS {
        ROCK(1, 2),
        PAPER(2, 3),
        SCISSORS(3, 1);

        private int id;
        private int winnerId;

        MATERIALS(int id, int winnerId) {
            this.id = id;
            this.winnerId = winnerId;
        }

        public int getId() {
            return id;
        }

        public int getWinnerId() {
            return winnerId;
        }

        public static MATERIALS findById(int id) {
            return Stream.of(MATERIALS.values()).filter(m -> m.getId() == id).findFirst().orElse(null);
        }

    }

}
