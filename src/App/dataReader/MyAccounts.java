package App.dataReader;

import App.dataReader.printer.ConsolePrinter;
import exception.AccountNumberExsistException;
import model.Account;

import model.Plan;

import java.util.*;

public class MyAccounts {

    private Map<String, Account> accounts = new HashMap<>();
    private List<Plan> lista = new LinkedList<>();
    ConsolePrinter consolePrinter = new ConsolePrinter();

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

    public void addMoney(String accNumber, double money) {
        String result = "Konto o takim numerze nie istnieje";
                    for (Map.Entry<String, Account> entry : accounts.entrySet())
                if (accounts.containsKey(accNumber)) {
                    Account account = entry.getValue();
                    account.setSaveMoney(account.getSaveMoney() + money);

                    result = "Prawidłowo dodano środki na konto";
                }

        consolePrinter.print(result);
    }

    public void addPlan(Plan plan) {
        lista.add(plan);
        // return lista;
    }

    public void printPlan() {
        lista.size();
        for (int i = 0; i < lista.size(); i++) {
            consolePrinter.print(lista.get(i).toString());

        }
    }
}
