**🔙 [Forrige](guide/01-drawTetris.md) • [📜 Oversikt](sem1-tetris/..) • [🔜 Neste](guide/03-tegnbrikke.md)**


# **✅ Testing av `TetrisBoard`**  

Er programmet vårt feilfritt hvis vi kjører det og alt ser riktig ut? **Nei!** 🚨  

Det kan fungere greit helt i starten, men etter hvert som vi legger til mer kompleksitet, blir det vanskelig å sjekke alt manuelt. **Vi trenger tester.**  

---

## **🛠️ TODO – `isFree`**  

Som vi lærte i **Lab 4**, er det sjeldent vi skriver unit-tester for grafikk. I stedet skal vi fokusere på testing av brettet og modellen.
Vi skal lage en metode i TetrisBoard slik at vi enkelt kan verifisere innholdet i modellen uten å måtte tolke grafikken.

### **📌 Implementer `isFree` i `TetrisBoard`**  

Legg til denne metoden i `TetrisBoard`:  

```java
public boolean isFree(CellPosition pos) {
	TODO: implement this
}
```



## **🛠️ TODO – Test `TetrisBoard`**  

Vi skal bruke denne metoden en del gjennom resten av utviklingen for å teste forskjellige metoder.  

### **📌 Opprett `TetrisBoardTest` og legg til denne testen:**  

```java
	@Test
	void testConstructStartsWithEmpty() {
		int rows = 3;
		int cols = 5;
		Grid grid = new Grid(rows,cols,'-');
		TetrisBoard board = new TetrisBoard(grid);
		int countFree=0;
		int countTaken=0;
		...
		assertEquals(rows*cols, countFree);
		assertEquals(0, countTaken);
	}
```
Bytt ut `...` med linjer som får testen til å passere.

Legg til et par tester til som tester følgende metoder:

- konstruktørene
- iterator()
- positionIsOnGrid()
- isFree()

Hint: du kan få noen ideer av å se på `GridTest.java`

---

## **✅ Fullført?**  

Du kan gå videre når:  
✔️ `isFree` fungerer 
✔️ `TetrisBoardTest` har nok gode tester som passerer uten feil  

**🔙 [Forrige](guide/01-drawTestris.md) • [📜 Oversikt](sem1-tetris/..) • [🔜 Neste](guide/03-tegnbrikke.md)**
