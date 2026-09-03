# Installere Java 17 og Maven på Mac OS

Her er instruksjoner for å installere Java OpenJDK 17 på Mac. Vi anbefaler at du installerer via [Homebrew](https://brew.sh/), som er en pakke-manager for svært mange nyttige verktøy og applikasjoner du vil få lyst på i løpet av ditt virke som programmerer.

### 0. Åpne terminalen
Punktene under skjer i terminalen i Mac OS. Den ligger i mappen *Applications/Utilities*, eller du kan søke den frem fra Launchpad eller Spotlight.

### 1. Installer Homebrew
- Sjekk om homebrew allerede er installert ved å gi kommandoen<br/>
`brew --version`<br/>
Hvis homebrew allerede er installert, hopp ned til steg 2 ([Oppdater Homebrew](#2-oppdater-homebrew)).
- Kopier inn kommandoen under i sin helhet og trykk enter: <br/> `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`<br/>
- Oppgi passord når du blir bedt om det, og gå videre når den spør
- Dersom det kommer en advarsel om at homebrew ikke er i din PATH, følg instruksjonene den foreslår.
- Sjekk at installasjon var vellykket ved å gi kommandoen<br/>`brew --version`<br/>Du skal da se informasjon om din versjon. Akkurat hvilken er ikke så farlig.

### 2. Oppdater Homebrew
- I terminalen, bruk kommandoen:<br/>
`brew update`<br/>

Denne kommandoen gjør at Homebrew henter informasjon om hvilke versjoner av f. eks. java som er tilgjengelige.

### 3. Installer Java OpenJDK 17
- I terminalen, skriv kommando:<br/>
`brew install openjdk@17`

### 4. Sett OpenJDK 17 som standard java-versjon.
OpenJDK er såkalt *keg-only* i homebrew. Det betyr at homebrew installerer programmet, men setter den ikke til *standard* for operativsystemet. Hensikten med dette fra Homebrew sin side er å ikke rote med programvare som kommer pre-installert på systemet (slik som f. eks. java er for Mac). Vi føler oss derimot såpass sikker på at denne nyere versjon av java *ikke* vil rote til operativsystemet at vi følger noen ekstra steg for å sette openjdk 17 til standard:
 - Kjør kommandoen<br/>
`brew info openjdk@17`<br/>
        Her vil det stå informasjon om hvor openjdk ble installert.
- Under overskriften *Caveats* står det instruksjoner om hvordan vi setter denne java-versjonen som standard. Kjør kommandoen oppgitt under punktet *For the system Java wrappers to find this JDK, symlink it with ...*
    
### 5. Sjekk at installasjonen var vellykket
- Gi kommandoen<br/>`java --version`<br/>

Du skal da få informasjon om at din java-versjon er openjdk 17. Du kan også sjekke at disse kommandoene fungerer:<br/>
    `javac --version`<br/>
    `mvn --version`<br/>
    Disse skal ha blitt installert sammen med java i openjdk-pakken. *javac* skal være versjon 17, *mvn* (Maven) bør være minst 3.8.

---
## ~Installere Maven~

~Maven er et prosjektstyringsverktøy for Java. I dette kurset blir alle laber og obliger levert ut som maven-prosjekter. Maven helper din IDE med å forstå hvilke bibliotek du bruker (for eksempel bruker vi biblioteket JUnit 5 for å skrive tester), og kan også brukes for å pakke applikasjoner/gjøre dem klar til å brukes av andre.~

~1. Sjekk om Maven allerede er installert. Gi kommandoen<br/>
`mvn --version`~

~2. Dersom maven ikke var installert, installer det med homebrew:<br/>
`brew install maven`~

~Sjekk at `mvn --version` nå fungerer. Maven bør helst være versjon 3.8 eller nyere.~

---
## Installere uten homebrew

Alternativt kan en versjon av Java som kalles Eclipse Temurin installeres uten homebrew. Last da ned Java 17 herfra: https://adoptium.net/en-GB/temurin/releases/?version=17. Dersom du har en nyere Mac med M1 eller M2 -prosessor, må du bruke `aarch64` -arkitektur; hvis ikke, må du bruke `x64`. Det enkleste er å laste ned .pkg -filen og klikke seg gjennom installasjonsprosessen.
