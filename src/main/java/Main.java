import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static List<List<Card>> cards;
    public static final Random rand = new Random();

    public static boolean advanced = true, rebellion = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("All sets will be included by default. Enter a set to exclude or continue to generation.");
        System.out.println("(1) Exclude advanced base set\n(2) Exclude rebellion \n(3) generate");
        String in = input.next();
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(in.trim());
                if (choice == 1) {
                    advanced = !advanced;
                } else if (choice == 2) {
                    rebellion = !rebellion;
                } else if (choice == 3) {
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid choice.");
            }
            System.out.println(STR."(1) \{advanced ? "Exclude" : "Include"} advanced base set\n(2) \{rebellion ? "Exclude" : "Include"} rebellion \n(3) generate");
            in = input.next();
        }
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
                if ((card.set == 1 && !advanced) || (card.set == 2 && !rebellion)) {
                    continue; //excluded sets
                }
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
