CREATE TABLE quote (
id BIGINT PRIMARY KEY,
symbol CHAR(10) NOT NULL,
timestamp TIMESTAMP,
open float,
high float,
low float,
price float,
change_percentage float
);