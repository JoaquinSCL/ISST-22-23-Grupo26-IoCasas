package es.upm.dit.isst.iocasasapi.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.upm.dit.isst.iocasasapi.model.Reserva;
@Repository
public interface reservaRepository extends CrudRepository<Reserva, Long> {

    List<Reserva> findByemailInquilino(String emailInquilino);
    List<Reserva> findByIdPuerta(Long idPuerta);
}
