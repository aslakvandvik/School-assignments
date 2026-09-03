# Steg 3 – Forbedre kodekvaliteten med interface  

Nå har vi en fungerende kalkulator med tre operatorer. **Men kodekvaliteten er ikke optimal.**  

For øyeblikket må vi endre flere metoder i `Calculator.java` hver gang vi legger til en ny operator. Dette innebærer å utvide en `if`-sjekk for `+`, `-` og `*`. Etter hvert som vi legger til flere operatorer, som **`/` (deling), `^` (eksponent)** osv., vil `Calculator.java` bli mer rotete og vanskelig å vedlikeholde.  

I stedet for denne tilnærmingen skal vi bruke **interface** og **klasser** for å strukturere koden bedre.  

## `Operator.java`  

I mappen `operator` finnes interfacet `Operator.java`. Dette interfacet inneholder tre metoder:  

- `getSymbol()`  
- `getDescription()`  
- `calculate(double num1, double num2)`  

Disse metodene skal håndtere akkurat det samme som koden vi har skrevet i `Calculator.java`, men ved å plassere logikken i separate klasser for hver operator, får vi **renere, mer vedlikeholdbar og mer lesbar kode**.  

# ✅ TODO  

Opprett tre klasser – én for hver operator – som implementerer `Operator`-interfacet:  

```java
public class Addition implements Operator {
    ...
}
```

Legg til de nødvendige metodene og implementer dem.  

✅ I testklassen `OperatorsTest` finner du en rekke utkommenterte tester. Disse må kommenteres inn og passere før du kan gå videre.

---

🔙 [Forrige steg](02-descriptions.md) &bullet; 🔜 [Neste steg](04-polymorphism.md)  