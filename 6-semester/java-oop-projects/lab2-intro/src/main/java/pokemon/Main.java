package pokemon;

public class Main {

    public static Pokemon pokemon1;
    public static Pokemon pokemon2;

    public static void main(String[] args) {
        // Create Pokémon
        pokemon1 = new Pokemon("Mewtwo", 94, 12);
        pokemon2 = new Pokemon("Rattata", 100, 3);

        // Print initial status
        System.out.println(pokemon1);
        System.out.println(pokemon2);
        System.out.println();

        // Battle loop
        while (pokemon1.isAlive() && pokemon2.isAlive()) {
            pokemon1.attack(pokemon2);
            if (!pokemon2.isAlive()) {
                break;
            }

            pokemon2.attack(pokemon1);
            System.out.println();
        }
    }
}