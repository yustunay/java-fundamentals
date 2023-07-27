import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterOccurrenceTest {

    @Test
    void getNonRepeatedCharacters() {
        List<String> returnedCharacters = CharacterOccurrence.getCharacters("YahyaUstunay", false);
        Assertions.assertTrue(returnedCharacters.containsAll(Arrays.asList("h","s","t","n")));
    }

    @Test
    void getRepeatedCharacters() {
        List<String> returnedCharacters = CharacterOccurrence.getCharacters("YahyaUstunay", true);
        Assertions.assertTrue(returnedCharacters.containsAll(Arrays.asList("y","a","u")));
    }

}