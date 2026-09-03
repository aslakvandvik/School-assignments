**🔙 [Forrige](guide/08-timer.md) • [📜 Oversikt](sem1-tetris/..)**


# 9 Flere idéer 💡

Her er noen idéer for videre utvikling. Dere kan også gjøre hva enn dere vil! 🎉

**Enkle:**
- Økende vanskelighetsgrad: Legg til nivåer i spillet! Du kan for eksempel ha en feltvariabel for antall rader fjernet totalt som du oppdaterer i metoden som limer en brikke til brettet; så kan du regne ut hva nivået bør være basert på den. Deretter kan du endre metoden som angir hvor lang tid det skal gå mellom hvert klokkeslag slik at returverdien blir basert på nivået. 📈
- Vis poeng ved game over: Hver gang man fjerner en eller flere rekker, får man poeng! Vanligvis får man 100 poeng for å fjerne én linje, 300 poeng for å fjerne to linjer, 500 poeng for å fjerne tre linjer, og 800 poeng for å fjerne fire linjer. Poengsummen multipliseres med hvilket nivå man er på. Vis score ved game over! 🏆
- Vis poeng underveis, under eller ved siden av brettet. 🕹️
- Lag en velkomstskjerm (lignende game over) med "trykk ned for å begynne." Etter game over kan et trykk føre tilbake hit. 🎮
- En pause-skjerm for å ta en liten pause. ⏸️
- Rotering i to retninger for mer kontroll! 🔄

**Medium:**
- Vis en "skygge" av brikken der den vil lande dersom man dropper. 🌑
- Vis neste brikke som ankommer i en rute ved siden av brettet. 🔮
- Mykere flytting av brikken: Kombiner `keyPressed` og `keyReleased` med en timer som flytter tetrominoen (timeren startes i `keyPressed` og stoppes i `keyReleased`, og flytter tetrominoen med et fast intervall). 🕒
- Penere tegning av brikkene for en bedre visuell opplevelse! 🎨
- [Wall kicks](https://tetris.fandom.com/wiki/SRS#Wall_Kicks) for mer spennende spillmekanikk. 🚀

**Avansert:**
- Vis en oversikt over beste poengsummer oppnådd etter game over! Skriv inn navn i high score-listen (enda bedre: lagret mellom spill). 📜
- Poeng basert på [T-spin](https://tetris.fandom.com/wiki/T-Spin_Guide) for ekstra utfordringer. 💥
- Ulike game modes: Vanskeligste mulige brikker kommer *alltid*, random brikker fjernes eller flytter seg tidvis på brettet, osv. 🎲
- To-player-modus på ulike deler av tastaturet! Når en spiller fjerner noen rekker, legges de fjernede rekkene (slik de så ut før de ble fjernet) til *nederst* på motspillerens brett, og dytter de andre brikkene på brettet oppover. Rekker man har fått av motspiller på denne måten flyttes ikke tilbake igjen; de fjernes for godt når de blir fjernet. 🤼‍♂️

**For de ambisiøse som kan litt fra før:**
- High score på internett (delt mellom brukere?) 🌐
- Smud animasjon av brikker som flytter seg, animasjoner når rekker fjernes! ✨
- To-player over lokalt nettverk for enda mer moro. 🕹️💻

Eller noe helt annet! La kreativiteten flyte! 💭✨