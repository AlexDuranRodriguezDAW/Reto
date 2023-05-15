
SET SERVEROUTPUT ON;

--------------------------------------------------------------------------------

/* PROCEDIEMIENTO ANONNIMO -> EmparejarLigaRegular */

-- Creamos un Split
INSERT INTO SPLIT (TIPO, FECHAINICIO)
VALUES ('abierto', SYSDATE);


-- Emparejamos los equipos.
BEGIN

DATOSCALENDARIO.EMPAREJARLIGAREGULAR();

END;

/* PROCEDIEMIENTO ANONNIMO -> ListaEmparejamientos */

-- Sacamos la informacion de los partidos creados.
DECLARE
  c_cursor      SYS_REFCURSOR;
  V_IdPartido   PARTIDOS.ID%TYPE;
  V_Equipo1     EQUIPOS.ID%TYPE;
  V_Equipo2     EQUIPOS.ID%TYPE;
  V_IdJornada   PARTIDOS.IDJORNADA%TYPE;
  
BEGIN
  DATOSCALENDARIO.lISTAEMPAREJAMIENTOS(c_cursor);
  
  LOOP
    FETCH c_cursor INTO V_IdJornada, V_IdPartido, V_Equipo1, V_Equipo2;
    EXIT WHEN c_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE( 'Jornada: '|| V_IdJornada ||', Partido: ' 
    || V_IdPartido || ', Equipo 1: ' || V_Equipo1 || ', Equipo 2: ' 
    || V_Equipo2 || '. ');
  END LOOP;
  
  CLOSE c_cursor;
END;


