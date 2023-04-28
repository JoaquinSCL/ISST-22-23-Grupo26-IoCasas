import { Link } from "react-router-dom";
import { useState } from "react";
import './App.css';

function AdminForm(props) {
    const [adminusername, setAdminusername] = useState(props.adminusername);
    const handleUsernameChange = (event) => {
        setAdminusername(event.target.value);
      };
    return(
        <div class='formDiv'>
        <label htmlFor="username"> Nombre de usuario del administrador:</label>
            <input class='inputs'
             type="text"
             id="username"
             name="username"
             value={adminusername}
             onChange={handleUsernameChange}
            />
            <button class='botonLog'>Enviar</button>
            <Link to="/"><button class='botonLog' id="volver">Volver</button></Link>
        </div>
    );
}

export default AdminForm
