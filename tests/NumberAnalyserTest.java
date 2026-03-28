import ex01_syntax.NumberAnalyser;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Exercise 1.2 — NumberAnalyser")
class NumberAnalyserTest {

    private static final int[] MIXED   = {3, -1, 7, 0, -5, 12, 4, -8, 9, 2};
    private static final int[] SINGLE  = {42};
    private static final int[] ALL_NEG = {-3, -7, -1, -9, -2};

    // ── findMax ───────────────────────────────────────────────────────────────

    @Test @DisplayName("findMax: largest value in mixed array")
    void findMaxMixed() {
        assertEquals(12, NumberAnalyser.findMax(MIXED));
    }

    @Test @DisplayName("findMax: single element array")
    void findMaxSingle() {
        assertEquals(42, NumberAnalyser.findMax(SINGLE));
    }

    @Test @DisplayName("findMax: all negative array")
    void findMaxAllNegative() {
        assertEquals(-1, NumberAnalyser.findMax(ALL_NEG));
    }

    // ── findMin ───────────────────────────────────────────────────────────────

    @Test @DisplayName("findMin: smallest value in mixed array")
    void findMinMixed() {
        assertEquals(-8, NumberAnalyser.findMin(MIXED));
    }

    @Test @DisplayName("findMin: single element array")
    void findMinSingle() {
        assertEquals(42, NumberAnalyser.findMin(SINGLE));
    }

    @Test @DisplayName("findMin: all negative array")
    void findMinAllNegative() {
        assertEquals(-9, NumberAnalyser.findMin(ALL_NEG));
    }

    // ── calculateAverage ──────────────────────────────────────────────────────

    @Test @DisplayName("calculateAverage: correct double for mixed array")
    void averageMixed() {
        // 3-1+7+0-5+12+4-8+9+2 = 23, /10 = 2.3
        assertEquals(2.3, NumberAnalyser.calculateAverage(MIXED), 0.001);
    }

    @Test @DisplayName("calculateAverage: single element")
    void averageSingle() {
        assertEquals(42.0, NumberAnalyser.calculateAverage(SINGLE), 0.001);
    }

    @Test @DisplayName("calculateAverage: returns double not truncated int — (1+2)/2 = 1.5 not 1")
    void averageNotTruncated() {
        assertEquals(1.5, NumberAnalyser.calculateAverage(new int[]{1, 2}), 0.001);
    }

    // ── countEvens ────────────────────────────────────────────────────────────

    @Test @DisplayName("countEvens: counts correctly in mixed array")
    void countEvensMixed() {
        // evens in MIXED: 0, 12, 4, -8, 2 = 5
        assertEquals(5, NumberAnalyser.countEvens(MIXED));
    }

    @Test @DisplayName("countEvens: returns 0 when no evens")
    void countEvensNone() {
        assertEquals(0, NumberAnalyser.countEvens(new int[]{1, 3, 5, 7}));
    }

    @Test @DisplayName("countEvens: 0 is even")
    void countEvensZeroIsEven() {
        assertEquals(1, NumberAnalyser.countEvens(new int[]{0}));
    }

    @Test @DisplayName("countEvens: negative even numbers count")
    void countEvensNegative() {
        assertEquals(2, NumberAnalyser.countEvens(new int[]{-2, -4}));
    }

    // ── reverseArray ──────────────────────────────────────────────────────────

    @Test @DisplayName("reverseArray: elements in reverse order")
    void reverseBasic() {
        assertArrayEquals(new int[]{5, 4, 3, 2, 1},
                          NumberAnalyser.reverseArray(new int[]{1, 2, 3, 4, 5}));
    }

    @Test @DisplayName("reverseArray: does NOT modify the original array")
    void reverseDoesNotMutate() {
        int[] original = {1, 2, 3};
        int[] copy = original.clone();
        NumberAnalyser.reverseArray(original);
        assertArrayEquals(copy, original, "reverseArray must return a new array, not modify the original");
    }

    @Test @DisplayName("reverseArray: single element")
    void reverseSingle() {
        assertArrayEquals(new int[]{7}, NumberAnalyser.reverseArray(new int[]{7}));
    }
}
