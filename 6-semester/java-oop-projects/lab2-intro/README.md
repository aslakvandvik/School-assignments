# Lab2 - Pokénmon

## Læringsmål
- Lage klasser
- Opprette objekter

## Intro

I denne labben skal vi definere vår egen datatype og lage **objekter**.

[Pokémon](https://en.wikipedia.org/wiki/Pok%C3%A9mon) er et verdenskjent japansk spill med 122 titler (per desember 2022). I dette spillet har vi en rekke forskjellige pocket monsters som kjemper mot hverandre. Alle de forskjellige pokémon'ene har felles tilstand og oppførsel, dermed blir det naturlig å bruke objektorientert programmering til å modellere disse.

![Pokémon](https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/International_Pok%C3%A9mon_logo.svg/640px-International_Pok%C3%A9mon_logo.svg.png)


Denne oppgaven er basert på en øvingsoppgave utarbeidet av Albin Severinson og Dag Haugland.

### Eksempelkjøring
Når vi i denne labben lager Pokémon vil vi fokusere på de essensielle aspektene ved spillet. Dette betyr at spillet vil være tekstbasert og ha ingen bruker-input. Når programmet kjøres skal det følgende skrives ut:
```
Pikachu HP: (94/94) STR: 12
Oddish HP: (100/100) STR: 3

Pikachu attacks Oddish.
Oddish takes 9 damage and is left with 91/100 HP
Oddish attacks Pikachu.
Pikachu takes 3 damage and is left with 91/94 HP
Pikachu attacks Oddish.
Oddish takes 14 damage and is left with 77/100 HP
Oddish attacks Pikachu.
Pikachu takes 4 damage and is left with 87/94 HP

(...)

Pikachu takes 3 damage and is left with 66/94 HP
Pikachu attacks Oddish.
Oddish takes 4 damage and is left with 0/100 HP
Oddish is defeated by Pikachu.
```
Merk deg at hele kampen ikke er tatt med her. Programmet skal skrive ut alle linjene av kampen når det kjøres.

<br>

---

### Guide

1. [Feltvariabler og konstruktør](./guide/01-feltvariabler_og_konstruktor.md)
2. [Getter og hjelpemetoder](./guide/02-getter_og_hjelpemetoder.md)
3. [`toString`](./guide/03-toString.md)
4. [`damage`](./guide/04-damage.md)
5. [`attack`](./guide/05-attack.md)
6. [Pokemon Battle](./guide/06-pokemon_battle.md)
7. [Referanser](./guide/07-referanser.md)
8. [`.equals()` vs `==`](./guide/08-equals.md)
9. [Pokemon Team](./guide/09-pokemon_team.md)

<br>

### ✅ Når alle testene i `PokemonTest.java`, `PokemonBattleTest.java` og `PokemonTrainerTest.java` passerer er oppgaven ferdig. HUSK AT DU MÅ LEVERE PÅ CODEGRADE!
