import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static List<List<Card>> cards;
    public static final Random rand = new Random();

    public static void main(String[] args) {
        loadCards();
        Card next;
        for (int i = 1; i <= 15; i++) {
            next = selectCard(i);
            System.out.println(STR."position \{i}: \{next.name}, set: \{getSetName(next.set)}");
        }
    }

    public static Card selectCard(int position) {
        return cards.get(position - 1).get(rand.nextInt(cards.get(position - 1).size()));
    }

    public static String getSetName(int set) {
        return switch (set) {
            case 2 -> "Rebellion";
            case 1 -> "Base (Advanced)";
            default -> "Base";
        };
    }

    public static void loadCards() {
        cards = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            cards.add(new ArrayList<>());
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Card> values = mapper.readValue(new File("src\\main\\resources\\cards.json"), new TypeReference<List<Card>>() {});
            for (Card card : values) {
                cards.get(card.position - 1).add(card);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Card {
        public String name;
        public int position, points, set;
    }
}
