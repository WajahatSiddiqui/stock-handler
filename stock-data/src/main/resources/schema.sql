CREATE TABLE quote (
symbol CHAR(10),
event_time timestamp,
open float,
high float,
low float,
price float,
change_percentage float,
PRIMARY KEY(symbol, event_time));