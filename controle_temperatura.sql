CREATE DATABASE controle_temperatura
GO

USE controle_temperatura
GO

CREATE TABLE BME280 (
localDateTime DATETIME,
pressure      DECIMAL(7, 2),
humidity      DECIMAL(4, 2),
temperature   DECIMAL(4, 2)
PRIMARY KEY(localDateTime)
)
GO

INSERT INTO BME280 (localDateTime, pressure, humidity, temperature)
VALUES             (GETDATE(), 10.00, 10.00, 20.00)  

INSERT INTO BME280 (localDateTime, pressure, humidity, temperature)
VALUES             (GETDATE(), 10.00, 10.00, 30.00)

SELECT * FROM BME280 WHERE temperature = 30.00
SELECT * FROM BME280

CREATE PROCEDURE sp_inserir_temperatura(@localDateTime DATETIME,
                                        @pressure DECIMAL(7, 2),
										@humidity DECIMAL(7, 2),
										@temperature DECIMAL(4, 2))
AS
BEGIN
     INSERT INTO BME280 (localDateTime, pressure, humidity, temperature)
	 VALUES             (@localDateTime, @pressure, @humidity, @temperature)
END

