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
    private ConsolePrinter consolePrinter;
    
    public DataReader(ConsolePrinter consolePrinter){
        this.consolePrinter = consolePrinter;
    }
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
        consolePrinter.print("Podaj imie właściciela konta");
        String firstName = sc.nextLine();
        consolePrinter.print("Podaj nazwisko właściciela konta");
        String lastName = sc.nextLine();
        consolePrinter.print("Podaj pesel właściciela konta");
        String pesel = sc.nextLine();
        consolePrinter.print("Podaj nazwę banku");
        String bank = sc.nextLine();
        consolePrinter.print("Podaj numer konta");
        String accountNumber = sc.nextLine();
        try {
            consolePrinter.print("Podaj kwotę którą zaoszczędziłeś");
            balance = getDouble();
        }catch (InputMismatchException e){
            consolePrinter.print(e.getMessage());
        }


        return new BankAccount(firstName, lastName, pesel, accountNumber, balance, bank);
    }

    public InvestmentAccount addInvestmentAccount(){
        consolePrinter.print("Podaj imie właściciela konta");
        String firstName = sc.nextLine();
        consolePrinter.print("Podaj nazwisko właściciela konta");
        String lastName = sc.nextLine();
        consolePrinter.print("Podaj pesel właściciela konta");
        String pesel = sc.nextLine();
        consolePrinter.print("Podaj numer konta");
        String accountNumber = sc.nextLine();
        try {
        consolePrinter.print("Podaj kwotę odłożona na lokatę");
        balance = getDouble();
        consolePrinter.print("Podaj oprocentowanie lokaty");
            interestRate = getDouble();
        }catch (InputMismatchException e){
            consolePrinter.print(e.getMessage());
        }
        consolePrinter.print("Podaj nazwę konta inwestycjne");
        String account = sc.nextLine();

        return new InvestmentAccount(firstName, lastName, pesel, accountNumber,balance, account, interestRate);
    }

    public Plan savingsPlan(){
        consolePrinter.print("Podaj na co zbierasz");
        String plan = sc.nextLine();
        consolePrinter.print("Ile musisz zebrac");
        double goal = getDouble();
        consolePrinter.print("Ile odkładasz miesięcznie");
        double save = getDouble();

        return new Plan(plan, goal, save);
    }
}
