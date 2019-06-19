INSERT INTO funzionario (id , username , password) VALUES (1 , 'admin' , '$2a$10$H8fl2lxJIBMY46CGlT773uQDfNVYM8eFMHIbW4kRxwSgNcvAmQRJW');

INSERT INTO album (id , nome, descrizione) VALUES (2 , 'Natura' , 'La bellezza della nostra terra' );

INSERT INTO album (id , nome, descrizione) VALUES (3 , 'Tramonto' , 'La potenza del Sole' );

INSERT INTO fotografo (id , nome, cognome) VALUES (4 ,'Francesco' , 'Piccolo' );

INSERT INTO fotografo (id , nome, cognome) VALUES (5 , 'Luigi' , 'Zicchittu' );

INSERT INTO fotografia (id , nome, descrizione , album_id , fotografo_id ) VALUES ('natura1.jpg' , 'Montagna' , 'Prato e Montagna' , 2 , 5 );

INSERT INTO fotografia (id , nome, descrizione , album_id , fotografo_id ) VALUES ('natura2.jpg' , 'Tridente Marino' , 'Ade affiora' , 2 , 5 );

INSERT INTO fotografia (id , nome, descrizione , album_id , fotografo_id ) VALUES ('natura3.jpg' , 'Torrente' , 'La vita nel Deserto' , 2 , 5 );

INSERT INTO fotografia (id , nome, descrizione , album_id , fotografo_id ) VALUES ('natura4.jpg' , 'Quiete e Tempesta' , 'Paesaggio Scuro' , 2 , 5 );

INSERT INTO fotografia (id , nome, descrizione , album_id , fotografo_id ) VALUES ('natura5.jpg' , 'Iceberg' , 'Pericolo affioramento' , 2 , 5 );

INSERT INTO fotografia (id , nome, descrizione , album_id , fotografo_id ) VALUES ('sunset1.jpg' , 'Tramonto Oscuro' , 'Un tramonto nella Notte' , 3 , 4 );

INSERT INTO fotografia (id , nome, descrizione , album_id , fotografo_id ) VALUES ('sunset2.jpg' , 'Tramonto nel Fiume' , 'Un bel tramonto sulle sponde della vita' , 3 , 4 );

INSERT INTO fotografia (id , nome, descrizione , album_id , fotografo_id ) VALUES ('sunset3.jpg' , 'Barca e Tramonto' , 'Una barca costeggia un tramonto' , 3 , 4 );

INSERT INTO fotografia (id , nome, descrizione , album_id , fotografo_id ) VALUES ('sunset4.jpg' , 'Baia al Tramonto' , 'Casette in riva al mare' , 3 , 4 );

INSERT INTO fotografia (id , nome, descrizione , album_id , fotografo_id ) VALUES ('sunset5.jpg' , 'Roccaforte al Tramonto' , 'Le rovine si colorano di rosso' , 3 , 4 );