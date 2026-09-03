[forrige](./07-referanser.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./09-pokemon_team.md)

## Oppgave 8 - `.equals()` vs `==`

I forrige oppgave lærte vi at `==` sjekker om to variabler refererer til *samme objekt*. Men hva om vi vil sjekke om to objekter har *samme verdier*?

>:question: **Referanselikhet** (`==`). Sjekker om to variabler peker til nøyaktig samme objekt i minnet. To forskjellige objekter med identiske verdier vil gi `false`.

>:question: **Verdilikhet** (`.equals()`). Sjekker om to objekter er "like" basert på deres verdier. Må implementeres av klassen for å definere hva "lik" betyr.

### Eksempel på forskjellen

```java
Pokemon a = new Pokemon("Pikachu", 100, 10);
Pokemon b = new Pokemon("Pikachu", 100, 10);  // Nytt objekt, samme verdier

System.out.println(a == b);       // false - ulike objekter
System.out.println(a.equals(b));  // Hva bør dette være?
```

<br></br>
### Deloppgave A - Implementer `equals()`

For at `a.equals(b)` skal fungere som forventet, må vi *overstyre* `equals()`-metoden fra `Object`-klassen.

>:question: **@Override**. En annotasjon som forteller kompilatoren at vi overskriver en metode fra en foreldreklasse. Dette hjelper med å fange feil hvis metodesignaturen er feil.

>:question: **Casting**. Å konvertere en verdi fra én type til en annen. Når vi skriver `(Pokemon) obj`, caster vi `obj` til typen `Pokemon`.

**TODO: Implementer `equals(Object obj)`-metoden i `Pokemon.java`.**

Metoden skal returnere `true` hvis:
1. `obj` er samme objekt som `this` (bruk `==`)
2. `obj` er en `Pokemon` med samme `name`, `maxHealthPoints` og `strength`

Metoden skal returnere `false` hvis:
1. `obj` er `null`
2. `obj` ikke er en `Pokemon`
3. `obj` har ulike verdier

**Viktig:** `currentHP` skal *ikke* påvirke likhet! To Pokémon med samme navn, maxHP og strength er "like" selv om en av dem har tatt skade.

Her er et skjelett du kan følge:

```java
@Override
public boolean equals(Object obj) {
    // 1. Sjekk om obj er samme objekt som this
    if (this == obj) {
        return true;
    }

    // 2. Sjekk om obj er null
    if (obj == null) {
        return false;
    }

    // 3. Sjekk om obj er av typen Pokemon
    if (!(obj instanceof Pokemon)) {
        return false;
    }

    // 4. Cast obj til Pokemon
    Pokemon other = (Pokemon) obj;

    // 5. Sammenlign feltene (navn, maxHP, strength)
    // Husk: Bruk .equals() for å sammenligne String!
    // ...
}
```

<br></br>
### Deloppgave B - Test forskjellen

Etter at du har implementert `equals()`, prøv følgende i `Main.java`:

```java
Pokemon a = new Pokemon("Pikachu", 100, 10);
Pokemon b = new Pokemon("Pikachu", 100, 10);
Pokemon c = a.copy();

System.out.println("a == b: " + (a == b));           // false - ulike objekter
System.out.println("a.equals(b): " + a.equals(b));   // true - samme verdier
System.out.println("a == c: " + (a == c));           // false - kopi er nytt objekt
System.out.println("a.equals(c): " + a.equals(c));   // true - kopien har samme verdier
```

<br></br>
### Deloppgave C - currentHP påvirker ikke likhet

En viktig designbeslutning: To Pokémon med samme "identitet" (navn, maxHP, strength) bør være like, selv om en har tatt skade:

```java
Pokemon a = new Pokemon("Pikachu", 100, 10);
Pokemon b = new Pokemon("Pikachu", 100, 10);

a.takeDamage(50);  // a har nå 50/100 HP

System.out.println(a.equals(b));  // Bør fortsatt være true!
```

**Tenk over:** Hvorfor gir det mening at currentHP ikke påvirker likhet?

> :bulb: **Tips:** Tenk på det slik: "Er dette den samme Pokémon-typen?" Pikachu med 50 HP er fortsatt en Pikachu med maxHP=100 og strength=10.

<br></br>
✅ Denne oppgaven er fullført når testene `equalsWithSameObjectTest`, `equalsWithIdenticalPokemonTest`, `equalsWithDifferentPokemonTest`, `equalsIgnoresCurrentHPTest`, `equalsWithNullTest`, `equalsWithCopyTest` og `equalsWithWrongTypeTest` i `PokemonTest.java` passerer.
