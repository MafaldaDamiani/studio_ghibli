-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Creato il: Feb 12, 2024 alle 17:57
-- Versione del server: 10.1.8-MariaDB
-- Versione PHP: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studio_ghibli`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `film`
--

CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `durata` varchar(15) NOT NULL,
  `anno` int(11) NOT NULL,
  `genere` varchar(80) NOT NULL,
  `rating` varchar(10) NOT NULL,
  `noleggio` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `film`
--

INSERT INTO `film` (`id`, `durata`, `anno`, `genere`, `rating`, `noleggio`) VALUES
(1, '117 min', 1984, 'Film d''azione, fantasy, avventura', 'VM14', 'si'),
(2, '86 min', 1988, 'Film d''azione, fantasy, avventura', 'TUTTI', 'no'),
(3, '130 min', 1989, 'Film d''azione, fantasy, avventura', 'TUTTI', 'si'),
(4, '94 min', 1992, 'Film d''azione, avventura, commedia', 'TUTTI', 'si'),
(5, '134 min', 1997, 'Film d''azione, fantasy, avventura', 'VM14', 'no'),
(6, '125 min', 2001, 'Film d''azione, fantasy, avventura', 'TUTTI', 'no'),
(7, '119 min', 2004, 'Film d''azione, fantasy, avventura', 'TUTTI', 'si'),
(8, '101 min', 2008, 'Film d''azione, fantasy, avventura', 'TUTTI', 'si'),
(9, '126 min', 2013, 'Film d''azione, biografico, drammatico', 'VM14', 'no'),
(10, '124 min', 2023, 'Film d''azione, fantasy, drammatico', 'TUTTI', 'no');

-- --------------------------------------------------------

--
-- Struttura della tabella `ordini`
--

CREATE TABLE `ordini` (
  `id` int(11) NOT NULL,
  `fk_id_utente` int(11) NOT NULL,
  `data_ora` datetime NOT NULL,
  `importo` double NOT NULL,
  `quantita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `ordini_prodotti`
--

