package es.upm.dit.isst.iocasasapi.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.upm.dit.isst.iocasasapi.model.Puerta;
@Repository
public interface puertaRepository extends CrudRepository<Puerta, Long> {
    Puerta findByIdPuerta(Long idPuerta);
    List<Puerta> findByEmailPropietario(String emailPropietario);
}

