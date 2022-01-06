import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {

    @DisplayName("test 1")
    @Test
    void test() {
        assertEquals(10 / 2, 5);
    }
}
