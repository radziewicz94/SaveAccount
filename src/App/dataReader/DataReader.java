package App.dataReader;

import App.dataReader.printer.ConsolePrinter;
import model.InvestmentAccount;
import model.BankAccount;
import model.Plan;
import java.util.InputMismatchException;;
import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private double balance = 0;
    private double interestRate = 0;


    public double getDouble(){
        Double number;
        try {
            number = sc.nextDouble();
            sc.nextLine();
            return number;
        }catch(InputMismatchException e){
            sc.nextLine();
            throw new InputMismatchException("Zły format danych");
        }
    }
    public int getInt(){
        int number;
        try{
            number = sc.nextInt();
            sc.nextLine();
            return number;
        }catch (InputMismatchException e){
            sc.nextLine();
            throw new InputMismatchException("Zły format danych");
        }
    }
    public String getString(){
        String text = sc.nextLine();
        return text;
    }
    public BankAccount addBankAccount(){
        ConsolePrinter.print("Podaj imie właściciela konta");
        String firstName = sc.nextLine();
        ConsolePrinter.print("Podaj nazwisko właściciela konta");
        String lastName = sc.nextLine();
        ConsolePrinter.print("Podaj pesel właściciela konta");
        String pesel = sc.nextLine();
        ConsolePrinter.print("Podaj nazwę banku");
        String bank = sc.nextLine();
        ConsolePrinter.print("Podaj numer konta");
        String accountNumber = sc.nextLine();
        try {
            ConsolePrinter.print("Podaj kwotę którą zaoszczędziłeś");
            balance = getDouble();
        }catch (InputMismatchException e){
            ConsolePrinter.print(e.getMessage());
        }


        return new BankAccount(firstName, lastName, pesel, accountNumber, balance, bank);
    }

    public InvestmentAccount addInvestmentAccount(){
        ConsolePrinter.print("Podaj imie właściciela konta");
        String firstName = sc.nextLine();
        ConsolePrinter.print("Podaj nazwisko właściciela konta");
        String lastName = sc.nextLine();
        ConsolePrinter.print("Podaj pesel właściciela konta");
        String pesel = sc.nextLine();
        ConsolePrinter.print("Podaj numer konta");
        String accountNumber = sc.nextLine();
        try {
            ConsolePrinter.print("Podaj kwotę odłożona na lokatę");
        balance = getDouble();
            ConsolePrinter.print("Podaj oprocentowanie lokaty");
            interestRate = getDouble();
        }catch (InputMismatchException e){
            ConsolePrinter.print(e.getMessage());
        }
        ConsolePrinter.print("Podaj nazwę konta inwestycjne");
        String account = sc.nextLine();

        return new InvestmentAccount(firstName, lastName, pesel, accountNumber,balance, account, interestRate);
    }

    public Plan savingsPlan(){
        ConsolePrinter.print("Podaj na co zbierasz");
        String plan = sc.nextLine();
        ConsolePrinter.print("Ile musisz zebrac");
        double goal = getDouble();
        ConsolePrinter.print("Ile odkładasz miesięcznie");
        double save = getDouble();

        return new Plan(plan, goal, save);
    }
    public void close(){
        sc.close();
    }
}
