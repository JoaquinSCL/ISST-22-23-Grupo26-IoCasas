package es.upm.dit.isst.iocasasapi.controller;

import es.upm.dit.isst.iocasasapi.repository.puertaRepository;
import es.upm.dit.isst.iocasasapi.repository.reservaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.iocasasapi.model.Puerta;
import es.upm.dit.isst.iocasasapi.model.Reserva;

@RestController
public class ReservaController {
    @Autowired
    private reservaRepository reservaRepository;
    @Autowired
    private puertaRepository puertaRepository;

    @PostMapping("/newreservas")
    public ResponseEntity<String> crearReserva(@RequestBody Reserva reserva) {
        reservaRepository.save(reserva);
        return ResponseEntity.ok("Reserva creada exitosamente");
    }

    @GetMapping("/api/{idReserva}/acceso")
    public Long getAccescodeLong(@PathVariable Long idReserva) {
        Optional<Reserva> reserva = reservaRepository.findById(idReserva);

        if (!reserva.isPresent()) {
            throw new RuntimeException("Reserva no encontrada");
        }

        Date fechaActual = new Date();

        if (fechaActual.before(reserva.get().getEntrada()) || fechaActual.after(reserva.get().getSalida())) {
            throw new RuntimeException("La reserva no está activa en este momento");
        }
        Puerta puerta = puertaRepository.findByIdPuerta(reserva.get().getIdPuerta());

        return puerta.getKey();
    }

    @GetMapping("/reservas/{emailInquilino}")
    public List<Reserva> getReservasPorUsuario(@PathVariable String emailInquilino) {
        List<Reserva> reservas = reservaRepository.findByemailInquilino(emailInquilino);

        if (reservas.isEmpty()) {
            throw new RuntimeException("El usuario no tiene reservas");
        }

        return reservas;
    }
}
