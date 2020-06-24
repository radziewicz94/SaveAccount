package App.dataReader.file;

import App.ApplicationControl;
import App.dataReader.MyAccounts;
import App.dataReader.printer.ConsolePrinter;
import exception.DataExportException;
import exception.DataImportException;
import exception.InvalidTypeException;
import model.Account;
import model.BankAccount;
import model.InvestmentAccount;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class CsvFileManager implements FileManager{
    private static final String CSV_FILE_NAME = "Accounts.csv";
    ConsolePrinter consolePrinter = new ConsolePrinter();
    @Override
    public MyAccounts importDate() {
        MyAccounts myAccounts = new MyAccounts();
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
        return new MyAccounts();
    }
    private Account createAccountFromCsv(String fromCsv) {
        String[] split = fromCsv.split(";");
        String type = split[0];
        if(BankAccount.TYPE.equals(type)){
            return createBankAccount(split);
        }else if(InvestmentAccount.TYPE.equals(type)){
            return createInvestmentAccount(split);
        }
        throw new InvalidTypeException("Nieznany typ konta " + type);
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
        Collection<Account> importAcc = myAccounts.getAccounts().values();
        String line =  null;
        try(    var FileWriter = new FileWriter(CSV_FILE_NAME);
                var BufferedWriter = new BufferedWriter(FileWriter);){
            for (Account account : importAcc) {
                BufferedWriter.write(account.toCsv());
                BufferedWriter.newLine();
            }
        }catch (IOException e){
            throw new DataExportException("Nie udało sie odczytać pliku " + CSV_FILE_NAME);
        }
    }
}
