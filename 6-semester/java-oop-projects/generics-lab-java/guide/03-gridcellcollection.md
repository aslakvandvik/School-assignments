[forrige](./02-gridcell.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./04-igrid.md)

## Oppgave 3: Gjør CellColorCollection og CellTextCollection generisk

I denne oppgaven skal vi ta grensesnittene `CellColorCollection` og `CellTextCollection` og erstatte disse med det generiske `GridCellCollection`.

**TODO:**
* Opprett interfacet ``GridCellCollection<T>`` og bruk strukturen i ``CellColorCollection`` og `CellTextCollection` til å definere de metodene i ``GridCellCollection`` slik at det blir generisk.


* Returtypen til getCells() skal være en liste av ``GridCell`` med samme generiske type som vi har satt på klassen.

* Pass på at dokumentasjonen fortsatt passer til grensesnittet. Om ikke, rett opp i det.

* Slett interfacene `CellColorCollection` og `CellTextCollection` og fiks opp slik at koden kompilerer igjen.

>:question: **T**. Merk deg at vi her bruker samme bokstav for den generiske typen som i `GridCell` klassen, og det er også dette testene i denne laben bruker. Men i et fritt prosjekt kan man bruke den bokstaven man vil, også om disse er forskjellige mellom klassene. Dette er fordi den generiske typen er lokal for klassen den tilhører. Det er kun om du vil representere flere forskjellige generiske typer i samme klasse at du må bruke forskjellige bokstaver. Et eksempel på dette er en ``Pair<A,B>`` klasse, hvor A og B representerer to forskjellige generiske typer som vi setter i et par.

Deklarasjonen til `GridCellCollection` burde nå se slik ut:
```Java
public interface GridCellCollection<T>
```

✅ Denne oppgaven er ferdig når du har gjort om ``CellColorCollection`` og `CellTextCollection` til det generiske grensesnittet ``GridCellCollection``, koden kompilerer og du kan kjøre koden slik at det samme som før vises på skjermen. Grensesnittet blir testet i oppgave 5.