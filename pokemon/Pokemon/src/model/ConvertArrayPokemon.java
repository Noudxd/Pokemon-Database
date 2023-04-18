package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import persistance.util.ConnectionFactory;
import persistance.util.SequelStorage;

public class ConvertArrayPokemon {

    static Connection connection = ConnectionFactory.connectionToDb();

    public static void convertFromList2Array() {

        ArrayList<Integer> listPokemonId = new ArrayList<>();
        Object[] myArray;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SequelStorage.getAllPokemon);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idResult = resultSet.getInt("id");

                listPokemonId.add(idResult);
            }

            myArray = listPokemonId.toArray();

            System.out.println("La mia lista di id di Pokemon: " + Arrays.toString(myArray));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void multiplyDivideId() {
        ArrayList<Integer> listPokemonId = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SequelStorage.getAllPokemon);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idResult = resultSet.getInt("id");

                listPokemonId.add(idResult);
            }

            for (int i = 0; i < listPokemonId.size(); i++) {
                int k = listPokemonId.get(i);
                if (k % 2 == 0) {
                    int id = listPokemonId.get(i);
                    id = id * 2;
                    listPokemonId.set(i, id);
                } else {
                    int id = listPokemonId.get(i);
                    id = id / 3;

                    listPokemonId.set(i, id);
                }
            }
            System.out.println(listPokemonId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
