insert into UTILISATEUR (LOGIN, PASSWORD, NOM, PRENOM) values ('amal@email.com', 'secret','BOUKILI','Amal');
insert into UTILISATEUR (LOGIN, PASSWORD, NOM, PRENOM) values ('dthibau@wmmod.com', 'secret','THIBAU','David');
insert into UTILISATEUR (LOGIN, PASSWORD, NOM, PRENOM) values ('toto@titi.com', 'secret','TITI','Toto');

insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION,DISPONIBLE) values ('CD1', 2, '1997-04-25', true);
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION,DISPONIBLE) values ('CD2', 3, '2000-01-10', true);
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION,DISPONIBLE) values ('CD3', 13, '2022-12-15', true);

insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION,DISPONIBLE) values ('DVD1', 4, '1970-03-28', true);
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION,DISPONIBLE) values ('DVD2', 5, '1999-01-18', true);
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION,DISPONIBLE) values ('DVD3', 11, '2021-12-20', true);

insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION,DISPONIBLE) values ('livre1', 6, '2010-04-14', true);
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION,DISPONIBLE) values ('livre2', 7, '1999-09-25', true);
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION,DISPONIBLE) values ('livre3', 11, '2021-02-02', true);



insert into CD (ARTISTE_GROUP, DUREE,NOMBRE_TITRE,ID) values ('artiste1', 120,6,1);
insert into CD (ARTISTE_GROUP, DUREE,NOMBRE_TITRE,ID) values ('artiste2', 125,5,2);
insert into CD (ARTISTE_GROUP, DUREE,NOMBRE_TITRE,ID) values ('artiste3', 115,5,3);


insert into DVD (REALISATEUR, DUREE, TYPE,ID) values ('Realisateur1', 158, 'NORMAL',4);
insert into DVD (REALISATEUR, DUREE, TYPE,ID) values ('Realisateur2', 159, 'BLUE_RAY',5);
insert into DVD (REALISATEUR, DUREE, TYPE,ID) values ('Realisateur3', 150, 'BLUE_RAY',6);

insert into LIVRE (ECRIVAIN, NUM_ISBN,ID) values ('ecrivain1', 140,7);
insert into LIVRE (ECRIVAIN, NUM_ISBN,ID) values ('ecrivain2', 150,8);
insert into LIVRE (ECRIVAIN, NUM_ISBN,ID) values ('ecrivain3', 160,9);