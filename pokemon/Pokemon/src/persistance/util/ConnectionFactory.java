package persistance.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static Connection connectionToDb() {
        Connection connection = null;

        //spostati i dati sensibili nel file CredentialsStorage, per le varibili presenti si fa "CredentialsStorage.variabile"
        
        try {
            Class.forName(CredentialsStorage.databaseDriver);
            System.out.println("Driver caricato correttamente. ");

            connection = DriverManager.getConnection(CredentialsStorage.databaseURLConnection, CredentialsStorage.dbUser, CredentialsStorage.dbPassword);
            System.out.println("Connessione al DB stabilita.");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return connection;
    }
}


