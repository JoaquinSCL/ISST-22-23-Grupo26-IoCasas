package es.upm.dit.isst.iocasasapi.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import es.upm.dit.isst.iocasasapi.model.Puerta;
import es.upm.dit.isst.iocasasapi.model.Reserva;

@Repository
public interface puertaRepository extends CrudRepository<Puerta, Long> {

    List<Puerta> findByemailPropietario(String emailPropietario);
    List<Puerta> findByIdPuerta(Long idPuerta);
}