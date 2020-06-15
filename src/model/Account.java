package model;

import java.util.Objects;

public abstract class Account {
        private String firstName;
        private String lastName;
        private String pesel;

    public Account(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
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
