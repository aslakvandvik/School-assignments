# Hovedoppgave 3


class Vurdering:
    def __init__(self, tekst, skår, emne, student):
        self.tekst = tekst
        self.skår = skår
        self.emne = emne
        self.student = student

    def skriv_ut(self):
        print(
            f'{self.student.navn}, {self.emne.kode}: "{self.tekst}", skår={self.skår}'
        )


class Emne:
    def __init__(self, kode, tittel):
        self.kode = kode
        self.tittel = tittel
        self.vurderinger = []

    def legg_til_vurdering(self, vurdering):
        self.vurderinger.append(vurdering)

    def gjennomsnittlig_vurdering(self):
        if self.vurderinger:
            total_skår = 0
            for vudering in self.vurderinger:
                total_skår += vudering.skår
            return total_skår / len(self.vurderinger)

    def skriv_ut(self):
        print(f"\nEmne {self.kode}: {self.tittel}")
        if self.vurderinger:
            print("Vurderinger:")
            for vurdering in self.vurderinger:
                vurdering.skriv_ut()
            print(f"Gjennomsnittlig vurdering: {self.gjennomsnittlig_vurdering()}")


class Student:
    def __init__(self, navn, epost):
        self.navn = navn
        self.epost = epost
        self.vurderinger = []

    def ny_vurdering(self, emne, tekst, skår):
        vurdering = Vurdering(tekst, skår, emne, self)
        emne.legg_til_vurdering(vurdering)
        self.vurderinger.append(vurdering)

    def skriv_ut(self):
        print(f"\nNavn: {self.navn}, epost: {self.epost}")
        if self.vurderinger:
            print("Vurderinger:")
            for vurdering in self.vurderinger:
                vurdering.skriv_ut()
        else:
            print("Ingen vurderinger tilgjengelig for denne studenten.")


# Testing
alina = Student("Alina Farschian", "afa754@student.uib.no")
info132 = Emne("INFO132", "Innføring i programmering")

alina.skriv_ut()
info132.skriv_ut()

alina.ny_vurdering(info132, "Kjempebra emne! Jeg tar det om igjen neste høst!", 5)
alina.skriv_ut()
info132.skriv_ut()

olea = Student("Olea Haldorsen", "oha356@student.uib.no")
olea.skriv_ut()

olea.ny_vurdering(info132, "Sånn passe. DATA110 om våren dekker omtrent det samme.", 3)
olea.skriv_ut()
info132.skriv_ut()
