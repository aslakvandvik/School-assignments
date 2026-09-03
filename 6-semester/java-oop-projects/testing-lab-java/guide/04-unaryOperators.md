🔙 **[Forrige steg](03-factorial.md)** • [📜 **Oversikt**](../README.md) • [**🔜 Neste steg**](05-testCoverageEnough.md)

# **Unære operatorer**

I dette steget skal du skrive tester for **unære operatorer** slik at testene dine fanger opp vanlige feil.

## **✅ Oppgave**
📌 **Skriv tester for de tre gjenværende unære operatorene** (`Log`, `Ln`, `Root`) slik at testene dine sjekker beregninger, symboler og beskrivelser.

> **Viktig:** Bruk `OperatorProvider` for å hente operatorer i testene dine og lagre dem som feltvariabler:
> ```java
> UnaryOperator log = OperatorProvider.getLog();
> UnaryOperator ln = OperatorProvider.getLn();
> UnaryOperator root = OperatorProvider.getRoot();
> ```
> **Ikke** bruk `new Log()`, `new Ln()` eller `new Root()` direkte — dette er nødvendig for at de automatiske vurderingstestene skal fungere.

For **hver operator** skal du teste de samme tre aspektene som for Factorial:
1. **`calculate()`** — returnerer riktig beregnet verdi (test også med negative tall og null)
2. **`getSymbol()`** — sjekk at symbolet er satt (ikke `null`, ikke tomt, ikke bare mellomrom)
3. **`getDescription()`** — sjekk at beskrivelsen er satt (ikke `null`, ikke tom, ikke bare mellomrom)

---

### **📐 Log (base-10 logaritme)**
Bruker `Math.log10(x)`. Svarer på: "10 opphøyd i hvilken potens gir x?"

| Input | Forventet resultat | Forklaring |
|-------|-------------------|------------|
| `calculate(1)` | `0.0` | 10^0 = 1 |
| `calculate(10)` | `1.0` | 10^1 = 10 |
| `calculate(100)` | `2.0` | 10^2 = 100 |
| `calculate(1000)` | `3.0` | 10^3 = 1000 |

- Sjekk at `getSymbol()` og `getDescription()` ikke er `null`, tomme eller bare mellomrom.
- **Obs:** Denne bruker `Math.log10()`, *ikke* `Math.log()` (som er naturlig logaritme). Velg testverdier der disse gir ulike svar (f.eks. 100: `log10(100) = 2.0` vs `ln(100) ≈ 4.605`).
- Test også med **negative tall** (`calculate(-1)` skal returnere `NaN`) og **0** (`calculate(0)` skal returnere `-Infinity`).

### **📐 Ln (naturlig logaritme, base e)**
Bruker `Math.log()`. Svarer på: "e opphøyd i hvilken potens gir x?" (e ≈ 2.71828)

| Input | Forventet resultat | Forklaring |
|-------|-------------------|------------|
| `calculate(1)` | `0.0` | e^0 = 1 |
| `calculate(Math.E)` | `1.0` | e^1 = e |

- Sjekk at `getSymbol()` og `getDescription()` ikke er `null`, tomme eller bare mellomrom.
- **Obs:** Denne bruker `Math.log()`, *ikke* `Math.log10()`. Velg testverdier der disse gir ulike svar.
- Test også med **negative tall** (`calculate(-1)` skal returnere `NaN`) og **0** (`calculate(0)` skal returnere `-Infinity`).

### **📐 Root (kvadratrot)**
Bruker `Math.sqrt()`. Finner tallet y slik at y × y = x.

| Input | Forventet resultat | Forklaring |
|-------|-------------------|------------|
| `calculate(0)` | `0.0` | √0 = 0 |
| `calculate(1)` | `1.0` | √1 = 1 |
| `calculate(4)` | `2.0` | 2 × 2 = 4 |
| `calculate(9)` | `3.0` | 3 × 3 = 9 |

- Sjekk at `getSymbol()` og `getDescription()` ikke er `null`, tomme eller bare mellomrom.
- **Obs:** Denne bruker `Math.sqrt()` (kvadratrot), ikke `Math.cbrt()` (kubikkrot). For eksempel: `√8 ≈ 2.828` mens kubikkrot av 8 = 2.0. Velg testverdier der disse gir ulike svar.
- Test også med **negative tall** (`calculate(-1)` skal returnere `NaN`) og **0** (`calculate(0)` skal returnere `0`).

---

## **💡 Hint: Sammenligning av desimaltall**
Når du tester **double**-verdier, må du huske at **små avrundingsfeil** kan forekomme. Derfor sammenligner vi tall med en **margin av feil** i stedet for eksakt likhet.

### **Eksempel**
Denne sjekken vil ofte feile pga. avrundingsforskjeller:
```java
double num1 = 1.0;
double num2 = 0.99999;
assertEquals(num1, num2); // ❌ Kan feile!
```
✅ **Bruk en toleranse (epsilon) for å unngå dette:**
```java
assertEquals(num1, num2, 0.001); // ✅ Passerer hvis forskjellen er mindre enn 0.001
```
Dette sikrer at **testene dine ikke feiler unødvendig** på grunn av små avrundingsavvik.

---

## **📊 Sjekk testene dine**
Kjør **`GradeUnaryTests`** for å sjekke at testene dine er gode nok. Du kan kjøre dem i IDE-en din eller med Maven:
```sh
mvn test -pl . -Dtest="no.uib.oop.calculator.operations.GradeUnaryTests"
```
🚀 **Du er ferdig med dette steget når alle testene i `LnMutationTests`, `LogMutationTests` og RootMutationTests passerer!**

---

🔙 **[Forrige steg](03-factorial.md)** • [📜 **Oversikt**](../README.md) • [**🔜 Neste steg**](05-testCoverageEnough.md)
