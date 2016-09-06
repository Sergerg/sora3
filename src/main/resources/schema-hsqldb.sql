CREATE TABLE contact (
  nick VARCHAR(255) NOT NULL UNIQUE,
  name text,
  email text,
  phone text
);

INSERT INTO contact (nick, name, email, phone)
VALUES ('adm', 'Admin', 'admin@a.a', '');
