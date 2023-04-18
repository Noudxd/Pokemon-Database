package persistance;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import persistance.util.ConnectionFactory;

public class DatabaseManager {

    Connection connection;

    public void initDB() {
        Connection connection = ConnectionFactory.connectionToDb();

        String createTable = "CREATE TABLE IF NOT EXISTS pokemon.pokemon_tb(id INT NOT NULL AUTO_INCREMENT,name VARCHAR(45) NULL,elementType VARCHAR(45) NULL,level VARCHAR(45) NULL,PRIMARY KEY (id));";

        // Statement stat = ecc.. per creare un comando SQL, premere direttamente
        // "surround by try/catch"
        try {
            Statement stat = connection.createStatement();
            stat.executeUpdate(createTable);
            System.out.println("Tabella creata");
            connection.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    
    
}
