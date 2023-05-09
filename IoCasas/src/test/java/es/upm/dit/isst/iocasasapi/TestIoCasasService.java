package es.upm.dit.isst.iocasasapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.upm.dit.isst.iocasasapi.model.Puerta;
import es.upm.dit.isst.iocasasapi.model.Reserva;
import es.upm.dit.isst.iocasasapi.repository.puertaRepository;
import es.upm.dit.isst.iocasasapi.repository.reservaRepository;

@SpringBootTest
public class TestIoCasasService {

    @Autowired
    private puertaRepository repoPuer;

    @Autowired
    private reservaRepository repoRes;

    @Test

    final void testPuerta() {

        Puerta puerta = new Puerta();
        puerta.setIdPuerta(33L);
        puerta.setEmailPropietario("alex@upm.es");
        puerta.setEmailAdministrador("joaquin@upm.es");
        puerta.setKey(678L);
        puerta.setUbicacion("Madrid");

        repoPuer.save(puerta);

        Puerta puerta2 = repoPuer.findByIdPuerta(33L);
        List<Puerta> puertas3 = repoPuer.findByEmailPropietario("alex@upm.es");
        assertTrue(puertas3.contains(puerta));

        assertEquals(puerta2.getEmailPropietario(), puerta.getEmailPropietario());
        assertEquals(puerta2.getKey(), 678);

        assertEquals(puertas3.get(0).getEmailAdministrador(), puerta.getEmailAdministrador());
        assertEquals(puertas3.get(0).getIdPuerta(), 33);

        puerta.setUbicacion("Hortaleza");
        repoPuer.save(puerta);

        puerta2 = repoPuer.findByIdPuerta(33L);
        assertNotEquals(puerta2.getUbicacion(), "Madrid");

        repoPuer.delete(puerta);
        puerta2 = repoPuer.findByIdPuerta(33L);
        assertNull(puerta2);
    }

    /**
     * @throws ParseException
     */
    @Test
    
    final void testReserva() throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String fechaString1 = "2023-05-17T00:00:00";
        String fechaString2 = "2023-05-18T00:00:00";
        String fechaString3 = "2023-05-19T00:00:00";
        Date fecha1 = formato.parse(fechaString1);
        Date fecha2 = formato.parse(fechaString2);
        Date fecha3 = formato.parse(fechaString3);

        // 17 de mayo de 2023 a las 00:00:00
        GregorianCalendar cdate1 = new GregorianCalendar(2023, Calendar.MAY, 17, 0, 0, 0);
        Timestamp timestamp1 = new Timestamp(cdate1.getTimeInMillis());

        // 18 de mayo de 2023 a las 00:00:00
        GregorianCalendar cdate2 = new GregorianCalendar(2023, Calendar.MAY, 18, 0, 0, 0);
        Timestamp timestamp2 = new Timestamp(cdate2.getTimeInMillis());

        // 19 de mayo de 2023 a las 00:00:00
        GregorianCalendar cdate3 = new GregorianCalendar(2023, Calendar.MAY, 19, 0, 0, 0);
        Timestamp timestamp3 = new Timestamp(cdate3.getTimeInMillis());


        Reserva reserva = new Reserva();
        reserva.setIdReserva(712L);
        reserva.setIdPuerta(33L);
        reserva.setEmailInquilino("marioivan@upm.es");
        reserva.setEmailPropietario("alex@upm.es");
        reserva.setEmailAdministrador("joaquin@upm.es");
        reserva.setEntrada(fecha1); // 17 de mayo de 2023 00:00:00
        reserva.setSalida(fecha3); // 19 de mayo de 2023 00:00:00

        repoRes.save(reserva);

        Optional<Reserva> reserva2 = repoRes.findById(712L);
        assertEquals(reserva2.get().getIdPuerta(), 33);
        assertEquals(reserva2.get().getEmailInquilino(), reserva.getEmailInquilino());
        assertEquals(reserva2.get().getEmailPropietario(), reserva.getEmailPropietario());
        assertEquals(reserva2.get().getEmailAdministrador(), reserva.getEmailAdministrador());
        assertEquals(reserva2.get().getEntrada(), timestamp1);
        assertEquals(reserva2.get().getSalida(), timestamp3); // 19 de mayo de 2023 00:00:00

        List<Reserva> reservas3 = repoRes.findByemailInquilino("marioivan@upm.es");
        assertTrue(reservas3.contains(reserva));
        List<Reserva> reservas4 = repoRes.findByemailPropietario("alex@upm.es");
        assertTrue(reservas4.contains(reserva));
        List<Reserva> reservas5 = repoRes.findByemailAdministrador("joaquin@upm.es");
        assertTrue(reservas5.contains(reserva));
        List<Reserva> reservas6 = repoRes.findByIdPuerta(33L);
        assertTrue(reservas6.contains(reserva));

        reserva.setEntrada(fecha2);// 18 de mayo de 2023 00:00:00
        repoRes.save(reserva);
        reserva2 = repoRes.findById(712L);
        assertNotEquals(reserva2.get().getEntrada(), timestamp1); // con 17 de mayo de 2023 00:00:00

        
        repoRes.delete(reserva);
        reserva2 = repoRes.findById(712L);
        assertFalse(reserva2.isPresent());
    }
}