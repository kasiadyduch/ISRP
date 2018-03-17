-- tworzenie bazy danych
CREATE TABLE lekarze(
  id_lekarza SERIAL PRIMARY KEY,
  imie text,
  nazwisko text,
  id_poradni INTEGER,
  nr_telefonu text,
  email text,
  login text,
  haslo text
);

CREATE TABLE pacjenci(
  id_pacjenta SERIAL PRIMARY KEY,
  imie text,
  nazwisko text,
  pesel text,
  nr_telefonu text,
  ulica text,
  nr_domu text,
  kod_pocztowy text,
  miejscowosc text,
  email text,
  login text,
  haslo text,
  id_zakladu INTEGER
);

CREATE TABLE poradnie(
  id_poradni SERIAL PRIMARY KEY,
  opis text
);

CREATE TABLE poradnie_lekarze(
  id  SERIAL PRIMARY KEY,
  id_poradni INTEGER,
  id_lekarza INTEGER
);

CREATE TABLE zaklady_pracy(
  id_zakladu  SERIAL PRIMARY KEY,
  nazwa TEXT,
  nip TEXT,
  ulica TEXT,
  nr_budynku TEXT,
  kod_pocztowy TEXT,
  miejscowosc TEXT
);

CREATE TABLE rezerwacje_mp (
  id_mp  SERIAL PRIMARY KEY,
  id_pacjenta INTEGER,
  id_zakladu INTEGER,
  id_badania INTEGER,
  nr_rezerwacji SERIAL
);

CREATE TABLE badania(
  id_badania SERIAL PRIMARY KEY,
  typ_badania TEXT
);

CREATE TABLE rezerwacje(
  id_rezerwacji  SERIAL PRIMARY KEY,
  id_lekarza INTEGER,
  id_pacjenta INTEGER,
  data text,
  godzina TIME
);

CREATE TABLE gabinety(
  id_gabinetu SERIAL PRIMARY KEY,
  id_poradni INTEGER
);

-- dodawanie kluczy obcych
ALTER TABLE rezerwacje_mp
  ADD CONSTRAINT my_fk17
FOREIGN KEY (id_badania)
REFERENCES badania
ON DELETE CASCADE;

-- zapełnianie tabel
INSERT INTO pacjenci (imie, nazwisko, pesel, nr_telefonu, ulica, nr_domu, kod_pocztowy, miejscowosc, email, login, haslo) VALUES
  ('Alicja', 'Mróz', '90021345678', '555-600-700', 'Urodzajna', '8/11', '43-300', 'Bielsko-Biała', 'alicjamroz@email.com', 'mroza', 'mroza'),
  ('Stefan', 'Kowalski', '53010202180', '600-000-999', 'Żywiecka', '30', '43-365', 'Wilkowice', 'stefankowalski@email.com', 'kowalskis', 'kowalskis'),
  ('Katarzyna', 'Kos', '80090811132', '800-111-111', 'Michałowicza', '120', '43-300', 'Bielsko-Biała', 'katarzynakos@email.com', 'koskat', 'koskat');

INSERT INTO poradnie_lekarze (id_poradni, id_lekarza) VALUES
  (1, 1),
  (2, 1),
  (1, 2),
  (3, 3),
  (4, 3);

INSERT INTO zaklady_pracy (nazwa, nip, ulica, nr_budynku, kod_pocztowy, miejscowosc) VALUES
  ('FCA Poland S.A.', '1234567890', 'Grażyńskiego', '141', '43-300', 'Bielsko-Biała');

INSERT INTO rezerwacje (id_lekarza, id_pacjenta, data, godzina) VALUES
  (2, 4, '2018-01-02', '08:30');

INSERT INTO rezerwacje_mp (id_pacjenta, id_zakladu, id_badania) VALUES
  (2, 1, 2);

INSERT INTO badania (typ_badania) VALUES
  ('wstępne'),
  ('okresowe'),
  ('kontrolne');

SELECT *
FROM pacjenci
ORDER BY id_pacjenta;