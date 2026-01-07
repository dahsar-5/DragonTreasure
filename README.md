1. Syfte och mål
Syftet med denna uppgift är att fortsätta utveckla äventyrsspel där spelaren med hjälp av de olika väderstrecken ska kunna navigera mellan olika rum i en grotta. Navigeringen gjordes i uppgift 1. I uppgift 2 har vi vidareutvecklat spelet med fler funktioner och spelmöjligheter, där vi bland annat använt oss av arv och polymorfism. Däribland att låta spelaren hantera att plocka upp saker och slåss mot monster. För att klara det här behöver koden utvecklas med fler klasser och metoder.  Målet med uppgiften är att få en djupare förståelse för objektorienterad programmering och hur man går tillväga för att utveckla en god datastruktur. 

2. Beskrivning
Spelet är programmerat med bland annat get och set metoder och arrayList. Det finns 11 klasser:

DragonTreasure – innehåller main-metoden och startar spelet. Skapar spelaren och skriver ut introduktionen.
Dungeon – bygger upp spelvärlden: skapar alla rum, kopplar ihop dem med dörrar (inklusive låsta dörrar), och innehåller spel-loopen via playGame()
Room – representerar ett rum med en beskrivning och en lista av dörrar. Har metoder för att visa dörrar och flytta mellan rum, samt skriva ut meddelanden vid låst dörr eller ifall spelaren väljer en riktning eller kommando som inte leder till en dörr. 
Player – lagrar spelarens namn med konstruktor och getter.
Door – representerar en dörr med riktning (direction), vilket rum den leder till (leadsTo)  och om den är låst (locked). Klassen har getters och setters för att hantera dessa värden.
Item – Basklassen till alla våra föremål som hanteras i spelet.
Key –Subklass till Item
Potion –Subklass till Item
Treasure –Subklass till Item
Weapon –Subklass till Item
Monster – Representerar ett monster i spelet som måste besegras.

Spelet navigeras med de fyra olika väderstrecken och spelaren har en ryggsäck där olika föremål sparas under spelets gång. Spelet är uppbyggt så att det endast finns en typ av spelare. Börjar man spelet väljer man namn och blir automatisk tilldelad ett visst antal hälsopoäng, och mängd skada man gör, samt en ryggsäck. 

Vi har valt att varje strid och användandet av föremål sker automatiskt. Spelaren får ett val om de önskar att plocka upp föremålet, sedan används föremålet antingen direkt, eller vid tillfället med nyckeln, när de passar i spellogiken. Det finns endast en nyckel som passar den enda låsta dörren som finns i spelet.

I arbetet så har vi valt att använda oss av Netbeans då vi kände att detta var ett bra alternativ då det är det programmet som använts under föreläsningarna. 


3. Förbättringar och utveckling
Förbättringar och justeringar som vi bland annat har gjort från första uppgiften är att vi nu utvecklat spelet med olika föremål som svärd, nyckel, hälsodryck och skatt som spelaren kan plocka upp under spelets gång. Vi har även i denna utvecklade version lagt till monster som spelaren måste bekämpa för att både få tag i skatten men också för att kunna ta sig ut ur grottan. Något som vi också justerat är hur vårat “slutrum” fungerar, alltså när man kommer ut ur grottan och klarat spelet. I tidigare version så hade man trots att man kommit ut ur grottan till vårt slutrum och egentligen avslutat spelet möjligheten att fortfarande gå in i grottan och fortsätta spela. Problem som fanns var då både att man kunde fortsätta spela och att spelet inte automatiskt avslutades när man lämnade grottan. Vi har nu utvecklat detta genom att vi tagit bort vårat slutrum och istället valt att göra vårt “Treasure” rum till slutrum så att när man går in i detta rum så finns inte möjligheten att gå ut ur rummet, samt måste man bekämpa en drake. Om man lyckas att besegra draken så får man tag i skatten som är målet med spelet och då avslutas spelet automatiskt i och med att man nu har vunnit.

Vid vidareutveckling av spelet hade fler val om när föremål används kunnat varit en naturlig utveckling. Speciellt vid flera olika sorters föremål, olika typer av monster som spelaren behöver olika vapen för att besegra, eller flera låsta dörrar som behöver specifika nycklar för upplåsning.  Eftersom vi har en arraylist för både items och inventory anser vi att den nuvarande spellogiken går relativt bra att bygga vidare på med fler föremål. Polymorfismen/arvet vi har använt med Item och de olika föremålen, gör även att det är lätt att lägga till föremål som spelaren kan använda genom items basmetod. 
