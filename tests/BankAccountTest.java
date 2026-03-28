import ex02_encapsulation.BankAccount;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Exercise 2.1 — BankAccount")
class BankAccountTest {

    private BankAccount alice;
    private BankAccount bob;

    @BeforeEach
    void setUp() {
        alice = new BankAccount("Alice", 500.00);
        bob   = new BankAccount("Bob",   0.00);
    }

    // ── Construction ──────────────────────────────────────────────────────────

    @Test @DisplayName("Initial balance set from constructor")
    void initialBalance() {
        assertEquals(500.00, alice.getBalance(), 0.001);
        assertEquals(0.00,   bob.getBalance(),   0.001);
    }

    @Test @DisplayName("getAccountHolder() returns constructor name")
    void accountHolder() {
        assertEquals("Alice", alice.getAccountHolder());
        assertEquals("Bob",   bob.getAccountHolder());
    }

    @Test @DisplayName("accountNumber is auto-generated, not null or blank")
    void accountNumberGenerated() {
       
        // System.err.println("hey"+alice.getAccountHolder());
        assertNotNull(alice.getAccountNumber());
        assertFalse(alice.getAccountNumber().isBlank());
    }

    @Test @DisplayName("Two accounts get different account numbers")
    void accountNumbersUnique() {
        assertNotEquals(alice.getAccountNumber(), bob.getAccountNumber());
    }

    // ── Deposit ───────────────────────────────────────────────────────────────

    @Test @DisplayName("deposit() increases balance correctly")
    void depositIncreasesBalance() {
        alice.deposit(200.00);
        assertEquals(700.00, alice.getBalance(), 0.001);
    }

    @Test @DisplayName("Multiple deposits accumulate")
    void multipleDeposits() {
        alice.deposit(100.00);
        alice.deposit(50.00);
        assertEquals(650.00, alice.getBalance(), 0.001);
    }

    @Test @DisplayName("deposit() ignores zero and negative amounts")
    void depositIgnoresInvalid() {
        alice.deposit(0);
        alice.deposit(-50);
        assertEquals(500.00, alice.getBalance(), 0.001);
    }

    // ── Withdraw ──────────────────────────────────────────────────────────────

    @Test @DisplayName("withdraw() reduces balance when funds available")
    void withdrawSuccess() {
        alice.withdraw(200.00);
        assertEquals(300.00, alice.getBalance(), 0.001);
    }

    @Test @DisplayName("withdraw() exact balance leaves zero")
    void withdrawExact() {
        alice.withdraw(500.00);
        assertEquals(0.00, alice.getBalance(), 0.001);
    }

    @Test @DisplayName("withdraw() does NOT change balance when insufficient funds")
    void withdrawInsufficient() {
        alice.withdraw(600.00);
        assertEquals(500.00, alice.getBalance(), 0.001);
    }

    @Test @DisplayName("Balance never goes below zero")
    void balanceNeverNegative() {
        bob.withdraw(100.00);
        assertTrue(bob.getBalance() >= 0.0);
    }

    // ── Encapsulation ─────────────────────────────────────────────────────────

    @Test @DisplayName("No public setBalance() — encapsulation enforced")
    void noPublicSetBalance() {
        boolean found = false;
        for (var m : BankAccount.class.getMethods()) {
            if (m.getName().equals("setBalance")) { found = true; break; }
        }
        assertFalse(found, "BankAccount must NOT have a public setBalance()");
    }

    @Test @DisplayName("No public setAccountNumber()")
    void noPublicSetAccountNumber() {
        boolean found = false;
        for (var m : BankAccount.class.getMethods()) {
            if (m.getName().equals("setAccountNumber")) { found = true; break; }
        }
        assertFalse(found, "BankAccount must NOT have a public setAccountNumber()");
    }
}
