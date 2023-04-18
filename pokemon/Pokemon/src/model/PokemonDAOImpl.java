package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import persistance.util.ConnectionFactory;
import persistance.util.SequelStorage;

public class PokemonDAOImpl implements PokemonDAO {

    Connection connection;

    public PokemonDAOImpl() {
        this.connection = ConnectionFactory.connectionToDb();
    }

    @Override
    public Pokemon createPokemon(Pokemon pokemon) {

        String insertPokemon = "INSERT INTO pokemon.pokemon_tb (name, elementType, level) VALUES (?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertPokemon);
            // setString comando specifico, dalla posizione X si setta il ? del value in una
            // stringa
            preparedStatement.setString(1, pokemon.getName());
            preparedStatement.setString(2, pokemon.getElementType());
            preparedStatement.setInt(3, pokemon.getLevel());

            int rowInserted = preparedStatement.executeUpdate();

            System.out.println("LOG: Inserimento di " + rowInserted + " avvenuto con successo");
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return pokemon;
    }

    @Override
    public Pokemon getPOkemon(int id) {

        Statement s;
        Pokemon daRitornare = null;

        try {
            s = connection.createStatement();

            String query = String.format("SELECT * FROM pokemon_tb WHERE Id = ?", id);

            ResultSet result = s.executeQuery(query);

            while (result.next()) {
                int idPokemon = result.getInt("id");
                String nomePokemon = result.getString("name");
                String elementPokemon = result.getString("elementType");
                int levelPokemon = result.getInt("level");

                daRitornare = new Pokemon(idPokemon, nomePokemon, elementPokemon, levelPokemon);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(daRitornare);
        return daRitornare;

    }

    @Override
    public ArrayList<Pokemon> getAllPOkemon() {

        ArrayList<Pokemon> daRitornare = new ArrayList<Pokemon>();

        Statement s;

        try {
            s = connection.createStatement();

            String query = String.format("SELECT * FROM pokemon_tb");

            ResultSet result = s.executeQuery(query);

            while (result.next()) {
                int idPokemon = result.getInt("id");
                String nomePokemon = result.getString("name");
                String elementPokemon = result.getString("elementType");
                int levelPokemon = result.getInt("level");

                Pokemon daInserire = new Pokemon(idPokemon, nomePokemon, elementPokemon, levelPokemon);

                daRitornare.add(daInserire);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(daRitornare);
        return daRitornare;

    }

    @Override
    public Pokemon updatePOkemon(Pokemon pokemon) {

        String updatePokemon = "UPDATE pokemon_tb SET name=?, elementType=?,level=? WHERE (id = ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updatePokemon);
            // setString comando specifico, dalla posizione X si setta il ? del value in una
            // stringa
            preparedStatement.setString(1, pokemon.getName());
            preparedStatement.setString(2, pokemon.getElementType());
            preparedStatement.setInt(3, pokemon.getLevel());
            preparedStatement.setInt(4, pokemon.getId());

            int rowInserted = preparedStatement.executeUpdate();

            System.out.println("LOG: Inserimento " + rowInserted + " avvenuto con successo");
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return pokemon;
    }

    @Override
    public void deletePokemonById(int id) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SequelStorage.deletePokemonById);
            preparedStatement.setInt(1, id);

            int rowDelete = preparedStatement.executeUpdate();

            System.out.println("LOG : Cancellazione di  " + rowDelete + "avvenuto con successo");

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("connesione chiusa");
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
