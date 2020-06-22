package App;

import App.dataReader.DataReader;
import App.dataReader.MyAccounts;
import App.dataReader.printer.ConsolePrinter;
import model.Account;
import model.BankAccount;
import model.InvestmentAccount;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationControl {
    Scanner sc = new Scanner(System.in);
    ConsolePrinter consolePrinter = new ConsolePrinter();
    DataReader dataReader = new DataReader(consolePrinter);
    MyAccounts myAccounts = new MyAccounts();
    private  Account account;


    protected void loopControl() {
        int option = -1;
        do {

            switch (getOption()) {
                case EXIT:
                    System.out.println("Wychodzę z programu");
                    option = 0;
                    break;
                case ADD_BANK_ACCOUNT:
                    addAccount();
                    break;
                case ADD_INVESTMENT_ACCOUNT:
                    addInvestment();
                    break;
                case PRINT_ALL_ACCOUNT:
                    printAllAccounts();
                    break;
                case PRINT_BANK_ACCOUNTS:
                    printBankAccounts();
                    break;
                case PRINT_INVESTMENT_ACCOUNTS:
                    printInvestmentAccount();
                    break;
                case ADD_MONEY_TO_BANK_ACCOUNT:
                    addSaveMoneyToBankAccount();
                    break;
                case GOAL:
                    addPlan();
                    break;
                case RATE:
                    printPlan();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + getOption());
            }
        } while (option != 0);

    }

    private void addSaveMoneyToBankAccount() {
        consolePrinter.print("Ile pieniędzy chce dodać");
        double money = dataReader.getDouble();
        consolePrinter.print("Podaj dane konta na które chcesz przelać oszczędności");
        String accNumber = sc.nextLine();
        myAccounts.addMoney(accNumber, money);

    }


    private void addAccount(){
        BankAccount bankAccount = dataReader.addBankAccount();
        String accNumber = bankAccount.getAccountNumber();
        myAccounts.addAccount(bankAccount);

    }

    private void addInvestment(){
        InvestmentAccount investmentAccount = dataReader.addInvestmentAccount();
        String accNumber = investmentAccount.getAccountNumber();
        myAccounts.addAccount(investmentAccount);

    }
    private void printAllAccounts() {
        consolePrinter.printAllAccounts(myAccounts.getAccounts().values());
    }
    private void printBankAccounts(){
        consolePrinter.printBankAccount(myAccounts.getAccounts().values());
    }
    private void printInvestmentAccount(){
        consolePrinter.printInvestmentAccount(myAccounts.getAccounts().values());
    }

    private void printOption() {
        System.out.println("Dostępne opcje");
        for (Option option : Option.values()) {
            System.out.println(option);
        }
    }
    private void addPlan(){
        myAccounts.addPlan(dataReader.savingsPlan());

    }
    private void printPlan(){
        myAccounts.printPlan();
    }

    private Option getOption() {
        boolean isOk = false;
        Option option = null;
        while (!isOk) {
            printOption();
            System.out.println("Podaj opcję");
            try {
                option = Option.getEnumFromInt(dataReader.getInt());
                isOk = true;
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return option;
    }

    private enum Option {
        EXIT(0, "Wyjście z programu"),
        ADD_BANK_ACCOUNT(1, "Dodaj konto bankowe"),
        ADD_INVESTMENT_ACCOUNT(2, "Dodaj konto inwestycyjne"),
        PRINT_ALL_ACCOUNT(3, "Wyświetl wszystkie konta"),
        PRINT_BANK_ACCOUNTS(4, "Wyświetl konta bankowe"),
        PRINT_INVESTMENT_ACCOUNTS(5, "Wyświetl konta inwestycyjne"),
        ADD_MONEY_TO_BANK_ACCOUNT(6, "Dodaj pieniądze do istniejącego konta bankowego"),
        GOAL(7, "Dodaj cel do uzbierania"),
        RATE(6, "Wyświetl cele");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option getEnumFromInt(int option) throws ArrayIndexOutOfBoundsException, InputMismatchException {
            Option[] options = Option.values();
            try {
                return options[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException("Brak opcji o id " + option);
            }
        }
    }

}
