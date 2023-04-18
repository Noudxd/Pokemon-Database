import model.Pokemon;
import model.PokemonDAO;
import model.PokemonDAOImpl;
import persistance.DatabaseManager;

//classe per far funzioare le classi con il database

public class PokemonDatab {
    
    private DatabaseManager databaseManager;

    private PokemonDAO pokemonDAO;



    public PokemonDatab() {
        databaseManager = new DatabaseManager();

        pokemonDAO = new PokemonDAOImpl();
    }

    public Pokemon addPokemon(Pokemon pokemon){
        return pokemonDAO.createPokemon(pokemon);

    }

    public void getPOkemonById(int id){
        pokemonDAO.getPOkemon(id);
    }

    public void getAllPOkemon(){
        pokemonDAO.getAllPOkemon();
    }

    public Pokemon updatePokemon(Pokemon pokemon){
        return pokemonDAO.updatePOkemon(pokemon);

    }

    public void deletePokemonById(int id){
        pokemonDAO.deletePokemonById(id);
    }
    
    public void closeConnection(){
        pokemonDAO.closeConnection();
    }
}
