#Oppgave 1 (3).
print("Oppgave 1(3)")

hour=input("Enter hours:")
rate=input("Enter rate:")

pay=float(hour)*float(rate)

print(f'Pay:{pay}')

#Oppgave 3.
print("Oppgave 3")

import random
antall_question = random.randint(1, 50)
question = "?"
r = antall_question * question
print(r)

gjett = int(input("Gjett antall spørsmålstegn:"))
if gjett == antall_question:
    print("That's True!")
else:
    print("That's False!")
    print(f"{antall_question} er det riktige svaret")

#Oppgave 4.
print("Oppgave 4.")

import math
n = int(input("1. siffer:"))
m = int(input("2. siffer:"))

n_nytt_tall = str(n) + str(m)
m_nytt_tall = str(m) + str(n)

regnestykke_svar = math.sqrt(int(n_nytt_tall)*int(m_nytt_tall))
print(f"Kvadratroten av {n_nytt_tall} * {m_nytt_tall} = {regnestykke_svar:.2f}")

#Oppgave 5. 
from itertools import permutations
print("Oppgave 5.")
tresifret_tall = input("Oppgi et tresifret tall:")
perm = permutations(str(tresifret_tall))
print(f"Permutasjoner: {perm}")
