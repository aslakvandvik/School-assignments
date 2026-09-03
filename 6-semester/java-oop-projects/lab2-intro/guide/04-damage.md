[forrige](./03-toString.md)  &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./05-attack.md)

## Oppgave 4 - `takeDamage`
Implementer metoden `takeDamage`. Metoden skal trekke i fra `damageTaken` fra antall `healthPoints` Pokémon'en har. Man kan ikke ha færre enn 0 `healthPoints`. Det skal ikke være mulig å gi negative skade, altså øke antall health points.

Metoden skal skrive ut (ikke returnere):
```
Pikachu takes 3 damage and is left with 84/94 HP
```
(I dette tilfellet er Pikachu pokémon'en som tar skade).

Implementer metoden `isAlive`.

✅ Denne oppgaven er fullført når `healthPointsTest`, `damageTest`, `cannotInflictNegativeDamage`, `hpNotBelowZeroTest1`, `hpNotBelowZeroTest2` og `isAliveTest` passerer.