CREATE TABLE `ordini_prodotti` (
  `fk_id_ordine` int(11) NOT NULL,
  `fk_id_prodotto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotti`
--

CREATE TABLE `prodotti` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `tipologia_prodotto` varchar(30) NOT NULL,
  `categoria` varchar(30) NOT NULL,
  `descrizione` varchar(500) NOT NULL,
  `prezzo` double NOT NULL,
  `immagine` text,
  `immagine_due` text,
  `data_inserimento` date NOT NULL,
  `quantita_disponibile` int(11) NOT NULL,
  `fk_id_film` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `prodotti`
--

INSERT INTO `prodotti` (`id`, `nome`, `tipologia_prodotto`, `categoria`, `descrizione`, `prezzo`, `immagine`, `immagine_due`, `data_inserimento`, `quantita_disponibile`, `fk_id_film`) VALUES
(1, 'Nausicaä della valle del vento', 'Film', 'DVD', 'Ambientato in un mondo post-apocalittico, il film segue le avventure di Nausicaä, una principessa che cerca di proteggere la sua terra da creature mutanti e da conflitti tra umani. Nausicaä dimostra un profondo rispetto per la natura e cerca la pace tra l''umanità e l''ambiente.', 4, 'immagini/film/locandina_nausicaa.jpeg', NULL, '2023-11-05', 10, 1),
(2, 'Il mio vicino Totoro', 'Film', 'Formato digitale', 'Il film segue le avventure di due giovani sorelle, Satsuke e Mei, che si trasferiscono in una casa di campagna con il padre. Lì fanno amicizia con creature magiche, inclusa la grande e amichevole creatura chiamata Totoro. Il film esplora la magia dell''infanzia, l''immaginazione e la connessione con la natura.', 10.3, 'immagini/film/locandina_totoro.jpeg', NULL, '2023-11-07', 8, 2),
(3, 'Kiki consegne a domicilio', 'Film', 'DVD', 'Il film segue Kiki, una giovane strega, che, come tradizione impone, parte da casa con il suo gatto nero Jiji per trovare una città in cui vivere e offrire i suoi servizi di consegna. Kiki affronta sfide e cresce durante il suo viaggio, imparando l''importanza dell''indipendenza e della fiducia in sé stessa.', 4.5, 'immagini/film/locandina_kiki.png', NULL, '2023-11-19', 5, 3),
(4, 'Porco Rosso', 'Film', 'Blu-Ray', 'Il film segue le avventure di Porco Rosso, un asso dell''aviazione porco antropomorfo, durante l''era post-Prima Guerra Mondiale. Lavorando come cacciatore di taglie, Porco Rosso si scontra con pirati e aviatori rivali mentre cerca di proteggere le navi da trasporto nell''Adriatico. Il film affronta temi di coraggio, onestà e amore.', 5.6, 'immagini/film/locandina_porco.jpeg', NULL, '2023-11-28', 12, 4),
(5, 'La principessa Mononoke', 'Film', 'DVD', 'Il film segue Ashitaka, un giovane guerriero infettato da una maledizione, che si avventura in una terra incontaminata alla ricerca della causa del suo problema. Incontra la Principessa Mononoke, una giovane donna in sintonia con gli spiriti della foresta, e si trova coinvolto in una lotta tra gli abitanti della foresta e gli esseri umani che cercano di sfruttarla. Il film esplora temi ambientali, spirituali e morali.', 17.9, 'immagini/film/locandina_mononoke.jpg', NULL, '2023-12-12', 3, 5),
(6, 'La città incantata', 'Film', 'Formato digitale', 'La storia segue Chihiro, una giovane ragazza che si imbatte in un mondo magico mentre cerca i suoi genitori scomparsi. Questo mondo è popolato da spiriti e creature straordinarie, e Chihiro dovrà affrontare varie sfide per trovare e salvare i suoi genitori. Il film esplora temi di crescita, coraggio e amicizia.', 9.7, 'immagini/film/locandina_incantata.jpg', NULL, '2023-12-15', 19, 6),
(7, 'Il castello errante di Howl', 'Film', 'Formato digitale', 'La storia segue Sophie, una giovane donna che viene maledetta da una strega e trasformata in una vecchia. Sophie cerca rifugio nel castello ambulante di Howl, un potente mago, e inizia una straordinaria avventura che coinvolge magia, amicizia e il conflitto tra nazioni. Il film esplora temi di identità, amore e coraggio.', 4.8, 'immagini/film/locandina_howl.jpg', NULL, '2023-12-22', 9, 7),
(8, 'Ponyo sulla scogliera', 'Film', 'Blu-Ray', 'La storia segue Ponyo, una piccola sirena desiderosa di diventare umana, che incontra e si innamora di Sosuke, un giovane ragazzo umano. Ponyo sfida la sua natura magica per vivere sulla terra, portando conseguenze magiche che mettono alla prova la loro amicizia. Il film esplora temi di amore, magia e connessione con il mondo naturale.', 7.15, 'immagini/film/locandina_ponyo.jpg', NULL, '2024-01-04', 6, 8),
(9, 'Si alza il vento', 'Film', 'DVD', 'Il film racconta la vita di Jiro Horikoshi, un ingegnere aeronautico giapponese che ha progettato molti degli aerei utilizzati dalla forza aerea giapponese durante la Seconda Guerra Mondiale. La trama esplora il suo amore per l''aviazione, la sua carriera e le complesse sfide morali legate al suo lavoro durante il periodo bellico.', 13.5, 'immagini/film/locandina_vento.jpg', NULL, '2024-01-20', 26, 9),
(10, 'Il ragazzo e l''airone', 'Film', 'Formato digitale', 'La storia segue Mahito Maki, un dodicenne che ha perso la madre durante un incendio in ospedale, segue un misterioso airone cenerino fino a una torre abbandonata nel bosco. Qui, viene intrappolato in un mondo magico all''interno della torre e, insieme a una domestica di nome Kiriko, cerca di salvare la madre e la zia. Navigando attraverso il mondo incantato, Mahito affronta sfide, incontra personaggi magici, e scopre il legame tra il mondo magico e la sua famiglia.', 20.18, 'immagini/film/locandina_airone.jpg', NULL, '2024-02-03', 8, 10),
(11, 'Mini borsa a tracolla "Kiki consegne a domicilio"', 'Merchandising', 'Accessori', 'Borsa in poliestere. Colori nero e grigio.', 14.5, 'immagini/merchandising/kiki_borsetta_1.jpg', 'immagini/merchandising/kiki_borsetta_2.jpg', '2023-11-05', 18, 3),
(12, 'Salvadanaio "La città incantata"', 'Merchandising', 'Decorazioni per la casa', 'Realizzato in ABS. Con due batterie AAA incluse.', 29.3, 'immagini/merchandising/incantata_salvadanaio_1.jpg', 'immagini/merchandising/incantata_salvadanaio_2.jpg', '2023-11-07', 19, 6),
(13, 'Cannoniera "Nausicaä della valle del vento"', 'Merchandising', 'Modellini da collezione', 'Caratteristiche come le ali pieghevoli e il carrello di atterraggio estraibile sono state aggiunte mantenendo il design originale del film. I vani motore si illuminano con un LED blu. Include Gunship, Moeve e quattro personaggi pilota non verniciati.', 120.3, 'immagini/merchandising/nausicaa_modellino_1.jpg', 'immagini/merchandising/nausicaa_modellino_2.jpg', '2023-11-19', 6, 1),
(14, 'Pupazzetto Marco "Porco Rosso"', 'Merchandising', 'Peluches ed Action Figures', 'Morbidissimo peluche in poliestere. Realizzato minuziosamente, con grande dovizia di dettagli.', 19.2, 'immagini/merchandising/porco_peluche.jpg', NULL, '2023-11-19', 8, 4),
(15, 'Portapenne in tessuto "Il mio vicino Totoro"', 'Merchandising', 'Ufficio e cancelleria', 'Borsello grigio. Realizzato interamente in oxford.', 6.9, 'immagini/merchandising/totoro_astuccio_1.jpg', 'immagini/merchandising/totoro_astuccio_2.jpg', '2023-11-28', 25, 2),
(16, 'Set matite "La città incantata"', 'Merchandising', 'Ufficio e cancelleria', 'Lascia fluire il tuo spirito creativo con questo pratico set di 10 matite di grafite con i personaggi amati del pluripremiato film fantasy di Hayao Miyazaki!', 17.1, 'immagini/merchandising/incantata_matite.jpg', NULL, '2023-11-28', 13, 6),
(17, 'Borsa in tela "Porco Rosso"', 'Merchandising', 'Accessori', 'Borsa tote con pratico ricamo adatta ad ogni contesto, per fare la spesa o anche per portare con te i tuoi effetti personali. Materiale di alta qualità e 100% cotone.', 36.2, 'immagini/merchandising/porco_tote_1.jpg', 'immagini/merchandising/porco_tote_2.jpg', '2023-12-12', 24, 4),
(18, 'Action Figure "Il mio vicino Totoro"', 'Merchandising', 'Peluches ed Action Figures', 'Ispirata al celebre film dello Studio Ghibli. Realizzata in resina.', 30.4, 'immagini/merchandising/totoro_actionfigure_1.jpg', 'immagini/merchandising/totoro_actionfigure_2.jpg', '2023-12-15', 17, 2),
(19, 'Salvadanaio "Il mio vicino Totoro"', 'Merchandising', 'Peluches ed Action Figures', 'Simpatico salvadanaio in PVC. Perfetto per custodire i tuoi risparmi (più di qualsiasi istituto di credito).', 25.8, 'immagini/merchandising/totoro_salvadanaio_1.jpg', 'immagini/merchandising/totoro_salvadanaio_2.jpg', '2023-12-22', 17, 2),
(20, 'Cover per iPhone "Il castello errante di Howl"', 'Merchandising', 'Telefonia', 'La custodia è progettata pensando a forme e funzionalità moderne. Ha uno straordinario guscio in TPU che offre resistenza agli urti, lasciando trasparire il fascino dello smartphone.', 17.2, 'immagini/merchandising/howl_cover_1.jpg', 'immagini/merchandising/howl_cover_2.jpg', '2923-12-22', 18, 7),
(21, 'Borsa pranzo "Il mio vicino Totoro"', 'Merchandising', 'Accessori', 'Borsa portaoggetti con isolamento termico in oxford (esterno) e pellicola di alluminio (interno).', 17.2, 'immagini/merchandising/totoro_borsatermica_1.jpg', 'immagini/merchandising/totoro_borsatermica_2.jpg', '2024-01-04', 9, 2),
(22, 'Calzini "Il mio vicino Totoro"', 'Merchandising', 'Accessori', 'Confezione da 5 paia. Taglia unica.', 20, 'immagini/merchandising/totoro_calzini_1.jpg', 'immagini/merchandising/totoro_calzini_2.jpg', '2024-01-04', 12, 2),
(23, 'Federa per cuscini "Il castello errante di Howl"', 'Merchandising', 'Decorazioni per la casa', 'Realizzata in lino e con colori vividi. Temperatura massima di lavaggio 40 gradi Celsius. Lavaggio non a secco.', 10, 'immagini/merchandising/howl_federa.jpg', NULL, '2024-01-04', 9, 7),
(24, 'Orecchini "Il mio vicino Totoro"', 'Merchandising', 'Accessori', 'Questi orecchini saranno un bel regalo per te o per qualcuno che ami, sono stati creati per donarti un sorriso!', 10.9, 'immagini/merchandising/totoro_orecchini_1.jpg', 'immagini/merchandising/totoro_orecchini_2.jpg', '2024-01-20', 15, 2),
(25, 'Maglietta con Jiji "Kiki consegne a domicilio"', 'Merchandising', 'Abbigliamento', '100% cotone. Senza impunture, lunghezza classica, con rifiniture su collo e spalle.', 16.9, 'immagini/merchandising/kiki_maglietta.jpg', NULL, '2024-01-20', 32, 3),
(26, 'Luce LED multicolor "La principessa Mononoke"', 'Merchandising', 'Decorazioni per la casa', '7 colori senza telecomando. 16 colori con telecomando. Base lampada nera (illuminazione verso l’alto) o lava (la luce viene emessa da tutte le direzioni e dona un effetto luminoso e cristallino).', 25.62, 'immagini/merchandising/mononoke_lampada_1.jpg', 'immagini/merchandising/mononoke_lampada_2.jpg', '2024-01-20', 29, 5),
(27, 'Felpa "Ponyo sulla scogliera"', 'Merchandising', 'Abbigliamento', '100% cotone. Taglia unica. Rendi le giornate fredde più calde e confortevoli con questa felpa. Realizzata con particolare attenzione ai dettagli, insieme ad un’insuperabile qualità, questa felpa è il perfetto abbigliamento casual per autunno e inverno.', 38.5, 'immagini/merchandising/ponyo_felpa.jpg', NULL, '2024-01-20', 24, 8),
(28, 'Poster "Nausicaä della valle del vento"', 'Merchandising', 'Poster', 'Con disegni in edizione super limitata. Disponibile solo per poco tempo.', 39.9, 'immagini/merchandising/nausicaa_poster.jpg', NULL, '2024-02-03', 4, 1),
(29, 'Action Figure "La principessa Mononoke"', 'Merchandising', 'Peluches ed Action Figures', 'Set di 5 pezzi. Realizzati in resina estremamente luminosa.\r\n“Sotto la luce della luna ho sentito chiaramente il battito del tuo cuore, un bel fronte freddo e tagliente, come il tuo viso, nel profondo del cuore triste, sapendo che il tuo cuore è solo quello degli elfi degli alberi nella foresta”.', 9.95, 'immagini/merchandising/mononoke_actionfigure_1.jpg', 'immagini/merchandising/mononoke_actionfigure_2.jpg', '2024-02-03', 17, 5),
(30, 'Custodia AirPods "Ponyo sulla scogliera"', 'Merchandising', 'Telefonia', 'Realizzata in silicone. Adatta ad Apple AirPods 1/2/Pro.', 14.68, 'immagini/merchandising/ponyo_custodiacuffie_1.jpg', 'immagini/merchandising/ponyo_custodiacuffie_2.jpg', '2024-02-05', 35, 8),
(31, 'Pupazzetto Warawara "Il ragazzo e l''airone"', 'Merchandising', 'Peluches ed Action Figures', 'Realizzato in cotone, morbido e rifinito con estrema cura.', 23.8, 'immagini/merchandising/airone_peluche_1.jpg', 'immagini/merchandising/airone_peluche_2.jpg', '2024-02-05', 19, 10),
(32, 'Poster in carta kraft "Si alza il vento"', 'Merchandising', 'Poster', 'Realizzato in materiale non impermeabile, senza copertura, per donare un tocco unico e retrò.', 7.15, 'immagini/merchandising/vento_poster_1.jpg', 'immagini/merchandising/vento_poster_2.jpg', '2024-02-08', 5, 9),
(33, 'Tazza "Il ragazzo e l''airone"', 'Merchandising', 'Decorazioni per la casa', 'Realizzata in ceramica di alta qualità. Lavabile in lavastoviglie. Adatta al microonde.', 16.8, 'immagini/merchandising/airone_tazza.jpg', NULL, '2024-02-08', 10, 10),
(34, 'Cover per iPhone "Si alza il vento"', 'Merchandising', 'Telefonia', 'Forma sottile e leggera, totalmente flessibile e resistente. Supporta ricarica wireless.', 16.5, 'immagini/merchandising/vento_cover_1.jpg', 'immagini/merchandising/vento_cover_2.jpg', '2024-02-11', 16, 9);

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `data_di_nascita` date NOT NULL,
  `email` varchar(30) NOT NULL,
  `numero_di_telefono` varchar(15) NOT NULL,
  `citta` varchar(50) NOT NULL,
  `indirizzo` varchar(100) NOT NULL,
  `provincia` varchar(2) NOT NULL,
  `cap` varchar(5) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`id`, `nome`, `cognome`, `data_di_nascita`, `email`, `numero_di_telefono`, `citta`, `indirizzo`, `provincia`, `cap`, `username`, `password`) VALUES
