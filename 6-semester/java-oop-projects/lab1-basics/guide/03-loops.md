[forrige](02-if.md) • [oversikt](../README.md) • [neste](05-lists.md)

## INF100 Lab3 - Loop'er

### Hvordan skrive en for-løkke i Java:
Det finnes to måter å skrive for-løkker i Java. Her viser vi først måten løkken skrives i Python, og deretter måten den samme løkken skrives i Java:

#### Iterere over en range
<table>
<tr>
<th>Python:</th>
<th>Java:</th>
</tr>
<tr>
<td>

```python
for (i in range(X)):
```
</td>
<td>

```java
for (int i = 0; i < X; i++) {}
```
</td>
</tr>
</table>

Her må vi altså definere og instansiere en variabel som er telleren vår, så definere hvor mange lenge løkken skal iterere (her har vi sagt så lenge `i < X`), og deretter hva som skal skje med telleren etter hver iterasjon (her sier vi `i++`, som er det samme som `i += 1)`.
Merk at vi separerer disse tre instruksjonene med `;`.

#### Iterere gjennom en liste med objekter
<table>
<tr>
<th>Python:</th>
<th>Java:</th>
</tr>
<tr>
<td>

```python
for (student in students):
```
</td>
<td>

```java
for (student : students) {}
```
</td>
</tr>
</table>

Her trenger vi bare å erstatte `in` med `:`.

### Hvordan skrive en while-løkke i Java:
While-løkke er veldig likt i Java som i Python:
<table>
<tr>
<th>Python:</th>
<th>Java:</th>
</tr>
<tr>
<td>

```python
while (condition):
```
</td>
<td>

```java
while (condition) {}
```
</td>
</tr>
</table>

✅**Da er du klar for å begynne på INF100 Lab3. Lykke til!**

---
De følgende oppgavene er tatt fra lab3 INF100h22. Du finner de opprinnelige oppgavene her:
https://inf100h22.stromme.me/lab/3/


### Oppgave 1 - `multiplesOfSeven`
Implementer metoden `Lab3::multiplesOfSeven`. Metoden har et parameter `n`. Skriv kode for å skrive ut alle heltall mindre eller lik `n` som er delelig på 7.

Når metoden kalles med argument `n = 49`: `multiplesOfSeven(49)` så skal det skrives ut:
```
7
14
21
28
35
42
49
```

### Oppgave 2 - `multiplicationTable`
Implementer metoden `Lab3::multiplicationTable`. Metoden har et parameter `n`. Skriv kode for å skrive ut gangetabellen for alle tall fra og med `1` til og med `n`. Utskriften skal følge møsnteret vist under.

Eksempelkjøringer:
`multiplicationTable(3)`
```
1: 1 2 3
2: 2 4 6
3: 3 6 9
```
`multiplicationTable(5)`
```
1: 1 2 3 4 5
2: 2 4 6 8 10
3: 3 6 9 12 15
4: 4 8 12 16 20
5: 5 10 15 20 25
```

### Oppgave 3 - `crossSum`
Implementer metoden `Lab3::crossSum`. Metoden har et parameter `n` og skal returnere tverrsummen av `n`. 
Tverrsummen er summen av sifferene i tallet, for eksempel er tverrsummen av 12 lik 3, siden 1 + 2 = 3.

Koden skal skrive ut de følgende verdiene gitt de forskjellige argumentene:
```java
int sum = crossSum(1);
System.out.println(sum); // 1

int sum = crossSum(12);
System.out.println(sum); // 3

int sum = crossSum(123);
System.out.println(sum); // 6

int sum = crossSum(1234);
System.out.println(sum); // 10

int sum = crossSum(4321);
System.out.println(sum); // 10
```


✅ Kjør `Lab3Test.java` for å teste om du har klart alle oppgavene i denne seksjonen.