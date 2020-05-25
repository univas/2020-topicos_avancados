-- Table "users"
CREATE TABLE users (
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  enabled smallint NOT NULL,
  PRIMARY KEY (username)
);

INSERT INTO users VALUES ('joao','{noop}aluno123',1);
INSERT INTO users VALUES ('jonas','{noop}secretaria123',1);
INSERT INTO users VALUES ('julia','{noop}admin123',1);


-- Table authorities
CREATE TABLE authorities (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,
  CONSTRAINT authorities_idx_1 UNIQUE (username,authority),
  CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO authorities VALUES ('joao','ROLE_STUDENT');
INSERT INTO authorities VALUES ('jonas','ROLE_SECRETARY');
INSERT INTO authorities VALUES ('julia','ROLE_SECRETARY');
INSERT INTO authorities VALUES ('julia','ROLE_ADMIN');
