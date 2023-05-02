package es.upm.dit.isst.iocasasapi.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.upm.dit.isst.iocasasapi.model.Reserva;
@Repository
public interface reservaRepository extends CrudRepository<Reserva, Long> {
    Optional<Reserva> findById(Long idReserva);
    List<Reserva> findByemailInquilino(String emailInquilino);
    List<Reserva> findByemailPropietario(String emailPropietario);
    List<Reserva> findByemailAdministrador(String emailAdministrador);
    List<Reserva> findByIdPuerta(Long idPuerta);
}
