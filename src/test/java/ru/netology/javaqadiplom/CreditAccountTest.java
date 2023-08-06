package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldNotAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        account.add(-2_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void negativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1, 5_000, 15);
        });
    }

    @Test
    public void negativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0, -1, 15);
        });
    }

    @Test
    public void negativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0, 5_000, -1);
        });
    }

    @Test
    public void positiveBalanceAfterAmount() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );
        account.pay(1_999);

        Assertions.assertEquals(1, account.getBalance());
    }

    @Test
    public void negativeBalanceAfterAmount() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );
        account.pay(5_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldNotPayAboveTotal() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );
        account.pay(7_001);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldNotPayIfAmountIsNegative() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );
        account.pay(-2_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void yearChangeIfNegativeBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );
        account.pay(5_000);

        Assertions.assertEquals(-450, account.yearChange());
    }

    @Test
    public void yearChangeIfPositiveBalance() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );
        account.pay(1_000);

        Assertions.assertEquals(0, account.yearChange());
    }
}
