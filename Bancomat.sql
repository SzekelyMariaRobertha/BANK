SET SQL_SAFE_UPDATES = 0;
drop database if exists Bancomat;
create database Bancomat;
use Bancomat;
create table utilizator
(
-- user
idUtilizator int primary key,
tipUtilizator varchar(10),
cnp varchar(13),
nume varchar(20),
prenume varchar(20),
adresa varchar(40),
nrTelefon varchar(10),
email varchar(20),
contIban varchar(30),
nrContract varchar(10),
pin varchar(4),
detaliiCont varchar(20),
valoareCont double,
expirare varchar(10),
tipDepozit int,
 -- client
dataNasterii varchar(20),
venit int,
statusOnline varchar(10),
angajatResponsabil varchar(25),
 -- angajat
sucursala varchar(20),
norma int,
salariu int,
departament varchar(30),
idTranzactie int

);
-- clienti

insert into utilizator (idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare)
values (1, 'client', '6010407125806', 'Szekely', 'Maria', 'Cluj-Napoca', '0755584774', 'maria@yahoo.com', 'ROBTRL25235346', '10000', '1234', '2001-04-07', 4500, 'true', 'curent', 100000, '01/22');
insert into utilizator(idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare)
values (2, 'client','6010406794321', 'Popescu', 'Cristina', 'Suceava', '0755459240', 'crisii@yahoo.com', 'ROBTRL25432524', '20000', '1235', '1975-01-01', 5000, 'true', 'curent', 0, '09/22');
insert into utilizator(idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare)
values (3, 'client','6010406794321', 'Popescu', 'Cristina', 'Suceava', '0755459240', 'crisii@yahoo.com', 'ROBTRL25234532', '30000', '1236', '1975-01-01', 5000, 'false', 'economii', 12, '05/22');
insert into utilizator(idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare)
values (4,  'client','6023487619734', 'Ionescu', 'Cosmina', 'Cluj', '0767893265', 'cosmi.ioni@yahoo.com', 'ROING25789352', '40000', '1236', '2001-05-24', 3000, 'false', 'economii', 500, '09/23');
insert into utilizator (idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare)
values (5,  'client','6010786542468', 'Todea', 'George', 'Arad', '0758976453', 'geo.todea@yahoo.com', 'ROING25274346', '50000', '1237', '1968-03-29', 4500, 'true', 'curent', 1200, '01/24');
insert into utilizator (idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare)
values (6,  'client','6010723542468', 'Matei', 'Ana', 'Baia Mare', '0758764530', 'anaa@yahoo.com', 'ROING25273446', '60000', '1238', '2000-03-29', 4500, 'true', 'curent', 600, '01/23');
insert into utilizator (idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare)
values (7,  'client', '6010723542468', 'Matei', 'Ana', 'Baia Mare', '0758764530', 'anaa@yahoo.com', 'ROING27897344', '70000', '1238', '2000-03-29', 4500, 'true', 'plati', 798, '01/24');
insert into utilizator (idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare)
values (8,  'client', '6010723542468', 'Matei', 'Ana', 'Baia Mare', '0758764530', 'anaa@yahoo.com', 'ROING23473446', '80000', '1238', '2000-03-29', 4500, 'true', 'economii', 988, '01/24');
insert into utilizator (idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare)
values (9,  'client', '6010723542468', 'Matei', 'Ana', 'Baia Mare', '0758764530', 'anaa@yahoo.com', 'ROING22373446', '90000', '1238', '2000-03-29', 4500, 'true', 'curent', 566, '01/24');
insert into utilizator (idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare, tipDepozit)
values (10,  'client','6010723542468', 'Matei', 'Ana', 'Baia Mare', '0758764530', 'anaa@yahoo.com', 'ROING22873446', '100000', '1238', '2000-03-29', 4500, 'true', 'depozit', 50, '01/24', 1);
insert into utilizator (idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare, tipDepozit)
values (11,  'client', '6010723888468', 'Moc', 'Stefania', 'Bucuresti', '0758789530', 'mock@yahoo.com', 'ROBTRL27897344', '110000', '1300', '2000-03-29', 2000, 'false', 'depozit', 20, '01/24', 3);
insert into utilizator (idUtilizator, tipUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, valoareCont, expirare, tipDepozit)
values (12,  'client', '6010723111468', 'Bivolaru', 'Lia', 'Bihor', '0746764530', 'Mishu@yahoo.com', 'ROBTRL11173446', '120000', '1400', '2000-03-29', 4500, 'false', 'depozit', 800, '01/24', 6);


