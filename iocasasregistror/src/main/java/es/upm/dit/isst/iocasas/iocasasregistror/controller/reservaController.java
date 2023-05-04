package es.upm.dit.isst.iocasas.iocasasregistror.controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import es.upm.dit.isst.iocasas.iocasasregistror.model.reserva;
import es.upm.dit.isst.iocasas.iocasasregistror.model.reservaWeb;


@Controller

public class reservaController {

        public final String RESERVAGUARDAR_STRING= "http://localhost:8083/newreservas/";
        public final String RESERVACONTROLAR_STRING= "http://localhost:8083/reserva/";
        public final String LISTARESERVASPROP_STRING= "http://localhost:8083/reservasprop/";
        public static final String VISTA_LISTA = "lista";
        public static final String VISTA_FORMULARIO = "formulario";
        private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm"; // formato de fecha en HTML

        private RestTemplate restTemplate = new RestTemplate();
         @GetMapping("/")
        public String inicio() {
                return "redirect:/" + VISTA_LISTA;
        }
        
        @GetMapping("/login")
        public String login() {
                return "redirect:/" + VISTA_LISTA;
        } 

        @GetMapping("/lista")
        public String lista(Model model, Principal principal) {
                List<reserva> lista = new ArrayList<reserva>();
                if(principal == null || principal.getName().equals("")){
                        model.addAttribute("reservas", lista);
                        return VISTA_LISTA;
                }
                else{
                lista = Arrays.asList(restTemplate.getForEntity(LISTARESERVASPROP_STRING + principal.getName(), reserva[].class).getBody());
                        model.addAttribute("reservas", lista);
                         //vista que devuelve la informacion
                }
                return VISTA_LISTA;
        }


         @GetMapping("/crear")
        public String crear(Map<String, Object> model) {
                reservaWeb reserva = new reservaWeb();
                model.put("reserva", reserva);
                model.put("accion", "guardar");
                return VISTA_FORMULARIO;
        }  



         @GetMapping("/editar/{id}")
        public String editar(@PathVariable(value = "id") String id, Map<String, Object> model, Principal principal) {
                reserva reserva = new reserva();
                reservaWeb reservafinal = new reservaWeb();  
                try { reserva = restTemplate.getForObject(RESERVACONTROLAR_STRING + id, reserva.class);
                        reservafinal = reserva.toReservaWeb();
                } catch (HttpClientErrorException.NotFound ex) {}
                
                model.put("reserva", reservafinal);
                model.put("accion", "../actualizar");
                return reservafinal != null ? VISTA_FORMULARIO : "redirect:/" + VISTA_LISTA;
        } 

        @PostMapping("/guardar")
        public String guardar( reservaWeb reserva, BindingResult result) {
                if (result.hasErrors()) {
                        return VISTA_FORMULARIO;
                }

        try {
                reserva reservafinal = new reserva();
                reservafinal = reserva.toReserva();  
                restTemplate.postForObject(RESERVAGUARDAR_STRING, reservafinal, reserva.class);
                } catch(Exception e) {
                // manejar la excepción apropiadamente
                }
                return "redirect:" + VISTA_LISTA;
        }

        @PostMapping("/actualizar")
        public String actualizar( reservaWeb reserva, BindingResult result) {
                if (result.hasErrors()) {
                        return VISTA_FORMULARIO;
                }
                try {
                        reserva reservafinal = new reserva();
                        reservafinal = reserva.toReserva();
                        restTemplate.put(RESERVACONTROLAR_STRING + reservafinal.getIdReserva(), reservafinal, reserva.class);
                } catch(Exception e) {}
                return "redirect:" + VISTA_LISTA;
        }

        /*  @PostMapping("/guardar")
        public String guardar(Reserva reserva, BindingResult result) {
                if (result.hasErrors()) {
                        return VISTA_FORMULARIO;
                }
                try { restTemplate.postForObject(RESERVAGUARDAR_STRING, reserva, Reserva.class);
                } catch(Exception e) {}
                return "redirect:" + VISTA_LISTA;
        }

        @PostMapping("/actualizar")
        public String actualizar(@Validated Reserva Reserva, BindingResult result) {
                if (result.hasErrors()) {
                        return VISTA_FORMULARIO;
                }
                try { restTemplate.put(RESERVACONTROLAR_STRING + Reserva.getIdReserva(),
                           Reserva, Reserva.class);
                } catch(Exception e) {}
                return "redirect:" + VISTA_LISTA;
        }  
        
         @GetMapping("/crear")
        public String crear(Map<String, Object> model) {
                Reserva reserva = new Reserva();
                model.put("reserva", reserva);
                model.put("accion", "guardar");
                return VISTA_FORMULARIO;
        }  



         @GetMapping("/editar/{id}")
        public String editar(@PathVariable(value = "id") String id,
                   Map<String, Object> model, Principal principal) {
                 if (principal == null || ! principal.getName().equals(id))
                        return "redirect:/" + VISTA_LISTA; 
                Reserva reserva = null;   
                try { reserva = restTemplate.getForObject(RESERVACONTROLAR_STRING + id, Reserva.class);
                } catch (HttpClientErrorException.NotFound ex) {}
                model.put("reserva", reserva);
                model.put("accion", "../actualizar");
                return reserva != null ? VISTA_FORMULARIO : "redirect:/" + VISTA_LISTA;
        }
        */      


        @GetMapping("/eliminar/{id}")
        public String eliminar(@PathVariable(value = "id") String id) {
                restTemplate.delete(RESERVACONTROLAR_STRING+ id);
                return "redirect:/" + VISTA_LISTA;
        }
    }