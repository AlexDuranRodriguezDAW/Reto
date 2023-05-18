-- Trigger para comprobar que se cumplan todos los requisitos de la liga
--> Trigger para asegurar que no se insertan mas de dos wildcard en un equipo

CREATE OR REPLACE TRIGGER ComprobarPlantilla
BEFORE INSERT OR UPDATE ON JORNADAS
FOR EACH ROW
DECLARE

V_JugadoresDraft                SYS_REFCURSOR;
V_JugadoresWildCard             SYS_REFCURSOR;
V_Jugadores                     SYS_REFCURSOR;
V_NumJugadores                  NUMBER;
V_NumEquipos                    NUMBER;
JugadoresDraftInsuficientes     EXCEPTION;
JugadoresWildCardSobrepasados   EXCEPTION;
NumEquiposError                 EXCEPTION;
NumJugadoresError               EXCEPTION;
 
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
    
        OPEN V_Jugadores FOR
        SELECT COUNT(*)
        FROM JUGADORESEQUIPOS
        GROUP BY IDEQUIPO;
        
        LOOP 
        FETCH V_Jugadores INTO V_NumJugadores;
        
        EXIT WHEN V_Jugadores%NOTFOUND;
        
        IF V_NumJugadores > 10 THEN

        LOOP

            FETCH V_JugadoresDraft INTO V_NumJugadores;

        	EXIT WHEN V_JugadoresDraft%NOTFOUND;

    		IF V_NumJugadores < 8 THEN

				RAISE JugadoresDraftInsuficientes;
                
            END IF;
                
        END LOOP;

        OPEN V_JugadoresWildCard FOR
        SELECT COUNT(J.IDJUGADOR)
        FROM JUGADORESEQUIPOS J, EQUIPOS E, JUGADORES JU
        WHERE J.IDEQUIPO(+) = E.ID AND JU.ID = J.IDJUGADOR 
        AND UPPER(JU.TIPO)='WILDCARD'
        GROUP BY E.ID;

        LOOP 

            FETCH V_JugadoresWildCard INTO V_NumJugadores;

        	EXIT WHEN V_JugadoresWildCard%NOTFOUND;

    		IF V_NumJugadores > 2 THEN

				RAISE JugadoresWildCardSobrepasados;
                
            END IF;
                
        END LOOP;
        ELSE
        
            RAISE NumJugadoresError;
            
        END IF;
        END LOOP;
    ELSE
    
        RAISE NumEquiposError;
            
    END IF;
    

EXCEPTION

    WHEN JugadoresDraftInsuficientes THEN
   		RAISE_APPLICATION_ERROR(-20001,'Los equipos no cumplen el minimo de 
        jugadores tipo draft requeridos para crear el calendario.');
        
    WHEN JugadoresWildCardSobrepasados THEN
        RAISE_APPLICATION_ERROR(-20002,'Los equipos superan el maximo de 
        jugadores tipo WildCard.');
                
    WHEN NumEquiposError THEN
        RAISE_APPLICATION_ERROR(-20003,'Tiene que haber 12 equipos');
        
    WHEN NumJugadoreserror THEN
        RAISE_APPLICATION_ERROR(-20004,'Los equipos tiene que tener maximo 10 
        jugadores.');
    
END;


/*


ERROR POR SOBREPASAR EL MAXIMO DE EQUIPOS 

insert into equipos(nombre,presupuesto,sponsor,idduenyo) values('aritz',200000000,'a','1'); 

insert into jornadas(fecha,tipo,idsplit) values (sysdate,'regular',1);


Error que empieza en la lï¿½nea: 7 del comando :
insert into jornadas(fecha,tipo,idsplit) values (sysdate,'regular',1)
Informe de error -
ORA-20003: Tiene que haber 12 equipos
ORA-06512: en "EQDAW03.COMPROBARPLANTILLA", lï¿½nea 76
ORA-04088: error durante la ejecuciï¿½n del disparador 'EQDAW03.COMPROBARPLANTILLA'

ERROR POR NO TENER SUFICIENTES JUGADORES DE DRAFT

Error que empieza en la línea: 4 del comando :
iNSERT INTO JORNADAS (FECHA,TIPO,IDSPLIT) VALUES (SYSDATE,'regular',1)
Informe de error -
ORA-20001: Los equipos no cumplen el minimo de 
        jugadores tipo draft requeridos para crear el calendario.
ORA-06512: en "EQDAW03.COMPROBARPLANTILLA", línea 69
ORA-04088: error durante la ejecución del disparador 'EQDAW03.COMPROBARPLANTILLA'


ERROR POR TENER DEMASIADOS WILDCARD

Error que empieza en la línea: 4 del comando :
iNSERT INTO JORNADAS (FECHA,TIPO,IDSPLIT) VALUES (SYSDATE,'regular',1)
Informe de error -
ORA-20002: Los equipos superan el maximo de 
        jugadores tipo WildCard.
ORA-06512: en "EQDAW03.COMPROBARPLANTILLA", línea 73
ORA-04088: error durante la ejecución del disparador 'EQDAW03.COMPROBARPLANTILLA'

ERROR POR SOBREPASAR EL MAXIMO DE JUGADORES

Error que empieza en la línea: 1 del comando :
insert into jornadas(fecha, tipo, idsplit) values (sysdate, 'regular', 1)
Informe de error -
ORA-20004: Los equipos tiene que tener maximo 10 
        jugadores.
ORA-06512: en "EQDAW03.COMPROBARPLANTILLA", línea 100
ORA-04088: error durante la ejecución del disparador 'EQDAW03.COMPROBARPLANTILLA'


*/


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


Error que empieza en la lï¿½nea: 72 del comando :
update JUGADORESEQUIPOS
set clausula = 15100000
where idjugador = 4
Informe de error -
ORA-20000: La liga esta cerrada
ORA-06512: en "EQDAW03.MODIFICARPLANTILLAS", lï¿½nea 19
ORA-04088: error durante la ejecuciï¿½n del disparador 'EQDAW03.MODIFICARPLANTILLAS'
*/

--****************************************************************************




