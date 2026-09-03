**🔙 [Forrige](guide/04-flyttebrikke.md) • [📜 Oversikt](sem1-tetris/..) • [🔜 Neste](guide/06-droppebrikke.md)**

# 5 Rotere brikken 🔄

Når du er ferdig med dette steget, kan du rotere brikken ved å trykke på pil-opp-tasten. ⬆️

[<img src="./pics/rotatePiece.gif" width="300">](./pics/rotatePiece.gif)

## Oppgaver

1. I `Tetromino`-klassen, opprett en metode for å lage en rotert kopi av seg selv. 🛠️
2. Begynn med å skrive testene for dette i *TestTetromino*: skriv for eksempel en test for `T`-brikken. ✅

![Illustrasjon av rotasjon](./pics/rotation.png)

Illustrasjonen viser rotasjon av et rutenett generelt.

> **Hint:** Opprett en ny `boolean[][]` i riktig størrelse og benytt en dobbel for-løkke over rad og kolonne i den nye fasongen. For hver posisjon (r, c) regn ut hvilken posisjon dette tilsvarer i den originale fasongen, og hent verdien derfra. 🧩
>
> ***Q:** Hvilken verdi skal ruten (r, c) i rotert fasong ha?*
> **A:** Samme verdi som (oldRow, oldCol) i original fasong, der
> oldRow = ... (sett inn matematisk uttrykk her)
> oldCol = ... (sett inn matematisk uttrykk her).
> For eksempel: hvis (r, c) er (2, 3) og bredden på original fasong er 4, da er (oldRow, oldCol) = (3, 1) 📏

Når testen din for rotasjonen passerer, er du klar til å fortsette:

3. I `ControllableTetrisModel` definerer vi en metode for å rotere brikken. 🔄
4. I `TetrisController` kaller vi overnevnte metode når brukeren trykker pil opp. ⬆️
5. I `TetrisModel` implementerer vi metoden på samme måte som vi gjorde for flyttingen: henter en rotert kopi, sjekker om den er lovlig, og hvis ja: oppdater feltvariabelen. 🔍
6. I `TetrisModelTest`, skriv en metode som tester metoden som roterer den fallende tetrominoen. ✅

---

:white_check_mark: Du er ferdig med dette steget når du kan rotere brikken ved å trykke på pil-opp-tasten. Pass på at du ikke kan rotere brikken "ut av brettet," at brikken ikke kan rotere slik at den legger seg oppå en fargelagt rute, at alle brikkene (også I-brikken) roterer rundt omtrent sentrum av seg selv, at alle brikkene kommer tilbake til nøyaktig samme posisjon etter fire rotasjoner, og at O-brikken ikke flytter på seg under rotasjon. 🎉

### Frivillig 💡

Implementer den offisielle rotasjonen [super rotation system](https://tetris.fandom.com/wiki/SRS), hvor det er mulig å «sparke fra» når man roterer i nærheten av en vegg. 🧱

**🔙 [Forrige](guide/04-flyttebrikke.md) • [📜 Oversikt](sem1-tetris/..) • [🔜 Neste](guide/06-droppebrikke.md)**
