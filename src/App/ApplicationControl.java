package App;

import App.dataReader.DataReader;
import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationControl {
    Scanner sc = new Scanner(System.in);
    DataReader dataReader = new DataReader();

    public void loopControl() {
        int option = -1;
        do{

            switch(getOption()){
                case EXIT:
                    System.out.println("Wychodzę z programu");
                    option = 0;
            }
        }while(option != 0);

    }
    private void printOption() {
        System.out.println("Dostępne opcje");
        for (Option option: Option.values()) {
            System.out.println(option);
        }
    }
    private Option getOption(){
        boolean isOk = false;
        Option option = null;
        while(!isOk){
            printOption();
            System.out.println("Podaj opcję");
            try {
                option = Option.getEnumFromInt(dataReader.getInt());
                isOk = true;
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }catch(RuntimeException e){
                System.out.println(e.getMessage());
                dataReader.getLine();
            }
        }
        return option;
    }

    private enum Option {
        EXIT(0,"Wyjście z programu"),
        STARTING_BALANCE(1, "Saldo początkowe");

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
            try{
                return options[option];
            }catch (ArrayIndexOutOfBoundsException e){
                throw new ArrayIndexOutOfBoundsException("Brak opcji o id " + option);
            }catch (RuntimeException e){
                throw new RuntimeException("Podaj liczbe a nie litere");
            }
        }
    }
}
