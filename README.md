DragonTreasure


Syfte och mål
   
Syftet med denna uppgift är att designa grundstrukturen för ett textbaserat äventyrsspel där spelaren med hjälp av de olika väderstrecken ska kunna navigera mellan olika rum i en grotta.
Spelaren ska även i varje rum få en textsträng som informerar spelaren om i vilket rum denne befinner sig, samt även en rumsbeskrivning och vilka riktningar man kan välja att förflytta sig i för att fortsätta spelet.
 Målet med uppgiften är att få en grundläggande förståelse för objektorienterad programmering och hur man går tillväga för att utveckla en god datastruktur.




Beskrivning

Dragon Treasure är ett textbaserat äventyrsspel skriven i Java. Spelaren utforskar en grotta med olika rum, dörrar och en skattkista.
Målet är att navigera genom rummen, hantera låsta dörrar och hitta utgången.
Spelet startar med att spelaren väljer ett namn och därefter kan spelaren navigera genom spelet genom olika rum i de fyra väderstrecken med kommandona “N”, “V”, “S” och “Ö”.
Det finns även alltid möjlighet att avsluta spelet med kommandot “quit”. I den här versionen finns “quit” som alternativ genom hela spelet. 

Spelet är programmerat med bland annat get och set metoder och arrayList. Det finns 5 klasser:

DragonTreasure – innehåller main-metoden och startar spelet. Skapar spelaren och skriver ut introduktionen.
Dungeon – bygger upp spelvärlden: skapar alla rum, kopplar ihop dem med dörrar (inklusive låsta dörrar), och innehåller spel-loopen via playGame()
Room – representerar ett rum med en beskrivning och en lista av dörrar. Har metoder för att visa dörrar och flytta mellan rum, samt skriva ut meddelanden vid låst dörr eller ifall spelaren väljer en riktning eller kommando som inte leder till en dörr. 
Player – lagrar spelarens namn med konstruktor och getter.
Door – representerar en dörr med riktning (direction), vilket rum den leder till (leadsTo)  och om den är låst (locked). Klassen har getters och setters för att hantera dessa värden.

I arbetet så har vi valt att använda oss av Netbeans då vi kände att detta var ett bra alternativ då det är de programmet som använts under föreläsningarna. 




Förbättringar och utveckling

Vidareutveckling av spelet framöver innefattar bland annat att spelaren ska kunna hantera föremål, låsa upp låsta dörrar och hantera strider med monster.
Detta för att skapa en mer komplett spelupplevelse för spelaren. För att kunna utveckla spelet med dessa framtida krav så behöver nuvarande metoder kollas över, samt kommer vi även behöva lägga till nya metoder och klasser för att bygga ut systemet för att nå slutgiltigt resultat.


Ingela Petersson inepet-0@student.ltu.se
Sara Dahlberg Christensen dahsar-5@student.ltu.se
Sara Rosenqvist sarroa-5@student.ltu.se