-- angajati
insert into utilizator (idUtilizator, tipUtilizator, nume, prenume, sucursala, norma, salariu, departament, nrContract, pin, detaliiCont, valoareCont, contIban )
values (30, 'angajat', 'Gheorghe', 'Viorel', 'Galati', 1500, 50000, 'IT', '54654', '0000', 'curent', 4500, 'ROING25899359');
insert into utilizator (idUtilizator, tipUtilizator, nume, prenume, sucursala, norma, salariu, departament, nrContract, pin, detaliiCont, valoareCont, contIban)
values (40, 'angajat', 'Pavel', 'Viorel', 'Galati', 1500, 50000, 'IT', '1233', '3333', 'curent', 4500, 'ROING95899352');

-- admin
insert into utilizator (idUtilizator, tipUtilizator, nume, prenume, sucursala, norma, salariu, departament, nrContract, pin, detaliiCont, valoareCont, contIban)
values (100, 'admin', 'Orbeanu', 'Alina', 'Bacau', 2000, 55000, 'IT', '87987', '9999', 'curent', 9999999, 'ROING25899352'); 

create table contacteFavorite
(
idContacteFavorite int,
utilizator_id int,
index utiliz_index (utilizator_id),
Foreign key (utilizator_id) references utilizator(idUtilizator)
);

insert into contacteFavorite (utilizator_id, idContacteFavorite)
values (1, 2);
insert into contacteFavorite (utilizator_id, idContacteFavorite)
values (2, 5);
insert into contacteFavorite (utilizator_id, idContacteFavorite)
values (5, 1);
insert into contacteFavorite (utilizator_id, idContacteFavorite)
values (5, 2);

create table if not exists cerere_angajat (
denumireCerere varchar(50),
aprobare_angajat varchar(25) default 'DA',
aprobare_admin varchar(25),
utilizator_idd int, 
index utilizator_index(utilizator_idd),
foreign key(utilizator_idd) references utilizator(idUtilizator)
);

create table if not exists useless (
id int,
nume varchar(25),
prenume varchar(25),
contiban varchar(25),
cerere varchar(50)
);
/*
insert into  utilizator(idUtilizator, nume) VALUES (34, 'ana');
insert into useless(id) values (34);
select * from useless;
/*
SELECT detaliiCont, valoareCont FROM utilizator WHERE nrContract = '90000';
SELECT valoareCont FROM utilizator WHERE contIban = 'ROING22873446';
UPDATE utilizator SET valoareCont = valoareCont + ( 50 - 0.2*50)  WHERE nrContract = '90000';
DELETE FROM utilizator WHERE contIban = 'ROING22873446';


/*
-- select valoareCont from utilizator where contIban = 'ROING25899352';
-- UPDATE utilizator SET  valoareCont = valoareCont - (2 *100) WHERE nrContract = '87987';
select valoareCont from utilizator where nrContract = '45000';

/*
select valoareCont from utilizator where nrContract = '10000';
UPDATE utilizator SET  valoareCont = valoareCont - (50 * 0.1) - 50 WHERE nrContract = '10000';
select valoareCont from utilizator where nrContract = '10000';

/*
insert into useless(id, nume, prenume, contiban, cerere) values ('10', 'Ana', 'Popa', 'robtrl', 'card');
select *  from useless;

insert into cerere_angajat(denumireCerere, utilizator_idd) values ("Solicitare Card", 10);
select * from utilizator, cerere_angajat where idUtilizator = utilizator_idd;

/*
insert into cerere_angajat(denumireCerere, utilizator_idd) values ("Solicitare Card", 10);
select nume, prenume, contIban from utilizator, cerere_angajat where idUtilizator = utilizator_idd;
*/
 /*
Select denumireCerere, utilizator_idd from cerere_angajat;
select nume, prenume, contIban from utilizator, cerere_angajat where idUtilizator = utilizator_idd;

insert into cerere_angajat(denumireCerere, utilizator_idd) values ("Solicitare Card", 9);
select nume, prenume, contIban, idUtilizator, denumireCerere from utilizator, cerere_angajat where idUtilizator = utilizator_idd;
*/
/*select u.nume
from contacteFavorite
         left join utilizator u on u.idUtilizator = contacteFavorite.idContacteFavorite
         left join utilizator u2 on u2.idUtilizator = contacteFavorite.utilizator_id
where u2.nrContract = 10000*/

-- SELECT nume, prenume, tipUtilizator FROM utilizator where tipUtilizator = 'client' or tipUtilizator = 'angajat' ;
-- SELECT cnp, COUNT(*) FROM utilizator Where cnp = '6010723542468';
-- UPDATE utilizator SET valoareCont = valoareCont+20 Where contIban = 'ROING22873446';
-- SELECT contIban, valoareCont FROM utilizator WHERE contIban = 'ROING22873446';
-- UPDATE utilizator SET  valoareCont = valoareCont - 20 Where contIban = 'ROING22873446' and (valoareCont > 20 and valoareCont > 0);
-- SELECT contIban, valoareCont FROM utilizator WHERE contIban = 'ROING22873446';