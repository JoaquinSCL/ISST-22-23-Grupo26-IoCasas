package es.upm.dit.isst.iocasasapi.controller;

import es.upm.dit.isst.iocasasapi.repository.reservaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import es.upm.dit.isst.iocasasapi.model.*;
public class ReservaController {
    private reservaRepository reservaRepository;

@GetMapping("/{idReserva}/acceso")
public Long getAccescodeLong(@PathVariable Long idReserva, @RequestParam Long idInquilino) {
    Optional<Reserva> reserva = reservaRepository.findById(idReserva);

    if (!reserva.isPresent()) {
        throw new RuntimeException("Reserva no encontrada");
    }

    // Verificar que el usuario tiene acceso a esta reserva
    if (!reserva.get().getIdInquilino().equals(idInquilino)) {
        throw new RuntimeException("El usuario no tiene acceso a esta reserva");
    }

    Date fechaActual = new Date();

    if (fechaActual.before(reserva.get().getEntrada()) || fechaActual.after(reserva.get().getSalida())) {
        throw new RuntimeException("La reserva no está activa en este momento");
    }

    return reserva.get().getKey();
}

@GetMapping("/{idInquilino}")
public List<Reserva> getReservasPorUsuario(@PathVariable Long idInquilino) {
    List<Reserva> reservas = reservaRepository.findByIdInquilino(idInquilino);

    if (reservas.isEmpty()) {
        throw new RuntimeException("El usuario no tiene reservas");
    }

    return reservas;
}

}
