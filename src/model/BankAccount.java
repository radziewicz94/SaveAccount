package model;

import java.util.Objects;

public class BankAccount extends Account {
        private String bankAccount;
        public final static String TYPE = "Konto bankowe";

    @Override
    public void addSaveMoney(double money) {
        setSaveMoney(getSaveMoney() + money);
    }


    public BankAccount(String firstName, String lastName, String pesel, String accountNumber, double saveMoney, String bankAccount) {
        super(firstName, lastName, pesel, accountNumber, saveMoney);
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }


    @Override
    public String toCsv() {
        return TYPE + ";" + getFirstName() + ";" + getLastName() + ";" + getPesel() + ";" +
                bankAccount + ";" + getSaveMoney() + ";" + getBankAccount() + ";";
    }
    @Override
    public String toString(){
        return "Konto bankowe " + bankAccount + ", zaoszczędzone pieniądze : " + getSaveMoney();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        if (!super.equals(o)) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(bankAccount, that.bankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bankAccount);
    }
}
