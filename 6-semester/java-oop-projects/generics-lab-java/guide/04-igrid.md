[forrige](./03-gridcellcollection.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./05-grid.md)

## Oppgave 4: Gjør IColorGrid og ITextGrid generisk

Her skal vi, som i oppgave 3, ta et grensesnitt og gjøre det generisk.

**TODO:**
* Opprett ``IGrid<T>`` og kopier over fra `IColorGrid` og/eller `ITextGrid` de metodene IGrid trenger. 

* Sett samme `<T>` etter `GridCellCollection` for å vise at Grid'et skal inneholde samme type ``T`` som vi snakker om i GridCellCollection.

* Gjør slik at metodedeklarasjonene er generiske i stedet for å referere til ``Color`` eller ``String``. Oppdater dokumentasjonen.

✅ Denne oppgaven er ferdig når du har opprettet det generiske grensesnittet ``IGrid`` og filen kompilerer uten å ha noen referanser til `String` eller `Color`. Testing gjøres i [neste oppgave](./05-grid.md).

Merk at vi ikke ba deg slette `IColorGrid` og `ITextGrid`, det skjer i neste steg. Om du allerede har slettet disse vil koden ikke kompilere, men det ordner vi i neste steg.