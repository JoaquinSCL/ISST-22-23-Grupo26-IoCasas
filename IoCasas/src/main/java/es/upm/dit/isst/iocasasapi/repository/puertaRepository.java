package es.upm.dit.isst.iocasasapi.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.iocasasapi.model.Puerta;

public interface puertaRepository extends CrudRepository<Puerta, Long> {

    List<Puerta> findByIdPropietario(Long idPropietario);
    List<Puerta> findByIdAdministrador(Long idAdministrador);
    List<Puerta> findByIdServicios(Long idServicios);
}