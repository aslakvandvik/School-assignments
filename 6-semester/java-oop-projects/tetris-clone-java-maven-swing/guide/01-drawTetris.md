**🔙 [Forrige](guide/00-arkitektur.md) • [📜 Oversikt](sem1-tetris/..) • [🔜 Neste](guide/02-testBoard.md)**

## **✅ Implementer Grid**  
I **Lab 5** har vi allerede laget en **grid-datastruktur** kopier inn din fil `Grid.java` fra Lab 5.
  
- Vi har laget en **visning av rutenettet**.  

Når du har kopiert inn rett kode i `Grid.java` skal følgende tester passere:
 - `CellPositionTest`
 - `GridTest`
 - `GridCellTest`

---

# **🎨 TetrisView **  
Vi har allerede kode for å tegne et grid fra Lab 5, der kallte vi det ´GridView´ nå kaller vi det (`TetrisView`).

Vi skal følge **Model-View-Controller (MVC)**-designmønsteret, `TetrisView` er ferdig laget og representerer View delen av designmønsteret.  

For å tegne hva som skjer på brettet, skal vi bruke noen ekstra klasser som hjelper oss med å holde koden ryddig:  

- **🟦 `TetrisBoard`** – Representerer selve brettet, basert på `Grid`. Denne klassen håndterer **hvordan celler legges til og fjernes**, for eksempel når en rad fylles opp og forsvinner.  
- **🎮 `TetrisModel`** – Hovedklassen som styrer reglene for spillet og holder oversikt over spillets tilstand.  

---

## **🛠️ TODO – Implementer `TetrisBoard`**  

✅ opprett `TetrisBoard` i pakken `no.uib.this OOP course.tetris.model`, denne klassen skal implementere de to interfacene ´Iterable´ og ´GridDimension´.

```java
public class TetrisBoard implements Iterable<GridCell>, GridDimension {
  ...
}
```

✅ For å hjelpe oss med å representere et TetrisBoard trenger vi en feltvariabel av typen IGrid.
Vi velger tegnet '-' til å representere en tom celle på brettet.

✅ Lag to konstruktører, en som tar inn et `IGrid` objekt og en som tar inn to parametre: `rows` og `cols`, som definerer størrelsen på brettet.

Hint: Når det er 2 konstruktører kan vi unngå duplikat kode ved at en konstruktør kaller på den andre ved å bruke:

```java
public TetrisBoard(...){
	this(...);
}
```

✅ Implementer metodene spesifisert i interfacene som TetrisBoard implementerer.
Gjenbruk mest mulig kode ved å kalle på metoder fra IGrid.

---

## **🛠️ TODO – `TetrisModel`**  

`TetrisModel` er knutepunktet mellom **TetrisBoard** og **TetrisView** (visningen).  

- Opprett et `TetrisBoard`-objekt som en **feltvariabel** og instansier den i `TetrisModel` sin konstruktør.  
- Bestem hvor stort brettet skal være. Noen gode verdier kan være 15 rader og 10 kolonner.

## **🛠️ TODO – `TetrisView`**  
TetrisView er nesten ferdig laget, du skal bare kopiere fra koden din for Lab 5 inn i metoden `drawCells`.

---

## **✅ Fullført? Sjekk dette!**  

Du vet at du har fullført dette steget når du kan kjøre `Main`, og du ser **et Tetris-brett på skjermen**, akkurat som i Lab 5.  

For å sjekke at brettet tegnes riktig, kan du legge til noen test-celler i `TetrisMain`:  

```java
	Grid grid = new Grid(15,10,'-');
	grid.set(new CellPosition(0, 0), 'r'); // Rød i øvre venstre hjørne
	grid.set(new CellPosition(grid.rows()-1, 0), 'b'); // Blå i nedre venstre hjørne
	grid.set(new CellPosition(0, grid.cols()-1), 'y'); // Gul i øvre høyre hjørne
	grid.set(new CellPosition(grid.rows()-1, grid.cols()-1), 'w');   // Hvit i nedre høyre hjørne		
	TetrisBoard board = new TetrisBoard(grid);
```

Når du kjører programmet, bør du se fire fargede celler i hjørnene av brettet. 🎨
Kommenter ut de 4 linjene igjen når du vet at tegningen fungerer som den skal.  

---

## **🛠️ TODO – `ViewableTetrisModel`**  

For å følge MVC-prinsippet har vi opprettet et interface `ViewableTetrisModel`.  

🔹 **Hva er poenget?**  
Dette interfacet lar `TetrisView` hente informasjon om brettet, **uten å kunne endre det**. Det betyr at:  
✅ `TetrisView` kan tegne brettet.  
❌ `TetrisView` kan *ikke* endre brikkene eller reglene i spillet.

`TetrisView` vil kun ha tilgang til metodene i `TetrisModel` som har med visning å gjøre, ikke noe som tillater den å gjøre endrigner på modellen, f.eks. som å fjerne rader.

`TetrisModel` implementerer allerede `ViewableTetrisModel`, men vi må fremdeles fylle ut disse metodene:  

- **`getDimension`** – Skal returnere et objekt av typen `GridDimension`. Har vi et slikt objekt?  
- **`getTilesOnBoard`** – Skal returnere et objekt av typen `Iterable<GridCell>`. Har vi et slikt objekt?


**🔙 [Forrige](guide/00-arkitektur.md) • [📜 Oversikt](sem1-tetris/..) • [🔜 Neste](guide/02-testBoard.md)**