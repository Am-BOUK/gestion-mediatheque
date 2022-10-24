insert into UTILISATEUR (LOGIN, PASSWORD, NOM, PRENOM) values ('amal@email.com', 'secret','BOUKILI','Amal');
insert into UTILISATEUR (LOGIN, PASSWORD, NOM, PRENOM) values ('dthibau@wmmod.com', 'secret','THIBAU','David');
insert into UTILISATEUR (LOGIN, PASSWORD, NOM, PRENOM) values ('toto@titi.com', 'secret','TITI','Toto');

insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION) values ('CD1', 2, '1997-04-25');
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION) values ('CD2', 0, '2000-01-10');
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION) values ('CD3', 13, '2022-12-15');

insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION) values ('DVD1', 0, '1970-03-28');
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION) values ('DVD2', 5, '1999-01-18');
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION) values ('DVD3', 11, '2021-12-20');

insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION) values ('livre1', 6, '2010-04-14');
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION) values ('livre2', 7, '1999-09-25');
insert into ITEM (TITRE, NOMBRE_EXEMPLAIRE, DATE_PARUTION) values ('livre3', 0, '2021-02-02');



insert into CD (ARTISTE_GROUP, DUREE,NOMBRE_TITRE,ID) values ('artiste1', 120,6,1);
insert into CD (ARTISTE_GROUP, DUREE,NOMBRE_TITRE,ID) values ('artiste2', 125,5,2);
insert into CD (ARTISTE_GROUP, DUREE,NOMBRE_TITRE,ID) values ('artiste3', 115,5,3);


insert into DVD (REALISATEUR, DUREE, TYPE,ID) values ('Realisateur1', 158, 'NORMAL',4);
insert into DVD (REALISATEUR, DUREE, TYPE,ID) values ('Realisateur2', 159, 'BLUE_RAY',5);
insert into DVD (REALISATEUR, DUREE, TYPE,ID) values ('Realisateur3', 150, 'BLUE_RAY',6);

insert into LIVRE (ECRIVAIN, NUM_ISBN,ID) values ('ecrivain1', 140,7);
insert into LIVRE (ECRIVAIN, NUM_ISBN,ID) values ('ecrivain2', 150,8);
insert into LIVRE (ECRIVAIN, NUM_ISBN,ID) values ('ecrivain3', 160,9);

insert into EMPRUNT(ID, DATE_EMPRUNT, DATE_RETOUR, USER_id) values (1, '2022-10-21','2022-10-21',1);
insert into EMPRUNT_ITEMS(EMPRUNTS_ID, ITEMS_ID) values (1, 1);
insert into EMPRUNT_ITEMS(EMPRUNTS_ID, ITEMS_ID) values (1, 2);


