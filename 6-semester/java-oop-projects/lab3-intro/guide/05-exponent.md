# Steg 5 – Legg til eksponent-operator  

Nå skal vi legge til en ny operator: **eksponentiering**. Dette vil også vise hvor enkelt det er å utvide kalkulatoren med den nye strukturen vi innførte i forrige steg!  

---

## ✅ TODO – Opprett `Exponent.java`  

Lag en ny klasse `Exponent` som implementerer `Operator`-interfacet.  

- Symbolet for eksponentiering skal være `^`  
- Beskrivelsen skal være:  
  > `"Calculate the result of raising a base number to the power of an exponent."`  
- `calculate()`-metoden skal bruke `Math.pow(base, exponent)`.  

Eksempel på bruk:  
```java
Operator operator = new Exponent();
double result = operator.calculate(4, 2); // 4^2 = 16
```

---

## ✅ TODO – Legg til i `Calculator.java`  

Den **eneste** endringen som trengs i `Calculator.java` er å legge til `Exponent` i `addOperators()`:  

```java
private void addOperators() {
    addOperator(new Addition());
    addOperator(new Subtraction());
    addOperator(new Multiplication());
    addOperator(new Exponent());
}
```
Vi trenger **ingen `if`-sjekker eller andre endringer** – den nye strukturen gjør utvidelse sømløs! 🎉  

---

## Fullføring  

✅ **Kommenter inn testene i `ExponentTest`-klassen. Labben er ferdig nå alle testene passerer**

📌 **Husk å levere på CodeGrade!**

---

🔙 [Forrige steg](04-polymorphism.md)