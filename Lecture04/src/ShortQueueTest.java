import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShortQueueTest {
    ShortQueue shortQueue = new ShortQueue();

    @Test
    void TakeTest() {
        shortQueue.put("stringTest");
        assertNull(shortQueue.take());
    }
    @Test
    void isFullTest() {
        try {
            assertNotNull(shortQueue.take());
        } catch (Exception e) {
            assertFalse(shortQueue.isFull());
        }
    }

    @Test
    void isFullTestWhenQueueIsEmpty() {
        assertFalse(shortQueue.isFull());
    }

    @Test
    void isFullTestWhenQueueHasOneElement() {
        shortQueue.put("Test");
        assertFalse(shortQueue.isFull());
    }

    @Test
    void isFullTestWhenQueueIsFull() {
        // Need to determine the capacity of ShortQueue to write this test
    }
}

