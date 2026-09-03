forrige &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./02-getter_og_hjelpemetoder.md)

## Oppgave 1 - Feltvariabler og konstruktør
### Deloppgave A - Feltvariabler
Klassen `Pokemon.java` skal definere datatypen Pokémon. Foreløpig har den kun et sett med tomme metoder. Disse skal vi *implementere*.

>:question: **Implementere**.  Å iverksette, utføre eller
realisere. Implementere blir særlig brukt om å gjøre det 
som er nødvendig for å få en datamaskin eller et dataprogram
til å virke ([snl](https://snl.no/implementere)).

Det første vi skal implementere er dens tilstand, aka. dens *feltvariabler*.

>:question: **Feltvariabler**. De variablene som tilhører et objekt og beskriver dets tilstand. Disse skrives oftest i toppen av klassen til objektet. En passende feltvariabel for en bil vil for eksempel være hastighet.


**TODO: Opprett feltvariablene:**
 * `name` - Navnet til Pokémon'en
 * `healthPoints` - *Health points* er hvor mye liv Pokémon'en har
 * `maxHealthPoints` - Hvor mange *health points* Pokémon'en kan maksimalt ha (og starter med)
 * `strength` - Hvor sterk Pokémon'en er
 
<br></br>
### Deloppgave B - Konstruktør
Konstruktøren i en klasse er en metode som oppretter et objekt av den datatypen. Den kan ha parametere for å spesifisere hvordan objektet skal være. I vårt tilfelle skal vi bruke konstruktøren til å lage en pokemon med et gitt navn, maks healthPoints og strength. <br></br>
**TODO: Implementer en konstruktør som tar inn tre argument: `String name`, `int healthPoints` og  `int strength`** (Pass på rekkefølgen, ellers blir det feil i testene!). Konstruktøren skal initiere feltvariablene. Husk at når pokemonen starter, skal `healthPoints` vere lik `maxHealthPoints`.   <br></br>

> :question: **Initiere** betyr her å lage objektene som tilhører feltvariablene, og gi de verdier. Ofte settes feltvariablenes verdi lik det tilhørende argumentet i konstruktøren.

✅ Denne oppgaven er fullført når alle feltvariabler er initiert og det er ingen syntax error i `PokemonTest.java`.
