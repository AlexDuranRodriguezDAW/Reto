
SET SERVEROUTPUT ON;

--------------------------------------------------------------------------------

/* PROCEDIEMIENTO ANONNIMO -> INFO_JUGADORES_DRAFT */

DECLARE

    V_Cursor_Draft      SYS_REFCURSOR;
    
    V_IdJugador         JUGADORES.ID%TYPE;
    V_DniJugador        PERSONAS.DNI%TYPE;
    V_NombreJugador     PERSONAS.NOMBRE%TYPE;
    V_ApellidoJugador   PERSONAS.APELLIDO%TYPE;
    V_PosicionJugador   JUGADORES.POSICION%TYPE;
    V_NumdraftJugador   JUGADORES.NUMDRAFT%TYPE;
    V_SueldoJugador     JUGADORESEQUIPOS.SUELDO%TYPE;
    V_ClausulaJugador   JUGADORESEQUIPOS.CLAUSULA%TYPE;
    V_IdEquipo          EQUIPOS.ID%TYPE;
    V_NombreEquipo      EQUIPOS.NOMBRE%TYPE;

BEGIN

    INFO_JUGADORES_DRAFT(V_Cursor_draft);
    
    LOOP
    
    FETCH V_Cursor_Draft INTO V_IdJugador, V_DniJugador, V_NombreJugador,
    V_ApellidoJugador, V_PosicionJugador, V_NumdraftJugador, V_IdEquipo, 
    V_NombreEquipo, V_SueldoJugador, V_ClausulaJugador ;
    
    EXIT WHEN V_Cursor_draft%NOTFOUND;
    
    dbms_output.put_line
    ('ID del jugador: ' || V_IdJugador || CHR(13) ||
     'Dni del jugador: ' || V_DniJugador || CHR(13) || 
     'Nombre del jugador: ' || V_NombreJugador || CHR(13) ||
     'Apellido del jugador: ' || V_ApellidoJugador || CHR(13) ||
     'Posición del jugador: ' || V_PosicionJugador || CHR(13) ||
     'Número de draft del jugador: ' || V_NumdraftJugador || CHR(13) ||
     'Sueldo del jugador: ' || V_SueldoJugador || CHR(13) ||
     'Clausula del jugador: ' || V_ClausulaJugador || CHR(13) ||
     'ID del equipo al que pertenece: ' || V_IdEquipo || CHR(13) ||
     'Nombre del equipo al que pertenece: ' || V_NombreJugador || CHR(13)||CHR(13));  
    
    END LOOP;

END;

--------------------------------------------------------------------------------

--------------------------------------------------------------------------------

/* PROCEDIEMIENTO ANONNIMO -> INFO_JUGADORES_DRAFT */


DECLARE

    V_Cursor_Wildcard   SYS_REFCURSOR;
    
    V_IdJugador         JUGADORES.ID%TYPE;
    V_DniJugador        PERSONAS.DNI%TYPE;
    V_NombreJugador     PERSONAS.NOMBRE%TYPE;
    V_ApellidoJugador   PERSONAS.APELLIDO%TYPE;
    V_PosicionJugador   JUGADORES.POSICION%TYPE;
    V_SueldoJugador     JUGADORESEQUIPOS.SUELDO%TYPE;
    V_IdEquipo          EQUIPOS.ID%TYPE;
    V_NombreEquipo      EQUIPOS.NOMBRE%TYPE;

BEGIN

        INFO_JUGADORES_WILDCARD(V_Cursor_Wildcard);
    
    LOOP
    
    FETCH V_Cursor_Wildcard INTO V_IdJugador, V_DniJugador, V_NombreJugador,
    V_ApellidoJugador, V_PosicionJugador, V_IdEquipo, 
    V_NombreEquipo, V_SueldoJugador;
    
    EXIT WHEN V_Cursor_Wildcard%NOTFOUND;
    
    dbms_output.put_line
    ('ID del jugador: ' || V_IdJugador || CHR(13) ||
     'Dni del jugador: ' || V_DniJugador || CHR(13) || 
     'Nombre del jugador: ' || V_NombreJugador || CHR(13) ||
     'Apellido del jugador: ' || V_ApellidoJugador || CHR(13) ||
     'Posición del jugador: ' || V_PosicionJugador || CHR(13) ||
     'Sueldo del jugador: ' || V_SueldoJugador || CHR(13) ||
     'ID del equipo al que pertenece: ' || V_IdEquipo || CHR(13) ||
     'Nombre del equipo al que pertenece: ' || V_NombreJugador || CHR(13)||CHR(13));  
    
    END LOOP;

END;

--------------------------------------------------------------------------------