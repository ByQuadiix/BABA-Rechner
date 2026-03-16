# AGENTS.md – BABA-Rechner

**BABA** = Berechnung Aller Basiseinheiten & Ableitungen  
Java Swing-Einheitenrechner. Keine Build-Skripte (reines IntelliJ-IDEA-Projekt, `BABA-Rechner.iml`).

---

## Architektur-Überblick

```
Einheitenrechner.java          ← Einstiegspunkt, Swing-Fenster, Intro-GIF, Menü-Buttons
  └─ Backend/Rechenlogik.java  ← Dispatcht getEinheiten() + rechnen() an konkreten Einheit-Typ
       └─ Backend/PanelBuilder.java  ← Baut Umrechnungs-Panel, ruft Rechenlogik auf
  └─ Backend/Einheiten/
       ├─ Einheit.java          ← Basisklasse (Einheiten[], Faktoren[], rechnen())
       └─ Laenge|Gewicht|Kraft|Fläche|Geschwindigkeit|Volumen|Zeit|Temperatur.java
```

**Datenfluss:**  
1. Menü-Button `.getName()` liefert String (z. B. `"Gewicht"`)  
2. `Rechenlogik.getEinheiten(name)` setzt **static** `temp_Einheit` und gibt `String[]` zurück  
3. `PanelBuilder.BuildPanel(einheiten[], onBack)` baut das UI  
4. Beim Klick auf „Umrechnen": `Rechenlogik.rechnen(input, vonIdx, zuIdx)` liest `temp_Einheit` und delegiert an den richtigen Einheit-Typ

---

## Kritische Muster

### Standardumrechnung (linear, alle Klassen außer Temperatur)
Basisklasse `Einheit.java`:
```java
double referenz = input / Faktoren[index_von];  // → Basiseinheit
double ergebnis = referenz * Faktoren[index_zu]; // → Zieleinheit
```
Die Basiseinheit hat immer `Faktor = 1.0` (z. B. `m` bei Länge, `kg` bei Gewicht).

### Temperatur-Ausnahme (`Temperatur.java`)
Überschreibt `rechnen()` komplett, weil Offsets nötig sind (`°F = °C × 1,8 + 32`).  
Dummy-`Faktoren` (alle `1.0`) – nur zur Vermeidung von NPE in der Basisklasse.  
Strategie: Eingabe → Celsius → Zieleinheit via `zuCelsius()` / `vonCelsius()`.

### Neue Einheit hinzufügen (linear)
1. Klasse in `src/Backend/Einheiten/` anlegen, `Einheit` erweitern, `Einheiten[]` + `Faktoren[]` im Konstruktor befüllen  
2. In `Rechenlogik.java`: Instanzfeld, `switch`-Case in `getEinheiten()` und `rechnen()` ergänzen  
3. In `Einheitenrechner.java`: Button mit `.setName("<Einheit>")` + Icon aus `Assets/icon/` anlegen

---

## Implizite Zustandskopplung – Achtung

`Rechenlogik.temp_Einheit` ist **static**. `getEinheiten()` setzt ihn als Seiteneffekt; `rechnen()` liest ihn später.  
→ Reihenfolge `getEinheiten()` → `rechnen()` muss eingehalten werden; parallele Nutzung mehrerer Instanzen ist unsicher.

---

## Asset-Pfade & Startverzeichnis

Alle Pfade sind **relativ zum Projektverzeichnis** hartcodiert:
```java
new ImageIcon("Assets/icon/area.png")
new ImageIcon("Assets/intro(1).gif")
```
Die Anwendung muss aus `Z:\BABA-Rechner-1.0.0.3\` gestartet werden (IntelliJ: Working Directory = `$MODULE_WORKING_DIR$`).

---

## Ungelöste Merge-Konflikte

`Einheitenrechner.java`, `PanelBuilder.java` und `Rechenlogik.java` enthalten aktive `<<<<<<< HEAD` / `>>>>>>>` Marker.  
**HEAD** ist der aktuelle Entwicklungsstand: enthält Temperatur-Button, `menuPanel` als Instanzfeld und `onBack`-Callback in `BuildPanel(String[], Runnable)`.  
Der ältere Branch (2ec9d94) hat nur `Laenge` implementiert – dieser Code sollte verworfen werden.

---

## Sprache & Konventionen

- Alle Kommentare, Variablennamen und UI-Labels sind **auf Deutsch**  
- Klassennamen folgen dem deutschen Einheitennamen (`Fläche.java`, `Geschwindigkeit.java`)  
- Sonderzeichen im Dateinamen: `Fläche.java` (ä) – auf korrektes Encoding achten
- `PanelBuilder` erbt von `Rechenlogik` (HEAD) **und** hält zusätzlich eine `Rechenlogik`-Instanz – redundant, nicht entfernen ohne Prüfung

