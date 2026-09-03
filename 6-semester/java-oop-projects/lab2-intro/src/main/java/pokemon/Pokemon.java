package pokemon;

import java.util.Objects;
import java.util.Random;

public class Pokemon {
    // Oppgave 1a
    // Create field variables here:
    private final String name;
    private final int maxHP;
    private int currentHP;
    private final int strength;

    // Random generator (used in attack)
    private final Random random = new Random();

    // Oppgave 1b
    // Create a constructor here:
    public Pokemon(String name, int maxHP, int strength) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (maxHP < 0) {
            throw new IllegalArgumentException("maxHP cannot be negative");
        }
        if (strength < 0) {
            throw new IllegalArgumentException("strength cannot be negative");
        }
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.strength = strength;
    }

    // Oppgave 2

    /**
     * Get name of the pokémon
     *
     * @return name of pokémon
     */
    String getName() {
        return name;
    }

    /**
     * Get strength of the pokémon
     *
     * @return strength of pokémon
     */
    int getStrength() {
        return strength;
    }

    /**
     * Get current health points of pokémon
     *
     * @return current HP of pokémon
     */
    int getCurrentHP() {
        return currentHP;
    }

    /**
     * Get maximum health points of pokémon
     *
     * @return max HP of pokémon
     */
    int getMaxHP() {
        return maxHP;
    }

    /**
     * Check if the pokémon is alive.
     * A pokemon is alive if current HP is higher than 0
     *
     * @return true if current HP > 0, false if not
     */
    boolean isAlive() {
        return currentHP > 0;
    }

    // Oppgave 4

    /**
     * The Pokémon takes a given amount of damage. This method reduces the number of
     * health points the pokémon has by <code>damageTaken</code>.
     * If <code>damageTaken</code> is higher than the number of current
     * health points then set current HP to 0.
     * <p>
     * It should not be possible to deal negative damage, i.e. increase the number of health points.
     * <p>
     * The method should print how much HP the Pokémon is left with.
     *
     * @param damageTaken the amount to reduce the Pokémon's HP by
     */
    void takeDamage(int damageTaken) {
        // No negative damage
        if (damageTaken < 0) {
            damageTaken = 0;
        }

        currentHP -= damageTaken;
        if (currentHP < 0) {
            currentHP = 0;
        }

        System.out.println(name + " takes " + damageTaken + " damage and is left with "
                + currentHP + "/" + maxHP + " HP");
    }

    // Oppgave 5

    /**
     * Attack another pokémon. The method conducts an attack by <code>this</code>
     * on <code>target</code>. Calculate the damage using the pokémons strength
     * and a random element. Reduce <code>target</code>s health.
     * <p>
     * If <code>target</code> has 0 HP then print that it was defeated.
     *
     * @param target pokémon that is being attacked
     */
    void attack(Pokemon target) {
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null");
        }

        System.out.println(this.name + " attacks " + target.name + ".");

        // Random element: sum of two rolls from 1..strength (allows > strength damage)
        int damage = 0;
        if (this.strength > 0) {
            damage = (random.nextInt(this.strength) + 1) + (random.nextInt(this.strength) + 1);
        }

        target.takeDamage(damage);

        if (!target.isAlive()) {
            System.out.println(target.name + " is defeated by " + this.name + ".");
        }
    }

    // Oppgave 3
    @Override
    public String toString() {
        return name + " HP: (" + currentHP + "/" + maxHP + ") STR: " + strength;
    }

    // Oppgave 7

    /**
     * Creates a copy of this Pokemon.
     * The copy is a new object with the same values.
     * @return a new Pokemon with same name, maxHP and strength (full HP)
     */
    Pokemon copy() {
        return new Pokemon(this.name, this.maxHP, this.strength);
    }

    // Oppgave 8

    /**
     * Checks if this Pokemon is equal to another.
     * Two Pokemon are equal if they have the same name, maxHealthPoints and strength.
     * currentHP does NOT affect equality.
     * @param obj the object to compare with
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pokemon other)) return false;

        return this.maxHP == other.maxHP
                && this.strength == other.strength
                && Objects.equals(this.name, other.name);
    }

    // (Optional but good practice when overriding equals)
    @Override
    public int hashCode() {
        return Objects.hash(name, maxHP, strength);
    }

    // Oppgave 9

    /**
     * Heals the Pokemon to full health.
     * Sets currentHP equal to maxHP.
     */
    void heal() {
        this.currentHP = this.maxHP;
    }
}