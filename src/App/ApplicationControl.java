package App;

import App.dataReader.DataReader;
import App.dataReader.ReadAndCreateAccounts;
import model.Account;
import model.BankAccount;
import model.InvestmentAccount;
import model.Plan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationControl {
    Scanner sc = new Scanner(System.in);
    DataReader dataReader = new DataReader();
    int count = 0;
    ReadAndCreateAccounts readAndCreateAccounts = new ReadAndCreateAccounts();
    private Account account;

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
               /* case PRINT_ALL_BANK_ACCOUNT:
                    printAccount();
                    break;*/
                /*case PRINT_ALL_INVESTMENT_ACCOUNT:
                    printInvestment();*/
                case PRINT_ALL_INVESTMENT_ACCOUNT:
                    break;
                case ADD_MONEY_TO_BANK_ACCOUNT:
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
    private void addAccount(){
        BankAccount bankAccount = dataReader.addBankAccount();
        String pesel = bankAccount.getPesel();
        readAndCreateAccounts.addAccount(bankAccount, pesel);

    }
    private void addInvestment(){
        InvestmentAccount investmentAccount = dataReader.addInvestmentAccount();
        String pesel = investmentAccount.getPesel();
        readAndCreateAccounts.addAccount(investmentAccount, pesel);

    }
    private void printAllAccounts(){
        readAndCreateAccounts.printAllAccount();
    }
   /* private void printAccount(){

        readAndCreateAccounts.printBankAccount(account.getPesel());
    }*/
   /* private void printInvestment(){
        readAndCreateAccounts.printInvestmentAccount();
    }*/
    private void printOption() {
        System.out.println("Dostępne opcje");
        for (Option option : Option.values()) {
            System.out.println(option);
        }
    }
    private void addPlan(){
        readAndCreateAccounts.addPlan(dataReader.savingsPlan());

    }
    private void printPlan(){
        readAndCreateAccounts.printPlan();
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
        PRINT_ALL_ACCOUNT(3, "Wyświetl konta"),
        PRINT_ALL_BANK_ACCOUNT(4, "Wyświetl wsztkie konta bankowe"),
        PRINT_ALL_INVESTMENT_ACCOUNT(5, "Wyświetl wsztkie konta inwestycyjne"),
        ADD_MONEY_TO_BANK_ACCOUNT(6, "Dodaj pieniądze do istniejącego konta bankowego"),
        GOAL(7, "Dodaj cel do uzbierania"),
        RATE(8, "Wyświetl cele");

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
