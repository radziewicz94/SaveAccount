package App.dataReader;

import model.Account;
import model.InvestmentAccount;
import model.BankAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private Account[] accounts = new Account[2];
    private int countAccount = 0;
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
    public BankAccount addBankAccount(){
        System.out.println("Podaj imie właściciela konta");
        String firstName = sc.nextLine();
        System.out.println("Podaj nazwisko");
        String lastName = sc.nextLine();
        System.out.println("Podaj pesel właściciela konta");
        String pesel = sc.nextLine();
        System.out.println("Podaj nazwę banku");
        String bank = sc.nextLine();
        System.out.println("Podaj nr konta");
        String accountNumber = sc.nextLine();
        try {
            System.out.println("Podaj kwotę którą zaoszczędziłeś");
            balance = getDouble();
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }

        return new BankAccount(firstName, lastName, pesel, bank, accountNumber, balance);
    }
    public InvestmentAccount addInvestmentAccount(){
        System.out.println("Podaj imie właściciela konta");
        String firstName = sc.nextLine();
        System.out.println("Podaj nazwisko");
        String lastName = sc.nextLine();
        System.out.println("Podaj pesel właściciela konta");
        String pesel = sc.nextLine();
        System.out.println("Podaj konto inwestycjne");
        String account = sc.nextLine();
        System.out.println("Podaj kwotę odłożona na lokatę");
        try {
        double balance = getDouble();
        System.out.println("Podaj oprocentowanie lokaty");
            interestRate = getDouble();
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }

        return new InvestmentAccount(firstName, lastName, pesel, account, balance, interestRate);
    }
}
