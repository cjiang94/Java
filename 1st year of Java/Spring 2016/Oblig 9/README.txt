1. Parallellitet: Hvilke operasjoner kan gå i parallell og hvilke kan ikke
gå i parallell i programmet ditt (Amdahls lov)?

- Alle trådene går parallellt, men metodene med synchronized kan ikke kjøres samtidelig
- Ingen grense på maks tråder i monitor -> mer å jobbe for CPU -> kan ta mindre tid (kommer også ann på synchronized metodene siden bare en tråd kan være i en synchronized metode om gangen)
- Med grense -> Traader som må vente (kan ta mer tid siden noen tråder sover og venter på notify) -> mindre jobb for CPU

2. Kjøretiden programmet ditt bruker på sorteringen i forhold til antord
og antTraader, f.eks. ca. hvor mye øker sorterings-kjøretiden (eller
antall operasjoner som utføres) når antOrd dobler seg. Stor O-notasjon
er ikke pensum og trenger derfor ikke tas med (for de som er kjent
med det); et lite anslag ved dobling av dataene (og dobling av antall
prosessorer) er nok.

- Siden vi bruker quickSort, er det slik at hvis vi alltid henter pivot som ligger i midten under hver sortering, så vil det virke mest effektiv (O(n logn))
- Men hvis det er slik at vi alltid velger pivot med random, så kan det hende at pivot ofte blir valgt som enten første, eller siste i listen, og kjøretiden vil da ta lengre (O(n^2)).


1) Hvordan synes du innleveringen var? Hva var enkelt og hva var
vanskelig?
Innleveringen denne gangen var ikke enkel siden mye av stoffet var veldig nytt og vi møtte lese opp mye.

2) Hvor lang tid (ca) brukte du på innleveringen?
ca. 15 timer.

3) Samarbeidet du med noen under innleveringen? Hvis ja, skriv brukernavn
p� den/de du samarbeidet med.
Juliayc, Christji

4) Var det noen oppgaver du ikke fikk til? Hvis ja:
Det vanskeligeste for oss var å få programmet til å kjøre når koden lå inne i run();. Vi har testet resten av metodene, uten å kjøre run(), og det ser ut til å funke og gjør det de burde gjøre. (QuickSort og skrivUtTilFil)
Selv om vi vet at det fleste av metodene våre er rette, og programmet kompilerer, er det noen feil i run()/array som gir oss ArrayIndexOutOfBounds.
Vi tror hovedproblemmet ligger i flettingen av tråder og arrayet som blir ikke er stort nok under flettingen.
Vi synes også det hadde vært mye enklere hvis vi kunne ha brukt arrayList istedet for array, siden da trenger man ikke å holde styr på lengdene.
Det er kanksje også andre feil som vi ikke har klart å finne ennå. Blant annet at siden vi ikke får returnert en ferdigsortert array fra run(), så får vi ikke sett om tabellen har riktig lengde når vi prøver å skrive ut til fil.
Men sortering og printingen fungerer som det skal. 
