[Tilbake til oppgave 7 - Referanser](./07-referanser.md)

## Ekstra: Referanser og likhet i dybden

### Hvordan minne fungerer

Når du oppretter et objekt med `new`, skjer følgende:
1. Java allokerer plass i minnet (på "heapen") for objektet
2. Konstruktøren kjører og initialiserer feltvariablene
3. `new` returnerer en *referanse* (minneadresse) til objektet
4. Denne referansen lagres i variabelen din

```
┌─────────────────────────────────────────────────────────┐
│ Stack (variabler)          │ Heap (objekter)            │
├─────────────────────────────────────────────────────────┤
│                            │                            │
│ Pokemon a ──────────────────► [ Pokemon-objekt ]       │
│    (referanse: 0x1234)     │   name: "Pikachu"          │
│                            │   maxHP: 100               │
│ Pokemon b ──────────────────► (samme objekt!)          │
│    (referanse: 0x1234)     │   currentHP: 100           │
│                            │   strength: 10             │
│                            │                            │
│ Pokemon c ──────────────────► [ Annet Pokemon-objekt ] │
│    (referanse: 0x5678)     │   name: "Pikachu"          │
│                            │   maxHP: 100               │
│                            │   currentHP: 100           │
│                            │   strength: 10             │
└─────────────────────────────────────────────────────────┘
```

I diagrammet over:
- `a` og `b` har samme referanse (0x1234) - de peker til *samme* objekt
- `c` har en annen referanse (0x5678) - et *forskjellig* objekt med like verdier

### Når bruke `==` vs `.equals()`?

| Situasjon | Bruk | Forklaring |
|-----------|------|------------|
| Primitive typer (`int`, `boolean`, etc.) | `==` | Primitive typer har ingen referanser |
| Sjekke om samme objekt | `==` | Sammenligner referanser |
| Sjekke om like verdier | `.equals()` | Sammenligner innhold |
| `null`-sjekk | `==` | `null.equals()` gir NullPointerException |

### String-sammenligning

Strenger er et spesialtilfelle. Java optimerer strenger slik at identiske streng-literaler deler samme objekt:

```java
String a = "Pikachu";
String b = "Pikachu";
String c = new String("Pikachu");

System.out.println(a == b);       // true! (samme objekt pga. "string interning")
System.out.println(a == c);       // false (c er et nytt objekt)
System.out.println(a.equals(c));  // true (samme innhold)
```

> **Regel:** Bruk *alltid* `.equals()` for å sammenligne strenger!

### `hashCode()`-kontrakten

Når du overskriver `equals()`, bør du også overskrive `hashCode()`. Dette er viktig for at objektene skal fungere korrekt i `HashMap`, `HashSet`, og lignende datastrukturer.

**Kontrakten:**
1. Hvis `a.equals(b)` er `true`, må `a.hashCode() == b.hashCode()`
2. Hvis `a.hashCode() != b.hashCode()`, må `a.equals(b)` være `false`

For `Pokemon` kunne en enkel `hashCode()` se slik ut:

```java
@Override
public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + maxHealthPoints;
    result = 31 * result + strength;
    return result;
}
```

> **Merk:** I denne labben implementerer vi ikke `hashCode()`, men det er viktig å vite om for fremtidig bruk.

### Null-sikker `equals()`

En robust `equals()`-implementasjon må håndtere alle edge-cases:

```java
@Override
public boolean equals(Object obj) {
    // Samme objekt - alltid lik seg selv
    if (this == obj) return true;

    // null er aldri lik noe
    if (obj == null) return false;

    // Feil type - kan ikke være lik
    if (!(obj instanceof Pokemon)) return false;

    // Nå vet vi at obj er en Pokemon
    Pokemon other = (Pokemon) obj;

    // Sammenlign feltene
    // Bruk Objects.equals() for null-sikker sammenligning av navn
    return this.maxHealthPoints == other.maxHealthPoints
        && this.strength == other.strength
        && java.util.Objects.equals(this.name, other.name);
}
```

> **Tips:** `java.util.Objects.equals(a, b)` håndterer null trygt - returnerer `true` hvis begge er null, `false` hvis bare én er null, og `a.equals(b)` ellers.
