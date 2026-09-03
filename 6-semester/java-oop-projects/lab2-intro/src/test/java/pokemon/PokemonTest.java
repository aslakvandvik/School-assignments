package pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PokemonTest {
    
    Pokemon pokemon;
    String name = "Mew";
    int healthPoints = 20;
    int strength = 5;

    @BeforeEach
    public void setup() {
        pokemon = new Pokemon(name, healthPoints, strength);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, pokemon.getName());
    }

    @Test
    public void getStrengthTest() {
        int strength = pokemon.getStrength();
        if (strength == 0)
            fail("Strength cannot be 0.");
    }

    @Test
    public void healthPointsTest() {
        int maxHP = pokemon.getMaxHP();
        assertNotEquals(maxHP, 0, "A pokemon should not have 0 HP as their max.");

        int initialHP = pokemon.getCurrentHP();
        assertEquals(maxHP, initialHP, "Maximum HP and current HP should be equal before engaging in battle.");

        pokemon.takeDamage(1);
        assertNotEquals(maxHP, pokemon.getCurrentHP(), "Maximum HP and current HP should not be equal after taking damage.");
    }

    @Test
    public void damageTest() {
        int currentHP = pokemon.getCurrentHP();
        int damage = 10;
        pokemon.takeDamage(damage);

        assertEquals(currentHP - damage, pokemon.getCurrentHP());
    }

    @Test
    public void cannotInflictNegativeDamage() {
        int currentHP = pokemon.getCurrentHP();
        int damage = -1;
        pokemon.takeDamage(damage);

        assertFalse(currentHP < pokemon.getCurrentHP(), "Inflicting negative damage, i.e. increasing the HP, should not be possible");
    }

    @Test
    public void hpNotBelowZeroTest1() {
        int currentHP = pokemon.getCurrentHP();
        pokemon.takeDamage(currentHP);
        assertEquals(0, pokemon.getCurrentHP());

        pokemon.takeDamage(1);
        assertEquals(0, pokemon.getCurrentHP(), "HP should be 0 when health is depleted, never negative HP.");
    }

    @Test
    public void hpNotBelowZeroTest2() {
        int currentHP = pokemon.getCurrentHP();
        pokemon.takeDamage(currentHP + 1);
        assertEquals(0, pokemon.getCurrentHP(), "HP should be 0 when health is depleted, never negative HP.");
    }

    @Test
    public void isAliveTest() {
        assertTrue(pokemon.isAlive());
        pokemon.takeDamage(pokemon.getCurrentHP());
        assertFalse(pokemon.isAlive());
    }

    @Test
    public void attackTest() {
        Pokemon target = new Pokemon("MewTwo", 100, 20);
        int targetHP = target.getCurrentHP();
        // Perform an attack 100 times. A pokemon may do 0 damage sometimes, but not 100 times in a row (astronomical chances).
        for (int i = 0; i < 100; i++) { 
            pokemon.attack(target);
            if (pokemon.getCurrentHP() <= 0)
                break;
        }
        assertTrue(targetHP > target.getCurrentHP());
    }

    @Test
    public void attackDefeatTest() {
        Pokemon target = new Pokemon("MewTwo", 100, 20);
        assertTrue(target.isAlive());
        for (int i = 0; i < 1000; i++) { 
            pokemon.attack(target);
        }
        assertFalse(target.isAlive());
        assertTrue(pokemon.isAlive());
    }

    @Test
    public void toStringTest() {
        // Expected: "Mew HP: (??/??) STR: ?"
        // where the questionmarks differ in value
        String pokemonString = pokemon.toString();
        String[] tokens = pokemonString.split(" ");
        assertEquals(name, tokens[0]);
        assertEquals("HP:", tokens[1]);

        char first = tokens[2].charAt(0);
        char last = tokens[2].charAt(tokens[2].length()-1);
        assertEquals('(', first);
        assertEquals(')', last);

        assertEquals("STR:", tokens[3]);
    }

    // ========== Oppgave 7 - Referanser ==========

    @Test
    public void referenceTest() {
        // Two variables pointing to the same object see the same changes
        Pokemon a = new Pokemon("Pikachu", 100, 10);
        Pokemon b = a; // b is a reference to the same object

        int originalHP = a.getCurrentHP();
        b.takeDamage(20);

        assertEquals(originalHP - 20, a.getCurrentHP(),
            "Changes through b should be visible through a (same object)");
        assertEquals(a.getCurrentHP(), b.getCurrentHP(),
            "a and b should always have the same HP (same object)");
    }

    @Test
    public void copyCreatesNewObjectTest() {
        // copy() should create a new object
        Pokemon original = new Pokemon("Pikachu", 100, 10);
        Pokemon copy = original.copy();

        assertFalse(original == copy,
            "copy() should create a new object (different reference)");
    }

    @Test
    public void copyHasSameValuesTest() {
        // The copy should have the same name, maxHP, and strength
        Pokemon original = new Pokemon("Pikachu", 100, 10);
        original.takeDamage(30); // Damage the original
        Pokemon copy = original.copy();

        assertEquals(original.getName(), copy.getName(),
            "Copy should have the same name");
        assertEquals(original.getMaxHP(), copy.getMaxHP(),
            "Copy should have the same maxHP");
        assertEquals(original.getStrength(), copy.getStrength(),
            "Copy should have the same strength");
        assertEquals(copy.getMaxHP(), copy.getCurrentHP(),
            "Copy should start with full HP");
    }

    // ========== Oppgave 8 - equals ==========

    @Test
    public void equalsWithSameObjectTest() {
        // An object should be equal to itself
        assertTrue(pokemon.equals(pokemon),
            "A Pokemon should be equal to itself");
    }

    @Test
    public void equalsWithIdenticalPokemonTest() {
        // Two Pokemon with the same values should be equal
        Pokemon a = new Pokemon("Pikachu", 100, 10);
        Pokemon b = new Pokemon("Pikachu", 100, 10);

        assertTrue(a.equals(b),
            "Two Pokemon with the same values should be equal");
        assertTrue(b.equals(a),
            "equals() should be symmetric");
    }

    @Test
    public void equalsWithDifferentPokemonTest() {
        // Pokemon with different values should not be equal
        Pokemon a = new Pokemon("Pikachu", 100, 10);
        Pokemon b = new Pokemon("Charmander", 100, 10);
        Pokemon c = new Pokemon("Pikachu", 90, 10);
        Pokemon d = new Pokemon("Pikachu", 100, 15);

        assertFalse(a.equals(b), "Different name should mean not equal");
        assertFalse(a.equals(c), "Different maxHP should mean not equal");
        assertFalse(a.equals(d), "Different strength should mean not equal");
    }

    @Test
    public void equalsIgnoresCurrentHPTest() {
        // currentHP should NOT affect equality
        Pokemon a = new Pokemon("Pikachu", 100, 10);
        Pokemon b = new Pokemon("Pikachu", 100, 10);

        a.takeDamage(50); // a now has 50/100 HP

        assertTrue(a.equals(b),
            "currentHP should not affect equality - Pokemon with same name, maxHP, and strength should be equal");
    }

    @Test
    public void equalsWithNullTest() {
        // equals(null) should return false, not throw exception
        assertFalse(pokemon.equals(null),
            "equals(null) should return false");
    }

    @Test
    public void equalsWithCopyTest() {
        // A copy should be equal to the original
        Pokemon original = new Pokemon("Pikachu", 100, 10);
        Pokemon copy = original.copy();

        assertTrue(original.equals(copy),
            "A Pokemon should be equal to its copy");
        assertTrue(copy.equals(original),
            "equals() should be symmetric for copies");
    }

    @Test
    public void equalsWithWrongTypeTest() {
        // equals() with a non-Pokemon should return false
        assertFalse(pokemon.equals("Not a Pokemon"),
            "equals() with a String should return false");
        assertFalse(pokemon.equals(42),
            "equals() with an Integer should return false");
    }

    // ========== Oppgave 9 - heal ==========

    @Test
    public void healTest() {
        // Pokemon should be restored to full HP after healing
        Pokemon p = new Pokemon("Pikachu", 100, 10);
        p.takeDamage(50);
        assertEquals(50, p.getCurrentHP(), "Pokemon should have taken damage");

        p.heal();
        assertEquals(p.getMaxHP(), p.getCurrentHP(),
            "Pokemon should be at full HP after healing");
    }

}
