# **Lab 4 – Testing**

## **Læringsmål**
🔹 Skrive og forstå enhetstester
🔹 Bruke tester til å identifisere og rette feil i koden
🔹 Evaluere testkvalitet ved å skrive tester som fanger feil

---

## **Introduksjon**

I denne labben skal du skrive tester for en kalkulatorapplikasjon og bruke dem til å finne og rette feil.

Kalkulatoren bygger videre på det du lagde i **Lab 3**, men har nå støtte for flere operatorer. Tidligere implementerte du **binære operatorer**, som tar to argumenter:
- ➕ **Addisjon:** `6 + 5 = 11`
- ✖ **Multiplikasjon:** `6 * 5 = 30`
- ➖ **Subtraksjon:** `6 - 5 = 1`
- ^ **Eksponent:** `4^2 = 16`

Nå har vi utvidet kalkulatoren med **unære operatorer**, som bare tar ett argument:
- **Fakultet:** `5! = 1 * 2 * 3 * 4 * 5 = 120`
- **Tierlogaritmen:** `log(100) = 2`
- **Naturlig logaritme:** `ln(e) = 1`
- √ **Square root:** `√9 = 3`

📌 **Koden du får utdelt er en utvidet versjon av løsningsforslaget fra Lab 3.** De binære operatorene er allerede godt testet, men unære operatorer mangler tester.

🔍 **Din oppgave:**
✅ Skrive tester for de nye unære operatorene
✅ Bruke testene til å avdekke eventuelle feil
✅ Fikse feilene slik at kalkulatoren fungerer riktig

---

## **Før du starter**

Koden du får ut fungerer, kjør Main.java og sjekk at dein kode kjører.

🛠️ **For å gjennomføre denne labben må du ha installert Maven.** 
Hvis du ikke har gjort dette ennå, kan du følge [denne guiden fra Lab 4 V25](https://git.app.uib.no/ii/this OOP course/25v/students/lab-4/-/blob/main/guide/maven.md).

---

## **Fremgangsmåte**

Følg stegene nedenfor for å fullføre oppgaven:
1. [📌 Hva er testing?](./guide/01-testing.md)
2. [📊 Test Coverage](./guide/02-testCoverage.md)
3. [❗ Fakultet](./guide/03-factorial.md)
4. [1️⃣ Unære operatorer](./guide/04-unaryOperators.md)
5. [🤔 Er det nok med coverage?](./guide/05-testCoverageEnough.md)

---

## **Fullføring**

✅ **Oppgaven er fullført når alle testene passerer!**
📌 **Husk å levere på CodeGrade før fristen!**

🚀 Lykke til! 🚀
