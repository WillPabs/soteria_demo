DROP TABLE IF EXISTS USER;

CREATE TABLE USER (
  id LONG AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);