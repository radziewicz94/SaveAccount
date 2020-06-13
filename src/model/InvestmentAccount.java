package model;

public class InvestmentAccount extends Account{
        private String accountName;
        private double saveMoney;
        private double interestedRate;

    public InvestmentAccount(String firstName, String lastName, String pesel, String accountName, double saveMoney, double interestedRate) {
        super(firstName, lastName, pesel);
        this.accountName = accountName;
        this.saveMoney = saveMoney;
        this.interestedRate = interestedRate;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(double saveMoney) {
        this.saveMoney = saveMoney;
    }

    public double getInterestedRate() {
        return interestedRate;
    }

    public void setInterestedRate(double interestedRate) {
        this.interestedRate = interestedRate;
    }
    @Override
    public String toString(){
        return "Konto " + accountName + ", z oprocentowaniem " + interestedRate + ", odłożone pieniądze: " + saveMoney;
    }
}
