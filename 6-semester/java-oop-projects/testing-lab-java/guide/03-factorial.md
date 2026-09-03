🔙 **[Forrige steg](02-testCoverage.md)** • [📜 **Oversikt**](../README.md) • [🔜 **Neste steg**](04-unaryOperators.md)

# **Test fakultet**
I denne delen skal du skrive dine første tester ved hjelp av **JUnit 5**.

---

## **📝 TODO 1 – Opprett testklasse**

📌 **Oppgave:** Opprett test klassen **`UnaryOperatorsTest`** i pakken **`no.uib.this OOP course.calculator.operations`**.
Pass på at det er under test mappen og ikke under main mappen du lager filen.

For å skrive tester med **JUnit 5**, må du importere følgende:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
```

🚀 **Du har fullført dette steget av labben når alle testene i `GradeUnaryTests` passerer!**

### **🔹 Struktur på tester i JUnit 5**
Alle tester må:
✅ Merkes med **`@Test`**-annotasjonen for at JUnit skal kjenne dem igjen.
✅ Ha **`void`** som returtype.
✅ Ikke ta noen parametere.

Eksempel:
```java
@Test
void myTest() {
    // Testlogikk her
}
```

### **🔹 Verktøy for testing**
JUnit gir oss flere metoder for å sjekke forventede verdier:

✔ **Sammenligning av verdier:**
```java
assertEquals(expected, actual);  // Sjekker om to verdier er like
```

✔ **Sjekk om en verdi er sann:**
```java
assertTrue(booleanVariable);  // Sjekker om en verdi er sann
```

✔ **Sjekk om en verdi er usann:**
```java
assertFalse(booleanVariable);  // Sjekker om en verdi er usann
```

✔ **Tving en test til å feile hvis en betingelse er oppfylt:**
```java
if (someCondition) {
    fail();  // Stopper testen med feil
}
```

---

## **📝 TODO 2 – Test klassen `Factorial`**

📌 **Oppgave:** Skriv tester som sjekker at metodene i klassen **`Factorial`** fungerer korrekt.

 **Viktig:** Bruk `OperatorProvider` for å hente operatorer i testene dine, f.eks.:

```java
  UnaryOperator factorial = OperatorProvider.getFactorial();
   @Test
    void factorialCalculate() {
        assertEquals(120, factorial.calculate(5));
    }
```
 
**Ikke** bruk `new Factorial()` direkte — dette er nødvendig for at de automatiske vurderingstestene skal fungere.

### **Hva er fakultet?**
Fakultet av n (skrevet n!) er produktet av alle positive heltall fra 1 til n:
```
n! = 1 × 2 × 3 × ... × n
```
Spesialtilfelle: **0! = 1** (per definisjon).

### ✏ **Testene skal dekke:**

✅ **`calculate(double n)`** — Sjekk at metoden returnerer riktig resultat.
   - `calculate(0)` skal returnere `1` (0! = 1 per definisjon)
   - `calculate(1)` skal returnere `1`
   - `calculate(5)` skal returnere `120` (5 × 4 × 3 × 2 × 1)
   - `calculate(10)` skal returnere `3628800`
   - Test gjerne med flere verdier for å sikre at beregningen er korrekt.

✅ **`calculate(double n)` med ugyldig input** — Sjekk at metoden kaster exception for negative tall.
   - `calculate(-1)` skal kaste `IllegalArgumentException`
   - Bruk `assertThrows` for å teste dette:
   ```java
   import static org.junit.jupiter.api.Assertions.assertThrows;

   assertThrows(IllegalArgumentException.class, () -> factorial.calculate(-1));
   ```


✅ **`getSymbol()`** — Sjekk at symbolet er satt.
   - Skal ikke være `null`, tom streng `""`, eller bare mellomrom.
   - Bruk f.eks. `assertNotNull(factorial.getSymbol())` og `assertFalse(factorial.getSymbol().isBlank())`.

✅ **`getDescription()`** — Sjekk at beskrivelsen er satt.
   - Skal ikke være `null`, tom streng `""`, eller bare mellomrom.
   - Bruk f.eks. `assertNotNull(factorial.getDescription())` og `assertFalse(factorial.getDescription().isBlank())`.

> 💡 **Tips:** Se på `BinaryOperatorsTest` for et eksempel på hvordan testene kan struktureres — du trenger minst tre tester (beregning, symbol og beskrivelse) per operator.

---

## Fullført?
Kjør **`FactorialMutationTests`** for å sjekke at testene dine for fakultet er gode nok. Du kan kjøre dem i IDE-en din eller med Maven:
```
mvn test -pl . -Dtest="no.uib.this OOP course.calculator.operations.FactorialMutationTests"
```
🚀 **Du har fullført dette steget av labben når alle testene i `FactorialMutationTests` passerer!**


🔙 **[Forrige steg](02-testCoverage.md)** • [📜 **Oversikt**](../README.md) • [🔜 **Neste steg**](04-unaryOperators.md)
