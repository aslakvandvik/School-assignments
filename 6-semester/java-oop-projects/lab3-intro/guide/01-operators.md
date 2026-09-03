# Steg 1 – Legg til `*` og `-`  

I dette steget skal du utvide kalkulatoren med to nye matematiske operatorer for å gjøre den mer nyttig.  

Per nå støtter kalkulatoren kun addisjon (`+`). Du skal nå legge til **multiplikasjon (`*`)** og **subtraksjon (`-`)**.  

## Endringer i `Calculator.java`  

`Calculator.java` er hovedklassen som styrer hvordan kalkulatoren fungerer. Ta en titt på metodene `getOperatorSymbols` og `evaluate`:  

```java
public List<String> getOperatorSymbols() {
    return Arrays.asList("+");
}
```

```java
public double evaluate(double num1, double num2, String operatorSymbol) {
    if (operatorSymbol.equals("+"))
        return num1 + num2;
    
    throw new IllegalArgumentException("This operator is not supported by the calculator: " + operatorSymbol);
}
```

# ✅ TODO

Utvid `Calculator.java` slik at den også støtter `*` og `-`, ved å følge det eksisterende bruksmønsteret.  

✅ Når du er ferdig, skal kalkulatoren kunne håndtere **`+`**, **`-`** og **`*`** korrekt.  

📌 **Før du går videre, må alle testene i `CalculatorOperatorTest.java` passere.**  

<img align="center" src="images/finishedCalculator.png" alt="Eksempelbilde av ferdig kalkulator" width="170"/>  

---  

🔙 [Oversikt](../README.md) &bullet; 🔜 [Neste steg](02-descriptions.md)  