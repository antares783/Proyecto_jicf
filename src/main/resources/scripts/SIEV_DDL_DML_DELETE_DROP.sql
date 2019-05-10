---------------------GENERAL---------------------
--DELETE FROM dbo.TC_SISTEMAS;
--DROP TABLE dbo.TC_SISTEMAS;
--DELETE FROM dbo.TC_SISTEMAS_CATALOGOS;
--DROP TABLE dbo.TC_SISTEMAS_CATALOGOS;
--DELETE FROM dbo.TC_MODELO;
--DROP TABLE dbo.TC_MODELO;
--DELETE FROM dbo.TC_MARCA;
--DROP TABLE dbo.TC_MARCA;
--DELETE FROM DBO.TC_PLAN;
--DROP TABLE DBO.TC_PLAN;
--DELETE FROM DBO.TC_TIPO_PLAZO;
--DROP TABLE DBO.TC_TIPO_PLAZO;
--DELETE FROM DBO.TT_WS_LLAMADA_RESPUESTA;
--DROP TABLE DBO.TT_WS_LLAMADA_RESPUESTA;

--DROP SEQUENCE DBO.SEQUENCE_TT_WS_LLAMADA_RESPUESTA;

---------------------SAFIN---------------------
DELETE FROM dbo.TC_SAFIN_TIPOS_PRODUCTO;
DROP TABLE dbo.TC_SAFIN_TIPOS_PRODUCTO;
DELETE FROM dbo.TC_SAFIN_SISTEMAS;
DROP TABLE dbo.TC_SAFIN_SISTEMAS;
DELETE FROM dbo.TC_SAFIN_MERCADOS;
DROP TABLE dbo.TC_SAFIN_MERCADOS;
DELETE FROM dbo.TC_SAFIN_MOVIMIENTOS;
DROP TABLE dbo.TC_SAFIN_MOVIMIENTOS;
DELETE FROM dbo.TC_SAFIN_CANALES;
DROP TABLE dbo.TC_SAFIN_CANALES;
DELETE FROM dbo.TC_SAFIN_FORMAS_PAGO;
DROP TABLE dbo.TC_SAFIN_FORMAS_PAGO;

---------------------CREDIT CHECK---------------------
--DELETE FROM dbo.TC_CREDCHECK_CANALES_VENTA;
--DROP TABLE dbo.TC_CREDCHECK_CANALES_VENTA;
--DELETE FROM dbo.TC_CREDCHECK_REGIONES;
--DROP TABLE dbo.TC_CREDCHECK_REGIONES;
--DELETE FROM dbo.TC_CREDCHECK_ESTADOS;
--DROP TABLE dbo.TC_CREDCHECK_ESTADOS;
--DELETE FROM dbo.TC_CREDCHECK_FUERZAS_VENTA;
DELETE FROM dbo.TC_CREDCHECK_MARCAS;
DROP TABLE dbo.TC_CREDCHECK_MARCAS;
DELETE FROM dbo.TC_CREDCHECK_MODELOS;
DROP TABLE dbo.TC_CREDCHECK_MODELOS;
DELETE FROM dbo.TT_WS_LLAMADA_RESPUESTA;
DROP TABLE dbo.TT_WS_LLAMADA_RESPUESTA;
DELETE FROM dbo.TC_PRUEBA;
DROP TABLE dbo.TC_PRUEBA;
DELETE FROM dbo.Prueba;
DROP TABLE dbo.Prueba;