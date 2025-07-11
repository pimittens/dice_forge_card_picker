import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static List<List<String>> cards;
    public static final Random rand = new Random();

    public static void main(String[] args) {
        loadCards();
        for (int i = 1; i <= 15; i++) {
            System.out.println(STR."position \{i}: \{selectCard(i)}");
        }
    }

    public static String selectCard(int position) {
        return cards.get(position - 1).get(rand.nextInt(cards.get(position - 1).size()));
    }

    public static void loadCards() {
        cards = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            cards.add(new ArrayList<>());
        }
    }
}
