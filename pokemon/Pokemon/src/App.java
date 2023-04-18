import model.ConvertArrayPokemon;

//import model.Pokemon;
//import persistance.ConnectionFactory;
//import persistance.DatabaseManager;
//import persistance.ConnectionFactory;


public class App {
    public static void main(String[] args) throws Exception {
        
       //ConnectionFactory.connectionToDb();

       //DatabaseManager dibiManager = new DatabaseManager();

       //dibiManager.initDB();

    PokemonDatab pokemonDatab = new PokemonDatab();

       //Pokemon picha = new Pokemon("Pickachu", "elettricita", 5);

       //Pokemon picha2 = new Pokemon("Squirtle", "aqua", 10);

       //Pokemon picha3 = new Pokemon("Ponyta", "fuoco", 5);

        //pokemonDatab.addPokemon(picha);
       //pokemonDatab.addPokemon(picha2); //commentare, se no continua a fare gli stessi inserimenti
       //pokemonDatab.addPokemon(picha3);

       //pokemonDatab.getPOkemonById(1);

       //pokemonDatab.getAllPOkemon();

       //picha.setName("Piplup");
       //picha.setElementType("acqua");
       //picha.setLevel(6);
       //picha.setId(1);

       //picha3.setLevel(7);
       //picha3.setId(4);
       //pokemonDatab.updatePokemon(picha3);
       
        
       //picha3.getId();
       //pokemonDatab.deletePokemonById(4);

       
       
        //pokemonDatab.getAllPOkemon();

        pokemonDatab.closeConnection();

        ConvertArrayPokemon.convertFromList2Array();

        ConvertArrayPokemon.multiplyDivideId();
       
    }
}
