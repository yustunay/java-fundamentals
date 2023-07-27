import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringReverserTest {

    @Test
    void reverseStringV4() {
        String returnedString = StringReverser.reverseStringV4("Yahya");
        assertEquals("ayhaY", returnedString);
    }
}