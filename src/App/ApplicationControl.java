package App;

import App.dataReader.DataReader;
import App.dataReader.MyAccounts;
import App.dataReader.file.CsvFileManager;
import App.dataReader.printer.ConsolePrinter;
import exception.AccountNumberExsistException;
import exception.DataExportException;
import model.BankAccount;
import model.InvestmentAccount;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationControl {
    Scanner sc = new Scanner(System.in);
    DataReader dataReader = new DataReader();
    MyAccounts myAccounts = new MyAccounts();
    CsvFileManager csvFileManager = new CsvFileManager();

    protected void loopControl() {
        int option = -1;
        do {

            switch (getOption()) {
                case EXIT:
                    exitProgram();
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
                case IMPORT_FILE_FROM_CSV:
                    importFromCsv();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + getOption());
            }
        } while (option != 0);

    }

    private void addSaveMoneyToBankAccount() {
        ConsolePrinter.print("Ile pieniędzy chcesz dodać");
        double money = dataReader.getDouble();
        ConsolePrinter.print("Podaj nr konta na które chcesz przelać oszczędności");
        String accNumber = sc.nextLine();

        myAccounts.addMoney(money, accNumber);

    }


    private void addAccount(){
        try {
            BankAccount bankAccount = dataReader.addBankAccount();
            myAccounts.addAccount(bankAccount);
        }catch (AccountNumberExsistException e){
            ConsolePrinter.print(e.getMessage());
        }

    }

    private void addInvestment(){
        try {
            InvestmentAccount investmentAccount = dataReader.addInvestmentAccount();
            myAccounts.addAccount(investmentAccount);
        }catch (AccountNumberExsistException e){
            ConsolePrinter.print(e.getMessage());
        }

    }
    private void printAllAccounts() {
        ConsolePrinter.printAllAccounts(myAccounts.getAccounts().values());
    }
    private void printBankAccounts(){
        ConsolePrinter.printBankAccount(myAccounts.getAccounts().values());
    }
    private void printInvestmentAccount(){
        ConsolePrinter.printInvestmentAccount(myAccounts.getAccounts().values());
    }
    private void importFromCsv(){
        csvFileManager.importAccounts(myAccounts);
        ConsolePrinter.print("Zaimportowane dane z pliku");
    }
    private void printOption() {
        ConsolePrinter.print("Dostępne opcje");
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

    private void exitProgram() {
        try {
            csvFileManager.exportDate(myAccounts);
            ConsolePrinter.print("Export danych do pliku zakończony powodzeniem");
        } catch (DataExportException e) {
            ConsolePrinter.print(e.getMessage());
        }
        dataReader.close();
        ConsolePrinter.print("Zamykam program");
    }
    private Option getOption() {
        boolean isOk = false;
        Option option = null;
        while (!isOk) {
            printOption();
            ConsolePrinter.print("Podaj opcję");
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
        RATE(8, "Wyświetl cele"),
        IMPORT_FILE_FROM_CSV(9, "Import z pliku csv");

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
