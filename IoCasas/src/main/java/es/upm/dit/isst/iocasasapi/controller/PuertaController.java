package es.upm.dit.isst.iocasasapi.controller;
import es.upm.dit.isst.iocasasapi.repository.puertaRepository;
import es.upm.dit.isst.iocasasapi.repository.reservaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.iocasasapi.model.Puerta;
import es.upm.dit.isst.iocasasapi.model.Reserva;
@RestController
public class PuertaController {
    @Autowired
    private puertaRepository puertaRepository;

    @PostMapping("/newpuerta")
    public ResponseEntity<String> crearPuerta(@RequestBody Puerta puerta) {
        puertaRepository.save(puerta);
        return ResponseEntity.ok("Reserva creada exitosamente");
    }

    @GetMapping("/puertas/{emailPrpietario}")
    public List<Puerta> getReservasPorUsuario(@PathVariable String emailPropietario) {
        List<Puerta> puertas = puertaRepository.findByEmailPropietario(emailPropietario);
        if (puertas.isEmpty()) {
            throw new RuntimeException("El usuario no tiene reservas");
        }
        return puertas;
    }

    @GetMapping("/puerta/{idPuerta}")
    public Puerta getReservasPorUsuario(@PathVariable Long idPuerta) {
        Puerta puerta = puertaRepository.findByIdPuerta(idPuerta);
        if (puerta == null) {
            throw new RuntimeException("El usuario no tiene reservas");
        }
        return puerta;
    }


    @DeleteMapping("puerta/{id}")
    ResponseEntity<Puerta> delete(@PathVariable Long id) {
      puertaRepository.deleteById(id);
      return ResponseEntity.ok().body(null);
    }

    @PutMapping("/puerta/{id}")
    public ResponseEntity<Puerta> updatePuerta(@RequestBody Puerta newPuerta, @PathVariable Long id) {

    return puertaRepository.findById(id).map(puerta -> {
        puerta.setEmailPropietario(newPuerta.getEmailPropietario());
        puerta.setEmailAdministrador(newPuerta.getEmailAdministrador());
        puerta.setKey(newPuerta.getKey());
        puerta.setUbicacion(newPuerta.getUbicacion());
        puertaRepository.save(puerta);
        return ResponseEntity.ok().body(puerta);
    }).orElse(new ResponseEntity<Puerta>(HttpStatus.NOT_FOUND));
    }

}
