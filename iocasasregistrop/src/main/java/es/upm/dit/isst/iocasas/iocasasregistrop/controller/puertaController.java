package es.upm.dit.isst.iocasas.iocasasregistrop.controller;


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
import es.upm.dit.isst.iocasas.iocasasregistrop.model.Puerta;


@Controller

public class puertaController {

        public final String PUERTAGUARDAR_STRING= "http://localhost:8083/newpuerta/";
        public final String PUERTACONTROLAR_STRING= "http://localhost:8083/puerta/";
        public final String LISTAPUERTAS_STRING= "http://localhost:8083/puertas/";
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

        @GetMapping("/lista/")
        public String lista(Model model, Principal principal) {
                List<Puerta> lista = new ArrayList<Puerta>();
                lista = Arrays.asList(restTemplate.getForEntity(LISTAPUERTAS_STRING+ principal.getName(),Puerta[].class).getBody());
                model.addAttribute("Puertas", lista);
                return VISTA_LISTA; //vista que devuelve la informacion
        }

         @GetMapping("/crear")
        public String crear(Map<String, Object> model) {
                Puerta Puerta = new Puerta();
                model.put("Puerta", Puerta);
                model.put("accion", "guardar");
                return VISTA_FORMULARIO;
        } 

        @PostMapping("/guardar")
        public String guardar(@Validated Puerta Puerta, BindingResult result) {
                if (result.hasErrors()) {
                        return VISTA_FORMULARIO;
                }
                try { restTemplate.postForObject(PUERTAGUARDAR_STRING, Puerta, Puerta.class);
                } catch(Exception e) {}
                return "redirect:" + VISTA_LISTA;
        }

         @GetMapping("/editar/{id}")
        public String editar(@PathVariable(value = "id") String id,
                   Map<String, Object> model, Principal principal) {
                if (principal == null || ! principal.getName().equals(id))
                        return "redirect:/" + VISTA_LISTA;
                Puerta Puerta = null;
                try { Puerta = restTemplate.getForObject(PUERTACONTROLAR_STRING + id, Puerta.class);
                } catch (HttpClientErrorException.NotFound ex) {}
                model.put("Puerta", Puerta);
                model.put("accion", "../actualizar");
                return Puerta != null ? VISTA_FORMULARIO : "redirect:/" + VISTA_LISTA;
        }

        @PostMapping("/actualizar")
        public String actualizar(@Validated Puerta Puerta, BindingResult result) {
                if (result.hasErrors()) {
                        return VISTA_FORMULARIO;
                }
                try { restTemplate.put(PUERTACONTROLAR_STRING + Puerta.getIdPuerta(),
                           Puerta, Puerta.class);
                } catch(Exception e) {}
                return "redirect:" + VISTA_LISTA;
        }

        @GetMapping("/eliminar/{id}")
        public String eliminar(@PathVariable(value = "id") String id) {
                restTemplate.delete(PUERTACONTROLAR_STRING+ id);
                return "redirect:/" + VISTA_LISTA;
        }
    }