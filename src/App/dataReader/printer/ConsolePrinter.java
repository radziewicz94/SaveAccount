package App.dataReader.printer;

import model.Account;
import model.BankAccount;
import model.InvestmentAccount;

import java.util.Collection;

public class ConsolePrinter {
    public static void print(String text){
        System.out.println(text);
    }

    public static void printBankAccount(Collection<Account> bankAccounts){
            for(Account account : bankAccounts){
                if(account instanceof BankAccount){
                    print(account.toString());
                }
            }
    }

    public static void printInvestmentAccount(Collection<Account> investmentAccounts){
        for(Account acc : investmentAccounts){
            if(acc instanceof InvestmentAccount){
                print(acc.toString());
            }
        }
    }
    public static void printAllAccounts(Collection<Account> accounts){
        for(Account acc : accounts){
            print(acc.toString());
        }
    }
}
