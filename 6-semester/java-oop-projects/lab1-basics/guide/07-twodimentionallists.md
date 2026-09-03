[forrige](05-lists.md) • [oversikt](../README.md) • [neste](./bonus-rockepaperscissor.md)

## INF100 Lab7 - Todimensjonale lister
De følgende oppgavene er tatt fra lab7 INF100h22. Du finner de opprinnelige oppgavene her:
https://inf100h22.stromme.me/lab/7/


### Oppgave 1 - `removeRow`
Implementer metoden `Lab7::removeRow`. Metoden har en todimensjonal liste av heltall `grid` og en rad-index `row` som parametre. Skriv kode for å fjerne raden på indeks `row` fra `grid`.

>❓ **Todimensjonal liste**. I Python lærte vi om todimensjonale lister. For å repetere, er dette en liste hvor hvert element er en liste, for eksempel slik `[[1,2], [2,3]]`.

Koden skal skrive ut de følgende verdiene gitt de forskjellige argumentene:
```java
ArrayList<ArrayList<Integer>> grid1 = new ArrayList<>();
grid1.add(new ArrayList<>(Arrays.asList(11, 12, 13)));
grid1.add(new ArrayList<>(Arrays.asList(21, 22, 23)));
grid1.add(new ArrayList<>(Arrays.asList(31, 32, 33)));

removeRow(grid1, 0);
for (int i = 0; i < grid1.size(); i++) {
    System.out.println(grid1.get(i));
}
// [21, 22, 23]
// [31, 32, 33]

ArrayList<ArrayList<Integer>> grid2 = new ArrayList<>();
grid2.add(new ArrayList<>(Arrays.asList(11, 12, 13)));
grid2.add(new ArrayList<>(Arrays.asList(21, 22, 23)));
grid2.add(new ArrayList<>(Arrays.asList(31, 32, 33)));

removeRow(grid2, 1);
for (int i = 0; i < grid2.size(); i++) {
    System.out.println(grid2.get(i));
}
// [11, 12, 13]
// [31, 32, 33]
```


### Oppgave 2 -`allRowsAndColsAreEqualSum`
Implementer metoden `Lab7::allRowsAndColsAreEqualSum`. Metoden har en todimensjonal liste av heltall `grid` som parameter. Skriv kode som sjekker at alle rader summerer til det samme tallet, og at alle kollonner summerer til det samme tallet. Summen av radene og kollonnene trenger ikke å være det samme.

Koden skal skrive ut de følgende verdiene gitt de forskjellige argumentene:
```java
ArrayList<ArrayList<Integer>> grid1 = new ArrayList<>();
grid1.add(new ArrayList<>(Arrays.asList(3, 0, 9)));
grid1.add(new ArrayList<>(Arrays.asList(4, 5, 3)));
grid1.add(new ArrayList<>(Arrays.asList(6, 8, 1)));

boolean equalSums1 = allRowsAndColsAreEqualSum(grid1);
System.out.println(equalSums1); // false


ArrayList<ArrayList<Integer>> grid2 = new ArrayList<>();
grid2.add(new ArrayList<>(Arrays.asList(3, 4, 6)));
grid2.add(new ArrayList<>(Arrays.asList(0, 5, 8)));
grid2.add(new ArrayList<>(Arrays.asList(9, 3, 1)));

boolean equalSums2 = allRowsAndColsAreEqualSum(grid2);
System.out.println(equalSums2); // false

ArrayList<ArrayList<Integer>> grid3 = new ArrayList<>();
grid3.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
grid3.add(new ArrayList<>(Arrays.asList(2, 3, 4, 1)));
grid3.add(new ArrayList<>(Arrays.asList(3, 4, 1, 2)));
grid3.add(new ArrayList<>(Arrays.asList(4, 1, 2, 3)));

boolean equalSums3 = allRowsAndColsAreEqualSum(grid3);
System.out.println(equalSums3); // true
```


✅ Kjør `Lab7Test.java` for å teste om du har klart alle oppgavene i denne seksjonen.