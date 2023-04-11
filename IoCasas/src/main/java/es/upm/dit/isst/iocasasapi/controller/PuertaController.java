package es.upm.dit.isst.iocasasapi.controller;
import es.upm.dit.isst.iocasasapi.repository.*;

import java.util.List;  
import java.util.Date;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.iocasasapi.model.*;

public class PuertaController {

    private puertaRepository puertaRepository;
    private reservaRepository reservaRepository;

    @GetMapping("/propietario/{idPropietario}")
    public List<Puerta> getPuertasPorProietario(@PathVariable Long idPropietario) {
        List<Puerta> puertas = puertaRepository.findByIdPropietario(idPropietario);

        if (puertas.isEmpty()) {
            throw new RuntimeException("El usuario no tiene puertas");
        }
        return puertas;
    }
    @GetMapping("/administrador/{idAdministrador}")
    public List<Puerta> getPuertasPorAdministrador(@PathVariable Long idAdministrador) {
        List<Puerta> puertas = puertaRepository.findByIdAdministrador(idAdministrador);

        if (puertas.isEmpty()) {
            throw new RuntimeException("El Administrador no tiene puertas");
        }
        return puertas;
    }
    @GetMapping("/servicios/{idServicios}")
    public List<Puerta> getPuertasPorServicios(@PathVariable Long idServicios) {
        List<Puerta> puertas = puertaRepository.findByIdServicios(idServicios);

        if (puertas.isEmpty()) {
            throw new RuntimeException("El usuario no tiene puertas");
        }
        return puertas;
    }

/*     @GetMapping("/{idPuerta}/acceso")
    public Long getAccescodeLong(@PathVariable Long idPuerta) {
        List<Reserva> reservas = reservaRepository.findByIdPuerta(idPuerta);

        Date fechaActual = new Date();
        for (Reserva reserva : reservas){
            if (fechaActual.before(reserva.getEntrada()) || fechaActual.after(reserva.getSalida())) {
                throw new RuntimeException("Hay reser");
            }   
        }
        return puertaRepository.findById(idPuerta).getAccescode();
} */

}