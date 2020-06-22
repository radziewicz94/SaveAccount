package model;

import java.util.Objects;

public abstract class Account {
        private String firstName;
        private String lastName;
        private String pesel;
        private String accountNumber;
        private double saveMoney;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(String firstName, String lastName, String pesel, String accountNumber, double saveMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.accountNumber = accountNumber;
        this.saveMoney = saveMoney;
    }

    public double getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(double saveMoney) {
        this.saveMoney = saveMoney;
    }
    public abstract void addSaveMoney(double money);


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public abstract String toCsv();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(firstName, account.firstName) &&
                Objects.equals(lastName, account.lastName) &&
                Objects.equals(pesel, account.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, pesel);
    }
}
