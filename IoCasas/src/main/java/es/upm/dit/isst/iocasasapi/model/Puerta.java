package es.upm.dit.isst.iocasasapi.model;

import javax.persistence.Id;

public class Puerta {
    @Id
    private long IdPuerta;
    private long IdPropietario;
    private long IdAdministrador;
    private long IdServicios;
    private long accescode;
    private String ubicacion;
    
    public Puerta() {
    }

    public Puerta(long idPuerta, long idPropietario, long idAdministrador, long idServicios, long accescode,
            String ubicacion) {
        IdPuerta = idPuerta;
        IdPropietario = idPropietario;
        IdAdministrador = idAdministrador;
        IdServicios = idServicios;
        this.accescode = accescode;
        this.ubicacion = ubicacion;
    }

    public long getIdPuerta() {
        return IdPuerta;
    }
    public void setIdPuerta(long idPuerta) {
        IdPuerta = idPuerta;
    }
    public long getIdPropietario() {
        return IdPropietario;
    }
    public void setIdPropietario(long idPropietario) {
        IdPropietario = idPropietario;
    }
    public long getIdAdministrador() {
        return IdAdministrador;
    }
    public void setIdAdministrador(long idAdministrador) {
        IdAdministrador = idAdministrador;
    }
    public long getIdServicios() {
        return IdServicios;
    }
    public void setIdServicios(long idServicios) {
        IdServicios = idServicios;
    }
    public long getAccescode() {
        return accescode;
    }
    public void setAccescode(long accescode) {
        this.accescode = accescode;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    @Override
    public String toString() {
        return "Puerta [ubicacion=" + ubicacion + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (IdPuerta ^ (IdPuerta >>> 32));
        result = prime * result + (int) (IdPropietario ^ (IdPropietario >>> 32));
        result = prime * result + (int) (IdAdministrador ^ (IdAdministrador >>> 32));
        result = prime * result + (int) (IdServicios ^ (IdServicios >>> 32));
        result = prime * result + (int) (accescode ^ (accescode >>> 32));
        result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
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
        Puerta other = (Puerta) obj;
        if (IdPuerta != other.IdPuerta)
            return false;
        if (IdPropietario != other.IdPropietario)
            return false;
        if (IdAdministrador != other.IdAdministrador)
            return false;
        if (IdServicios != other.IdServicios)
            return false;
        if (accescode != other.accescode)
            return false;
        if (ubicacion == null) {
            if (other.ubicacion != null)
                return false;
        } else if (!ubicacion.equals(other.ubicacion))
            return false;
        return true;
    }

    
    
}
