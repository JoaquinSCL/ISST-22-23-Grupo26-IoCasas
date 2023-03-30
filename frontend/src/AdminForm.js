import { Link } from "react-router-dom";
import { useState } from "react";
function AdminForm(props) {
    const [adminusername, setAdminusername] = useState(props.adminusername);
    const handleUsernameChange = (event) => {
        setAdminusername(event.target.value);
      };
    return(
        <div>
        <label htmlFor="username"> Nombre de usuario del administrador:</label>
            <input
             type="text"
             id="username"
             name="username"
             value={adminusername}
             onChange={handleUsernameChange}
            />
            <button>Enviar</button>
            <Link to="/"><button id="volver">Volver</button></Link>
        </div>
    );
}

export default AdminForm
