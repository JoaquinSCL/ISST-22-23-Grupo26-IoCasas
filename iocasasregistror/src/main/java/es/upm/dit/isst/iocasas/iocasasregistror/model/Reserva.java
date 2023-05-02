package es.upm.dit.isst.iocasasapi.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reserva{

    @Id
    private Long idReserva;
    private Long idPuerta;
    private String emailInquilino;
    private String emailPropietario;
    private String emailAdministrador;
    private Date entrada;
    private Date salida;

    public Reserva() {
    }

    public Reserva(Long idReserva, Long idPuerta, String emailInquilino, String emailPropietario,
            String emailAdministrador, Date entrada, Date salida) {
        this.idReserva = idReserva;
        this.idPuerta = idPuerta;
        this.emailInquilino = emailInquilino;
        this.emailPropietario = emailPropietario;
        this.emailAdministrador = emailAdministrador;
        this.entrada = entrada;
        this.salida = salida;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Long getIdPuerta() {
        return idPuerta;
    }

    public void setIdPuerta(Long idPuerta) {
        this.idPuerta = idPuerta;
    }

    public String getEmailInquilino() {
        return emailInquilino;
    }

    public void setEmailInquilino(String emailInquilino) {
        this.emailInquilino = emailInquilino;
    }

    public String getEmailPropietario() {
        return emailPropietario;
    }

    public void setEmailPropietario(String emailPropietario) {
        this.emailPropietario = emailPropietario;
    }

    public String getEmailAdministrador() {
        return emailAdministrador;
    }

    public void setEmailAdministrador(String emailAdministrador) {
        this.emailAdministrador = emailAdministrador;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idReserva == null) ? 0 : idReserva.hashCode());
        result = prime * result + ((idPuerta == null) ? 0 : idPuerta.hashCode());
        result = prime * result + ((emailInquilino == null) ? 0 : emailInquilino.hashCode());
        result = prime * result + ((emailPropietario == null) ? 0 : emailPropietario.hashCode());
        result = prime * result + ((emailAdministrador == null) ? 0 : emailAdministrador.hashCode());
        result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
        result = prime * result + ((salida == null) ? 0 : salida.hashCode());
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
        if (idReserva == null) {
            if (other.idReserva != null)
                return false;
        } else if (!idReserva.equals(other.idReserva))
            return false;
        if (idPuerta == null) {
            if (other.idPuerta != null)
                return false;
        } else if (!idPuerta.equals(other.idPuerta))
            return false;
        if (emailInquilino == null) {
            if (other.emailInquilino != null)
                return false;
        } else if (!emailInquilino.equals(other.emailInquilino))
            return false;
        if (emailPropietario == null) {
            if (other.emailPropietario != null)
                return false;
        } else if (!emailPropietario.equals(other.emailPropietario))
            return false;
        if (emailAdministrador == null) {
            if (other.emailAdministrador != null)
                return false;
        } else if (!emailAdministrador.equals(other.emailAdministrador))
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
        return true;
    }
    
}
