# Installere Java 25 på Windows

For at Java skal virke er det 2 hovedmomenter som må være på plass:
- En mappe som heter jdk-25.0.1.8 eller lignende må finnes på PCen, inne i den vil det finnes blandt annet 2 filer som heter java.exe og javac.exe
- PCen må vite hvor denne mappen er slik at når du skriver en kommando så finner PCen rett fil. Dette gjøres litt forskjellig avhengig av operativsystem. PATH, JAVA_HOME og alternatives er vanlige måter, her kan du lære mer om [Environment variables](https://www.baeldung.com/java-home-vs-path-env-var). 

Sjekk om du har Java installert ved å gå til et terminalvindu (command line eller PowerShell) og skrive `java -version`. Dersom du har Java installert vil du få vite hvilken versjon. Dersom du får `command not found` eller tilsvarende, eller en lavere versjon enn Java 25 (f.eks. 8 eller 9) må du installere nyeste versjonen.
(P.S. det går helt fint å bruke andre versjoner av Java men det kan hende det oppstår situasjoner som krever at du tilpasser prosjektene til din versjon)


```
> java -version
command not found: java
```

### Steg for steg
1. Åpne Filutforsker og naviger deg frem til ``C:\Program Files``. Hvis det ikke finnes allerede opprett en mappe med navn "Java".
2. [Klikk her for å laste ned nyeste versjon av JDK](https://adoptium.net). De aller fleste Windows-brukere bør velge arkitektur `x64`. Instruksjonene under antar at du laster ned som *.zip* -fil.
3. Høyreklikk zip-filen og velg "Pakk ut". Pakk ut i Java-mappen du opprettet i steg 1: ``C:\Program Files\Java``.
4. Legg til "path variable" for Java.
    - I søkefeltet ned til venstre (Windows søk) skriv "Vis avanserte Systeminnstillinger" og trykk ``enter``.
    - Trykk på ``Miljøvariabler``

    <img src="images/Avanserte-systeminnstillinger.png" alt="drawing" width="350"/>

    - Under "Brukervariabler for <ditt brukernavn>" trykk på "Ny". Variabelnavn: `JAVA_HOME` og Variabelverdi: `C:\Program Files\Java\jdk-25.0.1.8` (altså navnet på mappen du pakken ut i steg 3).

    <img src="images/JAVA_HOME.png" alt="drawing" width="400"/>

    - Under "Systemvariabler" dobbelklikk variabelen "Path". Trykk "Ny" og skriv inn `C:\Program Files\Java\jdk-25.0.1.8\bin` (altså navnet på mappen du pakken ut i steg 3 etterfulgt av `\bin`).

    <img src="images/Path.png" alt="drawing" width="400"/>
    
    - Trykk "Ok" til alle vinduer er stengt.

Når du er ferdig med installasjonen kan du kjøre `java -version` kommandoen igjen i et *nytt* terminalvindu, og sjekke at versjonen er riktig.

```
> java -version
openjdk version "25.0.1" 2025-10-21 LTS
OpenJDK Runtime Environment Temurin-25.0.1+8 (build 25.0.1+8-LTS)
OpenJDK 64-Bit Server VM Temurin-25.0.1+8 (build 25.0.1+8-LTS, mixed mode, sharing)
```

✅ Når `java -version` kommandoen gir versjon 25 kan du gå videre.
</a>

### Troubleshooting
- Dersom terminalvinduet ikke forstår kommandoen (command not found eller lignende) etter Java er installert, kan du prøve å starte et nytt terminalvindu og se om det fungerer der.
- Har du ikke Windows men likevel problemer med path se [her](https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux).
