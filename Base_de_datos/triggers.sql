-- Trigger para comprobar que se cumplan todos los requisitos de la liga
--> Trigger para asegurar que no se insertan mas de dos wildcard en un equipo


CREATE OR REPLACE TRIGGER ComprobarPlantilla
BEFORE INSERT OR UPDATE ON JORNADAS
FOR EACH ROW
DECLARE

V_CursorNumJugadores SYS_REFCURSOR;
V_NumJugadoresEquipo number;
V_NumEquipos number;
JugadoresInsuficientes EXCEPTION;
EquiposInsuficientes EXCEPTION;
 
BEGIN

    Select count(*) into  V_NumEquipos
    from equipos;

    if v_NumEquipos = 12 then
        OPEN V_CursorNumJugadores FOR
  			SELECT COUNT(J.IDJUGADOR) AS "JUGADORES", E.ID
  			FROM JUGADORESEQUIPOS J, EQUIPOS E
            WHERE J.IDEQUIPO(+) = E.ID
  			GROUP BY E.ID;

    LOOP

  				FETCH V_CursorNumJugadores into V_NumJugadoresEquipo;

  				EXIT WHEN V_CursorNumJugadores%NOTFOUND;

  				IF V_NumJugadoresEquipo < 8 THEN

  					RAISE JugadoresInsuficientes;

  				END IF;
                
                

  				END LOOP;
        else
            raise EquiposInsuficientes;
        end if;

EXCEPTION
 WHEN JugadoresInsuficientes THEN
   		RAISE_APPLICATION_ERROR(-20001,'Los equipos no cumplen el minimo de 
        jugadores requeridos para crear el calendario.');
 when EquiposInsuficientes then
    RAISE_APPLICATION_ERROR(-20002,'Tiene que haber 12 equipos');
    
END;

--******************************************************************************
-- Trigger para mirar si la liga esta abierta o cerrada

CREATE OR REPLACE TRIGGER ModificarPlantillas
BEFORE INSERT OR UPDATE OR DELETE ON JUGADORESEQUIPOS
DECLARE

    V_Estado VARCHAR2(10);
    LigaCerrada EXCEPTION;

BEGIN

    SELECT TIPO INTO V_Estado
    FROM SPLIT;

    IF UPPER(V_Estado) = 'CERRADO' THEN
        
        RAISE LigaCerrada;
        
    END IF;
    
EXCEPTION 
    WHEN  LigaCerrada then
        RAISE_APPLICATION_ERROR(-20000,'La liga esta cerrada');

END ModificarPlantillas;


/*

update JUGADORESEQUIPOS
set clausula = 15100000
where idjugador = 4;


Error que empieza en la línea: 72 del comando :
update JUGADORESEQUIPOS
set clausula = 15100000
where idjugador = 4
Informe de error -
ORA-20000: La liga esta cerrada
ORA-06512: en "EQDAW03.MODIFICARPLANTILLAS", línea 19
ORA-04088: error durante la ejecución del disparador 'EQDAW03.MODIFICARPLANTILLAS'
*/

--****************************************************************************




