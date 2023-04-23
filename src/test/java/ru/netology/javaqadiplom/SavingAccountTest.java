package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddLessThanZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-50);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(10_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayLessThanZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-100);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayMoreThanBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayCorrect() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldCheckRate() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(1_000, 1_000, 1_000, -1));
    }

    @Test
    public void shouldCheckMinBalanse() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(1_000, -1_000, 1_000, 5));
    }

    @Test
    public void shouldCheckMinAndMax() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(1000, 5000, 1000, 5));
    }
}
