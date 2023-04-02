package es.upm.dit.isst.iocasasapi.controller;
import es.upm.dit.isst.iocasasapi.repository.*;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.upm.dit.isst.iocasasapi.model.*;
public class ReservaController {
    
    @PostMapping("/")
public Reserva crearReserva(@RequestBody Reserva reserva) {
    return reservaRepository.save(reserva);
}

@PutMapping("/{id}")
public Reserva actualizarReserva(@PathVariable Long id, @RequestBody Reserva reservaActualizada) {
    Optional<Reserva> reservaExistente = reservaRepository.findById(id);

    if (!reservaExistente.isPresent()) {
        throw new RuntimeException("Reserva no encontrada");
    }

    reservaActualizada.setIdReserva(id);
    return reservaRepository.save(reservaActualizada);
}

@DeleteMapping("/{id}")
public void eliminarReserva(@PathVariable Long id) {
    reservaRepository.deleteById(id);
}

@GetMapping("/{id}")
public Reserva obtenerReservaPorId(@PathVariable Long id) {
    Optional<Reserva> reserva = reservaRepository.findById(id);

    if (!reserva.isPresent()) {
        throw new RuntimeException("Reserva no encontrada");
    }

    return reserva.get();
}

@GetMapping("/")
public Iterable<Reserva> obtenerTodasLasReservas() {
    return reservaRepository.findAll();
}

}
