-- Trigger para comprobar que se cumplan todos los requisitos de la liga
--> Trigger para asegurar que no se insertan mas de dos wildcard en un equipo

CREATE OR REPLACE TRIGGER ComprobarPlantilla
BEFORE INSERT OR UPDATE ON JORNADAS
FOR EACH ROW
DECLARE

V_JugadoresDraft                SYS_REFCURSOR;
V_JugadoresWildCard             SYS_REFCURSOR;
V_NumJugadores                  NUMBER;
V_NumEquipos                    NUMBER;
JugadoresDraftInsuficientes     EXCEPTION;
JugadoresWildCardSobrepasados   EXCEPTION;
EquiposInsuficientes            EXCEPTION;
 
BEGIN

    SELECT COUNT(*) INTO  V_NumEquipos
    FROM equipos;

    IF v_NumEquipos = 12 THEN
        
        OPEN V_JugadoresDraft FOR
        SELECT COUNT(J.IDJUGADOR)
        FROM JUGADORESEQUIPOS J, EQUIPOS E, JUGADORES JU
        WHERE J.IDEQUIPO(+) = E.ID AND JU.ID = J.IDJUGADOR 
        AND UPPER(JU.TIPO)='DRAFT'
        GROUP BY E.ID;

        LOOP

            FETCH V_JugadoresDraft INTO V_NumJugadoresEquipo;

        	EXIT WHEN V_JugadoresDraft%NOTFOUND;

    		IF V_NumJugadores < 8 THEN

				RAISE JugadoresDraftInsuficientes;
                
            END IF;
                
        END LOOP;

        OPEN V_JugadoresDraft FOR
        SELECT COUNT(J.IDJUGADOR)
        FROM JUGADORESEQUIPOS J, EQUIPOS E, JUGADORES JU
        WHERE J.IDEQUIPO(+) = E.ID AND JU.ID = J.IDJUGADOR 
        AND UPPER(JU.TIPO)='WILDCARD'
        GROUP BY E.ID;

        LOOP 

            FETCH V_JugadoresWildCard INTO V_NumJugadoresEquipo;

        	EXIT WHEN V_JugadoresWildCard%NOTFOUND;

    		IF V_NumJugadores > 2 THEN

				RAISE JugadoresWildCardSobrepasados;
                
            END IF;
                
        END LOOP;

    ELSE
    
        RAISE EquiposInsuficientes;
            
    END IF;

EXCEPTION

    WHEN JugadoresDraftInsuficientes THEN
   		RAISE_APPLICATION_ERROR(-20001,'Los equipos no cumplen el minimo de 
        jugadores tipo draft requeridos para crear el calendario.');
        
    WHEN JugadoresWildfCardSobrepasados THEN
        RAISE_APPLICATION_ERROR(-20002,'Los equipos superan el maximo de 
        jugadores tipo WildCard.');
        
    WHEN EquiposInsuficientes THEN
        RAISE_APPLICATION_ERROR(-20003,'Tiene que haber 12 equipos');
    
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




