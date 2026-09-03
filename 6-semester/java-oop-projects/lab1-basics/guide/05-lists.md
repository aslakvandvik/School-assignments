[forrige](03-loops.md) • [oversikt](../README.md) • [neste](07-twodimentionallists.md)

## Introduksjonsoppgave - Lister
Lister er litt annerledes i Java enn i Python. I Python kan vi bare skrive navnet på listen, og liste opp alle elementene inni en `[]` slik som dette: `mylist = [1, 2, 3]`. Du kan også lage lister med elementer av mange forskjellige typer, slik som dette: `mylist = ["a", 1, "b", 2]`.

I Java er lister **typespesifikke**. Python-lister oppbevarer bare pekeren til objektet i listen, mens i Java inneholder listen selve objektet, og vi kan derfor bare ha objekter av én bestemt type i Java-lister (teknisk sett gjelder dette Python og, hvor typen er pekere). Når vi lager en liste i Java, må vi opprette den på samme måte som alle andre objekter:
ved bruk av kommandoen `new`.

Skal vi opprette en liste med heltallene fra 1 til 5, kan vi gjøre slik:
```java
ArrayList<Integer> mylist = new ArrayList<>(Arrays.asList(1,2,3,4,5));
```

Eventuelt kan vi legge til ett og ett element i den tomme listen:
```java
ArrayList<Integer> myList = new ArrayList<>();
myList.add(1)
myList.add(2)
myList.add(3)
myList.add(4)
myList.add(5)
```

**VIKTIG:** Det er linjen `new ArrayList<>();` som faktisk oppretter objektet. `ArrayList<Integer> myList` er bare variabelen vi putter objektet inn i.

<details><summary><b>Klikk her hvis du vil se den detaljerte forklaringen av hva vi nettopp gjorde:</b></summary>

1. Først lager vi en variabel `mylist` av typen `ArrayList<Integer>`, hvor innholdet i `<>` spesifiserer typen som listen inneholder, i dette tilfellet `Integer`. 
2. Deretter setter vi denne variabelen lik det nye objektet vi oppretter med `new`. Dette objektet er av typen `ArrayList<>`. Her står `<>` tom, fordi variabelen `myList`ikke kan ha en liste med noe annet innhold enn `Integer` når vi har spesifisert dette i steg 1. Da trenger vi ikke spesifisere mer, programmet skjønner hva det skal gjøre av seg selv.
3. Videre kan vi velge å gi et **argument** til metoden `new ArrayList<>()`. Dette er nemlig en metode kalt en **konstruktør** som oppretter nye objekter.
4. I det første eksempelet vårt oppretter vi en liste med tallene våre ved å kalle den **statiske** metoden `asList` fra klassen `Arrays`.
5. I det andre eksempelet velger vi å legge til ett og ett element ved å bruke metoden `add()` **på** objektet `myList`. Dette gjøres ved å sette `.` mellom objektnavnet og metodenavnet.
</details>

Gjør oppgaven under for å sjekke at du har forstått hvordan man lager lister i Java.

### Oppgave 1 - `multiplyWithTwo`
Implementer metoden `Lab5::multiplyWithTwo`. Metoden tar inn en liste `list` av heltall. Skrive kode for å multiplisere alle tallene i listen med to, og returner disse tallene i en egen liste.

Koden skal skrive ut de følgende verdiene fitt de forskjellige argumentene:
```java
ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
ArrayList<Integer> multipliedList1 = multiplyWithTwo(list1);
System.out.println(multipliedList1); // [2, 4, 6, 8]

ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 2));
ArrayList<Integer> multipliedList2 = multiplyWithTwo(list2);
System.out.println(multpliedList2); // [4, 4]

ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(0));
ArrayList<Integer> multipliedList3 = multiplyWithTwo(list3);
System.out.println(multpliedList3); // [0]
```

## INF100 Lab5 - Lister
De følgende oppgavene er tatt fra lab5 INF100h22. Du finner de opprinnelige oppgavene her:
https://inf100h22.stromme.me/lab/5/


### Oppgave 1 - `removeThrees`
Implementer metoden `Lab5::removeThrees`. Metoden har en liste av heltall `list` som parameter. Skriv kode for å fjerne alle forekomster av tallet `3` i listen.

Koden skal skrive ut de følgende verdiene gitt de forskjellige argumentene:
```java
ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
ArrayList<Integer> removedList1 = removeThrees(list1);
System.out.println(removedList1); // [1, 2, 4]

ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 3));
ArrayList<Integer> removedList2 = removeThrees(list2);
System.out.println(removedList2); // [1, 2]

ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(3, 3, 1, 3, 2, 4, 3, 3, 3));
ArrayList<Integer> removedList3 = removeThrees(list3);
System.out.println(removedList3); // [1, 2, 4]

ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(3, 3));
ArrayList<Integer> removedList4 = removeThrees(list4);
System.out.println(removedList4); // []
```

### Oppgave 2 - `uniqueValues`
Implementer metoden `Lab5::uniqueValues`. Metoden har en liste heltall `list` som parameter. Skriv kode for å beholde alle unike verdier, men fjerne alle dulplikater. Sørg for at elementene som ikke fjernes beholder sin plassering i listen.

Koden skal skrive ut de følgende verdiene gitt de forskjellige argumentene:
```java
ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 1, 2, 1, 3, 3, 3, 2));
ArrayList<Integer> removedList1 = uniqueValues(list1);
System.out.println(removedList1); // [1, 2, 3]

ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 4, 4, 4, 4, 4, 4, 4, 4, 5);)
ArrayList<Integer> removedList2 = uniqueValues(list2);
System.out.println(removedList2); // [4, 5]
```

### Oppgave 3 - `addList`
Implementer metoden `Lab1::addList`. Metoden har to lister med heltall `a` og `b` som parametre. Skriv kode for å endre listen `a` ved å addere alle verdiene med heltallene i `b` på samme indeks. Du skal endre på liste `a`, men ikke endre på `b`.

Koden skal skrive ut de følgende verdiene gitt de forskjellige argumentene:
```java
ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1, 2, 3));
ArrayList<Integer> b1 = new ArrayList<>(Arrays.asList(4, 2, -3));
addList(a1, b1);
System.out.println(a1); // [5, 4, 0]

ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(1, 2, 3));
ArrayList<Integer> b2 = new ArrayList<>(Arrays.asList(47, 21, -30));
addList(a2, b2);
System.out.println(a2); // [48, 23, -27]
```


✅ Kjør `Lab5Test.java` for å teste om du har klart alle oppgavene i denne seksjonen.
