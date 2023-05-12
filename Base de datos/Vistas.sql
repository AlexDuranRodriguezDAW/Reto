
--Vista para sacar todos los jugadores de draft
CREATE OR REPLACE VIEW JUGADORES_DRAFT AS
(

	SELECT j.*, p.*
	FROM JUGADORES j , Personas p
	WHERE j.id = p.id 
    and UPPER(TIPO) = 'DRAFT'
    
);


--Vista para sacar todos los WildCard

CREATE OR REPLACE VIEW JUGADORES_WILDCARD AS
(
    SELECT j.*, p.*
	FROM JUGADORES j , Personas p
	WHERE j.id = p.id 
    and UPPER(TIPO) = 'WILDCARD'
	
);



-- Vista para ver la clasificacion 
Create or replace view clasificacion
as(
SELECT count(p.idEquipo) as partidosGanados,sum(p1.golesEquipo1+p2.golesEquipo2)
golesTotales,e.nombre nombre
from partidos p,partidoEquipo1 p1,partidoEquipo2 p2,equipos e
where p.id = p1.idPartido and p2.idPartido = p1.idPartido and
p1.idPartido = e.id
and p1.idEquipo = (Select id
                    from equipos)
and p2.idEquipo = (Select id
                    from equipos)
group by e.nombre
);



-- Vista para ver los resultados de cada partido

Create or replace view resultadoPartido
as(

    Select e.nombre as nombreLocal,a.nombre  as nombreVisitante,p1.golesEquipo1 
    golesLocal,p2.golesEquipo2 golesVisitante
    from equipos e, equipos a, partidoEquipo1 p1 ,partidoEquipo2 p2
    where e.id = a.id and e.id = p1.idEquipo and p1.idPartido = p2.idPartido



)