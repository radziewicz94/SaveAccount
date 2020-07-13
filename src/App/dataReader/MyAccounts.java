package App.dataReader;

import App.dataReader.printer.ConsolePrinter;
import exception.AccountNumberExsistException;
import model.Account;

import model.MoneyManager;
import model.Plan;

import java.util.*;

public class MyAccounts implements MoneyManager {

    private Map<String, Account> accounts = new HashMap<>();
    private List<Plan> lista = new LinkedList<>();

    public void addAccount( Account account) {
        if (accounts.containsKey(account.getAccountNumber())) {
            throw new AccountNumberExsistException("Konto o numerze" + account.getAccountNumber() + " już istnieje ");
        }
        accounts.put(account.getAccountNumber(), account);
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public List<Plan> getLista() {
        return lista;
    }

    public Map<String, Account> accountMap(String accNumber){
        Collection<Account> account = accountMap(accNumber).values();
        System.out.println(account);

        return null;
    }

    public void addPlan(Plan plan) {
        lista.add(plan);
        // return lista;
    }

    public void printPlan() {
        lista.size();
        for (int i = 0; i < lista.size(); i++) {
            ConsolePrinter.print(lista.get(i).toString());

        }
    }

    @Override
    public void addMoney(double money, String accNumber) {
        String result = "Konto o takim numerze nie istnieje";
        Collection<Account> collection = accounts.values();
        Iterator<Account> account = collection.iterator();
        while (account.hasNext()){
            Account account1 = account.next();
            if(account1.getAccountNumber().equals(accNumber)) {
                System.out.println(account1);
                account1.setSaveMoney(money);
            }

        }
        ConsolePrinter.print(result);
    }
}
