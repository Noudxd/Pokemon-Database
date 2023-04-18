package persistance.util;

public class SequelStorage {
    
    //DDL
    public static final String createTable = "CREATE TABLE IF NOT EXISTS pokemon.pokemon_tb(id INT NOT NULL AUTO_INCREMENT,name VARCHAR(45) NULL,elementType VARCHAR(45) NULL,level VARCHAR(45) NULL,PRIMARY KEY (id));";

    //DML 
    public static final String createPokemon = "INSERT INTO pokemon.pokemon_tb (name, elementType, level) VALUES (?,?,?);";

    public static final String updatePokemon = "UPDATE pokemon_tb SET name=?, elementType=?,level=? WHERE (id = ?)";

    public static final String deletePokemonById = "DELETE FROM pokemon_tb WHERE Id = ?";


    //DQL
    public static final String getPokemonById = "SELECT * FROM pokemon_tb WHERE Id = ?";

    public static final String getAllPokemon = "SELECT * FROM pokemon_tb";

    


}
