[forrige](./08-equals.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; neste

## Oppgave 9 - Pokemon Team

I denne oppgaven skal vi lage en `PokemonTrainer`-klasse som kan holde styr på et team av Pokémon. Her får du bruke alt du har lært: referanser, `equals()`, og `toString()`.

>:question: **Liste (ArrayList)**. En liste er en ordnet samling av elementer. `ArrayList` er Javas mest brukte liste-implementasjon. Den kan vokse dynamisk når du legger til elementer.

>:question: **Generics** (`<Pokemon>`). Når vi skriver `ArrayList<Pokemon>`, forteller vi Java at listen *kun* skal inneholde `Pokemon`-objekter. Dette gir typesikkerhet - kompilatoren hjelper oss å unngå feil.

### Deloppgave A - Implementer PokemonTrainer-klassen

**TODO: Implementer `PokemonTrainer.java` i `pokemon`-pakken.**

Klassen skal ha:
- En feltvariabel `String name` - trenerens navn
- En feltvariabel `ArrayList<Pokemon> team` - trenerens Pokémon-team
- En konstruktør som tar inn trenerens navn og initialiserer et tomt team

```java
package pokemon;

import java.util.ArrayList;

public class PokemonTrainer {
    // Feltvariabler
    private String name;
    private ArrayList<Pokemon> team;

    // Konstruktør - initialiser name og opprett en tom ArrayList
    public PokemonTrainer(String name) {
        // TODO
    }

    // Getter for navn
    public String getName() {
        // TODO
    }
}
```

> :bulb: **Tips:** For å opprette en tom ArrayList skriver du `new ArrayList<>()` eller `new ArrayList<Pokemon>()`.

<br></br>
### Deloppgave B - Legg til Pokémon i teamet

**TODO: Implementer metodene for å administrere teamet.**

```java
/**
 * Legger til en Pokémon i teamet.
 * @param p Pokémon som skal legges til
 */
public void addToTeam(Pokemon p) {
    // Bruk ArrayList.add()
}

/**
 * Returnerer antall Pokémon i teamet.
 * @return størrelsen på teamet
 */
public int getTeamSize() {
    // Bruk ArrayList.size()
}
```

Test koden din:
```java
PokemonTrainer ash = new PokemonTrainer("Ash");
System.out.println(ash.getTeamSize());  // 0

ash.addToTeam(new Pokemon("Pikachu", 100, 15));
System.out.println(ash.getTeamSize());  // 1

ash.addToTeam(new Pokemon("Charizard", 150, 20));
System.out.println(ash.getTeamSize());  // 2
```

<br></br>
### Deloppgave C - Sjekk for duplikater (bruker equals!)

**TODO: Implementer `hasPokemon()`-metoden.**

```java
/**
 * Sjekker om teamet har en Pokémon som er lik den gitte.
 * @param p Pokémon å sjekke for
 * @return true hvis teamet inneholder en lik Pokémon
 */
public boolean hasPokemon(Pokemon p) {
    // Bruk ArrayList.contains()
}
```

> :bulb: **Viktig innsikt:** `ArrayList.contains()` bruker `equals()` internt for å sjekke likhet! Det er derfor vi implementerte `equals()` i forrige oppgave. Uten en korrekt `equals()`-implementasjon ville `contains()` bare sjekket referanselikhet.

Test det:
```java
PokemonTrainer ash = new PokemonTrainer("Ash");
Pokemon pikachu = new Pokemon("Pikachu", 100, 15);
ash.addToTeam(pikachu);

// Sjekk med samme objekt
System.out.println(ash.hasPokemon(pikachu));  // true

// Sjekk med nytt objekt med samme verdier
Pokemon annenPikachu = new Pokemon("Pikachu", 100, 15);
System.out.println(ash.hasPokemon(annenPikachu));  // true! (takket være equals())

// Sjekk med ulik Pokémon
Pokemon charmander = new Pokemon("Charmander", 80, 12);
System.out.println(ash.hasPokemon(charmander));  // false
```

<br></br>
### Deloppgave D - List alle Pokémon

**TODO: Implementer `printTeam()`-metoden.**

```java
/**
 * Skriver ut alle Pokémon i teamet.
 */
public void printTeam() {
    // Bruk en for-each-løkke og toString()
}
```

En for-each-løkke lar deg iterere over alle elementer i en liste:
```java
for (Pokemon p : team) {
    // Gjør noe med p
}
```

Forventet output:
```
Ash's team:
Pikachu HP: (100/100) STR: 15
Charizard HP: (150/150) STR: 20
```

<br></br>
### Deloppgave E - Heal alle Pokémon (bruker referanser!)

Først må vi legge til en `heal()`-metode i `Pokemon.java`.

**TODO: Implementer `heal()` i `Pokemon.java`.**

```java
/**
 * Healer Pokémon'en til full helse.
 * Setter currentHP lik maxHP.
 */
void heal() {
    // TODO
}
```

**TODO: Implementer så `healAll()` i `PokemonTrainer.java`.**

```java
/**
 * Healer alle Pokémon i teamet til full helse.
 */
public void healAll() {
    // Bruk en for-each-løkke og kall heal() på hver Pokémon
}
```

> :bulb: **Viktig innsikt om referanser:** Pokémon-objektene i listen er *referanser*. Når du kaller `heal()` på en Pokémon i listen, healer du det faktiske objektet. Hvis du har en variabel utenfor som peker til samme objekt, vil den også se endringen!

```java
Pokemon pikachu = new Pokemon("Pikachu", 100, 15);
PokemonTrainer ash = new PokemonTrainer("Ash");
ash.addToTeam(pikachu);

pikachu.takeDamage(50);
System.out.println(pikachu.getCurrentHP());  // 50

ash.healAll();
System.out.println(pikachu.getCurrentHP());  // 100! Referansen i listen peker til samme objekt
```

<br></br>
### Oppsummering

I denne oppgaven har du lært:
- **ArrayList** - en dynamisk liste for å lagre objekter
- **Generics** - typesikkerhet med `<Pokemon>`
- **for-each-løkker** - iterering over lister
- Hvordan **equals()** brukes av `ArrayList.contains()`
- Hvordan **referanser** fungerer i lister

<br></br>
✅ Denne oppgaven er fullført når testene i `PokemonTrainerTest.java` passerer.

<br></br>
### Gratulerer! Du har fullført alle oppgavene i Lab 2!

Du har nå lært det grunnleggende om objektorientert programmering i Java:
- Klasser og objekter
- Feltvariabler og konstruktører
- Metoder og `toString()`
- Referanser og aliasing
- `.equals()` vs `==`
- Lister med `ArrayList`

HUSK AT DU MÅ LEVERE PÅ CODEGRADE!
