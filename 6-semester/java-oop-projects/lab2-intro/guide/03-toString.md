[forrige](./02-getter_og_hjelpemetoder.md)  &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./04-damage.md)

## Oppgave 3 - `toString`

Implementer `toString`. Denne metoden lager en string-representasjon av *datatypen*.

> :question: **Datatype**. Et objekt vil alltid ha sin egen klasse som datatype (vi skal lære mer om hvilke andre typer et objekt kan ha senere). En Pokemon har typen Pokemon, og en int har typen int. Å lage en string-representasjon av en int vil vere så enkelt som å skrive tallet i tekstform.

En pokémon ønsker vi å representere slik:
```
Mew HP: (??/??) STR: ??
```
Her er navnet til pokémonen *Mew*. Spørsmålstegnene inni parentesene skal byttes ut med `healthPoints` og `maxHealthPoints`. Spørsmålstegnene etter "STR:" skal byttes ut med `strength`.

Det kan for eksempel se slik ut når vi har konkrete verdier:

```
Mew HP: (25/50) STR: 12
```

✅ Denne oppgaven er fullført når `toStringTest` i `PokemonTest.java` passerer.
