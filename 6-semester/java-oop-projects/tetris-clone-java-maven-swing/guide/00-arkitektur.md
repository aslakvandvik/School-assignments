**[📜 Oversikt](sem1-tetris/..) • [🔜 Neste](guide/01-drawTetris.md)**  


# **🛠️ Hvordan skal vi strukturere koden?**  

Dette prosjektet er større enn de vi har jobbet med tidligere, og det er derfor ekstra viktig at vi holder koden ryddig og godt strukturert. For å oppnå dette skal vi bruke designmønsteret **MODEL-VIEW-CONTROLLER (MVC)**.  

MVC-prinsippet hjelper oss med å skille mellom:  
- **Modellen** – logikken for hva programmet skal gjøre.  
- **Visningen** – hvordan modellen tegnes på skjermen.  
- **Kontrolleren** – hvordan brukeren samhandler med modellen.  

---

## **📌 Oversikt**  

Her er en oversikt over koden vi skal skrive. Dette er **ikke** en steg-for-steg-oppskrift du skal følge nå, men en introduksjon til hvordan vi strukturerer koden. De nødvendige stegene kommer på de neste sidene i guiden.

### **🧩 Modell (Model)**  
For å representere Tetris trenger vi to sentrale elementer:  
- Et **brett** med ruter.  
- En **fallende brikke**.  

Vi definerer følgende klasser i pakken `oop.tetris.model`:  
- **`TetrisModel`** – representerer logikken i spillet og holder styr på brettet, den fallende brikken og om spillet er over.  
- **`TetrisBoard`** – representerer rutenettet brettet består av.  
- **`Tetromino`** – representerer en Tetris-brikke.  

Modellen er den viktigste delen av koden, og vi må sikre at den er **godt testet**.  

### **🎨 Visning (View)**  
For å tegne modellen lager vi klassen `TetrisView` i pakken `oop.tetris.view`. Denne klassen skal:  
1. Tegne brettet.  
2. Tegne den fallende brikken over brettet.  

For å unngå uønskede endringer i modellen når vi tegner den, definerer vi et grensesnitt `ViewableTetrisModel` i `oop.tetris.view`, som spesifiserer hvilke metoder `TetrisView` har tilgang til. `TetrisModel` implementerer dette grensesnittet, men `TetrisView` vil aldri vite at den jobber direkte med `TetrisModel`.  

### **🎮 Kontroller (Controller)**  
For å håndtere brukerinput og styre automatisk fallende brikker lager vi klassen `TetrisController` i pakken `oop.tetris.controller`. Denne klassen:  
- Endrer modellen basert på tastetrykk fra brukeren.  
- Styrer hvordan brikken faller automatisk over tid.  

For å holde modellen innkapslet definerer vi grensesnittet `ControllableTetrisModel` i `oop.tetris.controller`, som beskriver hvilke metoder kontrolleren trenger. `TetrisModel` implementerer dette grensesnittet, slik at `TetrisController` kan styre modellen uten å ha direkte tilgang til all dens funksjonalitet.  

---



**[📜 Oversikt](sem1-tetris/..) • [🔜 Neste](guide/01-drawTetris.md)**  