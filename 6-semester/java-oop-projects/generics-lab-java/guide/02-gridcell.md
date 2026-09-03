[forrige](./01-textgrid_vs_colorgrid.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./03-gridcellcollection.md)

## Oppgave 2: Gjør CellColor og CellText generisk

Når vi ser på klassediagramet i oppgave 1 oppdager vi at `CellColor` og `CellText` er veldig like, vi skal erstatte disse to med en Generisk klasse vi kaller `GridCell`. Vi starter med `CellColor`, som vi endrer til: `GridCell`.

**TODO:**
* Lag et nytt record som heter `GridCell`. Denne skal være nesten identisk til `CellColor` 

Merk at din IDE sannsynligvis kan gjøre refakturering for deg, det vil si at den kan f.eks. gi nytt navn til en fil, I VSCode gjøres dette ved å høyreklikke på filnavnet og trykke "rename". Men når du gjør det får du ikke vite hvor det ble gjort endringer og dermed forstår du mindre av hvorfor vi gjør endringene.

* Gjør GridCell generisk ved å legge inn `<T>` etter `GridCell` i record-deklarasjonen og bytt ut typen til den andre parameteren i konstruktøren med `T`. Se under for hvordan den bør se ut.

>:question: **Deklarasjon**. Med dette mener vi den delen av en struktur i Java (en metode, klasse, grensenitt, record osv.) som inneholder nøkkelord som public/private, returtype (for metoder), implementerte eller utvidede grensesnitt (for klasser og grensesnitt) og annet.

* Gi argumentet med den generiske typen `T` det mer passende navnet "elem" (kort for "element"). Oppdater dokumentasjonen slik at den passer.

>:question: **T**. Her bruker vi bokstaven T som et alias for en vilkårlig type. Du kan bruke andre bokstaver i stedet for T, men det er vanlig å bruke T for en generisk type som dette.

Recorden `GridCell` burde nå se slik ut (hvor vi har valgt "elem" som navn på det generiske argumentet):
```Java
public record GridCell<T>(CellPosition pos, T elem) {}
```

Vi skal nå slutte å bruke CellColor og CellText så slett disse filene.
Nå vil ikke koden kompilere lenger.
Finn alle stedene koden ikke kompilerer og erstatt CellColor og CellText med en GridCell som har rett parameter.

## Test
* Sett inn denne testen i den tomme testklassen `GridCellTest.java` som ligger i testmappen under pakken `no.uib.oop.datastructure`. Hvis alt er gjort riktig skal testen passere og heller ikke gi røde streker eller kompilasjonsfeil:

```Java
@Test
public void sanityTest() {
    GridCell<Integer> integerCell = new GridCell<Integer>(new CellPosition(5, 2), 40);
    assertEquals(40, integerCell.elem(), "element is null or not equal");
    CellPosition expectedPosition = new CellPosition(5, 2);
    assertEquals(expectedPosition, integerCell.pos(), "position is null or not equal");
}
```

✅ Denne oppgaven er ferdig når GridCell er generisk og den innlimte testen `GridCellTest::sanityTest()` passerer og du igjen kan kjøre Main og få opp noe på skjermen.
