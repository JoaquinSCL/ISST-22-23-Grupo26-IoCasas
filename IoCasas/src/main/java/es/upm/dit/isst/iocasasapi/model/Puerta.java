    package es.upm.dit.isst.iocasasapi.model;

    import javax.persistence.Entity;
    import javax.persistence.Id;
    @Entity
    public class Puerta {
        @Id
            private Long idPuerta;
            private String emailPropietario;
            private String emailAdministrador;
            private Long key;
            private String ubicacion;
        public Puerta() {
        }
        public Puerta(Long idPuerta, String emailPropietario, String emailAdministrador, Long key, String ubicacion) {
            this.idPuerta = idPuerta;
            this.emailPropietario = emailPropietario;
            this.emailAdministrador = emailAdministrador;
            this.key = key;
            this.ubicacion = ubicacion;
        }
        public Long getIdPuerta() {
            return idPuerta;
        }
        public void setIdPuerta(Long idPuerta) {
            this.idPuerta = idPuerta;
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
        public Long getKey() {
            return key;
        }
        public void setKey(Long key) {
            this.key = key;
        }
        public String getUbicacion() {
            return ubicacion;
        }
        public void setUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((idPuerta == null) ? 0 : idPuerta.hashCode());
            result = prime * result + ((emailPropietario == null) ? 0 : emailPropietario.hashCode());
            result = prime * result + ((emailAdministrador == null) ? 0 : emailAdministrador.hashCode());
            result = prime * result + ((key == null) ? 0 : key.hashCode());
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
            if (idPuerta == null) {
                if (other.idPuerta != null)
                    return false;
            } else if (!idPuerta.equals(other.idPuerta))
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
            if (key == null) {
                if (other.key != null)
                    return false;
            } else if (!key.equals(other.key))
                return false;
            if (ubicacion == null) {
                if (other.ubicacion != null)
                    return false;
            } else if (!ubicacion.equals(other.ubicacion))
                return false;
            return true;
        }

        
    }
