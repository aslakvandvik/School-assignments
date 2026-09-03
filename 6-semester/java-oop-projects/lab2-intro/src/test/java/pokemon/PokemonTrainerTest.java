package pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PokemonTrainerTest {

    PokemonTrainer trainer;
    String trainerName = "Ash";

    @BeforeEach
    public void setup() {
        trainer = new PokemonTrainer(trainerName);
    }

    @Test
    public void trainerHasNameTest() {
        assertEquals(trainerName, trainer.getName(),
            "Trainer should have the correct name");
    }

    @Test
    public void emptyTeamTest() {
        assertEquals(0, trainer.getTeamSize(),
            "New trainer should start with an empty team");
    }

    @Test
    public void addToTeamTest() {
        Pokemon pikachu = new Pokemon("Pikachu", 100, 15);
        trainer.addToTeam(pikachu);
        assertEquals(1, trainer.getTeamSize(),
            "Team size should be 1 after adding one Pokemon");

        Pokemon charizard = new Pokemon("Charizard", 150, 20);
        trainer.addToTeam(charizard);
        assertEquals(2, trainer.getTeamSize(),
            "Team size should be 2 after adding two Pokemon");
    }

    @Test
    public void hasPokemonTest() {
        Pokemon pikachu = new Pokemon("Pikachu", 100, 15);
        trainer.addToTeam(pikachu);

        assertTrue(trainer.hasPokemon(pikachu),
            "hasPokemon should return true for a Pokemon in the team");
    }

    @Test
    public void hasPokemonWithCopyTest() {
        // hasPokemon should use equals(), so a Pokemon with the same values should be found
        Pokemon pikachu = new Pokemon("Pikachu", 100, 15);
        trainer.addToTeam(pikachu);

        // Create a new Pokemon with the same values (not the same object)
        Pokemon anotherPikachu = new Pokemon("Pikachu", 100, 15);

        assertTrue(trainer.hasPokemon(anotherPikachu),
            "hasPokemon should return true for a Pokemon with equal values (uses equals())");
    }

    @Test
    public void hasPokemonNotInTeamTest() {
        Pokemon pikachu = new Pokemon("Pikachu", 100, 15);
        trainer.addToTeam(pikachu);

        Pokemon charmander = new Pokemon("Charmander", 80, 12);
        assertFalse(trainer.hasPokemon(charmander),
            "hasPokemon should return false for a Pokemon not in the team");
    }

    @Test
    public void healAllTest() {
        Pokemon pikachu = new Pokemon("Pikachu", 100, 15);
        Pokemon charizard = new Pokemon("Charizard", 150, 20);

        pikachu.takeDamage(50);
        charizard.takeDamage(100);

        trainer.addToTeam(pikachu);
        trainer.addToTeam(charizard);

        assertEquals(50, pikachu.getCurrentHP(), "Pikachu should have taken damage");
        assertEquals(50, charizard.getCurrentHP(), "Charizard should have taken damage");

        trainer.healAll();

        assertEquals(pikachu.getMaxHP(), pikachu.getCurrentHP(),
            "Pikachu should be at full HP after healAll");
        assertEquals(charizard.getMaxHP(), charizard.getCurrentHP(),
            "Charizard should be at full HP after healAll");
    }

    @Test
    public void healAllReferencesTest() {
        // Demonstrates that Pokemon in the list are references
        // Healing affects the actual objects
        Pokemon pikachu = new Pokemon("Pikachu", 100, 15);
        pikachu.takeDamage(50);

        trainer.addToTeam(pikachu);

        // Keep a separate reference to the same Pokemon
        Pokemon samePikachu = pikachu;

        trainer.healAll();

        // The reference we kept should also see the healing
        assertEquals(samePikachu.getMaxHP(), samePikachu.getCurrentHP(),
            "Healing through the trainer should affect the actual Pokemon object (references)");
    }
}
