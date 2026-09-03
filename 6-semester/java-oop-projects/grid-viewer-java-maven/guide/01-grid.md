# **Steg 1 – Implementering av Grid**  

I denne oppgaven skal du implementere klassene `Grid`, `CellPosition` og `GridCell` i pakken **no.uib.oop.grid**. Dette gridet skal fylles opp med datatypen `Character` (objektversjonen av `char`).
✅ **Målet er at alle medfølgende tester skal kjøre uten feil når implementasjonen er fullført.**  

---

## **Oppgavebeskrivelse**  

### **1️⃣ Implementer `CellPosition`**  
Opprett en **record-klasse** `CellPosition` med følgende felt:  
📌 `row` (int) – Radnummeret i gridet.  
📌 `col` (int) – Kolonnenummeret i gridet.  

### **2️⃣ Implementer `GridCell`**  
Opprett en **record-klasse** `GridCell` med følgende felt:  
📌 `pos` (CellPosition) – En instans av `CellPosition` som angir cellens plassering.  
📌 `symbol` (Character) – Tegnet som representerer cellen.  

### **3️⃣ Implementer `Grid`**  
Opprett klassen `Grid`, som representerer rutenettet. Denne klassen må implementere **grensesnittet `IGrid`**, som allerede er definert.

Noen av metodene som `Grid` må implementere er definert i interfacene  `GridDimension` og `Iterable` og så arver `IGrid` metodene fra disse så kommentarene til metodene finnes i den filen de er definert.

Her må du selv velge hvilken måte du representerer `Grid` på, dette snakket vi om på forelesning om abstraksjon.

### **🔹 Fremgangsmåte:**  
1. Opprett **alle metodene som kreves av `IGrid`**. I første omgang kan disse returnere **"dummy"-verdier** (f.eks. `0` eller `null`) for å sikre at koden kompilerer.  
2. Les **Javadoc-kommentarene i `IGrid`** og undersøk **testene i `GridTest`** for å forstå hvilke metoder og konstruktører som må implementeres.  

---

## **Implementering av `Iterable<GridCell>`**  
Grensesnittet `IGrid` utvider `Iterable<GridCell>`, noe som betyr at **`Grid` må implementere en `iterator`-metode**.

📌 **Foreslått løsning:**  
1. Opprett klassen `RowWiseGridIterator` og la denne implementere `Iterator<GridCell>`.  
2. Lag en feltvariabel `next` av typen `CellPosition` som starter på posisjon 0,0 og en av typen `IGrid`.
3. Metoden `hasNext()` sjekker om feltvariabelen `next` er innenfor grensene til gridet.
4. Metoden `next()` lagrer `next` i et midlertidig variabel så erstattes next med neste posisjon før den midlertidige variabelen returneres.  
5. Metoden `iterator()` i klassen `Grid` kan nå returnere en nytt objekt av typen `RowWiseGridIterator`


---

✅ **Oppgaven er fullført når alle testene i `CellPositionTest`, `GridCellTest` og `GridTest` passerer.**  
📌 **Husk å sjekke testene før du går videre!**  

🔙 [Tilbake til oversikt](../README.md#steg-for-steg) | 🔜 [Neste steg](./02-tegnrutenett.md)  
