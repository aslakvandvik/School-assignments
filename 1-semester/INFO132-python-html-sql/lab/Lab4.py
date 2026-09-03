#Lab 4

#Oppgave 1 
print("Oppgave 1.")
print("")
"""
Oppgave 1 – Tipskalkulator (enkel).
Lag en funksjon som returnerer hvor mye tips du bør gi basert på totalbeløpet av 
regningen og den prosentvise tipsraten du ønsker å gi. Funksjonen skal ha standardverdi for tipsraten, 
men brukeren skal ha mulighet til å overstyre denne verdien.

Standardverdi på tips skal ligge på 10%
"""
def beregn_tips(total_regning, prosent = 10):
    tips= prosent*total_regning/100
    print(tips)

beregn_tips(1500, prosent=15)

#Oppgave 2. 
print("Oppgave 2.")
print("")
"""
Oppgave 2 – Alderstest (enkel).
Lag en funksjon som tar inn en persons alder og skriver ut om personen
er gammel nok til å kjøre bil (18 år eller eldre). Hvis personen er under 18 år, 
skal funksjonen skrive ut hvor mange år det er igjen til personen kan kjøre.
"""
def aldertest(alder):
    if alder >= 18:
        print("Du er gammel nok til å kjøre bil.")
    elif alder < 18:
        år_fra_18 = 18-alder
        print(f"Du må vente {år_fra_18} år til før du kan kjøre bil.")
    else:
        print("Du må skrive inn alderen din.")

aldertest(19)

#Oppgave 3.
print("Oppgave 3.")
print("")
"""
Oppgave 3 – Gjett tallet (middels).
Lag en funksjon hvor datamaskinen velger et tilfeldig tall mellom 1 og 10, 
og brukeren får tre forsøk på å gjette hva tallet er. 
For hvert gjettede tall skal datamaskinen skrive ut om tallet er for høyt eller for lavt.
"""
import random
def gjett_tall():
    riktig_tall= random.randint(1, 10)
    forsok = 0
    
    print("Gjett et tall mellom 1 og 10 (forsøk 1 av 3):")
    
    while forsok < 3:
        gjett = int(input())
        
        forsok += 1
        if gjett < riktig_tall:
            print(f"For lavt! (forsøk {forsok} av 3):")
        elif gjett > riktig_tall:
            print(f"For høyt! (forsøk {forsok} av 3):")
        elif gjett == riktig_tall:
            print("Gratulerer du gjettet riktig!")
            break
    if forsok == 3:
        print(f"Du har brukt opp alle forsøk. Riktig tall var {riktig_tall}.")

gjett_tall()

#Oppgave 4.
print("Oppgave 4.")
print("")
"""
Oppgave 4 – Tidskonverterer (vanskelig).
Lag en funksjon som konverterer sekunder til timer, minutter og sekunder. 
Funksjonen skal returnere en streng på formen "X time(r), Y minutt(er) og Z sekund(er)".
"""
def tidskoverterer(z):
    x = z // 3600  
    y = (z % 3600) // 60
    z = z % 60
    # x = timer, y = minutter, z = sekunder 
    setningsformattering = f"{x} time{'r' if x != 1 else ''}, " \
                           f"{y} minutt{'er' if y != 1 else ''} og " \
                           f"{z} sekund{'er' if z != 1 else ''}."
    return setningsformattering
print(tidskoverterer(4000000))

