package model;


import java.util.ArrayList;

public interface PokemonDAO {
    
    public Pokemon createPokemon(Pokemon pokemon);

    public Pokemon getPOkemon(int id);

    public ArrayList<Pokemon> getAllPOkemon();
    
    public Pokemon updatePOkemon(Pokemon pokemon);

    public void deletePokemonById(int id);

    public void closeConnection();


}
