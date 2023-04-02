package es.upm.dit.isst.iocasasapi.model;
import java.util.Date;
import java.lang.String;

import javax.persistence.Id;
//import javax.validation.constraints.NotEmpty;

public class Reserva{

    @Id
    private int IdReserva;
    private int IdPuerta;
    private int IdInquilino;
    private int IdPropietario;
    private int IdAdministrador;
//    @NotEmpty
    private Date entrada;
//    @NotEmpty
    private Date salida;
//    @NotEmpty
    private String key;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + IdReserva;
        result = prime * result + IdPuerta;
        result = prime * result + IdInquilino;
        result = prime * result + IdPropietario;
        result = prime * result + IdAdministrador;
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
        if (IdReserva != other.IdReserva)
            return false;
        if (IdPuerta != other.IdPuerta)
            return false;
        if (IdInquilino != other.IdInquilino)
            return false;
        if (IdPropietario != other.IdPropietario)
            return false;
        if (IdAdministrador != other.IdAdministrador)
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


    public int getIdReserva() {
        return IdReserva;
    }


    public void setIdReserva(int idReserva) {
        IdReserva = idReserva;
    }


    public int getIdPuerta() {
        return IdPuerta;
    }


    public void setIdPuerta(int idPuerta) {
        IdPuerta = idPuerta;
    }


    public int getIdInquilino() {
        return IdInquilino;
    }


    public void setIdInquilino(int idInquilino) {
        IdInquilino = idInquilino;
    }


    public int getIdPropietario() {
        return IdPropietario;
    }


    public void setIdPropietario(int idPropietario) {
        IdPropietario = idPropietario;
    }


    public int getIdAdministrador() {
        return IdAdministrador;
    }


    public void setIdAdministrador(int idAdministrador) {
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


    public String getKey() {
        return key;
    }


    public void setKey(String key) {
        this.key = key;
    }


    public Reserva(int idReserva, int idPuerta, int idInquilino, int idPropietario, int idAdministrador, Date entrada,
            Date salida, String key) {
        IdReserva = idReserva;
        IdPuerta = idPuerta;
        IdInquilino = idInquilino;
        IdPropietario = idPropietario;
        IdAdministrador = idAdministrador;
        this.entrada = entrada;
        this.salida = salida;
        this.key = key;
    }


    public Reserva(){}


    
}