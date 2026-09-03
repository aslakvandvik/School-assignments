🔙 **[Forrige steg](../README.md)** • [📜 **Oversikt**](../README.md) • [🔜 **Neste steg**](02-testCoverage.md)

# **🧪 Testing**  

Testing er en **essensiell, men ofte undervurdert** del av programvareutvikling.  
✅ **Vi skriver tester for å sikre at programmet fungerer som forventet.**  

## **🔹 Eksempel på en test**  
Her er en av testene som allerede er inkludert i prosjektet:  

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberExpressionTest {
    @Test
    void testConstructWithValidExpression() {
        Number expr = new Number(5);
        assertEquals(5.0, expr.getNumberValue());
    }
}
```  

Dette er en **enhetstest** (unit test). **Enhetstester** fokuserer på å teste små, individuelle deler av programmet for å sjekke om de fungerer som forventet.  

I dette emnet bruker vi **[JUnit 5](https://junit.org/junit5/)** for å skrive tester.  

## **📂 Hvor skal testene ligge?**  
Alle testene våre legges i en egen mappe kalt **[`test`](../src/test)**.  
Testpakkene må følge **samme struktur** som [`main`](../src/main)-mappen i prosjektet.  

### **🛠 Hvordan lage en testklasse?**  
1️⃣ Opprett en ny testklasse i **test-mappen**.  
2️⃣ Annoter testmetodene med **`@Test`** for å markere dem som tester.  

Eksempel:  
```java
@Test
void myTest() {
    // Testlogikk her
}
```  

📌 Det går helt fint om du lager testene public, men det er ikke nødvendig i dette prosjektet, så vi har utelatt det.

📌 Vanligvis kan du kalle test klassen din hva du vil og lage så mange klasser du vil.
Men for at vi skal kunne automatisk sjekke at dine tester er gode er det viktig at du følger instruksene i Steg 3 og lager en testklasse med rett navn.

## **🎯 Målet med denne labben**  
✅ I tidligere labber har du fått en kodebase **med tester** og skrevet kode for å få testene til å passere.  
✅ **Denne gangen skal du skrive tester for en eksisterende kodebase.**  

Men **det holder ikke bare å ha mange tester – testene må også være gode!** 🔍  

---

🔙 **[Forrige steg](../README.md)** • [📜 **Oversikt**](../README.md) • [🔜 **Neste steg**](02-testCoverage.md)