(1, 'Antonio', 'Di Pietro', '1998-07-13', 'a.dipietro@gmail.com', '3108452137', 'San Giovanni Rotondo', 'Via Cappuccini n.20', 'FG', '71013', 'antoDiPedro', 'prOGgECTW0RK!');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `ordini`
--
ALTER TABLE `ordini`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_utente` (`fk_id_utente`);

--
-- Indici per le tabelle `ordini_prodotti`
--
ALTER TABLE `ordini_prodotti`
  ADD KEY `fk_id_ordine` (`fk_id_ordine`),
  ADD KEY `fk_id_prodotto` (`fk_id_prodotto`);

--
-- Indici per le tabelle `prodotti`
--
ALTER TABLE `prodotti`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_film` (`fk_id_film`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `film`
--
ALTER TABLE `film`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT per la tabella `ordini`
--
ALTER TABLE `ordini`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `prodotti`
--
ALTER TABLE `prodotti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `ordini`
--
ALTER TABLE `ordini`
  ADD CONSTRAINT `utente` FOREIGN KEY (`fk_id_utente`) REFERENCES `utente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `ordini_prodotti`
--
ALTER TABLE `ordini_prodotti`
  ADD CONSTRAINT `ordine` FOREIGN KEY (`fk_id_ordine`) REFERENCES `ordini` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prodotto` FOREIGN KEY (`fk_id_prodotto`) REFERENCES `prodotti` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `prodotti`
--
ALTER TABLE `prodotti`
  ADD CONSTRAINT `film` FOREIGN KEY (`fk_id_film`) REFERENCES `film` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
