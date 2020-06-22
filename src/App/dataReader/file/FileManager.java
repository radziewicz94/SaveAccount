package App.dataReader.file;

import App.ApplicationControl;
import App.dataReader.MyAccounts;

public interface FileManager {
     MyAccounts importDate();
     void exportDate(MyAccounts myAccounts);
}
