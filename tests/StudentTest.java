import ex02_encapsulation.Student;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Exercise 2.2 — Student")
class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Thabo", 22, 3.5);
    }

    // ── Construction ──────────────────────────────────────────────────────────

    @Test @DisplayName("Valid student stores all values correctly")
    void validConstruction() {
        assertEquals("Thabo", student.getName());
        assertEquals(22,      student.getAge());
        assertEquals(3.5,     student.getGpa(), 0.001);
    }

    @Test @DisplayName("studentId is auto-generated, not null or blank")
    void studentIdGenerated() {
        assertNotNull(student.getStudentId());
        assertFalse(student.getStudentId().isBlank());
    }

    @Test @DisplayName("Two students get different IDs")
    void studentIdsUnique() {
        Student other = new Student("Amara", 20, 2.8);
        assertNotEquals(student.getStudentId(), other.getStudentId());
    }

    // ── Name validation ───────────────────────────────────────────────────────

    @Test @DisplayName("setName() rejects null")
    void setNameNull() {
        assertThrows(IllegalArgumentException.class, () -> student.setName(null));
    }

    @Test @DisplayName("setName() rejects empty string")
    void setNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> student.setName(""));
    }

    @Test @DisplayName("setName() accepts valid name")
    void setNameValid() {
        student.setName("Lerato");
        assertEquals("Lerato", student.getName());
    }

    // ── Age validation ────────────────────────────────────────────────────────

    @Test @DisplayName("setAge() rejects age below 16")
    void setAgeTooLow() {
        assertThrows(IllegalArgumentException.class, () -> student.setAge(15));
    }

    @Test @DisplayName("setAge() rejects age above 60")
    void setAgeTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> student.setAge(61));
    }

    @Test @DisplayName("setAge() accepts boundary values 16 and 60")
    void setAgeBoundaries() {
        assertDoesNotThrow(() -> student.setAge(16));
        assertDoesNotThrow(() -> student.setAge(60));
    }

    // ── GPA validation ────────────────────────────────────────────────────────

    @Test @DisplayName("setGpa() rejects GPA below 0.0")
    void setGpaTooLow() {
        assertThrows(IllegalArgumentException.class, () -> student.setGpa(-0.1));
    }

    @Test @DisplayName("setGpa() rejects GPA above 4.0")
    void setGpaTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> student.setGpa(4.1));
    }

    @Test @DisplayName("setGpa() accepts boundary values 0.0 and 4.0")
    void setGpaBoundaries() {
        assertDoesNotThrow(() -> student.setGpa(0.0));
        assertDoesNotThrow(() -> student.setGpa(4.0));
    }

    // ── toString ──────────────────────────────────────────────────────────────

    @Test @DisplayName("toString() is non-blank and includes the student's name")
    void toStringContainsName() {
        String s = student.toString();
        assertNotNull(s);
        assertFalse(s.isBlank());
        assertTrue(s.contains("Thabo"), "toString() should include the student name");
    }

    // ── Constructor validation ────────────────────────────────────────────────

    @Test @DisplayName("Constructor rejects invalid age")
    void constructorInvalidAge() {
        assertThrows(IllegalArgumentException.class, () -> new Student("X", 10, 3.0));
    }

    @Test @DisplayName("Constructor rejects invalid GPA")
    void constructorInvalidGpa() {
        assertThrows(IllegalArgumentException.class, () -> new Student("X", 20, 5.0));
    }
}
