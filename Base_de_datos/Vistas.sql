--Vista para sacar todos los jugadores de draft
CREATE OR REPLACE VIEW JUGADORES_DRAFT AS
(

	SELECT J.POSICION, J.NUMDRAFT, J.TIPO , P.*
	FROM JUGADORES J , PERSONAS P
	WHERE J.ID = P.ID 
    and UPPER(TIPO) = 'DRAFT'
    
);


--Vista para sacar todos los WildCard

CREATE OR REPLACE VIEW JUGADORES_WILDCARD AS
(
    SELECT J.POSICION, J.TIPO , P.*
	FROM JUGADORES J , PERSONAS P
	WHERE J.ID = P.ID 
    and UPPER(TIPO) = 'WILDCARD'
	
);



-- Vista para ver la clasificacion

CREATE OR REPLACE VIEW CLASIFICACION
AS(
SELECT COUNT(P.IDEQUIPO) AS PARTIDOSGANADOS, SUM(P1.GOLESEQUIPO1 + P2.GOLESEQUIPO2)
GOLESTOTALES,E.NOMBRE NOMBRE
FROM PARTIDOS P, PARTIDOEQUIPO1 P1, PARTIDOEQUIPO2 P2, EQUIPOS E
WHERE P.ID = P1.IDPARTIDO AND P2.IDPARTIDO = P1.IDPARTIDO AND
P1.IDPARTIDO = E.ID
AND p1.idEquipo = (SELECT ID FROM EQUIPOS)
AND p2.idEquipo = (SELECT ID FROM EQUIPOS)
GROUP BY E.NOMBRE
);



-- Vista para ver los resultados de cada partido

Create or replace view resultadoPartido
as(

    Select e.nombre as nombreLocal,a.nombre  as nombreVisitante,p1.golesEquipo1 
    golesLocal,p2.golesEquipo2 golesVisitante
    from equipos e, equipos a, partidoEquipo1 p1 ,partidoEquipo2 p2
    where e.id = a.id and e.id = p1.idEquipo and p1.idPartido = p2.idPartido

);

--Vista para ver los emparejamientos de los equipos

CREATE OR REPLACE VIEW EMPAREJAMIENTOS AS
(

    SELECT J.ID AS "JORNADA",P1.IDPARTIDO AS "PARTIDO", P1.IDEQUIPO AS "EQUIPO1"
    , P2.IDEQUIPO AS "EQUIPO2"
    FROM JORNADAS J, PARTIDOEQUIPO1 P1, PARTIDOEQUIPO2 P2, PARTIDOS P
    WHERE J.ID = P.IDJORNADA AND P.ID = P1.IDPARTIDO AND P.ID = P2.IDPARTIDO

);


