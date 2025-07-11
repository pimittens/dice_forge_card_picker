import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardsTest {

    @Test
    void randShouldIncludeAllCards() {
        Map<String, Integer> rands = new HashMap<>();

        final int rounds = 1000;
        Main.loadCards();
        for (int i = 1; i <= 15; i++) {
            for (int j = 0; j < rounds; j++) {
                String randomValue = Main.selectCard(i);
                rands.compute(randomValue, (_, v) -> v == null ? 1 : v + 1);
            }
        }

        assertTrue(rands.containsKey("The Elder"));
        assertTrue(rands.containsKey("Wild Spirits"));
        assertTrue(rands.containsKey("Celestial Ship"));
        assertTrue(rands.containsKey("The Guardian's Owl"));
        assertTrue(rands.containsKey("The Guardian's Shield"));
        assertTrue(rands.containsKey("Minotaur"));
        assertTrue(rands.containsKey("Triton"));
        assertTrue(rands.containsKey("Gorgon"));
        assertTrue(rands.containsKey("Mirror of the Abyss"));
        assertTrue(rands.containsKey("Cyclops"));
        assertTrue(rands.containsKey("Sphinx"));
        assertTrue(rands.containsKey("Typhon"));
        assertTrue(rands.containsKey("Hydra"));
        assertTrue(rands.containsKey("Sentinel"));
        assertTrue(rands.containsKey("Cancer"));
        assertTrue(rands.containsKey("Helmet of Invisibility"));
        assertTrue(rands.containsKey("Cerberus"));
        assertTrue(rands.containsKey("Ferryman"));
        assertTrue(rands.containsKey("Tenacious Boar"));
        assertTrue(rands.containsKey("Satyrs"));
        assertTrue(rands.containsKey("Great Bear"));
        assertTrue(rands.containsKey("The Silver Hind"));
        assertTrue(rands.containsKey("The Blacksmith's Chest"));
        assertTrue(rands.containsKey("The Blacksmith's Hammer"));
        assertTrue(rands.containsKey("The Tree"));
        assertTrue(rands.containsKey("The Merchant"));
        assertTrue(rands.containsKey("The Wood Nymph"));
        assertTrue(rands.containsKey("The Light"));
        assertTrue(rands.containsKey("The Omniscient"));
        assertTrue(rands.containsKey("The Goldsmith"));
        assertTrue(rands.containsKey("The Abyssal Trident"));
        assertTrue(rands.containsKey("The Left Hand"));
        assertTrue(rands.containsKey("The Eternal Fire"));
        assertTrue(rands.containsKey("The First Titan"));
        assertTrue(rands.containsKey("The Goddess"));
        assertTrue(rands.containsKey("The Right Hand"));
        assertTrue(rands.containsKey("The Eternal Night"));
        assertTrue(rands.containsKey("The Mists"));
        assertTrue(rands.containsKey("The Ancestor"));
        assertTrue(rands.containsKey("The Wind"));
        assertTrue(rands.containsKey("The Celestial Die"));
        assertTrue(rands.containsKey("The Companion"));
        assertTrue(rands.containsKey("The Blacksmith's Scepter"));
        assertTrue(rands.containsKey("The Twins"));
    }
}
