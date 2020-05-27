DROP TABLE IF EXISTS currency;

CREATE TABLE currency (countryCode VARCHAR(25) NOT NULL, conversionFactor decimal(30,2) NOT NULL);  

INSERT INTO currency (countryCode, conversionFactor) VALUES

('USD', 5.2),

 ('EUR', 10.5),

 ('INR', 11);