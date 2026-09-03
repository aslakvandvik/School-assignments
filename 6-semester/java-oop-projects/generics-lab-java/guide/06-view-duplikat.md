[forrige](./05-grid.md) &bullet; [oversikt](../README.md#steg-for-steg)

## Oppgave 6: Fjern duplikat kode i View-klassene

I oppgave 1 la du merke til at ``ColorGrid`` og ``TextGrid`` hadde mye duplikat kode, og i oppgave 2-5 løste vi dette med generics. Men sammenlign ``ColorGridView`` og ``TextGridView`` nå — de har nesten identisk kode! Feltvariabler, ``paintComponent()``, ``drawGrid()`` — alt er likt. Den eneste reelle forskjellen er ``drawCells()``.

Generics alene kan ikke fjerne denne duplikaten, fordi ``drawCells()`` må gjøre forskjellige ting for ``Color`` og ``String``. Men vi kan bruke **arv** til å trekke ut den felles koden i en abstrakt superklasse.

### Del A: Abstrakt superklasse

**TODO:**
* Lag en ny abstrakt klasse ``GridView`` som utvider ``JPanel`` og er generisk (``<T>``).

* Flytt den felles koden fra ``ColorGridView`` og ``TextGridView`` inn i ``GridView``:
  - Feltvariabelen ``grid`` (med type ``IGrid<T>``)
  - Konstantene ``OUTERMARGIN`` og ``MARGINCOLOR``
  - ``paintComponent()``-metoden
  - ``drawGrid()``-metoden

* Merk at ``INNERMARGIN`` og ``preferredSize`` har **forskjellige verdier** i de to klassene. Disse kan ikke være konstanter i superklassen. Ta de heller inn som parametere i konstruktøren til ``GridView`` og lagre ``INNERMARGIN`` som en feltvariabel.

* Legg til en abstrakt metode som subklassene må implementere for å tegne cellene. ``drawGrid()`` i superklassen kaller denne metoden i stedet for en lokal ``drawCells()``.

* Endre ``ColorGridView`` slik at den utvider ``GridView<Color>`` i stedet for ``JPanel``. Fjern all kode som nå ligger i superklassen — det eneste som skal være igjen er konstruktøren (som kaller ``super(...)``) og ``drawCells()``. Gjør det samme for ``TextGridView`` med ``GridView<String>``.

<br>

### Del B: Refleksjon

Det finnes en helt annen tilnærming som ikke bruker arv. I stedet for å la subklasser overstyre ``drawCells()``, kan man sende inn selve tegne-logikken som en parameter til én enkelt klasse.

* Tenk over: Hvordan kunne du løst dette med kun én klasse og ingen subklasser? Hva er fordeler og ulemper sammenlignet med løsningen i Del A? Diskuter gjerne med en medstudent eller gruppeleder.

<br>

✅ Denne oppgaven er fullført når ``ColorGridView`` og ``TextGridView`` utvider ``GridView<T>``, all duplikat kode er fjernet, og programmet kjører som før.

## ✅ Denne laben er fullført når alle testene passerer og begge gridene vises korrekt.
