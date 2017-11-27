-- Mappa Parametri
CREATE TABLE HBN_MAPPA_PARAMETRI 
(
  COD_PARAMETRO VARCHAR2(100 BYTE) NOT NULL 
, DES_PARAMETRO VARCHAR2(100 BYTE) 
, ID_USER VARCHAR2(50 BYTE) DEFAULT 'SYSTEM' NOT NULL 
, ID_TIMESTAMP TIMESTAMP(6) DEFAULT SYSTIMESTAMP NOT NULL 
, CONSTRAINT PK_HBN_MAPPA_PARAMETRI PRIMARY KEY 
  (
    COD_PARAMETRO 
  )
);