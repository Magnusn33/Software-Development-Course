import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShortQueueTest {
    ShortQueue shortQueue = new ShortQueue();

    @Test
    void TakeTest() {
        shortQueue.put("stringTest");
        assertNull(shortQueue.take());
    }

    void isFullTest() {
        try {
            assertNotNull(shortQueue.take());
        } catch (Exception e) {
            assertEquals(false, shortQueue.isFull());
        }
    }

}

