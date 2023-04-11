package es.upm.dit.isst.iocasasapi.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.iocasasapi.model.Reserva;

public interface reservaRepository extends CrudRepository<Reserva, String> {

    List<Reserva> findByemailInquilino(String emailInquilino);
    List<Reserva> findByIdPuerta(Long idPuerta);
}