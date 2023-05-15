
-- PAQUETE REFERENTE AL CALENDARIO (HEADER) --

CREATE OR REPLACE PACKAGE DatosCalendario IS

    PROCEDURE EmparejarLigaRegular;
    
    PROCEDURE ListaEmparejamientos(C_CURSOR OUT sys_refcursor);
    
    PROCEDURE EmparejarPLayOff;
    

END DatosCalendario;