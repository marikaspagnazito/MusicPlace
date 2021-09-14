DROP DATABASE IF EXISTS musicplace;
create database musicplace;
use musicplace;


create table utente(
	username char(40) primary key,
    pasword char(20) not null,
    email char(50) not null,
    nome char(30) not null,
    cognome char(30) not null,
    data_nascita date not null,
    citta char(20) not null,
    provincia char(2) not null,
    cap char(5) not null,
    indirizzo char(30) not null,
    civico char(5) not null,
    contatto char(30)
);

create table metodo_pagamento(
    numero char(30) primary key,
    titolare char(30) not null,
    circuito char(20) not null,
    scadenza char(10) not null,
    CVV char(3) not null
);

create table utilizzo(
	username_utente char(40) references utente(username),
    numero_carta char(30) references metodo_pagamento(numero)
);

create table ordine(
    Numero_Ordine int primary key,
    data_ordine date not null,
    somma_pagata double not null,
    IVA double not null,
    numero_carta char(30) references metodo_pagamento(numero),
    username char(40) references utente(username)
);

create table dettaglioOrdine(
    ID int primary key auto_increment,
    ID_ordine int references ordine(Numero_Ordine),
    titolo char(40) not null,
    prezzo double not null,
    IVA double not null,
    ID_album int references album(ID) ,
    ID_brano int references brano(ID) 
);

create table artista(
	ID int primary key auto_increment,
    nome char(30) not null,
    foto varchar(500) not null
);

create table album(
	ID int primary key auto_increment,
    titolo char(50) not null,
    casa_discografica char(20) not null,
	copertina varchar(500),
    prezzo double not null,
    IVA double not null,
    anno_produzione int not null
);

create table incisione(
	ID_artista int references artista(ID),
    ID_album int references album(ID)
);

create table brano(
	ID int primary key auto_increment,
    titolo char(30) not null,
    traccia blob,
    prezzo double not null,
    IVA double not null,
    ID_album int references album(ID)
);

