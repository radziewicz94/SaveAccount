package App.dataReader;

import App.dataReader.printer.Println;
import model.Account;
import model.BankAccount;
import model.InvestmentAccount;
import model.Plan;

import java.util.*;

public class ReadAndCreateAccounts {

    //private static final int MAX_ACCOUNT = 2;
    private DataReader dataReader = new DataReader();
    private HashMap<String, Account> accounts= new HashMap<>();
    private List<Plan> lista = new LinkedList<>();
    private int count = 0;

    public ReadAndCreateAccounts() {
    }

    public void addAccount(Account account, String accNumber){
        accounts.put(accNumber, account);
    }

    public void printAllAccount() {
        System.out.println("Wielkość kolekcji " + accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            (accounts.values());
        }
    }

   /*public void printBankAccount(String pesel) {
        int bankCount = 0;
       for (int i = 0; i < accounts.size(); i++) {
           if(accounts.containsKey(pesel)){
               System.out.println(account.toString());
               bankCount++;
           }
       }
        if(bankCount == 0){
            System.out.println("Aktualnie nie masz żadnych kont bankowych");
        }
    }*/
    public void printInvestmentAccount() {
        int invCount = 0;
        for (int i = 0; i < count; i++) {
            if(accounts instanceof HashMap){
                Println.print(accounts.toString());
                invCount++;
            }
        }if(invCount == 0){
            System.out.println("Aktualnie nie masz żadnych kont inwestycyjnych");
        }
    }
    public List<Plan> addPlan(Plan plan){
        lista.add(plan);
        return lista;
    }
    public void printPlan(){
        lista.size();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }
}
