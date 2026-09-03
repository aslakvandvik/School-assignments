forrige &bullet; [oversikt](../README.md) &bullet; [neste](02-if.md)

## INF100 Lab1 - Printing og innlesning

### Hvordan printe til terminalen i Java

Her er et eksempel på hvordan man printer til terminalen i Java:

```
System.out.println("Hello World!");
```

### Hvordan lese input fra brukeren i Java

I denne laben har vi laget en metode som leser input fra brukeren for deg. Du gir metoden et spørsmål den skal stille brukeren, og så
returneres det brukeren skriver inn. Her er et eksempel på hvordan du kan kalle på metoden.

```
readInput("How old are you?")
// Bruker skriver "20" i terminalen
// Metoden returnerer strengen "20"
```
> ❓ **Å kalle på en funksjon** betyr å bruke funksjonen et annet sted i programmet etter at den er
> implementert.

✅**Da er du klar for å begynne på INF100 Lab1. Lykke til!**

---
De følgende oppgavene er tatt fra lab1 INF100h22. Du finner de opprinnelige oppgavene her:
https://inf100h22.stromme.me/lab/1/

### Oppgave 1

Implementer metoden `Lab1::task1`. Metoden skal skrive ut akkurat følgende output i terminalen:

```
Hei, det er meg, datamaskinen.
Hyggelig å se deg her.
Lykke til med this OOP course!
```

> ❓ `::` er en operator som brukes til å kalle en metode ved hjelp av klassenavnet. Her brukes det til å referere til
> metoden `task1` i klassen `Lab1`.

### Oppgave 2

Implementer metoden `Lab1::task2`. Metoden skal gjøre følgende, i oppgitt rekkefølge:

1. Les inn brukerens navn ved å bruke `readInput`.
2. Les inn brukerens gatedresse ved å bruke `readInput`.
3. Les inn postkode og poststed ved å bruke `readInput`.
4. Printer "*navn*-s adresse er:"
5. Printer en tom linje
6. Printer navn og adresse slik man skriver det på et brev

Eksempelkjøring:

```
Hva er ditt navn?
Kari Nordmann
Hva er din adresse?
Gateveien 1
Hva er ditt postnummer og poststed?
1234 Stedet
Kari Nordmanns adresse er:

Kari Nordmann
Gateveien 1
1234 Stedet
```

For å lese inn input fra brukeren kan du kalle på `readInput`.

✅ Kjør `Lab1Test.java` for å teste om du har klart alle oppgavene i denne seksjonen.
