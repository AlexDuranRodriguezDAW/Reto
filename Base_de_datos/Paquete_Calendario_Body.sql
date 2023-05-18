
-- PAQUETE REFERENTE AL CALENDARIO (BODY) --

CREATE OR REPLACE PACKAGE BODY DatosCalendario AS

--------------------------------------------------------------------------------
--****************************************************************************--
--------------------------------------------------------------------------------

    PROCEDURE EmparejarLigaRegular
    AS
    
    V_FechaJornada      DATE := SYSDATE;
    V_HoraPartido       VARCHAR(5) := '16:00';
    V_IdSplit           SPLIT.ID%TYPE;
    V_IdJornada         JORNADAS.ID%TYPE;
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
            WHERE IDEQUIPO1 = EQUIPO1.ID AND IDJORNADA = V_IdJornada
            OR IDEQUIPO2 = EQUIPO1.ID AND IDJORNADA = V_IdJornada;
            
            IF V_PartidoExiste = 0 THEN
            
            IF EQUIPO1.ID <> EQUIPO2.ID THEN
                
                SELECT COUNT(P.ID) INTO V_PartidoExiste
                FROM PARTIDOS P
                WHERE   IDEQUIPO1 = EQUIPO1.ID AND IDEQUIPO2 = EQUIPO2
                OR IDEQUIPO1 = EQUIPO2.ID AND IDEQUIPO2 = EQUIPO1
                OR IDEQUIPO1 = EQUIPO2.ID AND IDJORNADA = V_IdJornada
                OR IDEQUIPO1 = EQUIPO2.ID AND IDJORNADA = V_IdJornada;
        
                IF V_PartidoExiste = 0 THEN
                    
                    V_IdEquipo1 := EQUIPO1.ID;
                    V_IdEquipo2 := EQUIPO2.ID;
                    
                    INSERT INTO PARTIDOS (HORA, IDEQUIPO1, IDEQUIPO2, IDJORNADA)
                    VALUES (V_HoraPartido, V_IdEquipo1, V_IdEquipo2, V_IdJornada);
                    
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
                SELECT * FROM EMPAREJAMIENTOS
                ORDER BY JORNADA, EQUIPO1;
    END ListaEmparejamientos;

--------------------------------------------------------------------------------
--****************************************************************************--
--------------------------------------------------------------------------------

    PROCEDURE EmparejarPlayOff
    AS
    
    C_CursorEquipos SYS_REFCURSOR;
    V_Equipo        EQUIPOS.ID%TYPE;
    V_Equipo1       EQUIPOS.ID%TYPE;
    V_Equipo2       EQUIPOS.ID%TYPE;
    V_Equipo3       EQUIPOS.ID%TYPE;
    V_Equipo4       EQUIPOS.ID%TYPE;
    V_Equipo5       EQUIPOS.ID%TYPE;
    V_Equipo6       EQUIPOS.ID%TYPE;
    V_Equipo7       EQUIPOS.ID%TYPE;
    V_Equipo8       EQUIPOS.ID%TYPE;
    V_IdSplit       SPLIT.ID%TYPE;
    V_IdJornada     JORNADAS.ID%TYPE;
    V_Contador      NUMBER := 1;
    
    BEGIN
    
        OPEN C_CursorEquipos FOR
        SELECT E.ID
        FROM PARTIDOS P, EQUIPOS E
        WHERE E.ID = P.IDEQUIPOGANA
        GROUP BY E.ID
        ORDER BY COUNT(P.IDEQUIPOGANA);
        
    LOOP
    
    FETCH C_CursorEquipos INTO V_Equipo;
    
    CASE
    WHEN V_Contador = 1 THEN V_Equipo1 := V_Equipo;
    WHEN V_Contador = 2 THEN V_Equipo2 := V_Equipo;
    WHEN V_Contador = 3 THEN V_Equipo3 := V_Equipo;
    WHEN V_Contador = 4 THEN V_Equipo4 := V_Equipo;
    WHEN V_Contador = 5 THEN V_Equipo5 := V_Equipo;
    WHEN V_Contador = 6 THEN V_Equipo6 := V_Equipo;
    WHEN V_Contador = 7 THEN V_Equipo7 := V_Equipo;
    WHEN V_Contador = 8 THEN V_Equipo8 := V_Equipo;
    
    END CASE;
    
    V_Contador := V_Contador +1;
    
    EXIT WHEN V_Contador = 8;

    END LOOP;
    
    SELECT MAX(ID) INTO V_Split
    FROM SPLIT;
    
    -- Jornada PlayOff 1 --
    INSERT INTO IDJORNADA (FECHA, TIPO, IDSPLIT)
    VALUES (SYSDATE, 'playoff', V_Split);
    
    SELECT ID INTO V_IdJornada
    FROM JORNADAS 
    WHERE ROWNUM = 1 
    ORDER BY ID DESC;
    
    -- Partido PlayOff 1 --
    INSERT INTO PARTIDOS (HORA, IDEQUIPO1, IDEQUIPO2, IDJORNADA)
    VALUES ('16:00', V_Equipo1, V_Equipo8, V_IdJornada);
    
    -- Partido PlayOff 2 --
    INSERT INTO PARTIDOS (HORA, IDEQUIPO1, IDEQUIPO2, IDJORNADA)
    VALUES ('18:00', V_Equipo2, V_Equipo7, V_IdJornada);
    
    -- Partido PlayOff 3 --
    INSERT INTO PARTIDOS (HORA, IDEQUIPO1, IDEQUIPO2, IDJORNADA)
    VALUES ('18:00', V_Equipo3, V_Equipo6, V_IdJornada);
    
    -- Partido PlayOff 4 --
    INSERT INTO PARTIDOS (HORA, IDEQUIPO1, IDEQUIPO2, IDJORNADA)
    VALUES ('18:00', V_Equipo4, V_Equipo5, V_IdJornada);
    
    END EmparejarPlayOff;

--------------------------------------------------------------------------------
--****************************************************************************--
--------------------------------------------------------------------------------

END DatosCalendario;