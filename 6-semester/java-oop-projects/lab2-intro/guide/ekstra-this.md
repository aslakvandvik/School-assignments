[Tilbake til oppgave 5 - `attack`](./05-attack.md)

## Hva er `this`?

`this` brukes for at et objekt skal kunne referere til seg selv i sin egen klasse. Utenfor klassen får objektet et alias, for eksempel:
```java
Pokemon mew;
```
Men objektet selv vet ikke hva aliaset er, så for å ha et navn for seg selv bruker den `this`. Dette er ofte nyttig for å hindre forvirring når man skal behandle et annet objekt samtidig som seg selv, slik man gjør i `attack`-metoden i denne oppgaven. Da er det lettere å unngå å forvirre din egen HP med `target` sin HP, for eksempel.