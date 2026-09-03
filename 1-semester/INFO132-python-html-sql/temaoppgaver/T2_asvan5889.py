# Oppgave 1.

import math

r = float(input("Radius:"))
a = (r**2) * (math.pi)
print(f"Arealet til en sirkel med radius {r} er {a:.3f}")

# Oppgave 2.

setning = input("Skriv setning:").replace(" ", "")
lengde = int(input("Gjett lengde:"))
total_words = len(setning)

if total_words == lengde:
    print("That's Correct!")
else:
    print("That's False!")

# Oppgave 3.

import random

tall = int(input("Gi meg et tall:"))

random_tall = random.randint(1, 9)
nytt_tall = int(str(tall) + str(random_tall))

svar = int(nytt_tall) / int(tall)

print(f"{nytt_tall}/{tall}={svar}")
