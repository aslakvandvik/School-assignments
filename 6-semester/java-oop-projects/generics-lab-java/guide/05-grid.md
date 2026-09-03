[forrige](./04-igrid.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./06-view-duplikat.md)

## Oppgave 5: Gjør ColorGrid generisk

Vi er endelig kommet fram til å lage et generisk `Grid` som kan erstatte `ColorGrid` og `TextGrid`. Denne nye, generiske klassen `Grid` kommer til å være nyttig videre i OOP.

**TODO:**
* Opprett ``Grid`` som en generisk klasse.

* La Grid implementere grensesnittet, ``IGrid``.

* Legg inn kode fra `ColorGrid` / `TextGrid` der de spesifike typene er erstattet med generiske alternativer. Dette inkluderer feltet ``List<List<Color>> data``, konstruktørparameteren, og alle metoder som bruker ``Color``/`String` eller ``CellColor``/`CellText`. Hva tenker du skal stå i stedet for disse?
(Hint finner du i testene)

* Slett `IColorGrid`, `ITextGrid`, `ColorGrid` og `TextGrid`, fiks slik at all koden kompilerer.

## Test

Lim inn alle testmetodene fra [denne filen](./test-05.md) i `GridTest.java` der det står `// PASTE HERE`. Pass på at hvis de ikke passerer kan det skyldes feil fra oppgave 3 eller 4 også, siden vi tester ``GridCellCollection``, ``IGrid`` og ``Grid`` samtidig.

✅ Denne oppgaven er ferdig når du har gjort ColorGrid om til den generiske ``Grid`` klassen, og de innlimte testene kjører og passerer. Samt at både `ColorGridView` og `TextGridView` bruker generiske grids og du ikke har kompileringsfeil og kan kjøre ``Main.java`` og få opp to forskjellige grafiske representasjoner av Grid.