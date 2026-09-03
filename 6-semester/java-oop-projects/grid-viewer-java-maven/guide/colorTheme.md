### Implementering av `ColorTheme`

I GridView trenger vi **`ColorTheme`**, en hjelpeklasse som definerer fargevalg for cellene i gridet.  

✅ **Målet er å tilordne riktig farge til hver celle basert på dens symbol.**  

---

## **1️⃣ Opprett `ColorTheme`-klassen**  

Lag en ny klasse **`ColorTheme`** i pakken **`no.uib.this OOP course.view`**.  
Denne klassen skal håndtere fargevalg for **Cellene i rutenettet**. Valg av farge skal baseres på symbolene vi finner i gridet, altså hvilken `Character`-verdi hver celle har.  

---

## **2️⃣ Implementer `getCellColor`**  

Denne metoden skal ta inn et tegn (`Character`) og returnere riktig farge:  
- `'r'` → **Rød**  
- `'g'` → **Grønn**  
- `'y'` → **Gul**  
- `'b'` → **Blå**  
- `'-'` → **Svart** (for tomme celler)  
- **Hvis tegnet ikke er definert**, kast en **IllegalArgumentException**.  

🔹 **Pseudokode:**  
```
Funksjon getCellColor(c):
    Hvis c er 'r', returner RØD
    Hvis c er 'g', returner GRØNN
    Hvis c er 'y', returner GUL
    Hvis c er 'b', returner BLÅ
    Hvis c er '-', returner SVART
    Ellers kast en feil: "Ingen tilgjengelig farge for dette tegnet"
```

---

## 🚀 **Neste steg:**  
Bruke `ColorTheme` i `GridView` for å sikre at cellene får riktig farge! 🎨🎉

🔙 [Tilbake til steg 2](./02-tegnrutenett.md)