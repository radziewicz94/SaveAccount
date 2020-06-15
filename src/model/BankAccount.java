package model;

public class BankAccount extends Account {
        private String bankAccount;
        private double saveMoney;

    public BankAccount(String firstName, String lastName, String pesel, String bankAccount, double saveMoney) {
        super(firstName, lastName, pesel);
        this.bankAccount = bankAccount;
        this.saveMoney = saveMoney;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(double saveMoney) {
        this.saveMoney = saveMoney;
    }

    @Override
    public String toString(){
        return "Konto bankowe " + bankAccount + ", zaoszczędzone pieniądze : " + saveMoney;
    }
}
