package App.dataReader;

import java.util.Scanner;

public class DataReader {
    Scanner sc = new Scanner(System.in);

    public int getInt(){
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }
    public void getLine(){
        String line = sc.nextLine();
    }
}
