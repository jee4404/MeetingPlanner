-- table employé
create table employe (
	id int primary key not null,
	nom text not null,
	prenom text not null
);

-- table local
create table local (
	code text PRIMARY KEY not null,
	capacite int not null
);

-- table réunion
create table reunion (
	id int not null primary key,
	date_evenement int not null,
	heure_evenement int not null,
	organisateur int not null,
	liste_participants int
);