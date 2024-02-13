```# Ghibli Store

“Ghibli Store” è una web app di e-commerce per il merchandising e i film dello Studio Ghibli, la famosa casa di produzione di film d'animazione giapponese. “Ghibli Store” permette di registrarsi, accedere alla propria pagina personale, sfogliare il catalogo dei prodotti disponibili suddivisi in “film” e “merchandising”, aggiungerli al carrello, effettuare l'acquisto e visualizzare il riepilogo degli ordini. 


## Funzionalità

“Ghibli Store” offre le seguenti funzionalità:
    • Home page: la pagina principale della web app, dove vengono mostrate le ultime novità. Si può accedere alle altre sezioni tramite il menu di navigazione.
    • Registrazione: la pagina dove si può creare il proprio account inserendo i dati personali, come nome, email, username, password, indirizzo.
    • Login: la pagina personale dove si potrà accedere al proprio account inserendo username e password.
    • Catalogo, diviso in:
      Film: la pagina dove sono mostrati tutti i film disponibili, filtrabili per prezzo, categoria, genere, rating, noleggio. 
      Merchandising: i prodotti del merchandising sono filtrabili per prezzo, film o categoria. 
      Per ogni prodotto presente nel catalogo di “film” o di “merchandising” è possibile accedere ad una pagina di dettaglio verranno elencate le sue caratteristiche e i prodotti correlati. Si potrà anche aggiungere il prodotto al carrello (a condizione di aver fatto il login) o tornare alla home page.
    • Carrello: vengono mostrati i prodotti aggiunti al carrello, il prezzo, i dati di spedizione e il totale. I prodotti possono essere rimossi prima di procedere all'ordine. Per procedere all'acquisto bisogna aver fatto il login e cliccare su “Paga con PayPal”: se il carrello contiene prodotti il click permette di registrare l'ordine, altrimenti, se il carrello è vuoto, restituirà un messaggio di avvertimento all'utente e se il prodotto non è più disponibile, verrà dato un messaggio di errore.
    • Dettaglio ordini: la pagina dove è presente lo storico dei proprio ordini con la data, l’ora, il totale e i prodotti acquistati. Per accedere a questa pagina, bisogna essere loggati.


## Dipendenze

“Ghibli Store” è realizzato con Spring e Java per il back-end, e Html, CSS e Bootstrap per il front-end. Le dipendenze necessarie per far funzionare il progetto sono:

    • Spring web,
    • Spring boot devtools,
    • Validation,
    • Spring JPA,
    • Thymeleaf,
    • MySQL driver.


## Installazione

Per installare “Ghibli Store” sul tuo computer devi seguire questi passi:
    • Crea un database MySQL chiamato "studio_ghibli".
    • Clona il repository GitHub del progetto con il comando:

```bash
git clone https://github.com/MafaldaDamiani/ghibli-store.git
``` 

    • Apri il progetto con Spring Boot e assicurati che la connessione del file application.properties sia corretto.
    • Apri il browser e vai all'indirizzo:
      
```bash
http://localhost:8080
```


## Uso
Per usare “Ghibli Store”, devi seguire questi passi:
    • Se non hai un account, registrati tramite la pagina di registrazione, inserendo i tuoi dati personali.
    • Se hai già un account, accedi tramite la pagina di login, inserendo lo username e la tua password.
    • Sfoglia il catalogo dei prodotti “film” e “merchandising” utilizzando i relativi filtri. Per ogni prodotto, puoi vedere i dettagli, aggiungerlo al carrello e vedere i prodotti correlati.
    • Quando hai scelto i prodotti che vuoi acquistare, vai al carrello e controlla il totale. Puoi anche rimuovere i prodotti, prima di procedere all'ordine.
    • Clicca sul pulsante "Paga con Paypal" per completare il pagamento e registrare l'ordine. Se l'ordine è stato registrato con successo, potrai vedere i dettagli nella pagina di riepilogo ordini.


## Contributo

Se vuoi contribuire al miglioramento di “Ghibli Store”, puoi:

    • Aprire una [issue](https://github.com/MafaldaDamiani/ghibli-store/issues) per segnalare un problema o una richiesta di funzionalità.
    • Fare una [pull request](https://github.com/MafaldaDamiani/ghibli-store/pulls) per proporre una modifica o una soluzione.
    • Scrivere dei test per verificare il funzionamento del codice.
    • Aggiornare la documentazione se necessario.
      



## Ringraziamenti

Grazie a:

    • “Studio Ghibli” per averci ispirato con i suoi meravigliosi film;
    • Spring per averci fornito un framework potente e facile da usare;
    • Bootstrap per averci permesso di creare un'interfaccia grafica accattivante;
    • MySQL per averci offerto un database affidabile e performante;
    • Thymeleaf per averci facilitato la creazione delle pagine web dinamiche;
    • GitHub per aver ospitato il progetto e averci dato la possibilità di condividerlo;
    • Accademia del Levante per averci formato come programmatrici Java;
    • Generation Italy per averci dato l'opportunità di sviluppare questa applicazione.














