package model;

public class InvestmentAccount extends Account{
        private String accountName;
        private double interestedRate;
        public static final String TYPE = "Lokata";

    public InvestmentAccount(String firstName, String lastName, String pesel, String accountNumber,
                             double saveMoney, String accountName, double interestedRate) {
        super(firstName, lastName, pesel, accountNumber, saveMoney);
        this.accountName = accountName;
        this.interestedRate = interestedRate;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getInterestedRate() {
        return interestedRate;
    }

    public void setInterestedRate(double interestedRate) {
        this.interestedRate = interestedRate;
    }
    @Override
    public String toCsv() {
        return TYPE + ";" + getFirstName() + ";" + getLastName() + ";" + getPesel() + ";" + getAccountNumber() +
                ";" + getSaveMoney() + ";" + accountName + ";" + interestedRate;
    }
    @Override
    public String toString(){
        return "Konto inwestycyjne " + accountName + " numer konta " + getAccountNumber() + ", z oprocentowaniem " + interestedRate + ", odłożone pieniądze: " + getSaveMoney();
    }
}
