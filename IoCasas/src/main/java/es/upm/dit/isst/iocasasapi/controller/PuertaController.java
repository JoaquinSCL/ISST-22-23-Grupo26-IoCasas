package es.upm.dit.isst.iocasasapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.iocasasapi.model.Puerta;
import es.upm.dit.isst.iocasasapi.model.Reserva;
import es.upm.dit.isst.iocasasapi.repository.puertaRepository;
import es.upm.dit.isst.iocasasapi.repository.reservaRepository;


@RestController
public class PuertaController {
    @Autowired
    private puertaRepository puertaRepository;

}
