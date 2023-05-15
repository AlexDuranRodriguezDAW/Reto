
-- PAQUETE REFERENTE AL CALENDARIO (BODY) --

CREATE OR REPLACE PACKAGE BODY DatosCalendario AS

--------------------------------------------------------------------------------
--****************************************************************************--
--------------------------------------------------------------------------------

    PROCEDURE EmparejarLigaRegular
    AS
    
    V_FechaJornada      DATE := SYSDATE;
    V_HoraPartido       VARCHAR(5) := '1600';
    V_IdSplit           SPLIT.ID%TYPE;
    V_IdJornada         JORNADAS.ID%TYPE;
    V_IdJornadaMinima   JORNADAS.ID%TYPE;
    V_IdPartido         PARTIDOS.ID%TYPE;
    V_IdEquipo1         EQUIPOS.ID%TYPE;
    V_IdEquipo2         EQUIPOS.ID%TYPE;
    V_PartidoExiste     NUMBER;
    V_Emparejados       NUMBER;
    
    BEGIN
    
    --CREAR 11 JORNADAS PARA EL ULTIMO SPLIT
        
        SELECT MAX(ID) INTO V_IdSplit
        FROM SPLIT;
        
        FOR NumJornadas IN 1..11
        LOOP
        
        INSERT INTO JORNADAS (FECHA, TIPO, IDSPLIT)
        VALUES(V_FechaJornada, 'regular', V_IdSplit);
        
        V_FechaJornada := V_FechaJornada + 7;
        
        END LOOP;
    
    --OBTENER LOS ID DE LAS JORNADAS
        SELECT MIN(ID) INTO V_IdJornada
        FROM JORNADAS
        WHERE IDSPLIT = V_IdSplit;
        
    --CREAR LOS PARTIDOS PARA CADA JORNADA
    
        V_Emparejados := 1;
        
        
        
        FOR EQUIPO1 IN (SELECT * FROM EQUIPOS) 
        LOOP
        
            SELECT MIN(ID) INTO V_IdJornada
            FROM JORNADAS
            WHERE IDSPLIT = V_IdSplit;
            
            FOR EQUIPO2 IN (SELECT * FROM EQUIPOS)
            LOOP
            
            SELECT COUNT(P.ID) INTO V_PartidoExiste
                FROM PARTIDOS P
                WHERE (P.ID IN (SELECT ID
                                FROM PARTIDOEQUIPO1
                                WHERE IDEQUIPO = EQUIPO1.ID
                                AND IDPARTIDO IN (SELECT ID
                                               FROM PARTIDOS
                                               WHERE IDJORNADA = V_IdJornada)))
                OR (P.ID IN (SELECT ID
                             FROM PARTIDOEQUIPO2
                             WHERE IDEQUIPO = EQUIPO1.ID
                             AND IDPARTIDO IN (SELECT ID
                                               FROM PARTIDOS
                                               WHERE IDJORNADA = V_IdJornada)));
            
            IF V_PartidoExiste = 0 THEN
            
            IF EQUIPO1.ID <> EQUIPO2.ID THEN
                
                SELECT COUNT(P.ID) INTO V_PartidoExiste
                FROM PARTIDOS P
                WHERE (P.ID IN (SELECT ID
                                FROM PARTIDOEQUIPO1
                                WHERE IDEQUIPO = EQUIPO1.ID
                                AND IDPARTIDO IN (SELECT IDPARTIDO
                                                  FROM PARTIDOEQUIPO2
                                                  WHERE IDEQUIPO = EQUIPO2.ID)))
                OR (P.ID IN (SELECT ID
                             FROM PARTIDOEQUIPO2
                             WHERE IDEQUIPO = EQUIPO1.ID
                             AND IDPARTIDO IN (SELECT IDPARTIDO
                                               FROM PARTIDOEQUIPO1
                                               WHERE IDEQUIPO = EQUIPO2.ID)))
                OR (P.ID IN (SELECT ID
                             FROM PARTIDOEQUIPO1
                             WHERE IDEQUIPO = EQUIPO2.ID
                             AND IDPARTIDO IN (SELECT ID
                                               FROM PARTIDOS
                                               WHERE IDJORNADA = V_IdJornada)))
                OR (P.ID IN (SELECT ID
                             FROM PARTIDOEQUIPO2
                             WHERE IDEQUIPO = EQUIPO2.ID
                             AND IDPARTIDO IN (SELECT ID
                                               FROM PARTIDOS
                                               WHERE IDJORNADA = V_IdJornada)));
        
                IF V_PartidoExiste = 0 THEN
                    
                    V_IdEquipo1 := EQUIPO1.ID;
                    V_IdEquipo2 := EQUIPO2.ID;
                    
                    INSERT INTO PARTIDOS (HORA, IDJORNADA) VALUES 
                    (V_HoraPartido, V_IdJornada);
                    
                    SELECT ID INTO V_IdPartido
                    FROM PARTIDOS 
                    WHERE ROWNUM = 1 
                    ORDER BY ID DESC;
                    
                    INSERT INTO PARTIDOEQUIPO1 (IDEQUIPO, IDPARTIDO)
                    VALUES (V_IdEquipo1, V_IdPartido);
                    
                    INSERT INTO PARTIDOEQUIPO2 (IDEQUIPO, IDPARTIDO)
                    VALUES (V_IdEquipo2, V_IdPartido);
                    
                    V_Emparejados := 0;
                    
                        IF V_Emparejados = 0 THEN
                        
                            V_IdJornada := V_IdJornada + 1;
                            V_Emparejados := 1;
                            
                        END IF;
                END IF;
                
            END IF;
            ELSE
            
            V_IdJornada := V_IdJornada + 1;
            
            END IF;
            
            END LOOP;
            
            
            
        END LOOP;
        
    END EmparejarLigaRegular;

--------------------------------------------------------------------------------
--****************************************************************************--
--------------------------------------------------------------------------------

    PROCEDURE ListaEmparejamientos
    (C_CURSOR OUT SYS_REFCURSOR)
    AS
    BEGIN
        OPEN C_CURSOR FOR
                SELECT P.ID, EL.NOMBRE AS LOCAL, EV.NOMBRE AS VISITANTE, P.ID, P.HORA
                FROM PARTIDOS P, PARTIDOEQUIPO1 PL, PARTIDOEQUIPO2 PV, EQUIPOS EL, EQUIPOS EV
                WHERE P.ID = PL.IDPARTIDO AND P.ID = PV.IDPARTIDO
                AND PL.IDEQUIPO = EL.ID AND PV.IDEQUIPO = EV.ID
                AND P.ID IN (SELECT ID FROM JORNADAS WHERE IDSPLIT = (SELECT max(ID) from SPLIT))
                GROUP BY P.ID, EL.NOMBRE, EV.NOMBRE, P.IDJORNADA, P.HORA;
    END ListaEmparejamientos;

--------------------------------------------------------------------------------
--****************************************************************************--
--------------------------------------------------------------------------------

    PROCEDURE EmparejarPlayOff
    AS
    
    BEGIN
    
        NULL;
    
    END EmparejarPlayOff;

--------------------------------------------------------------------------------
--****************************************************************************--
--------------------------------------------------------------------------------

END DatosCalendario;