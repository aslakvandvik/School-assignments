# Steg 4 – La `Calculator.java` bruke `Operator.java`  

Nå som vi har en egen klasse for hver operator, må vi integrere dem i `Calculator.java`.  

For øyeblikket sjekker vi hvilken operator som brukes med flere `if`-setninger:  

```java
if (operatorSymbol.equals("+"))
    // Gjør noe
if (operatorSymbol.equals("-"))
    // Gjør noe
if (operatorSymbol.equals("*"))
    // Gjør noe
```
Dette er upraktisk, fordi vi må endre koden hver gang vi legger til en ny operator.  

I stedet skal vi **lagre operatorene i en strukturert måte** og bruke **polymorfisme** til å utføre beregningene uten eksplisitte `if`-sjekker.  

Se på dette eksempelet:  

```java
Operator operator = new Addition();
double result = operator.calculate(6, 5); // 6 + 5 = 11

operator = new Subtraction();
result = operator.calculate(6, 5); // 6 - 5 = 1

operator = new Multiplication();
result = operator.calculate(6, 5); // 6 * 5 = 30
```
Her ser vi at vi **ikke trenger å sjekke hvilken operator det er**. Vi kaller bare `calculate()`, og riktig metode blir automatisk valgt basert på objektets type.  

Dette er et eksempel på **dynamisk polymorfisme**: Koden vår kan utføre forskjellige operasjoner basert på hvilket `Operator`-objekt som brukes, uten at vi manuelt trenger å sjekke hvilken operator det er.  

---

## Oppgave  

For å få dette til å fungere må vi gjøre noen endringer i `Calculator.java`.  

### ✅ TODO 1 – Lagre operatorer i et `Map`  

>:question: **Hva er et Map?**  
> Et `Map` er en samling av nøkkel-verdi-par, lik `dictionary` i Python. I stedet for at vi må bruke `if`-sjekker, kan vi lagre operatortypene med symbolet som nøkkel.  

Først oppretter vi et `Map` i `Calculator.java` for å lagre operatorene:  

```java
private Map<String, Operator> operators;

public Calculator() {
    operators = new HashMap<>();
}
```
Her vil vi lagre operatortypene slik:  
```
"+" → Addition-objekt  
"-" → Subtraction-objekt  
"*" → Multiplication-objekt  
```

---

### ✅ TODO 2 – Fyll inn operatorene  

Opprett en ny metode for å legge til operatorene i `operators`-mapet:  

```java
private void addOperators() {
    ...
}
```
Legg til de tre operatorene (`+`, `-`, `*`) i `operators`-mapet. Denne metoden må kalles fra konstruktøren for å legge til alle operatorene når vi oppretter et nytt `calculator`-objekt.

```java
private void addOperator(Operator operator) {
    ...
}
```
For å gjøre koden enda bedre kan vi opprette en hjelpemetode som legger til én og én operator. Denne kaller du for hver operator du legger til i `addOperators`-metoden.

---

### ✅ TODO 3 – Endre `getOperatorSymbols()`  

Oppdater `getOperatorSymbols()` slik at den **henter symbolene fra `operators`-mapet** i stedet for å returnere en hardkodet liste:  

```java
public List<String> getOperatorSymbols() {
    ...
}
```

---

### ✅ TODO 4 – Endre `getOperatorDescription()`  

Oppdater `getOperatorDescription(String operatorSymbol)` slik at den **henter beskrivelsen fra riktig operator i `operators`-mapet**:  

```java
public String getOperatorDescription(String operatorSymbol) {
    ...
}
```

---

### ✅ TODO 5 – Endre `evaluate()`  

Til slutt, oppdater `evaluate(double num1, double num2, String operatorSymbol)` slik at den **bruker `Operator.calculate()`** i stedet for `if`-sjekker:  

```java
public double evaluate(double num1, double num2, String operatorSymbol) {
    ...
}
```

---

## Fullføring  

Når du er ferdig, skal programmet fungere akkurat som før – men nå er **koden mer fleksibel og lett å utvide**! 🎉  

✅ **Oppførselen til programmet skal være helt likt som tidligere, så sørg for at alle testene så langt fortsatt passerer.**  

---

🔙 [Forrige steg](03-operatorInterface.md) &bullet; 🔜 [Neste steg](05-exponent.md)  