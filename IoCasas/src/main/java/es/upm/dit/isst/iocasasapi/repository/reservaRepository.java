package es.upm.dit.isst.iocasasapi.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.iocasasapi.model.Reserva;

public interface reservaRepository extends CrudRepository<Reserva, Long> {

    List<Reserva> findByIdInquilino(Long idInquilino);
    List<Reserva> findByIdPuerta(Long idPuerta);
}