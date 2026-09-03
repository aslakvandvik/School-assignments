[forrige](./04-damage.md)  &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./06-pokemon_battle.md)

## Oppgave 5 - `attack`
Implementer metoden `attack`. Metoden skal utføre et angrep på `target`. Hvor mange health points som skal tas fra `target` baseres på Pokémon'ens strength og tilfeldighet. Her kan du bruke denne kodesnutten:
```
Random rand = new Random();
int damageInflincted = rand.nextInt(this.strength+1);
```
Du kan lese dokumentasjonen til **Random** og `nextInt` hvis du vil vite mer om hva som skjer her.

Deretter skal metoden trekke i fra `damageInflincted` fra `target` sine health points. Print ut den følgende linjen:
```
Oddish attacks Pikachu.
```
(I dette tilfellet er Oddish `this` og Pikachu target).
>:question: [Klikk her for å lese mer om `this`](./ekstra-this.md)

Hvis `target` ikke er levende etter angrepet skal metoden skrive ut:
```
Pikachu is defeated by Oddish.
```

✅ Denne oppgaven er fullført når `attackTest` og `attackDefeatTest` passerer.
