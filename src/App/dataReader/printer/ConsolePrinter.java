package App.dataReader.printer;

import model.Account;
import model.BankAccount;
import model.InvestmentAccount;

import java.util.Collection;

public class ConsolePrinter {
    public void print(String text){
        System.out.println(text);
    }

    public void printBankAccount(Collection<Account> bankAccounts){
            for(Account account : bankAccounts){
                if(account instanceof BankAccount){
                    print(account.toString());
                }
            }
    }

    public void printInvestmentAccount(Collection<Account> investmentAccounts){
        for(Account acc : investmentAccounts){
            if(acc instanceof InvestmentAccount){
                print(acc.toString());
            }
        }
    }
    public void printAllAccounts(Collection<Account> accounts){
        for(Account acc : accounts){
            print(acc.toString());
        }
    }
}
