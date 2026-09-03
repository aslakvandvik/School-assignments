[forrige](./06-pokemon_battle.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./08-equals.md)

## Oppgave 7 - Referanser

I Java er objektvariabler egentlig *referanser* til objekter, ikke selve objektene. Dette er et viktig konsept å forstå.

>:question: **Referanse**. En referanse er en "peker" til et objekt i minnet. Når du skriver `Pokemon p = new Pokemon("Pikachu", 100, 10)`, holder variabelen `p` en referanse (adresse) til Pokémon-objektet, ikke selve objektet.

### Deloppgave A - Aliasing

Når du tilordner en objektvariabel til en annen, kopierer du *referansen*, ikke objektet. Begge variablene peker da til det samme objektet.

>:question: **Aliasing**. Når to eller flere variabler refererer til det samme objektet kalles det aliasing. Endringer gjennom én variabel vil påvirke objektet som alle variablene peker på.

Se på følgende kode:
```java
Pokemon a = new Pokemon("Pikachu", 100, 10);
Pokemon b = a;  // b peker nå til SAMME objekt som a
b.takeDamage(20);
System.out.println(a.getCurrentHP()); // Hva skrives ut?
```

Siden `a` og `b` peker til samme objekt, vil skaden påført via `b` også sees via `a`. Begge variablene refererer til den *samme* Pokémon'en!

**Tenk over:** Hva skrives ut i eksempelet over? Prøv å kjøre koden i `Main.java` for å verifisere svaret ditt.

<br></br>
### Deloppgave B - Kopier

Noen ganger ønsker vi å lage en ekte kopi av et objekt - et helt nytt objekt med samme verdier. Da må vi eksplisitt opprette et nytt objekt.

**TODO: Implementer `copy()`-metoden i `Pokemon.java`.**

Metoden skal:
- Opprette og returnere en *ny* `Pokemon` med samme navn, maxHP og strength som `this`
- Den nye Pokémon'en skal starte med full HP (akkurat som en nyopprettet Pokémon)

```java
Pokemon copy() {
    // Opprett og returner en ny Pokemon med samme verdier
}
```

<br></br>
### Deloppgave C - Forskjellen mellom referanse og kopi

Etter at du har implementert `copy()`, prøv følgende i `Main.java`:

```java
Pokemon original = new Pokemon("Pikachu", 100, 10);
Pokemon referanse = original;  // Samme objekt
Pokemon kopi = original.copy();  // Nytt objekt

original.takeDamage(50);

System.out.println("Original: " + original.getCurrentHP());
System.out.println("Referanse: " + referanse.getCurrentHP());
System.out.println("Kopi: " + kopi.getCurrentHP());
```

**Tenk over:** Hva skrives ut for hver linje? Hvorfor er det forskjell på `referanse` og `kopi`?

<br></br>
### Ekstra: Sjekke om to variabler refererer til samme objekt

I Java kan du bruke `==` for å sjekke om to objektvariabler refererer til *samme* objekt:

```java
Pokemon a = new Pokemon("Pikachu", 100, 10);
Pokemon b = a;
Pokemon c = a.copy();

System.out.println(a == b);  // true - samme objekt
System.out.println(a == c);  // false - ulike objekter (selv om de har like verdier)
```

> :bulb: **Tips:** Vil du lære mer om referanser og minne? Sjekk ut [ekstra-materialet om referanser og likhet](./ekstra-referanser_og_likhet.md).

<br></br>
✅ Denne oppgaven er fullført når testene `referenceTest`, `copyCreatesNewObjectTest` og `copyHasSameValuesTest` i `PokemonTest.java` passerer.
