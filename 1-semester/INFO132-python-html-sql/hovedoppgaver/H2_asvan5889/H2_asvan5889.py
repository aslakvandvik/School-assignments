# Hovedoppgave 2 - Aslak Vandvik


class Tekstanalyse:
    tekst = ""  # teksten som analyseres
    avsnittliste = []  # liste over normaliserte avsnitt i teksten
    ordlister = []  # liste av lister over ord som forekommer i hvert avsnitt
    ordtellinger = []  # liste av lister med ordtellinger for hvert avsnitt

    def __init__(self, tekst):
        self.tekst = tekst

    def normaliser_tekst(self, spesialtegn=".,:;!?(){}[]"):
        # Fjerner spesialtegn fra self.tekst og konverterer til små bokstaver.
        for tegn in spesialtegn:
            self.tekst = self.tekst.replace(tegn, "")
        self.tekst = self.tekst.lower()

    def til_avsnitt(self, avsnittskille="\n\n"):
        # Deler self.tekst opp i en liste av avsnitt som lagres i self.avsnitt.
        self.avsnittliste = self.tekst.split(avsnittskille)

    def lag_ordliste(self, avsnittekst):
        # Lager en liste av ord som forekommer i avsnittet.
        return avsnittekst.split()

    def tell_ordforekomster(self, ordliste, avsnittekst):
        # Lager en liste over antall forekomster av ordene i ordliste i avsnittet."
        ordtelling = {}
        for ord in ordliste:
            antall = avsnittekst.count(ord)
            ordtelling[ord] = antall
        return ordtelling

    def analyser_tekst(self):
        # Lager en ordliste og teller ordforekomster for hvert avsnitt i teksten.
        ordlister = []
        ordtellinger = []
        for avsnittekst in self.avsnittliste:
            ordliste = self.lag_ordliste(avsnittekst)
            ordtelling = self.tell_ordforekomster(ordliste, avsnittekst)
            ordlister.append(ordliste)
            ordtellinger.append(ordtelling)
        self.ordlister = ordlister
        self.ordtellinger = ordtellinger

    def skriv_ut(self):
        # Skriver ut analyseresultatene for hvert avsnitt på skjermen.
        for i, avsnitt in enumerate(self.avsnittliste):
            print(f"\nAvsnitt {i+1}:\n\n")
            print(f"Avsnitttekst: {avsnitt}\n")
            print("Ordliste:", self.ordlister[i])
            print(
                "Ordtelling:", [self.ordtellinger[i][ord] for ord in self.ordlister[i]]
            )

    def lagre_til_fil(self, filnavn):
        # Lagrer analyseresultatene for hvert avsnitt i en fil.
        with open(filnavn, "w", encoding="utf-8") as fil:
            for i, avsnitt in enumerate(self.avsnittliste):
                fil.write(f"\nAvsnitt {i + 1}:\n\n")
                fil.write(f"Avsnitttekst: {avsnitt}\n")
                fil.write("Ordliste: ")
                fil.write(str(self.ordlister[i]) + "\n")
                fil.write("Ordtelling: ")
                fil.write(
                    str([self.ordtellinger[i][ord] for ord in self.ordlister[i]]) + "\n"
                )


# Testkjøring
filnavn = "eksempeltekst.txt"
eksempeltekst = open(filnavn, "r", encoding="utf-8").read()
tekstanalyse = Tekstanalyse(eksempeltekst)
tekstanalyse.normaliser_tekst()
tekstanalyse.til_avsnitt()
tekstanalyse.analyser_tekst()
tekstanalyse.skriv_ut()

# Lagring av resultatene til ny fil
tekstanalyse.lagre_til_fil("analyseresultat.txt")
