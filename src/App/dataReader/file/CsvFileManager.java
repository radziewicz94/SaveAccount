package App.dataReader.file;

import App.ApplicationControl;
import App.dataReader.MyAccounts;
import App.dataReader.printer.ConsolePrinter;
import exception.DataImportException;
import model.Account;
import model.BankAccount;
import model.InvestmentAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;

public class CsvFileManager implements FileManager{
    private static final String CSV_FILE_NAME = "Accounts.csv";
    ConsolePrinter consolePrinter = new ConsolePrinter();
    @Override
    public void importDate(MyAccounts myAccounts) {

        try(Scanner sc = new Scanner(new File(CSV_FILE_NAME)))
        {
            while(sc.hasNext()){
                String line = sc.nextLine();
                Account account = createAccountFromCsv(line);
                myAccounts.addAccount(account);
            }
        }catch (FileNotFoundException e){
            throw new DataImportException("Nie udało się zaimportować danych z pliku " + CSV_FILE_NAME);
        }
    }
    private Account createAccountFromCsv(String fromCsv) {
        String[] split = fromCsv.split(";");
        String type = split[0];
        if(BankAccount.TYPE.equals(type)){
            return createBankAccount(split);
        }else if(InvestmentAccount.TYPE.equals(type)){
            createInvestmentAccount(split);
        }
    }

    private InvestmentAccount createInvestmentAccount(String[] split) {
        String firstName = split[1];
        String lastName = split[2];
        String pesel = split[3];
        String accNumber = split[4];
        double saveMoney = Double.parseDouble(split[5]);
        String accName = split[6];
        double interestedRate = Double.parseDouble(split[7]);

        return new InvestmentAccount(firstName, lastName, pesel, accNumber, saveMoney, accName, interestedRate);
    }

    private BankAccount createBankAccount(String[] split) {
        String firstName = split[1];
        String lastName = split[2];
        String pesel = split[3];
        String accNumber = split[4];
        double saveMoney = Double.parseDouble(split[5]);
        String bankAccount = split[6];

        return new BankAccount(firstName, lastName, pesel, accNumber, saveMoney, bankAccount);
    }


    @Override
    public void exportDate(MyAccounts myAccounts) {
        Collection<MyAccounts>  importAcc =
        try(Sc)
        return null;
    }
}
