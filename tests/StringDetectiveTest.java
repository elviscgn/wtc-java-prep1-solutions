import ex01_syntax.StringDetective;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Exercise 1.3 — StringDetective")
class StringDetectiveTest {

    // ── isPalindrome ──────────────────────────────────────────────────────────

    @Test @DisplayName("isPalindrome: 'racecar' is a palindrome")
    void palindromeTrue() {
        assertTrue(StringDetective.isPalindrome("racecar"));
    }

    @Test @DisplayName("isPalindrome: 'Racecar' is a palindrome (case-insensitive)")
    void palindromeCaseInsensitive() {
        assertTrue(StringDetective.isPalindrome("Racecar"));
    }

    @Test @DisplayName("isPalindrome: 'hello' is not a palindrome")
    void palindromeFalse() {
        assertFalse(StringDetective.isPalindrome("hello"));
    }

    @Test @DisplayName("isPalindrome: single character is always a palindrome")
    void palindromeSingleChar() {
        assertTrue(StringDetective.isPalindrome("a"));
    }

    @Test @DisplayName("isPalindrome: 'Madam' is a palindrome")
    void palindromeMadam() {
        assertTrue(StringDetective.isPalindrome("Madam"));
    }

    // ── countVowels ───────────────────────────────────────────────────────────

    @Test @DisplayName("countVowels: 'WeThinkCode' has 4 vowels")
    void vowelsWeThinkCode() {
        assertEquals(4, StringDetective.countVowels("WeThinkCode"));
    }

    @Test @DisplayName("countVowels: 'aeiou' has 5 vowels")
    void vowelsAllLower() {
        assertEquals(5, StringDetective.countVowels("aeiou"));
    }

    @Test @DisplayName("countVowels: 'AEIOU' has 5 vowels (case-insensitive)")
    void vowelsAllUpper() {
        assertEquals(5, StringDetective.countVowels("AEIOU"));
    }

    @Test @DisplayName("countVowels: 'rhythm' has 0 vowels")
    void vowelsNone() {
        assertEquals(0, StringDetective.countVowels("rhythm"));
    }

    // ── reverseWords ──────────────────────────────────────────────────────────

    @Test @DisplayName("reverseWords: reverses word order not letter order")
    void reverseWordsBasic() {
        assertEquals("java world hello", StringDetective.reverseWords("hello world java"));
    }

    @Test @DisplayName("reverseWords: single word returns same word")
    void reverseWordsSingle() {
        assertEquals("java", StringDetective.reverseWords("java"));
    }

    @Test @DisplayName("reverseWords: two words swap")
    void reverseWordsTwo() {
        assertEquals("Code WeThink", StringDetective.reverseWords("WeThink Code"));
    }

    // ── capitaliseEachWord ────────────────────────────────────────────────────

    @Test @DisplayName("capitaliseEachWord: capitalises first letter, lowercases rest")
    void capitaliseBasic() {
        assertEquals("We Think Code", StringDetective.capitaliseEachWord("we think code"));
    }

    @Test @DisplayName("capitaliseEachWord: 'HELLO' becomes 'Hello' (not 'HELLO')")
    void capitaliseFromAllCaps() {
        assertEquals("Hello", StringDetective.capitaliseEachWord("HELLO"));
    }

    @Test @DisplayName("capitaliseEachWord: single word")
    void capitaliseSingle() {
        assertEquals("Java", StringDetective.capitaliseEachWord("java"));
    }

    @Test @DisplayName("capitaliseEachWord: already correct stays correct")
    void capitaliseAlreadyCorrect() {
        assertEquals("Hello World", StringDetective.capitaliseEachWord("Hello World"));
    }
}
