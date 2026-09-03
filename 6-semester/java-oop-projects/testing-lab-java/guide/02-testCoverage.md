🔙 **[Forrige steg](01-testing.md)** • [📜 **Oversikt**](../README.md) • [🔜 Neste steg](03-factorial.md)

# **🛡️ Test Coverage**

Når vi tester kode, ønsker vi å være grundige. **Dårlige tester kan føre til at feil i programmet ikke oppdages, selv om det ser ut til å fungere.**

For å sjekke hvor grundige testene våre er, kan vi bruke et **test coverage-verktøy**.

## **📊 Hva er test coverage?**
Test coverage-verktøy viser **hvor stor del av koden som er dekket av tester**.
De fleste slike verktøy måler hvor mange linjer som er kjørt under testene (**line coverage**), men dette tallet sier ikke nødvendigvis noe om hvor **gode** testene er.

## **🧐 Hvorfor er line coverage ikke nok?**
En test som bare *kjører* koden uten å sjekke resultatet, gir 100% line coverage — men fanger ingen feil! For eksempel:

```java
@Test
void badTest() {
    factorial.calculate(5); // Kjører koden, men sjekker ikke resultatet!
}
```

Denne testen gir full line coverage for `calculate`-metoden, men den verifiserer ikke at svaret faktisk er 120. Hvis metoden returnerte feil svar, ville testen fortsatt bestå.

## **🎯 Hvordan vi vurderer testkvalitet i denne labben**
I stedet for bare å måle line coverage, sjekker vi om testene dine faktisk **fanger feil**. Vi gjør dette ved å bytte inn **bevisst feilaktige implementasjoner** (buggy-versjoner) og kjøre testene dine mot dem.

- **Dersom testene dine feiler** mot den buggy versjonen → testene dine oppdaget feilen ✅
- **Dersom testene dine fortsatt passerer** → testene dine sjekker ikke godt nok ❌

For eksempel: Vi bytter inn en versjon av `Factorial` der `calculate(5)` returnerer `5` i stedet for `120`. Hvis testene dine sjekker at `calculate(5) == 120`, vil de oppdage denne feilen.

💡 **Tips:** Sørg for at testene dine:
- Sjekker at `calculate()` returnerer **riktige verdier** (ikke bare at den kjører)
- Sjekker at `getSymbol()` **er satt** (ikke `null`, ikke tom, ikke bare mellomrom)
- Sjekker at `getDescription()` **er satt** (ikke `null`, ikke tom, ikke bare mellomrom)
- Sjekker at ugyldig input kaster **exceptions**

## **🏆 Målet med denne labben**
Du skal:
✅ Lære å skrive dine egne tester.
✅ Sikre at testene dine faktisk **fanger feil** i koden.
✅ **Skrive gode tester, ikke bare mange tester!**

---

🔙 **[Forrige steg](01-testing.md)** • [📜 **Oversikt**](../README.md) • [🔜 Neste steg](03-factorial.md)
