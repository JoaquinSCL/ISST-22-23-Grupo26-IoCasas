package es.upm.dit.isst.iocasasapi.model;
import java.util.Date;

import javax.persistence.Id;

public class Reserva{

    @Id
    private Long IdReserva;
    private Long IdPuerta;
    private String emailInquilino;
    private Long IdPropietario;
    private Long IdAdministrador;
    private Date entrada;
    private Date salida;
    private Long key;

    public Reserva() {
    }

    

    public Reserva(Long idReserva, Long idPuerta, String emailInquilino, Long idPropietario, Long idAdministrador,
            Date entrada, Date salida, Long key) {
        IdReserva = idReserva;
        IdPuerta = idPuerta;
        this.emailInquilino = emailInquilino;
        IdPropietario = idPropietario;
        IdAdministrador = idAdministrador;
        this.entrada = entrada;
        this.salida = salida;
        this.key = key;
    }



    public Long getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(Long idReserva) {
        IdReserva = idReserva;
    }

    public Long getIdPuerta() {
        return IdPuerta;
    }

    public void setIdPuerta(Long idPuerta) {
        IdPuerta = idPuerta;
    }

    public String getEmailInquilino() {
        return emailInquilino;
    }

    public void setEmailInquilino(String emailInquilino) {
        this.emailInquilino = emailInquilino;
    }

    public Long getIdPropietario() {
        return IdPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        IdPropietario = idPropietario;
    }

    public Long getIdAdministrador() {
        return IdAdministrador;
    }

    public void setIdAdministrador(Long idAdministrador) {
        IdAdministrador = idAdministrador;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((IdReserva == null) ? 0 : IdReserva.hashCode());
        result = prime * result + ((IdPuerta == null) ? 0 : IdPuerta.hashCode());
        result = prime * result + ((emailInquilino == null) ? 0 : emailInquilino.hashCode());
        result = prime * result + ((IdPropietario == null) ? 0 : IdPropietario.hashCode());
        result = prime * result + ((IdAdministrador == null) ? 0 : IdAdministrador.hashCode());
        result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
        result = prime * result + ((salida == null) ? 0 : salida.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reserva other = (Reserva) obj;
        if (IdReserva == null) {
            if (other.IdReserva != null)
                return false;
        } else if (!IdReserva.equals(other.IdReserva))
            return false;
        if (IdPuerta == null) {
            if (other.IdPuerta != null)
                return false;
        } else if (!IdPuerta.equals(other.IdPuerta))
            return false;
        if (emailInquilino == null) {
            if (other.emailInquilino != null)
                return false;
        } else if (!emailInquilino.equals(other.emailInquilino))
            return false;
        if (IdPropietario == null) {
            if (other.IdPropietario != null)
                return false;
        } else if (!IdPropietario.equals(other.IdPropietario))
            return false;
        if (IdAdministrador == null) {
            if (other.IdAdministrador != null)
                return false;
        } else if (!IdAdministrador.equals(other.IdAdministrador))
            return false;
        if (entrada == null) {
            if (other.entrada != null)
                return false;
        } else if (!entrada.equals(other.entrada))
            return false;
        if (salida == null) {
            if (other.salida != null)
                return false;
        } else if (!salida.equals(other.salida))
            return false;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Reserva [emailInquilino=" + emailInquilino + "]";
    }

    
    
}