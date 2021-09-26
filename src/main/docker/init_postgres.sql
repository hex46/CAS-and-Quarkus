CREATE USER app WITH PASSWORD 'app' CREATEDB;
CREATE DATABASE app
    WITH 
    OWNER = app
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE app.user (
    id integer PRIMARY KEY,
    email varchar(150) NOT NULL,
    password varchar(250) NOT NULL
);
   