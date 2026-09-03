package pokemon;

import java.util.ArrayList;

public class PokemonTrainer {

    // Oppgave 9a: Field variables
    private final String name;
    private final ArrayList<Pokemon> team;

    // Oppgave 9a: Constructor
    // Takes trainer name and initializes an empty team
    public PokemonTrainer(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
        this.team = new ArrayList<>();
    }

    /**
     * Gets the trainer's name.
     * @return the trainer's name
     */
    public String getName() {
        return name;
    }

    // Oppgave 9b: addToTeam(Pokemon p), getTeamSize()

    /**
     * Adds a Pokemon to the team.
     * @param p the Pokemon to add
     */
    public void addToTeam(Pokemon p) {
        if (p == null) {
            throw new IllegalArgumentException("Pokemon cannot be null");
        }
        team.add(p);
    }

    /**
     * Gets the number of Pokemon in the team.
     * @return the team size
     */
    public int getTeamSize() {
        return team.size();
    }

    // Oppgave 9c: hasPokemon(Pokemon p)

    /**
     * Checks if the team has a Pokemon equal to the given one.
     * Uses ArrayList.contains() which internally uses equals().
     * @param p the Pokemon to check for
     * @return true if the team contains an equal Pokemon
     */
    public boolean hasPokemon(Pokemon p) {
        return team.contains(p);
    }

    // Oppgave 9d: printTeam()

    /**
     * Prints all Pokemon in the team.
     * Uses a for-each loop and the Pokemon's toString() method.
     */
    public void printTeam() {
        for (Pokemon p : team) {
            System.out.println(p);
        }
    }

    // Oppgave 9e: healAll()

    /**
     * Heals all Pokemon in the team to full health.
     */
    public void healAll() {
        for (Pokemon p : team) {
            p.heal();
        }
    }
}