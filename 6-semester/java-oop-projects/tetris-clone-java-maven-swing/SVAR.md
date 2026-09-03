For å fullføre laben, ber vi deg om å svare på følgende spørsmål. Svar på spørsmålene ved å fylle ut denne filen. 

## Forklar hvordan du har brukt grensesnitt til å gjenbruke kode i TetrisView.

I `TetrisView` har jeg brukt grensesnitt for å kunne tegne forskjellige ting på samme måte. Både brettet og den aktive brikken blir behandlet som `Iterable<GridCell>`, så jeg kan bruke den samme metoden, `drawCells(...)`, til å tegne begge deler. Da slipper jeg å skrive én metode for brettet og en annen for tetrominoen.

Jeg har også brukt grensesnittet `ViewableTetrisModel` i stedet for å la visningen kjenne til hele `TetrisModel`. På den måten trenger `TetrisView` bare å vite hvilke data den kan lese, som dimensjoner, rutene på brettet, den aktive brikken, score og game state. Dette gjør at visningen blir enklere å gjenbruke og mindre avhengig av den konkrete modellen.

## Både Tetromino og Grid implementerer Iterable<GridCell>, men på hver sin måte, forklar forskjellen og hvorfor dette er viktig.

Forskjellen er at `Grid` itererer over alle rutene i hele brettet, også de som er tomme. `Tetromino` itererer derimot bare over rutene som faktisk hører til brikken. For en O-brikke får jeg derfor bare de fire rutene som er fylt, og ikke alle posisjonene i figurens interne matrise.

Dette er viktig fordi brettet og brikken brukes til ulike ting. Når jeg tegner brettet, trenger jeg å gå gjennom alle ruter for å kunne vise både tomme og fylte celler. Når jeg jobber med en tetromino, er jeg bare interessert i cellene som faktisk er en del av brikken, for eksempel ved tegning, flytting, kollisjonssjekk og når brikken skal limes fast på brettet. Ved at begge implementerer `Iterable<GridCell>`, kan jeg likevel bruke samme type løkker og samme type hjelpemetoder flere steder i programmet.

## Forklar hvordan du har brukt grensesnitt for å opprettholde MVC-arkitekturen og sikre at visningen ikke kan påvirke logikken i modellen.

For å holde på MVC-arkitekturen har jeg delt modellen opp i ulike grensesnitt avhengig av hvem som bruker den. `TetrisView` får bare tilgang til `ViewableTetrisModel`, som bare inneholder metoder for å lese data. Dermed kan visningen ikke flytte brikker, endre score eller påvirke spilltilstanden direkte.

Kontrolleren bruker i stedet `ControllableTetrisModel`, som inneholder metodene som trengs for å styre spillet, som å flytte, rotere, droppe og håndtere ticks fra timeren. På denne måten er ansvaret delt tydelig: visningen viser bare tilstanden, kontrolleren håndterer input, og modellen inneholder logikken. Dette gjør også koden lettere å teste og vedlikeholde.

## Forklar hvordan du har gjort Tetromino uforanderlig og hvorfor dette er viktig for å sikre at spillet fungerer som forventet.

Jeg har gjort `Tetromino` uforanderlig ved at feltene er `final`, og ved at objekter ikke blir endret etter at de er opprettet. I stedet lager metoder som `shiftedBy(...)`, `shiftedToTopCenterOf(...)`, `rotated()` og `rotatedCounterClockwise()` en ny `Tetromino` og returnerer den. Den gamle brikken blir altså ikke endret.

I tillegg kopierer konstruktøren figurmatrisen, slik at ingen utenfra kan endre den samme matrisen og dermed forandre brikken indirekte.

Dette er viktig fordi spilllogikken hele tiden tester mulige nye tilstander. For eksempel når en brikke skal flyttes eller roteres, kan modellen først lage en ny variant og sjekke om den er gyldig. Hvis den ikke er gyldig, kan den gamle brikken beholdes helt uendret. Det gjør logikken tryggere, mer forutsigbar og enklere å feilsøke.
