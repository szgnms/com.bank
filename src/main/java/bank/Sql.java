package bank;

import java.sql.SQLException;
import java.util.concurrent.Semaphore;

public class Sql extends Database {

 public static void createTable()  {

     try {
         st.execute("CREATE TABLE IF NOT EXISTS bank (" +
                 "name VARCHAR(50) NOT NULL," +
                 "surname VARCHAR(50) NOT NULL," +
                 "id INT NOT NULL)");
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }

 }

    public static void createSamTable()  {
        try {
            st.execute("CREATE TABLE IF NOT EXISTS samTable (" +
                    "sam VARCHAR(255) NOT NULL," +
                    "duration BIGINT  NOT NULL," +
                            "name VARCHAR(255) NOT NULL );"
                     );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
