package es.upm.dit.isst.iocasasapi.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import es.upm.dit.isst.iocasasapi.model.reserva;

public interface reservaRepository extends CrudRepository<Reserva, String> {

    List<Reserva> findByIdInquilino(int idInquilino);

}