package App.dataReader;

import App.dataReader.printer.Println;
import exception.AccountNumberExsistException;
import model.Account;

import model.Plan;

import java.util.*;

public class ReadAndCreateAccounts {

    //private static final int MAX_ACCOUNT = 2;
    private DataReader dataReader = new DataReader();
    private List<Account> accounts = new LinkedList<>();
    private List<Plan> lista = new LinkedList<>();
    private int count = 0;
    Scanner sc = new Scanner(System.in);
    Println println;

    public void addAccount(Account account){
        if(accounts.contains(account)){
            throw new AccountNumberExsistException("Konto o takim numerze już istnieje " + account.getAccountNumber());
        }
        accounts.add(account);
    }

    public void printAllAccount() {
        Println.print("Ilość kont " + accounts.size());
        for (Account account : accounts) {
            println.print(account.toString());
        }
    }

    public void addMoney(double money, Account account){
        System.out.println("Podaj nr konta");
        sc.nextLine();
      //  if(accounts.contains(accounts.))

    }
    public void addPlan(Plan plan){
        lista.add(plan);
       // return lista;
    }
    public void printPlan(){
        lista.size();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());

        }
    }
}
