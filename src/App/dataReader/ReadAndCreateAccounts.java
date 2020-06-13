package App.dataReader;

import model.Account;
import model.BankAccount;
import model.InvestmentAccount;

public class ReadAndCreateAccounts {

    private static final int MAX_ACCOUNT = 2;
    DataReader dataReader = new DataReader();
    Account[] accounts = new Account[MAX_ACCOUNT];
    public static int count = 0;

    public void addBankAccount(BankAccount bankAccount) {
        if (count >= MAX_ACCOUNT) {
            System.out.println("jest już maksymalna liczba kont");
        }
        accounts[count] = bankAccount;
        count++;
    }

    public void addInvestmentAccount(InvestmentAccount investmentAccount) {
        if (count >= MAX_ACCOUNT) {
            System.out.println("jest już maksymalna liczba kont");
        }
        accounts[count] = investmentAccount;
        count++;
    }

    public void printAllAccount() {
        for (int i = 0; i < count; i++) {
            System.out.println(accounts[i].toString());
        }
        if (count == 0) {
            System.out.println("Nie posiadasz żadnych kont");
        }
    }

    public void printBankAccount() {
        int bankCount = 0;
        for (int i = 0; i < count; i++) {
            if (accounts[i] instanceof BankAccount) {
                System.out.println(accounts[i].toString());
                bankCount++;
            }
        }if(bankCount == 0){
            System.out.println("Aktualnie nie masz żadnych kont bankowych");
        }
    }
    public void printInvestmentAccount() {
        int invCount = 0;
        for (int i = 0; i < ReadAndCreateAccounts.count; i++) {
            if(accounts[i] instanceof InvestmentAccount){
                System.out.println(accounts[i].toString());
                invCount++;
            }
        }if(invCount == 0){
            System.out.println("Aktualnie nie masz żadnych kont inwestycyjnych");
        }
    }
}
