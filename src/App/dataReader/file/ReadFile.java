package App.dataReader.file;

import App.dataReader.DataReader;
import App.dataReader.printer.ConsolePrinter;
import exception.InvalidTypeException;

public class ReadFile {
    DataReader dataReader = null;
    ConsolePrinter consolePrinter = null;
    public ReadFile(DataReader dataReader, ConsolePrinter consolePrinter){
        this.dataReader = dataReader;
        this.consolePrinter = consolePrinter;
    }


    public FileManager chooseOption(){
        FileType fileType = read();
        switch (fileType){
            case CSV:
                return new CsvFileManager();
            default:
                throw new InvalidTypeException("Nie ma takiego typu danych");
        }
    }
    public FileType read(){
        System.out.println("Wybierz format danych");
        FileType fileType = null;
        boolean isOk = false;
        do{
            printDateTypes();
            String result = dataReader.getString().toUpperCase();
            try{
                fileType = FileType.valueOf(result);
                isOk = true;
            }catch (IllegalArgumentException e){
                System.out.println("Nie ma takiego typu danych");
            }
        }while(!isOk);
        return fileType;
    }

    public void printDateTypes(){
        FileType[] fileTypes = FileType.values();
        for (FileType fileType : fileTypes) {
            System.out.println(fileType.name());
        }
    }
}
