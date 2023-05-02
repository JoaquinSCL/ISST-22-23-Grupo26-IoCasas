package es.upm.dit.isst.iocasas.iocasasregistror.controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


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

import es.upm.dit.isst.iocasas.iocasasregistror.model.Reserva;


@Controller

public class reservaController {

        public final String RESERVAGUARDAR_STRING= "http://localhost:8083/newreservas/";
        public final String RESERVACONTROLAR_STRING= "http://localhost:8083/reserva/";
        public final String LISTARESERVASPROP_STRING= "http://localhost:8083/reservasprop/";
        public static final String VISTA_LISTA = "lista";
        public static final String VISTA_FORMULARIO = "formulario";
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
                List<Reserva> lista = new ArrayList<Reserva>();
                if(principal == null || principal.getName().equals("")){
                        model.addAttribute("reservas", lista);
                        return VISTA_LISTA;
                }
                else{
                lista = Arrays.asList(restTemplate.getForEntity(LISTARESERVASPROP_STRING + principal.getName(), Reserva[].class).getBody());
                        model.addAttribute("reservas", lista);
                         //vista que devuelve la informacion
                }
                return VISTA_LISTA;
        }


         @GetMapping("/crear")
        public String crear(Map<String, Object> model) {
                Reserva reserva = new Reserva();
                model.put("reserva", reserva);
                model.put("accion", "guardar");
                return VISTA_FORMULARIO;
        } 

        @PostMapping("/guardar")
        public String guardar(@Validated Reserva reserva, BindingResult result) {
                if (result.hasErrors()) {
                        return VISTA_FORMULARIO;
                }
                try { restTemplate.postForObject(RESERVAGUARDAR_STRING, reserva, Reserva.class);
                } catch(Exception e) {}
                return "redirect:" + VISTA_LISTA;
        }

         @GetMapping("/editar/{id}")
        public String editar(@PathVariable(value = "id") String id,
                   Map<String, Object> model, Principal principal) {
/*                 if (principal == null || ! principal.getName().equals(id))
                        return "redirect:/" + VISTA_LISTA; */
                Reserva reserva = null;   
                try { Reserva = restTemplate.getForObject(RESERVACONTROLAR_STRING + id, Reserva.class);
                } catch (HttpClientErrorException.NotFound ex) {}
                model.put("reserva", reserva);
                model.put("accion", "../actualizar");
                return reserva != null ? VISTA_FORMULARIO : "redirect:/" + VISTA_LISTA;
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

        @GetMapping("/eliminar/{id}")
        public String eliminar(@PathVariable(value = "id") String id) {
                restTemplate.delete(RESERVACONTROLAR_STRING+ id);
                return "redirect:/" + VISTA_LISTA;
        }
    }